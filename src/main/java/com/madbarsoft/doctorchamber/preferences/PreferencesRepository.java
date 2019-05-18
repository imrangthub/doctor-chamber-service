package com.madbarsoft.doctorchamber.preferences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.pagination.DataTableRequest;
import com.madbarsoft.doctorchamber.pagination.DataTableResults;
import com.madbarsoft.doctorchamber.pagination.PaginationCriteria;
import com.madbarsoft.doctorchamber.userPreferences.UserPreferencesEntity;
import com.madbarsoft.doctorchamber.userPreferences.UserPreferencesService;
import com.madbarsoft.doctorchamber.util.CommonUtils;
import com.madbarsoft.doctorchamber.util.Def;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class PreferencesRepository extends BaseRepository {

	@Autowired
	private UserPreferencesService userPreferencesService;

	private UserPreferencesEntity isExistUserPref(PreferencesEntity preferencesEntity,
			List<UserPreferencesEntity> userPrefList) {
		if (userPrefList != null) {
			return userPrefList.stream().filter(userPreference -> userPreference.getUserPreferencesKey()
					.equals(preferencesEntity.getPreferencesKey())).findAny().orElse(null);
		}

		return null;
	}

	public Response listByDoctorNo(String userNoStr) {

		JSONObject json = new JSONObject(userNoStr);
		Long userNo = Def.getLong(json, "userNo");

		List<UserPreferencesEntity> userPreferencesList = null;
		List<PreferencesEntity> prescriptionPreferencesList = null;
		List<PreferencesEntity> finalPreferencesList = new ArrayList<PreferencesEntity>();
		Response userPrefResponse = userPreferencesService.listByDoctorNo(userNo);

		if (userPrefResponse.isSuccess() && userPrefResponse.getItems() != null) {
			userPreferencesList = getListFromObject(userPrefResponse.getItems(), UserPreferencesEntity.class);
		}
		Response prefResponse = baseList(criteriaQuery(new PreferencesEntity()));
		if (prefResponse.isSuccess() && prefResponse.getItems() != null) {
			prescriptionPreferencesList = getListFromObject(prefResponse.getItems(),
					PreferencesEntity.class);
		}

		for (PreferencesEntity preferences : prescriptionPreferencesList) {

			UserPreferencesEntity userPreference = isExistUserPref(preferences, userPreferencesList);
			if (userPreference != null) {
				preferences.setPreferencesType(userPreference.getUserPreferencesType());
				preferences.setPreferencesValue(userPreference.getUserPreferencesValue());
				preferences.setPreferencesSerial(userPreference.getPreferencesSerial());
				preferences.setPreferencesShowInReport(userPreference.getPreferencesShowInReport());
				if(userPreference.getTitle() == null) {
					userPreference.setTitle(preferences.getTitle());
				}
				preferences.setTitle(userPreference.getTitle());
			}

			finalPreferencesList.add(preferences);
		}

		Response finalResponse = new Response();
		finalResponse.setItems(finalPreferencesList);

		return getSuccessResponse("user preferecne data ", finalResponse);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {

		List gridList = new ArrayList<>();
		Response response = new Response();
		PreferencesEntity preferencesEntity = new PreferencesEntity();
		DataTableRequest dataTableInRQ = new DataTableRequest(request);
		Long totalRowCount = totalCount(preferencesEntity);
		DataTableResults<PreferencesEntity> dataTableResults = null;

		if (dataTableInRQ.isGlobalSearch()) {
			String searchCriteria = CommonUtils.PERCENTAGE_SIGN + dataTableInRQ.getSearch()
					+ CommonUtils.PERCENTAGE_SIGN;
		}
		response = baseList(typedQuery(preferencesEntity, dataTableInRQ));
		if (response.isSuccess()) {
			if (response.getItems() != null) {
				gridList = response.getItems();
			}

			dataTableResults = dataTableResults(dataTableInRQ, gridList, gridList, totalRowCount);
		}
		response.setItems(null);
		response.setObj(dataTableResults);
		return response;
	}

	public PreferencesEntity findById(Long id) {
		PreferencesEntity obj = new PreferencesEntity();
		obj.setId(id);
		Response response = baseFindById(criteriaQuery(obj));
		if (response.isSuccess()) {
			return (PreferencesEntity) response.getObj();
		}
		return null;
	}

	public Response save(PreferencesEntity reqObj) {
		return baseOnlySave(reqObj);
	}

	public Response update(PreferencesEntity reqObj) {
		PreferencesEntity obj = findById(reqObj.getId());
		if (obj != null) {
			obj.setTitle(reqObj.getTitle());
			obj.setPreferencesValue(reqObj.getPreferencesValue());
			obj.setPreferencesKey(reqObj.getPreferencesKey());
			obj.setDescription(reqObj.getDescription());
			return baseUpdate(obj);
		}
		return getErrorResponse("Record not Found !!");

	}

	public Response detele(Long id) {
		PreferencesEntity obj = findById(id);
		return baseDelete(obj);
	}

	public Response remove(Long id) {
		PreferencesEntity obj = findById(id);
		obj.setActiveStatus(3);
		return baseRemove(obj);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(PreferencesEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(PreferencesEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;

		List<Predicate> p = new ArrayList<Predicate>();
		p = criteriaCodtion(filter, null, null);

		if (!CollectionUtils.isEmpty(p)) {
			Predicate[] pArray = p.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}
		return criteria;
	}

	@SuppressWarnings({ "unchecked" })
	private List<Predicate> criteriaCodtion(PreferencesEntity filter, CriteriaBuilder builder,
			Root<PreferencesEntity> root) {

		if (builder == null) {
			builder = super.builder;
		}
		if (root == null) {
			root = super.root;
		}

		List<Predicate> p = new ArrayList<Predicate>();

		if (filter != null) {
			if (filter.getActiveStatus() > 0) {
				Predicate condition = builder.equal(root.get("activeStatus"), filter.getActiveStatus());
				p.add(condition);
			}
			if (filter.getId() != null && filter.getId() > 0) {
				Predicate condition = builder.equal(root.get("id"), filter.getId());
				p.add(condition);
			}
			if (filter.getTitle() != null && !filter.getTitle().isEmpty()) {
				Predicate condition = builder.like(root.get("title"), filter.getTitle());
				p.add(condition);
			}

		}

		return p;
	}

	@SuppressWarnings({ "rawtypes" })
	private TypedQuery typedQuery(PreferencesEntity filter, DataTableRequest dataTableInRQ) {
		init();
		List<Predicate> pArrayJoin = new ArrayList<Predicate>();
		List<Predicate> pconJunction = criteriaCodtion(filter, null, null);
		List<Predicate> pdisJunction = filterDisjunction(dataTableInRQ);
		Predicate predicateAND = null;
		Predicate predicateOR = null;

		if (!CollectionUtils.isEmpty(pconJunction)) {
			Predicate[] pArray = pconJunction.toArray(new Predicate[] {});
			predicateAND = builder.and(pArray);
		}
		if (!CollectionUtils.isEmpty(pdisJunction)) {
			Predicate[] pArray = pdisJunction.toArray(new Predicate[] {});
			predicateOR = builder.or(pArray);
		}
		if (predicateAND != null) {
			pArrayJoin.add(predicateAND);

		}
		if (predicateOR != null) {
			pArrayJoin.add(predicateOR);

		}
		criteria.where(pArrayJoin.toArray(new Predicate[0]));
		return baseTypedQuery(criteria, dataTableInRQ);
	}

	private Long totalCount(PreferencesEntity filter) {
		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<PreferencesEntity> root = from(PreferencesEntity.class, criteriaQuery);
		return totalCount(builder, criteriaQuery, root, criteriaCodtion(filter, builder, root), null);

	}

	private List<Predicate> filterDisjunction(DataTableRequest dataTableInRQ) {
		PaginationCriteria paginationCriteria = dataTableInRQ.getPaginationRequest();
		paginationCriteria.getFilterBy().getMapOfFilters();
		List<Predicate> p = new ArrayList<Predicate>();
		if (!paginationCriteria.isFilterByEmpty()) {
			Iterator<Entry<String, String>> fbit = paginationCriteria.getFilterBy().getMapOfFilters().entrySet()
					.iterator();

			while (fbit.hasNext()) {
				Map.Entry<String, String> pair = fbit.next();
				p.add(builder.like(root.get(pair.getKey()),
						CommonUtils.PERCENTAGE_SIGN + pair.getValue() + CommonUtils.PERCENTAGE_SIGN));
			}

		}
		return p;
	}

	private void init() {
		initEntityManagerBuilderCriteriaQueryRoot(PreferencesEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}

}

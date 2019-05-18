package com.madbarsoft.doctorchamber.userPreferences;

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
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.pagination.DataTableRequest;
import com.madbarsoft.doctorchamber.pagination.DataTableResults;
import com.madbarsoft.doctorchamber.pagination.PaginationCriteria;
import com.madbarsoft.doctorchamber.util.CommonUtils;
import com.madbarsoft.doctorchamber.util.Def;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class UserPreferencesRepository extends BaseRepository {

	public Response listByDoctorNo(Long userNo) {
		UserPreferencesEntity obj = new UserPreferencesEntity();
		obj.setUserNo(userNo);
		//obj.setUserPreferencesValue("1");
		List<UserPreferencesEntity> userPreferencesList = null;
		Response userPreference = baseList(criteriaQuery(obj));
		if (userPreference.isSuccess() && userPreference.getItems() != null) {
			userPreferencesList = getListFromObject(userPreference.getItems(), UserPreferencesEntity.class);
		}
		//Map<String, String> preferenceMap = new HashMap<String, String>();
		Response finalmap = new Response();
		if (userPreferencesList != null) {
//			preferenceMap = userPreferencesList.stream().collect(Collectors.toMap(UserPreferencesEntity::getUserPreferencesKey, UserPreferencesEntity::getUserPreferencesValue));
			finalmap.setItems(userPreferencesList);
		}

//		finalmap.setObj(preferenceMap);		

		return getSuccessResponse("preference data", finalmap);
	}
	
	
	public UserPreferencesEntity getPreferenceByDoctorNoAndKey(Long userNo,String preferencekey) {
		UserPreferencesEntity obj = new UserPreferencesEntity();
		obj.setUserNo(userNo);
		obj.setUserPreferencesKey(preferencekey);

		Response userPreference = baseSingleObject(criteriaQuery(obj));
		if (userPreference.isSuccess() && userPreference.getObj() != null) {
			obj = getValueFromObject(userPreference.getObj(), UserPreferencesEntity.class);
		    return obj;
		}
		return null;
	}
	
	public List<UserPreferencesEntity> getPreferenceByDoctorNo(Long userNo) {
		List <UserPreferencesEntity> userPreferenceList = new ArrayList<UserPreferencesEntity>();
		UserPreferencesEntity obj = new UserPreferencesEntity();
		obj.setUserNo(userNo);

		Response userPreference = baseList(criteriaQuery(obj));
		if (userPreference.isSuccess() && userPreference.getItems() != null) {
			userPreferenceList = getListFromObject(userPreference.getItems(), UserPreferencesEntity.class);
		    return userPreferenceList;
		}

		return null;
	}
	public UserPreferencesEntity getPreferenceByKey(List<UserPreferencesEntity> userPreferenceList,String preferencekey) {
		return userPreferenceList.stream().filter(preference -> preference.getUserPreferencesKey().equals(preferencekey)).findAny().orElse(null);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {

		List gridList = new ArrayList<>();
		Response response = new Response();
		UserPreferencesEntity userPreferencesEntity = new UserPreferencesEntity();
		DataTableRequest dataTableInRQ = new DataTableRequest(request);
		Long totalRowCount = totalCount(userPreferencesEntity);
		DataTableResults<UserPreferencesEntity> dataTableResults = null;

		if (dataTableInRQ.isGlobalSearch()) {
			String searchCriteria = CommonUtils.PERCENTAGE_SIGN + dataTableInRQ.getSearch()
					+ CommonUtils.PERCENTAGE_SIGN;
		}
		response = baseList(typedQuery(userPreferencesEntity, dataTableInRQ));
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

	public UserPreferencesEntity findById(Long id) {
		UserPreferencesEntity obj = new UserPreferencesEntity();
		obj.setId(id);
		Response response = baseFindById(criteriaQuery(obj));
		if (response.isSuccess()) {
			return (UserPreferencesEntity) response.getObj();
		}
		return null;
	}

	public UserPreferencesEntity findByUserNoAndPreferencesType(Long userNo, String preferencesKey) {
		UserPreferencesEntity obj = new UserPreferencesEntity();
		obj.setUserNo(userNo);
		obj.setUserPreferencesKey(preferencesKey);
		Response response = baseFindById(criteriaQuery(obj));
		if (response.isSuccess() && response.getObj() != null) {
			return (UserPreferencesEntity) response.getObj();
		}
		return null;
	}

	public Response save(String userPref) {

		JSONObject json = new JSONObject(userPref);
		String userPrefArrayStr = Def.getArrayString(json, "userPrefList");

		List<UserPreferencesEntity> userPrefList = objectMapperReadArrayValue(userPrefArrayStr,
				UserPreferencesEntity.class);

		for (UserPreferencesEntity obj : userPrefList) {
			UserPreferencesEntity checkObj = findByUserNoAndPreferencesType(obj.getUserNo(),
					obj.getUserPreferencesKey());
			if (checkObj != null) {
				obj.setId(checkObj.getId());
				baseUpdate(obj);
			} else {
				baseOnlySave(obj);
			}
		}

		return getSuccessResponse("Update Successfully");
	}

	public Response update(UserPreferencesEntity reqObj) {
		UserPreferencesEntity obj = findById(reqObj.getId());
		if (obj != null) {
			obj.setUserPreferencesValue(reqObj.getUserPreferencesValue());
			obj.setUserPreferencesKey(reqObj.getUserPreferencesKey());
			obj.setUserNo(reqObj.getUserNo());
			return baseUpdate(obj);
		}
		return getErrorResponse("Record not Found !!");

	}

	public Response detele(Long id) {
		UserPreferencesEntity obj = findById(id);
		return baseDelete(obj);
	}

	public Response remove(Long id) {
		UserPreferencesEntity obj = findById(id);
		obj.setActiveStatus(3);
		return baseRemove(obj);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(UserPreferencesEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(UserPreferencesEntity.class);
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
	private List<Predicate> criteriaCodtion(UserPreferencesEntity filter, CriteriaBuilder builder,
			Root<UserPreferencesEntity> root) {

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
			if (filter.getUserPreferencesValue() != null && !filter.getUserPreferencesValue().isEmpty()) {
				Predicate condition = builder.equal(root.get("userPreferencesValue"), filter.getUserPreferencesValue());
				p.add(condition);
			}
			if (filter.getUserPreferencesType() != null && !filter.getUserPreferencesType().isEmpty()) {
				Predicate condition = builder.equal(root.get("userPreferencesType"), filter.getUserPreferencesType());
				p.add(condition);
			}
			if (filter.getUserPreferencesKey() != null && !filter.getUserPreferencesKey().isEmpty()) {
				Predicate condition = builder.equal(root.get("userPreferencesKey"), filter.getUserPreferencesKey());
				p.add(condition);
			}
			if (filter.getUserNo() != null && filter.getUserNo() > 0) {
				Predicate condition = builder.equal(root.get("userNo"), filter.getUserNo());
				p.add(condition);
			}

		}

		return p;
	}

	@SuppressWarnings({ "rawtypes" })
	private TypedQuery typedQuery(UserPreferencesEntity filter, DataTableRequest dataTableInRQ) {
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

	private Long totalCount(UserPreferencesEntity filter) {
		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<UserPreferencesEntity> root = from(UserPreferencesEntity.class, criteriaQuery);
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
		initEntityManagerBuilderCriteriaQueryRoot(UserPreferencesEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}

}

package com.madbarsoft.doctorchamber.userDataPreferences;

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

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.pagination.DataTableRequest;
import com.madbarsoft.doctorchamber.pagination.DataTableResults;
import com.madbarsoft.doctorchamber.pagination.PaginationCriteria;
import com.madbarsoft.doctorchamber.util.CommonUtils;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class UserDataPreferencesRepository extends BaseRepository {

	public Response listByDoctorNo(Long userNo) {
		UserDataPreferencesEntity obj = new UserDataPreferencesEntity();
		obj.setUserNo(userNo);
		List<UserDataPreferencesEntity> userPreferencesList = null;
		Response userPreference = baseList(criteriaQuery(obj));
		if (userPreference.isSuccess() && userPreference.getItems() != null) {

			userPreferencesList = getListFromObject(userPreference.getItems(), UserDataPreferencesEntity.class);
		}
		Response finalmap = new Response();
		if (userPreferencesList != null) {
			finalmap.setItems(userPreferencesList);
		}

		return getSuccessResponse("user preference data", finalmap);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {

		List gridList = new ArrayList<>();
		Response response = new Response();
		UserDataPreferencesEntity userPreferencesEntity = new UserDataPreferencesEntity();
		DataTableRequest dataTableInRQ = new DataTableRequest(request);
		Long totalRowCount = totalCount(userPreferencesEntity);
		DataTableResults<UserDataPreferencesEntity> dataTableResults = null;

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

	public UserDataPreferencesEntity findById(Long id) {
		UserDataPreferencesEntity obj = new UserDataPreferencesEntity();
		obj.setId(id);
		Response response = baseFindById(criteriaQuery(obj));
		if (response.isSuccess()) {
			return (UserDataPreferencesEntity) response.getObj();
		}
		return null;
	}

	public UserDataPreferencesEntity findByUserNoAndPrefDataType(Long userNo, Long userPrefDataType) {
		UserDataPreferencesEntity obj = new UserDataPreferencesEntity();
		obj.setUserNo(userNo);
		Response response = baseFindById(criteriaQuery(obj));
		if (response.isSuccess() && response.getObj() != null) {
			return (UserDataPreferencesEntity) response.getObj();
		}
		return null;
	}

	public Response save(UserDataPreferencesEntity obj) {
		return baseOnlySave(obj);
	}

	public Response update(UserDataPreferencesEntity reqObj) {
		UserDataPreferencesEntity obj = findById(reqObj.getId());
		if (obj != null) {
			obj.setUserPrefDataNo(reqObj.getUserPrefDataNo());
			obj.setUserPrefDataValue(reqObj.getUserPrefDataValue());
			obj.setUserPrefDataType(reqObj.getUserPrefDataType());
			obj.setUserPrefDataBrandName(reqObj.getUserPrefDataBrandName());
			obj.setUserPrefDataForm(reqObj.getUserPrefDataForm());
			obj.setUserPrefDataStrength(reqObj.getUserPrefDataStrength());
			obj.setUserPrefDataDosage(reqObj.getUserPrefDataDosage());
			obj.setUserPrefDataDuration(reqObj.getUserPrefDataDuration());
			obj.setUserPrefDataRelationWithMeal(reqObj.getUserPrefDataRelationWithMeal());
			obj.setUserNo(reqObj.getUserNo());
			return baseUpdate(obj);
		}
		return getErrorResponse("Record not Found !!");

	}

	public Response detele(Long id) {
		UserDataPreferencesEntity obj = findById(id);
		return baseDelete(obj);
	}

	public Response remove(Long id) {
		UserDataPreferencesEntity obj = findById(id);
		obj.setActiveStatus(3);
		return baseRemove(obj);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(UserDataPreferencesEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(UserDataPreferencesEntity.class);
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
	private List<Predicate> criteriaCodtion(UserDataPreferencesEntity filter, CriteriaBuilder builder,
			Root<UserDataPreferencesEntity> root) {

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
			if (filter.getUserPrefDataNo() != null && filter.getUserPrefDataNo() > 0) {
				Predicate condition = builder.equal(root.get("userPrefDataNo"), filter.getUserPrefDataNo());
				p.add(condition);
			}
			if (filter.getUserPrefDataValue() != null && !filter.getUserPrefDataValue().isEmpty()) {
				Predicate condition = builder.equal(root.get("userPrefDataValue"), filter.getUserPrefDataValue());
				p.add(condition);
			}

			if (filter.getUserPrefDataForm() != null && !filter.getUserPrefDataForm().isEmpty()) {
				Predicate condition = builder.equal(root.get("userPrefDataForm"), filter.getUserPrefDataForm());
				p.add(condition);
			}
			if (filter.getUserPrefDataStrength() != null && !filter.getUserPrefDataStrength().isEmpty()) {
				Predicate condition = builder.equal(root.get("userPrefDataStrength"), filter.getUserPrefDataStrength());
				p.add(condition);
			}
			if (filter.getUserPrefDataDosage() != null && !filter.getUserPrefDataDosage().isEmpty()) {
				Predicate condition = builder.equal(root.get("userPrefDataDosage"), filter.getUserPrefDataDosage());
				p.add(condition);
			}
			if (filter.getUserPrefDataDuration() != null && !filter.getUserPrefDataDuration().isEmpty()) {
				Predicate condition = builder.equal(root.get("userPrefDataDuration"), filter.getUserPrefDataDuration());
				p.add(condition);
			}
			if (filter.getUserPrefDataRelationWithMeal() != null
					&& !filter.getUserPrefDataRelationWithMeal().isEmpty()) {
				Predicate condition = builder.equal(root.get("userPrefDataRelationWithMeal"),
						filter.getUserPrefDataRelationWithMeal());
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
	private TypedQuery typedQuery(UserDataPreferencesEntity filter, DataTableRequest dataTableInRQ) {
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

	private Long totalCount(UserDataPreferencesEntity filter) {
		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<UserDataPreferencesEntity> root = from(UserDataPreferencesEntity.class, criteriaQuery);
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
		initEntityManagerBuilderCriteriaQueryRoot(UserDataPreferencesEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}
}

package com.madbarsoft.doctorchamber.autoComplete;

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
public class AutoCompleteRepository extends BaseRepository {

	public Response listByDoctorNo(AutoCompleteEntity obj) {
		return baseList(criteriaQuery(obj));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {

		List gridList = new ArrayList<>();
		Response response = new Response();
		AutoCompleteEntity autoCompleteEntity = new AutoCompleteEntity();
		Long doctorNo = Long.parseLong(request.getParameter("doctorNo"));
		if(doctorNo != null)autoCompleteEntity.setDoctorNo(doctorNo);
		DataTableRequest dataTableInRQ = new DataTableRequest(request);
		Long totalRowCount = totalCount(autoCompleteEntity);
		DataTableResults<AutoCompleteEntity> dataTableResults = null;

		if (dataTableInRQ.isGlobalSearch()) {
			String searchCriteria = CommonUtils.PERCENTAGE_SIGN + dataTableInRQ.getSearch()
					+ CommonUtils.PERCENTAGE_SIGN;
		}
		response = baseList(typedQuery(autoCompleteEntity, dataTableInRQ));
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

	public AutoCompleteEntity findById(Long id) {
		AutoCompleteEntity obj = new AutoCompleteEntity();
		obj.setId(id);
		Response response = baseFindById(criteriaQuery(obj));
		if (response.isSuccess()) {
			return (AutoCompleteEntity) response.getObj();
		}
		return null;
	}

	public Response save(AutoCompleteEntity reqObj) {
		return baseOnlySave(reqObj);
	}

	public Response update(AutoCompleteEntity reqObj) {
		AutoCompleteEntity obj = findById(reqObj.getId());
		if (obj != null) {
			obj.setAutoKey(reqObj.getAutoKey());
			obj.setAutoComType(reqObj.getAutoComType());
			obj.setAutoComValEng(reqObj.getAutoComValEng());
			obj.setAutoComValLocal(reqObj.getAutoComValLocal());
			obj.setDoctorNo(reqObj.getDoctorNo());
			return baseUpdate(obj);
		}
		return getErrorResponse("Record not Found !!");

	}

	public Response detele(Long id) {
		AutoCompleteEntity obj = findById(id);
		return baseDelete(obj);
	}

	public Response remove(Long id) {
		AutoCompleteEntity obj = findById(id);
		obj.setActiveStatus(3);
		return baseRemove(obj);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(AutoCompleteEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(AutoCompleteEntity.class);
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
	private List<Predicate> criteriaCodtion(AutoCompleteEntity filter, CriteriaBuilder builder,
			Root<AutoCompleteEntity> root) {

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

			if (filter.getAutoKey() != null && !filter.getAutoKey().isEmpty()) {
				Predicate condition = builder.like(root.get("autoKey"), filter.getAutoKey());
				p.add(condition);
			}
			if (filter.getAutoComValEng() != null && !filter.getAutoComValEng().isEmpty()) {
				Predicate condition = builder.like(root.get("autoComValEng"), filter.getAutoComValEng());
				p.add(condition);
			}

			if (filter.getAutoComValLocal() != null && !filter.getAutoComValLocal().isEmpty()) {
				Predicate condition = builder.like(root.get("autoComValLocal"), filter.getAutoComValLocal());
				p.add(condition);
			}

			if (filter.getDoctorNo() != null && filter.getDoctorNo() > 0) {
				Predicate condition = builder.equal(root.get("doctorNo"), filter.getDoctorNo());
				p.add(condition);
			}
		}

		return p;
	}

	@SuppressWarnings({ "rawtypes" })
	private TypedQuery typedQuery(AutoCompleteEntity filter, DataTableRequest dataTableInRQ) {
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

	private Long totalCount(AutoCompleteEntity filter) {
		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<AutoCompleteEntity> root = from(AutoCompleteEntity.class, criteriaQuery);
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
		initEntityManagerBuilderCriteriaQueryRoot(AutoCompleteEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}

}

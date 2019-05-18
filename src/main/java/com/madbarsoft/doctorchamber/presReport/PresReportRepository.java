package com.madbarsoft.doctorchamber.presReport;

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
public class PresReportRepository extends BaseRepository {

	public Response listByDoctorNo(PresReportEntity obj) {
		return baseList(criteriaQuery(obj));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {

		List gridList = new ArrayList<>();
		Response response = new Response();
		PresReportEntity presTemplateEntity = new PresReportEntity();
		DataTableRequest dataTableInRQ = new DataTableRequest(request);
		Long totalRowCount = totalCount(presTemplateEntity);
		DataTableResults<PresReportEntity> dataTableResults = null;

		if (dataTableInRQ.isGlobalSearch()) {
			String searchCriteria = CommonUtils.PERCENTAGE_SIGN + dataTableInRQ.getSearch()+ CommonUtils.PERCENTAGE_SIGN;
		}
		response = baseList(typedQuery(presTemplateEntity, dataTableInRQ));
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

	public PresReportEntity findById(Long id) {
		PresReportEntity obj = new PresReportEntity();
		obj.setId(id);
		Response response = baseFindById(criteriaQuery(obj));
		if (response.isSuccess()) {
			return (PresReportEntity) response.getObj();
		}
		return null;
	}

	public Response save(PresReportEntity reqObj) {
		return baseOnlySave(reqObj);
	}

	public Response update(PresReportEntity reqObj) {
		PresReportEntity obj = findById(reqObj.getId());
		if (obj != null) {
			obj.setReportName(reqObj.getReportName());
			obj.setReportLink(reqObj.getReportLink());
			return baseUpdate(obj);
		}
		return getErrorResponse("Record not Found !!");

	}

	public Response detele(Long id) {
		PresReportEntity obj = findById(id);
		return baseDelete(obj);
	}

	public Response remove(Long id) {
		PresReportEntity obj = findById(id);
		obj.setActiveStatus(3);
		return baseRemove(obj);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(PresReportEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(PresReportEntity.class);
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
	private List<Predicate> criteriaCodtion(PresReportEntity filter, CriteriaBuilder builder,
			Root<PresReportEntity> root) {

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
			if (filter.getReportName() != null && !filter.getReportName().isEmpty()) {
				Predicate condition = builder.like(root.get("reportName"), filter.getReportName());
				p.add(condition);
			}
		}

		return p;
	}
	
	@SuppressWarnings({ "rawtypes" })
	private TypedQuery typedQuery(PresReportEntity filter, DataTableRequest dataTableInRQ) {
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
	
	private Long totalCount(PresReportEntity filter) {
		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<PresReportEntity> root = from(PresReportEntity.class, criteriaQuery);
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
		initEntityManagerBuilderCriteriaQueryRoot(PresReportEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}

}

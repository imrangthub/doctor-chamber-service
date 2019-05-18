package com.madbarsoft.doctorchamber.shortKey;

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
public class ShortKeyRepository extends BaseRepository {

	public Response listByDoctorNo(ShortKeyEntity obj) {
		return baseList(criteriaQuery(obj));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {

		List gridList = new ArrayList<>();
		Response response = new Response();
		ShortKeyEntity shortKeyEntity = new ShortKeyEntity();
		Long doctorNo = Long.parseLong(request.getParameter("doctorNo"));
		if(doctorNo != null)shortKeyEntity.setDoctorNo(doctorNo);
		DataTableRequest dataTableInRQ = new DataTableRequest(request);
		Long totalRowCount = totalCount(shortKeyEntity);
		DataTableResults<ShortKeyEntity> dataTableResults = null;

		if (dataTableInRQ.isGlobalSearch()) {
			String searchCriteria = CommonUtils.PERCENTAGE_SIGN + dataTableInRQ.getSearch()+ CommonUtils.PERCENTAGE_SIGN;
		}
		response = baseList(typedQuery(shortKeyEntity, dataTableInRQ));
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

	public ShortKeyEntity findById(Long id) {
		ShortKeyEntity obj = new ShortKeyEntity();
		obj.setId(id);
		Response response = baseFindById(criteriaQuery(obj));
		if (response.isSuccess()) {
			return (ShortKeyEntity) response.getObj();
		}
		return null;
	}

	public Response save(ShortKeyEntity reqObj) {
		return baseOnlySave(reqObj);
	}

	public Response update(ShortKeyEntity reqObj) {
		ShortKeyEntity obj = findById(reqObj.getId());
		if (obj != null) {
			obj.setShortCode(reqObj.getShortCode());
			obj.setShortValEng(reqObj.getShortValEng());
			obj.setShortValLocal(reqObj.getShortValLocal());
			obj.setDoctorNo(reqObj.getDoctorNo());
			return baseUpdate(obj);
		}
		return getErrorResponse("Record not Found !!");

	}

	public Response detele(Long id) {
		ShortKeyEntity obj = findById(id);
		return baseDelete(obj);
	}

	public Response remove(Long id) {
		ShortKeyEntity obj = findById(id);
		obj.setActiveStatus(3);
		return baseRemove(obj);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(ShortKeyEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(ShortKeyEntity.class);
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
	private List<Predicate> criteriaCodtion(ShortKeyEntity filter, CriteriaBuilder builder, Root<ShortKeyEntity> root) {

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

			if (filter.getShortCode() != null && !filter.getShortCode().isEmpty()) {
				Predicate condition = builder.like(root.get("shortCode"), filter.getShortCode());
				p.add(condition);
			}

			if (filter.getShortValEng() != null && !filter.getShortValEng().isEmpty()) {
				Predicate condition = builder.like(root.get("shortValEng"), filter.getShortValEng());
				p.add(condition);
			}

			if (filter.getShortValLocal() != null && !filter.getShortValLocal().isEmpty()) {
				Predicate condition = builder.like(root.get("shortValLocal"), filter.getShortValLocal());
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
	private TypedQuery typedQuery(ShortKeyEntity filter, DataTableRequest dataTableInRQ) {
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

	private Long totalCount(ShortKeyEntity filter) {
		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<ShortKeyEntity> root = from(ShortKeyEntity.class, criteriaQuery);
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
		initEntityManagerBuilderCriteriaQueryRoot(ShortKeyEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}

}

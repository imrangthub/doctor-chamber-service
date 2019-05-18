package com.madbarsoft.doctorchamber.finalization;

import java.util.ArrayList;
import java.util.List;

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
import com.madbarsoft.doctorchamber.history.HistoryEntity;
import com.madbarsoft.doctorchamber.pagination.DataTableRequest;
import com.madbarsoft.doctorchamber.pagination.DataTableResults;
import com.madbarsoft.doctorchamber.util.CommonUtils;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class FinalizationRepository extends BaseRepository {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {
		Response response = new Response();
		FinalizationEntity finalizationEntity = new FinalizationEntity();
		Long doctorNo = Long.parseLong(request.getParameter("doctorNo"));
		if(doctorNo != null)finalizationEntity.setDoctorNo(doctorNo);
		DataTableRequest dataTableInRQ = new DataTableRequest(request);
		Long totalRowCount = totalCount(FinalizationEntity.class,
				criteriaCodtion(finalizationEntity, LongCriteriaQuery(FinalizationEntity.class)));
		DataTableResults<FinalizationEntity> dataTableResults = null;
		List gridList = new ArrayList<>();

		if (dataTableInRQ.isGlobalSearch()) {
			String searchCriteria = CommonUtils.PERCENTAGE_SIGN + dataTableInRQ.getSearch()
					+ CommonUtils.PERCENTAGE_SIGN;
			finalizationEntity.setFinalizeName(searchCriteria);
		}
		response = baseList(typedQuery(finalizationEntity, dataTableInRQ));
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
	@SuppressWarnings({ "rawtypes" })
	private TypedQuery typedQuery(FinalizationEntity filter, DataTableRequest dataTableInRQ) {
		CriteriaQuery criteria = criteriaQuery(filter);
		return baseTypedQuery(criteria, dataTableInRQ);
	}
	public Response save(FinalizationEntity obj) {
		FinalizationEntity finalizationEntity = findByNameAndDoctorNo(obj);
		if(finalizationEntity==null) {
			return baseOnlySave(obj);
		}
		System.out.println("Dublicated Entity found");
		return getErrorResponse("Record Found !!");
	}
	public Response update(FinalizationEntity finalizationEntity) {
		FinalizationEntity obj = findById(finalizationEntity.getId());
		if (obj != null) {
			obj.setFinalizeName(finalizationEntity.getFinalizeName());
			obj.setFinalizeResult(finalizationEntity.getFinalizeResult());
			obj.setFinalizePlaceHolder(finalizationEntity.getFinalizePlaceHolder());
			obj.setSerial(finalizationEntity.getSerial());
			obj.setDoctorNo(finalizationEntity.getDoctorNo());
			obj.setIsEnable(finalizationEntity.getIsEnable());
			return baseUpdate(obj);
		}
		return getErrorResponse("Record Found !!");
	}
	public Response detele(Long id) {
		FinalizationEntity vital = findById(id);
		return baseDelete(vital);
	}
	public Response remove(Long id) {
		FinalizationEntity vital = findById(id);
		vital.setActiveStatus(3);
		return baseRemove(vital);
	}

	public Response list(FinalizationEntity reqObj) {
		return baseList(criteriaQuery(reqObj));
	}
	
	public FinalizationEntity findByNameAndDoctorNo(FinalizationEntity reqObj) {
		Response response = baseSingleObject(criteriaQueryForEqualQuery(reqObj));
		if (response.isSuccess()) {
			return (FinalizationEntity) response.getObj();
		}
		return null;
	}

	/**
	 * @param id
	 * @return
	 */
	public FinalizationEntity findById(Long id) {
		Response response = baseFindById(criteriaQuery(new FinalizationEntity(id)));
		if (response.isSuccess()) {
			return (FinalizationEntity) response.getObj();
		}
		return null;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(FinalizationEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(FinalizationEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
		List<Predicate> p = criteriaCodtion(filter, root);
		if (!CollectionUtils.isEmpty(p)) {
			Predicate[] pArray = p.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}
		return criteria;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<Predicate> criteriaCodtion(FinalizationEntity filter, Root root) {
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
			if (filter.getFinalizeName() != null && !filter.getFinalizeName().isEmpty()) {
				Predicate condition = builder.like(root.get("finalizeName"), filter.getFinalizeName());
				p.add(condition);
			}
			if (filter.getDoctorNo() != null && filter.getDoctorNo() > 0) {
				Predicate condition = builder.equal(root.get("doctorNo"), filter.getDoctorNo());
				p.add(condition);
			}
		}
		return p;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQueryForEqualQuery(FinalizationEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(FinalizationEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
		List<Predicate> p = criteriaCodtion(filter, root);
		if (!CollectionUtils.isEmpty(p)) {
			Predicate[] pArray = p.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}
		return criteria;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<Predicate> criteriaCodtionForEqualQuery(FinalizationEntity filter, Root root) {
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
			if (filter.getFinalizeName() != null && !filter.getFinalizeName().isEmpty()) {
				Predicate condition = builder.like(root.get("finalizeName"), filter.getFinalizeName());
				p.add(condition);
			}
			if (filter.getDoctorNo() != null && filter.getDoctorNo() > 0) {
				Predicate condition = builder.equal(root.get("doctorNo"), filter.getDoctorNo());
				p.add(condition);
			}
		}
		return p;
	}
}

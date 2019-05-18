package com.madbarsoft.doctorchamber.vital;

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
import com.madbarsoft.doctorchamber.chiefComplain.ChiefComplainEntity;
import com.madbarsoft.doctorchamber.history.HistoryEntity;
import com.madbarsoft.doctorchamber.pagination.DataTableRequest;
import com.madbarsoft.doctorchamber.pagination.DataTableResults;
import com.madbarsoft.doctorchamber.physicalExamination.PhysicalExaminationEntity;
import com.madbarsoft.doctorchamber.util.CommonUtils;
import com.madbarsoft.doctorchamber.util.Response;

/**
 * @author Md. Jahurul Islam
 *
 */

@Repository
@Transactional
public class VitalRepository extends BaseRepository {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {

		Response response = new Response();
		VitalEntity vitalEntity = new VitalEntity();
		Long doctorNo = Long.parseLong(request.getParameter("doctorNo"));
		if(doctorNo != null)vitalEntity.setDoctorNo(doctorNo);
		DataTableRequest dataTableInRQ = new DataTableRequest(request);
		
		Long totalRowCount = totalCount(VitalEntity.class,criteriaCodtion(vitalEntity, LongCriteriaQuery(VitalEntity.class)));
		
		DataTableResults<ChiefComplainEntity> dataTableResults = null;
		List gridList = new ArrayList<>();

		if (dataTableInRQ.isGlobalSearch()) {
			String searchCriteria = CommonUtils.PERCENTAGE_SIGN + dataTableInRQ.getSearch()
					+ CommonUtils.PERCENTAGE_SIGN;
			vitalEntity.setVitalName(searchCriteria);
		}
		response = baseList(typedQuery(vitalEntity, dataTableInRQ));
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
	private TypedQuery typedQuery(VitalEntity filter, DataTableRequest dataTableInRQ) {
		CriteriaQuery criteria = criteriaQuery(filter);
		return baseTypedQuery(criteria, dataTableInRQ);
	}

	public Response save(VitalEntity obj) {
		VitalEntity vitalEntity = findByNameAndDoctorNo(obj);
		if(vitalEntity==null) {
			return baseOnlySave(obj);
		}
		System.out.println("Dublicated Entity found");
		return getErrorResponse("Record Found !!");
	}

	public Response update(VitalEntity vital) {

		VitalEntity obj = findById(vital.getId());

		if (obj != null) {
            obj.setDefaultValue(vital.getDefaultValue());
			obj.setVitalName(vital.getVitalName());
			obj.setVitalUnit(vital.getVitalUnit());
			obj.setVitalSerial(vital.getVitalSerial());
			obj.setInputType(vital.getInputType());
			obj.setDoctorNo(vital.getDoctorNo());
			obj.setIsEnable(vital.getIsEnable());
			return baseUpdate(obj);
		}

		return getErrorResponse("Record Found !!");
	}

	public Response detele(Long id) {
		VitalEntity vital = findById(id);
		return baseDelete(vital);
	}

	public Response remove(Long id) {
		VitalEntity vital = findById(id);
		vital.setActiveStatus(3);
		return baseRemove(vital);
	}
	
	public VitalEntity findByNameAndDoctorNo(VitalEntity reqObj) {
		Response response = baseSingleObject(criteriaQueryForEqualQuery(reqObj));
		if (response.isSuccess()) {
			return (VitalEntity) response.getObj();
		}
		return null;
	}

	public Response list(VitalEntity reqObj) {

		return baseList(criteriaQuery(reqObj));
	}

	/**
	 * @param id
	 * @return
	 */
	public VitalEntity findById(Long id) {

		Response response = baseFindById(criteriaQuery(new VitalEntity(id)));
		if (response.isSuccess()) {
			return (VitalEntity) response.getObj();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(VitalEntity filter) {

		initEntityManagerBuilderCriteriaQueryRoot(VitalEntity.class);

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
	private List<Predicate> criteriaCodtion(VitalEntity filter, Root root) {
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
			if (filter.getVitalName() != null && !filter.getVitalName().isEmpty()) {
				Predicate condition = builder.like(root.get("vitalName"), filter.getVitalName());
				p.add(condition);
			}
			if (filter.getDoctorNo() != null && filter.getDoctorNo() > 0) {
				Predicate condition = builder.equal(root.get("doctorNo"), filter.getDoctorNo());
				p.add(condition);
			}
			
			criteria.orderBy(builder.asc(root.get("vitalSerial")));
		}
		return p;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQueryForEqualQuery(VitalEntity filter) {

		initEntityManagerBuilderCriteriaQueryRoot(VitalEntity.class);

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
	private List<Predicate> criteriaCodtionForEqualQuery(VitalEntity filter, Root root) {
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
			if (filter.getVitalName() != null && !filter.getVitalName().isEmpty()) {
				Predicate condition = builder.like(root.get("vitalName"), filter.getVitalName());
				p.add(condition);
			}
			if (filter.getDoctorNo() != null && filter.getDoctorNo() > 0) {
				Predicate condition = builder.equal(root.get("doctorNo"), filter.getDoctorNo());
				p.add(condition);
			}
			
			criteria.orderBy(builder.asc(root.get("vitalSerial")));
		}
		return p;
	}
}

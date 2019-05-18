package com.madbarsoft.doctorchamber.physicalExamination;

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

import com.madbarsoft.doctorchamber.advice.AdviceEntity;
import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.history.HistoryEntity;
import com.madbarsoft.doctorchamber.pagination.DataTableRequest;
import com.madbarsoft.doctorchamber.pagination.DataTableResults;
import com.madbarsoft.doctorchamber.util.Response;

/**
 * @author Md. Jahurul Islam
 *
 */

@Repository
@Transactional
public class PhysicalExaminationRepository extends BaseRepository {

	/*
	 * @SuppressWarnings({ "rawtypes", "unchecked" }) public Response
	 * gridList(HttpServletRequest request) { Response response = new Response();
	 * PhysicalExaminationEntity physicalExamination = new
	 * PhysicalExaminationEntity();
	 * 
	 * Long doctorNo = Long.parseLong(request.getParameter("doctorNo")); if(doctorNo
	 * != null)physicalExamination.setDoctorNo(doctorNo);
	 * 
	 * DataTableRequest dataTableInRQ = new DataTableRequest(request); Long
	 * totalRowCount = totalCount(PhysicalExaminationEntity.class,criteriaCodtion(
	 * physicalExamination, LongCriteriaQuery(PhysicalExaminationEntity.class)));
	 * DataTableResults<ChiefComplainEntity> dataTableResults = null; List gridList
	 * = new ArrayList<>();
	 * 
	 * if (dataTableInRQ.isGlobalSearch()) { String searchCriteria =
	 * CommonUtils.PERCENTAGE_SIGN + dataTableInRQ.getSearch() +
	 * CommonUtils.PERCENTAGE_SIGN; physicalExamination.setExamName(searchCriteria);
	 * } response = baseList(typedQuery(physicalExamination, dataTableInRQ)); if
	 * (response.isSuccess()) { if (response.getItems() != null) { gridList =
	 * response.getItems(); } dataTableResults = dataTableResults(dataTableInRQ,
	 * gridList, gridList, totalRowCount); } response.setItems(null);
	 * response.setObj(dataTableResults);
	 * 
	 * return response; }
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {

		String doctorNo = request.getParameter("doctorNo");
		DataTableResults<PhysicalExaminationEntity> dataTableResults = null;
		Response response = new Response();

		PhysicalExaminationEntity physicalExaminationEntity = new PhysicalExaminationEntity();

		if (!doctorNo.isEmpty()) {
			physicalExaminationEntity.setDoctorNo(Long.parseLong(doctorNo));
		}

		DataTableRequest dataTableInRQ = new DataTableRequest(request);

		Long totalRowCount = totalCount(physicalExaminationEntity);

		List gridList = new ArrayList<>();

		response = baseList(typedQuery(physicalExaminationEntity, dataTableInRQ));

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

	private Long totalCount(PhysicalExaminationEntity filter) {
		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<PhysicalExaminationEntity> root = from(PhysicalExaminationEntity.class, criteriaQuery);
		return totalCount(builder, criteriaQuery, root, criteriaCodtion(filter, builder, root));

	}
	
	public PhysicalExaminationEntity findByNameAndDoctorNo(PhysicalExaminationEntity reqObj) {

		Response response = baseSingleObject(criteriaQueryForEquealQuery(reqObj));
		if (response.isSuccess()) {
			return (PhysicalExaminationEntity) response.getObj();
		}
		return null;
	}

	@SuppressWarnings({ "unchecked" })
	private List<Predicate> criteriaCodtion(PhysicalExaminationEntity filter, CriteriaBuilder builder,
			Root<PhysicalExaminationEntity> root) {

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
			if (filter.getExamName() != null && !filter.getExamName().isEmpty()) {
				Predicate condition = builder.like(root.get("examName"), filter.getExamName());
				p.add(condition);
			}
			if (filter.getDoctorNo() != null && filter.getDoctorNo() > 0) {
				Predicate condition = builder.or(builder.equal(root.get("doctorNo"), filter.getDoctorNo()),
						builder.isNull(root.get("doctorNo")));

				p.add(condition);
			}
		}

		return p;
	}

	@SuppressWarnings({ "rawtypes" })
	private TypedQuery typedQuery(PhysicalExaminationEntity filter, DataTableRequest dataTableInRQ) {
		CriteriaQuery criteria = criteriaQuery(filter);
		return baseTypedQuery(criteria, dataTableInRQ);
	}

	public Response save(PhysicalExaminationEntity physicalExam) {
		PhysicalExaminationEntity physicalExaminationEntity = findByNameAndDoctorNo(physicalExam);
		if(physicalExaminationEntity==null) {
			return baseOnlySave(physicalExam);
		}
		System.out.println("Dublicated Entity found");
		return getErrorResponse("Record Found !!");
	}

	public Response update(PhysicalExaminationEntity physicalExam) {
		PhysicalExaminationEntity obj = findById(physicalExam.getId());
		if (obj != null) {
			obj.setExamName(physicalExam.getExamName());
			obj.setExamUnit(physicalExam.getExamUnit());
			obj.setExamSerial(physicalExam.getExamSerial());
			obj.setDoctorNo(physicalExam.getDoctorNo());
			obj.setInputType(physicalExam.getInputType());
			obj.setIsEnable(physicalExam.getIsEnable());
			obj.setIsShowHeader(physicalExam.getIsShowHeader());
			obj.setExamGroup(physicalExam.getExamGroup());
			return baseUpdate(obj);
		}
		return getErrorResponse("Record Found !!");
	}

	public Response detele(Long id) {
		PhysicalExaminationEntity vital = findById(id);
		return baseDelete(vital);
	}

	public Response remove(Long id) {
		PhysicalExaminationEntity vital = findById(id);
		vital.setActiveStatus(3);
		return baseRemove(vital);
	}

	public Response list(PhysicalExaminationEntity reqObj) {

		return baseList(criteriaQuery(reqObj));
	}

	/**
	 * @param id
	 * @return
	 */
	public PhysicalExaminationEntity findById(Long id) {

		Response response = baseFindById(criteriaQuery(new PhysicalExaminationEntity(id)));
		if (response.isSuccess()) {
			return (PhysicalExaminationEntity) response.getObj();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(PhysicalExaminationEntity filter) {

		initEntityManagerBuilderCriteriaQueryRoot(PhysicalExaminationEntity.class);

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
	private List<Predicate> criteriaCodtion(PhysicalExaminationEntity filter, Root root) {
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
			if (filter.getExamName() != null && !filter.getExamName().isEmpty()) {
				Predicate condition = builder.like(root.get("examName"), filter.getExamName());
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
	private CriteriaQuery criteriaQueryForEquealQuery(PhysicalExaminationEntity filter) {

		initEntityManagerBuilderCriteriaQueryRoot(PhysicalExaminationEntity.class);

		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;

		List<Predicate> p = criteriaCodtionForEqualQuery(filter, root);

		if (!CollectionUtils.isEmpty(p)) {
			Predicate[] pArray = p.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}

		return criteria;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<Predicate> criteriaCodtionForEqualQuery(PhysicalExaminationEntity filter, Root root) {
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
			if (filter.getExamName() != null && !filter.getExamName().isEmpty()) {
				Predicate condition = builder.equal(root.get("examName"), filter.getExamName());
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

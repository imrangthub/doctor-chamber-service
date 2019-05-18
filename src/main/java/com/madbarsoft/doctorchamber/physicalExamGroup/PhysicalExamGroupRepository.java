package com.madbarsoft.doctorchamber.physicalExamGroup;

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
import com.madbarsoft.doctorchamber.pagination.DataTableRequest;
import com.madbarsoft.doctorchamber.pagination.DataTableResults;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class PhysicalExamGroupRepository extends BaseRepository {

	/*
	 * @SuppressWarnings({ "rawtypes", "unchecked" }) public Response
	 * gridList(HttpServletRequest request) { Response response = new Response();
	 * PhysicalExamGroupEntity physicalExamGroupEntity = new
	 * PhysicalExamGroupEntity(); Long doctorNo =
	 * Long.parseLong(request.getParameter("doctorNo")); if(doctorNo !=
	 * null)physicalExamGroupEntity.setDoctorNo(doctorNo); DataTableRequest
	 * dataTableInRQ = new DataTableRequest(request);
	 * 
	 * Long totalRowCount = totalCount(PhysicalExamGroupEntity.class,
	 * criteriaCodtion(physicalExamGroupEntity,
	 * LongCriteriaQuery(PhysicalExamGroupEntity.class)));
	 * DataTableResults<PhysicalExamGroupEntity> dataTableResults = null; List
	 * gridList = new ArrayList<>();
	 * 
	 * if (dataTableInRQ.isGlobalSearch()) { String searchCriteria =
	 * CommonUtils.PERCENTAGE_SIGN + dataTableInRQ.getSearch() +
	 * CommonUtils.PERCENTAGE_SIGN;
	 * physicalExamGroupEntity.setGroupName(searchCriteria); } response =
	 * baseList(typedQuery(physicalExamGroupEntity, dataTableInRQ)); if
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
		DataTableResults<PhysicalExamGroupEntity> dataTableResults = null;
		Response response = new Response();

		PhysicalExamGroupEntity physicalExamGroupEntity = new PhysicalExamGroupEntity();

		if (!doctorNo.isEmpty()) {
			physicalExamGroupEntity.setDoctorNo(Long.parseLong(doctorNo));
		}

		DataTableRequest dataTableInRQ = new DataTableRequest(request);

		Long totalRowCount = totalCount(physicalExamGroupEntity);

		List gridList = new ArrayList<>();

		response = baseList(typedQuery(physicalExamGroupEntity, dataTableInRQ));

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

	private Long totalCount(PhysicalExamGroupEntity filter) {

		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<PhysicalExamGroupEntity> root = from(PhysicalExamGroupEntity.class, criteriaQuery);

		return totalCount(builder, criteriaQuery, root, criteriaCodtion(filter, builder, root));

	}

	@SuppressWarnings({ "unchecked" })
	private List<Predicate> criteriaCodtion(PhysicalExamGroupEntity filter, CriteriaBuilder builder,
			Root<PhysicalExamGroupEntity> root) {

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
			if (filter.getGroupName() != null && !filter.getGroupName().isEmpty()) {
				Predicate condition = builder.like(root.get("groupName"), filter.getGroupName());
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
	private TypedQuery typedQuery(PhysicalExamGroupEntity filter, DataTableRequest dataTableInRQ) {
		CriteriaQuery criteria = criteriaQuery(filter);
		return baseTypedQuery(criteria, dataTableInRQ);
	}

	public Response save(PhysicalExamGroupEntity obj) {
		return baseOnlySave(obj);
	}

	public Response update(PhysicalExamGroupEntity physicalExamGroupEntity) {
		PhysicalExamGroupEntity obj = findById(physicalExamGroupEntity.getId());
		if (obj != null) {
			obj.setGroupName(physicalExamGroupEntity.getGroupName());
			obj.setSerial(physicalExamGroupEntity.getSerial());
			obj.setDoctorNo(physicalExamGroupEntity.getDoctorNo());
			obj.setIsShowHeader(physicalExamGroupEntity.getIsShowHeader());
			obj.setIsEnable(physicalExamGroupEntity.getIsEnable());
			return baseUpdate(obj);
		}

		return getErrorResponse("Record Found !!");
	}

	public Response detele(Long id) {
		PhysicalExamGroupEntity obj = findById(id);
		return baseDelete(obj);
	}

	public Response remove(Long id) {
		PhysicalExamGroupEntity obj = findById(id);
		obj.setActiveStatus(3);
		return baseRemove(obj);
	}

	public Response list(PhysicalExamGroupEntity obj) {

		return baseList(criteriaQuery(obj));
	}

	/**
	 * @param id
	 * @return
	 */
	public PhysicalExamGroupEntity findById(Long id) {

		Response response = baseFindById(criteriaQuery(new PhysicalExamGroupEntity(id)));
		if (response.isSuccess()) {
			return (PhysicalExamGroupEntity) response.getObj();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(PhysicalExamGroupEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(PhysicalExamGroupEntity.class);
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
	private List<Predicate> criteriaCodtion(PhysicalExamGroupEntity filter, Root root) {
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
			if (filter.getGroupName() != null && !filter.getGroupName().isEmpty()) {
				Predicate condition = builder.like(root.get("groupName"), filter.getGroupName());
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

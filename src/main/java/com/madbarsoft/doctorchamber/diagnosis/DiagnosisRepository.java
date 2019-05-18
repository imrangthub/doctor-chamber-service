package com.madbarsoft.doctorchamber.diagnosis;

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
public class DiagnosisRepository extends BaseRepository {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {

		String doctorNo = request.getParameter("doctorNo");
		DataTableResults<DiagnosisEntity> dataTableResults = null;
		Response response = new Response();
		DiagnosisEntity diagnosisEntity = new DiagnosisEntity();
		if (!doctorNo.isEmpty()) {
			diagnosisEntity.setDoctorNo(Long.parseLong(doctorNo));
		}
		DataTableRequest dataTableInRQ = new DataTableRequest(request);
		Long totalRowCount = totalCount(diagnosisEntity);

		List gridList = new ArrayList<>();
		response = baseList(typedQuery(diagnosisEntity, dataTableInRQ));

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

	public Response save(DiagnosisEntity reqObj) {
		return baseOnlySave(reqObj);
	}

	public Response update(DiagnosisEntity reqObj) {
		DiagnosisEntity obj = findById(reqObj.getId());
		if (obj != null) {
			obj.setDiagnosisName(reqObj.getDiagnosisName());
			obj.setDoctorNo(reqObj.getDoctorNo());
			return baseUpdate(obj);
		}

		return getErrorResponse("Record not Found !!");

	}

	public Response detele(Long id) {

		DiagnosisEntity diagnosis = findById(id);
		return baseDelete(diagnosis);

	}

	public Response remove(Long id) {
		DiagnosisEntity diagnosis = findById(id);
		diagnosis.setActiveStatus(3);
		return baseRemove(diagnosis);
	}

	public Response listByDoctorNo(DiagnosisEntity obj) {
		return baseList(criteriaQuery(obj));
	}

	public DiagnosisEntity findById(Long id) {
		DiagnosisEntity diagnosisEntity = new DiagnosisEntity();
		diagnosisEntity.setId(id);
		Response response = baseFindById(criteriaQuery(diagnosisEntity));
		if (response.isSuccess()) {
			return (DiagnosisEntity) response.getObj();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(DiagnosisEntity filter) {
		init();
		List<Predicate> p = new ArrayList<Predicate>();
		p = criteriaCodtion(filter, null, null);
		if (!CollectionUtils.isEmpty(p)) {
			Predicate[] pArray = p.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}
		return criteria;
	}

	@SuppressWarnings({ "rawtypes" })
	private <T> TypedQuery typedQuery(DiagnosisEntity filter, DataTableRequest<T> dataTableInRQ) {
		init();
		List<Predicate> pArrayJoin = new ArrayList<Predicate>();
		List<Predicate> pConjunction = criteriaCodtion(filter, null, null);
		List<Predicate> pDisJunction = dataTablefilter(dataTableInRQ);

		Predicate predicateAND = null;
		Predicate predicateOR = null;

		if (!CollectionUtils.isEmpty(pConjunction)) {
			Predicate[] pArray = pConjunction.toArray(new Predicate[] {});
			predicateAND = builder.and(pArray);
		}

		if (!CollectionUtils.isEmpty(pDisJunction)) {
			Predicate[] pArray = pDisJunction.toArray(new Predicate[] {});
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

	private Long totalCount(DiagnosisEntity filter) {
		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<DiagnosisEntity> root = from(DiagnosisEntity.class, criteriaQuery);
		return totalCount(builder, criteriaQuery, root, criteriaCodtion(filter, builder, root));

	}

	@SuppressWarnings({ "unchecked" })
	private List<Predicate> criteriaCodtion(DiagnosisEntity filter, CriteriaBuilder builder,
			Root<DiagnosisEntity> root) {

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
			if (filter.getDiagnosisName() != null && !filter.getDiagnosisName().isEmpty()) {
				Predicate condition = builder.like(root.get("diagnosisName"), filter.getDiagnosisName());
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

	private void init() {
		initEntityManagerBuilderCriteriaQueryRoot(DiagnosisEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}
}

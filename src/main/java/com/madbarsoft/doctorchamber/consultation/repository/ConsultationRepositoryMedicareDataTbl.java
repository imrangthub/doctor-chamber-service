package com.madbarsoft.doctorchamber.consultation.repository;

import java.util.ArrayList;
import java.util.Date;
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
import com.madbarsoft.doctorchamber.consultation.ConsultationEntity;
import com.madbarsoft.doctorchamber.pagination.DataTableRequest;
import com.madbarsoft.doctorchamber.pagination.DataTableResults;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class ConsultationRepositoryMedicareDataTbl extends BaseRepository {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {

		String doctorNo = request.getParameter("doctorNo");
		DataTableResults<ConsultationEntity> dataTableResults = null;
		Response response = new Response();

		ConsultationEntity consultationEntity = new ConsultationEntity();

		DataTableRequest dataTableInRQ = new DataTableRequest(request);

		Long totalRowCount = totalCount(consultationEntity);

		List gridList = new ArrayList<>();

		response = baseList(typedQuery(consultationEntity, dataTableInRQ));

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

	private Long totalCount(ConsultationEntity filter) {

		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<ConsultationEntity> root = from(ConsultationEntity.class, criteriaQuery);

		return totalCount(builder, criteriaQuery, root, criteriaCodtion(filter, builder, root));

	}

	public Response list() {
		ConsultationEntity obj = new ConsultationEntity();
		return baseList(criteriaQuery(obj));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(ConsultationEntity filter) {
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
	private <T> TypedQuery typedQuery(ConsultationEntity filter, DataTableRequest<T> dataTableInRQ) {
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

	@SuppressWarnings({ "unchecked" })
	private List<Predicate> criteriaCodtion(ConsultationEntity filter, CriteriaBuilder builder,
			Root<ConsultationEntity> root) {

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
			if (filter.getConsultationId() != null && !filter.getConsultationId().isEmpty()) {
				Predicate condition = builder.equal(root.get("consultationId"), filter.getConsultationId());
				p.add(condition);
			}
			if (filter.getConsultationNo() != null && filter.getConsultationNo() > 0) {
				Predicate condition = builder.equal(root.get("consultationNo"), filter.getConsultationNo());
				p.add(condition);
			}
			if (filter.getHospitalNo() != null && !filter.getHospitalNo().isEmpty()) {
				Predicate condition = builder.equal(root.get("hospitalNo"), filter.getHospitalNo());
				p.add(condition);
			}
			if (filter.getConsult_out() != null && filter.getConsult_out() == 0) {
				Predicate condition = builder.equal(root.get("consult_out"), filter.getConsult_out());
				p.add(condition);
			}
			if (filter.getDoctor_no() != null && filter.getDoctor_no() > 0) {
				Predicate condition = builder.equal(root.get("doctor_no"), filter.getDoctor_no());
				p.add(condition);
			}
			if (filter.getFromDate() != null && filter.getToDate() != null) {
				Date fromDate = addHourMinutesSeconds(00, 00, 00, filter.getFromDate());
				Date toDate = addHourMinutesSeconds(23, 59, 59, filter.getToDate());
				Predicate condition = builder.between(root.get("appointmentDt"), fromDate, toDate);
				p.add(condition);
			}

		}

		return p;
	}

	private void init() {
		initEntityManagerBuilderCriteriaQueryRoot(ConsultationEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}
}

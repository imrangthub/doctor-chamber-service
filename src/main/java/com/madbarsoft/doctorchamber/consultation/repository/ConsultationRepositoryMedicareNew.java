package com.madbarsoft.doctorchamber.consultation.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.consultation.ConsultantEntity;
import com.madbarsoft.doctorchamber.consultation.ConsultationEntity;
import com.madbarsoft.doctorchamber.consultation.statement.ConsultationStatementMedicareLive;
import com.madbarsoft.doctorchamber.consultation.statement.ConsultationStatementMedicareNew;
import com.madbarsoft.doctorchamber.pagination.DataTableRequest;
import com.madbarsoft.doctorchamber.pagination.DataTableResults;
import com.madbarsoft.doctorchamber.pagination.PaginationCriteria;
import com.madbarsoft.doctorchamber.util.AppUtil;
import com.madbarsoft.doctorchamber.util.Response;
import com.madbarsoft.doctorchamber.vital.VitalEntity;

@Repository
@Transactional
public class ConsultationRepositoryMedicareNew extends BaseRepository {
	
	
	
	public Response save(ConsultationEntity reqObj) {
		Response response = new Response();
		
		reqObj.setHospitalNo("HP"+System.currentTimeMillis());
		reqObj.setConsultationId("CH"+System.currentTimeMillis());
		reqObj.setConsultationNo(System.currentTimeMillis());
		
		reqObj.setDoctor_no(137l);
		reqObj.setDoctorName("MD IMRAN HOSSAIN");
		reqObj.setConsult_in(1l);
		reqObj.setConsult_out(0l);
		
		reqObj.setConsultationDt(new Date());
		reqObj.setAppointmentDt(new Date());
		reqObj.setConsultationTime(new Date());
		reqObj.setConsultationType("1");
		
		
		response = baseOnlySave(reqObj);
		if(response.isSuccess()){
			return getSuccessResponse("Sava Success");
		}
		return getErrorResponse("Sava Error");
	}
	
	
	public Response listWithFilter(Map<String, String> queryMap) {

		Response response = new Response();

		List<ConsultationEntity> consulationEntityList = new ArrayList<ConsultationEntity>();
		
		ConsultationEntity obj = new ConsultationEntity();

		obj.setDoctor_no(Long.parseLong(queryMap.get("doctorNo")));
		
		response = baseList(criteriaQuery(obj));
		
		System.out.println("response"+response);
		System.out.println("response"+response.getItems());

		return response;

		//return getSuccessResponse("Work List Found", response);
	}
	
	
	public Response findByDoctorNo(Long doctorNo) {

		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		con = getOraConnection();

		ConsultantEntity consultantEntity = new ConsultantEntity();


				consultantEntity.setDoctorNo(137);
				consultantEntity.setDoctorName("MD IMRAN HOSSAIN");
				consultantEntity.setDoctorSignature("MBBS");


		response.setObj(consultantEntity);

		return getSuccessResponse("Consultant Information Found", response);
	}
	
	
	
	public Response findByHospitalNumber(String hnNumber) {
		ConsultationEntity obj = new ConsultationEntity();
		obj.setHospitalNo(hnNumber);
		Response response = baseSingleObject(criteriaQuery(obj));
		if (response.isSuccess()) {
			return response;
		}

		return getErrorResponse("Consultation Information not Found");
	}
	
	public Response findByConsultationId(ConsultationEntity reqObj) {
		
		Response response = baseSingleObject(criteriaQuery(reqObj));
		if (response.isSuccess()) {
			return response;
		}

		return getErrorResponse("Consultation Information not Found");
	}
	

	public Response listByDoctorNo(ConsultationEntity obj) {
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

	private Long totalCount(ConsultationEntity filter) {

		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<ConsultationEntity> root = from(ConsultationEntity.class, criteriaQuery);

		return totalCount(builder, criteriaQuery, root, criteriaCodtion(filter, builder, root));

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
			if (filter.getHospitalNo() != null && !filter.getHospitalNo().isEmpty()) {
				Predicate condition = builder.equal(root.get("hospitalNo"), filter.getHospitalNo());
				p.add(condition);
			}
			if (filter.getDoctor_no() != null && filter.getDoctor_no() > 0) {
				Predicate condition = builder.equal(root.get("doctor_no"), filter.getDoctor_no());
				p.add(condition);
			}
//			if (filter.getDoctor_no() != null && filter.getDoctor_no() > 0) {
//				Predicate condition = builder.or(builder.equal(root.get("doctor_no"), filter.getDoctor_no()),
//						builder.isNull(root.get("doctor_no")));
//
//				p.add(condition);
//			}
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

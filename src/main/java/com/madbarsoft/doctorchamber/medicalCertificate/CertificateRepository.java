package com.madbarsoft.doctorchamber.medicalCertificate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.madbarsoft.core.util.CommonFunction;
import com.madbarsoft.core.util.CommonFunctions;
import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.consultation.ConsultantEntity;
import com.madbarsoft.doctorchamber.consultation.ConsultationEntity;
import com.madbarsoft.doctorchamber.consultation.service.ConsultationService;
import com.madbarsoft.doctorchamber.util.Def;
import com.madbarsoft.doctorchamber.util.Response;

/**
 * @author Mohammad lockman
 *
 */
@Repository
@Transactional
public class CertificateRepository extends BaseRepository {

	@Autowired
	ConsultationService consulationService;

	public Response save(String reqObj) {
		CertificateEntity certificateEntity = objectMapperReadValue(reqObj, CertificateEntity.class);
		return baseSaveOrUpdate(certificateEntity);
	}

	public Response list(String reqObj) {
		CertificateEntity certificateEntity = objectMapperReadValue(reqObj, CertificateEntity.class);
		return baseList(criteriaQuery(certificateEntity));
	}

//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	private CriteriaQuery criteriaQuery(CertificateEntity filter) {
//		init();
//
//		List<Predicate> p = new ArrayList<Predicate>();
//		p = criteriaCodtion(filter, null, null);
//
//		if (!CollectionUtils.isEmpty(p)) {
//			Predicate[] pArray = p.toArray(new Predicate[] {});
//			Predicate predicate = builder.and(pArray);
//			criteria.where(predicate);
//		}
//		return criteria;
//	}

	public Response findByCriteria(String searchCriteria) {
		JSONObject searchCriteriaObj = new JSONObject(searchCriteria);

		Long id = Def.getLong(searchCriteriaObj, "id");
		String hospitalNo = Def.getString(searchCriteriaObj, "hospitalNo");
		String consultationNo = Def.getString(searchCriteriaObj, "consultationNo");
		Long doctorNo = Def.getLong(searchCriteriaObj, "doctorNo");

		CertificateEntity certificateEntity = new CertificateEntity();
		certificateEntity.setId(id);
		certificateEntity.setHospitalNo(hospitalNo);
		certificateEntity.setConsultationNo(consultationNo);
		certificateEntity.setDoctorNo(doctorNo);

		Response response = baseFindById(criteriaQuery(certificateEntity));

		if (response.isSuccess()) {
			certificateEntity = (CertificateEntity) response.getObj();
			response.setObj(certificateEntity);
			return response;
		}
		return getErrorResponse("Data Not Found.");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(CertificateEntity filter) {

		initEntityManagerBuilderCriteriaQueryRoot(CertificateEntity.class);

		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;

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

		}

		if (filter.getHospitalNo() != null && !filter.getHospitalNo().isEmpty()) {
			Predicate condition = builder.equal(root.get("hospitalNo"), filter.getHospitalNo());
			p.add(condition);
		}

		if (filter.getConsultationNo() != null && !filter.getConsultationNo().isEmpty()) {
			Predicate condition = builder.equal(root.get("consultationNo"), filter.getConsultationNo());
			p.add(condition);
		}

		if (filter.getDoctorNo() != null) {
			Predicate condition = builder.equal(root.get("doctorNo"), filter.getDoctorNo());
			p.add(condition);
		}
		
		if (filter.getType() != null) {
			Predicate condition = builder.equal(root.get("type"), filter.getType());
			p.add(condition);
		}

		if (!CollectionUtils.isEmpty(p)) {
			Predicate[] pArray = p.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}

		// criteria.orderBy(builder.desc(root.get("id")));

		return criteria;

	}

	@SuppressWarnings({ "unchecked" })
	private List<Predicate> criteriaCodtion(CertificateEntity filter, CriteriaBuilder builder,
			Root<CertificateEntity> root) {

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
			if (filter.getHospitalNo() != null && !filter.getHospitalNo().isEmpty()) {
				Predicate condition = builder.equal(root.get("hospitalNo"), filter.getHospitalNo());
				p.add(condition);
			}
			if (filter.getConsultationNo() != null && !filter.getConsultationNo().isEmpty()) {
				Predicate condition = builder.equal(root.get("consultationNo"), filter.getConsultationNo());
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
		initEntityManagerBuilderCriteriaQueryRoot(CertificateEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}

	public String checkNull(String param) {
		if (param == null) {
			return "";
		} else {
			return param;
		}
	}
	
//	public String replaceString(String text,List l) {
//		
//		return null;
//	}
	public String dateFormat(Date dateStr, String dateFormat) {
		if(dateStr == null) {
			return new SimpleDateFormat(dateFormat).format(new Date());
		}
		String parseDate = new SimpleDateFormat(dateFormat).format(dateStr);
		
		return parseDate;
	}
	
	public String getFinialCertificateText(CertificateEntity certificateEntity) {
		String finialCertificateText = null;
		String certificateText = certificateEntity.getCertificateText();
//		Response response = consulationService.findByHospitalNumber(certificateEntity.getHospitalNo());
		Response response = null;
		ConsultationEntity consultationEntity = null;
		if (response.isSuccess()) {
			consultationEntity = getValueFromObject(response.getObj(), ConsultationEntity.class);
			
		}

		if (consultationEntity != null) {
			finialCertificateText = certificateText.replace("@FullName", consultationEntity.getPatientName())
					.replace("@DateOfBirth", dateFormat(consultationEntity.getDob(), "dd/MMM/yyyy"))
					.replace("@CurrentDate", dateFormat(null, "dd/MMM/yyyy"))
					.replace("@Gender", checkNull(consultationEntity.getGender()))
					.replace("@Age", checkNull(consultationEntity.getAge()))
					.replace("@Mobile", checkNull(consultationEntity.getPhoneNo()))
					.replace("@ConsultationId", checkNull(consultationEntity.getConsultationId()))
					.replace("@PatientId", checkNull(consultationEntity.getHospitalNo()))
					.replace("@MaritalStatus", checkNull(consultationEntity.getMaritalStatus()))
					.replace("@BloodGroup", checkNull(consultationEntity.getBloodGroup()));
		}

		return finialCertificateText;
	}
}

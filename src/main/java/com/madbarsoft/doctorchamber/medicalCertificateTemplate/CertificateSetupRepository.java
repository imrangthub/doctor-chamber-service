package com.madbarsoft.doctorchamber.medicalCertificateTemplate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;
import com.madbarsoft.doctorchamber.util.Response;

/**
 * @author Mohammad lockman
 *
 */

@Repository
@Transactional
public class CertificateSetupRepository extends BaseRepository {

	public Response save(String certificate) {
		CertificateSetupEntity certificateSetupEntity = objectMapperReadValue(certificate, CertificateSetupEntity.class);
		return baseOnlySave(certificateSetupEntity);
	}
	
	public Response list(String reqObj) {
		CertificateSetupEntity certificateSetupEntity = objectMapperReadValue(reqObj, CertificateSetupEntity.class);
		return baseList(criteriaQuery(certificateSetupEntity));
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(CertificateSetupEntity filter) {
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
	
	@SuppressWarnings({ "unchecked" })
	private List<Predicate> criteriaCodtion(CertificateSetupEntity filter, CriteriaBuilder builder, Root<CertificateSetupEntity> root) {

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
			if (filter.getTemplateName() != null && !filter.getTemplateName().isEmpty()) {
				Predicate condition = builder.like(root.get("templateName"), filter.getTemplateName());
				p.add(condition);
			}
			if (filter.getDoctorNo() != null && filter.getDoctorNo() > 0) {
				Predicate condition = builder.or(builder.equal(root.get("doctorNo"), filter.getDoctorNo()),
						builder.isNull(root.get("doctorNo")));
				p.add(condition);
			}
			if (filter.getType() != null ) {
				Predicate condition = builder.or(builder.equal(root.get("type"), filter.getType()),
						builder.isNull(root.get("type")));
				p.add(condition);
			}
		}

		return p;
	}

	private void init() {
		initEntityManagerBuilderCriteriaQueryRoot(CertificateSetupEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}

	public Response updateDefultTemplate(String reqObj) {	
		CertificateSetupEntity certificateSetupEntity = objectMapperReadValue(reqObj, CertificateSetupEntity.class);
		return baseSaveOrUpdate(certificateSetupEntity);
	}

	public Response getAllTag() {
		Response response = new Response();
		response.setObj(CertificateTemplateTag.getAllTag());
		return response;
	}
	
	public CertificateSetupEntity findById(Long id) {
		CertificateSetupEntity certificateSetupEntity = new CertificateSetupEntity();
		certificateSetupEntity.setId(id);
		Response response = baseFindById(criteriaQuery(certificateSetupEntity));

		if (response.isSuccess()) {
			return getValueFromObject(response.getObj(), CertificateSetupEntity.class) ;
		}
		return null;
	}

	public Response delete(Long id) {				
		CertificateSetupEntity   certificateSetupEntity = findById(id);		
		return baseDelete(certificateSetupEntity);
	}
}

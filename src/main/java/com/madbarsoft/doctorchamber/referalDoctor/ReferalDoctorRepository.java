package com.madbarsoft.doctorchamber.referalDoctor;

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
public class ReferalDoctorRepository extends BaseRepository {

	public Response save(String certificate) {
		ReferalDoctorEntity certificateSetupEntity = objectMapperReadValue(certificate, ReferalDoctorEntity.class);
		return baseOnlySave(certificateSetupEntity);
	}
	
	public Response list(String reqObj) {
		ReferalDoctorEntity certificateSetupEntity = objectMapperReadValue(reqObj, ReferalDoctorEntity.class);
		return baseList(criteriaQuery(certificateSetupEntity));
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(ReferalDoctorEntity filter) {
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
	private List<Predicate> criteriaCodtion(ReferalDoctorEntity filter, CriteriaBuilder builder, Root<ReferalDoctorEntity> root) {

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
			if (filter.getDoctorName() != null && !filter.getDoctorName().isEmpty()) {
				Predicate condition = builder.like(root.get("doctorName"), filter.getDoctorName());
				p.add(condition);
			}

		}

		return p;
	}

	private void init() {
		initEntityManagerBuilderCriteriaQueryRoot(ReferalDoctorEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}

	public Response updateDefultTemplate(String reqObj) {	
		ReferalDoctorEntity certificateSetupEntity = objectMapperReadValue(reqObj, ReferalDoctorEntity.class);
		return baseSaveOrUpdate(certificateSetupEntity);
	}


	public ReferalDoctorEntity findById(Long id) {
		ReferalDoctorEntity certificateSetupEntity = new ReferalDoctorEntity();
		certificateSetupEntity.setId(id);
		Response response = baseFindById(criteriaQuery(certificateSetupEntity));

		if (response.isSuccess()) {
			return getValueFromObject(response.getObj(), ReferalDoctorEntity.class) ;
		}
		return null;
	}

	public Response delete(Long id) {				
		ReferalDoctorEntity   certificateSetupEntity = findById(id);		
		return baseDelete(certificateSetupEntity);
	}
}

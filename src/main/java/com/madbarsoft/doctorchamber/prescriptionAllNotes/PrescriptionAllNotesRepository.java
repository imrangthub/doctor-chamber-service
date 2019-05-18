package com.madbarsoft.doctorchamber.prescriptionAllNotes;

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

@Repository
@Transactional
public class PrescriptionAllNotesRepository extends BaseRepository {

	public Response save(PrescriptionAllNotesEntity prescriptionAllNotes) {
		return baseOnlySave(prescriptionAllNotes);
	}

	public Response update(PrescriptionAllNotesEntity prescriptionAllNotes) {

		if (prescriptionAllNotes != null) {
			return baseUpdate(prescriptionAllNotes);
		}

		return getErrorResponse("Record not Found !!");
	}

	public Response detele(Long id) {

		PrescriptionAllNotesEntity prescriptionAllNotes = findById(id);
		return baseDelete(prescriptionAllNotes);

	}

	public Response remove(Long id) {
		PrescriptionAllNotesEntity prescriptionAllNotes = findById(id);
		prescriptionAllNotes.setActiveStatus(3);
		return baseRemove(prescriptionAllNotes);
	}

	public Response list() {

		return baseList(criteriaQuery(new PrescriptionAllNotesEntity()));
	}

	public PrescriptionAllNotesEntity findById(Long id) {
		PrescriptionAllNotesEntity prescriptionAllNotes = new PrescriptionAllNotesEntity();
		prescriptionAllNotes.setId(id);
		Response response = baseFindById(criteriaQuery(prescriptionAllNotes));

		if (response.isSuccess()) {
			return (PrescriptionAllNotesEntity) response.getObj();
		}
		return null;
	}

	public List<PrescriptionAllNotesEntity> getListFindByPrescriptionId(PrescriptionEntity id) {
		PrescriptionAllNotesEntity prescriptionAllNotes = new PrescriptionAllNotesEntity();
		prescriptionAllNotes.setPrescription(id);
		Response response = getListFindById(criteriaQuery(prescriptionAllNotes));

		if (response.isSuccess()) {
			return (List<PrescriptionAllNotesEntity>) response.getItems();
		}
		return null;
	}

	public PrescriptionAllNotesEntity getListFindByNotesDataType(List<PrescriptionAllNotesEntity> noteList, int notesDataType) {
		return noteList.stream().filter(pn -> pn.getNotesDataType()==notesDataType).findAny().orElse(null);
	}
	
	public PrescriptionAllNotesEntity getListFindByNotesDataType(PrescriptionEntity id, int notesDataType) {
	    List<PrescriptionAllNotesEntity> noteList = getListFindByPrescriptionId(id);
		return noteList.stream().filter(pn -> pn.getNotesDataType()==notesDataType).findAny().orElse(null);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(PrescriptionAllNotesEntity filter) {

		initEntityManagerBuilderCriteriaQueryRoot(PrescriptionAllNotesEntity.class);

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

			if (filter.getPrescription() != null) {
				Predicate condition = builder.equal(root.get("prescription"), filter.getPrescription());
				p.add(condition);
			}

		}

		if (!CollectionUtils.isEmpty(p)) {
			Predicate[] pArray = p.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}

		return criteria;

	}
}

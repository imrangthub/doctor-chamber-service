package com.madbarsoft.doctorchamber.prescriptionHistory;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
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
public class PrescriptionHistoryRepository extends BaseRepository {

	public Response save(PrescriptionHistoryEntity historyPrescriptionDataEntity) {
		return baseOnlySave(historyPrescriptionDataEntity);
	}

	public Response update(PrescriptionHistoryEntity historyPrescriptionDataEntity) {
		if (historyPrescriptionDataEntity != null) {
			return baseUpdate(historyPrescriptionDataEntity);
		}
		return getErrorResponse("Record not Found !!");
	}

	public Response detele(Long id) {
		PrescriptionHistoryEntity historyPrescriptionDataEntity = findById(id);
		return baseDelete(historyPrescriptionDataEntity);

	}
	
	public Response remove(Long id) {
		PrescriptionHistoryEntity historyPrescriptionDataEntity = findById(id);
		historyPrescriptionDataEntity.setActiveStatus(3);
		return baseRemove(historyPrescriptionDataEntity);
	}

	public Response list() {
		return baseList(criteriaQuery(new PrescriptionHistoryEntity()));
	}

	public PrescriptionHistoryEntity findById(Long id) {
		PrescriptionHistoryEntity historyPrescriptionDataEntity = new PrescriptionHistoryEntity();
		historyPrescriptionDataEntity.setId(id);
		Response response = baseFindById(criteriaQuery(historyPrescriptionDataEntity));
		if (response.isSuccess()) {
			return (PrescriptionHistoryEntity) response.getObj();
		}
		return null;
	}

	public List<PrescriptionHistoryEntity> getListFindByPrescriptionId(PrescriptionEntity id) {
		PrescriptionHistoryEntity historyPrescriptionDataEntity = new PrescriptionHistoryEntity();
		historyPrescriptionDataEntity.setPrescription(id);
		Response response = getListFindById(criteriaQuery(historyPrescriptionDataEntity));
		if (response.isSuccess() && response.getItems().size() > 0) {
			return getListFromObject(response.getItems(), PrescriptionHistoryEntity.class);
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(PrescriptionHistoryEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(PrescriptionHistoryEntity.class);
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
				//Predicate conditionNotEmpty = builder.isNotEmpty(root.get("historyResult"));
				//Predicate conditionNotNotNull = builder.isNotNull(root.get("historyResult"));
				//p.add(conditionNotEmpty);
				//p.add(conditionNotNotNull);
			}
			
			List<Order> orderList = new ArrayList();
			orderList.add(builder.asc(root.get("historyGroup")));
			orderList.add(builder.asc(root.get("inReportSerial")));
			
			criteria.orderBy(orderList);

		}
		if (!CollectionUtils.isEmpty(p)) {
			Predicate[] pArray = p.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}

		return criteria;

	}
}

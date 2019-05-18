package com.madbarsoft.doctorchamber.history;

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
import com.madbarsoft.doctorchamber.util.CommonUtils;
import com.madbarsoft.doctorchamber.util.Response;

/**
 * @author Md. Jahurul Islam
 *
 */

@Repository
@Transactional
public class HistoryRepository extends BaseRepository {

/*	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {
		Response response = new Response();
		HistoryEntity historyination = new HistoryEntity();

		Long doctorNo = Long.parseLong(request.getParameter("doctorNo"));
		if (doctorNo != null)
			historyination.setDoctorNo(doctorNo);

		DataTableRequest dataTableInRQ = new DataTableRequest(request);
		Long totalRowCount = totalCount(HistoryEntity.class,
				criteriaCodtion(historyination, LongCriteriaQuery(HistoryEntity.class)));
		DataTableResults<HistoryEntity> dataTableResults = null;
		List gridList = new ArrayList<>();

		if (dataTableInRQ.isGlobalSearch()) {
			String searchCriteria = CommonUtils.PERCENTAGE_SIGN + dataTableInRQ.getSearch()
					+ CommonUtils.PERCENTAGE_SIGN;
			historyination.setHistoryName(searchCriteria);
		}
		response = baseList(typedQuery(historyination, dataTableInRQ));
		if (response.isSuccess()) {
			if (response.getItems() != null) {
				gridList = response.getItems();
			}
			dataTableResults = dataTableResults(dataTableInRQ, gridList, gridList, totalRowCount);
		}
		response.setItems(null);
		response.setObj(dataTableResults);

		return response;
	}*/
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {

		String doctorNo = request.getParameter("doctorNo");
		DataTableResults<HistoryEntity> dataTableResults = null;
		Response response = new Response();

		HistoryEntity historyEntity = new HistoryEntity();

		if (!doctorNo.isEmpty()) {
			historyEntity.setDoctorNo(Long.parseLong(doctorNo));
		}

		DataTableRequest dataTableInRQ = new DataTableRequest(request);

		Long totalRowCount = totalCount(historyEntity);

		List gridList = new ArrayList<>();

		response = baseList(typedQuery(historyEntity, dataTableInRQ));

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

	private Long totalCount(HistoryEntity filter) {
		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<HistoryEntity> root = from(HistoryEntity.class, criteriaQuery);
		return totalCount(builder, criteriaQuery, root, criteriaCodtion(filter, builder, root));

	}

	@SuppressWarnings({ "unchecked" })
	private List<Predicate> criteriaCodtion(HistoryEntity filter, CriteriaBuilder builder,
			Root<HistoryEntity> root) {

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
			if (filter.getHistoryName() != null && !filter.getHistoryName().isEmpty()) {
				Predicate condition = builder.like(root.get("historyName"), filter.getHistoryName());
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
	private TypedQuery typedQuery(HistoryEntity filter, DataTableRequest dataTableInRQ) {
		CriteriaQuery criteria = criteriaQuery(filter);
		return baseTypedQuery(criteria, dataTableInRQ);
	}

	public Response save(HistoryEntity history) {	
		HistoryEntity historyEntity = findByNameAndDoctorNo(history);
		if(historyEntity==null) {
			return baseOnlySave(history);
		}
		System.out.println("Dublicated Entity found");
		return getErrorResponse("Record Found !!");
	}

	public Response update(HistoryEntity history) {
		HistoryEntity obj = findById(history.getId());
		if (obj != null) {
			obj.setHistoryName(history.getHistoryName());
			obj.setHistoryPlaceHolder(history.getHistoryPlaceHolder());
			obj.setHistorySerial(history.getHistorySerial());
			obj.setDoctorNo(history.getDoctorNo());
			obj.setInputType(history.getInputType());
			obj.setIsEnable(history.getIsEnable());
			obj.setIsShowHeader(history.getIsShowHeader());
			obj.setHistoryGroup(history.getHistoryGroup());
			return baseUpdate(obj);
		}
		return getErrorResponse("Record Found !!");
	}

	public Response detele(Long id) {
		HistoryEntity vital = findById(id);
		return baseDelete(vital);
	}

	public Response remove(Long id) {
		HistoryEntity vital = findById(id);
		vital.setActiveStatus(3);
		return baseRemove(vital);
	}
	

	public Response list(HistoryEntity reqObj) {

		return baseList(criteriaQuery(reqObj));
	}

	/**
	 * @param id
	 * @return
	 */
	public HistoryEntity findById(Long id) {

		Response response = baseFindById(criteriaQuery(new HistoryEntity(id)));
		if (response.isSuccess()) {
			return (HistoryEntity) response.getObj();
		}
		return null;
	}
	
	public HistoryEntity findByNameAndDoctorNo(HistoryEntity reqObj) {

		Response response = baseSingleObject(criteriaQueryForEqualQuery(reqObj));
		if (response.isSuccess()) {
			return (HistoryEntity) response.getObj();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(HistoryEntity filter) {

		initEntityManagerBuilderCriteriaQueryRoot(HistoryEntity.class);

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
	private CriteriaQuery criteriaQueryForEqualQuery(HistoryEntity filter) {

		initEntityManagerBuilderCriteriaQueryRoot(HistoryEntity.class);

		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;

		List<Predicate> p = criteriaCodtionEqualQuery(filter, root);

		if (!CollectionUtils.isEmpty(p)) {
			Predicate[] pArray = p.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}

		return criteria;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<Predicate> criteriaCodtion(HistoryEntity filter, Root root) {
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
			if (filter.getHistoryName() != null && !filter.getHistoryName().isEmpty()) {
				Predicate condition = builder.like(root.get("historyName"), filter.getHistoryName());
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
	private List<Predicate> criteriaCodtionEqualQuery(HistoryEntity filter, Root root) {
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
			if (filter.getHistoryName() != null && !filter.getHistoryName().isEmpty()) {
				Predicate condition = builder.equal(root.get("historyName"), filter.getHistoryName());
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

package com.madbarsoft.doctorchamber.manufacturer;

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
import com.madbarsoft.doctorchamber.chiefComplain.ChiefComplainEntity;
import com.madbarsoft.doctorchamber.pagination.DataTableRequest;
import com.madbarsoft.doctorchamber.pagination.DataTableResults;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class ManufacturerRepository extends BaseRepository{
	
	
/*	public Response gridList(ManufacturerEntity obj) {
		return baseList(criteriaQuery(obj));
	}
	*/
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {
		
		DataTableResults<ManufacturerEntity> dataTableResults = null;
		Response response = new Response();
		ManufacturerEntity manufacturerEntity = new ManufacturerEntity();
/*		Long doctorNo = Long.parseLong(request.getParameter("doctorNo"));
		if(doctorNo != null)manufacturerEntity.setDoctorNo(doctorNo);*/
		DataTableRequest dataTableInRQ = new DataTableRequest(request);
		Long totalRowCount = totalCount(manufacturerEntity);
		List gridList = new ArrayList<>();
		response = baseList(typedQuery(manufacturerEntity, dataTableInRQ));

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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(ManufacturerEntity filter) {
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
	private <T> TypedQuery typedQuery(ManufacturerEntity filter, DataTableRequest<T> dataTableInRQ) {
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

	private Long totalCount(ManufacturerEntity filter) {

		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<ManufacturerEntity> root = from(ManufacturerEntity.class, criteriaQuery);
		return totalCount(builder, criteriaQuery, root, criteriaCodtion(filter, builder, root));

	}

	@SuppressWarnings({ "unchecked" })
	private List<Predicate> criteriaCodtion(ManufacturerEntity filter, CriteriaBuilder builder,
			Root<ManufacturerEntity> root) {
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
			if (filter.getManufactName() != null && !filter.getManufactName().isEmpty()) {
				Predicate condition = builder.like(root.get("manufactName"), filter.getManufactName());
				p.add(condition);
			}
			if (filter.getDescription() != null && !filter.getDescription().isEmpty()) {
				Predicate condition = builder.like(root.get("description"), filter.getDescription());
				p.add(condition);
			}
	
		}

		return p;
	}

	private void init() {
		initEntityManagerBuilderCriteriaQueryRoot(ManufacturerEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}
	
	public Response list(ManufacturerEntity obj) {
		return baseList(criteriaQuery(obj));
	}
	
	public Response save(ManufacturerEntity reqObj) {
		return baseOnlySave(reqObj);
	}

	public Response update(ManufacturerEntity reqObj) {
		ManufacturerEntity obj = findById(reqObj.getId());
		if (obj != null) {
			obj.setManufactName(reqObj.getManufactName());
			obj.setDescription(reqObj.getDescription());
			return baseUpdate(obj);
		}
		return getErrorResponse("Record not Found !!");

	}

	public Response detele(Long id) {
		ManufacturerEntity obj = findById(id);
		return baseDelete(obj);
	}

	public Response remove(Long id) {
		ManufacturerEntity obj = findById(id);
		obj.setActiveStatus(3);
		return baseRemove(obj);
	}


	public ManufacturerEntity findById(Long id) {
		ManufacturerEntity obj = new ManufacturerEntity();
		obj.setId(id);
		Response response = baseFindById(criteriaQuery(obj));
		if (response.isSuccess()) {
			return (ManufacturerEntity) response.getObj();
		}
		return null;
	}

}

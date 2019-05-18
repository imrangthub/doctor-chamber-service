package com.madbarsoft.doctorchamber.setup.head;

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
public class HeadRepository extends BaseRepository {

	public Response save(HeadEntity reqObj) {
		return baseOnlySave(reqObj);
	}

	
	public Response update(HeadEntity reqObj) {
		HeadEntity obj = findById(reqObj.getId());
		if (obj != null) {
			obj.setHeadName(reqObj.getHeadName());
			obj.setHeadNamePrint(reqObj.getHeadNamePrint());
			obj.setIsPrintable(reqObj.getIsPrintable());
			obj.setDoctorNo(reqObj.getDoctorNo());
			return baseUpdate(obj);
		}
		return getErrorResponse("Record not Found !!");

	}
	
	public Response saveOrupdate(HeadEntity reqObj) {

	  Response findResponse = baseSingleObject(criteriaQuery(reqObj));
	  HeadEntity obj = null;
	   if(findResponse.isSuccess() && findResponse.getObj() !=null) {
		   obj = getValueFromObject(findResponse.getObj(),HeadEntity.class);
	     }

		if (obj != null) {
			obj.setHeadName(reqObj.getHeadName());
			obj.setHeadNamePrint(reqObj.getHeadName());
			obj.setIsPrintable(reqObj.getIsPrintable());
			obj.setDoctorNo(reqObj.getDoctorNo());
			return baseUpdate(obj);
		}else {
			return save(reqObj);
		}

	}

	public Response detele(Long id) {
		HeadEntity obj = findById(id);
		return baseDelete(obj);
	}

	public Response remove(Long id) {
		HeadEntity obj = findById(id);
		obj.setActiveStatus(3);
		return baseRemove(obj);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {

		String doctorNo = request.getParameter("doctorNo");
		DataTableResults<HeadEntity> dataTableResults = null;
		Response response = new Response();

		HeadEntity headEntity = new HeadEntity();

		if (!doctorNo.isEmpty()) {
			headEntity.setDoctorNo(Long.parseLong(doctorNo));
		}

		DataTableRequest dataTableInRQ = new DataTableRequest(request);

		Long totalRowCount = totalCount(headEntity);

		List gridList = new ArrayList<>();

		response = baseList(typedQuery(headEntity, dataTableInRQ));

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

	public Response listByDoctorNo(HeadEntity obj) {
		return baseList(criteriaQuery(obj));
	}

	public Response listByDoctorNo(Long doctorNo) {
		HeadEntity headEntity = new HeadEntity();
		headEntity.setDoctorNo(doctorNo);
		return baseList(criteriaQuery(headEntity));
	}
	
	public HeadEntity findById(Long id) {
		HeadEntity obj = new HeadEntity();
		obj.setId(id);
		Response response = baseFindById(criteriaQuery(obj));
		if (response.isSuccess()) {
			return (HeadEntity) response.getObj();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(HeadEntity filter) {
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
	private <T> TypedQuery typedQuery(HeadEntity filter, DataTableRequest<T> dataTableInRQ) {
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

	private Long totalCount(HeadEntity filter) {

		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<HeadEntity> root = from(HeadEntity.class, criteriaQuery);

		return totalCount(builder, criteriaQuery, root, criteriaCodtion(filter, builder, root));

	}

	@SuppressWarnings({ "unchecked" })
	private List<Predicate> criteriaCodtion(HeadEntity filter, CriteriaBuilder builder, Root<HeadEntity> root) {

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
			if (filter.getHeadName() != null && !filter.getHeadName().isEmpty()) {
				Predicate condition = builder.like(root.get("headName"), filter.getHeadName());
				p.add(condition);
			}
			if (filter.getHeadNamePrint() != null && !filter.getHeadNamePrint().isEmpty()) {
				Predicate condition = builder.like(root.get("headNamePrint"), filter.getHeadNamePrint());
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
		initEntityManagerBuilderCriteriaQueryRoot(HeadEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}

}

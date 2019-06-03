package com.madbarsoft.doctorchamber.app_user;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.pagination.DataTableRequest;
import com.madbarsoft.doctorchamber.pagination.DataTableResults;
import com.madbarsoft.doctorchamber.pagination.PaginationCriteria;
import com.madbarsoft.doctorchamber.util.AppUtil;
import com.madbarsoft.doctorchamber.util.CommonUtils;
import com.madbarsoft.doctorchamber.util.Def;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class AppUserRepository extends BaseRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(AppUserRepository.class);
	
	
	public Response list(AppUserEntity obj) {
		return baseList(criteriaQuery(obj));
	}
	
	public AppUserEntity findById(Long id) {
		AppUserEntity obj = new AppUserEntity();
		obj.setId(id);
		Response response = baseFindById(criteriaQuery(obj));
		if (response.isSuccess()) {
			return (AppUserEntity) response.getObj();
		}
		return null;
	}
	
	public AppUserEntity findByUserNo(Long userNo) {
		AppUserEntity obj = new AppUserEntity();
		obj.setUserNo(userNo);
		Response response = baseSingleObject(criteriaQuery(obj));
		if (response.isSuccess()) {
			return (AppUserEntity) response.getObj();
		}
		return null;
	}
	
	public AppUserEntity findByUserId(String userId) {
		AppUserEntity obj = new AppUserEntity();
		obj.setUserId(userId);
		Response response = baseSingleObject(criteriaQuery(obj));
		if (response.isSuccess()) {
			return (AppUserEntity) response.getObj();
		}
		return null;
	}
	

	public Response save(AppUserEntity reqObj) {
		return baseOnlySave(reqObj);
	}

//	public Response update(String reqObj) {
//		JSONObject jsonObj = Def.getJSONObject(reqObj);
//		AppUserEntity doctorWisePscripEntity = (AppUserEntity)objectMapperReadValue(jsonObj.toString(), AppUserEntity.class);
//		AppUserEntity obj = findByDoctorId(doctorWisePscripEntity.getDoctorId());
//		if (obj != null) {
//			obj.setDoctorNo(doctorWisePscripEntity.getDoctorNo());
//			obj.setDoctorId(doctorWisePscripEntity.getDoctorId());
//			obj.setIsEnable(doctorWisePscripEntity.getIsEnable());
//			obj.setPresReportEntity(doctorWisePscripEntity.getPresReportEntity());
//			obj.setPresFormEntity(doctorWisePscripEntity.getPresFormEntity());
//			return baseUpdate(obj);
//		}else {
//			return baseOnlySave(doctorWisePscripEntity);
//		}
//
//	}

	public Response detele(Long id) {
		AppUserEntity obj = findById(id);
		return baseDelete(obj);
	}

	public Response remove(Long id) {
		AppUserEntity obj = findById(id);
		obj.setActiveStatus(3);
		return baseRemove(obj);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(AppUserEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(AppUserEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;

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
	private List<Predicate> criteriaCodtion(AppUserEntity filter, CriteriaBuilder builder, Root<AppUserEntity> root) {

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
			if (filter.getUserNo() != null && filter.getUserNo() > 0) {
				Predicate condition = builder.equal(root.get("userNo"), filter.getUserNo());
				p.add(condition);
			}
			if (filter.getUserId() != null && !filter.getUserId().isEmpty()) {
				Predicate condition = builder.equal(root.get("userId"), filter.getUserId());
				p.add(condition);
			}
		}

		return p;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	private TypedQuery typedQuery(AppUserEntity filter, DataTableRequest dataTableInRQ) {
		init();
		List<Predicate> pArrayJoin = new ArrayList<Predicate>();
		List<Predicate> pconJunction = criteriaCodtion(filter, null, null);
		List<Predicate> pdisJunction = filterDisjunction(dataTableInRQ);
		Predicate predicateAND = null;
		Predicate predicateOR = null;

		if (!CollectionUtils.isEmpty(pconJunction)) {
			Predicate[] pArray = pconJunction.toArray(new Predicate[] {});
			predicateAND = builder.and(pArray);
		}
		if (!CollectionUtils.isEmpty(pdisJunction)) {
			Predicate[] pArray = pdisJunction.toArray(new Predicate[] {});
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

	@SuppressWarnings("unused")
	private Long totalCount(AppUserEntity filter) {
		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<AppUserEntity> root = from(AppUserEntity.class, criteriaQuery);
		return totalCount(builder, criteriaQuery, root, criteriaCodtion(filter, builder, root), null);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<Predicate> filterDisjunction(DataTableRequest dataTableInRQ) {
		PaginationCriteria paginationCriteria = dataTableInRQ.getPaginationRequest();
		paginationCriteria.getFilterBy().getMapOfFilters();
		List<Predicate> p = new ArrayList<Predicate>();
		if (!paginationCriteria.isFilterByEmpty()) {
			Iterator<Entry<String, String>> fbit = paginationCriteria.getFilterBy().getMapOfFilters().entrySet()
					.iterator();

			while (fbit.hasNext()) {
				Map.Entry<String, String> pair = fbit.next();
				p.add(builder.like(root.get(pair.getKey()),
						CommonUtils.PERCENTAGE_SIGN + pair.getValue() + CommonUtils.PERCENTAGE_SIGN));
			}

		}
		return p;
	}
	
	@SuppressWarnings({ "unused", "rawtypes" })
	private void init() {
		initEntityManagerBuilderCriteriaQueryRoot(AppUserEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}
	
	private boolean isThere(ResultSet rs, String column)
	{
	  try
	  {
	    rs.findColumn(column);
	    return true;
	  } catch (SQLException sqlex)
	  {
	    logger.debug("column doesn't exist {}", column);
	  }
	  return false;
	}
	

}

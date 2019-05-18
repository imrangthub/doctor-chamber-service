package com.madbarsoft.doctorchamber.doctorWisePscrip;


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
public class DoctorWisePscripRepository extends BaseRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(DoctorWisePscripRepository.class);
	

	
	public Response docotorById(String doctorId) {
		String query = DoctorWisePscripStatement.findByDocotId(doctorId);
		Response response = new Response();
		List<DoctorWisePscripDto> doctorWisePscripDtoList = new ArrayList<DoctorWisePscripDto>();
		  
		  doctorWisePscripDtoList = doctorDto(query);
		  if(doctorWisePscripDtoList.size()>0) {
			  response.setObj(doctorWisePscripDtoList.get(0));
			  return getSuccessResponse("Data found", response);
		  }
		  return getErrorResponse("Data Not found");
	}
	
	public Response docotorByNo(Long doctorNo) {
		String query = DoctorWisePscripStatement.findByDocotNo(doctorNo);
		Response response = new Response();
		List<DoctorWisePscripDto> doctorWisePscripDtoList = new ArrayList<DoctorWisePscripDto>();
		  
		  doctorWisePscripDtoList = doctorDto(query);
		  if(doctorWisePscripDtoList.size()>0) {
			  response.setObj(doctorWisePscripDtoList.get(0));
			  return getSuccessResponse("Data found", response);
		  }
		  return getErrorResponse("Data Not found");
	}
	
	public Response doctorList(String params) {
		String query = DoctorWisePscripStatement.doctorList();
		Response response = new Response();
		List<DoctorWisePscripDto> doctorWisePscripDtoList = new ArrayList<DoctorWisePscripDto>();
		  
		  doctorWisePscripDtoList = doctorDto(query);
		  if(doctorWisePscripDtoList.size()>0) {
			  response.setItems(doctorWisePscripDtoList);
			  return getSuccessResponse("Data found", response);
		  }
		  return getErrorResponse("Data Not found");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {
		
	    DataTableRequest dataTableInRQ = new DataTableRequest(request);
		PaginationCriteria pagination = dataTableInRQ.getPaginationRequest();
		String paginatedQuery = AppUtil.oracleBuildPaginatedQuery(DoctorWisePscripStatement.doctor_wise_pscrip_web_v_grid(), pagination);
		Response response = new Response();
		
		  List<DoctorWisePscripDto> doctorWisePscripDtoList = new ArrayList<DoctorWisePscripDto>();
		  
		  doctorWisePscripDtoList = doctorDto(paginatedQuery);
		  
		logger.info(" doctorWisePscrip gridList update successfully");
		
		long totalRecord = 0;
		if(doctorWisePscripDtoList !=null && doctorWisePscripDtoList.size() > 0) {
			totalRecord = doctorWisePscripDtoList.get(0).getTotalRecord();
		}
		DataTableResults dtr = dataTableResults(dataTableInRQ,doctorWisePscripDtoList,doctorWisePscripDtoList,totalRecord);
		
		response.setObj(dtr);
		
        
        return getSuccessResponse("Work List Found",response);
    }
	
	
	private  List<DoctorWisePscripDto> doctorDto(String paginatedQuery) {
		  Connection con = null;
		  ResultSet rs = null;
		  Statement stm = null;
		  Long totalRecord = 0l;
		  
		  List<DoctorWisePscripDto> doctorWisePscripDtoList = new ArrayList<DoctorWisePscripDto>();
		
		try {
			 con = getOraConnection();
			 stm  = con.createStatement();
		     rs = stm.executeQuery(paginatedQuery);
		     boolean isColumnIsChecked = false;
		     boolean isThere = false;
		     
		    
		    while(rs.next()) {
		    	
		    	DoctorWisePscripDto obj = new DoctorWisePscripDto();
		    	if(!isColumnIsChecked) { 
		    		isThere = isThere(rs, "total_records");
		    		isColumnIsChecked = true;
		    		}
		    	
		    	if(isThere) {
			    	totalRecord = rs.getLong("total_records");
			    	obj.setTotalRecord(totalRecord);	    	
		    	}
		    	
		    	obj.setDoctorNo(rs.getLong("doctorNo"));
		    	obj.setDoctorId(rs.getString("doctorId"));
		    	obj.setDoctorName(rs.getString("doctorName"));
		    	obj.setDpecialization(rs.getString("dpecialization"));
		    	doctorWisePscripDtoList.add(obj);
		    	
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			finalyConStmRs(con, stm, rs);	

		}
		
		return doctorWisePscripDtoList;
		
	}
	
	public Response list(DoctorWisePscripEntity obj) {
		return baseList(criteriaQuery(obj));
	}
	
	public DoctorWisePscripEntity findById(Long id) {
		DoctorWisePscripEntity obj = new DoctorWisePscripEntity();
		obj.setId(id);
		Response response = baseFindById(criteriaQuery(obj));
		if (response.isSuccess()) {
			return (DoctorWisePscripEntity) response.getObj();
		}
		return null;
	}
	
	public DoctorWisePscripEntity findbyDoctorNo(Long doctorNo) {
		DoctorWisePscripEntity obj = new DoctorWisePscripEntity();
		obj.setDoctorNo(doctorNo);
		Response response = baseFindById(criteriaQuery(obj));
		if (response.isSuccess()) {
			return (DoctorWisePscripEntity) response.getObj();
		}
		return null;
	}
	
	public DoctorWisePscripEntity findByDoctorId(String doctorId) {
		DoctorWisePscripEntity obj = new DoctorWisePscripEntity();
		obj.setDoctorId(doctorId);
		Response response = baseFindById(criteriaQuery(obj));
		if (response.isSuccess()) {
			return (DoctorWisePscripEntity) response.getObj();
		}
		return null;
	}

	public Response save(DoctorWisePscripEntity reqObj) {
		return baseOnlySave(reqObj);
	}

	public Response update(String reqObj) {
		JSONObject jsonObj = Def.getJSONObject(reqObj);
		DoctorWisePscripEntity doctorWisePscripEntity = (DoctorWisePscripEntity)objectMapperReadValue(jsonObj.toString(), DoctorWisePscripEntity.class);
		DoctorWisePscripEntity obj = findByDoctorId(doctorWisePscripEntity.getDoctorId());
		if (obj != null) {
			obj.setDoctorNo(doctorWisePscripEntity.getDoctorNo());
			obj.setDoctorId(doctorWisePscripEntity.getDoctorId());
			obj.setIsEnable(doctorWisePscripEntity.getIsEnable());
			obj.setPresReportEntity(doctorWisePscripEntity.getPresReportEntity());
			obj.setPresFormEntity(doctorWisePscripEntity.getPresFormEntity());
			return baseUpdate(obj);
		}else {
			return baseOnlySave(doctorWisePscripEntity);
		}

	}

	public Response detele(Long id) {
		DoctorWisePscripEntity obj = findById(id);
		return baseDelete(obj);
	}

	public Response remove(Long id) {
		DoctorWisePscripEntity obj = findById(id);
		obj.setActiveStatus(3);
		return baseRemove(obj);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(DoctorWisePscripEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(DoctorWisePscripEntity.class);
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
	private List<Predicate> criteriaCodtion(DoctorWisePscripEntity filter, CriteriaBuilder builder, Root<DoctorWisePscripEntity> root) {

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
			if (filter.getDoctorId() != null && !filter.getDoctorId().isEmpty()) {
				Predicate condition = builder.equal(root.get("doctorId"), filter.getDoctorId());
				p.add(condition);
			}
			if (filter.getDoctorNo() != null && filter.getDoctorNo()>0) {
				Predicate condition = builder.equal(root.get("doctorNo"), filter.getDoctorNo());
				p.add(condition);
			}
		}

		return p;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	private TypedQuery typedQuery(DoctorWisePscripEntity filter, DataTableRequest dataTableInRQ) {
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
	private Long totalCount(DoctorWisePscripEntity filter) {
		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<DoctorWisePscripEntity> root = from(DoctorWisePscripEntity.class, criteriaQuery);
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
		initEntityManagerBuilderCriteriaQueryRoot(DoctorWisePscripEntity.class);
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

package com.madbarsoft.core.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.jpa.QueryHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.CollectionUtils;

import com.madbarsoft.core.pagination.DataTableRequest;
import com.madbarsoft.core.pagination.PaginationCriteria;
import com.madbarsoft.core.util.CommonFunctions;
import com.madbarsoft.core.util.CommonUtils;
import com.madbarsoft.core.util.Response;



public class BaseRepository implements CommonFunctions {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private Environment env;

	public CriteriaBuilder builder = null;
	public CriteriaQuery criteria = null;
	public Root root = null;

	/*
	 * public BaseRepository(Class clazz) {
	 * 
	 * this.builder = entityManager.getCriteriaBuilder(); this.criteria =
	 * builder.createQuery(clazz); this.root = criteria.from(clazz); }
	 */

	public Response baseOnlySave(Object obj) {
		Response response = new Response();
		try {
			entityManager.persist(obj);
			return getSuccessResponse("Save Successfully", response);
		} catch (Exception e) {
			// TODO: handle exception
			return getErrorResponse("Save fail !!");
		}

	}

	public Response baseSaveOrUpdate(Object obj) {
		Response response = new Response();
		try {
			response.setObj(entityManager.merge(obj));
			return getSuccessResponse("Update Successfully", response);
		} catch (Exception e) {
			// TODO: handle exception
			return getErrorResponse("Save fail !!");
		}

	}

	public Response baseUpdate(Object obj) {

		try {
			entityManager.merge(obj);
			return getSuccessResponse("Update Successfully");
		} catch (Exception e) {
			// TODO: handle exception
			return getErrorResponse("Update fail !!");
		}

	}

	public Response baseRemove(Object obj) {

		try {
			entityManager.merge(obj);
			return getSuccessResponse("Remove Successfully");
		} catch (Exception e) {
			// TODO: handle exception
			return getErrorResponse("Update fail !!");
		}

	}

	public Response baseDelete(Object obj) {
		try {
			entityManager.remove(obj);
			return getSuccessResponse("Delete Successfully");
		} catch (Exception e) {
			return getErrorResponse("Delete fail !!");
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response baseList(CriteriaQuery criteria) {
		Response response = new Response();
		List list = null;
		try {
			list = entityManager.createQuery(criteria).setHint(QueryHints.HINT_READONLY, true).getResultList();
			if (list.size() > 0) {
				response.setItems(list);
				return getSuccessResponse("Data found ", response);
			}
			return getSuccessResponse("Data Empty ");
		} catch (Exception e) {
			// TODO: handle exception
			return getErrorResponse("Data not found !!");
		}

	}

	@SuppressWarnings({ "rawtypes" })
	public Response baseList(TypedQuery typedQuery) {
		Response response = new Response();
		List list = null;

		try {

			list = typedQuery.setHint(QueryHints.HINT_READONLY, true).getResultList();

			if (list.size() > 0) {

				response.setItems(list);
				return getSuccessResponse("Data found ", response);
			}

			return getSuccessResponse("Data Empty ");

		} catch (Exception e) {
			// TODO: handle exception
			return getErrorResponse("Data not found !!");
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response baseFindById(CriteriaQuery criteria) {
		Response response = new Response();
		Object obj = null;
		try {
			obj = entityManager.createQuery(criteria).getSingleResult();
			response.setObj(obj);
			return getSuccessResponse("find data Successfully", response);
		} catch (Exception e) {
			// TODO: handle exception
			return getErrorResponse("Data not Found !!");
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> TypedQuery baseTypedQuery(CriteriaQuery criteria, DataTableRequest dataTableInRQ) {

		CriteriaQuery<T> select = criteria.select(root);
		TypedQuery<T> typedQuery = entityManager.createQuery(select);
		typedQuery.setFirstResult(dataTableInRQ.getStart());
		typedQuery.setMaxResults(dataTableInRQ.getLength());
		return typedQuery;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response getListFindById(CriteriaQuery criteria) {
		Response response = new Response();
		Object obj = null;
		try {
			obj = entityManager.createQuery(criteria).getResultList();
			response.setItems((List) obj);
			return getSuccessResponse("find data Successfully", response);
		} catch (Exception e) {
			// TODO: handle exception
			return getErrorResponse("Data not Found !!");
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> entityManagerBuilderCriteriaQueryRoot(Class clazz) {

		Map<String, Object> entityManagerParams = new HashMap<String, Object>();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery criteria = builder.createQuery(clazz);
		entityManagerParams.put("builder", builder);
		entityManagerParams.put("criteria", criteria);
		entityManagerParams.put("root", root);

		return entityManagerParams;

	}

	@SuppressWarnings({ "rawtypes" })
	public void initEntityManagerBuilderCriteriaQueryRoot(Class clazz) {
		criteriaRoot(clazz);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Root criteriaRoot(Class clazz) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery criteria = builder.createQuery(clazz);
		Root root = criteria.from(clazz);
		this.builder = builder;
		this.criteria = criteria;
		this.root = root;

		return root;
	}

	public <T> void totalCriteriaQuery(Class<T> clazz) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<T> root = criteria.from(clazz);

		this.builder = builder;
		this.criteria = criteria;
		this.root = root;

	}

	public CriteriaBuilder criteriaBuilder() {
		return entityManager.getCriteriaBuilder();
	}

	public CriteriaQuery<Long> longCriteriaQuery(CriteriaBuilder builder) {
		return builder.createQuery(Long.class);
	}

	public <T> Root<T> from(Class<T> clazz, CriteriaQuery<Long> criteria) {
		return criteria.from(clazz);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Root LongCriteriaQuery(Class clazz) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root root = criteria.from(clazz);
		this.builder = builder;
		this.criteria = criteria;
		this.root = root;
		return root;

	}

	/*
	 * @SuppressWarnings({ "rawtypes", "unchecked" }) public <T> Long
	 * totalCount(Class<T> clazz) {
	 * 
	 * CriteriaBuilder builder = entityManager.getCriteriaBuilder(); CriteriaQuery
	 * criteria = builder.createQuery(Long.class);
	 * criteria.select(builder.count(criteria.from(clazz))); Long totalRowCount =
	 * (Long)entityManager.createQuery(criteria).getSingleResult();
	 * 
	 * return totalRowCount;
	 * 
	 * }
	 */

	public <T> String criteriaQuery(Class<T> clazz) {
		CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(clazz);
		Root<T> root = criteriaQuery.from(clazz);
		return criteriaQuery.select(root).toString();
	}

	public <T> void limitedCriteriaQuer(Class clazz) {
		Query limitedCriteriaQuery = entityManager.createQuery(criteriaQuery(clazz)).setFirstResult(0)
				.setMaxResults(10);
		// return limitedCriteriaQuery.getResultList();
	}

	/*
	 * public <T> Long totalCount(CriteriaBuilder builder, CriteriaQuery<Long>
	 * criteria, List<Predicate> p) {
	 * 
	 * //CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	 * //CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
	 * 
	 * // criteria.select(builder.count(criteria.from(clazz)));
	 * 
	 * if (!CollectionUtils.isEmpty(p)) {
	 * 
	 * Predicate[] pArray = p.toArray(new Predicate[] {}); Predicate predicate =
	 * builder.and(pArray); criteria.where(predicate); }
	 * 
	 * 
	 * Long totalRowCount = entityManager.createQuery(criteria).getSingleResult();
	 * 
	 * return totalRowCount;
	 * 
	 * }
	 */

	public <T> Long totalCount(Class<T> clazz, List<Predicate> p) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

		criteria.select(builder.count(criteria.from(clazz)));

		/*
		 * if (!CollectionUtils.isEmpty(p)) {
		 * 
		 * Predicate[] pArray = p.toArray(new Predicate[] {}); Predicate predicate =
		 * builder.and(pArray); criteria.where(predicate); }
		 */

		Long totalRowCount = entityManager.createQuery(criteria).getSingleResult();

		return totalRowCount;

	}

	public <T> Long totalCount(CriteriaBuilder builder, CriteriaQuery<Long> criteria, Root<T> root,
			List<Predicate> pConjunction) {

		criteria.select(builder.count(root));

		if (!CollectionUtils.isEmpty(pConjunction)) {
			Predicate[] pArray = pConjunction.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}

		Long totalRowCount = entityManager.createQuery(criteria).getSingleResult();

		return totalRowCount;

	}

	public <T> Long totalCount(CriteriaBuilder builder, CriteriaQuery<Long> criteria, Root<T> root,
			List<Predicate> pConjunction, List<Predicate> pDisjunction) {

		criteria.select(builder.count(root));

		if (!CollectionUtils.isEmpty(pConjunction)) {
			Predicate[] pArray = pConjunction.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}

		if (!CollectionUtils.isEmpty(pDisjunction)) {
			Predicate[] pArray = pDisjunction.toArray(new Predicate[] {});
			Predicate predicate = builder.or(pArray);
			criteria.where(predicate);
		}

		Long totalRowCount = entityManager.createQuery(criteria).getSingleResult();

		return totalRowCount;

	}

	public <T> List<Predicate> dataTablefilter(DataTableRequest<T> dataTableInRQ) {

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

	public Connection getOraConnection() {

		try {

			Class.forName(env.getProperty("ora.driver"));

		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");

		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(env.getProperty("ora.url"), env.getProperty("ora.user"),
					env.getProperty("ora.password"));

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
		}
		if (connection != null) {
			return connection;
		} else {
			System.out.println("Failed to make connection!");
			return null;
		}
	}

	public void finalyConStmRs(Connection con, Statement stm, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void finalyConPstmRs(Connection con, PreparedStatement pstm, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void finalyStmRs(Statement stm, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				rs.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public <T> List globalCtriteria(Conjunction objConjunction,Disjunction
	 * objDisjunction, Class<T> clazz, Predicate predicate) { Session sessoin =
	 * sessionFactory.getCurrentSession(); Criteria criteria1 =
	 * sessoin.createCriteria(clazz); if(objConjunction != null) {
	 * criteria1.add(objConjunction); } if(objDisjunction !=null) {
	 * criteria1.add(objDisjunction); }
	 * 
	 * 
	 * CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
	 * 
	 * //Create Criteria CriteriaQuery<T> criteria = builder.createQuery(clazz);
	 * Root<T> contactRoot = criteria.from(clazz);
	 * criteria.select(contactRoot).where(predicate);
	 * 
	 * 
	 * 
	 * //Use criteria to query with session to fetch all contacts List<T> contacts =
	 * sessionFactory.createQuery(criteria).getResultList();
	 * 
	 * Predicate likeRestriction = builder.and( builder.li(
	 * myObjectRoot.get("name"), "%string1"), builder.notLike(
	 * myObjectRoot.get("name"), "%string2") );
	 * 
	 * 
	 * return null; }
	 */
}

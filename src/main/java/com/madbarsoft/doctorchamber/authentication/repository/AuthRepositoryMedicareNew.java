package com.madbarsoft.doctorchamber.authentication.repository;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.hql.internal.ast.tree.BooleanLiteralNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madbarsoft.doctorchamber.authentication.UserEntity;
import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.doctorWisePscrip.DoctorWisePscripEntity;
import com.madbarsoft.doctorchamber.doctorWisePscrip.DoctorWisePscripService;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class AuthRepositoryMedicareNew extends BaseRepository {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	private DoctorWisePscripService doctorWisePscripService;

	public static Connection con;
	
	
	
	public Response login(UserEntity user) {
		if(user.getUserName() == null && user.getPassword() == null) {
			return getErrorResponse("User or Password not found !");
		}

		Response response = new Response();
		Map<String, Object> param = new HashMap<>();
		
			if (checkPassword(user.getUserName(), user.getPassword())) {
				int doctorFlag = 1;

				param.put("empName", "MD IMRAN HOSSAIN");
				param.put("userNo", 12121);
				param.put("isDoctor", doctorFlag);
				param.put("reportLink", "2");
				param.put("formLink", "homeTwo");
				response.setModel(param);
				System.out.println("Login Successfully complete");
				
				return getSuccessResponse("login successfully", response);

			}else {
				return getErrorResponse("Login fail...!");
			}

	}
	
	
	

//	public Response login(UserEntity user) {
//
//		Response response = new Response();
//		Map<String, Object> param = new HashMap<>();
//		try {
//			con = getOraConnection();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//		try {
//			Object checkPass = checkPassword(user.getUserName(), user.getPassword());
//			if (checkPass.equals("OK")) {
//				int doctorFlag = 0;
//				BigDecimal userNo = getUserNo(user.getUserName());
//				Map<String, Object> doctorInfo = getDoctorNo(userNo);
//				List<Map<String, Object>> companyList = getPriviledgeCompany(userNo);
//
//				if ((Integer) doctorInfo.get("doctorNo") != null && (Integer) doctorInfo.get("doctorNo") != 0) {
//					userNo = BigDecimal.valueOf((Integer) doctorInfo.get("doctorNo"));
//					doctorFlag = 1;
//				}
//				DoctorWisePscripEntity doctorWisePscripEntity = doctorWisePscripService
//						.findbyDoctorNo(userNo.longValue());
//				param.put("empName", doctorInfo.get("empName"));
//				param.put("companyList", companyList);
//				param.put("userNo", userNo);
//				param.put("isDoctor", doctorFlag);
//				if (doctorWisePscripEntity != null) {
//					param.put("reportLink", doctorWisePscripEntity.getPresReportEntity().getReportLink());
//					param.put("formLink", doctorWisePscripEntity.getPresFormEntity().getFormLink());
//				} else {
//					param.put("reportLink", "1");
//					param.put("formLink", "homeOne");
//				}
//				response.setModel(param);
//				return getSuccessResponse("login successfully", response);
//			} else {
//				return getErrorResponse("User Name or Password does Not Match");
//			}
//		} catch (Exception ex) {
//
//			return getErrorResponse(ex.getMessage());
//		}
//
//	}

	public Response oncologyLogin(UserEntity user) {
		Response response = new Response();
		Map<String, Object> paramMap = new HashMap<>();
		try {
			con = getOraConnection();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Object checkPass = checkPassword(user.getUserName(), user.getPassword());
			if (checkPass.equals("OK")) {
				int doctorFlag = 0;
				BigDecimal userNo = getUserNo(user.getUserName());
				Map<String, Object> doctorInfo = getDoctorNo(userNo);
				List<Map<String, Object>> companyList = getPriviledgeCompany(userNo);
				
				if ((Integer) doctorInfo.get("doctorNo") != null && (Integer) doctorInfo.get("doctorNo") != 0) {
					userNo = BigDecimal.valueOf((Integer) doctorInfo.get("doctorNo"));
					doctorFlag = 1;
				}
				paramMap.put("empName", doctorInfo.get("empName"));
				paramMap.put("companyList", companyList);
				paramMap.put("userNo", userNo);
				paramMap.put("userName", user.getUserName());
				paramMap.put("api", "oncology");
				paramMap.put("isDoctor", doctorFlag);
				response.setModel(paramMap);
				LOGGER.debug("Oncology login response : " + response);
				return getSuccessResponse("login successfully", response);
			} else {
				return getErrorResponse("User Name or Password does Not Match");
			}
		} catch (Exception ex) {
			return getErrorResponse(ex.getMessage());
		}

	}

	public boolean checkPassword(String username, String password) {
        if(username.equals("imran") && password.equals("123")) {
        	return true;
        }
		return false;
	}

	public BigDecimal getUserNo(String userName) throws SQLException {
		String call = "BEGIN ? := PK_SECURITY.PKFD_GETUSERNO(?); END;";
		CallableStatement cstmt = con.prepareCall(call);
		cstmt.registerOutParameter(1, Types.BIGINT);
		cstmt.setString(2, userName);
		cstmt.executeUpdate();
		BigDecimal userNo = cstmt.getBigDecimal(1);
		return userNo;
	}

	public Map<String, Object> getDoctorNo(BigDecimal userNo) throws SQLException {
		Map<String, Object> paramMap = new HashMap<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select emp_no, doctor_no, emp_name ");
		sql.append("from hr_emp ");
		sql.append("where emp_no = ");
		sql.append(userNo);

		Statement stmt = null;
		String query = sql.toString();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				paramMap.put("userNo", rs.getInt("emp_no"));
				paramMap.put("doctorNo", rs.getInt("doctor_no"));
				paramMap.put("empName", rs.getString("emp_name"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return paramMap;
	}

	public List<Map<String, Object>> getPriviledgeCompany(BigDecimal userNo) throws SQLException {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select g.company_no, s.company_name, nvl(g.default_flag,0) ");
		sql.append(" default_og, nvl(g.all_company_no,0) all_company_no, g.user_no ");
		sql.append(" from sa_grantcompany g, sa_company s ");
		sql.append(" where g.company_no (+) = s.company_no ");
		sql.append(" and nvl(s.com_con_flag,0) = 1 and g.user_no = ");
		sql.append(userNo);

		Statement stmt = null;
		String query = sql.toString();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				paramMap.put("COMPANY_NAME", rs.getString("COMPANY_NAME"));
				paramMap.put("COMPANY_NO", rs.getInt("COMPANY_NO"));
				paramMap.put("DEFAULT_OG", rs.getInt("DEFAULT_OG"));
				paramMap.put("ALL_COMPANY_NO", rs.getInt("ALL_COMPANY_NO"));
				paramMap.put("USER_NO", rs.getInt("USER_NO"));
				list.add(paramMap);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return list;
	}
}

package com.madbarsoft.doctorchamber.authentication;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.doctorWisePscrip.DoctorWisePscripEntity;
import com.madbarsoft.doctorchamber.doctorWisePscrip.DoctorWisePscripService;
import com.madbarsoft.doctorchamber.userPreferences.UserPreferencesService;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class AuthRepository extends BaseRepository {
	
	@Autowired
	private DoctorWisePscripService doctorWisePscripService;
	
	@Autowired
	private UserPreferencesService userPreferencesService;

	public static Connection con;

	public Response login(UserEntity user) {
		Response response = new Response();
		Map<String, Object> param = new HashMap<>();
		try {
			con = getOraConnection();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Object checkPass = checkPassword(user.getUserName(), user.getPassword());
			if (checkPass.equals("OK")) {
				BigDecimal userNo = getUserNo(user.getUserName());
				DoctorWisePscripEntity doctorWisePscripEntity = doctorWisePscripService.findbyDoctorNo(userNo.longValue());
				List<Map<String, Object>> companyList = getPriviledgeCompany(userNo);
				param.put("companyList", companyList);
				param.put("userNo", userNo);
				param.put("userName", user.getUserName());
				if(doctorWisePscripEntity != null) {
					param.put("reportLink", doctorWisePscripEntity.getPresReportEntity().getReportLink());
					param.put("formLink", doctorWisePscripEntity.getPresFormEntity().getFormLink());
				}else {
					param.put("reportLink", "1");
					param.put("formLink", "homeOne");
				}
				response.setModel(param);
				return getSuccessResponse("login successfully", response);
			} else {
				return getErrorResponse("User Name or Password does Not Match");
			}
		} catch (Exception ex) {

			return getErrorResponse(ex.getMessage());
		}

	}

	public Object checkPassword(String username, String passsword) throws SQLException {
		String call = "BEGIN ? := PK_SECURITY.PKFD_CHKPASSWORD( ?,?); END;";
		CallableStatement cstmt = con.prepareCall(call);
		cstmt.registerOutParameter(1, Types.VARCHAR);
		cstmt.setString(2, username);
		cstmt.setString(3, passsword);
		cstmt.executeUpdate();
		String message = cstmt.getString(1);
		return message;
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

	public List<Map<String, Object>> getPriviledgeCompany(BigDecimal userNo) throws SQLException {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select g.company_no, s.company_name, nvl(g.default_og,0) ");
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

package com.madbarsoft.doctorchamber.consultation.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.consultation.ConsultantEntity;
import com.madbarsoft.doctorchamber.consultation.ConsultationEntity;
import com.madbarsoft.doctorchamber.consultation.statement.ConsultationStatementMedicareLive;
import com.madbarsoft.doctorchamber.consultation.statement.ConsultationStatementMedicareNew;
import com.madbarsoft.doctorchamber.pagination.DataTableRequest;
import com.madbarsoft.doctorchamber.pagination.DataTableResults;
import com.madbarsoft.doctorchamber.pagination.PaginationCriteria;
import com.madbarsoft.doctorchamber.util.AppUtil;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class ConsultationRepositoryMedicareLive extends BaseRepository {
	private static final Logger logger = LoggerFactory.getLogger(ConsultationRepositoryMedicareLive.class);
	@Autowired
	ConsultationStatementMedicareNew consulationStatement;

	public Response save(ConsultationEntity reqObj) {
		return baseOnlySave(reqObj);
	}

	public Response update(ConsultationEntity reqObj) {
		ConsultationEntity obj = findById(reqObj.getId());

		if (obj != null) {

			return baseUpdate(obj);

		}

		return getErrorResponse("Record not Found !!");

	}

	public Response detele(Long id) {
		ConsultationEntity brand = findById(id);
		return baseDelete(brand);
	}

	public Response remove(Long id) {
		ConsultationEntity brand = findById(id);
		return baseRemove(brand);
	}

	private Map<String, String> parseData(Map<String, String> queryMap) {

		if (queryMap.containsKey("fromDate") && queryMap.containsKey("toDate")) {
			queryMap.put("fromDate",
					dateFormat(deateParse(queryMap.get("fromDate"), "E MMM dd yyyy HH:mm:ss 'GMT'z"), "dd/MM/yyyy"));
			queryMap.put("toDate",
					dateFormat(deateParse(queryMap.get("toDate"), "E MMM dd yyyy HH:mm:ss 'GMT'z"), "dd/MM/yyyy"));
		}
		return queryMap;
	}

	public Response listWithFilter(Map<String, String> queryMap) {

		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		List<ConsultationEntity> consulationEntityList = new ArrayList<ConsultationEntity>();
		// con = getOraConnection();

		try {

			con = getOraConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(ConsultationStatementMedicareLive.opd_consultation_web_v(queryMap));

			while (rs.next()) {
				ConsultationEntity consulationEntity = new ConsultationEntity();

				consulationEntity.setId(rs.getLong("reg_no"));
				consulationEntity.setHospitalNo(rs.getString("hospital_number"));
				consulationEntity.setDoctor_no(rs.getLong("doctor_no"));
//				consulationEntity.setConsult_in(rs.getInt("consult_in"));
//				consulationEntity.setConsult_out(rs.getInt("consult_out"));
//				consulationEntity.setShiftdtlNo(rs.getInt("shiftdtl_no"));
				consulationEntity.setConsultationNo(rs.getLong("opd_consultation_no"));
				consulationEntity.setConsultationId(rs.getString("opd_consultation_id"));
				consulationEntity.setConsultationDt(rs.getDate("consultation_dt"));
				consulationEntity
						.setConsultationDtStr(dateFormat(consulationEntity.getConsultationDt(), "dd-MMM-yyyy"));
				consulationEntity.setPatientName(rs.getString("full_name"));
				consulationEntity.setGender(rs.getString("sex"));
				consulationEntity.setAge(rs.getString("age"));
				consulationEntity.setMaritalStatus(rs.getString("m_status"));
				consulationEntity.setPhoneNo(rs.getString("mobile"));
				consulationEntity.setConsultationType(rs.getString("consult_type_no"));
				consulationEntity.setBloodGroup(rs.getString("bloodgroup"));
				consulationEntity.setDob(rs.getDate("dob"));
				consulationEntityList.add(consulationEntity);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			finalyConStmRs(con, stm, rs);
		}

		response.setItems(consulationEntityList);

		return getSuccessResponse("Work List Found", response);
	}
	
	public Response registrationListWithFilter(Map<String, String> queryMap) {

		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		List<ConsultationEntity> consulationEntityList = new ArrayList<ConsultationEntity>();
		// con = getOraConnection();

		try {

			con = getOraConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(ConsultationStatementMedicareLive.opd_registration(parseData(queryMap)));

			while (rs.next()) {
				ConsultationEntity consulationEntity = new ConsultationEntity();

				consulationEntity.setId(rs.getLong("reg_no"));
				consulationEntity.setHospitalNo(String.valueOf(rs.getLong("hospital_number")));
				consulationEntity.setPatientName(rs.getString("full_name"));
				consulationEntity.setGender(rs.getString("sex"));
				consulationEntity.setAge(rs.getString("age"));
				consulationEntity.setMaritalStatus(rs.getString("m_status"));
				consulationEntity.setPhoneNo(rs.getString("mobile"));
				consulationEntity.setBloodGroup(rs.getString("bloodgroup"));
				consulationEntityList.add(consulationEntity);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			finalyConStmRs(con, stm, rs);
		}

		response.setItems(consulationEntityList);

		return getSuccessResponse("Work List Found", response);
	}

	public Response list() {
		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		List<ConsultationEntity> consulationEntityList = new ArrayList<ConsultationEntity>();

		try {
			con = getOraConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(ConsultationStatementMedicareLive.opd_consultation_web_v());

			while (rs.next()) {
				ConsultationEntity consulationEntity = new ConsultationEntity();

				consulationEntity.setId(rs.getLong("reg_no"));
				consulationEntity.setHospitalNo(rs.getString("hospital_number"));
				consulationEntity.setDoctor_no(rs.getLong("doctor_no"));
			//	consulationEntity.setConsult_in(rs.getInt("consult_in"));
//				consulationEntity.setConsult_out(rs.getInt("consult_out"));
//				consulationEntity.setShiftdtlNo(rs.getInt("shiftdtl_no"));
				consulationEntity.setConsultationNo(rs.getLong("opd_consultation_no"));
				consulationEntity.setConsultationId(rs.getString("opd_consultation_id"));
				consulationEntity.setPatientName(rs.getString("full_name"));
				consulationEntity.setGender(rs.getString("sex"));
				consulationEntity.setAge(rs.getString("age"));
				consulationEntity.setMaritalStatus(rs.getString("m_status"));
				consulationEntity.setPhoneNo(rs.getString("mobile"));
				consulationEntity.setConsultationType(rs.getString("consult_type_no"));
				consulationEntity.setBloodGroup(rs.getString("bloodgroup"));
				consulationEntityList.add(consulationEntity);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					rs.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		response.setItems(consulationEntityList);

		return getSuccessResponse("Work List Found", response);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {

		DataTableRequest dataTableInRQ = new DataTableRequest(request);
		PaginationCriteria pagination = dataTableInRQ.getPaginationRequest();
		String paginatedQuery = AppUtil.oracleBuildPaginatedQuery(ConsultationStatementMedicareLive.opd_consultation_web_v_grid(),
				pagination);
		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		List<ConsultationEntity> consulationEntityList = new ArrayList<ConsultationEntity>();

		Long totalRecord = 0l;
		try {
			con = getOraConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(paginatedQuery);

			while (rs.next()) {
				ConsultationEntity consulationEntity = new ConsultationEntity();
				totalRecord = rs.getLong("total_records");
				consulationEntity.setTotalRecord(totalRecord);
				consulationEntity.setId(rs.getLong("reg_no"));
				consulationEntity.setHospitalNo(rs.getString("hospital_number"));
				consulationEntity.setDoctor_no(rs.getLong("doctor_no"));
//				consulationEntity.setConsult_in(rs.getInt("consult_in"));
//				consulationEntity.setShiftdtlNo(rs.getInt("shiftdtl_no"));
//				consulationEntity.setConsult_out(rs.getInt("consult_out"));
				consulationEntity.setConsultationNo(rs.getLong("opd_consultation_no"));
				consulationEntity.setConsultationId(rs.getString("opd_consultation_id"));
				consulationEntity.setPatientName(rs.getString("full_name"));
				consulationEntity.setGender(rs.getString("sex"));
				consulationEntity.setAge(rs.getString("age"));
				consulationEntity.setMaritalStatus(rs.getString("m_status"));
				consulationEntity.setPhoneNo(rs.getString("mobile"));
				consulationEntity.setConsultationType(rs.getString("consult_type_no"));
				consulationEntity.setBloodGroup(rs.getString("bloodgroup"));
				consulationEntityList.add(consulationEntity);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					rs.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		logger.info(" consultation gridList update successfully");
		DataTableResults dtr = dataTableResults(dataTableInRQ, consulationEntityList, consulationEntityList,
				totalRecord);

		response.setObj(dtr);
		return getSuccessResponse("Work List Found", response);
	}

	public ConsultationEntity findById(Long id) {

		return null;
	}

	public Response findByConsultationId(ConsultationEntity reqObj) {

		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		con = getOraConnection();

		ConsultationEntity consulationEntity = new ConsultationEntity();

		try {
			stm = con.createStatement();
			rs = stm.executeQuery(ConsultationStatementMedicareLive.opd_consultation_find_by_consultation_Id(reqObj));

			while (rs.next()) {

				consulationEntity.setId(rs.getLong("reg_no"));
				consulationEntity.setHospitalNo(rs.getString("hospital_number"));
				consulationEntity.setDoctor_no(rs.getLong("doctor_no"));
//				consulationEntity.setConsult_in(rs.getInt("consult_in"));
//				consulationEntity.setConsult_out(rs.getInt("consult_out"));
//				consulationEntity.setShiftdtlNo(rs.getInt("shiftdtl_no"));
				consulationEntity.setConsultationNo(rs.getLong("opd_consultation_no"));
				consulationEntity.setConsultationId(rs.getString("opd_consultation_id"));
				consulationEntity.setAppointmentNo(rs.getLong("appointment_no"));
				consulationEntity.setPatientName(rs.getString("full_name"));
				consulationEntity.setGender(rs.getString("sex"));
				consulationEntity.setAge(rs.getString("age"));
				consulationEntity.setMaritalStatus(rs.getString("m_status"));
				consulationEntity.setPhoneNo(rs.getString("mobile"));
				consulationEntity.setConsultationType(rs.getString("consult_type_no"));
				consulationEntity.setBloodGroup(rs.getString("bloodgroup"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			finalyConStmRs(con, stm, rs);
		}

		response.setObj(consulationEntity);

		return getSuccessResponse("Consultation Information Found", response);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(ConsultationEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(ConsultationEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;

		List<Predicate> p = new ArrayList<Predicate>();

		if (filter != null) {

		}

		if (!CollectionUtils.isEmpty(p)) {
			Predicate[] pArray = p.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}

		return criteria;

	}

	public Response findByHospitalNumber(String hnNumber) {

		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		con = getOraConnection();

		ConsultationEntity consulationEntity = new ConsultationEntity();

		try {
			stm = con.createStatement();
			rs = stm.executeQuery(ConsultationStatementMedicareLive.opd_consultation_find_by_hospital_number(hnNumber));

			while (rs.next()) {

				consulationEntity.setConsultationId(rs.getString("opd_consultation_id"));
				consulationEntity.setHospitalNo(rs.getString("hospital_number"));
				consulationEntity.setPatientName(rs.getString("full_name"));
				consulationEntity.setPhoneNo(rs.getString("mobile"));
				consulationEntity.setGender(rs.getString("sex"));
				consulationEntity.setAge(rs.getString("age"));
				consulationEntity.setDob(rs.getDate("dob"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			finalyConStmRs(con, stm, rs);
		}

		response.setObj(consulationEntity);

		return getSuccessResponse("Consultation Information Found", response);
	}

	public Response findByDoctorNo(Long doctorNo) {

		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		con = getOraConnection();

		ConsultantEntity consultantEntity = new ConsultantEntity();

		try {
			stm = con.createStatement();
			rs = stm.executeQuery(ConsultationStatementMedicareLive.hpms_emp_doctor_v_find_by_doctor_number(doctorNo));

			while (rs.next()) {

				consultantEntity.setDoctorNo(rs.getLong("doctor_no"));
				consultantEntity.setDoctorName(rs.getString("doctor_name"));
				consultantEntity.setDoctorSignature(rs.getString("doctor_signature"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			finalyConStmRs(con, stm, rs);
		}

		response.setObj(consultantEntity);

		return getSuccessResponse("Consultant Information Found", response);
	}

	public Response consltInByAppointmentNo(Long apointmentNo) {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		con = getOraConnection();

		try {

			pstm = con.prepareStatement(ConsultationStatementMedicareLive.updateOpdtConsIn());
			pstm.setBigDecimal(1, converLongTBigDecimmal(apointmentNo));
			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			finalyConPstmRs(con, pstm, rs);
		}

		return getSuccessResponse("Update opd appointmetn");

	}
	
	public Response updateByAppointmentNo(Long apointmentNo) {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		con = getOraConnection();

		try {

			pstm = con.prepareStatement(ConsultationStatementMedicareLive.updateOpdAppointment());
			pstm.setBigDecimal(1, converLongTBigDecimmal(apointmentNo));
			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			finalyConPstmRs(con, pstm, rs);
		}

		return getSuccessResponse("Update opd appointmetn");

	}

}

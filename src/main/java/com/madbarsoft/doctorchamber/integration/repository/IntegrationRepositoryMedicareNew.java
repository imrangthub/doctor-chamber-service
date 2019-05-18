package com.madbarsoft.doctorchamber.integration.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.integration.IntegrationEntity;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class IntegrationRepositoryMedicareNew extends BaseRepository {

	private static final Logger logger = LoggerFactory.getLogger(IntegrationRepositoryMedicareLive.class);
	@Autowired
	IntegrationStatementMedicareNew integrationStatement;

	public Response save(IntegrationEntity reqObj) {
		return baseOnlySave(reqObj);
	}

	public Response findByConsultationId(Long consultationNo) {

		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		List<IntegrationEntity> integrationEntityList = new ArrayList<IntegrationEntity>();
		con = getOraConnection();

		try {
			stm = con.createStatement();
			rs = stm.executeQuery(integrationStatement.readInvestigationDataByConsultationNo(consultationNo));

			while (rs.next()) {

				IntegrationEntity integration = new IntegrationEntity();
				integration.setOpdCondtlNo(rs.getLong("OPD_CONDTL_NO"));
				//integration.setOpdCondtlId(rs.getString("OPD_CONDTL_ID"));
				integration.setAppointmentNo(rs.getLong("APPOINTMENT_NO"));
				integration.setOpdConsultationNo(rs.getLong("OPD_CONSULTATION_NO"));
				integration.setItemNo(rs.getLong("ITEM_NO"));
				integration.setItemtypeNo(rs.getLong("ITEMTYPE_NO"));
				integration.setItemName(rs.getString("ITEM_NAME"));
				integration.setItemQty(rs.getInt("ITEM_QTY"));
				integration.setDeliveryStatusNo(rs.getInt("DELIVERY_STATUS_NO"));

				integrationEntityList.add(integration);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			finalyConStmRs(con, stm, rs);

		}

		response.setItems(integrationEntityList);

		return getSuccessResponse("Work List Found", response);
	}

	public Response medicinefindByConsultationId(Long consultationNo) {

		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		List<IntegrationEntity> integrationEntityList = new ArrayList<IntegrationEntity>();
		con = getOraConnection();

		try {
			stm = con.createStatement();
			rs = stm.executeQuery(integrationStatement.readMedicineData(consultationNo));

			while (rs.next()) {

				IntegrationEntity integration = new IntegrationEntity();
				integration.setOpdCondtlNo(rs.getLong("OPD_CONDTL_NO"));
				//integration.setOpdCondtlId(rs.getString("OPD_CONDTL_ID"));
				integration.setAppointmentNo(rs.getLong("APPOINTMENT_NO"));
				integration.setOpdConsultationNo(rs.getLong("OPD_CONSULTATION_NO"));
				integration.setItemNo(rs.getLong("ITEM_NO"));
				integration.setItemtypeNo(rs.getLong("ITEMTYPE_NO"));
				integration.setItemName(rs.getString("ITEM_NAME"));
				integration.setItemQty(rs.getInt("ITEM_QTY"));
				integration.setDeliveryStatusNo(rs.getInt("DELIVERY_STATUS_NO"));

				integration.setUomNo(rs.getLong("UOM_NO"));
				integration.setGenericNo(rs.getLong("GENERIC_NO"));
				integration.setMedDose(rs.getString("MED_DOSE"));
				integration.setMedRoute(rs.getString("MED_ROUTE"));
				integration.setMedDuration(rs.getLong("MED_DURATION"));
				integration.setMedDurationMu(rs.getString("MED_DURATION_MU"));

				integrationEntityList.add(integration);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			finalyConStmRs(con, stm, rs);

		}

		response.setItems(integrationEntityList);

		return getSuccessResponse("Work List Found", response);
	}

	public Response create(IntegrationEntity integration) {
		Long consDtlNo = getStampNo();
		//String consDtlId = getStampId();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		con = getOraConnection();

		try {
			pstm = con.prepareStatement(integrationStatement.creatInvestigationQuery());
			pstm.setLong(1, consDtlNo); // OPD_CONDTL_NO
			//pstm.setString(2, consDtlId); // OPD_CONDTL_ID

			pstm.setBigDecimal(2, converLongTBigDecimmal(integration.getAppointmentNo())); // APPOINTMENT_NO
			pstm.setBigDecimal(3, converLongTBigDecimmal(integration.getOpdConsultationNo())); // OPD_CONSULTATION_NO
			pstm.setBigDecimal(4, converLongTBigDecimmal(integration.getItemNo())); // ITEM_NO
			pstm.setBigDecimal(5, converLongTBigDecimmal(integration.getItemtypeNo())); // ITEMTYPE_NO
			pstm.setBigDecimal(6, converFloatTBigDecimmal(new Float(integration.getItemQty()))); // ITEM_QTY
			pstm.setInt(7, integration.getDeliveryStatusNo());// DELIVERY_STATUS_NO
			pstm.setString(8, integration.getItemName()); // ITEM_NAME

			pstm.setBigDecimal(9, converLongTBigDecimmal(integration.getSsCreator()));
			pstm.setDate(10, new java.sql.Date(new Date().getTime()));
			pstm.setLong(11, 1);

			pstm.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			finalyConPstmRs(con, pstm, rs);

		}

		return getSuccessResponse("Save successfully");
	}

	public Response createMedicine(IntegrationEntity integration) {
		Long consDtlNo = getStampNo();
		//String consDtlId = getStampId();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		// List<IntegrationEntity> integrationEntityList = new
		// ArrayList<IntegrationEntity>();
		con = getOraConnection();

		try {
			pstm = con.prepareStatement(integrationStatement.createMedicineData());
			pstm.setLong(1, consDtlNo); // OPD_CONDTL_NO
			//pstm.setString(2, consDtlId); // OPD_CONDTL_ID

			pstm.setBigDecimal(2, converLongTBigDecimmal(integration.getAppointmentNo())); // APPOINTMENT_NO
			pstm.setBigDecimal(3, converLongTBigDecimmal(integration.getOpdConsultationNo())); // OPD_CONSULTATION_NO
			pstm.setBigDecimal(4, converLongTBigDecimmal(integration.getItemNo())); // ITEM_NO
			pstm.setBigDecimal(5, converLongTBigDecimmal(integration.getItemtypeNo())); // ITEMTYPE_NO
			pstm.setBigDecimal(6, converFloatTBigDecimmal(new Float(integration.getItemQty()))); // ITEM_QTY
			pstm.setInt(7, integration.getDeliveryStatusNo()); // DELIVERY_STATUS_NO
			pstm.setString(8, integration.getItemName()); // ITEM_NAME

			pstm.setBigDecimal(9, converLongTBigDecimmal(integration.getSsCreator())); // SS_CREATOR
			pstm.setDate(10, new java.sql.Date(new Date().getTime())); // SS_CREATED_ON
			pstm.setLong(11, 1); // COMPANY_NO

			pstm.setBigDecimal(12, converLongTBigDecimmal(integration.getItemGroup())); // ITEM_GROUP
			pstm.setBigDecimal(13, converLongTBigDecimmal(integration.getUomNo())); // UOM_NO
			pstm.setBigDecimal(14, converLongTBigDecimmal(integration.getGenericNo())); // GENERIC_NO
			pstm.setString(15, integration.getMedDose()); // MED_DOSE
			pstm.setString(16, integration.getMedRoute()); // MED_ROUTE
			pstm.setBigDecimal(17, converLongTBigDecimmal(integration.getMedDuration())); // MED_DURATION
			pstm.setString(18, integration.getMedDurationMu()); // MED_DURATION_MU
			pstm.setBigDecimal(19, converLongTBigDecimmal(integration.getSubitemtypeNo())); // SUBITEMTYPE_NO

			pstm.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			finalyConPstmRs(con, pstm, rs);

		}

		// response.setItems(integrationEntityList);

		return getSuccessResponse("Save successfully");
	}

	public Response createOrUpdate(IntegrationEntity integration, List<IntegrationEntity> integrationList) {
		IntegrationEntity integrationEntity = null;
		if (integrationList != null) {
			integrationEntity = isExistInvestigation(integration, integrationList);
		}

		if (integrationEntity != null) {
			update(integration);
			logger.info(" integration update successfully");
			return getSuccessResponse("update successfully");
		}

		create(integration);

		return getSuccessResponse("Save successfully");
	}

	public Response createOrUpdateMedicine(IntegrationEntity integration, List<IntegrationEntity> integrationList) {
		IntegrationEntity integrationEntity = null;
		if (integrationList != null) {
			integrationEntity = isExistInvestigation(integration, integrationList);
		}

		if (integrationEntity != null) {
			update(integration);
			return getSuccessResponse("update successfully");
		}
		createMedicine(integration);

		return getSuccessResponse("Save successfully");
	}

	public Response update(IntegrationEntity integration) {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		con = getOraConnection();

		try {

			pstm = con.prepareStatement(integrationStatement.updateInvestigationData());
			pstm.setBigDecimal(1, converLongTBigDecimmal(integration.getItemtypeNo())); // ITEMTYPE_NO
			pstm.setBigDecimal(2, converFloatTBigDecimmal(new Float(integration.getItemQty()))); // ITEM_QTY
			pstm.setString(3, integration.getItemName()); // ITEM_NAME
			pstm.setBigDecimal(4, converLongTBigDecimmal(integration.getSsModifier())); // SS_MODIFIER
			pstm.setDate(5, new java.sql.Date(new Date().getTime())); // SS_MODIFIED_ON
			pstm.setInt(6, integration.getSsIsDeleted()); // SS_IS_DELETED

			pstm.setBigDecimal(7, converLongTBigDecimmal(integration.getOpdConsultationNo())); // OPD_CONSULTATION_NO
			pstm.setBigDecimal(8, converLongTBigDecimmal(integration.getItemNo())); // ITEM_NO

			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			finalyConPstmRs(con, pstm, rs);

		}

		return getSuccessResponse("Update Successfully");
	}

	public Response updateMedicine(IntegrationEntity integration) {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		con = getOraConnection();

		try {

			pstm = con.prepareStatement(integrationStatement.updateMedicineData());

			pstm.setBigDecimal(1, converLongTBigDecimmal(integration.getItemtypeNo())); // ITEMTYPE_NO
			pstm.setBigDecimal(2, converFloatTBigDecimmal(new Float(integration.getItemQty()))); // ITEM_QTY
			pstm.setBigDecimal(3, converLongTBigDecimmal(integration.getUomNo())); // UOM_NO
			pstm.setBigDecimal(4, converLongTBigDecimmal(integration.getGenericNo())); // GENERIC_NO
			pstm.setString(5, integration.getMedDose()); // MED_DOSE
			pstm.setString(6, integration.getMedRoute()); // MED_ROUTE
			pstm.setString(7, integration.getItemName()); // ITEM_NAME
			pstm.setDate(8, new java.sql.Date(new Date().getTime())); // SS_MODIFIED_ON
			pstm.setInt(9, integration.getSsIsDeleted()); // SS_IS_DELETED
			pstm.setBigDecimal(10, converLongTBigDecimmal(integration.getOpdConsultationNo())); // OPD_CONSULTATION_NO
			pstm.setBigDecimal(11, converLongTBigDecimmal(integration.getItemNo())); // ITEM_NO

			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			finalyConPstmRs(con, pstm, rs);

		}

		return getSuccessResponse("Update Successfully");
	}

	public Response delete(IntegrationEntity integration) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		con = getOraConnection();
		if( integration.getOpdConsultationNo() !=null && integration.getItemNo()!=null) {
		try {

			pstm = con.prepareStatement(integrationStatement.deleteInvestigationData());
			pstm.setLong(1, integration.getOpdConsultationNo()); // OPD_CONSULTATION_NO
			pstm.setLong(2, integration.getItemNo()); // ITEM_NO
			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			finalyConPstmRs(con, pstm, rs);

		}
		}
		return getSuccessResponse("Update Successfully");
	}
	
	public Response deleteAllWithoutItemNo(Long consultationNo) {
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pstm = null;
	con = getOraConnection();

	try {

		pstm = con.prepareStatement(integrationStatement.deleteAllInvestigationDataWithOutItemNo());
		pstm.setLong(1, consultationNo); // OPD_CONSULTATION_NO
		pstm.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		finalyConPstmRs(con, pstm, rs);

	}

	return getSuccessResponse("delete Successfully");
}

	private IntegrationEntity isExistInvestigation(IntegrationEntity integration,
			List<IntegrationEntity> integrationList) {

		if (integration.getItemNo() != null) {
			/*
			 * for(IntegrationEntity inv : integrationList) {
			 * 
			 * if (inv.getOpdConsultationNo().longValue() ==
			 * integration.getOpdConsultationNo().longValue() && inv.getItemNo().longValue()
			 * == integration.getItemNo().longValue() ) { return inv ; } }
			 * 
			 * return null;
			 */
			return integrationList.stream()
					.filter(inv -> inv.getOpdConsultationNo().longValue() == integration.getOpdConsultationNo()
							.longValue() && inv.getItemNo().longValue() == integration.getItemNo().longValue())
					.findAny().orElse(null);
		}

		return null;

	}

	public Long getStampNo() {
		Connection con = getOraConnection();
		try {
			CallableStatement cstm = con.prepareCall("{call K_GENERAL.PD_GENARATE_NO(?,?,?,?,?)}");
			cstm.setString(1, "SEQ_OPD_CONSULTATIONDLT_NO"); // "SEQ_OPD_CONSULTATIONDLT_NO"
			cstm.setLong(2, 1);
			cstm.registerOutParameter(3, java.sql.Types.NUMERIC);
			cstm.setString(4, "YYMM");// "YYMM"
			cstm.setLong(5, 10);// 10
			cstm.execute();

			Long consDtlNo = cstm.getLong(3);

			return consDtlNo;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public String getStampId() {
		Connection con = getOraConnection();
		try {
			CallableStatement cstm = con.prepareCall("{call K_GENERAL.PD_GENARATE_ID(?,?,?,?,?)}");
			cstm.setString(1, "");
			cstm.setString(2, "OPD_CONSULTATION_DETAIL"); // "OPD_CONSULTATION_DETAIL"
			cstm.setString(3, "OPD_CONDTL_ID"); // "OPD_CONDTL_ID"
			cstm.setLong(4, 1);
			cstm.registerOutParameter(5, java.sql.Types.VARCHAR);
			cstm.execute();

			String consDtlId = cstm.getString(5);
			return consDtlId;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public Long getStampNo(String sequence, long companyNo, String prifixDate, long dataLength) {
		Connection con = getOraConnection();
		try {
			CallableStatement cstm = con.prepareCall("{call K_GENERAL.PD_GENARATE_NO(?,?,?,?,?)}");
			cstm.setString(1, sequence); // "SEQ_OPD_CONSULTATIONDLT_NO"
			cstm.setLong(2, companyNo);
			cstm.registerOutParameter(3, java.sql.Types.NUMERIC);
			cstm.setString(4, prifixDate);// "YYMM"
			cstm.setLong(5, dataLength);// 10
			cstm.execute();

			Long consDtlNo = cstm.getLong(3);

			return consDtlNo;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public String getStampId(String tableName, String columnName) {
		Connection con = getOraConnection();
		try {
			CallableStatement cstm = con.prepareCall("{call K_GENERAL.PD_GENARATE_ID(?,?,?,?,?)}");
			cstm.setString(1, "");
			cstm.setString(2, tableName); // "OPD_CONSULTATION_DETAIL"
			cstm.setString(3, columnName); // "OPD_CONDTL_ID"
			cstm.setLong(4, 1);
			cstm.registerOutParameter(5, java.sql.Types.VARCHAR);
			cstm.execute();

			String consDtlId = cstm.getString(5);
			return consDtlId;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}

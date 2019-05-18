package com.madbarsoft.doctorchamber.investigationResult;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class LabNonLabReportRepository extends BaseRepository {

	public Response labReportList(String hnNumber) {
		Response response = new Response();
//		Connection con = null;
//		ResultSet rs = null;
//		Statement stm = null;
//		List<LabNonLabReportEntity> labReportList = new ArrayList<LabNonLabReportEntity>();
//
//		try {
//			con = getOraConnection();
//			stm = con.createStatement();
//			rs = stm.executeQuery(LabNonLabReportStatement.labReportFindbyHnNumber(hnNumber));
//
//			while (rs.next()) {
//				LabNonLabReportEntity labReportEntity = new LabNonLabReportEntity();
//				labReportEntity.setRegNo(rs.getLong("REG_NO"));
//				labReportEntity.setBillInvoiceDateStr(rs.getString("INVOICE_DATETIME"));
//				labReportEntity.setBillInvoiceDate(deateParse(labReportEntity.getBillInvoiceDateStr(),"DD/MM/YYYY hh:mm:ss"));
//				labReportEntity.setItemNo(rs.getLong("ITEM_NO"));
//				labReportEntity.setItemId(rs.getString("ITEM_ID"));
//				labReportEntity.setItemName(rs.getString("ITEM_NAME"));
//				labReportEntity.setBuNo(rs.getLong("BU_NO"));
//				labReportEntity.setBuName(rs.getString("BU_NAME"));
//				labReportEntity.setTotalTest(rs.getLong("TOTAL_TEST"));
//
//				labReportList.add(labReportEntity);
//
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (stm != null) {
//					rs.close();
//				}
//				if (con != null) {
//					con.close();
//				}
//
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//		response.setItems(labReportList);

		return getSuccessResponse("Lab Report List Found", response);
	}

	public Response nonLabReportList(String hnNumber) {
		Response response = new Response();
//		Connection con = null;
//		ResultSet rs = null;
//		Statement stm = null;
//		List<LabNonLabReportEntity> nonLabReportList = new ArrayList<LabNonLabReportEntity>();
//
//		try {
//			con = getOraConnection();
//			stm = con.createStatement();
//			rs = stm.executeQuery(LabNonLabReportStatement.nonLabReportFindbyHnNumber(hnNumber));
//
//			while (rs.next()) {
//				LabNonLabReportEntity labReportEntity = new LabNonLabReportEntity();
//
//				labReportEntity.setRegNo(rs.getLong("REG_NO"));
//				labReportEntity.setItemNo(rs.getLong("ITEM_NO"));
//				labReportEntity.setItemId(rs.getString("ITEM_ID"));
//				labReportEntity.setItemName(rs.getString("ITEM_NAME"));
//				labReportEntity.setBuNo(rs.getLong("BU_NO"));
//				labReportEntity.setBuName(rs.getString("BU_NAME"));
//				labReportEntity.setTotalTest(rs.getLong("TOTAL_TEST"));
//
//				nonLabReportList.add(labReportEntity);
//
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (stm != null) {
//					rs.close();
//				}
//				if (con != null) {
//					con.close();
//				}
//
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//		response.setItems(nonLabReportList);

		return getSuccessResponse("Non Lab Report List Found", response);
	}

	public Response labInvestigationDetailList(long regNumber, long itemNo) {
		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		List<LabReportEntity> labInvestigationDetailList = new ArrayList<LabReportEntity>();

		try {
			con = getOraConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(LabNonLabReportStatement.labInvestigationDetail(regNumber, itemNo));

			while (rs.next()) {
				LabReportEntity labReportEntity = new LabReportEntity();

				labReportEntity.setStampId(rs.getString("STAMP_ID"));
				labReportEntity.setLabId(rs.getString("LAB_ID"));
				//labReportEntity.setResultDate(rs.getDate("RESULT_DATE"));
				labReportEntity.setItemNo(rs.getLong("ITEM_NO"));
				labReportEntity.setSlNo(rs.getLong("SL_NO"));
				labReportEntity.setAttr(rs.getString("ATTR"));
				labReportEntity.setMachineAttrib(rs.getString("MACHINE_ATTRIB"));
				labReportEntity.setAnalyzerDesk(rs.getString("ANALYZER_DESC"));
				labReportEntity.setResult(rs.getString("RESULT"));
				labReportEntity.setResult1(rs.getString("RESULT1"));
				labReportEntity.setResult2(rs.getString("RESULT2"));
				labReportEntity.setResult3(rs.getString("RESULT3"));

				labInvestigationDetailList.add(labReportEntity);

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

		response.setItems(labInvestigationDetailList);

		return getSuccessResponse("Non Lab Report List Found", response);
	}

	public Response nonLabInvestigationDetailList(long invoiceNo, long itemNo) {
		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		List<NonLabReportEntity> nonLabInvestigationDetailList = new ArrayList<NonLabReportEntity>();

		try {
			con = getOraConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(LabNonLabReportStatement.nonLabInvestigationDetail(invoiceNo, itemNo));

			while (rs.next()) {
				NonLabReportEntity nonLabReportEntity = new NonLabReportEntity();

				nonLabReportEntity.setReportText(rs.getString("REPORT_TEXT"));

				nonLabInvestigationDetailList.add(nonLabReportEntity);

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

		response.setItems(nonLabInvestigationDetailList);

		return getSuccessResponse("Non Lab Report List Found", response);
	}

}

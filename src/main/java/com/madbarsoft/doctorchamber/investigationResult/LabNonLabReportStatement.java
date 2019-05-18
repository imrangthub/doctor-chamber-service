package com.madbarsoft.doctorchamber.investigationResult;

import org.springframework.stereotype.Component;

@Component
public class LabNonLabReportStatement {

	public static String labReportFindbyHnNumber(String hnNumber) {
		StringBuilder sqlQuery = new StringBuilder();

		sqlQuery.append(
				"SELECT DISTINCT B.REG_NO, to_char(B.INVOICE_DATETIME, 'DD/MM/YYYY hh:mm:ss') as INVOICE_DATETIME, I.ITEM_NO,T.ITEM_ID, I.ITEM_NAME, T.BU_NO, H.BU_NAME, COUNT(I.ITEM_NO) TOTAL_TEST  ");
		sqlQuery.append(
				"FROM BILL_INVOICE B, BILL_INVOICEDTL I, PATH_INVOICEDTL P, IN_ITEM T, HR_BU H, OPD_REGISTRATION R ");
		sqlQuery.append("WHERE B.INVOICE_NO = I.INVOICE_NO ");
		sqlQuery.append("AND I.INVOICEDTL_NO = P.INVOICEDTL_NO ");
		sqlQuery.append("AND I.ITEM_NO = T.ITEM_NO ");
		sqlQuery.append("AND T.BU_NO = H.BU_NO ");
		sqlQuery.append("AND NVL(I.CANCEL_FLAG, 0) = 0  ");
		sqlQuery.append("AND P.LAB_RESULT_FINAL_KEY_FLAG = 1 ");
		sqlQuery.append("AND R.REG_NO = B.REG_NO ");
		sqlQuery.append("AND R.HOSPITAL_NUMBER = ");
		sqlQuery.append(" '" + hnNumber + "' ");
		sqlQuery.append("GROUP BY B.REG_NO, B.INVOICE_DATETIME, I.ITEM_NO, T.ITEM_ID, I.ITEM_NAME, T.BU_NO, H.BU_NAME ");
		sqlQuery.append("ORDER BY ITEM_NO");

		return sqlQuery.toString();

	}

	public static String nonLabReportFindbyHnNumber(String hnNumber) {
		StringBuilder sqlQuery = new StringBuilder();

		sqlQuery.append(
				"SELECT DISTINCT B.REG_NO, I.ITEM_NO,T.ITEM_ID, I.ITEM_NAME, T.BU_NO, H.BU_NAME, COUNT(I.ITEM_NO) TOTAL_TEST  ");
		sqlQuery.append(
				"FROM BILL_INVOICE B, BILL_INVOICEDTL I, IMG_INVOICEDTL P, IN_ITEM T, HR_BU H, OPD_REGISTRATION R ");
		sqlQuery.append("WHERE B.INVOICE_NO = I.INVOICE_NO ");
		sqlQuery.append("AND I.INVOICEDTL_NO = P.INVOICEDTL_NO ");
		sqlQuery.append("AND I.ITEM_NO = T.ITEM_NO ");
		sqlQuery.append("AND T.BU_NO = H.BU_NO ");
		sqlQuery.append("AND NVL(I.CANCEL_FLAG, 0) = 0  ");
		sqlQuery.append("AND P.NLAB_FINALIZE_KEY_FLAG = 1 ");
		sqlQuery.append("AND R.REG_NO = B.REG_NO ");
		sqlQuery.append("AND R.HOSPITAL_NUMBER = ");
		sqlQuery.append(" '" + hnNumber + "' ");
		sqlQuery.append("GROUP BY B.REG_NO, I.INVOICE_NO, I.ITEM_NO, T.ITEM_ID, I.ITEM_NAME, T.BU_NO, H.BU_NAME ");
		sqlQuery.append("ORDER BY ITEM_NO");

		return sqlQuery.toString();
	}

	public static String labInvestigationDetail(long regNumber, long itemNo) {
		StringBuilder sqlQuery = new StringBuilder();

		sqlQuery.append(
				"SELECT P.STAMP_ID, D.LAB_ID, TO_CHAR(D.LAB_RESULT_VERIFY_KEYED_TIME, 'DD/MM/YYYY') RESULT_DATE, ");
		sqlQuery.append("R.ITEM_NO, R.SL_NO, R.ATTR, R.MACHINE_ATTRIB, R.ANALYZER_DESC, ");
		sqlQuery.append("R.RESULT, R.RESULT1, R.RESULT2, R.RESULT3, ");
		sqlQuery.append("R.COMMENTS, R.NOTE, R.INTERPRETATION, R.PLAIN_TEXT, R.UNIT, R.GROUP_TXT, ");
		sqlQuery.append(
				"R.REFERENCEVALUE, R.TEST_METHOD, R.SHOW_IN_REP, R.MACHINE_VAL_ARRIVED, R.ORIGINAL_RESULT, R.GROUP_SEQ ");
		sqlQuery.append("FROM BILL_INVOICE B, PATH_INVOICEDTL D, PATH_TESTRESULT R, PATH_TESTRESULTSTAMP P, HR_EMP H ");
		sqlQuery.append("WHERE B.INVOICE_NO = D.INVOICE_NO ");
		sqlQuery.append("AND D.PATHINVOICEDTL_NO = R.PATHINVOICEDTL_NO ");
		sqlQuery.append("AND R.STAMP_NO = P.STAMP_NO ");
		sqlQuery.append("AND P.RESULT_FINAL_KEYED_BY = H.EMP_NO ");
		sqlQuery.append("AND D.CANCEL_FLAG = 0 ");
		sqlQuery.append("AND B.REG_NO = " + regNumber);
		sqlQuery.append("AND R.ITEM_NO = NVL( " + itemNo + " , R.ITEM_NO) ");
		sqlQuery.append("ORDER BY R.ITEM_NO, R.SL_NO ");

		return sqlQuery.toString();
	}

	public static String nonLabInvestigationDetail(long invoiceNo, long itemNo) {
		StringBuilder sqlQuery = new StringBuilder();

		sqlQuery.append("SELECT NVL(REPORT_TEXT, '') REPORT_TEXT ");
		sqlQuery.append("FROM IMG_TESTRESULT ");
		sqlQuery.append("WHERE ITEM_NO = " + itemNo);
		sqlQuery.append("AND INVOICE_NO = " + invoiceNo);

		return sqlQuery.toString();

	}
}

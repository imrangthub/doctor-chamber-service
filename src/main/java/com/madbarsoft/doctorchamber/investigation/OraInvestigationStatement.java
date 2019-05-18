package com.madbarsoft.doctorchamber.investigation;

import org.springframework.stereotype.Component;

import com.madbarsoft.doctorchamber.util.CommonFunctions;

@Component
public class OraInvestigationStatement implements CommonFunctions{

	
	public static String oraItemStatement() {
		
		StringBuilder itemStatement = new StringBuilder();
		itemStatement.append("SELECT ITEM_NO, ");
		itemStatement.append(" ITEM_ID,");
		itemStatement.append(" ITEM_NAME,");
		itemStatement.append(" TEST_SHORT_NAME,");
		itemStatement.append(" ITEMTYPE_NO,");
		itemStatement.append(" SALES_PRICE,");
		itemStatement.append(" b.BU_NO, b.BU_NAME ");
		itemStatement.append(" FROM in_item i, HR_BU b ");
		itemStatement.append(" where i.ITEMTYPE_NO IN (1,2) and i.BU_NO = b.BU_NO and i.ACTIVE_STAT = 1 ");
		return itemStatement.toString();
		
	}
	
	
	

}

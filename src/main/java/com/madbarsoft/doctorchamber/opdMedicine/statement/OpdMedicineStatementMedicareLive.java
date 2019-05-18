package com.madbarsoft.doctorchamber.opdMedicine.statement;

import org.springframework.stereotype.Component;

import com.madbarsoft.doctorchamber.util.CommonFunctions;

@Component
public class OpdMedicineStatementMedicareLive implements CommonFunctions {

	public static String all_medicine_v_web() {

		StringBuilder sqlQuery = new StringBuilder();
		
		sqlQuery.append("SELECT item_no, item_id, item_name, active_stat, sales_price, ");
		sqlQuery.append(" purchase_price, itemtype_no, item_type_name, uom_no, ");
		sqlQuery.append(" uom_name, manufacturer_no, manufacturer_name, in_box_qty, ");
		sqlQuery.append(" generic_no, generic_name, route_no, route_name ");
		sqlQuery.append(" FROM all_medicine_v_web ");
			 
		return sqlQuery.toString();		
	}

	public static String opd_stock_medicine_v_web() {

		StringBuilder sqlQuery = new StringBuilder();
		
		sqlQuery.append("SELECT item_no, item_id, item_name, active_stat, ");
		sqlQuery.append(" sales_price, purchase_price, stock, ");
		sqlQuery.append(" itemtype_no, item_type_name, uom_no, uom_name, ");
		sqlQuery.append(" manufacturer_no, manufacturer_name, in_box_qty,  ");
		sqlQuery.append(" generic_no, generic_name, route_no, route_name  ");
		sqlQuery.append(" FROM opd_stock_medicine_v_web ");
			 
		return sqlQuery.toString();		
	}

	public static String ipd_stock_medicine_v_web() {

		StringBuilder sqlQuery = new StringBuilder();
		
		sqlQuery.append("SELECT item_no, item_id, item_name, active_stat, ");
		sqlQuery.append(" sales_price, purchase_price, stock, ");
		sqlQuery.append(" itemtype_no, item_type_name, uom_no, uom_name, ");
		sqlQuery.append(" manufacturer_no, manufacturer_name, in_box_qty,  ");
		sqlQuery.append(" generic_no, generic_name, route_no, route_name  ");
		sqlQuery.append(" FROM opd_stock_medicine_v_web ");
			 
		return sqlQuery.toString();		
	}
	
}

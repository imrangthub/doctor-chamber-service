package com.madbarsoft.doctorchamber.opdMedicine.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.opdMedicine.OpdMedicineEntity;
import com.madbarsoft.doctorchamber.opdMedicine.statement.OpdMedicineStatementMedicareNew;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class OpdMedicineRepositoryMedicareNew extends BaseRepository {
	
	
	public Response list(String  reqObj) {
		Response response = new Response();
		OpdMedicineEntity opdMedicineEntity = new OpdMedicineEntity();
		List<OpdMedicineEntity> opdMedicineEntityList = new ArrayList<OpdMedicineEntity>();
		
		opdMedicineEntity.setReferenceId(101l);
		opdMedicineEntity.setItemNo(101l);
		opdMedicineEntity.setItemId("N101");
		opdMedicineEntity.setBrandName("Napa");
		opdMedicineEntity.setForm("Paracetamal");
		opdMedicineEntity.setManufacturer("ACI");
		opdMedicineEntity.setGenericName("Paracdtamal");
		opdMedicineEntity.setRoute("1000mg");
		
		opdMedicineEntityList.add(opdMedicineEntity);
		
		

		response.setItems(opdMedicineEntityList);

		return getSuccessResponse("Medicine List Found", response);
	}
	
	// Real code

//	public Response list(String  reqObj) {
//		Response response = new Response();
//		Connection con = null;
//		ResultSet rs = null;
//		Statement stm = null;
//		List<OpdMedicineEntity> opdMedicineEntityList = new ArrayList<OpdMedicineEntity>();
//
//		try {
//			con = getOraConnection();
//			stm = con.createStatement();
//			rs = stm.executeQuery(OpdMedicineStatementMedicareNew.all_medicine_v_web());
//
//			while (rs.next()) {				
//				OpdMedicineEntity opdMedicineEntity = new OpdMedicineEntity();
//				opdMedicineEntity.setReferenceId(rs.getLong("item_no"));
//				opdMedicineEntity.setItemNo(rs.getLong("item_no"));
//				opdMedicineEntity.setItemId(rs.getString("item_id"));
//				opdMedicineEntity.setBrandName(rs.getString("item_name"));
//				opdMedicineEntity.setForm(rs.getString("item_type_name"));
//				opdMedicineEntity.setManufacturer(rs.getString("manufacturer_name"));				
//				opdMedicineEntity.setGenericName(rs.getString("generic_name"));
//				opdMedicineEntity.setRoute(rs.getString("route_name"));				
//				opdMedicineEntityList.add(opdMedicineEntity);
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
//		response.setItems(opdMedicineEntityList);
//
//		return getSuccessResponse("Medicine List Found", response);
//	}

	public Response listOpd(String  reqObj) {
		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		List<OpdMedicineEntity> opdMedicineEntityList = new ArrayList<OpdMedicineEntity>();

		try {
			con = getOraConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(OpdMedicineStatementMedicareNew.opd_stock_medicine_v_web());

			while (rs.next()) {				
				OpdMedicineEntity opdMedicineEntity = new OpdMedicineEntity();
				opdMedicineEntity.setReferenceId(rs.getLong("item_no"));
				opdMedicineEntity.setItemNo(rs.getLong("item_no"));
				opdMedicineEntity.setItemId(rs.getString("item_id"));
				opdMedicineEntity.setBrandName(rs.getString("item_name"));
				opdMedicineEntity.setForm(rs.getString("item_type_name"));
				opdMedicineEntity.setManufacturer(rs.getString("manufacturer_name"));				
				opdMedicineEntity.setGenericName(rs.getString("generic_name"));
				opdMedicineEntity.setRoute(rs.getString("route_name"));				
				opdMedicineEntity.setStock(rs.getLong("stock"));				
				opdMedicineEntityList.add(opdMedicineEntity);
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

		response.setItems(opdMedicineEntityList);

		return getSuccessResponse("Medicine List Found", response);
	}

	public Response listIpd(String  reqObj) {
		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		List<OpdMedicineEntity> opdMedicineEntityList = new ArrayList<OpdMedicineEntity>();

		try {
			con = getOraConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(OpdMedicineStatementMedicareNew.ipd_stock_medicine_v_web());

			while (rs.next()) {				
				OpdMedicineEntity opdMedicineEntity = new OpdMedicineEntity();
				opdMedicineEntity.setReferenceId(rs.getLong("item_no"));
				opdMedicineEntity.setItemNo(rs.getLong("item_no"));
				opdMedicineEntity.setItemId(rs.getString("item_id"));
				opdMedicineEntity.setBrandName(rs.getString("item_name"));
				opdMedicineEntity.setForm(rs.getString("item_type_name"));
				opdMedicineEntity.setManufacturer(rs.getString("manufacturer_name"));				
				opdMedicineEntity.setGenericName(rs.getString("generic_name"));
				opdMedicineEntity.setRoute(rs.getString("route_name"));				
				opdMedicineEntity.setStock(rs.getLong("stock"));				
				opdMedicineEntityList.add(opdMedicineEntity);
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

		response.setItems(opdMedicineEntityList);

		return getSuccessResponse("Medicine List Found", response);
	}

}

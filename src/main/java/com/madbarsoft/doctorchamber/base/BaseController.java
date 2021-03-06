package com.madbarsoft.doctorchamber.base;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.madbarsoft.doctorchamber.report.CusJasperReportDef;

/**
 * @author Md. Jahurul Islam
 *
 */
@Controller
public class BaseController  {

	/**
	 * write byte array to response to download/open report
	 * @param jasperReport CusJasperReportDef
	 * @param forceDownload whether force  browser to download, if false browser can open like image/pdf
	 * @return
	 * @throws IOException 
	 */
	public   ResponseEntity<byte[]> respondReportOutput(CusJasperReportDef jasperReport, boolean forceDownload) throws IOException {
		if (jasperReport == null || jasperReport.getContent() == null) {
			throw new FileNotFoundException("jasper Report Not found");
		} else {
			String outputFileName = (jasperReport.getOutputFilename()) + "." + jasperReport.getReportFormat().getExtension();
			String contentDisposition = forceDownload == true ? "attachment;filename=\""+outputFileName+"\"": "filename=\""+outputFileName+"\"";
		    return ResponseEntity
		  	      .ok()
		          .header("Access-Control-Allow-Origin", "*")
		  	      .header("Content-Type",  jasperReport.getReportFormat().getMimeType()+";charset=UTF-8")
		  	      .header("Content-Disposition", contentDisposition)
		  	      .body(jasperReport.getContent());
			
		}
		
	}

    
 

}

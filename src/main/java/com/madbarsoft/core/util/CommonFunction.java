package com.madbarsoft.core.util;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.madbarsoft.core.report.JasperExportFormat;
import com.madbarsoft.core.report.ReportPathAndName;


/**
 * @author Md. Jahurul Islam
 *
 */
public class CommonFunction {

	@Autowired
    HttpSession httpSession;
	static final List<ReportPathAndName> reportNamList = new ArrayList<ReportPathAndName>();

	 static{
		 if(reportNamList.size() == 0) {
		   		reportNamList.add(new ReportPathAndName("wahab","1","/report/prescription/wahab","prescriptionLayout_1"));
				reportNamList.add(new ReportPathAndName("wahab","2","/report/prescription/wahab","prescriptionLayout_2"));
				reportNamList.add(new ReportPathAndName("gen","1","/report/prescription","generalPrescriptionLayout_1"));
		 }
	 }
	public static JasperExportFormat printFormat(String printFormat){
        if(printFormat==null){
            printFormat = "PDF";
        }
        if(printFormat == "PDF"){
            return JasperExportFormat.PDF_FORMAT;
        } 
        if(printFormat == "HTML"){
            return JasperExportFormat.HTML_FORMAT;
        }
        else if(printFormat == "DOCX"){
            return JasperExportFormat.DOCX_FORMAT;
        } else if(printFormat == "XLSX"){
            return JasperExportFormat.XLSX_FORMAT;
        }
        
      
        
        return JasperExportFormat.PDF_FORMAT;
    }

    public static  String getReportPath(HttpServletRequest request,String path) {
    	  return request.getServletContext().getRealPath(path);
    	// return request.getSession().getServletContext().getRealPath(path);
    	 //path = this.getClass().getClassLoader().getResource("").getPath();
    }
    /**
     * 
     * @param filePath
     * @return
     */
    public static  String getResoucePath(String filePath) {
      Resource resource = new ClassPathResource(filePath);
  	  try {
		return resource.getFile().getAbsolutePath();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  	  return null;
   }
    


    
    public static long generateRandom(int length) {
        while (true) {
            long numb = (long)(Math.random() * 100000000 * 1000000);
            if (String.valueOf(numb).length() == length)
                return numb;
               }
   }
    
    
	 public void setHttpSession(String key, Object obj) {
		
		 httpSession.setAttribute(key, obj);
	 }

	 public Object getHttpSession(String key) {
		 System.out.println( "uuuuuuuuuuuuu "+httpSession.getAttributeNames());
		 return httpSession.getAttribute(key);
	 }


   
	public static ReportPathAndName reportPathName(String pClient, String pLayout) {
		return reportNamList.stream().filter(rp -> rp.getpClient().equals(pClient) && rp.getpLayout().equals(pLayout)).findAny().orElse(null);
	}
}

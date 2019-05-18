package com.madbarsoft.doctorchamber.report;


import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.madbarsoft.doctorchamber.util.JasperExportFormat;

import net.sf.jasperreports.engine.JRDataSource;

public class CusJasperReportDef implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

    //required information
    String reportName;
    String reportDir;

    //report parameters
    Map<String, Object> parameters = new HashMap<String, Object>();


    //report format
    JasperExportFormat reportFormat = JasperExportFormat.PDF_FORMAT;

    //data source
    Collection<?>  reportData;
    JRDataSource dataSource;

    //additional configuration
    Boolean useDefaultConfiguration;
    Map<String, Object> reportConfiguration = new HashMap<String, Object>();

    //local
   // Locale locale

    //generated byte array
    byte[] content;

    //output filename
    String outputFilename;

    /**
     * get report as resource from report path
     * @return
     * @throws FileNotFoundException 
     */
  public Resource getReport() throws FileNotFoundException {
	  System.out.println(reportDir+"==reoort path ======");
      String reportPath = reportDir+reportName;
        Resource result = new FileSystemResource(reportPath + ".jasper");
        if (result.exists()) {
            return result;
        }

        result = new FileSystemResource(reportPath + ".jrxml");
        if (result.exists()) {
            return result;
        }
        throw new FileNotFoundException("Report ["+reportPath + ".jasper"+"] or ["+reportPath + ".jrxml] file not found");
    }

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportDir() {
		return reportDir;
	}

	public void setReportDir(String reportDir) {
		this.reportDir = reportDir;
	}



	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	public JasperExportFormat getReportFormat() {
		return reportFormat;
	}

	public void setReportFormat(JasperExportFormat reportFormat) {
		this.reportFormat = reportFormat;
	}



	public Collection<?> getReportData() {
		return reportData;
	}

	public void setReportData(Collection<?> reportData) {
		this.reportData = reportData;
	}

	public JRDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(JRDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Boolean getUseDefaultConfiguration() {
		return useDefaultConfiguration;
	}

	public void setUseDefaultConfiguration(Boolean useDefaultConfiguration) {
		this.useDefaultConfiguration = useDefaultConfiguration;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getOutputFilename() {
		return outputFilename;
	}

	public void setOutputFilename(String outputFilename) {
		this.outputFilename = outputFilename;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<String, Object> getReportConfiguration() {
		return reportConfiguration;
	}

	public void setReportConfiguration(Map<String, Object> reportConfiguration) {
		this.reportConfiguration = reportConfiguration;
	}
    
    
    
    

}

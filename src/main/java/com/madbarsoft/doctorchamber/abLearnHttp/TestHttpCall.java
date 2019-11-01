package com.madbarsoft.doctorchamber.abLearnHttp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestHttpCall {
	
	private static HttpURLConnection conn;
	

	public static void main(String[] args) {

       System.out.println("============ CALL HTTP REQUEST ===============");
       
       
       StringBuffer responseContent = new StringBuffer();
       BufferedReader reader;
       String line;
       
       try {
    	   
    	   URL url = new URL("http://localhost:8090/api/consulation/list");
    	   conn = (HttpURLConnection) url.openConnection();
    	   
    	   
    	  conn.setRequestMethod("GET");
    	  conn.setConnectTimeout(5000);
    	  conn.setReadTimeout(5000);
    	  
    	  int reqStatus = conn.getResponseCode();
    	  System.out.println("REQ STATUS# "+reqStatus);
    	  
    	  
    	  reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
          
    	  while ((line = reader.readLine()) != null ){
    		  responseContent.append(line);
    	  }
    	  
    	  System.out.println("REQ RESPONSE# "+responseContent);
    	   
    	  
    	   
    	   
    	   
       }catch (Exception e){
    	   e.printStackTrace();
       }finally {
    	   conn.disconnect();
	   }
	}
	
	
	
	
	

}

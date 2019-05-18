package com.madbarsoft.doctorchamber.util;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Md. Jahurul Islam
 *
 */
@Getter
@Setter
public class Response {
	
	private boolean success = true;
	private boolean info = false;
	private boolean warning = false;
	private String message;
	private boolean valid = false;
	
	private    Long id;
	private   Map<String,Object> model;
	private    List items;
	private    Object obj;

}
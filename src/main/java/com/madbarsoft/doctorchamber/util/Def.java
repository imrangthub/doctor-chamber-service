package com.madbarsoft.doctorchamber.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Md. Jahurul Islam
 *
 */
public class Def {

	static String dateFormat;
	
	
	
	/**
	 * 
	 * @param json
	 * @param key
	 * @return String
	 */
	public static JSONObject getJSONObject(String jsonStr) {
		JSONObject json = new JSONObject(jsonStr);
		return json;
	}


	/**
	 * 
	 * @param json
	 * @param key
	 * @return String
	 */
	public static String getString(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" && json.get(key) != null) {
				return json.get(key).toString();
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * @param json
	 * @param key
	 * @return
	 */
	public static Object getObjcect(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" && json.get(key) != null) {
				return json.get(key);
			} else {
				return null;
			}
		}
		return null;
	}
	
	/**
	 * @param json
	 * @param key
	 * @return
	 */
	public static String getArrayString(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" && json.get(key) != null) {
				return json.getJSONArray(key).toString();
			} else {
				return null;
			}
		}
		return null;
	}
	
	/**
	 * @param json
	 * @param key
	 * @return
	 */
	public static Object getArrayObj(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" && json.get(key) != null) {
				return json.getJSONArray(key);
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param json
	 * @param key
	 * @retur Long
	 */
	public static Long getLong(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" &&  !json.isNull(key)) {
				return Long.parseLong(json.get(key).toString());
			} else {
				return null;
			}
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param json
	 * @param key
	 * @retur Double
	 */
	public static Double getDouble(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" && json.get(key) != null) {				
				return Double.parseDouble(json.get(key).toString());
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param json
	 * @param key
	 * @return Integer
	 */
	public static Integer getInteger(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" && json.get(key) != null) {
				return Integer.parseInt(json.get(key).toString());
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param json
	 * @param key
	 * @return date
	 */
	public static Date getDate(JSONObject json, String key) {
		SimpleDateFormat formatter = null;
		if (Def.dateFormat == null) {
			formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		} else {
			formatter = new SimpleDateFormat(Def.dateFormat);
		}

		if (json.has(key)) {

			if (!json.get(key).equals("") && json.get(key) != null) {
				try {
					return formatter.parse(json.get(key).toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param json
	 * @param key
	 * @param dateFromat
	 * @return date
	 */
	public static Date getDate(JSONObject json, String key, String dateFromat) {
		Def.dateFormat = dateFromat;
		return Def.getDate(json, key);
	}

	/**
	 * @param dateStr
	 * @return
	 */
	public static Date DateParse(String dateStr) {
		Date date = null;
		SimpleDateFormat formatter = null;
		if (Def.dateFormat == null) {
			formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		} else {
			formatter = new SimpleDateFormat(Def.dateFormat);
		}
		try {
			date = formatter.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date DateParse(String dateStr, String format) {
		Def.dateFormat = format;
		Date date = null;
		SimpleDateFormat formatter = null;
		if (Def.dateFormat == null) {
			formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		} else {
			formatter = new SimpleDateFormat(Def.dateFormat);
		}
		try {
			date = formatter.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return date;
		}

		return date;
	}

		/**
	 * 
	 * @param json
	 * @param key
	 * @retur Float
	 */
	public static Float getFloat(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" && !json.get(key).toString().isEmpty() && json.get(key) != null ) {	

					return Float.parseFloat(json.get(key).toString());
				
			} else {
				return null;
			}
		}
		return null;
	}
}

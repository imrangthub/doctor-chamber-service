package com.madbarsoft.doctorchamber.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;

import org.hibernate.loader.criteria.CriteriaLoader;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.madbarsoft.doctorchamber.pagination.DataTableRequest;
import com.madbarsoft.doctorchamber.pagination.DataTableResults;
import com.madbarsoft.doctorchamber.prescriptionAllNotes.PrescriptionAllNotesEntity;
import com.madbarsoft.doctorchamber.prescriptionDetails.PrescriptionDetailsEntity;

/**
 * @author Md. Jahurul Islam
 *
 */

public interface CommonFunctions {

	default Response getSuccessResponse(String message) {
		Response response = new Response();
		response.setSuccess(true);
		response.setMessage(message);
		return response;
	}
	
    default Date addHourMinutesSeconds(int hour, int minute, int second, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        calendar.add(Calendar.HOUR_OF_DAY, hour);
        calendar.add(Calendar.MINUTE, minute);
        calendar.add(Calendar.SECOND, second);

        return calendar.getTime();
    }
    
    

	default Response getSuccessResponse(String message, Response response) {
		response.setSuccess(true);
		response.setMessage(message);
		return response;
	}

	default Response getErrorResponse(String message) {
		Response response = new Response();
		response.setSuccess(false);
		response.setMessage(message);
		return response;
	}

	default Response getErrorResponse(String message, Response response) {
		response.setSuccess(false);
		response.setMessage(message);
		return response;
	}

	default String buildStr(String str, Map<String, Object> map) {
		String replaceStr = str;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (entry.getValue() instanceof String) {
				replaceStr = replaceStr.replaceAll(entry.getKey().toString(),
						strsingleQuotation(entry.getValue().toString()));
			} else {
				replaceStr = replaceStr.replaceAll(entry.getKey().toString(), entry.getValue().toString());
			}

		}
		return replaceStr;
	}

	default String strsingleQuotation(String val) {
		String[] values = val.split(",");
		StringBuilder str = new StringBuilder();
		for (int j = 0; j < values.length; j++) {
			if (j > 0) {
				str.append(",");
			}
			String valuesPattern = "'";
			valuesPattern += values[j];
			valuesPattern += "'";
			str.append(valuesPattern);

		}
		return str.toString();
	}

	default <T> T objectMapperReadValue(String content, Class<T> valueType) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {

			return (T) objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
					.readValue(content, valueType);

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// return null;
	}
	
	
	
	default String objectToJson(Object content) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(content);
			

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// return null;
	}

	default <T> DataTableResults<T> dataTableResults(DataTableRequest<T> dtr, List<T> pFilterList, List<T> pList,
			Long totalRecord) {

		DataTableResults<T> dataTableResult = new DataTableResults<T>();
		dataTableResult.setDraw(dtr.getDraw());

		if (dtr.isGlobalSearch()) {
			dataTableResult.setData(pList);
		} else {
			dataTableResult.setData(pList);
		}

		if ((pList != null && pList.size() > 0)) {

			dataTableResult.setRecordsTotal(String.valueOf(totalRecord));

			if (dtr.getPaginationRequest().isFilterByEmpty()) {
				dataTableResult.setRecordsFiltered(String.valueOf(totalRecord));

			} else {
				dataTableResult.setRecordsFiltered(Integer.toString(pList.size()));
			}

		} else {
			dataTableResult.setRecordsTotal("0");
			dataTableResult.setRecordsFiltered("0");
		}

		return dataTableResult;

	}

	@SuppressWarnings("unchecked")
	default <T> List<T> objectMapperReadArrayValue(String mapperArrStr, Class<T> clazz) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {

			return (List<T>) objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
					.readValue(mapperArrStr, TypeFactory.defaultInstance().constructCollectionType(List.class, clazz));

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	default <T> List<T> getListFromObject(Object data, Class<T> clazz) {
		return (List<T>) data;
	}

	@SuppressWarnings("unchecked")
	default <T> T getValueFromObject(Object data, Class<T> clazz) {
		return (T) data;
	}

	/**
	 * 
	 * @param str
	 * @param searchStr
	 * @return
	 */
	default boolean containsIgnoreCase(String str, String searchStr) {
		if (str != null) {
			return str.toLowerCase().contains(searchStr.toLowerCase());
		} else {
			return false;
		}

	}

	/**
	 * 
	 * @param length
	 * @return long
	 */

	default long generateRandom(int length) {
		while (true) {
			long numb = (long) (Math.random() * 100000000 * 1000000);
			if (String.valueOf(numb).length() == length)
				return numb;
		}
	}

	default Map<String, Date> baseOnCriteriaFromAndToDate(Map<String, Object> dateRange) {
		Map<String, Date> formDateAndToDate = new HashMap<String, Date>();
		Date fromDate = null;
		Date toDate = null;
		if (DateRangCriteria.DATE_BETWEEN.name().equals(dateRange.get("dateRange"))) {
			fromDate = (Date) dateRange.get("fromDate");
			toDate = (Date) dateRange.get("toDate");
		} else if (DateRangCriteria.TODAY.name().equals(dateRange.get("dateRange"))) {
			fromDate = clearTime(new Date());
			toDate = oneDayPlusClearTime(new Date());
		} else if (DateRangCriteria.THIS_WEEK.name().equals(dateRange.get("dateRange"))) {
			fromDate = thisWeekFirstDate(null);
			toDate = thisWeekLastDate(null);
		} else if (DateRangCriteria.THIS_MONTH.name().equals(dateRange.get("dateRange"))) {
			fromDate = thisMonthFirstDate(null);
			toDate = thisMonthLastDate(null);
		} else if (DateRangCriteria.THIS_YEAR.name().equals(dateRange.get("dateRange"))) {
			fromDate = thisYearFirstDate();
			toDate = thisYearLastDate();
		} else {
			fromDate = clearTime(new Date());
			toDate = oneDayPlusClearTime(new Date());
		}

		formDateAndToDate.put("fromDate", fromDate);
		formDateAndToDate.put("toDate", toDate);
		return formDateAndToDate;
	}

	default Date thisWeekFirstDate(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		} else {
			cal.setTime(new Date());
		}
		cal.set(Calendar.DAY_OF_WEEK, cal.getActualMinimum(Calendar.DAY_OF_WEEK));
		return cal.getTime();
	}

	default Date thisWeekLastDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		} else {
			calendar.setTime(new Date());
		}
		calendar.set(Calendar.DAY_OF_WEEK, 7);
		return calendar.getTime();
	}

	default Date thisMonthFirstDate(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		} else {
			cal.setTime(new Date());
		}
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	default Date thisMonthLastDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		} else {
			calendar.setTime(new Date());
		}
		calendar.add(Calendar.MONTH, 1); // add one month
		calendar.set(Calendar.DAY_OF_MONTH, 1); // set value day 1
		calendar.add(Calendar.DATE, -1); // minus one date
		return calendar.getTime();
	}

	default Date thisYearFirstDate() {
		// Current Date
		LocalDate currentDate = LocalDate.now();
		LocalDate date = LocalDate.of(currentDate.getYear(), 01, 01);
		Date thisYearFirstDate = null;
		try {
			thisYearFirstDate = new SimpleDateFormat("yyyy-MM-dd").parse(date.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return thisYearFirstDate;
	}

	default Date thisYearLastDate() {
		// Current Date
		LocalDate currentDate = LocalDate.now();
		LocalDate date = LocalDate.of(currentDate.getYear(), 12, 30);
		Date thisYearLastDate = null;
		try {
			thisYearLastDate = new SimpleDateFormat("yyyy-MM-dd").parse(date.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return thisYearLastDate;
	}

	default Date oneDayPlus(Date date) {
		Date givenDate = date;
		LocalDate localDate = givenDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		Date oneDayPlusDate = null;
		try {
			oneDayPlusDate = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.plusDays(1).toString());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oneDayPlusDate;
	}

	default Date oneDayPlusClearTime(Date date) {
		Date givenDate = date;
		LocalDateTime localDateTime = givenDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		Date oneDayPlusDate = Date.from(localDateTime.plusDays(1).atZone(ZoneId.systemDefault()).toInstant());
		return oneDayPlusDate;
	}

	default Date clearTime(Date date) {
		Date givenDate = date;
		LocalDate localDate = givenDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Date localDateClearTime = null;
		try {
			localDateClearTime = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return localDateClearTime;
	}

	default Date deateParse(String dateStr, String dateFormat) {

		Date parseDate = null;

		try {
			parseDate = new SimpleDateFormat(dateFormat).parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parseDate;
	}

	default String dateFormat(Date dateStr, String dateFormat) {
		if(dateStr == null) {
			return "";
		}
		String parseDate = new SimpleDateFormat(dateFormat).format(dateStr);
		
		return parseDate;
	}

	default List<PrescriptionDetailsEntity> getDetailList(List<PrescriptionDetailsEntity> presDetailList,
			int dataTypeid) {

		return presDetailList.stream().filter(pd -> pd.getPrescritionDataType() == dataTypeid)
				.collect(Collectors.toList());
	}

	default PrescriptionAllNotesEntity getGenearalNote(List<PrescriptionAllNotesEntity> presAllNotesList,
			int dataTypeid) {

		return presAllNotesList.stream().filter(pd -> pd.getNotesDataType() == dataTypeid).findFirst().orElse(null);
	}

	default PrescriptionDetailsEntity getDatil(List<PrescriptionDetailsEntity> presDetailList, int dataTypeid) {

		return presDetailList.stream().filter(pd -> pd.getPrescritionDataType() == dataTypeid).findFirst().orElse(null);
	}

	default BigDecimal converLongTBigDecimmal(Long logval) {

		if (logval != null) {

			return new BigDecimal(logval);
		}

		return null;
	}

	default BigDecimal converFloatTBigDecimmal(Float floatgval) {

		if (floatgval != null) {

			return new BigDecimal(floatgval);
		}

		return null;
	}
	
//	default List<Order> orderList(CriteriaBuilder builder) {
//		List<Order> orderList = new ArrayList();
//		retun null;
//	}
}

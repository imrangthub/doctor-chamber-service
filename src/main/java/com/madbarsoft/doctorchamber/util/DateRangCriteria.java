package com.madbarsoft.doctorchamber.util;

import lombok.Getter;

@Getter
public enum DateRangCriteria {
	
    TODAY("TODAY","Today"),
    THIS_WEEK("THIS_WEEK","This Week"),
    THIS_MONTH("THIS_MONTH","This Month"),
    THIS_YEAR("THIS_YEAR","This Year"),
    DATE_BETWEEN("DATE_BETWEEN","Date Between");

    private final String value;
    private final String dateRange;

    DateRangCriteria(String value, String dateRange) {
        this.value = value;
        this.dateRange = dateRange;
    }

}

package com.example.market.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateUtility {
    
    public static String customDateFormat(String pattern,Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}

	public static Date convertStringToDate(String pattern, String dateString){
		try {
			return new SimpleDateFormat(pattern).parse(dateString);
		} catch (ParseException e) {
			log.info("Cannot Parse String To Date");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Date is not valid");
		}
	}
}

package com.visog.pasupukumkuma.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateUtils {
	
	private static final Logger logger = Logger.getLogger(DateUtils.class);
	
	/**
	 * This method returns the EOD for the given date string 
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndDate(String date) {
		
		return getEndDate(date, new SimpleDateFormat(PropertyUtil.getProperty("APP_DATE_FORMAT")));
		
	}
	
	/**
	 * This method returns the EOD for the given date object
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		cal.add(Calendar.MILLISECOND, -1);
		return cal.getTime();
	}	
	
	/**
	 * This method returns the EOD for the given date string in given sdf format
	 * 
	 * @param date
	 * @param sdf
	 * @return
	 */
	public static Date getEndDate(String date, SimpleDateFormat sdf) {
		try {
			return getEndDate(sdf.parse(date));
		} catch (ParseException e) {
			logger.error("Exception occured while parsing", e);
			return null;
		}
	}
}

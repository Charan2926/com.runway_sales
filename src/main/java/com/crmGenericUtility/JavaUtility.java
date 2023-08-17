package com.crmGenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * This method is used to get random number
	 * @author Nani
	 * @return
	 */
	public int getRandomno() {
		Random ran = new Random();
		int random =ran.nextInt();
		return random;
	}
   
	/**
	 * This method is used to get the system date 
	 * @return
	 */
	public String GetSystemDate() {
		Date d = new Date();
		String date =d.toString();
		return date;
	}
	
	/**
	 * This method is used to get the systemdate in format
	 * @author Nani
	 * @return
	 */
	public String GetSystemDateInFormat() {
		SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy hh-MM-ss");
		Date date = new Date();
		String systemdf=df.format(date);
		return systemdf;
	}
}
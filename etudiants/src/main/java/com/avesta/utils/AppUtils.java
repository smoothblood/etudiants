package com.avesta.utils;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class AppUtils {
	
	/**
	 * Description: R�cup�rer message sans argument
	 * Date cr�ation: 9 d�c. 2017 20:06:28
	 * User: saadxbelbsir
	 * @param messageSource
	 * @param code
	 * @return String
	 */
//	public static String getMessage(MessageSource messageSource, final String code) {
//		return messageSource.getMessage(code, null, code, Locale.getDefault());
//	}
	
	/**
	 * Description: R�cup�rer message avec un argument
	 * Date cr�ation: 9 d�c. 2017 20:08:27
	 * User: saadxbelbsir
	 * @param messageSource
	 * @param code
	 * @param arg1
	 * @return String
	 */
//	public static String getMessage(MessageSource messageSource, final String code, final String arg1) {
//		return messageSource.getMessage(code, new String[] {arg1}, code, Locale.getDefault());
//	}
	
	/**
	 * Description: R�cup�rer message avec deux argument
	 * Date cr�ation: 9 d�c. 2017 20:08:31
	 * User: saadxbelbsir
	 * @param messageSource
	 * @param code
	 * @param arg1
	 * @param arg2
	 * @return String
	 */
//	public static String getMessage(MessageSource messageSource, final String code, final String arg1, final String arg2) {
//		return messageSource.getMessage(code, new String[] {arg1, arg2}, code, Locale.getDefault());
//	}
	
	/**
	 * Description: R�cuperer message aves des arguments
	 * Date cr�ation: 16 d�c. 2017 16:02:44
	 * User: saadxbelbsir
	 * @param messageSource
	 * @param code
	 * @param args
	 * @return String
	 */
	public static String getMessage(MessageSource messageSource, final String code, final Object... args) {
		return messageSource.getMessage(code, args, code, Locale.getDefault());
	}
	
}

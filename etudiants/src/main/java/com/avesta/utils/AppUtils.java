package com.avesta.utils;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class AppUtils {
	
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

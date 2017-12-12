package com.avesta.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component("appUtils")
public class AppUtils {
	
	
	private static MessageSource messageSource;
	
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		AppUtils.messageSource = messageSource;
	}

	/**
	 * Description: Récupérer message sans argument
	 * Date création: 9 déc. 2017 20:06:28
	 * User: saadxbelbsir
	 * @param code
	 * @return String
	 */
	public static String getMessage(final String code) {
		return messageSource.getMessage(code, null, Locale.getDefault());
	}
	
	/**
	 * Description: Récupérer message avec un argument
	 * Date création: 9 déc. 2017 20:08:27
	 * User: saadxbelbsir
	 * @param code
	 * @param arg1
	 * @return String
	 */
	public static String getMessage(final String code, final String arg1) {
		return messageSource.getMessage(code, new String[] {arg1}, Locale.getDefault());
	}
	
	/**
	 * Description: Récupérer message avec deux argument
	 * Date création: 9 déc. 2017 20:08:31
	 * User: saadxbelbsir
	 * @param code
	 * @param arg1
	 * @param arg2
	 * @return String
	 */
	public static String getMessage(final String code, final String arg1, final String arg2) {
		return messageSource.getMessage(code, new String[] {arg1, arg2}, Locale.getDefault());
	}
	
	
}

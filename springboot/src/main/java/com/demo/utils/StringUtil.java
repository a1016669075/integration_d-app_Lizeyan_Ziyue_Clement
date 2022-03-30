package com.demo.utils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	public static boolean isNullOrEmpty(Object obj) {	
		return obj == null || "".equals(obj.toString());
	}
	/**
	 * 是不是空
	 * @param obj
	 * @return
	 */
	public static boolean isNullOrEmptyTrim(Object obj) {	
		if(obj == null){
			return true;
		}
		String s = obj.toString().replaceAll(" ", "");
		if("".equals(s)){
			return true;
		}
		return false;
	}
	//获取文件名称
	public static String getFileName(String url) {	
		if(url == null){
			return "";
		}
		int lastIndex = url.lastIndexOf("/");
		url=url.substring(lastIndex+1, url.length());
		return url;
	}
	/**
	 * 是不是电话号码
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles){  
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches(); 
	}
	/**
	 *格式化字符串
	 * @param 
	 * @return
	 */
	public static String  displayNone(String str){  
		int cardIndex = str.length()-8;
		String a = str.substring(0, cardIndex);
		a = a+"****"+str.substring(cardIndex+4, str.length());
		return a; 
	}
	/**
	 *格式化字符串 保留1位小数
	 * @param
	 * @return
	 */
	public static String  decimalFormatNumber(float str){
		DecimalFormat df = new DecimalFormat("#.0");
		return df.format(str);
	}
}

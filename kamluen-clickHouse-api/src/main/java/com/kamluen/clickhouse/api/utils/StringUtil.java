package com.kamluen.clickhouse.api.utils;

import java.util.Collection;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: StringUtil
 * @Description: 字符串工具类
 * @author zhanglei
 * @date 2019年4月4日
 * @version 1.0.0
 */
public class StringUtil {

	public static boolean isNEmpty(Collection<?> collection){
	    if((collection != null) && (collection.size() > 0)) {
	       return true;
	     }
	     return false;
	 }
	
	public static boolean isNEmpty(String str){
	    if((str != null) && (str.length() > 0) && !"null".equals(str) && !"".equals(str)){
	    	return true;
	    }
	    return false;
	}
	
	public static boolean isNEmpty(Object[] objArr){
	     if ((objArr != null) && (objArr.length > 0)) {
	       return true;
	     }
	     return false;
	}
	
	public static boolean isEmpty(Object obj){
	     if (obj == null || null == obj || "null".equals(obj)) {
	       return true;
	     }
	     return false;
	}
	
	/**
	 * @Description: 隐藏字符
	 * @param @param str
	 * @param @param begin 开始几个
	 * @param @param end  结束几个
	 * @param @return
	 * @return String
	 * 脱敏方案：
	 *		  手机号：前3后4
			   身份证：前4后3 
			   银行卡：前4后4
			   姓名 ： 前一后一
	 *
	 *1041138810@qq.com
	 */
	public static String toConceal(String str,int begin,int end) {
		if(!StringUtil.isNEmpty(str)){
			return str;
		}else{
			int length = str.length();
			int count = length - end - begin;
			StringBuffer sb = new StringBuffer(length);
			if(count > 0) {
					sb.append(str.substring(0, begin));
					for(int i = 0;i < count;i++){
						sb.append("*");
					}
					sb.append(str.substring(begin+count)); 
			}else {
				return null;
			}
			return sb.toString();
		}
	}
	
	/**
	 * @Description: TODO
	 * @param @param str
	 * @param @param begin
	 * @param @param end
	 * @param @return   yaozg@tjpay.com
	 * @return String
	 */
	public static String toConceal1(String str) {
		if(!StringUtil.isNEmpty(str)){
			return str;
		}else{
			int length = str.length();
			int begin = 4;
			int end = str.split("@")[1].length();
			int count  = length - end - begin - 1;
			StringBuffer sb = new StringBuffer(length);
			if(count > 0) {
					sb.append(str.substring(0, begin));
					for(int i = 0;i < count;i++){
						sb.append("*");
					}
					sb.append(str.substring(begin+count)); 
			}else {
				return null;
			}
			return sb.toString();
		}
	}
	
	
	/**
	 * 把第一个字符变大写
	 */

	public static String capitalizeFirst(String str) {
		return changeFirstCharacterCase(true, str);
	}

	/**
	 * 把第一个字符变小写 
	 */
	public static String uncapitalizeFirst(String str) {
		return changeFirstCharacterCase(false, str);
	}

	/**
	 * 改变字符大小写
	 */
	private static String changeFirstCharacterCase(boolean capitalize,
			String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return str;
		}
		StringBuffer buf = new StringBuffer(strLen);
		if (capitalize) {
			buf.append(Character.toUpperCase(str.charAt(0)));
		} else {
			buf.append(Character.toLowerCase(str.charAt(0)));
		}
		buf.append(str.substring(1));
		return buf.toString();
	}
	
	/**
	 * 全部改变字符大小写
	 */
	public static String changeCharacterCase(boolean capitalize,String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return str;
		}
		StringBuffer buf = new StringBuffer(strLen);
		int length = str.length();
		
		for(int i = 0;i < length; i++){
			if (capitalize) {
					buf.append(Character.toUpperCase(str.charAt(i)));
			}else {
				buf.append(Character.toLowerCase(str.charAt(i)));
			}
		}
		//buf.append(str.substring(1));
		return buf.toString();
	}
	
	/**
	 * 字符串不为空
	 */
	public static boolean isNotNull(String value) {
		return hasLength(value);
	}
	
	/**
	 * 对象不为空
	 */
	public static boolean isNotNull(Object value) {
		return hasLength(value);
	}
	
	public static boolean hasLength(String str) {
		return (str != null && str.length() > 0 && !"null".equals(str.toLowerCase()));
	}

	public static boolean hasLength(Object obj) {
		return (obj != null && (obj + "").length() > 0 && !"null".equals((obj + "").toLowerCase()));
	}
	
	/**
	 * @Description:替换空格，换行符，回车符等
	 * @param @param capitalize
	 * @param @param str
	 * @param @return
	 * @return String
	 */
	public static String replace(String str,String partner) {
		//Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Pattern p = Pattern.compile(partner);
		if(isNEmpty(str)){
			Matcher m = p.matcher(str);
			return m.replaceAll("");
		}
		return null;
	}
	
	/**
	 * 生成三位随机数
	 */
	public static String getNum() {
		Random random = new Random();
		String result = "";
		for (int i = 0; i < 3; i++) {
			result += random.nextInt(10);
		}
		return result;
	}
	
	/**
	 * 获取全球唯一性ID
	 * @return string
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	private static String dateTimeRegex = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";

	public static boolean isDateTime(String str){
	    if(null == str){
	        return false;
        }
		return Pattern.matches(dateTimeRegex, str);
	}
	
	public static void main(String[] args) {
		/*String str = "null1";
		if((str != null) && (str.length() > 0) && !"null".equals(str) && !"".equals(str)){
		    System.out.println("==============");
	    }else{
	    	System.out.println("-------------------");
	    }*/
		String aa = null;
		aa = "1";
		if(null != aa){
			System.out.println("-----------------");
		}else{
			System.out.println("+==============");
		}
	}
	
}

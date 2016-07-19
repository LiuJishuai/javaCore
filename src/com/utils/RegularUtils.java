package com.utils;
/**
 *
 * @Message:  created by Jeyson on 2016年7月19日
 * 
 * @Description:正则表达式工具
 *  
 */
public class RegularUtils {

	 public static final String INTEGER_STYLE="^-?[1-9]\\d*$";                 //整数
	 public static final String POINTEGER_STYLE="^[1-9]\\d*$";                 //正整数
	 public static final String NEINTEGER_STYLE="^-[1-9]\\d*$";                //负整数
	 public static final String FLOAT_STYLE="^([+-]?)[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*$";//浮点数
	 public static final String POFLOAT_STYLE="^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*$";   //正浮点数
	 public static final String NEFLOAT_STYLE="^-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)$";//负浮点数
	 public static final String IDCARD_STYLE="^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";   //身份证
	 public static final String IP_STYLE="^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$";//IPV4
	 public static final String CHINESE_STYLE="^[\\u4e00-\\u9fa5]+$";          //仅含中文
	 public static final String ASCII_STYLE="^[\\x00-\\xFF]+$";                //仅ASCII编码
	 public static final String LETTER_STYLE="^[A-Za-z]+$";                    //字母
	 public static final String LETTER_L_STYLE="^[a-z]+$";                     //小写字母
	 public static final String LETTER_U_STYLE="^[A-Z]+$";                     //大写字符
	 public static final String CELLPHONE_STYLE="^[1][34578]\\d{9}$";          //手机号码
	 public static final String QQ_STYLE="^[1-9]*[1-9][0-9]*$";                //QQ号码
	 public static final String ZIP_CODE_STYLE="^\\d{6}$";                     //邮编
	 public static final String EMAIL_STYLE="[_a-z\\d\\-\\./]+@[_a-z\\d\\-]+(\\.[_a-z\\d\\-]+)*(\\.(info|biz|com|edu|gov|net|am|bz|cn|cx|hk|jp|tw|vc|vn))$"; //邮箱
	 public static final String URL_STYLE="((http|ftp|https)://)([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$";//URL
}


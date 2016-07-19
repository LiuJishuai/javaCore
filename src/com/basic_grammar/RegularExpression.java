package com.basic_grammar;

import org.junit.Test;

import com.utils.RegularUtils;

/**
 *
 * @Message:  created by Liujishuai on 2015年12月23日
 * 
 * @Description:正则表达式
 */
public class RegularExpression {

	/**
	 * 正负号，数字
	 */
	@Test
	public void test1(){
		String style1="-\\d";//一个负号+一个数字  -2
		String style2="-?\\d";//可能有一个负号+一个数字  22
		String style3="-?\\d+";//可能一个负号+一个或多个数字  -222
		String style4="(-|\\+)?\\d+";//可能一个负号或正号+一个或多个数字  -222（正号在正则里有特殊意义，需要\\转义）
		System.out.println("匹配1:"+"-2".matches(style1));
		System.out.println("匹配2:"+"-2".matches(style2));
		System.out.println("匹配3:"+"-2".matches(style3));
		
		System.out.println("匹配11:"+"22".matches(style1));
		System.out.println("匹配22:"+"22".matches(style2));
		System.out.println("匹配33:"+"22".matches(style3));
		
		System.out.println("匹配111:"+"-222".matches(style1));
		System.out.println("匹配222:"+"-222".matches(style2));
		System.out.println("匹配333:"+"-222".matches(style3));
		System.out.println("匹配444:"+"-222".matches(style4));
		
		System.out.println("匹配1111:"+"+222".matches(style1));
		System.out.println("匹配2222:"+"+222".matches(style2));
		System.out.println("匹配3333:"+"+222".matches(style3));
		System.out.println("匹配4444:"+"+222".matches(style4));
		
	}
	@Test
	public void test2(){
		
		
		System.out.println("测试整数："+"13".matches(RegularUtils.INTEGER_STYLE));
		System.out.println("测试+整数："+"156".matches(RegularUtils.POINTEGER_STYLE));
		System.out.println("测试-整数："+"-12".matches(RegularUtils.NEINTEGER_STYLE));
		System.out.println("测试浮点数："+"-13.1".matches(RegularUtils.FLOAT_STYLE));
		System.out.println("测试+浮点数："+"156".matches(RegularUtils.POFLOAT_STYLE));
		System.out.println("测试-浮点数："+"12".matches(RegularUtils.NEFLOAT_STYLE));
		System.out.println("测试QQ号："+"185245414451".matches(RegularUtils.QQ_STYLE));
		System.out.println("测试IDCARD号："+"372923199012327541".matches(RegularUtils.IDCARD_STYLE));
		System.out.println("测试ip号："+"192.168.1.1".matches(RegularUtils.IP_STYLE));
		System.out.println("测试url号："+"http://blog.csdn.net/weasleyqi/article/details/7912647".matches(RegularUtils.URL_STYLE));
		System.out.println("测试phone号："+"18652124481".matches(RegularUtils.CELLPHONE_STYLE));
		System.out.println("测试email号："+"524172558@qq.com".matches(RegularUtils.EMAIL_STYLE));
		System.out.println("测试中文："+"好了".matches(RegularUtils.CHINESE_STYLE));
		
	}
	
	/**
	 * 测试switch
	 */
	@Test
	public void testSwitch(){
		    int temp=60;
	        Integer t=0;
	        t=temp%5==0?5:t;
	        t=temp%15==0?15:t;
	        t=temp%30==0?30:t;
	       switch (t) {
		    case 30:
		    	 System.out.println("测试结果:"+t);
			break;
		    case 15:
		    	 System.out.println("测试结果:"+t);
			break;
		    case 5:
		    	 System.out.println("测试结果:"+t);
			break;
		default:
			break;
		}

	}
}


package com.basic_grammar;

import org.junit.Test;

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


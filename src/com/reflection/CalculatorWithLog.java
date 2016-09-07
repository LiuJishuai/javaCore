package com.reflection;
/**
 *
 * @Message:  created by Jeyson on 2016年9月7日
 * 
 * @Description:计算器实现类，带日志
 *  
 */
public class CalculatorWithLog implements ICalculator {

	@Override
	public int add(int a, int b) {
		System.out.println("方法：add 开始，参数为："+a+","+b);
		int result=a+b;
		System.out.println("方法：add 结束，结果为："+result);
		return result;
	}

	@Override
	public int sub(int a, int b) {
		System.out.println("方法：sub 开始，参数为："+a+","+b);
		int result=a-b;
		System.out.println("方法：sub 结束，结果为："+result);
		return result;
	}

	@Override
	public int mul(int a, int b) {
		System.out.println("方法：mul 开始，参数为："+a+","+b);
		int result=a*b;
		System.out.println("方法：mul 结束，结果为："+result);
		return result;
	}

	@Override
	public int div(int a, int b) {
		System.out.println("方法：div 开始，参数为："+a+","+b);
		int result=a/b;
		System.out.println("方法：div 结束，结果为："+result);
		return result;
	}

}


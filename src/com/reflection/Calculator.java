package com.reflection;
/**
 *
 * @Message:  created by Jeyson on 2016年9月7日
 * 
 * @Description:原生的计算器实现类，不带日志（可以用动态代理来实现带日志）
 *  动态代理模拟日志实现AOP功能
 */
public class Calculator implements ICalculator {

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}

}


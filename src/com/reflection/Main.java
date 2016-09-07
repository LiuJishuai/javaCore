package com.reflection;
/**
 *
 * @Message:  created by Jeyson on 2016年9月7日
 * 
 * @Description:
 */
public class Main {

	public static void main(String[] args) {
		int a=10,b=4;
		// 不使用代理
		ICalculator calculator=new Calculator() ;
		ICalculator log=new CalculatorWithLog() ;
		System.out.println("++："+calculator.add(a, b));
		System.out.println("--："+calculator.sub(a, b));
		System.out.println("**："+calculator.mul(a, b));
		System.out.println("//："+calculator.div(a, b));
		System.out.println("-----------------------------------------------------");
		//使用带日志的实现类
		System.out.println("log++："+log.add(a, b));
		System.out.println("log--："+log.sub(a, b));
		System.out.println("log**："+log.mul(a, b));
		System.out.println("log//："+log.div(a, b));
		System.out.println("-----------------------------------------------------");
		//使用代理类实现日志功能
		ICalculator proxy=new CaculatorProxy(calculator).getLogCaculatorProxy();
		System.out.println("proxy++："+proxy.add(a, b));
		System.out.println("proxy--："+proxy.sub(a, b));
		System.out.println("proxy**："+proxy.mul(a, b));
		System.out.println("proxy//："+proxy.div(a, b));
		

	}

}


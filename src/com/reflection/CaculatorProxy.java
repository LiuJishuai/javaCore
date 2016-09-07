package com.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @Message:  created by Jeyson on 2016年9月7日
 * 
 * @Description: 动态代理类
 */
public class CaculatorProxy {
	//要代理的对象
    private ICalculator target;
    //构造器负责传进来需要代理的类
    public CaculatorProxy(ICalculator target) {
		this.target = target;
	}

	//
    public ICalculator getLogCaculatorProxy(){
    	ICalculator proxy=null;
    	//代理对象由哪个类加载器负责加载
    	ClassLoader classLoder=target.getClass().getClassLoader();
    	//代理对象的类型，即其中有哪些方法
    	Class [] interfaces=new Class[]{ICalculator.class};
    	//当调用代理对象方法时，需要执行的代理代码
    	InvocationHandler hander=new InvocationHandler() {
			/**
			 * proxy:正在返回的那个代理对象，一般情况下在invoke方法中不用
			 * method：正在被调用的方法
			 * args：调用方法传入的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//开始日志
				System.out.println("方法："+method.getName()+" 开始，参数为："+Arrays.asList(args));
				Object result=method.invoke(target, args);
			    //结束日志
				System.out.println("方法：sub 结束，结果为："+result);
				return result;
			}
		};
    	proxy=(ICalculator) Proxy.newProxyInstance(classLoder, interfaces, hander);
    	return proxy;
    }
    
}


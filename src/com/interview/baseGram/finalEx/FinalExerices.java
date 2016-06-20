package com.interview.baseGram.finalEx;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 *
 * @Message:  created by Liujishuai on 2016年6月20日
 * 
 * @Description: final关键字
 *   final 数据，方法，类
 */
public class FinalExerices {
    
	/**
	 * final数据：
	 *  用处：
	 *    1 需要一个永不改变的编译时常量
	 *    2 一个运行时被初始化的值，不希望被更改
	 *  好处：
	 *    编译时就执行的计算，减轻运行时的负担
	 *    
	 *  修饰：
	 *     基本类型时，数值恒定不变
	 *     对象引用时，一旦引用被初始化指向一个对象，就无法再将它更改指向另一个对象（该对象本身可以修改）
	 *     
	 *  空白final：
	 *     final修饰但又未给初值的域。
	 *     必须在域的定义处或构造器内用表达式给final进行赋值（final使用前必须被初始化）
	 *  注意：
	 *    被static和final同时修饰的域（编译期常量）一般用大写表示，下划线分隔单词
	 */
	private Random rand=new Random();
	private static  Random random=new Random();
	private final int n1=12;
	private final int number=rand.nextInt(30);
	private  static final int NUMBER2=random.nextInt(40);
	@Test
	public void finalDataTest(){
		System.out.println(n1);
		System.out.println("--------------------");
		System.out.println(rand.nextInt(30));
		System.out.println("--------------------");
		System.out.println("编译初始之后，不会改变："+number);
		System.out.println("--------------------");
		System.out.println("编译初始之后，不会改变："+NUMBER2);
		
	}
	/**
	 * final修饰参数：该参数可读，但无法修改。
	 * @param sk
	 * @return
	 */
	public String finalParam(final String sk){
		//sk="jeyson"; final参数不能被修改
		return sk;
		
	}
	/**
	 * final方法：
	 *   好处：
	 *     1 早前版本效率更高，jdk1.5后没差别了（可忽略）
	 *     2 方法锁定，确保继承中方法含义不变，不会被覆盖
	 *   对private方法可以使用final，但没什么意义
	 */
	public final String finalMethod(){
		return "Hello World";
	}
	
	
}


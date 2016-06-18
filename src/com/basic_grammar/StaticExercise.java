package com.basic_grammar;

import java.rmi.server.Skeleton;

import org.junit.Test;
import org.junit.experimental.theories.Theories;
import static com.generic.MyStaticImportTest.number;
import static com.generic.MyStaticImportTest.getMyWords;

/**
 *
 * @Message:  created by Liujishuai on 2016年6月18日
 * 
 * @Description:
 *  静态
 *  
 *
 */
public class StaticExercise {
	
	public static String sky="jeyson";
    
	public static String getMySky(String sky){
		return sky;
	}
	static {
		System.out.println("这是静态块中的内容--");
		System.out.println("静态块："+getMySky(sky));
	}
	/**
	 * ***静态对象好处：
	 *    1--静态对象的数据是全局唯一的，一改都改，可以保证数据唯一。
	 *    2--引用方便，直接类名.方法就行了，不用set和get
	 * ***分配空间顺序：
	 *    先分配静态对象空间再分配非静态。初始化顺序也是这样
	 * ***static final 修饰的成员变量和成员方法可以理解为全局变量（java中没有全局变量概念）
	 * ***静态对象，方法，块的限制：
	 *    1--只能调用其他的static方法
	 *    2--只能访问static数据
	 *    3--不能以任何方式引用this或super
	 * 静态对象测试
	 */
	@Test
	public void testStatic1(){
		System.out.println(sky);
		System.out.println("-----------------");
		System.out.println(getMySky(sky));
		System.out.println("-----------------");
		System.out.println(StaticTest.getSms());
		
	}
	/**
	 *静态内部类测试
	 * ***使用场景：
	 *    内部类跟外部类联系紧密，一般只有用到外部类的时候才会用到这个类
	 * ***使用
	 *    随类一同被加载，直接外部类.内部类.静态对象（方法）
	 */
	@Test
	public  void testStatic2(){
		System.out.println(StaticTest.InnerStatic.MYSKY);
	}
	/**
	 * 静态导包
	 * ***使用方法：
	 *   直接静态导入相应的变量和方法：（import static 包名.类名.静态成员变量（方法）
	 *       import static com.generic.MyStaticImportTest.number;
     *       import static com.generic.MyStaticImportTest.getMyWords;
     * *** 好处：
     *     被导入的静态方法和变量在这个类中直接可见，无需再给出类名
     * *** 坏处
     *     一定程度上降低了代码的可读性
	 */
	@Test
	public void testStatic3(){
		//静态导入后可以直接用
		int myNumber=number;
		getMyWords();
	}
	
}

class StaticTest{
	public static String sms="to my sky";
	public static String getSms(){
		return sms;
	}
	/**
	 * 静态内部类
	 * ***使用场景：
	 *    内部类跟外部类联系紧密，一般只有用到外部类的时候才会用到这个类
	 * ***使用
	 *    随类一同被加载，直接外部类.内部类.静态对象（方法）
	 */
	static  class InnerStatic{
		public static final String MYSKY="MY FINAL SKY";
	}
}


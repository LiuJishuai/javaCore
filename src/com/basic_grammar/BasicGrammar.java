package com.basic_grammar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 *
 * @Message:  created by Liujishuai on 2015年12月17日
 * 
 * @Description:
 */
public class BasicGrammar {
    
	
	
	
	public static void main(String[] args) {
		   
		int i=100;
		switch (i) {
		case 100:
			System.out.println(i);
		case 200:
			System.out.println(i);
		case 300:
			System.out.println(i);

		}

	}
	/**
	 * 可变长参数
	 * 
	 */
	public  void  testParams(String... args){
		/*可变长参数利用数组实现，所以也可以写成（只是这种不能是可变参数）：
		  String[] args={"aa","bb","cc"};
		   testParams(args);
         */
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
	/**
	 * 测试循环遍历
	 * 尽量使用Iterator，因为foreach也是使用Iterator实现的
	 * 而且任何可以进行foreach操作的类必须实现Iterator接口才行
	 */
	@Test
	public void testForEach(){
		 List<String> list = new ArrayList<String>();
		    list.add("111");
		    list.add("222");
		    for (Iterator<String> iterator=list.iterator();iterator.hasNext();)
		    {
		        System.out.println(iterator.next());
		    }
	}
}


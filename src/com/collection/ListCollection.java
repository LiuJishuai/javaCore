package com.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

/**
 *
 * @Message:  created by Liujishuai on 2015年11月3日
 * 
 * @Description: List  有序，可重复，每个元素都有对应的顺序索引
 * 
 */
public class ListCollection {

	/**
	 * ArrayList
	 */
	@Test
	public void TestArrayList(){
		List list=new ArrayList();
	   list.add("AA");
	   list.add("BB");
	   list.add("CC");
	   list.add("DD");
	   /**
	    * 1 使用集合的公共方法Iterator
	    */
	   Iterator it=list.iterator();
	   while (it.hasNext()) {
		System.out.println("公共Iterator："+it.next());
		
	}
	   /**
	    * 2.1 for循环
	    */
	   for(Object object:list){
		   System.out.println("for循环："+object);
	   }
	   /**
	    * 2.2 for循环
	    */
	   for(int i=0;i<list.size();i++){
		   System.out.println("for循环2："+list.get(i));
	   }
	   /**
	    * 3 使用List专属的ListIterator
	    * 具备向前查询的方法，因为有索引
	    */
	   list.add(2, "插入");//可以把一个元素放到指定索引位置
	   Object oo=list.get(2);//可以根据索引获取元素，也可以删除
	   List subList=list.subList(1,3);//两个索引之间子List（包含索引1,2两个元素）
	   ListIterator iterator=list.listIterator();
	   while(iterator.hasNext()){
		  System.out.println("ListIterator："+iterator.next());
	   }
		
	}
}


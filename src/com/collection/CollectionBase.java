package com.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

/**
 *
 * @Message:  created by Liujishuai on 2015年10月22日
 * 
 * @Description: 集合操作（集合操作使用所有子实现类）
 */
public class CollectionBase {

	/**
	 * 添加元素
	 */
	@Test
	public void testCollectionAdd(){
		Collection c1=new ArrayList<>();
		Collection c2=new ArrayList<>();
		c1.add("Hello");
		c1.add("World");
		c2.add("Collection");
		c2.addAll(c1);
		System.out.println(c2.size());
	}
	/**
	 * 访问集合(迭代器)
	 */
	@Test
	public void iteratorCollection(){
		Collection c1=new ArrayList<>();
		c1.add("Hello");
		c1.add("World");
        Iterator iterator=c1.iterator();
        while(iterator.hasNext()) {
			Object object=iterator.next();
			System.out.println(object);
			
		}
        System.out.println("----------------");
        //增强的for循环
        for (Object o:c1) {
			System.out.println(o);
		}
	}
	/**
	 * 移除集合中元素
	 * remove 移除一个
	 * clear 清空
	 * removeAll 移除一组，跟addAll差不多
	 */
	@Test
	public void CollectionRemove(){
		Collection c1=new ArrayList<>();
		c1.add("Hello");
		c1.add("World");
		c1.clear();//清空
		System.out.println(c1.size());
		String s1="hello";
		String s2="ketty";
		c1.add(s1);
		c1.add(s2);
		c1.remove(c1);
		System.out.println(c1.size());
		
	}
	/**
	 * 检测是否包含
	 */
	@Test
	public void checkCollection(){
		Collection c1=new ArrayList<>();
		c1.add("Hello");
		c1.add("World");
		Collection c2=new ArrayList<>();
		boolean b1=c1.contains("Hello");//true
		boolean b2=c1.contains(c2);//true
		boolean b3=c1.isEmpty();//false
	
	}
	/**
	 * 其他方法
	 */
	@Test
	public void others(){
		Collection c1=new ArrayList<>();
		c1.add("Hello");
		c1.add("World");
		Object[] obs=c1.toArray();
	}
}


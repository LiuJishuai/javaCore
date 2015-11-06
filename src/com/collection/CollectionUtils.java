package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 *
 * @Message: created by Liujishuai on 2015年11月6日
 * 
 * @Description: collections是操作集合的工具类
 */
public class CollectionUtils {

	/**
	 * 排序
	 */
	@Test
	public void testCompa() {
		List list = new ArrayList();
		list.add(new Person("A", 12));
		list.add(new Person("B", 15));
		list.add(new Person("C", 10));
		list.add(new Person("D", 8));
		// 按指定字段排序
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Person p1 = (Person) o1;
				Person p2 = (Person) o2;
				return p1.getAge() - p2.getAge();// 降序用p2-p1
			}
		});
		for (Object o : list) {
			System.out.println(o);
		}
		System.out.println("////////////////////////////////////");
		List list2 = new ArrayList();
		list2.add("AAAA");
		list2.add("CC");
		list2.add("BB");
		Collections.sort(list2);
		for (Object o : list2) {
			System.out.println(o);
		}
		// 集合反转
		System.out.println("反转排序：");
		Collections.reverse(list2);
		for (Object o : list2) {
			System.out.println(o);
		}
		// 集合随机排序
		System.out.println("随机排序：");
		Collections.shuffle(list2);
		for (Object o : list2) {
			System.out.println(o);
		}
		// 调换指定位置排序
		System.out.println("调换排序：");
		Collections.swap(list2, 0, 2);
		;
		for (Object o : list2) {
			System.out.println(o);
		}
		// 最大最小值
		System.out.println("最大值" + Collections.max(list2));
		System.out.println("最小值" + Collections.min(list2));

	}

	// 内部类
	class Person {
		private String name;
		private int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}

	}
}

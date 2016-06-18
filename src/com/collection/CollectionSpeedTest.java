package com.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.mail.internet.NewsAddress;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @Message: created by Liujishuai on 2016年4月9日
 * 
 * @Description:
 */
public class CollectionSpeedTest {

	public static int leng = 200000;
	private String[] array;
	private Set<String> set;
	private List<String> list;
	private Queue<String> queue;
	private Map<String, String> map;

	@Before
	public void init() {
		array = new String[leng];
		set = new HashSet<String>();
		list = new ArrayList<String>();
		queue = new LinkedList<String>();
		map = new HashMap<String, String>();
		for (int i = 0; i < leng; i++) {
			String key = "didi:" + i;
			String value = "da";
			array[i] = key;
			set.add(key);
			list.add(key);
			queue.add(key);
			map.put(key, value);

		}
	}

	// shzu
	@Test
	public void testArray() {
		Long startTime = new Date().getTime();
		for (String sk : array) {
			///
		}
		Long endTime = new Date().getTime();
		Long times = endTime - startTime;
		System.out.println("时间：" + times);
	}

	// list
	@Test
	public void testList() {
		Long startTime = new Date().getTime();
		for (String sk : list) {
			///
		}
		Long endTime = new Date().getTime();
		Long times = endTime - startTime;
		System.out.println("时间：" + times);
	}

	// map
	@Test
	public void testMap() {
		Long startTime = new Date().getTime();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			entry.getKey();
		}
		Long endTime = new Date().getTime();
		Long times = endTime - startTime;
		System.out.println("时间：" + times);
		Long startTime1 = new Date().getTime();
		for (String key : map.keySet()) {
			String value = (String) map.get(key);
		}
		Long endTime1 = new Date().getTime();
		Long times1 = endTime - startTime;
		System.out.println("时间1：" + times1);
	}
	

	// Queue
	@Test
	public void testQueue() {
		Long startTime = new Date().getTime();
		for (String s: queue) {
			//
		}
		Long endTime = new Date().getTime();
		Long times = endTime - startTime;
		System.out.println("时间1：" + times);
	}
	// Set
		@Test
		public void testSet() {
			Long startTime = new Date().getTime();
			for (String s: set) {
				//
			}
			Long endTime = new Date().getTime();
			Long times = endTime - startTime;
			System.out.println("时间：" + times);
		}
		
		
		@Test
		public void TestInit(){
			int le=2900000;
			Long s1= new Date().getTime();;
			Set set1 = new HashSet<String>();
			for (int i = 0; i < le; i++) {
				String key = "didi:" + i;
				set1.add(key);
			}
			Long e1= new Date().getTime();;
			Long t1=e1-s1;
			System.out.println("Set初始化："+t1);
			
			Long s2= new Date().getTime();;
			 List<String> list1=new ArrayList<>();
			for (int i = 0; i < le; i++) {
				String key = "didi:" + i;
				list1.add(key);
			}
			Long e2= new Date().getTime();;
			Long t2=e2-s2;
			System.out.println("List初始化："+t2);
			
			Long s3= new Date().getTime();;
			String[] array1 = new String[le];
			for (int i = 0; i < le; i++) {
				String key = "didi:" + i;
				array1[i]=key;
			}
			Long e3= new Date().getTime();;
			Long t3=e3-s3;
			System.out.println("array初始化："+t3);
			
		}
}

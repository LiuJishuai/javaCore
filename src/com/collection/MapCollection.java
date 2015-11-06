package com.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @Message:  created by Liujishuai on 2015年11月4日
 * 
 * @Description:
 */
public class MapCollection {
    
	/**
	 * 遍历
	 * key是一个Set集合
	 * value是一个类似List的集合
	 * 具体遍历方式见Collection_Map_Classic01
	 */
	public void getMapTest(){
		Map<String,String> map=new HashMap<String, String>();
		map.put("AA", "AAAA");
		map.put("BB", "BBBB");
		map.put("CC", "CCC");
		Set set=map.keySet();
	     Iterator iterator=set.iterator();
		 while (iterator.hasNext()){
			iterator.next();
		}
	}
}


package com.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @Message:  created by Liujishuai on 2015年10月9日
 * 
 * @Description: map的遍历四种方法
 */
public class Collection_Map_Classic01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> map=new HashMap<Integer, String>();
		map.put(1, "工行-ICBC");
		map.put(2, "中行-BOC");
		map.put(3, "建行-CCB");
		map.put(4, "交行-BCM");
		map.put(5, "招行-CMB");
		Map<Integer, String> map1=new HashMap<Integer, String>();
		Map<Integer, String> map2=new HashMap<Integer, String>();
		Map<Integer, String> map3=new HashMap<Integer, String>();
		Map<Integer, String> map4=new HashMap<Integer, String>();
		//第一种方法，二次取值 ,通过Map.keySet遍历key来完成
		for(Integer key:map.keySet()){
			map1.put(key, map.get(key));
		}
		//第二种方法，迭代器iterator
		Iterator<Map.Entry<Integer, String>> iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
        	Map.Entry<Integer, String> entry=iterator.next();
        	map2.put(entry.getKey(), entry.getValue());
        }
        //第三种方法，使用Map.entrySet遍历key和value。容量大时推荐使用
        for(Map.Entry<Integer, String> entry:map.entrySet()){
        	map3.put(entry.getKey(), entry.getValue());
        }
        //第四种方法，使用Map.values遍历value，但是没办法取的Key
        int i=1;
        for(String value:map.values()){
        	map4.put(i, value);
        	i=i+1;
        }
        //输出测试：（使用第三方方法遍历四个map输出数据）
        for(Map.Entry<Integer, String> entry:map1.entrySet()){
        	System.out.println("方案1的数据："+entry.getKey()+":"+entry.getValue());
        }
        for(Map.Entry<Integer, String> entry:map2.entrySet()){
        	System.out.println("方案2的数据："+entry.getKey()+":"+entry.getValue());
        }
        for(Map.Entry<Integer, String> entry:map3.entrySet()){
        	System.out.println("方案3的数据："+entry.getKey()+":"+entry.getValue());
        }
        for(Map.Entry<Integer, String> entry:map4.entrySet()){
        	System.out.println("方案4的数据："+entry.getKey()+":"+entry.getValue());
        }
	}
   
}


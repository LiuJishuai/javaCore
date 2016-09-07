package com.arithmetic;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSException;

import com.alibaba.fastjson.JSON;

/**
 *
 * @Message:  created by Jeyson on 2016年8月18日
 * 
 * @Description:
 */
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
    
    List<Integer> list=new ArrayList<>();
    list.add(1);
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    List<Integer> list2=new ArrayList<>();
    list2.add(1);
    list2.add(2);
    list.removeAll(list2);
    System.out.println(list);
  
	}

}


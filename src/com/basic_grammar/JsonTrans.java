package com.basic_grammar;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

/**
 *
 * @Message: created by Liujishuai on 2015年12月19日
 * 
 * @Description:
 */
public class JsonTrans {

	/**
	 * 使用谷歌GSON工具来实现JSON和Object转换
	 */
	@Test
	public void testGSON() {
		Milk milk = new Milk();
		milk.setName("银鹭核桃");
		milk.setBrand("银鹭");
		milk.setType("混合牛奶");
		// Gson().toJson(Object)实现javaBean到json数据转换
		String gsonString = new Gson().toJson(milk);
		System.out.println(gsonString);
		// Gson().fromJson(json, clazz)实现json到javaBean的转换
		Milk milk2 = new Gson().fromJson(gsonString, Milk.class);
		System.out.println(milk2.getName());
		
	}
   /**
    * 使用阿里巴巴fastjson实现JSON和Object转换
    */
	@Test
	public void testFastjson(){
		Milk milk = new Milk();
		milk.setName("冰糖雪梨");
		milk.setBrand("冰糖");
		milk.setType("混合果汁");
		//使用JSON.toJSONString(obj)方式来实现javaBean到json
		String jsonString=JSON.toJSONString(milk);
		System.out.println(jsonString);
		//使用JSON.parseObject(jsonString, clazz)可以将json数据转换成相应的javabean，可以是实体类，也可以是List，Map等集合类
		Milk milk2=JSON.parseObject(jsonString, Milk.class);
		System.out.println(milk2.getName());
	}

}

class Milk {
	private String name;
	private String brand;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
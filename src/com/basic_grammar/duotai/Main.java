package com.basic_grammar.duotai;
/**
 *
 * @Message:  created by Liujishuai on 2015年10月15日
 * 
 * @Description: 多态之 instanceof
 */
public class Main {
 
	public static void main(String[] args){
		
		Person p1=new Person();
		Person p2=new Women();
		Person p3=new Man();
		if(p1 instanceof Women){
			System.out.println("p1");
			p1.getInfo();
		}
		if(p2 instanceof Women){
			System.out.println("p2");
			p2.getInfo();
		}
		if(p3 instanceof Women){
			System.out.println("p3");
			p3.getInfo();
		}
	}
}


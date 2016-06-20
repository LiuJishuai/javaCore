package com.interview.baseGram.transientEx;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream.PutField;
import java.io.Serializable;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.poi.ss.extractor.ExcelExtractor;

/**
 *
 * @Message:  created by Liujishuai on 2016年6月20日
 * 
 * @Description:
 *    transient关键字
 *      transient只能修饰变量，表示该变量不能被序列化，用于实现Serializable可以序列化的类中
 *      在序列化对象的时候，这个属性不会序列化到指定的目的地（本地序列化或网络传输序列化）
 *      
 *      小结：
 *       1 被transient修饰的变量不再是对象持久化的一部分，该变量内容序列化后无法获得访问
 *       2 transient只能修饰变量，不能修饰类和方法
 *       3 被transient关键字修饰的变量不再能被序列化，一个静态变量无论是否被transient修饰，都不能序列化
 *       
 *     
 */
public class TransientEx  {
   
	public static void main(String[] args) {
		User user=new User();
		user.setUsername("jeyson");
		user.setPassword("123456");
		System.out.println("序列化前：");
		System.out.println("   username="+user.getUsername());
		System.out.println("   password="+user.getPassword());
		//序列化
		try {
			ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("C://MyResource//test1.txt"));
			os.writeObject(user);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//反序列化
		try {
			
			ObjectInputStream is=new ObjectInputStream(new FileInputStream("C://MyResource//test1.txt"));
			user=(User) is.readObject();
			is.close();
			System.out.println("序列化后：");
			System.out.println("   username="+user.getUsername());
			System.out.println("   password="+user.getPassword());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------------");
		
	}
}

class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private  String username;
	//使用 transient
	private transient String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	
}
	
	 
 

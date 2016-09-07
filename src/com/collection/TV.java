package com.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 *
 * @Message:  created by Jeyson on 2016年8月2日
 * 
 * @Description:
 */
public class TV {
   public static void main(String[] args) {
		CCTV tv=new SDTV();
		//因为static关系，getName是CCTV
		System.out.println("TV:"+tv.getName()+",price:"+tv.getprice());
	   
	}
   
}

class CCTV{
	 public int price=10;
	   public int getprice(){
		   return price;
	   }
	   public static String getName(){
		   return "CCTV";
	   }
}
class SDTV extends CCTV{
	
	public int price=20;
	
	public int getprice(){
		return price;
	}
	public int getSuperPrice(){
		return super.price;
	}

	public static String getName(){
		return "SDTV";
	}
	
	public String getSuperName(){
		return super.getName();
	}
}


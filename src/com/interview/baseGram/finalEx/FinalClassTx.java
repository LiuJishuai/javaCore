package com.interview.baseGram.finalEx;
/**
 *
 * @Message:  created by Liujishuai on 2016年6月20日
 * 
 * @Description:
 * final类
 */
public final class FinalClassTx {
   private int k;
   
   public void getMyWord(){
	   System.out.println("这是一个final类，k的值是"+getK());
   }
   
public int getK() {
	return k;
}
public void setK(int k) {
	this.k = k;
}
   
}


package com.thread;
/**
 *
 * @Message:  created by Liujishuai on 2015年11月9日
 * 
 * @Description:
 */
public class BaseThread {

	
	public static void main(String[] args) {
		Thread threadChild=new ThreadChild("Thread1");
		threadChild.start();
		String name=Thread.currentThread().getName();
		for (int i = 0; i < 50; i++) {
			System.out.println(name+":"+i);
		}
		
	}
	
}

class ThreadChild extends Thread{
	public ThreadChild(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(int i=0;i<50;i++){
			System.out.println(getName()+":"+i);
		}
	}
}
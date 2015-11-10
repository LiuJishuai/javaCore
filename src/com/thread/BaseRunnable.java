package com.thread;
/**
 *
 * @Message:  created by Liujishuai on 2015年11月9日
 * 
 * @Description:
 */
public class BaseRunnable implements Runnable {
    
	int i=0;
	@Override
	public void run() {
		for (; i < 50; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
		
	}

	public static void main(String[] args) {
		BaseRunnable baseRunnable=new BaseRunnable();
		Thread thread1=new Thread(baseRunnable);
		Thread thread2=new Thread(baseRunnable);
		thread1.start();
		thread2.start();
	}
}


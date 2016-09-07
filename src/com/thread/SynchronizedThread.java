package com.thread;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Message:  created by Liujishuai on 2015年12月23日
 * 
 * @Description:
 */
public class SynchronizedThread implements Runnable{
	//定义取票数量
    private int ticketCount;
    
	public int getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}
	
	public synchronized boolean getTicket(){
		System.out.println("**目前还有票数："+ticketCount);
		if(ticketCount>0){
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ticketCount--;
			System.out.println("  "+Thread.currentThread().getName()+"购买一张车票，"+"剩余票数"+ticketCount);
			return true;
		}else {
			System.out.println("  "+Thread.currentThread().getName()+"来购买车票，票卖完了");
			return false;
		}
		
	}
	@Override
	public void run() {
		
			while (ticketCount>0){
				//System.out.println(Thread.currentThread().getName()+"来买票了，还剩"+ticketCount);
				getTicket();
				
			}
				//System.out.println(Thread.currentThread().getName()+"来买票，但是票卖完了");
			
		}
		
	
	
	public static void main(String[] args) {
		SynchronizedThread sn=new SynchronizedThread();
		sn.setTicketCount(40);
		Thread th1=new Thread(sn,"小王");
		Thread th2=new Thread(sn,"小韩");
		Thread th3=new Thread(sn,"小刘");
		th1.start();
		th2.start();
		th3.start();
		List<Object> kk=new ArrayList<>();
	}

}


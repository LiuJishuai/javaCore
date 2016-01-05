package com.thread;
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
		
		if(ticketCount>0){
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ticketCount--;
			System.out.println(Thread.currentThread().getName()+"购买一张车票"+"还剩"+ticketCount);
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public void run() {
		
			while (ticketCount>0){
				//System.out.println(Thread.currentThread().getName()+"来买票了，还剩"+ticketCount);
				getTicket();
				
			}
				System.out.println(Thread.currentThread().getName()+"来买票，但是票卖完了");
			
		}
		
	
	
	public static void main(String[] args) {
		SynchronizedThread sn=new SynchronizedThread();
		sn.setTicketCount(8);
		Thread th1=new Thread(sn,"小王");
		Thread th2=new Thread(sn,"小韩");
		th1.start();
		th2.start();
	}

}


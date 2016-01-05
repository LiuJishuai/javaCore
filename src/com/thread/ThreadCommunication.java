package com.thread;
/**
 *
 * @Message:  created by Liujishuai on 2015年12月25日
 * 
 * @Description:
 */
public class ThreadCommunication implements Runnable{
   
	private char key;
	
	
	public void setKey(char key) {
		this.key = key;
	}
	public synchronized void printChar(){
		if(key<='z'){
			System.out.println(Thread.currentThread().getName()+"："+key);
			key++;
			notifyAll();
		  try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	@Override
	public void run() {
		while (key<='z') {
			printChar();
			
		}
		
	}
    public static void main(String[] args) {
		ThreadCommunication communication=new ThreadCommunication();
		communication.setKey('a');
		Thread wwThread=new Thread(communication,"木木");
		Thread hhThread=new Thread(communication,"塔塔");
		wwThread.start();
		hhThread.start();
		
	}
}


package com.thread;

/**
 *
 * @Message: created by Liujishuai on 2015年11月9日
 * 
 * @Description:
 */
public class BaseRunnable implements Runnable {

	int i = 0;

	@Override
	public void run() {
		for (; i < 50; i++) {
//
//			try {
//				//暂时休眠（毫秒）
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			System.out.println(Thread.currentThread().getName() + ":" + i);
		}

	}

	public static void main(String[] args) {
		BaseRunnable baseRunnable = new BaseRunnable();
		Thread thread1 = new Thread(baseRunnable, "Thread-1");
		Thread thread2 = new Thread(baseRunnable, "Thread-2");
		thread1.start();
		thread2.start();
		for(int i=0;i<10;i++){
			if(i>2){
				System.out.println("join开始吧----------------------");
				try {
					thread2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Main:"+i);
		}
		
	
	}
}

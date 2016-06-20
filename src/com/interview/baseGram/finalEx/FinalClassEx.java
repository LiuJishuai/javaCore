package com.interview.baseGram.finalEx;

/**
 *
 * @Message: created by Liujishuai on 2016年6月20日
 * 
 * @Description: final类： 不希望被任何继承
 */
public class FinalClassEx {
	public static void main(String[] args) {
		FinalClassTx tx = new FinalClassTx();
		tx.setK(99);
		tx.getMyWord();
	}

}

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

/**
 *
 * @Message:  created by Liujishuai on 2016年6月20日
 * 
 * @Description:
 * 
 *  Externalizable：
 *        实现Serializable接口的类，所有的序列化会自动进行。
 *        实现Externalizable接口类，没有任何东西可以自动序列化。无论是否用transient对结果都没影响。
 *          此时如果需要序列化，则需要在writeExternal方法中上进行手动指定索要序列化的变量。
 */
public class ExternalizableEx implements Externalizable {
	private transient String name="ssss";
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name=(String) in.readObject();
		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);		
	}
   
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		 ExternalizableEx ex=new ExternalizableEx();
		 ex.setName("jeyson");
		 System.out.println("Externalizable序列化前:");
		 System.out.println(ex.getName());
		 //序列化
		 try {
			 ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(new File("C://MyResource//test2.txt")));
			 os.writeObject(ex);
			 os.flush();
			 os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 //反序列化
		 try {
			 ObjectInputStream is=new ObjectInputStream(new FileInputStream(new File("C://MyResource//test2.txt")));
			 ex=(ExternalizableEx) is.readObject();
			 is.close();
			 System.out.println("Externalizable序列化后:");
			 System.out.println(ex.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


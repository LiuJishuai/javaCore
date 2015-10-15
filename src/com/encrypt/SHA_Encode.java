package com.encrypt;

import java.security.MessageDigest;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

/**
 *
 * @Message:  created by Liujishuai on 2015年10月15日
 * 
 * @Description:
 */
public class SHA_Encode {
	 /** 
     * SHA-1消息摘要算法 
     */  
    public static String encodeSHA(String data,String salt) throws Exception {  
        // 初始化MessageDigest,SHA即SHA-1的简称  
        MessageDigest md = MessageDigest.getInstance("SHA");  
        // 执行摘要方法  
        byte[] digest = md.digest((data+salt).getBytes("UTF-8"));  
        return new HexBinaryAdapter().marshal(digest);  
    }  
  
    /** 
     * SHA-256消息摘要算法 
     */  
    public static String encodeSHA256(String data,String salt) throws Exception {  
        // 初始化MessageDigest,SHA即SHA-1的简称  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
        // 执行摘要方法  
        byte[] digest = md.digest((data+salt).getBytes("UTF-8"));  
        return new HexBinaryAdapter().marshal(digest);  
        
    }  
  
    /** 
     * SHA-384消息摘要算法 
     */  
    public static String encodeSHA384(String data,String salt) throws Exception {  
        // 初始化MessageDigest,SHA即SHA-1的简称  
        MessageDigest md = MessageDigest.getInstance("SHA-384");  
        // 执行摘要方法  
        byte[] digest = md.digest((data+salt).getBytes("UTF-8"));  
        return new HexBinaryAdapter().marshal(digest);  
    }  
  
    /** 
     * SHA-512消息摘要算法 
     */  
    public static String encodeSHA512(String data,String salt) throws Exception {  
        // 初始化MessageDigest,SHA即SHA-1的简称  
        MessageDigest md = MessageDigest.getInstance("SHA-512");  
        // 执行摘要方法  
        byte[] digest = md.digest((data+salt).getBytes("UTF-8"));  
        return new HexBinaryAdapter().marshal(digest);  
    }  

  
/** 
 * 测试类 
 */  

    public static void main(String[] args) throws Exception {  
       String data="Jeyson";  
       String salt="ask";
       System.out.println(encodeSHA(data,salt));  
       System.out.println(encodeSHA256(data,salt));  
       System.out.println(encodeSHA384(data,salt));  
       System.out.println(encodeSHA512(data,salt));  
    }  
}


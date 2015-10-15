package com.encrypt;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.apache.commons.codec.digest.DigestUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @Message:  created by Liujishuai on 2015年10月15日
 * 
 * @Description:  java自身提供MD2，MD5加密（16位），自定义32位的MD5加密；Apache提供的MD2，MD5加密
 */
public class MD_Encode {

	/**
	 * BASE64加密
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static String decryptBASE64(String code) throws Exception{
		return ((new BASE64Decoder()).decodeBuffer(code)).toString();
	}
	/**
	 * BASE64解密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(String data) throws Exception{
		return (new BASE64Encoder()).encode(data.getBytes("UTF-8"));
	}
	  /**
	   * java自身提供的 MD2加密  
	   * @param data
	   * @return
	   * @throws Exception
	   */
    public static String encodeMd2(byte[] data) throws Exception {  
        // 初始化MessageDigest  
        MessageDigest md = MessageDigest.getInstance("MD2");  
        // 执行摘要信息  
        byte[] digest = md.digest(data);  
        // 将摘要信息转换为32位的十六进制字符串  
        return new String(new HexBinaryAdapter().marshal(digest));  
    }  
  /**
   * java自身提供的 MD5加密  
   * @param data
   * @return
   * @throws Exception
   */ 
    public static String encodeMd5(byte[] data) throws Exception {  
        // 初始化MessageDigest  
        MessageDigest md = MessageDigest.getInstance("MD5");  
        // 执行摘要信息  
        byte[] digest = md.digest(data);  
        // 将摘要信息转换为32位的十六进制字符串  
        return new String(new HexBinaryAdapter().marshal(digest));  
    }  
	/**
	 * 自定义32位的 MD5加密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encryptMD5(String data) throws Exception{
		  char hexDigits[] = {
		            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		            'a', 'b', 'c', 'd', 'e', 'f'
		        };
		        char str[];
		        byte strTemp[] = data.getBytes("UTF-8");
		        try {
		            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
		            mdTemp.update(strTemp);
		            byte md[] = mdTemp.digest();
		            int j = md.length;
		            str = new char[j * 2];
		            int k = 0;
		            for (int i = 0; i < j; i++)
		            {
		                byte byte0 = md[i];
		                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
		                str[k++] = hexDigits[byte0 & 0xf];
		            }

		            return new String(str);
		        } catch (NoSuchAlgorithmException e) {
		            e.printStackTrace();
		        }
		        
		        return null;
	}
	 // MD5加密 返回十六进制的字符串  
    public static String encodeApacheMd5Hex(byte[] data) throws Exception {  
        return DigestUtils.md5Hex(data);  
    }  
  
    // MD5加密,返回十进制的字节数组  
    public static byte[] encodeApacheMd5(byte[] data) {  
        return DigestUtils.md5(data);  
    }  
}


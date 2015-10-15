package com.encrypt;

import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import com.exception.MyException;

/**
 *
 * @Message: created by Liujishuai on 2015年10月10日
 * 
 * @Description:
 */
public class HMAC_Classic {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String keyString = "secret";
		String dataString = "Message--|sjhaksh--工商局";
		System.out.println(HMACSHA256(keyString, dataString));
		System.out.println(HMACSHA256_digest(keyString, dataString));
	}
	/**
	 * HMAC-SHA256加密（京东架构师开涛的shiro框架讲解中使用的加密验证的方案，权威性较高）
	 * @param key 秘钥
	 * @param content 加密数据
	 * @return
	 */
	public static String HMACSHA256_digest(String key, String content) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            byte[] secretByte = key.getBytes("utf-8");
            byte[] dataBytes = content.getBytes("utf-8");

            SecretKey secret = new SecretKeySpec(secretByte, "HmacSHA256");
            mac.init(secret);

            byte[] doFinal = mac.doFinal(dataBytes);
            byte[] hexB = new Hex().encode(doFinal);
            return new String(hexB, "utf-8");
        } catch (Exception e) {
            throw new MyException(e);
        }
    }
	/**
	 * HMAC-SHA256加密（重载方案）
	 * @param key 秘钥
	 * @param map 加密数据
	 * @return
	 */
    @SuppressWarnings("unchecked")
	public static String HMACSHA256_digest(String key, Map<String, ?> map) {
        StringBuilder s = new StringBuilder();
        for(Object values : map.values()) {
            if(values instanceof String[]) {
                for(String value : (String[])values) {
                    s.append(value);
                }
            } else if(values instanceof List) {
                for(String value : (List<String>)values) {
                    s.append(value);
                }
            } else {
                s.append(values);
            }
        }
        return HMACSHA256_digest(key, s.toString());
    }
	/**
	 * 基于HMAC-SHA256的base64加密（优点：各个平台都有相应的方案：http://blog.csdn.net/js_sky/article/details/49024959#）
	 * @param key 秘钥
	 * @param data 需要加密的数据
	 * @return
	 */
	public static String HMACSHA256(String key, String data) {
		try {
			Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
			SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("utf-8"),
					"HmacSHA256");
			sha256_HMAC.init(secret_key);
			String hash = Base64.encodeBase64String(sha256_HMAC.doFinal(data
					.getBytes("utf-8")));
			return hash;
		} catch (Exception e) {
			System.out.println("Error");
		}
		return null;
	}
}

package com.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.exception.MyException;
import com.thoughtworks.xstream.XStream;

/**
 *
 * @Message:  created by Liujishuai on 2016年2月14日
 *  post和get请求，maven包：org.apache.httpcomponents
 * @Description:
 */
public class HttpUtils {

	 /**
     * 发送http请求
     * @param url
     * @param formparams
     * @return
     * @throws IOException
     */
    public static String post(String url, List<NameValuePair> formparams) throws IOException {
        try {
            /*// 编码参数
            List<NameValuePair> formparams = new ArrayList<NameValuePair>(); // 请求参数
            for (NameValuePair p : params) {
                formparams.add(p);
            }*/
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams,
                    "UTF-8");
            // 创建POST请求
            HttpPost request = new HttpPost(url);
            request.setEntity(entity);
            // 发送请求
            HttpClient client = HttpClients.createDefault();
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new RuntimeException("请求失败");
            }
            HttpEntity resEntity = response.getEntity();
            return (resEntity == null) ? null : EntityUtils.toString(resEntity, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        } catch (ClientProtocolException e) {
            return null;
        } catch (IOException e) {
            throw new RuntimeException("连接失败", e);
        }

    }

    /**
     * 发送http请求
     * @param url
     * @param param  格式： a=1&b=2
     * @return
     * @throws IOException
     */
    public static String get(String url,String param) throws IOException {
    	 HttpClient httpClient = HttpClients.createDefault();
    	 HttpGet httpGet = null;
    	 if(param!=null&&!param.isEmpty()){
    		 httpGet = new HttpGet(url+"?"+param);
    	 }else {
    		 httpGet = new HttpGet(url);
		}
         
         HttpResponse response = null;
         String result=null;
         try {
             response = httpClient.execute(httpGet);
             result=EntityUtils.toString(response.getEntity());
             if(!result.contains("id")){
            
                 throw new MyException("发送短信失败,错误码:"+result);
             }else {
				return result;
			}
         } catch (IOException e) {
            
             throw new MyException("短信发送失败");
         }
    }
    
    /**
     * 测试http请求
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
    	String urlString="http://192.168.XX.XXX/xx/xxx/member/login";
//    	
//         List<NameValuePair> list=new ArrayList<>();
//         list.add(new BasicNameValuePair("username","xxxxxx"));
//         list.add(new BasicNameValuePair("password","xxxxxxxxx"));
//         String sk= post(urlString,list);
////         XStream xStream=new XStream();
////         String ss=xStream.fromXML(sk).toString();
//         System.out.println(sk);
    	
    	String paramString="a=12&b=123";
    	String resString=get(urlString, paramString);
	}
}


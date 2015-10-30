package com.utils;
import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.codec.binary.StringUtils;

import com.exception.MyException;

/**
 *
 * @Message:  created by Liujishuai on 2015年10月29日
 * 
 * @Description:
 */
public class JavaMail {
	

        //邮箱服务器
    //private static final String SMTP_SERVER = "smtp.163.com";
    private static final String SMTP_SERVER = "smtp.qq.com";
    //用户名
    private static final String APIKey = "liujishuai@supuy.com";
    //密码
    private static final String APISecret = "*****";
    //发送来源
    private static final String EmailFrom="liujishuai@supuy.com";
    public static void sendEmail(String recipient, String subject,String fileAttachment,String content) throws Exception {
        String ttId=new Date().toString();
        Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTP_SERVER);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "25");
        properties.put("mail.transport.protocol", "smtp");
        InternetAddress[] receiveAddresses = new InternetAddress[1];
        try {
            receiveAddresses[0] = new InternetAddress(recipient);
        } catch (AddressException e) {
            e.printStackTrace();
        }
        Session session = Session.getInstance(properties, new SmtpAuth());
        //session.setDebug(true);
       // session.setDebugOut(new PrintStream("SMTPLog.txt"));
        MimeMessage message = new MimeMessage(session);
        MimeMultipart multipart = new MimeMultipart();
        multipart.setSubType("alternative");

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(content, "text/html; charset=utf-8");
        multipart.addBodyPart(bodyPart);
        if (fileAttachment!=null) {
            DataSource dataSource = new FileDataSource(fileAttachment);
            String name = dataSource.getName();
            bodyPart = new MimeBodyPart();
            bodyPart.setDataHandler(new DataHandler(dataSource));
            bodyPart.setFileName(MimeUtility.encodeText(name));
            multipart.addBodyPart(bodyPart);
        }
        message.setSubject(subject);
        message.setContent(multipart);
        message.setFrom(new InternetAddress(EmailFrom));
        message.setRecipients(Message.RecipientType.TO, receiveAddresses);
        InternetAddress[] addresses = new InternetAddress[1];
        addresses[0] = new InternetAddress(recipient);
        message.setReplyTo(addresses);
       // message.addHeader("X-List", MimeUtility.encodeText("联系人列表名称"));
        message.addHeader("X-Campaign", MimeUtility.encodeText(ttId));
        message.addHeader("X-Qos", "transactional");
        try{
            Transport.send(message);
           
        }catch (Exception e){
           
            throw new MyException("邮件发送失败,收件人:"+recipient+",标题:"+subject);
        }

/**
 * 获取返回信息
 */
//        File file = new File("SMTPLog.txt");
//        BufferedReader reader = null;
//        try {
//        reader = new BufferedReader(new FileReader(file));
//        String tempString = null;
//        while ((tempString = reader.readLine()) != null) {
//            if (tempString.lastIndexOf("250 ok:") != -1) {
//                System.out.println("返回数据为： " + tempString);
//            }
//        }
//        reader.close();
//    } catch (IOException e) {
//        e.printStackTrace();
//    } finally {
//        if (reader != null) {
//            reader.close();
//        }
//    }

}
static class SmtpAuth extends Authenticator {
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(APIKey,APISecret);
    }
}

public static void main(String[] args) throws Exception{
	
	sendEmail("534172885@qq.com", "测试一下试试", null, "我觉得上午去菏泽好点，把你的感觉写下来吧");
}
	}




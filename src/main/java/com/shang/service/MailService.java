package com.shang.service;

/**
 * Created by liuzhixiong on 2018/4/16.
 */
public interface MailService {

    //发送简单邮件
    public void sendSimpleMail(String to, String subject, String content) throws Exception;

    //发送html
    public void sendHtmlMail(String to, String subject, String content) throws Exception;

    //发送带附件的邮件
    public void sendAttachmentsMail(String to, String subject, String content, String filePath)throws Exception;
    //静态资源
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId)throws Exception;
}

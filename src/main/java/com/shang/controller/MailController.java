package com.shang.controller;

import com.shang.entity.ResultMap;
import com.shang.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liuzhixiong on 2018/4/16.
 */
@RestController
public class MailController {
    @Autowired
    private MailService mailServiceImpl;

  /*  @RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
    String index(){
        return "Hello Spring Boot!";
    }*/
    @RequestMapping(value = "/sendSimpleMail",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap sendSimpleMail(@RequestParam(value = "to") String to, @RequestParam(value = "subject") String subject, @RequestParam(value = "content") String content){

        try {
            mailServiceImpl.sendSimpleMail(to, subject, content);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultMap.build(400,"发送邮件失败",e.getMessage());

        }
        return ResultMap.ok();
    }

    @RequestMapping(value = "/sendHtmlMail",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap sendHtmlMail(@RequestParam(value = "to") String to, @RequestParam(value = "subject") String subject, @RequestParam(value = "content") String content){

        try {
            mailServiceImpl.sendHtmlMail(to, subject, content);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultMap.build(400,"发送邮件失败",e.getMessage());

        }
        return ResultMap.ok();
    }

    @RequestMapping(value = "/sendAttachmentsMail",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap sendAttachmentsMail(@RequestParam(value = "to") String to, @RequestParam(value = "subject") String subject,
                                         @RequestParam(value = "content") String content,@RequestParam(value = "filePath") String filePath){

        try {
            mailServiceImpl.sendAttachmentsMail(to, subject, content,filePath);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultMap.build(400,"发送邮件失败",e.getMessage());

        }
        return ResultMap.ok();
    }

    @RequestMapping(value = "/sendInlineResourceMail",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap sendInlineResourceMail(@RequestParam(value = "to") String to, @RequestParam(value = "subject") String subject,
                                         @RequestParam(value = "content") String content,@RequestParam(value = "rscPath") String rscPath,
                                            @RequestParam(value = "rscId") String rscId){

        try {
            mailServiceImpl.sendInlineResourceMail(to, subject, content,rscPath,rscId);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultMap.build(400,"发送邮件失败",e.getMessage());

        }
        return ResultMap.ok();
    }
}

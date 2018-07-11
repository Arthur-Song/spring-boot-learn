package com.arthursong.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMailService {
    @Autowired
    private MailService mailService;

    @Test
    public void testSendSimpleMail(){
        mailService.sendSimpleMail("主题：简单邮件","简单邮件测试内容");
    }

    @Test
    public void testSendHtmlMail(){
        String content="<html><body><h1>标题</h1><h2>标题</h2><h3>标题</h3><h4>标题</h4><h5>标题</h5><h6>标题</h6></body></html>";
        mailService.sendHtmlMail("主题：html邮件",content);
    }

    @Test
    public void testSendAttachmentsMail(){
        String filePath = "E:\\test\\test.txt";
        mailService.sendAttachmentsMail("主题：带附件邮件","带附件邮件测试内容",filePath);
    }

    @Test
    public void testSendInlineResourceMail(){
        String rscId = "picture";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "E:\\test\\picture.jpg";
        mailService.sendInlineResourceMail("主题：带静态资源邮件",content,imgPath,rscId);
    }

    @Test
    public void testSendTemplateMail(){
        Context context = new Context();
        context.setVariable("username","ArthurSong");
        mailService.sendTemplateMail("主题：模板邮件","template",context);
    }
}

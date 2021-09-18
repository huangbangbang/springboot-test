package com.ysb.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootTestApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("邮件主题");
        mailMessage.setText("邮件内容");
        mailMessage.setTo("3497618951@qq.com");
        mailMessage.setFrom("huangbangbang666@163.com");
        javaMailSender.send(mailMessage);
    }
    @Test
    void contextLoads1() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setSubject("邮件主题");
        mimeMessageHelper.setText("<p style='color:red'>邮件内容</p>",true);
        mimeMessageHelper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Desktop\\1.jpg"));
        mimeMessageHelper.addAttachment("2.txt",new File("C:\\Users\\Administrator\\Desktop\\2.txt"));
        mimeMessageHelper.setTo("3497618951@qq.com");
        mimeMessageHelper.setFrom("huangbangbang666@163.com");
        javaMailSender.send(mimeMessage);
    }

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /*@RequestMapping("set")
    public void set(){
        redisTemplate.setKeySerializer(new );
        user.setId(1);
        user.setName("jack");
        redisTemplate.opsForStream("user",user);
    }*/

    @Test
    public void get(){
        System.out.println((String) redisTemplate.opsForValue().get("k1"));

    }

}

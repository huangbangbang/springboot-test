package com.ysb.test;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.ysb.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    /*@RequestMapping("set")
    public void set(){
        redisTemplate.setKeySerializer(new );
        user.setId(1);
        user.setName("jack");
        redisTemplate.opsForStream("user",user);
    }*/

    @RequestMapping("/get")
    public String get(){
        return (String) redisTemplate.opsForValue().get("k1");

    }
}

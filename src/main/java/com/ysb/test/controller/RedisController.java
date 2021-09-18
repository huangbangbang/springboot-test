package com.ysb.test.controller;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.ysb.test.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@RestController
public class RedisController {

    @Autowired
    private User user;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/get1")
    public List get1() {
        List<Object> values = redisTemplate.opsForHash().values("user");
        return values;

    }
    @RequestMapping("/get2")
    public Map get2() {
        Map<Object, Object> entries = redisTemplate.opsForHash().entries("user");
        return entries;

    }
    @RequestMapping("/get3")
    public Object get3() {
        Object o = redisTemplate.opsForHash().get("user", "userName");
        return o;

    }
    @RequestMapping("/get4")
    public Set get4() {
        Set<Object> keys = redisTemplate.opsForHash().keys("user");
        return keys;

    }

    @RequestMapping("/set")
    public String set() {
        user.setName("tom");
        user.setId(1);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.opsForHash().put("user","userID",user.getId().toString());
        redisTemplate.opsForHash().put("user","userName",user.getName());
        /*redisTemplate.opsForValue().set("userName",user.getName());
        redisTemplate.opsForValue().set("userId",user.getId().toString());*/
        System.out.println("设置成功");
        return "设置成功";
    }
}

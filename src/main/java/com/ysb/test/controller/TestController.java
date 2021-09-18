package com.ysb.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

        @RequestMapping("/log")
        public String testLog(){
            log.debug("#########  debug  #########");
            log.info("#########  info  #########");
            log.error("#########  error  #########");
            return "返回值";
        }
}

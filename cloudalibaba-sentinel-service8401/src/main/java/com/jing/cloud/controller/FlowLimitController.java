package com.jing.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.jing.cloud.service.FlowLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "---------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "---------testB";
    }


    //C和D两个请求都访问flowLimitService.common()方法，对C限流，对D不管
    @Autowired
    private FlowLimitService flowLimitService;
    @GetMapping("/testC")
    public String testC(){
        flowLimitService.common();
        return "--------testC";
    }

    @GetMapping("/testD")
    public String testD(){
        flowLimitService.common();
        return "--------testD";
    }

    @GetMapping("/testE")
    public String testE(){
        System.out.println(Thread.currentThread().getName() + "\t" + "testE,排队等待");
        return "--------testE";
    }

    @GetMapping("/hotkey")
    @SentinelResource(value = "hotkey",blockHandler = "hotKeyHandler")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "hotKey------------";
    }


    public String hotKeyHandler(String s1, String s2){
        return "default_hotKeyHandler!:";
    }
}

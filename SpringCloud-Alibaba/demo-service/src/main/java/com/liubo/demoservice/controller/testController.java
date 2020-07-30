package com.liubo.demoservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：liubo
 * @date ：Created in 2020/7/30 13:10
 * @description：测试接口
 */
@RestController
@RequestMapping("/impl")
public class testController {

    @RequestMapping("/time")
    public String getTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

}

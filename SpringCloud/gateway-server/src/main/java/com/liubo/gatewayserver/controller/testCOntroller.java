package com.liubo.gatewayserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassNametestCOntroller
 * @Description 接口测试
 * @Author liubo
 * @Date 2020/7/20 17:25
 */
@RestController
@RequestMapping("/impl")
public class testCOntroller {
	@RequestMapping("/time")
	public String getTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}

	@RequestMapping("/hello")
	public String hello(){

		return "hello";
	}

}

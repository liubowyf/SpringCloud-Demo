package com.liubo.demoservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassNametestController
 * @Description 模拟测试接口
 * @Author liubo
 * @Date 2020/6/22 10:16
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

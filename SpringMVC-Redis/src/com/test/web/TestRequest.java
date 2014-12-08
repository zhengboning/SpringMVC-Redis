package com.test.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPipeline;

import com.test.test.RedisInitBean;

@Controller
@RequestMapping("/TestRequest")
public class TestRequest {

	@Autowired
	private RedisInitBean rib;
	
	@RequestMapping("/test")
	public ModelAndView test(@RequestParam(value = "username") final String userid,@RequestParam(value = "password") final String passwd, HttpSession session){	
		ModelAndView m = new ModelAndView();
		m.setViewName("../index");	
		ShardedJedis jedis = rib.getSingletonInstance();
		ShardedJedisPipeline pipeline = jedis.pipelined();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 99999; i++) {
			pipeline.set("zhenbn" + i, "n" + i);      
		}
		List<Object> results = pipeline.syncAndReturnAll();
		long end = System.currentTimeMillis();
		rib.returnResource();
		rib.destroy();
		System.out.println("分布式连接池异步调用耗时: " + ((end - start)/1000.0) + " 秒");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(results+"9999");
		m.addObject("returnMsg","么么哒！");	
		return m;
	}

}

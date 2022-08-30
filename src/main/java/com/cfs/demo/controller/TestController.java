package com.cfs.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: TestController
 * Description:
 * date: 2022/3/17 19:57
 *
 * @author ShowFaker
 * @since JDK 8
 */
@RequestMapping("/heap/test")
@RestController
public class TestController {

	public static final Map<String, Object> map = new ConcurrentHashMap<>();

	@RequestMapping("")
	public String testHeapUsed() {
		for (int i = 0; i < 10000000; i++) {
			map.put(i + "", new Object());
		}
		return "ok";
	}
}
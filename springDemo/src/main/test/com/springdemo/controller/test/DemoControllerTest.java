package com.springdemo.controller.test;

import org.junit.Test;

import com.springdemo.controller.DemoController;

public class DemoControllerTest {
	@Test
	public void testIndex(){
		DemoController dc = new DemoController();
		System.out.println("testing:"+dc.index()); 
	}
}

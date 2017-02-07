package com.springdemo.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.model.Person;

@Controller
public class DemoController {
	
	@RequestMapping("/index")
	public String index(){
		return "demo";
	}
	
	//1、 自动匹配参数
	// .../springDemo/say?name=xxx&age=xx
	// age为int类型时，age(int)必须要要传，否则传null会报有问题,而string类型则不会
	@RequestMapping("/say")
	public String say(String name,int age){
		System.out.println("name:"+name+" "+age);
		return "demo";
	}
	
	//2、会自动装箱
	@RequestMapping("/xiaoming")
	public String hiXiaoMing(Person p){
		System.out.println("name="+p.getName()+"age="+p.getAge());
		return "demo";
	}
	
	//3、ajax ? ?
	@RequestMapping("/ps")
	public void ps(String name,PrintWriter pw){
		pw.write("hello,"+name);
	}
	
}

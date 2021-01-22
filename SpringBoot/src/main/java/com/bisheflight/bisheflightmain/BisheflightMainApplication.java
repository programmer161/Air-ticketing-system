package com.bisheflight.bisheflightmain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/*
 *       ┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓** ** **  Kiss my ass
 * 　　　　┃　　　　　　　┏┛** ** **  BUG在想屁吃
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * */
@SpringBootApplication
@ComponentScan(basePackages = {"com.bisheflight.bisheflightmain.*"})
@MapperScan("com.bisheflight.bisheflightmain.mapper")
public class BisheflightMainApplication {
	public static void main(String[] args) {
		SpringApplication.run(BisheflightMainApplication.class, args);
	}

}
package com.bourchier.homechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bourchier.homechat.config")
public class HomechatApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomechatApplication.class, args);
	}

}

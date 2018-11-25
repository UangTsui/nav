package com.uangtsui.nav.link.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.uangtsui.nav.upms.client.client")
public class LinkServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkServerApplication.class, args);
	}
}

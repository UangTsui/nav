package com.uangtsui.nav.link.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LinkServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkServerApplication.class, args);
	}
}

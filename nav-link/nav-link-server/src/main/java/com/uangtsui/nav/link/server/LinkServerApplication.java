package com.uangtsui.nav.link.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableCircuitBreaker
@SpringCloudApplication
@EnableFeignClients(basePackages = "com.uangtsui.nav.upms.client.client")
@ComponentScan(basePackages = "com.uangtsui.nav.upms.client.client")
@EnableHystrixDashboard
public class LinkServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkServerApplication.class, args);
	}
}

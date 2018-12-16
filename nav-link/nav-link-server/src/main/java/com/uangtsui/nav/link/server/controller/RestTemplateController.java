package com.uangtsui.nav.link.server.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.uangtsui.nav.link.server.config.RestTemplateConfig;
import com.uangtsui.nav.upms.client.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
//@DefaultProperties(defaultFallback = "defaultFallback")
public class RestTemplateController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

    //@HystrixCommand(fallbackMethod = "fallback")
    // 超时配置
    /*@HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })*/
    // 断路由
    /*@HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })*/
    //@HystrixCommand
    @GetMapping("getRestTemplateMsg")
    public String getRestTemplateMsg(){
        // 1.第一种方式，使用RestTemplate的Url
        //RestTemplate restTemplate = new RestTemplate();
        //String str = restTemplate.getForObject("http://localhost:8080/user/restTemplateMsg", String.class);

        // 2.第二种方式，先使用LoadBalancerClient获取Url，在通过RestTemplate获取
        ServiceInstance serviceInstance = loadBalancerClient.choose("UPMS");
        //String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort())
                //+ "/user/restTemplateMsg";
        //String str = restTemplate.getForObject(url, String.class);

        // 3.第三种方法，利用@LoadBalanced，可在RestTemplate中使用应用名称
        //String str = restTemplate.getForObject("http://UPMS/user/restTemplateMsg", String.class);

        String str = userClient.restTemplateMsg();

        //throw new RuntimeException("异常也会触发降级");
        return str;
    }

    private String fallback() {
        return "网络拥挤，请稍后再试";
    }

    private String defaultFallback() {
        return "默认网络拥挤，请稍后再试";
    }
}

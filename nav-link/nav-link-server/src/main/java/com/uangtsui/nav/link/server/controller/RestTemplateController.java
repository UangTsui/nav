package com.uangtsui.nav.link.server.controller;

import com.uangtsui.nav.link.server.config.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("getRestTemplateMsg")
    public String getRestTemplateMsg(){
        // 1.第一种方式，使用RestTemplate的Url
        //RestTemplate restTemplate = new RestTemplate();
        //String str = restTemplate.getForObject("http://localhost:8080/user/restTemplateMsg", String.class);

        // 2.第二种方式，先使用LoadBalancerClient获取Url，在通过RestTemplate获取
        ServiceInstance serviceInstance = loadBalancerClient.choose("UPMS");
        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort())
                + "/user/restTemplateMsg";
        //String str = restTemplate.getForObject(url, String.class);

        // 3.第三种方法，利用@LoadBalanced，可在RestTemplate中使用应用名称
        String str = restTemplate.getForObject("http://UPMS/user/restTemplateMsg", String.class);
        return str;
    }
}

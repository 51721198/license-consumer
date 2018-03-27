package com.kevin.snake.licenseconsumer.service.impl;

import com.kevin.snake.licenseconsumer.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class HelloServiceImpl implements HelloService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String sayHello() {

        return restTemplate.getForEntity("http://LICENSE/user/showAllUsers", String.class).getBody();
    }

    public String helloFallback(){
        return "this is an error!!!!";
    }
}

package com.kevin.snake.licenseconsumer.service.impl;

import com.kevin.snake.licenseconsumer.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class HelloServiceImpl implements HelloService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "helloFallback", ignoreExceptions = {HystrixBadRequestException.class})
    public String sayHello() {

        return restTemplate.getForEntity("http://LICENSE/user/showAllUsers", String.class).getBody();
    }

    //e为hystrix命令执行过程中抛出的异常
    public String helloFallback(Throwable e){
        return "this is an error!!!!";
    }
}

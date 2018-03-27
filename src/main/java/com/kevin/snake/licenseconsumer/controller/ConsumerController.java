package com.kevin.snake.licenseconsumer.controller;

import com.kevin.snake.licenseconsumer.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    @Resource
    HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
//        return restTemplate.getForEntity("http://LICENSE/user/showAllUsers", String.class).getBody();
        return helloService.sayHello();
    }

}

package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * Created by zwl on 2018/3/26.
 */
@Service
public class HelloService {
    @HystrixCommand(fallbackMethod = "helloServiceFallBack")
    public String helloService(String name)  {
        System.out.println("name:" + name);
        try {
            Thread.sleep(600000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name;
    }

    private String helloServiceFallBack(String name){
        return "这个是失败的信息";
    }
}

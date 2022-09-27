package com.tchokouaha.spring.training.demospringboot.aopdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleEnpointController {

    @LogStuff
    @GetMapping("/test-aop")
    public void testAop() {
        System.out.println("In the method");
        try {
            throw new RuntimeException();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}

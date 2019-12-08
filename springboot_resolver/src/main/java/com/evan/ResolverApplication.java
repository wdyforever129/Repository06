package com.evan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@RequestMapping(path="/test",method = RequestMethod.GET)
public class ResolverApplication {
	
    @RequestMapping(value = "/Resolver")
    public String testResolver(){
        System.out.println("Hello,Resolver");
        return "Resolver Service is start!";
    }

    //okcs
    public static void main(String[] args) {
        SpringApplication.run(ResolverApplication.class, args);
        System.out.println("Hello!");

    }
}

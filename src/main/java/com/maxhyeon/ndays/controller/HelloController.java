package com.maxhyeon.ndays.controller;

//import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController
public class HelloController {

    @GetMapping(value = "/helloworld/string")
    @ResponseBody
    public String helloworldString(){
        return "Hello world";
    }

    @GetMapping(value = "/helloworld/json")
    @ResponseBody
    public Hello helloworldJson(){
        Hello hello = Hello.builder().message("Helloworld").build();
        return hello;
    }

    @Data
    @Builder
    public static class Hello {
        private String message;
    }
}


package com.huallpa.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path ="/hello-world")
    public String helloWord() {
        return "Hello world";
    }

    @GetMapping(path ="/hello-world-bean")
    public HelloWorldBean helloWordBean() {
        return new HelloWorldBean("Hello world");
    }

    @GetMapping(path ="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWordBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello world, %s", name));
    }

    @GetMapping(path ="/hello-world-internationalized")
    public String helloWordInternationalized(
            @RequestHeader(name="Accept-Language", required=false) Locale locale) {
        return messageSource.getMessage("good.morning.message", null, locale);
    }

}

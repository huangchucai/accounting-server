package com.hcc.accounting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(path = "v1/hello/{name}/{id}")
    public String sayHello(@PathVariable String name, @PathVariable Integer id) {
        return String.format("Hello, %s, %d", name, id);
    }

    @GetMapping(path = "v1/greeting")
    public String sayGreetings(@RequestParam String name) {
        return String.format("Greetings, %s", name);
    }
}

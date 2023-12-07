package com.hcc.accounting.controller;

import com.hcc.accounting.model.dao.UserInfo;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    /**
     * sayHello 方法
     * @param name 姓名
     * @param id id
     * @return string
     */
    @GetMapping(path = "v1/hello/{name}/{id}")
    public String sayHello(@PathVariable String name, @PathVariable Integer id) {
        val userInfo = UserInfo.builder().userName("hcc").build();
        System.out.println(userInfo.getId());
        return String.format("Hello, %s, %d", name, id);
    }

    @GetMapping(path = "v1/greeting")
    public String sayGreetings(@RequestParam String name) {
        return String.format("Greetings, %s", name);
    }
}

package com.example.SpringPractice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/simple-hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/name-hello")
    public String nameHello (
            @RequestParam(value = "name", defaultValue = "") String name
    ) {
        if (Objects.equals(name, "")) {
            return "No name provided";
        }
        return "Hello %s".formatted(name);
    }
}

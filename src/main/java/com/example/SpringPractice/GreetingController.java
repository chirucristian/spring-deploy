package com.example.SpringPractice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class GreetingController {
    public static final String template = "Hello, %s";
    public static final AtomicLong counter = new AtomicLong();
    public static final ArrayList<Greeting> requests = new ArrayList<>();

    @GetMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "<null>") String name
    ) {
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        requests.add(greeting);

        return requests.getLast();
    }

    @GetMapping("/greeting/show-requests")
    public ArrayList<Greeting> getRequests() {
        return requests;
    }
}

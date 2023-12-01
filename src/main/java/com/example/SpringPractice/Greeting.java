package com.example.SpringPractice;

public class Greeting {
    public Long id;
    public String content;

    public Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}

package com.mss.task.arithmetic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rb")
public class ResponseBodyDemo {
    @PostMapping("/add")
    public int add(@RequestBody Student s1)
    {
        int a1=s1.getA();
        int b1=s1.getB();
        return a1+b1;
    }
    @PostMapping("/sub")
    public int sub(@RequestBody Student s1)
    {
        int a1=s1.getA();
        int b1=s1.getB();
        return a1-b1;
    }
    @PostMapping("/mul")
    public int mul(@RequestBody Student s1)
    {
        int a1=s1.getA();
        int b1=s1.getB();
        return a1*b1;
    }
    
    @PostMapping("/div")
    public int div(@RequestBody Student s1)
    {
        int a1=s1.getA();
        int b1=s1.getB();
        return a1/b1;
    }
}

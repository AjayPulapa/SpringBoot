package com.mss.task.arithmetic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pv")
public class PathVariableDemo {
    @GetMapping("add/{a}/{b}")
	public int add(@PathVariable int a,@PathVariable int b)
	{
		return a+b;
	}
    @GetMapping("/sub/{a}/{b}")
	public int sub(@PathVariable int a,@PathVariable int b)
	{
		return a-b;
	}
    @GetMapping("/mul/{a}/{b}")
	public int mul(@PathVariable int a,@PathVariable int b)
	{
		return a*b;
	}
    @PostMapping("/div/{a}/{b}")
	public int div(@PathVariable int a,@PathVariable int b)
	{
		return a/b;
	}
}
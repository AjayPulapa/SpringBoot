package com.mss.task.arithmetic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/rp")
public class RequestParameterDemo {
                              //Request Paramater Passing
	@GetMapping("/add")
	public int add(@RequestParam int a,@RequestParam int b)
	{
		return a+b;
	}
	@GetMapping("/sub")
	public int sub(@RequestParam int a,@RequestParam int b)
	{
		return a-b;
	}
	@GetMapping("/mul")
	public int mul(@RequestParam int a,@RequestParam int b)
	{
		return a*b;
	}
	@GetMapping("/div")
	public int div(@RequestParam int a,@RequestParam int b)
	{
		return a/b;
	}	
}
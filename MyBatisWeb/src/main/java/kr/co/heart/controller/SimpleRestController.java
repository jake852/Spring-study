package kr.co.heart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.heart.domain.Person;

//@RestController
@Controller
public class SimpleRestController {
	
	@GetMapping("/ajax")
	public String ajax() {		//ajax = 이름은 상관x 
		return "ajax";
	
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}	
	
	@ResponseBody
	@PostMapping("/send")
	public Person test(@RequestBody Person p) {
		//비동기 처리함으로써 view가 아니기때문에 @RequestBody 필요 (views를 받는게 아닌 데이터를 받는것이기때문에)
		System.out.println("p = " + p);
		p.setName("ezen0111");
		p.setAge(p.getAge() + 2023);
		
		return p;
	}
}

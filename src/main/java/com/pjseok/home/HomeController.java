package com.pjseok.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	@GetMapping(value = "/hello")
	public String hello(Model model) {
		
		model.addAttribute("member", "홍길동");
		
		return "hello";
	}
	
	@GetMapping(value = "/hyper")
	public String hyper(Model model) {
		
		
		
		return "hyperTest";
	}
	
	@GetMapping(value = "/hyperResult")
	public String hyperResult(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "hyperResult";
	}
	
	@GetMapping(value="/iftest")
	public String iftest(Model model) {
		
		List<MemberDto> memberDtos = new ArrayList<MemberDto>();
		
		for(int i=0;i<=10;i++) {
			MemberDto memberDto = new MemberDto();
			memberDto.setId("tiger"+i);
			memberDto.setName("길동"+i);
			memberDto.setEmail("tiger"+i+"@abc.com");
			memberDto.setAge(+20);
			
			memberDtos.add(memberDto);
		}
		
		model.addAttribute("memberDtos", memberDtos);
		
		
		return "ifTest";
	}
	
	
}

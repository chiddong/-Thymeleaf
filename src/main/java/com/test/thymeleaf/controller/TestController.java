package com.test.thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.thymeleaf.persist.AddressDAO;
import com.test.thymeleaf.persist.AddressDTO;

@Controller
public class TestController {

	
	@Autowired private AddressDAO dao;
	
	//타임리프 적용?
//	@GetMapping("/m1")
//	public String m1(Model model) {
//
//		
//		//접두어: /template/
//		//접미어: .html
//		return "m1";
//	}
	
//	@GetMapping("/m1")
//	public void m1(Model model) {
//
//		//리턴값이 void면 자동으로 "m1.html"이 호출된다. > 되도록 쓰지말것! 헷갈림 나중에
//		
//	}
	
	
//	@GetMapping("/member/info")
//	public String info(Model model) {
//		return "member/info"; //JSP 경로때와 동일하게 작성
//	}

	@GetMapping("/m1")
	public String m1(Model model) {

		//단일값 전달
		int num = dao.num();
		String txt = dao.txt();
		LocalDateTime now = dao.now();
		
		model.addAttribute("num", num);
		model.addAttribute("txt", txt);
		model.addAttribute("now", now);

		return "m1";
	}
	
	@GetMapping("/m2")
	public String m2(Model model) {

		//m2
		//- 객체 전달
		AddressDTO dto = dao.get();
		HashMap<String, Integer> map = dao.getMap();
		
		
		model.addAttribute("dto", dto);
		model.addAttribute("map", map);
		
		return "m2";
	} //m2
	
	@GetMapping("/m3")
	public String m3(Model model) {

		//m3
		//- 스프링 메시지 출력
		
		
		return "m3";
	}//m3
	
	@GetMapping("/m4")
	public String m4(Model model) {

		//m4
		//- 상수 표현
		//- 연산자
		
		 int a = 10;
		 int b = 3;
		 
		 model.addAttribute("a", a);
		 model.addAttribute("b", b);

		return "m4";
	}//m4
	
	@GetMapping("/m5")
	public String m5(Model model) {

		//m5
		//- HTML 속성 조작
		model.addAttribute("size", 50);
		model.addAttribute("name", "홍길동");
		model.addAttribute("color", "cornflowerblue");

		return "m5";
	}//m5
	
	@GetMapping("/m6")
	public String m6(Model model) {

		//m6
		//- 콘텐츠 조작(시작태그~끝태그 사이)
		//- PCDATA 조작, 하위 태그 조작
		// - innerText, textContent, innerHTML 기능
		
		String txt1 = "홍길동입니다.";
		String txt2 = "<b>홍길동</b>입니다.";
		AddressDTO dto = dao.get();
		HashMap<String, Integer> map = dao.getMap();
		List<String> names = dao.getNames();
		List<AddressDTO> list = dao.list();
		
		model.addAttribute("txt1", txt1);
		model.addAttribute("txt2", txt2);
		model.addAttribute("dto", dto);
		model.addAttribute("map", map);
		model.addAttribute("names", names);
		model.addAttribute("list", list);

		return "m6";
	}
	
	
}















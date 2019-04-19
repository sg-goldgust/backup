package edu.autocar.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HelloController {
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "hong");
		return "hello";
	}
}

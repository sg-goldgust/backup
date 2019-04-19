package edu.autocar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.autocar.domain.Board.Member;
import edu.autocar.domain.Board.PageInfo;
import edu.autocar.domain.Board.ResultMsg;
import edu.autocar.domain.Board.UserLevel;
import edu.autocar.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/admin/member") // 공통된 url처리
public class AdminMemberController {
	@Autowired
	MemberService service;

	@GetMapping("/list")
	public void list(@RequestParam(value = "page", defaultValue = "1") int page, Model model) throws Exception {
		PageInfo<Member> pi = service.getList(page);
		model.addAttribute("pi", pi);
	}

	@PostMapping("/create")
	public String postCreate(@Valid Member member, BindingResult result, @RequestParam("avata") MultipartFile file,
			Model model) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("userLevels", UserLevel.values());
			return "admin/member/create";
		}
		service.create(member, file);
		return "redirect:list";
	}

	@GetMapping("/create")
	public void getCreate(Model model, Member member) throws Exception {

		model.addAttribute("userLevels", UserLevel.values());
	}

	@DeleteMapping("/delete/{userId}")
	@ResponseBody
	public ResponseEntity<ResultMsg> delete(@PathVariable String userId,
			@RequestParam(value = "password") String password) throws Exception {
		if (service.delete(userId, password)) {
			return ResultMsg.response("success", "삭제했습니다.");
		} else {
			return ResultMsg.response("fail", "비밀번호가 일치하지 않습니다.");
		}
	}

	@DeleteMapping("/multi_delete")
	@ResponseBody
	public ResponseEntity<ResultMsg> multiDelete(@RequestParam("users") String[] users,
			@RequestParam("password") String password) throws Exception {
		for (String userId : users) {
			System.out.println(userId);
		}
		return ResultMsg.response("success", "삭제했습니다.");
	}

	@GetMapping("/id-check/{userId}")
	@ResponseBody
	public ResponseEntity<ResultMsg> checkId(@PathVariable String userId) throws Exception {

		if (service.getMember(userId) == null) {
			return ResultMsg.response("ok", "사용가능한 ID 입니다.");
		} else {
			return ResultMsg.response("duplicate", "이미 사용중인 ID 입니다.");
		}

	}

	@GetMapping("/edit/{userId}")
	public String edit(@PathVariable String userId, Model model) throws Exception {
		Member member = service.getMember(userId);
		model.addAttribute("member", member);
		List<UserLevel> list = new ArrayList<>();

		for (UserLevel ul : UserLevel.values()) {
			list.add(ul);
		}

		model.addAttribute("ulList", list);
		return "member/edit";
	}

	@PostMapping("/edit/{userId}")
	public String postEdit(@RequestParam(value = "page") int page, @Valid Member member, BindingResult result,
			@RequestParam("avata") MultipartFile file, Model model) throws Exception {
		model.addAttribute("userLevels", UserLevel.values());
		if (result.hasErrors()) {
			return "admin/member/edit";
		}
		if (service.updateByAdmin(member, file)) {
			return "redirect:/admin/member/view/" + member.getUserId() + "?page=" + page;
		} else {
			FieldError fieldError = new FieldError("member", "password", "비밀번호가 일치하지 않습니다");
			result.addError(fieldError);
			return "admin/member/edit";
		}
	}
}

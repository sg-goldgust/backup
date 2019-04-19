package edu.autocar.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.autocar.domain.Board.FileInfo;
import edu.autocar.domain.Board.Gallery;
import edu.autocar.domain.Board.Member;
import edu.autocar.domain.Board.PageInfo;
import edu.autocar.service.GalleryService;
import edu.autocar.service.ImageService;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	@Autowired
	GalleryService service;

	@Autowired
	ImageService imageService;

	@GetMapping("/list")
	public void list(@RequestParam(value = "page", defaultValue = "1") int page, Model model) throws Exception {
		PageInfo<Gallery> pi = service.getPage(page);
		model.addAttribute("pi", pi);
	}

	// 테스트를 위한 로그인 자동화
	// 모든 url에서 사용된다.
	@ModelAttribute("USER")
	public Member testUser(HttpSession session) {
		Member m = (Member) session.getAttribute("USER");
		if (m == null) {
			m = new Member();
			m.setUserId("hong2");
			session.setAttribute("USER", m);
		}
		return m;
	}

	@GetMapping("/create")
	public void getCreate(Gallery gallery) throws Exception {
	}

	@PostMapping("/create")
	public String postCreate(@Valid Gallery gallery, BindingResult result, MultipartHttpServletRequest request)
			throws Exception {
		if (result.hasErrors())
			return "gallery/create";
		service.create(gallery, request.getFiles("files"));
		return "redirect:list";
	}

	@GetMapping("/view/{galleryId}")
	public String getGallery(@PathVariable int galleryId, Model model) throws Exception {
		Gallery gallery = service.getGallery(galleryId);
		model.addAttribute("gallery", gallery);
		return "gallery/view";
	}

	@GetMapping("/image/{imageId}")
	public String getImage(@PathVariable int imageId, Model model) throws Exception {
		FileInfo fi = imageService.getFileInfo(imageId);
		model.addAttribute("fileInfo", fi);
		
		return "image";
	}

	@GetMapping("/thumb/{imageId}")
	public String getThumb(@PathVariable int imageId, Model model) throws Exception {
		FileInfo fi = imageService.getThumbFileInfo(imageId);
		model.addAttribute("fileInfo", fi);
		System.out.print("galleryController 도착");
		return "image";
	}

	@GetMapping("/download/{imageId}")
	public String download(@PathVariable int imageId, Model model) throws Exception {
		FileInfo fi = imageService.getFileInfo(imageId);
		model.addAttribute("fileInfo", fi);
		return "download";
	}
	
	@GetMapping("/edit/{galleryId}")
	public String getEdit(@PathVariable int galleryId, Model model) throws Exception {
		Gallery gallery = service.getGallery(galleryId);
		model.addAttribute("gallery",gallery);
		return "gallery/edit";
	}

}

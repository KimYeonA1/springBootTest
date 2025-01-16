package com.kh.controller;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kh.domain.Address;
import com.kh.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

	@PostMapping(value = "/insert")
	public String insertMemebr(Member member, Address address) {
		log.info("insertMemebr");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getPassword() = " + member.getPassword());
		log.info("member.getCoin() = " + member.getCoin());
		log.info("Date dateOfBirth = " + member.getDateOfBirth());
		log.info("member.tostring = " + member);
		log.info("address.tostring = " + address);
		return "home";
	}

	@RequestMapping(value = "/registerFileUp01", method = RequestMethod.POST)
	public String registerFileUp01(@RequestBody MultipartFile picture) throws Exception {
		log.info("registerFileUp01");
		log.info("originalName: " + picture.getOriginalFilename());
		log.info("size: " + picture.getSize());
		log.info("contentType: " + picture.getContentType());

		if (!picture.isEmpty()) {
			String fileName = picture.getOriginalFilename();
			picture.transferTo(new File("C:/SpringBootProject/upload_files/" + fileName));
		}
		return "home";
	}

	// 입력값 검증
	@RequestMapping(value = "/registerValidation", method = RequestMethod.POST)
	public String registerValidation(@Validated Member member, BindingResult result) {
		log.info("registerValidation");
		if (result.hasErrors()) {
			return "registerValidationForm"; // 뷰 파일명
		}
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getUserName() = " + member.getUserName());
		log.info("member.getGender() = " + member.getGender());
		return "home";
	}

	@RequestMapping(value = "/registerValidationForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		log.info("registerValidationForm01");
		model.addAttribute("member", new Member());
		return "registerValidationForm"; // 뷰 파일명
	}

	// 전체적인 입력값 검증
	@RequestMapping(value = "/registerValidation2", method = RequestMethod.POST)
	public String registerValidation2(@Validated Member member, BindingResult result) {
		log.info("registerValidation2");
		// 입력값 검증 에러가 발생한 경우 true 를 반환한다.
		log.info("result.hasErrors() = " + result.hasErrors());
		// 입력값 검증 후 BindingResult 가 제공하는 메서드를 이용하여 검사 결과를 확인한다.
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			List<ObjectError> globalErrors = result.getGlobalErrors();
			List<FieldError> fieldErrors = result.getFieldErrors();
			log.info("allErrors.size() = " + allErrors.size());
			log.info("globalErrors.size() = " + globalErrors.size());
			log.info("fieldErrors.size() = " + fieldErrors.size());
			for (int i = 0; i < allErrors.size(); i++) {
				ObjectError objectError = allErrors.get(i);
				log.info("allError = " + objectError);
			}
			for (int i = 0; i < globalErrors.size(); i++) {
				ObjectError objectError = globalErrors.get(i);
				log.info("globalError = " + objectError);
			}
			for (int i = 0; i < fieldErrors.size(); i++) {
				FieldError fieldError = fieldErrors.get(i);
				log.info("fieldError.getDefaultMessage() = " + fieldError.getDefaultMessage());
			}
			return "registerValidation2Form"; // 뷰 파일명
		}
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getGender() = " + member.getGender());
		return "home";
	}

	@RequestMapping(value = "/registerValidation2Form01", method = RequestMethod.GET)
	public String registerValidation2Form01(Model model) {
		log.info("registerValidation2Form01");
		model.addAttribute("member", new Member());
		return "registerValidation2Form"; // 뷰 파일명
	}
}
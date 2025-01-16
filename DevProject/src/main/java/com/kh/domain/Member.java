package com.kh.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Member {
	@NotBlank(message = "공백이나 빈칸일 수 없습니다")
	private String userId;
	@NotBlank
	private String password;
	@Email//이메일 패턴이 안 맞으면 검증
	private String email;
	@NotBlank(message = "이름입력은 필수(최대3)")
	@Size(max=3)
	private String userName;
	private List<String> hobbylsit;
	private int coin;
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date dateOfBirth;
	private String gender;
}

//NotBlank 반드시 입력하게 하는 것
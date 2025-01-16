package com.kh.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileMember {
	private String userId;
	private String password;
	private List<MultipartFile> picture;
}






//	private String[] car;    //ArrayList<타입String> car로 넣어도 됨
//	private Address address;  //member가 Address 클래스를 가지는 것임ㄴ   
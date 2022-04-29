package com.uploadarquivosapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uploadarquivosapirest.storage.Disco;

@RestController
@RequestMapping("/upload")
public class UploadContrller {
	
	@Autowired
	private Disco disco;

	@PostMapping
	public void upload(@RequestParam MultipartFile file) {
		disco.salvarFile(file);
	}	
}
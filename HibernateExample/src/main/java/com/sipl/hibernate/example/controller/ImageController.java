package com.sipl.hibernate.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sipl.hibernate.example.dtos.ImageDto;
import com.sipl.hibernate.example.response.ImageApiResponse;


@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "*")
public interface ImageController {
	
	@PostMapping("/add")
	ResponseEntity<ImageApiResponse> add(@RequestBody ImageDto imageDto);
}

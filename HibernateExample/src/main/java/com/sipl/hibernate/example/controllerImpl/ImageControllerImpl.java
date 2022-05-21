package com.sipl.hibernate.example.controllerImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.sipl.hibernate.example.controller.ImageController;
import com.sipl.hibernate.example.dtos.ImageDto;
import com.sipl.hibernate.example.response.ImageApiResponse;
import com.sipl.hibernate.example.service.ImageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageControllerImpl implements ImageController {
	@Autowired
	private ImageService imageService;

	@Override
	public ResponseEntity<ImageApiResponse> add(ImageDto imageDto) {
		log.info("add endpoint called");
		try {
			return new ResponseEntity<>(imageService.add(imageDto), HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

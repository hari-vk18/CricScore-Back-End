package com.cricimg.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cricimg.Repository.imageRepo;
import com.cricimg.model.images;

@RestController
@RequestMapping("/api")
public class ImageUploadController {

	@Autowired
	private imageRepo imageRepo;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadImage(@RequestParam MultipartFile file) {
		// TODO: process POST request

		if (file.isEmpty()) {
			return new ResponseEntity<>("No file selected", HttpStatus.BAD_REQUEST);
		}

		try {

			long fileSize = file.getSize();
			System.out.println("File size: " + fileSize + " bytes");

			images image = new images();
			image.setName(file.getOriginalFilename().substring(0, 3));
			image.setImage(file.getBytes());

			imageRepo.save(image);

			return new ResponseEntity<>("Image Uploded", HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

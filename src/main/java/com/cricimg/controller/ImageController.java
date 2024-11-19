package com.cricimg.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cricimg.model.images;
import com.cricimg.service.ImageService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ImageController {

	@Autowired
	ImageService imageService;

	@GetMapping("/image/{name}")
	public ResponseEntity<byte[]> getImage(@PathVariable String name) {

		Optional<images> imageData = imageService.getImageByName(name);

		if (imageData.isPresent()) {
			images image = imageData.get();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG);

			return new ResponseEntity<>(image.getImage(), headers, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}

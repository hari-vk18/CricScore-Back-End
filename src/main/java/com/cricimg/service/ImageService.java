package com.cricimg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricimg.Repository.imageRepo;
import com.cricimg.model.images;

@Service
public class ImageService {

	@Autowired
	imageRepo imageRepo;

	public Optional<images> getImageByName(String name) {
		// TODO Auto-generated method stub

		return Optional.ofNullable(imageRepo.findByName(name));
	}

}

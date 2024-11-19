package com.cricimg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricimg.model.images;

@Repository
public interface imageRepo extends JpaRepository<images, Long> {
	images findByName(String name);
}

package com.actionict.inventory.repository;

import com.actionict.inventory.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
}
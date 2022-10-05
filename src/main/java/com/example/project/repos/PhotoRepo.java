package com.example.project.repos;

import com.example.project.domain.Photo;
import com.example.project.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhotoRepo extends CrudRepository<Photo, Long> {
    List<Photo> findByUserId(Long id);

    Photo findPhotoById(Long id);
}
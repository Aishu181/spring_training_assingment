package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.LibModel;

public interface LibRepo extends CrudRepository<LibModel,String> {

	List<LibModel> findByAuthor(String author);
}

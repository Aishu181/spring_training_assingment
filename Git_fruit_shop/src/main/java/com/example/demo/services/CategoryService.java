package com.example.demo.services;

import java.util.*;

import com.example.model.CategoryDTO;

public interface CategoryService {

	List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}

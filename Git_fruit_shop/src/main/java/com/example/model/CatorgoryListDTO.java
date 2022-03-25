package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatorgoryListDTO {

   public CatorgoryListDTO(List<CategoryDTO> allCategories) {
		// TODO Auto-generated constructor stub
	}

List<CategoryDTO> categories;

}

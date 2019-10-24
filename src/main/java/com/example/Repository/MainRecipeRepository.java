package com.example.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Domain.Recipe;
	@Repository
	public interface MainRecipeRepository extends JpaRepository<Recipe, Integer>{

		
		
		
		
	}



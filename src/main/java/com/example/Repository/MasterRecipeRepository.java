package com.example.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Domain.MasterRecipe;
	@Repository
	public interface MasterRecipeRepository extends JpaRepository<MasterRecipe, Integer>{		
		
	}



package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Business.MasterRecipeService;
import com.example.Domain.MasterRecipe;

@RestController
@CrossOrigin("*")
public class MasterRecipeController {

	@Autowired
	private MasterRecipeService service;
	
	@GetMapping("/recipe")
	public List<MasterRecipe> getAllRecipes() {
		return service.getAllRecipes();
	}
	
	@PostMapping("/recipe")
	public MasterRecipe addNewRecipe(@RequestBody MasterRecipe recipe) {
		return service.addNewRecipe(recipe);
	}
	
	@PutMapping("/recipe")
	public MasterRecipe updateRecipe(@RequestBody MasterRecipe recipe) {
		return service.updateRecipe(recipe);
	}
	
	@DeleteMapping("/recipe/{regno}")
	public String delete(@PathVariable(value = "regno") int regno) {
		return service.deleteRecipe(regno);
	}

}
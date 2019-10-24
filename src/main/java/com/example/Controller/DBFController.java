package com.example.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Domain.Recipe;
import com.example.Repository.MainRecipeRepository;
@RestController
public class DBFController {
@Autowired
private MainRecipeRepository repo;

@GetMapping("/showAll")
public ArrayList<Recipe> showAll(){
	return (ArrayList<Recipe>) repo.findAll();
}

@GetMapping("/message")
public String message(){
	return "hello";
}
//@GetMapping("/findIngredientsByRecipeName/{n}")
//public String findIngredientsByRecipeName(@PathVariable String n){
//	//if character dash is here eliminate them
//	 return repo.findIngredientsByRecipeName(n);
//	 }
		 
	 }
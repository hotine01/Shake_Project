package com.example.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;

@Entity

//@NamedQueries(value= {
//		@NamedQuery(
//				name="Recipe.getIngredientsByRecipeName",
//				query="select ingredients from MasterRecipe m where m.recipe=?1"
//				)
//})
public class Recipe {
	@Id
	private int regno;
	private String recipe;
	private String ingredients;
	public int getRegno() {
		return regno;
	}
	public void setRegno(Integer regno) {
		this.regno = regno;
	}
	public String getRecipe() {
		return recipe;
	}
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
}
	
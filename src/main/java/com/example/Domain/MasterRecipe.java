package com.example.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Recipe")
public class MasterRecipe {
	@Id
	@GeneratedValue
	private Integer regno;
	private String recipe;
	private String ingredients;
	
	public MasterRecipe(String recipe, String ingredients) {
		this.recipe=recipe;
		this.ingredients=ingredients;
	}

	public MasterRecipe() {
		super();
	}
	
	public Integer getRegno() {
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
	
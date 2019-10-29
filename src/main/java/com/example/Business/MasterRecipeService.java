package com.example.Business;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Domain.MasterRecipe;
import com.example.Repository.MasterRecipeRepository;

@Service
public class MasterRecipeService {

	@Autowired
	private MasterRecipeRepository Repo;

	public MasterRecipeService() {

	}

	public List<MasterRecipe> getAllRecipes() {
		if (Repo.findAll().isEmpty()) {
			setUpRecipe();
		}
		return Repo.findAll();
	}

	private void setUpRecipe() {
		MasterRecipe BananaWeightGain = new MasterRecipe("Banana weight gain", "500ml of whole milk, 5 egg whites, 1 egg yolk, 1 banana, 50g peanut butter, 100g powdered oats, 1 tablespoon of MCT oil, 1 tablespoon of olive oil");
		MasterRecipe StrawberryWeightLoss = new MasterRecipe("Strawberry weight loss", "500ml of water, 4 egg whites, 100g of strawberries, 50g flax seeds");
		MasterRecipe LeanMuscleWeightGain = new MasterRecipe("Lean muscle chocolate flavour", "500ml of water, 5 egg whites, 50g of chocolate flavoured protein powder, 1 tablespoon of chocolate nesquik");
		Repo.save(BananaWeightGain);
		Repo.save(StrawberryWeightLoss);
		Repo.save(LeanMuscleWeightGain);
	}
	
	public MasterRecipe addNewRecipe(MasterRecipe recipe) {
		return Repo.save(recipe);
	}

	public MasterRecipe updateRecipe(MasterRecipe recipe) {
		return Repo.save(recipe);
	}

	public String deleteRecipe(int regno) {
		Repo.deleteById(regno);
		return "Recipe deleted";
	}
}
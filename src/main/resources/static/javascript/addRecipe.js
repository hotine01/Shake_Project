	function addRecipe() {
	var recipe = document.getElementById('recipe').value;
	var ingredients = document.getElementById('ingredients').value;
	var masterRecipe = new Object();
	masterRecipe.recipe = recipe;
	masterRecipe.ingredients = ingredients;
	var masterRecipeJSON = JSON.stringify(masterRecipe);
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/recipe",
		contentType : "application/json",
		data : masterRecipeJSON,
		success : function(data) {
			console.log(data);
		},
		error : function(data) {
			console.log(data);
		},
		dataType : 'json'
	});
}
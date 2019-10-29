
$(document).ready(function () {
	getAllRecipes();
})

function getAllRecipes() {
	let request = new XMLHttpRequest();
	request.open("GET", "http://localhost:8080/recipe");

	request.onload = function () {
		let list = document.getElementById("recipe-list");
		list.innerHTML = "";
		let data = JSON.parse(request.response);
		for (let recipe of data) {
			console.log(recipe)
			let listItem = document.createElement("li");
			listItem.className = "list-group-item";
			let text = document.createElement("p");
			text.innerText = recipe.recipe + " " + recipe.ingredients
			let button = document.createElement("button");
			button.addEventListener("click", function() {
				"deleteRecipe(" +recipe.regno +")"

			} 

			listItem.append(text);
			listItem.append(button);
			list.appendChild(listItem);
		}
	}
	request.send();
}

function addRecipe(form) {
	let request = new XMLHttpRequest();
	request.open("POST", "http://localhost:8080/recipe");
	request.setRequestHeader("Content-Type", "application/json");
	request.onload = function () {
		getAllRecipes();
	}
	let body = {};
	for(let input of form) {
		if(input.name){
			body[input.name] = input.value;
			input.value="";
		}
	}
	request.send(JSON.stringify(body));
	return false;
}

function updateRecipe() {
	let request = new XMLHttpRequest();
	request.open("PUT", "http://localhost:8080/recipe");

	request.onload = function () {
		var recipe = document.getElementById('recipe').value;
		var ingredients = document.getElementById('ingredients').value;
		var regno = document.getElementById('regno').value;
		var masterRecipe = new Object();
		masterRecipe.recipe = recipe;
		masterRecipe.ingredients = ingredients;
		masterRecipe.regno = regno;
		var masterRecipeJSON = JSON.stringify(masterRecipe)
	}
	request.send();
}



function deleteRecipe(regno) {
	const Http = new XMLHttpRequest();
	const url = 'http://localhost:8080/recipe/'+regno;
	Http.open("DELETE", url);
	Http.onload = function (e) {
		getAllRecipes();
	}
	request.send();
}

$(document).ready(function () {
	getAllRecipes();
})

function getAllRecipes() {
	let request = new XMLHttpRequest();
	request.open("GET", "http://"+location.host+":8081/recipe");

	request.onload = function () {
		renderToScreen(JSON.parse(request.response));
	}
	request.send();
}

function renderToScreen(data) {
	let list = document.getElementById("recipe-list");
	list.innerHTML = "";
	for (let recipe of data) {
		// console.log(recipe)
		let listItem = document.createElement("li");
		listItem.className = "list-group-item";
		let text = document.createElement("div");

		let header = document.createElement("h2");
		header.innerText = recipe.recipe;

		let paragraph = document.createElement("p");
		paragraph.innerText = recipe.ingredients;

		text.appendChild(header);
		text.appendChild(paragraph);

		let button = document.createElement("button");
		button.innerText = "Delete";
		button.addEventListener("click", function() {
			deleteRecipe(recipe.regno);
		});
		let button1 = document.createElement("button");
		button1.innerText = "Edit";
		button1.addEventListener("click", function edit() {
			editRecipe(listItem , edit, button1, recipe)
		});
		listItem.append(text);
		listItem.append(button);
		listItem.append(button1);
		list.appendChild(listItem);
	}
}



/**
 * Edits the recipe of the given information
 * @param {HTMLLIElement} listItem 
 * @param {Function} func 
 * @param {HTMLButtonElement} button 
 * @param {Object} info 
 */
function editRecipe(listItem, func, button, info) {
	button.removeEventListener("click", func);
	
	let form = document.createElement("form");
	let textbox = document.createElement("input");
	textbox.type = "text";
	let submit = document.createElement("input");
	submit.type= "submit";
	
	form.onsubmit = function() {
		let body = info
		body.ingredients = textbox.value;
		updateRecipe(body);
		return false;
	}
	form.appendChild(textbox);
	form.appendChild(submit);
	listItem.appendChild(form);
	console.log(listItem);
	console.log(func)
}

function addRecipe(form) {
	let request = new XMLHttpRequest();
	request.open("POST", "http://"+location.host+":8081/recipe");
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

function updateRecipe(body) {
	console.log(body);
	 let request = new XMLHttpRequest();
	 request.open("PUT", "http://"+location.host+":8081/recipe");
	request.setRequestHeader("Content-Type", "application/json");
	request.onload = function () {
			getAllRecipes();
		}
		var body= JSON.stringify(body)
		request.send(body);
		return false
}



function deleteRecipe(regno) {
	const http = new XMLHttpRequest();
	const url = 'http://"+location.host+":8081/recipe'+regno;
	http.open("DELETE", url);
	http.onload = function (e) {
		getAllRecipes();
	}
	http.send();
}
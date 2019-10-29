<html>
<div class="container">
<h3>Delete recipe:<h3>

	<form>
	<div>


<script>
function request(){
const Http = new XMLHttpRequest();
const url='http://localhost:8080/recipes';
Http.open("DELETE", url);
Http.onreadystatechange = function(e){
	data=JSON.parse(Http.responseText);
	data.forEach(function(item){
		var regno=document.createElement("span");
		var name=document.createElement("span");
		var ingredients=document.createElement("span");
		regno.innerHTML=item.regno;
		name.innerHTML=item.name;
		marks.innerHTML=item.ingredients;
		document.body.appendChild(regno);
		document.body.appendChild(name);
		document.body.appendChild(ingredients);		
	});
}
Http.send();
}
</script>
<input type="button" value="Send Request" onclick="request()">
</html>

/*USER PERMISSIONS*/

/*Function to Set All Selected Boxes*/
function checkAll(event){
	setAllCheckBoxes(event.className, event.checked);
}

/*Function to Set All Check Boxes*/
function setAllCheckBoxes(name, boolResult) {
	let checkboxes = document.getElementsByClassName(name);
	
	for(var i=0; i< checkboxes.length ;i++){
		checkboxes[i].checked = boolResult;
	}
}

/*Function to Set Permissions based on the role*/
function setPermissions(){
	let role = document.getElementById("role");
	if(role.value === "user"){
		console.log("check role",role.vale);
		setAllCheckBoxes("admin-permission", false);
		setAllCheckBoxes("user-permission", true);
	}
	else{
		setAllCheckBoxes("admin-permission", true);
	}
}
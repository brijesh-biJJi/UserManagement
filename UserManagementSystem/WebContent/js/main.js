function sideBarBtn() {
	var div = document.getElementById("sidebarId");

	if (div.style.display !== "none") {
		div.style.display = "none";
		document.getElementById("sideBarIcon").className = 'ti-arrow-circle-right';
	} else {
		div.style.display = "block";
		document.getElementById("sideBarIcon").className = 'ti-arrow-circle-left';
	}
}

var sideMenuBtn = document.getElementsByClassName("menu-btn");

for (var i = 0; i < sideMenuBtn.length; i++) {
	sideMenuBtn[i].addEventListener("click", function() {
        this.classList.toggle("active");
        var subMenu = this.nextElementSibling;
        if (subMenu.style.display === "block") {
        	subMenu.style.display = "none";
        } else {
        	subMenu.style.display = "block";
        }
    });
}

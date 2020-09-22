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

$(function(){
	$('#deleteUser').on('click', function(){
		var modalId = $(this).attr('data-modelid');
		$('#'+modalId).toggle();
	})

	$('.close-modal').on('click', function(){
		$('.modal-fade').css('display','none');
	})	
})



function searchFunction() {
	// Declare variables
  var searchValue, filter, tableId, tableRow, tableData, i, txtValue;
  
  searchValue = document.getElementById("searchInput");
  filter = searchValue.value.toUpperCase();
  
  tableId = document.getElementById("usersTable");
  tableRow = tableId.getElementsByTagName("tr");
  
//Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tableRow.length; i++) {
	  tableData = tableRow[i].getElementsByTagName("td")[1];
    if (tableData) {
      txtValue = tableData.textContent || tableData.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
    	  tableRow[i].style.display = "";
      } else {
    	  tableRow[i].style.display = "none";
      }
    }       
  }
}

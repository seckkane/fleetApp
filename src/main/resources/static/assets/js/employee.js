$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Employee');
	    $('#id').val('');
	    $('#firstname').val('');
	    $('#lastname').val('');
	    $('#othername').val('');
	    $('#title').val('');
	    $('#initials').val('');
	    $('#socialSecurityNumber').val('');
	    $('#gender').val('');
	    $('#maritalStatus').val('');
	    $('#countryid').val('');
	    $('#stateid').val('');
	    $('#dateOfBirth').val('');
	    $('#city').val('');
	    $('#address').val('');
	    $('#phone').val('');
	    $('#mobile').val('');
	    $('#email').val('');
	    $('#photovalue').text("Photo:");
	    $('#employeetypeid').val('');
	    $('#username').val('');
	    $('#jobtitleid').val('');
	    $('#hireDate').val('');
	    $('#submit').text('Save');
	    $('#submit').show();
		$('#cancel').text('Cancel');
  });
});

$(function (){
    $(".show-button").click(function(){
		$('#modal-title').text('Details - Employe');
		$("#id").val($(this).data("employee-id"));
		$('#firstname').val($(this).data("employee-firstname"));
	    $('#lastname').val($(this).data("employee-lastname"));
	    $('#othername').val($(this).data("employee-othername"));
	    $('#title').val($(this).data("employee-title"));
	    $('#initials').val($(this).data("employee-initials"));
	    $('#socialSecurityNumber').val($(this).data("employee-socialsecuritynumber"));
	    $('#gender').val($(this).data("employee-gender"));
		$('#maritalStatus').val($(this).data("employee-maritalstatus"));
	    $('#countryid').val($(this).data("employee-countryid"));
	    $('#stateid').val($(this).data("employee-stateid"));
	    $('#dateOfBirth').val($(this).data("employee-dateofbirth"));
	    $('#city').val($(this).data("employee-city"));
	    $('#address').val($(this).data("employee-address"));
	    $('#phone').val($(this).data("employee-phone"));
	    $('#mobile').val($(this).data("employee-mobile"));
	    $('#email').val($(this).data("employee-email"));
	    $('#photovalue').text("Photo déja chargée : " + $(this).data("employee-photo"));
	    $('#employeetypeid').val($(this).data("employee-employeetypeid"));
	    $('#username').val($(this).data("employee-username"));
		$('#jobtitleid').val($(this).data("employee-jobtitleid"));
	    $('#hireDate').val($(this).data("employee-hiredate"));
	    $('#submit').hide();	
		$('#cancel').text('Close');
    });
}); 


$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Editing an Employe');
		$("#id").val($(this).data("employee-id"));
		$('#firstname').val($(this).data("employee-firstname"));
	    $('#lastname').val($(this).data("employee-lastname"));
	    $('#othername').val($(this).data("employee-othername"));
	    $('#title').val($(this).data("employee-title"));
	    $('#initials').val($(this).data("employee-initials"));
	    $('#socialSecurityNumber').val($(this).data("employee-socialsecuritynumber"));
	    $('#gender').val($(this).data("employee-gender"));
		$('#maritalStatus').val($(this).data("employee-maritalstatus"));
	    $('#countryid').val($(this).data("employee-countryid"));
	    $('#stateid').val($(this).data("employee-stateid"));
	    $('#dateOfBirth').val($(this).data("employee-dateofbirth"));
	    $('#city').val($(this).data("employee-city"));
	    $('#address').val($(this).data("employee-address"));
	    $('#phone').val($(this).data("employee-phone"));
	    $('#mobile').val($(this).data("employee-mobile"));
	    $('#email').val($(this).data("employee-email")); 
	    $('#photovalue').text("Photo déja chargée : " + $(this).data("employee-photo"));
	    $('#employeetypeid').val($(this).data("employee-employeetypeid"));
	    $('#username').val($(this).data("employee-username"));
		$('#jobtitleid').val($(this).data("employee-jobtitleid"));
	    $('#hireDate').val($(this).data("employee-hiredate"));
		$('#submit').text('Update');
		$('#submit').show();
		$('#cancel').text('Cancel');	
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/employee/delete/" + $(this).data("employee-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});

$('.table #photoButton').on('click',function(event) {
   event.preventDefault();
   var href = $(this).attr('href');
   $('#photoModal #employeePhoto').attr('src', href);		
});	

// Fonction pour vérifier l'extension du fichier
function checkFileExtension() {
  var fileInput = $("#fich");
  var filePath = fileInput.val();
  var allowedExtensions = /(\.jpg)$/i;  // Extensions autorisées (ici, seulement .jpg)
  
  if(!$("#fich").val()) 
  	return true;
  if (!allowedExtensions.exec(filePath)) {
    alert('Seuls les fichiers JPG sont autorisés.');
    fileInput.val('');
    return false;
  }
  
  return true;
}

// Soumission du formulaire
$("#formEmployee").submit(function(e) {
  if (!checkFileExtension()) {
    e.preventDefault();  // Empêche la soumission du formulaire si l'extension du fichier n'est pas valide
  }
});

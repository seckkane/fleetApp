$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Country');
	    $('#id').val('');
	    $('#description').val('');
	    $('#capital').val('');
	    $('#code').val('');
	    $('#continent').val('');
	    $('#nationality').val('');
	    $('#submit').text('Save');
  });
});

$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Editing a Country');
		$("#id").val($(this).data("country-id"));
		$("#description").val($(this).data("country-description"));
		$("#capital").val($(this).data("country-capital"));
		$("#code").val($(this).data("country-code"));
		$("#continent").val($(this).data("country-continent"));
		$("#nationality").val($(this).data("country-nationality"));	
		$('#submit').text('Update');	
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/country/delete/" + $(this).data("country-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});



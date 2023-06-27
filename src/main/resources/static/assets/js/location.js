$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Location');
	    $('#id').val('');
	    $('#description').val('');
	    $('#details').val('');
	    $('#countryid').val('');
	    $('#stateid').val('');
	    $('#city').val('');
	    $('#address').val('');
	    $('#submit').text('Save');
	    $('#submit').show();
		$('#cancel').text('Cancel');
  });
});

$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Editing a Location');
		$("#id").val($(this).data("location-id"));
		$("#description").val($(this).data("location-description"));
		$("#details").val($(this).data("location-details"));
		$("#countryid").val($(this).data("location-countryid"));
		$("#stateid").val($(this).data("location-stateid"));
		$("#city").val($(this).data("location-city"));
		$("#address").val($(this).data("location-address"));
		$('#submit').text('Update');	
		$('#submit').show();
		$('#cancel').text('Cancel');
    });
}); 

$(function (){
    $(".show-button").click(function(){
		$('#modal-title').text('Details - Location');
		$("#id").val($(this).data("location-id"));
		$("#description").val($(this).data("location-description"));
		$("#details").val($(this).data("location-details"));
		$("#countryid").val($(this).data("location-countryid"));
		$("#stateid").val($(this).data("location-stateid"));
		$("#city").val($(this).data("location-city"));
		$("#address").val($(this).data("location-address"));
		$('#submit').hide();
		$('#cancel').text('Close');	
    });
}); 


$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/location/delete/" + $(this).data("location-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});

$(function (){
        $('#countryid').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});

$(function (){
        $('#stateid').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});
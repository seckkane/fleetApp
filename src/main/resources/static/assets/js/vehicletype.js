$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Vehicle Type');
	    $('#id').val('');
	    $('#description').val('');
	    $('#details').val('');
	    $('#submit').text('Save');
	    $('#submit').show();
		$('#cancel').text('Cancel');
  });
});

$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Editing a Vehicle Type');
		$("#id").val($(this).data("vehicletype-id"));
		$("#description").val($(this).data("vehicletype-description"));
		$("#details").val($(this).data("vehicletype-details"));
		$('#submit').text('Update');
		$('#submit').show();
		$('#cancel').text('Cancel');	
		$('#submit').show();
		$('#cancel').text('Cancel');
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/vehicletype/delete/" + $(this).data("vehicletype-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});
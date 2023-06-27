$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Vehicle Status');
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
		$('#modal-title').text('Editing a Vehicle Status');
		$("#id").val($(this).data("vehiclestatus-id"));
		$("#description").val($(this).data("vehiclestatus-description"));
		$("#details").val($(this).data("vehiclestatus-details"));
		$('#submit').text('Update');	
		$('#submit').show();
		$('#cancel').text('Cancel');
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/vehiclestatus/delete/" + $(this).data("vehiclestatus-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});
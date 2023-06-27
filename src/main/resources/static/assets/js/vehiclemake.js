$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Vehicle Make');
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
		$('#modal-title').text('Editing a Vehicle Make');
		$("#id").val($(this).data("vehiclemake-id"));
		$("#description").val($(this).data("vehiclemake-description"));
		$("#details").val($(this).data("vehiclemake-details"));
		$('#submit').text('Update');	
		$('#submit').show();
		$('#cancel').text('Cancel');
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/vehiclemake/delete/" + $(this).data("vehiclemake-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});
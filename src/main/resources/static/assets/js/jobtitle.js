$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Job Title');
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
		$('#modal-title').text('Editing a Job Title');
		$("#id").val($(this).data("jobtitle-id"));
		$("#description").val($(this).data("jobtitle-description"));
		$("#details").val($(this).data("jobtitle-details"));
		$('#submit').text('Update');	
		$('#submit').show();
		$('#cancel').text('Cancel');
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/jobtitle/delete/" + $(this).data("jobtitle-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});
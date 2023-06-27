$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Employee Type');
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
		$('#modal-title').text('Editing an Employe Type');
		$("#id").val($(this).data("employeetype-id"));
		$("#description").val($(this).data("employeetype-description"));
		$("#details").val($(this).data("employeetype-details"));
		$('#submit').text('Update');
		$('#submit').show();
		$('#cancel').text('Cancel');	
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/employeetype/delete/" + $(this).data("employeetype-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});
$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Invoice Status');
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
		$('#modal-title').text('Editing an Invoice Status');
		$("#id").val($(this).data("invoicestatus-id"));
		$("#description").val($(this).data("invoicestatus-description"));
		$("#details").val($(this).data("invoicestatus-details"));
		$('#submit').text('Update');
		$('#submit').show();
		$('#cancel').text('Cancel');
		$('#submit').show();
		$('#cancel').text('Cancel');	
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/invoicestatus/delete/" + $(this).data("invoicestatus-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});
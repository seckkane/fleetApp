$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Invoice');
	    $('#id').val('');
	    $('#invoicedate').val('');
	    $('#invoicestatusid').val('');
	    $('#clientid').val('');
	    $('#remarks').val('');
	    $('#submit').text('Save');
	    $('#submit').show();
		$('#cancel').text('Cancel');
  });
});

$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Editing an Invoice');
		$("#id").val($(this).data("invoice-id"));
		$("#invoiceDate").val($(this).data("invoice-invoicedate"));
		$("#invoicestatusid").val($(this).data("invoice-invoicestatusid"));
		$("#clientid").val($(this).data("invoice-clientid"));
		$("#remarks").val($(this).data("invoice-remarks"));
		$('#submit').text('Update');
		$('#submit').show();
		$('#cancel').text('Cancel');	
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/invoice/delete/" + $(this).data("invoice-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});

$(function (){
        $('#invoicestatusid').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});

$(function (){
        $('#clientid').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});
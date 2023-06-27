$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Vehicle Maintenance');
	    $('#id').val('');
	    $('#vehicleid').val('');
	    $('#startdate').val('');
	    $('#enddate').val('');
	    $('#price').val('');
	    $('#supplierid').val('');
	    $('#remarks').val('');
	    $('#submit').text('Save');
	    $('#submit').show();
		$('#cancel').text('Cancel');
  });
});

$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Editing a Vehicle Maintenance');
		$("#id").val($(this).data("vehiclemaintenance-id"));
		$("#vehicleid").val($(this).data("vehiclemaintenance-vehicleid"));
		$("#startdate").val($(this).data("vehiclemaintenance-startdate"));
		$("#enddate").val($(this).data("vehiclemaintenance-enddate"));
		$("#price").val($(this).data("vehiclemaintenance-price"));
		$("#supplierid").val($(this).data("vehiclemaintenance-supplierid"));
		$("#remarks").val($(this).data("vehiclemaintenance-remarks"));
		$('#submit').text('Update');	
		$('#submit').show();
		$('#cancel').text('Cancel');
    });
}); 

$(function (){
    $(".show-button").click(function(){
		$('#modal-title').text('Details - Vehicle Maintenance');
		$("#id").val($(this).data("vehiclemaintenance-id"));
		$("#vehicleid").val($(this).data("vehiclemaintenance-vehicleid"));
		$("#startdate").val($(this).data("vehiclemaintenance-startdate"));
		$("#enddate").val($(this).data("vehiclemaintenance-enddate"));
		$("#price").val($(this).data("vehiclemaintenance-price"));
		$("#supplierid").val($(this).data("vehiclemaintenance-supplierid"));
		$("#remarks").val($(this).data("vehiclemaintenance-remarks"));
		$('#submit').hide();	
		$('#cancel').text('Close');
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/vehiclemaintenance/delete/" + $(this).data("vehiclemaintenance-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});

$(function (){
        $('#supplierid').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});

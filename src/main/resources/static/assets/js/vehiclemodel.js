$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Vehicle Model');
	    $('#id').val('');
	    $('#description').val('');
	    $('#details').val('');
	    $('#createdBy').hide();
		$('#createdDate').hide();
		$('#lastModifiedBy').hide();
		$('#lastModifiedDate').hide();
		$('#lblcreatedBy').hide();
		$('#lblcreatedDate').hide();
		$('#lbllastModifiedBy').hide();
		$('#lbllastModifiedDate').hide();
	    $('#submit').text('Save');
	    $('#submit').show();
		$('#cancel').text('Cancel');
  });
});


$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Editing a Vehicle Model');
		$("#id").val($(this).data("vehiclemodel-id"));
		$("#description").val($(this).data("vehiclemodel-description"));
		$("#details").val($(this).data("vehiclemodel-details"));
		$('#createdBy').hide();
		$('#createdDate').hide();
		$('#lastModifiedBy').hide();
		$('#lastModifiedDate').hide();
		$('#lblcreatedBy').hide();
		$('#lblcreatedDate').hide();
		$('#lbllastModifiedBy').hide();
		$('#lbllastModifiedDate').hide();
		$('#submit').text('Update');	
		$('#submit').show();
		$('#cancel').text('Cancel');
    });
}); 

$(function (){
    $(".show-button").click(function(){
		$('#modal-title').text('Details - Vehicle Model');
		$("#id").val($(this).data("vehiclemodel-id"));
		$("#description").val($(this).data("vehiclemodel-description"));
		$("#details").val($(this).data("vehiclemodel-details"));
		$('#createdBy').val($(this).data("vehiclemodel-createdby"));
		$('#createdDate').val($(this).data("vehiclemodel-createddate").substr(0,19).replace("T", " "));
		$('#lastModifiedBy').val($(this).data("vehiclemodel-lastmodifiedby"));
		$('#lastModifiedDate').val($(this).data("vehiclemodel-lastmodifieddate").substr(0,19).replace("T", " "));
		$('#createdBy').show();
		$('#createdDate').show();
		$('#lastModifiedBy').show();
		$('#lastModifiedDate').show();
		$('#lblcreatedBy').show();
		$('#lblcreatedDate').show();
		$('#lbllastModifiedBy').show();
		$('#lbllastModifiedDate').show();
		$('#submit').hide();
		$('#cancel').text('Fermer');
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/vehiclemodel/delete/" + $(this).data("vehiclemodel-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});
$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Vehicle');
	    $('#id').val('');
	    $('#vehicletypeid').val('');
	    $('#name').val('');
	    $('#vehicleNumber').val('');
	    $('#registrationDate').val('');
	    $('#acquisitionDate').val('');
	    $('#description').val('');
	    $('#vehiclemakeid').val('');
	    $('#power').val('');
	    $('#fuelCapacity').val('');
	    $('#vehiclestatusid').val('');
	    $('#netWeight').val('');
	    $('#employeeid').val('');
	    $('#vehiclemodelid').val('');
	    $('#locationid').val('');
	    $('#remarks').val('');
	    $('#submit').text('Save');
	    $('#submit').show();
		$('#cancel').text('Cancel');
		
  });
});

$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Editing a Vehicle Model');
		$("#id").val($(this).data("vehicle-id"));
		$('#vehicletypeid').val($(this).data("vehicle-vehicletypeid"));
	    $('#name').val($(this).data("vehicle-vehiclename"));
	    $('#vehicleNumber').val($(this).data("vehicle-vehiclenumber"));
	    $('#registrationDate').val($(this).data("vehicle-registrationdate"));
	    $('#acquisitionDate').val($(this).data("vehicle-acquisitiondate"));
	    $('#description').val($(this).data("vehicle-description"));
	    $('#vehiclemakeid').val($(this).data("vehicle-vehiclemakeid"));
	    $('#power').val($(this).data("vehicle-power"));
	    $('#fuelCapacity').val($(this).data("vehicle-fuelcapacity"));
	    $('#vehiclestatusid').val($(this).data("vehicle-vehiclestatusid"));
	    $('#netWeight').val($(this).data("vehicle-netweight"));
	    $('#employeeid').val($(this).data("vehicle-employeeid"));
	    $('#vehiclemodelid').val($(this).data("vehicle-vehiclemodelid"));
	    $('#locationid').val($(this).data("vehicle-locationid"));
	    $('#remarks').val($(this).data("vehicle-remarks"));
		$('#submit').text('Update');	
		$('#submit').show();
		$('#cancel').text('Cancel');
    });
}); 

$(function (){
    $(".show-button").click(function(){
		$('#modal-title').text('Details - Vehicle');
		$("#id").val($(this).data("vehicle-id"));
		$('#vehicletypeid').val($(this).data("vehicle-vehicletypeid"));
	    $('#name').val($(this).data("vehicle-vehiclename"));
	    $('#vehicleNumber').val($(this).data("vehicle-vehiclenumber"));
	    $('#registrationDate').val($(this).data("vehicle-registrationdate"));
	    $('#acquisitionDate').val($(this).data("vehicle-acquisitiondate"));
	    $('#description').val($(this).data("vehicle-description"));
	    $('#vehiclemakeid').val($(this).data("vehicle-vehiclemakeid"));
	    $('#power').val($(this).data("vehicle-power"));
	    $('#fuelCapacity').val($(this).data("vehicle-fuelcapacity"));
	    $('#vehiclestatusid').val($(this).data("vehicle-vehiclestatusid"));
	    $('#netWeight').val($(this).data("vehicle-netweight"));
	    $('#employeeid').val($(this).data("vehicle-employeeid"));
	    $('#vehiclemodelid').val($(this).data("vehicle-vehiclemodelid"));
	    $('#locationid').val($(this).data("vehicle-locationid"));
	    $('#remarks').val($(this).data("vehicle-remarks"));	
		$('#submit').hide();	
		$('#cancel').text('Close');
    });
});

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/vehicle/delete/" + $(this).data("vehicle-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});

$(function (){
        $('#vehicletypeid').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});
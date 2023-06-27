$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Vehicle Movement');
	    $('#id').val('');
	    $('#vehicleid').val('');
	    $('#locationid1').val('');
	    $('#date1').val('');
	    $('#locationid2').val('');
	    $('#date2').val('');
	    $('#remarks').val('');
	    $('#submit').text('Save');
	    $('#submit').show();
		$('#cancel').text('Cancel');
  });
});

$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Editing a Vehicle Movement');
		$("#id").val($(this).data("vehiclemovement-id"));
		$("#vehicleid").val($(this).data("vehiclemovement-vehicleid"));
		$("#locationid1").val($(this).data("vehiclemovement-locationid1"));
		$("#date1").val($(this).data("vehiclemovement-date1"));
		$("#locationid2").val($(this).data("vehiclemovement-locationid2"));
		$("#date2").val($(this).data("vehiclemovement-date2"));
		$("#remarks").val($(this).data("vehiclemovement-remarks"));
		$('#submit').text('Update');
		$('#submit').show();
		$('#cancel').text('Cancel');	
    });
}); 

$(function (){
    $(".show-button").click(function(){
		$('#modal-title').text('Details - Vehicle Movement');
		$("#id").val($(this).data("vehiclemovement-id"));
		$("#vehicleid").val($(this).data("vehiclemovement-vehicleid"));
		$("#locationid1").val($(this).data("vehiclemovement-locationid1"));
		$("#date1").val($(this).data("vehiclemovement-date1"));
		$("#locationid2").val($(this).data("vehiclemovement-locationid2"));
		$("#date2").val($(this).data("vehiclemovement-date2"));
		$("#remarks").val($(this).data("vehiclemovement-remarks"));
		$('#submit').hide();
		$('#cancel').text('Close');
    });
}); 


$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/vehiclemovement/delete/" + $(this).data("vehiclemovement-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});

$(function (){
        $('#vehicleid').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});

$(function (){
        $('#locationid1').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});

$(function (){
        $('#locationid2').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});

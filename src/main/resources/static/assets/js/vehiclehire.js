$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Vehicle Hire');
	    $('#id').val('');
	    $('#vehicleid').val('');
	    $('#dateout').val('');
	    $('#timeout').val('');
	    $('#datein').val('');
	    $('#timein').val('');
	    $('#clientid').val('');
	    $('#locationid').val('');
	    $('#price').val('');
	    $('#remarks').val('');
	    $('#submit').text('Save');
	    $('#submit').show();
		$('#cancel').text('Cancel');
  });
});

$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Editing a Vehicle Hire');
		$("#id").val($(this).data("vehiclehire-id"));
		$("#vehicleid").val($(this).data("vehiclehire-vehicleid"));
		$("#dateout").val($(this).data("vehiclehire-dateout"));
		$("#timeout").val($(this).data("vehiclehire-timeout"));
		$("#datein").val($(this).data("vehiclehire-datein"));
		$("#timein").val($(this).data("vehiclehire-timein"));
		$("#clientid").val($(this).data("vehiclehire-clientid"));
		$("#locationid").val($(this).data("vehiclehire-locationid"));
		$("#price").val($(this).data("vehiclehire-price"));
		$("#remarks").val($(this).data("vehiclehire-remarks"));
		$('#submit').text('Update');	
		$('#submit').show();
		$('#cancel').text('Cancel');
    });
}); 

$(function (){
    $(".show-button").click(function(){
		$('#modal-title').text('Details - Vehicle Hire');
		$("#id").val($(this).data("vehiclehire-id"));
		$("#vehicleid").val($(this).data("vehiclehire-vehicleid"));
		$("#dateout").val($(this).data("vehiclehire-dateout"));
		$("#timeout").val($(this).data("vehiclehire-timeout"));
		$("#datein").val($(this).data("vehiclehire-datein"));
		$("#timein").val($(this).data("vehiclehire-timein"));
		$("#clientid").val($(this).data("vehiclehire-clientid"));
		$("#locationid").val($(this).data("vehiclehire-locationid"));
		$("#price").val($(this).data("vehiclehire-price"));
		$("#remarks").val($(this).data("vehiclehire-remarks"));
		$('#submit').hide();
		$('#cancel').text('Close');	
    });
});

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/vehiclehire/delete/" + $(this).data("vehiclehire-id");;
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
        $('#clientid').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});

$(function (){
        $('#locationid').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});

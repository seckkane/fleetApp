$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Client');
	    $('#id').val('');
	    $('#name').val('');
	    $('#address').val('');
	    $('#city').val('');
	    $('#phone').val('');
	    $('#mobile').val('');
	    $('#website').val('');
	    $('#email').val('');
	    $('#countryid').val('');
	    $('#stateid').val('');
	    $('#submit').text('Save');
	    $('#submit').show();
		$('#cancel').text('Cancel');
  });
});

$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Editing a Client');
		$("#id").val($(this).data("client-id"));
		$("#name").val($(this).data("client-name"));
		$("#address").val($(this).data("client-address"));
		$("#city").val($(this).data("client-city"));
		$("#phone").val($(this).data("client-phone"));
		$("#mobile").val($(this).data("client-mobile"));
		$("#website").val($(this).data("client-website"));
		$("#email").val($(this).data("client-email"));
		$("#countryid").val($(this).data("client-countryid"));
		$("#stateid").val($(this).data("client-stateid"));
		$("#details").val($(this).data("client-details"));
		$('#submit').text('Update');
		$('#submit').show();
		$('#cancel').text('Cancel');		
    });
}); 

$(function (){
    $(".show-button").click(function(){
		$('#modal-title').text('Details - Client');
		$("#id").val($(this).data("client-id"));
		$("#name").val($(this).data("client-name"));
		$("#address").val($(this).data("client-address"));
		$("#city").val($(this).data("client-city"));
		$("#phone").val($(this).data("client-phone"));
		$("#mobile").val($(this).data("client-mobile"));
		$("#website").val($(this).data("client-website"));
		$("#email").val($(this).data("client-email"));
		$("#countryid").val($(this).data("client-countryid"));
		$("#stateid").val($(this).data("client-stateid"));
		$("#details").val($(this).data("client-details"));
		$('#submit').hide();
		$('#cancel').text('Close');	
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/client/delete/" + $(this).data("client-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});

$(function (){
        $('#countryid').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});

$(function (){
        $('#stateid').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});
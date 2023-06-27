$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Supplier');
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
		$('#modal-title').text('Editing a Supplier');
		$("#id").val($(this).data("supplier-id"));
		$("#name").val($(this).data("supplier-name"));
		$("#address").val($(this).data("supplier-address"));
		$("#city").val($(this).data("supplier-city"));
		$("#phone").val($(this).data("supplier-phone"));
		$("#mobile").val($(this).data("supplier-mobile"));
		$("#website").val($(this).data("supplier-website"));
		$("#email").val($(this).data("supplier-email"));
		$("#countryid").val($(this).data("supplier-countryid"));
		$("#stateid").val($(this).data("supplier-stateid"));
		$("#details").val($(this).data("supplier-details"));
		$('#submit').text('Update');	
		$('#submit').show();
		$('#cancel').text('Cancel');
    });
}); 

$(function (){
    $(".show-button").click(function(){
		$('#modal-title').text('Details - Supplier');
		$("#id").val($(this).data("supplier-id"));
		$("#name").val($(this).data("supplier-name"));
		$("#address").val($(this).data("supplier-address"));
		$("#city").val($(this).data("supplier-city"));
		$("#phone").val($(this).data("supplier-phone"));
		$("#mobile").val($(this).data("supplier-mobile"));
		$("#website").val($(this).data("supplier-website"));
		$("#email").val($(this).data("supplier-email"));
		$("#countryid").val($(this).data("supplier-countryid"));
		$("#stateid").val($(this).data("supplier-stateid"));
		$("#details").val($(this).data("supplier-details"));
		$('#submit').hide();
		$('#cancel').text('Close');	
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/supplier/delete/" + $(this).data("supplier-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});


$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/supplier/delete/" + $(this).data("supplier-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});


$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/supplier/delete/" + $(this).data("supplier-id");;
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
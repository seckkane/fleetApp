$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new Contact');
	    $('#id').val('');
	    $('#firstname').val('');
	    $('#lastname').val('');
	    $('#phone').val('');
	    $('#email').val('');
	    $('#mobile').val('');
	    $('#remarks').val('');
	    $('#submit').text('Save');
	    $('#submit').show();
		$('#cancel').text('Cancel');
  });
});

$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Editing a Contact');
		$("#id").val($(this).data("contact-id"));
		$("#firstname").val($(this).data("contact-firstname"));
		$("#lastname").val($(this).data("contact-lastname"));
		$("#phone").val($(this).data("contact-phone"));
		$("#email").val($(this).data("contact-email"));
		$("#mobile").val($(this).data("contact-mobile"));
		$("#remarks").val($(this).data("contact-remarks"));
		$('#submit').text('Update');
	    $('#submit').show();
		$('#cancel').text('Cancel');		
    });
}); 

$(function (){
    $(".show-button").click(function(){
		$('#modal-title').text('Details - Contact');
		$("#id").val($(this).data("contact-id"));
		$("#firstname").val($(this).data("contact-firstname"));
		$("#lastname").val($(this).data("contact-lastname"));
		$("#phone").val($(this).data("contact-phone"));
		$("#email").val($(this).data("contact-email"));
		$("#mobile").val($(this).data("contact-mobile"));
		$("#remarks").val($(this).data("contact-remarks"));
		$('#submit').hide();
		$('#cancel').text('Close');	
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/contact/delete/" + $(this).data("contact-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
 });

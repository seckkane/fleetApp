$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new State');
	    $('#id').val('');
	    $('#name').val('');
	    $('#capital').val('');
	    $('#code').val('');
	    $('#countryid').val('');
	    $('#details').val('');
	    $('#submit').text('Save');
	    $('#submit').show();
		$('#cancel').text('Cancel');
  });
});

$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Editing a State');
		$("#id").val($(this).data("state-id"));
		$("#countryid").val($(this).data("state-countryid"));
		$("#name").val($(this).data("state-name"));
		$("#capital").val($(this).data("state-capital"));
		$("#code").val($(this).data("state-code"));
		$("#details").val($(this).data("state-details"));	
		$('#submit').text('Update');	
		$('#submit').show();
		$('#cancel').text('Cancel');
    });
}); 

$(function (){
    $(".show-button").click(function(){
		$('#modal-title').text('Details - State');
		$("#id").val($(this).data("state-id"));
		$("#countryid").val($(this).data("state-countryid"));
		$("#name").val($(this).data("state-name"));
		$("#capital").val($(this).data("state-capital"));
		$("#code").val($(this).data("state-code"));
		$("#details").val($(this).data("state-details"));	
		$('#submit').text('Update');	
		$('#submit').show();
		$('#cancel').text('Cancel');
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/state/delete/" + $(this).data("state-id");;
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


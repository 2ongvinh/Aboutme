$(function(){
    /*$(document).on('click','.sunmite_button #submit', function(){*/
    $(document).on('submit','#formlienhe', function(){
    /*$("#formlienhe input,#formlienhe textarea").jqBootstrapValidation({*/

        var name = $("input#name").val();
        var email = $("input#email").val();
        var phone = $("input#phone").val();
        var message = $("textarea#mes").val();

        $.ajax({
            url: '/Public_index/ajax',
            type: 'POST',
            cache: false,
            data: {
                aname: name,
                aphone: phone,
                aemail: email,
                amessage: message
            },
            success: function(data){
                // Success message
                $('#success').html("<div class='alert alert-success'>");
                $('#success > .alert-success').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                    .append("</button>");
                $('#success > .alert-success')
                    .append("<strong>Cảm ơn bạn đã gửi tin nhắn. </strong>");
                $('#success > .alert-success')
                    .append('</div>');

                //clear all fields
                $('#formlienhe').trigger("reset");
            },
            error: function (){
                // Fail message
                $('#success').html("<div class='alert alert-danger'>");
                $('#success > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                    .append("</button>");
                $('#success > .alert-danger').append("<strong>Sorry " + firstName + ", it seems that my mail server is not responding. Please try again later!");
                $('#success > .alert-danger').append('</div>');
                //clear all fields
                $('#formlienhe').trigger("reset");
            }
        });     
    });
});
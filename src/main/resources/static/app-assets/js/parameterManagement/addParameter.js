'use strict';
$(document).ready(function (){
    $("#form").submit(function (e) {
        e.preventDefault();
        if($("#temperature").val()=== ""){
            swal.fire("Oops...!", 'temperature field is mandatory', "error");
        }else if($("#deviceName").val()===""){
            swal.fire("Oops...!", 'deviceName field is mandatory', "error")
        } else if($("#pH").val() === ""){
            swal.fire("Oops...!", 'pH field is mandatory!', "error");
        }else if($("#turbidity").val() ===""){
            swal.fire("Oops...!", 'turbidity field is mandatory!', "error");
        }else  if($("#conductivity").val()===""){
            swal.fire("Oops...!", 'conductivity field is mandatory!', "error");
        }
        else{
            ajaxPost();
        }
        })

    function ajaxPost(){
        let formData = {
            deviceName:$("#deviceName").val(),
            temperature: $("#temperature").val(),
            pH:$("#pH").val(),
            turbidity:$("#turbidity").val(),
            conductivity:$("#conductivity").val()
        }
        $.ajax({
            type: 'POST',
            url: 'submitParameterData',
            data:JSON.stringify(formData),
            dataType:"json",
            processData: false,
            contentType: "application/json",
            success: function (data) {

                if (data.status === "success") {
                    swal.fire({
                        title:"Done",
                        text:data.message,
                        type:"success"

                    }).then((result) => {
                        // Reload the Page
                        location.reload();
                    });
                    $("#deviceName").val("")
                    $("#temperature").val("")
                    $("#pH").val("")
                    $("#turbidity").val("")
                    $("#conductivity").val("")

                } else if(data.data === 404){
                    swal.fire("Info", data.message, "info");
                } else {
                    swal.fire("Error", data.message, "error");
                }
            }, error: function () {
                swal.fire("Error", data.message, "error");
            }
        });
    }
})

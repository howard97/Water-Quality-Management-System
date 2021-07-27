'use strict';
$(document).ready(function (){
    $("#form").submit(function (e) {
        e.preventDefault();
        if($("#deviceName").val()=== ""){
            swal.fire("Oops...!", 'deviceName field is mandatory', "error");
        }else if($("#deviceLocation").val() === ""){
            swal.fire("Oops...!", 'deviceLocation field is mandatory!', "error");
        }else if($("#deviceLongitude").val() ===""){
            swal.fire("Oops...!", 'deviceLongitude field is mandatory!', "error");
        }else  if($("#deviceLatitude").val()===""){
            swal.fire("Oops...!", 'deviceLatitude field is mandatory!', "error");
        }
        else{
            ajaxPost();
        }
    })

    function ajaxPost(){
        let formData = {
            deviceName: $("#deviceName").val(),
            deviceLocation:$("#deviceLocation").val(),
            gpsLongitude:$("#deviceLongitude").val(),
            gpsLatitude:$("#deviceLatitude").val()
        }
        console.log(formData);
        $.ajax({
            type: 'POST',
            url: 'submitDeviceData',
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
                     $("#deviceLocation").val("")
                     $("#deviceLongitude").val("")
                     $("#deviceLatitude").val("")

                } else if(data.data === 507){
                    swal.fire("Info", data.message, "info");
                }
                else {
                    swal.fire("Error", data.message, "error");
                }
            }, error: function () {
                swal.fire("Error", data.message, "error");
            }
        });
    }
})
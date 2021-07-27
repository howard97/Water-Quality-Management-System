$(document).on('click', '#deleteDevice', function () {
    swal.fire({
        title: "Warning",
        text: "Are you sure you want to delete the device?",
        type: "warning",
        showCancelButton: true,
        confirmButtonClass: "btn-danger",
        confirmButtonText: "Yes, Proceed",
        cancelButtonText: "No, cancel",
    }).then((result) => {
            let dataId = $('#deleteDevice').val();
            console.log(dataId);
           /* let formData = {
                id : dataId
            }*/
           /* console.log(formData)*/
            $.ajax({
                type: 'DELETE',
                url: 'deleteDevice/'+ dataId,
                data:JSON.stringify(dataId),
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
                    } else {
                        swal.fire("Error", data.message, "error");
                    }
                }, error: function () {
                    swal.fire("Error", data.message, "error");
                }
            });
    });
});

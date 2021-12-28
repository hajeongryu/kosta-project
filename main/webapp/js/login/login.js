function loginClick(){
    let $loginFormObj = $('.email_login');

    $loginFormObj.click(function(){
        let ajaxUrl = $(this).attr('action');
        let ajaxMethod = $(this).attr('method').val();
        let idValue = $(this).attr('input[name=id]').val();
        let pwdValue = $(this).attr('input[name=pwd]').val();
        $.ajax({
            url: ajaxUrl,
            method: ajaxMethod,
			data: {id: idValue, pwd: pwdValue},
            success: function(responseObj) {
                if (responseObj.status == 0) {
					alert(responseObj.msg);
                }
            },
            error: function(xhr){
                alert("응답실패 status:" + xhr.status);
            }
        })
        return false;
    })
}
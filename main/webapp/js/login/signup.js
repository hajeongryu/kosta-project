
function submitClick(){
    let submitBt = $('.signup_box2');

    submitBt.click(function(e){
		let id = $(this).attr('input[name=id]');
	    let id2 = $(this).attr('input[name=id2]');
	    let pwd = $(this).attr('input[name=pwd]');
	    let pwd2 = $(this).attr('input[name=pwd2]');

        if(id == id2) {
            if(pwd == pwd2) {
                submitBt.submit();
            } else {
                alert("비밀번호가 일치하지 않습니다");
				
            }
        } else {
            alert("이메일이 일치하지 않습니다");
			
        }
		return false;
    })
}

/*--메뉴 클릭 되었을 때--*/
function menuClick(){
    let $menuObj = $('section>div.interest-select>span>a');
    $menuObj.click(function(){
        let menuHref = $(this).attr('href');
        console.log("메뉴 href=" + menuHref);

        let ajaxUrl = "";
        switch(menuHref){
            case 'interestlist':
                ajaxUrl = menuHref;
                $('section>div.select-content').load(ajaxUrl,function(responseText, textStatus, jqXHR){
                    if(jqXHR.status != 200){
                        alert('응답실패:' + jqXHR.status);
                    };
                });
                return false;
            case 'prelaunchedlist':
                ajaxUrl = menuHref;
                $('section>div.select-content').load(ajaxUrl,function(responseText, textStatus, jqXHR){
                    if(jqXHR.status != 200){
                        alert('응답실패:' + jqXHR.status);
                    };
                });
                return false;
        }
    });
}
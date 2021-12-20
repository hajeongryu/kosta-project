
function adSlide(){
    let $rb = $('button.ad1-right');
    // $rb.css('visibility','hidden');

    let index =1;

    $rb.click(function(){
        plusDivs(1);
    });


}

function showDivs(slideIndex,n) {
    var i;
    var x = document.getElementsByClassName("ad1-img");
    //다음 사진 없을때
    if (n > x.length) {slideIndex = 1}
    //e이전사진 없을때
    if (n < 1) {slideIndex = x.length}


    for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
    }
    x[slideIndex-1].style.display = "block";  
}


function popSlide(){
    let $popNextB = $('button.pop-nextB');
    let $popBackB = $('button.pop-backB');

    let $popItem = $('.popular-project >.item-rapper>.item-inrap1>.item');
    let popNextSize =0;
    

	$popBackB.hide();
    $popNextB.click(function(e){
		e.stopPropagation();
		var maxItemLangth = ($popItem.length-4)*100;
		if(popNextSize < maxItemLangth){
			popNextSize +=100;
			$popItem.css({'transform':'translateX(-'+popNextSize+'%)'});
			$popBackB.show();
		}

		if(popNextSize == maxItemLangth){
			$popNextB.hide();
		}
	});


    $popBackB.click(function(e){
		e.stopPropagation();

        if(popNextSize>=100){ popNextSize-=100; $popNextB.show(); }
        if(popNextSize ==0){ $popBackB.hide(); }

        $popItem.css({'transform':'translateX(-'+ popNextSize+'%)'});
    });

}

function endcomeSlide(){
    let $endcomeNextB = $('button.endcome-nextB');
    let $endcomeBackB = $('button.endcome-backB');

    let $endcomeItem = $('.endcome-project >.item-rapper>.item-inrap1>.item');
    let endcomeNextSize =0;
    

	$endcomeBackB.hide();
    $endcomeNextB.click(function(e){
		e.stopPropagation();

		var maxItemLangth = ($endcomeItem.length-4)*100;
		if(endcomeNextSize < maxItemLangth){
			endcomeNextSize +=100;
			$endcomeItem.css({'transform':'translateX(-'+endcomeNextSize+'%)'});
			$endcomeBackB.show();
		}

		if(endcomeNextSize == maxItemLangth){
			$endcomeNextB.hide();
		}
	});


    $endcomeBackB.click(function(e){
		e.stopPropagation();

        if(endcomeNextSize>=100){ endcomeNextSize-=100; $endcomeNextB.show(); }
        if(endcomeNextSize ==0){ $endcomeBackB.hide(); }

        $endcomeItem.css({'transform':'translateX(-'+ endcomeNextSize+'%)'});
    });
	
}




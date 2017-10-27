  $(function(){
     var aa='제이쿼리 작동 result.js';  
    //alert(aa)
    
 

    var cnt = $('.cosnum').length;
    //alert(cnt);
    
    $('.cosnum').each(function(index,item){
    	alert(item.innerHTM)
        console.log("index" + index);

        console.log("item" + item);

        console.log("innerHTML"+item.innerHTML);       

    })



    
   /* 
    switch (cnt) {
        case (cnt >= 10 && cnt <= 20):
            alert('10');
            break;
        case (cnt >= 21 && cnt <= 30):
           alert('21');
            break;
        case (cnt >= 31 && cnt <= 40):
   alert('31');
            break;
        default:
            alert('>41');
    }
    
    */
    
    

  });

  $(function(){
     var aa='제이쿼리 작동 cos_info.js';  
    //alert(aa)
    
    $(".cosbox").click(function () { 
    	//alert('hello')
    	var cosname=$(this).text();
    	//alert(cosname)
    	 $('#cosInfo').css('left','0')
         $('#wrap').css('marginLeft','25vw')
         $('#wrapBg').css('display','block')   
         
         //var cosn=$(this).text();
         
         var cosnum = $('.cosnum').text();
    	
    	//alert(cosnum[0]);
        
         
    	/*$.ajax({
             type: 'POST',
             url: '${pageContext.request.contextPath}/cosinfo.do',
             data: {
            	 "cosnum" : $('.cosnum').text()
             },
             error : function() {
                 alert('통신실패!!');
             },
             success: function(data){
            	 alert(data);
            	 //$('#cosInfo').append(data);
             }
         });   */
         
    });  


    
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
    
    

    $(".closed").click(function () { 
    	    $('#cosInfo').css('left','-28vw')
    	    $('#wrap').css('marginLeft','0')
    	    $('#wrapBg').css('display','none')
    });
    
    
    
/*function openCosInfo(){	
        $('#cosInfo').css('left','0')
        $('#wrap').css('marginLeft','25vw')
        $('#wrapBg').css('display','block')   
      
    }

function closeCosInfo(){
    $('#cosInfo').css('left','-28vw')
    $('#wrap').css('marginLeft','0')
    $('#wrapBg').css('display','none')
    
    
}*/




  });

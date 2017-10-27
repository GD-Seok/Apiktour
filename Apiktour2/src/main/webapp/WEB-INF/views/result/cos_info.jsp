<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="spring"  uri="http://www.springframework.org/tags" %>               
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>   



<script>
      
    $( function() {
       
        $('#contentBtn').click(function(){
			var cosnum=$('#cosnum').val()
			var cosname=$('#cosname').val()
			var mode=$('#mode').val()
			var level=$('#level').val()

			$('#contentView').attr('action','${pageContext.request.contextPath}/content.do').submit();
			return true;//전송이 가능하게 설정		
		})
    
    });
    </script>     
    

<p>
<span class="closebtn">
<a href="javascript:void(0)" class="closed" class="txt-none"></a>
</span>
</p>
<div id="wrap_cosinfo">
    <h1 class="mg_center txt_none">코스레벨아이콘</h1>
    <div id="title_bar" class="mg_b20 mg_t20">
    <h2 class="txt_center fpx24 fw_6">잔잔한 여행</h2>
    <span class="like txt-none"><a class="reg_liked" href="#">
        <svg version="1.1" id="btn_like" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px"
             y="0px" width="40.603px" height="37.374px" viewBox="0 0 40.603 37.374" enable-background="new 0 0 40.603 37.374"
             xml:space="preserve">
        <path fill-rule="evenodd" clip-rule="evenodd" stroke="#fff" stroke-miterlimit="10" d="M0.516,12.696
            c-0.084-1.697,0.179-3.413,0.828-5.096C2.76,3.93,5.183,1.259,9.247,0.651c4.522-0.678,7.886,1.195,10.192,5.081
            c0.196,0.33,0.427,0.641,0.74,1.107c0.361-0.597,0.621-1.035,0.89-1.467c4.165-6.69,13.526-6.45,17.3,0.461
            c2.834,5.191,2.029,10.258-1.225,14.813c-1.906,2.669-4.511,4.866-6.934,7.134c-3.26,3.053-6.646,5.968-9.988,8.951
            c-0.367-0.27-0.634-0.432-0.861-0.637c-4.359-3.953-8.801-7.82-13.026-11.911c-1.65-1.597-3.044-3.574-4.13-5.606
            C1.201,16.699,0.615,14.711,0.516,12.696z"/>
        </svg>
        </a>
    </span>
    </div>
    <p class="txt_center mg_b20">
 
	 <span>가파도 - 노리매 공원 - 오설록</span>

    </p>
    <p class="memo mg_b20 flex_txt">
			제주도 여행 추천 코스를 소개합니다.
    </p>    
    <div id="wrap_api"> 
<%-- <c:forEach var="cosinfo" items="${cosnumList }">   --%>

 
         <div class="list">
            <div class="api_title">
                <span class="dot"></span>
                <h3 class="fpx16 fw_6">가파도 자전거 여행</h3>
            </div>

            <div class="api_content line_left line_h">
                <div class="list_info">           
                    <div>
                    <p class="api_img">
                    	<img src="${pageContext.request.contextPath}/resources/upload/img/222.jpg" alt="getLocname()">
                    </p>
	                    <table class="api_summery">
	                    	<tbody>
	                    	<tr>
	                    	<th class="api_th">주소</th>
	                    	<td class="api_td">제주특별자치도 서귀포시 대정읍 가파리()</td>
	                    	</tr>
	                    	<tr>
	                    	<th class="api_th">연락처</th>
	                    	<td class="api_td">-</td>
	                    	</tr>
	                    	<tr>
	                    	<th class="api_th">운영시간</th>
	                    	<td class="api_td">-</td>
	                    	</tr>   
	                    	</tbody>                 	
	                    </table>               
                    </div>
                </div><!-- list_info -->
            </div><!-- api_content -->          
        </div> <!-- list -->   
        
        

    <div class="list">
            <div class="api_title">
                <span class="dot"></span>
                <h3 class="fpx16 fw_6">노리매 공원</h3>
            </div>
            <div class="api_content line_left line_h">
                <div class="list_info">           
                    <div>
                    <p class="api_img">
                    	<img src="${pageContext.request.contextPath}/resources/upload/img/111.jpg" alt="getLocname()">
                    </p>
	                    <table class="api_summery">
	                    	<tbody>
	                    	<tr>
	                    	<th class="api_th">주소</th>
	                    	<td class="api_td">제주특별자치도 서귀포시 대정읍 중산간서로 2260-15</td>
	                    	</tr>
	                    	<tr>
	                    	<th class="api_th">연락처</th>
	                    	<td class="api_td">064-792-8211</td>
	                    	</tr>
	                    	<tr>
	                    	<th class="api_th">운영시간</th>
	                    	<td class="api_td">09:00~18:00 폐장 1시간 전 입장마감</td>
	                    	</tr>   
	                    	</tbody>                 	
	                    </table>               
                    </div>
                </div><!-- list_info -->
            </div><!-- api_content -->          
        </div> <!-- list -->   
       
         <div class="list">
            <div class="api_title">
                <span class="dot"></span>
                <h3 class="fpx16 fw_6">오설록 티 뮤지엄</h3>
            </div>

            <div class="api_content line_left line_h">
                <div class="list_info">           
                    <div>
                    <p class="api_img">
                    	<img src="${pageContext.request.contextPath}/resources/upload/img/333.jpg" alt="getLocname()">
                    </p>
	                    <table class="api_summery">
	                    	<tbody>
	                    	<tr>
	                    	<th class="api_th">주소</th>
	                    	<td class="api_td">제주특별자치도 서귀포시 안덕면 신화역사로 15 오설록</td>
	                    	</tr>
	                    	<tr>
	                    	<th class="api_th">연락처</th>
	                    	<td class="api_td">064-794-5312</td>
	                    	</tr>
	                    	<tr>
	                    	<th class="api_th">운영시간</th>
	                    	<td class="api_td">09:00~18:00 연중무휴</td>
	                    	</tr>   
	                    	</tbody>                 	
	                    </table>               
                    </div>
                </div><!-- list_info -->
            </div><!-- api_content -->          
        </div> <!-- list -->   
        
        
<%-- </c:forEach> --%>
    </div><!-- wrap_api -->
    <form id="contentView" method="post">         
                 <a id="contentBtn" href="#"  class="mg_t20 btn_details flex_txt fpx14">
			     	상세보기     	
			     <input type="hidden" name="cosnum" value="1" id="cosnum">
			     <input type="hidden" name="cosname" value="잔잔한 여행" id="cosname">
			     <input type="hidden" name="mode" id="mode" value="rest">
	            <input type="hidden" name="level"  id="level"  value="1">
			     </a>           
    </form> 

    <!-- <button class="mg_t20 btn_details" onclick="moveContent()">상세보기</button> -->
</div>

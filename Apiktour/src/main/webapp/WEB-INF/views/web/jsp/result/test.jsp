<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="Admin.*, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
 <%
	request.setCharacterEncoding("utf-8");
   //String mode=request.getParameter("mode");
	//String level=request.getParameter("level");


	//int lv=Integer.parseInt(level);
	//String play=mode;
	//int count=Integer.parseInt(request.getParameter("count"));
	String play="play";
	int lv = 1;
	System.out.println("play:"+play+" , lv:"+lv);	
	
	//DB조회
	CourseDAO course = new CourseDAO();
	//int count=0;	
	
	 // 코스유형이 ?이며 코스레벨이 ?인 코스들(list)의 좌표값과 여행지타입 조회
	 List cosmap = null;
	 //List cosmap2 = null;
	 cosmap = course.getCourseMapList(play, lv);
	 //cosmap2 = course.getCourseMapList(play, lv);
	 CourseDTO cos=new CourseDTO();
	 MapDTO map = new MapDTO();


   %>
   <h3>   지도 좌표 가져오기     </h3>   
    <%

for(int i=0;i<cosmap.size();i++){
    map=(MapDTO)cosmap.get(i);%>
    
    <div>
    	<%=cos.getCosnum()%>, <%=cos.getCosname() %>, <%=cos.getPlay() %>, <%=cos.getLv() %>
    	<%=map.getLocname() %>, <%=map.getLocationx() %>, <%=map.getLocationy() %> , <%=map.getLoctype() %>
    </div>    
    
<%    
    }
%>

   <h3>   지도 좌표 Json 방식 가져오기     </h3>   
   [
    <%

for(int i=0;i<cosmap.size();i++){
    map=(MapDTO)cosmap.get(i);
   
    %>
    
    { 
    	"locname" : <%=map.getLocname() %>, 
    	"locationx" : <%=map.getLocationx() %>,
    	"locationy": <%=map.getLocationy() %> ,
    	"loctype":<%=map.getLoctype() %>
    } ,
    
<%    
    }
%>
]









<%-- <h3>과연 나올까?</h3> 
    <%

for(int i=0;i<cosmap2.size();i++){

    cos=(CourseDTO)cosmap2.get(i);%>
    
    <div>
    	<%=cos.getCosnum()%>, <%=cos.getCosname() %>, <%=cos.getPlay() %>, <%=cos.getLv() %>
    	<%=map.getLocname() %>, <%=map.getLocationx() %>, <%=map.getLocationy() %> 
    </div>    
    
<%    
    }
%> --%>

<body>

</body>
</html>
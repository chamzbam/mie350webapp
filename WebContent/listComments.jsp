<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div class="container-fluid text-left">
    
    
    
    
      
      
      
       <c:forEach items="${comments}" var="comment">
       
       <p><fmt:formatDate pattern="yyyy-MMM-dd"
										value="${comment.getDate()}" /></p>
      <p><c:out value="${comment.getBody()}" /></p>
      
      
  
       <br />
       
       
       </c:forEach>
       
       
       
   

	
	
			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>
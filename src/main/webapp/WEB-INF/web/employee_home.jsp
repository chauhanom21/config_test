<%@include file="/WEB-INF/web/header/employee_header.jsp" %>
<link rel="stylesheet" href="css/style.css" type="text/css">
<center>
    <br/><br/><br/><br/><br/>
    <h1><i>Welcome to Aeries Management system. </i></h1>
</center>

<%
	String regSuccess = (String)request.getAttribute("testRegSuccess");
	if (regSuccess != null) { %>
	<center><font color="green" size="3">
		 	<%= request.getAttribute("testRegSuccess") %> 
		 	</font>
	</center>
<%	} %>


<br/><br/><br/><br/><br/>
<%@include file="/WEB-INF/web/footer/footer.jsp" %>
<%@page import="com.aeries.ams.model.EmpRegForm"%>
<%@page import="java.util.List"%>
<%@include file="/WEB-INF/web/header/hr_header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="./resources/css/style.css" type="text/css">
<link rel="stylesheet" href="./resources/css/base.css">
<link rel="stylesheet" href="./resources/css/skeleton.css">
<link rel="stylesheet" href="./resources/css/layout.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.js"></script>
<script>
	window.jQuery
			|| document
					.write("<script src='js/jquery-1.5.1.min.js'>\x3C/script>")
</script>
<script src="./resources/js/app.js"></script>


<h2>
	<center>List of Employees's</center>
</h2>
<br/>
<center>

	<table class="imagetable">
		<thead>
			<th>Employee Id</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Address</th>
		<thead>
		<tbody>

			<%
				Object patients = request.getAttribute("employees");
					if (patients != null) {
						List<EmpRegForm> empList = (List<EmpRegForm>) patients;
						for (EmpRegForm emp : empList) {
			%>
			<tr>
				<td><%=emp.getEmpId()%></td>
				<td><%=emp.getFirstname()%></td>
				<td><%=emp.getLastname()%></td>
				<td><%=emp.getEmail()%></td>
				<td><%=emp.getMobile()%></td>
				<td><%=emp.getAddress()%></td>
			</tr>
			<%
				}
				}
			%>

		</tbody>
	</table>
</center>

<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
table.imagetable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.imagetable th {
	background:#b5cfd2 url('cell-blue.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
table.imagetable td {
	background:#dcddc0 url('cell-grey.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
</style>

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<%@include file="/WEB-INF/web/footer/footer.jsp"%>
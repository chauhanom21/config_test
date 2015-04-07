<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="/WEB-INF/web/header/admin_header.jsp"%>
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
<script>
	$(document).ready(function() {
	    //add more file components if Add is clicked
	    $('#addFile').click(function() {
	        var fileIndex = $('#fileTable tr').children().length;
	        console.log(fileIndex)
	        $('#fileTable').append(
	                '<tr><td>'+
	                '   <input type="file" name="fileData['+ fileIndex +']" />'+
	                '</td></tr>');
	    });
	     
	});
</script>

<h2>
	<center>Upload Patient's Report</center>
</h2>
<br><br>
			<%
				String success = (String)request.getAttribute("success");
				if (success != null) { %>
				<center><font color="green" size="3"> Congratulations! </br>
					<%= request.getAttribute("success") %> </font></center>
			<%	} %>
			
			<%
				String uploadError = (String)request.getAttribute("uploadError");
				if (uploadError != null) { %>
					<center><font color="red" size="3">	
					 <%= request.getAttribute("uploadError") %> <br>
					 
					 </font>
				    </center>
			<%	} %>
			<form:form action="uploadPatientReport" method="post" modelAttribute="uploadForm"
				enctype="multipart/form-data"> 
				<p> <input type="text" placeholder="Username"  name="username" required="true"/></p>
				<p> <input type="text" placeholder="Patient Name"  name="patient" required="true" /></p>
				
				<center>
				 <p>Select files to upload. Press Add button to add more file inputs.</p>
 
			    <input id="addFile" type="button" value="Add File" />
			    <br><br>
			    <table id="fileTable">
			        <tr>
			            <td><input name="fileData[0]" type="file" required="true"/></td>
			        </tr>
			    </table>
			    
			    <br>
			    <input type="submit" value="Upload File" />
			    </center> 
			</form:form>
			

<%@include file="/WEB-INF/web/footer/footer.jsp"%>
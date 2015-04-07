<%@include file="/WEB-INF/web/header/header.jsp" %>
<link rel="stylesheet" href="./resources/css/style.css" type="text/css">
<link rel="stylesheet" href="./resources/css/base.css">
	<link rel="stylesheet" href="./resources/css/skeleton.css">
	<link rel="stylesheet" href="./resources/css/layout.css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.js"></script>
	<script>window.jQuery || document.write("<script src='js/jquery-1.5.1.min.js'>\x3C/script>")</script>
	<script src="./resources/js/app.js"></script>
<center>
    <div class="container">

		<div class="form-bg">
			<h4>
				<font color="red">Invalid Credentials :: Login Denied</font>
			</h4>
			
			<form action="j_spring_security_check" method="post">
				<h2>Login</h2>
				<p><input type="text" placeholder="Username"  id="j_username" name="j_username" required="true"/></p>
				<p><input type="password" placeholder="Password" id="j_password" name="j_password" required="true" /></p>
				
				<button type="submit"></button>
			</form>
		</div>
	</div><!-- container -->
</center>
<br/><br/><br/>
<%@include file="/WEB-INF/web/footer/footer.jsp" %>
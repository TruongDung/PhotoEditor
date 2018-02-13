<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value='favicon3.png' />" type="image/gif" rel="shortcut icon" />
	<title>Photo Editor</title>
	
	<!-- jQuery -->
		<script src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script>
		
	<!-- Bootstrap -->
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	
	<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
	<!-- Font Awesome -->
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
	
	<!-- Photo Editor App -->
	<script src="<c:url value='/resources/js/application.js'/>"></script>
	
	<!-- Firebase libs -->
	<script src="https://www.gstatic.com/firebasejs/4.9.0/firebase-app.js"></script>
	<script src="https://www.gstatic.com/firebasejs/4.9.0/firebase-auth.js"></script> <!--authentication-->
	<script src="https://www.gstatic.com/firebasejs/4.9.0/firebase-database.js"></script>
	<script src="https://www.gstatic.com/firebasejs/4.9.0/firebase-firestore.js"></script>
	<script src="https://www.gstatic.com/firebasejs/4.9.0/firebase-messaging.js"></script>
	<script src="https://www.gstatic.com/firebasejs/4.9.0/firebase-storage.js"></script>
	
	<!-- Firebase UI -->
	<script src="https://cdn.firebase.com/libs/firebaseui/2.5.1/firebaseui.js"></script>
	<link type="text/css" rel="stylesheet" href="https://cdn.firebase.com/libs/firebaseui/2.5.1/firebaseui.css" />
	
	<!-- Firebase -->
	<script src="https://www.gstatic.com/firebasejs/4.9.0/firebase.js"></script>
	
	<!-- Application's FireBase -->
	<script src="<c:url value='/resources/js/firebase.js'/>"></script>
	
	<link rel="stylesheet" href="<c:url value='/resources/css/cover.css'/>" />
	
	
</head>

<body>

	<div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

		<!-- 
          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Cover</h3>
              <nav class="nav nav-masthead">
                <a class="nav-link active" href="#">Home</a>
                <a class="nav-link" href="#">Features</a>
                <a class="nav-link" href="#">Contact</a>
              </nav>
            </div>
          </div>
          -->

          <div id="mainSection" class="inner cover">
            <h1 class="cover-heading">Photo Editor</h1>
            
         	
         	<div class="text-center">
				<a id="signInFB" href="#" class="btn btn-fb social-button">
					<i class="fa fa-facebook"></i> Facebook</a>
			</div>
			
			<div class="text-center">
				<a href="#" class="btn btn-tw social-button">
					<i class="fa fa-twitter"></i> Twitter</a>
			</div>
         	
          </div>

		<!-- 
          <div class="mastfoot">
            <div class="inner">
              <p>Cover template for <a href="https://getbootstrap.com">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p>
            </div>
          </div>
 		-->
 
        </div>

      </div>

    </div>
    <script src="<c:url value='/resources/js/home.js'/>"></script>
    
</body>


</html>
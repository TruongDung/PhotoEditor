<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="title" fragment="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<link href="<c:url value='favicon3.png' />" type="image/gif" rel="shortcut icon" />
		<title><jsp:invoke fragment="title"/></title>
		
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
		
		<!-- Load Facebook SDK -->
		
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
		
		<!-- Other less important tools -->
		<script src="<c:url value='/resources/js/bootstrap-notify.min.js'/>"></script>
		
		<!-- Application's FireBase -->
		<script src="<c:url value='/resources/js/firebase.js'/>"></script>
		
		<!-- Common js (handle header, login section, etc.) -->
		<script src="<c:url value='/resources/js/common.js'/>"></script>
		
		<!-- Application's CSS -->
		<link rel="stylesheet" href="<c:url value='/resources/css/common.css'/>" />
		
	</head>
	<body>
		<div class="spinning-loader-container">
			<div class="spinning-loader"></div>
		</div>
	
		<div id="firebaseui-auth-container"></div>
		<nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
			<div id="navbarContainer" class="container-fluid">
				<a id="titleLink" href="editor"><span class="siteName">Photo Editor</span></a>
				<ul id="loginMenu" class="nav navbar-nav navbar-right">
					<li> 
						<img id="userAvatar1" class="profile-img" src="" alt="user avatar" />
						<span class="navbar-text" id="userName1"></span>
					</li>
					<li id="dropdownLink" class="dropdown">
						<a id="signInLink" href="#" class="dropdown-toggle" data-toggle="dropdown"><span id="signInText">Sign in</span> <span class="caret"></span></a>
						<ul id="login-dp" class="dropdown-menu">
							<li>
								 <div class="row">
										<div class="col-md-12">
											<!-- <div class="social-buttons"> -->
												<!-- <a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i> Facebook</a> -->
												<!-- <a href="#" class="btn btn-tw"><i class="fa fa-twitter"></i> Twitter</a> -->
											<!-- </div> -->
											<div class="text-center">
												<a id="signInFB" href="#" class="btn btn-fb social-button"><i class="fa fa-facebook"></i> Facebook</a>
											</div>
											<div class="text-center">
												<a href="#" class="btn btn-tw social-button"><i class="fa fa-twitter"></i> Twitter</a>
											</div>
										</div>
										<!-- <div class="bottom text-center"> -->
											<!-- <a href="#" class="btn btn-tw"><i class="fa fa-twitter"></i> Twitter</a> -->
										<!-- </div> -->
								 </div>
							</li>
						</ul>
						<ul id="features-dp" class="hidden-menu">
							<li>
								 <div class="row">
										<div class="feature-item">
										 	<a id="linkToReview" href="review">Saved Photos</a>	
										</div>
										<div class="feature-item">
										 	<a id="linkToEditor" href="editor">Photo Editor</a>	
										</div>
										<div id="signOut" class="feature-item">
											Sign out
										</div>
								 </div>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</nav>
	
		<jsp:doBody />
		
	</body>
</html>

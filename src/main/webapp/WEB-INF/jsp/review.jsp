<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper>

	<jsp:attribute name="title">
		Saved Photos
	</jsp:attribute>

<jsp:body>
<link rel="stylesheet" href="<c:url value='/resources/css/review.css'/>" />
<div class="container pageContainer">
	<div id="photosContainer" class="row">
		<div class="gallery">
			<c:forEach var="photo" items="${photos}">
			  <figure>
			    <img src="${photo.imageData}" alt="${photo.title}" />
			    <figcaption>
			    	<div>${photo.title}</div> 
			    	<div class="downloadImgLeft">
			    		<small>${photo.createdFormat}</small>
			    	</div>
			    	<div class="downloadImgRight">
			    		<a id="downloadImg" href="${photo.imageData}" download="${photo.title}">
				    		<span id="downloadImgIcon" class="fa fa-download fa-2x image-command">
			    			</span>
		    			</a>
			    		<span id="shareImgIcon" class="fa fa-facebook fa-2x image-command"></span>
			    		<span id="deleteImgIcon" class="fa fa-trash image-command" data-value="${photo.id}"></span>
			    	</div>
			    </figcaption>
			  </figure>
			 </c:forEach>
		</div>
	</div>
</div>
<script src="<c:url value='/resources/js/facebook-connector.js'/>"></script>
<script src="<c:url value='/resources/js/review.js'/>"></script>
</jsp:body>
</t:wrapper>



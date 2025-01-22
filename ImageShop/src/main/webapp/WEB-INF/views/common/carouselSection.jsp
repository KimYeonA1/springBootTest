<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/carouselSection.css">
<c:out value="${pageContext.request.contextPath}" />

<div class="carousel">
	<div id="slide_show">
		<a href="#"><img src="${pageContext.request.contextPath}/image/fashion.jpg" alt="" class="slide" id="p2" /></a>
		<a href="#"><img src="${pageContext.request.contextPath}/image/makeup.jpg" alt="" class="slide" id="p3" /></a> 
		<a href="#"><img src="${pageContext.request.contextPath}/image/casing.jpg" alt="" class="slide" id="p1" /></a> 
		<a href="#"><img src="${pageContext.request.contextPath}/image/tennis.jpg" alt="" class="slide" id="p4" /> </a>
	</div>
	<i class="fa-solid fa-chevron-left" id="navgateleft"></i> 
	<i class="fa-solid fa-chevron-right" id="navgateright"></i>
	<div id="indicator">
		<a href="#" class="active"> 
		<i class="fa-solid fa-minus"></i></a> 
		<a href="#"> <i class="fa-solid fa-minus"></i></a>
		<a href="#"> <i class="fa-solid fa-minus"></i></a><a href="#"> 
		<i class="fa-solid fa-minus"></i></a>
	</div>
</div>
<%-- <script src="<%=request.getContextPath()%>/static/js/carousel.js"></script> --%>
<script src="${pageContext.request.contextPath}/js/carousel.js"></script>

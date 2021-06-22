<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="html/meta.html"></jsp:include>

        <title>Back to the Future - Lugares</title>
        
        <jsp:include page="html/import.html"></jsp:include>
        <link rel="stylesheet" href="css/mainStyle.css">
        <link rel="stylesheet" href="css/sidebar.css">
        <link rel="stylesheet" href="css/locationStyle.css">
        <link rel="stylesheet" href="css/footer.css">

    </head>
    <body>
        <header>
            <jsp:include page="html/sidebar.html"></jsp:include>
        </header>

        <main>
	        <c:forEach var="location" items="${locList}">
	        	<c:if test="${location.locationImages.size() > 0}">
			        <section>
			            <div id="carouselExampleFade${location.id}" class="carousel slide carousel-fade" data-ride="carousel">
			                <div class="carousel-inner ">
			                <c:forEach items="${location.locationImages}" var="image" varStatus="id">
			                	<c:if test="${id.count % 2 == 0}">
				                  <div class="carousel-item active">
				                    <img src="${image.url}" class="d-block w-100 " alt="...">
				                  </div>
			                	</c:if>
			                	<c:if test="${id.count % 2 != 0}">
				                  <div class="carousel-item">
				                    <img src="${image.url}" class="d-block w-100 " alt="...">
				                  </div>
			                	</c:if>
			                </c:forEach>
			                  
			                  <div class="carousel-caption d-none d-md-block info">
			                    <h1>${location.name}</h1>
			                    <p>${location.description}</p>
			                  </div>
			                </div>
			                <c:if test="${location.locationImages.size() == 2}">
				                <a class="carousel-control-prev" href="#carouselExampleFade${location.id}" role="button" data-slide="prev">
				                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				                  <span class="sr-only">Previous</span>
				                </a>
				                <a class="carousel-control-next" href="#carouselExampleFade${location.id}" role="button" data-slide="next">
				                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
				                  <span class="sr-only">Next</span>
				                </a>
			                </c:if>
			              </div>
			        </section>
		        </c:if>
	        </c:forEach>
        </main>

        <footer>
			<jsp:include page="html/footer.html"></jsp:include>
        </footer>

        <jsp:include page="html/importScripts.html"></jsp:include>
    </body>
</html>
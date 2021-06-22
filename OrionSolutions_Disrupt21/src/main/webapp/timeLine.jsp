<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="html/meta.html"></jsp:include>

        <title>Back to the Future - Objeto</title>
        
        <jsp:include page="html/import.html"></jsp:include>
        <link rel="stylesheet" href="css/mainStyle.css">
        <link rel="stylesheet" href="css/sidebar.css">
        <link rel="stylesheet" href="css/footer.css">
        <link rel="stylesheet" href="css/timeline.css">

    </head>
    <body>
        <header>
            <jsp:include page="html/sidebar.html"></jsp:include>
        </header>

        <main>
        <section class="d-flex justify-content-center flex-column align-items-center" style="height:20vh;">
        		<h2 class="justify-content-center textStyle" style="margin: 20px;">Linha do Tempo</h2>
        		
        	</section>

        	<section class="body">
        		<div class="timeline">
                    <ul>
                        <c:forEach var="movieEvent" items="${eventList}">
                            <li>
                                <div class='time'>
                                    <span><f:formatDate value="${movieEvent.dateEvent}" pattern="yyyy"/></span>
                                </div>
                                <div class="content">
                                <h3>${movieEvent.name}</h3>
                                <p class="text-justify">
                                   ${movieEvent.description}
                                </p>
                                <img class="card-img-top" src="${movieEvent.image.url}" alt="Card image cap">
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
        	</section>
        </main>

        <footer>
			<jsp:include page="html/footer.html"></jsp:include>
        </footer>

        <jsp:include page="html/importScripts.html"></jsp:include>
    </body>
</html>
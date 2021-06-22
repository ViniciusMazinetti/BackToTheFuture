<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="html/meta.html"></jsp:include>

        <title>Back to the Future - Objeto</title>
        
        <jsp:include page="html/import.html"></jsp:include>
        <link rel="stylesheet" href="css/mainStyle.css">
        <link rel="stylesheet" href="css/sidebar.css">
        <link rel="stylesheet" href="css/objectStyle.css">
        <link rel="stylesheet" href="css/footer.css">

    </head>
    <body>
        <header>
            <jsp:include page="html/sidebar.html"></jsp:include>
        </header>

        <main>
        	<section class="objects d-flex justify-content-center flex-column align-items-center" style="height:80vh">
	            <h1 class="textStyle text-center m-3" >Escolha um Objeto </h1>
	            <div class="d-flex justify-content-around flex-wrap">
	            	<c:forEach var="object" items="${objectList}">
		            	<div class="objectImg m-2">
		                    <a href="objectSelection?objectId=${object.id}"><img src="${object.image.url}" alt="${object.image.description}"></a>
		                </div>
	            	</c:forEach>
	            </div>
        	</section>
        	<c:if test="${show}">
	        	<section class="textStyle objects align-items-center justify-content-around d-flex">
			        	<div>
			        		<img class="imgInfo" alt="" src="${object.image.url}">
			        	</div>
			        	<div class="p-3 m-3">
			        		<h3>Nome: ${object.name}</h3>
			        		<p>Usuários: <c:forEach var="character" items="${characters}">${character.name} /</c:forEach></p>
			        		<p>Descrição: ${object.description}</p>
			        	</div>
			        	
	        	</section>
        	</c:if>
        </main>

        <footer>
			<jsp:include page="html/footer.html"></jsp:include>
        </footer>

        <jsp:include page="html/importScripts.html"></jsp:include>
    </body>
</html>
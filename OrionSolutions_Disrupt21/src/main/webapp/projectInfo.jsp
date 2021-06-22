<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="html/meta.html"></jsp:include>

        <title>Back to the Future</title>
        
        <jsp:include page="html/import.html"></jsp:include>
        <link rel="stylesheet" href="css/mainStyle.css">
        <link rel="stylesheet" href="css/sidebar.css">
        <link rel="stylesheet" href="css/footer.css">

    </head>
    <body>
        <header>
            <jsp:include page="html/sidebar.html"></jsp:include>
        </header>

        <main>
        	<section class="d-flex justify-content-center flex-column align-items-center" style="height:100vh">
        		<h2 class="justify-content-center textStyle" style="margin: 20px;">Diagrama de classes</h2>
        		<iframe src="img/pdf/OrionSolutions_Diagrama_de_Classes.pdf" width="100%" height="100%" style="border: none;"></iframe>
        	</section>
        </main>

        <footer>
			<jsp:include page="html/footer.html"></jsp:include>
        </footer>

        <jsp:include page="html/importScripts.html"></jsp:include>
    </body>
</html>
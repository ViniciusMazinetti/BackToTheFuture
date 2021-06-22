<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="html/meta.html"></jsp:include>

        <title>Back to the Future - Personagens</title>
        
        <jsp:include page="html/import.html"></jsp:include>
        <link rel="stylesheet" href="css/mainStyle.css">
        <link rel="stylesheet" href="css/sidebar.css">
        <link rel="stylesheet" href="css/characterStyle.css">
        <link rel="stylesheet" href="css/footer.css">

    </head>
    <body>
        <header>
            <jsp:include page="html/sidebar.html"></jsp:include>
        </header>

        <main>
            <section>
                <jsp:include page="html/bannerCharacter.html"></jsp:include>
            </section>

            <!-- Replicar - Inicio-->
            <c:forEach items="${charList}" var="character" varStatus="id">
	            <section class="character d-flex justify-content-center align-items-center" id="character${character.id}">
	            

					<c:choose>
		            	<c:when test="${id.count % 2 == 0}">
			                <div class="order-2">
			                	<img class="characterImage" src="img/character/${character.name}_young.png" alt="">
	                		</div>
		            	</c:when>
		            	<c:otherwise>
		            		<div class="order-1">
		            			<img class="characterImage" src="img/character/${character.name}_young.png" alt="">
	               			</div>
		            		
		            	</c:otherwise>
					</c:choose>	            	
	                
	                <div class="order-1 info">
	                    <h1 class="textStyle">${character.name}</h1>
	                    <p class="textStyle">${character.description}</p>
	                    <p class="textStyle"><span >Ator/Atriz:</span>${character.actorsName}</p>
	                    <c:if test="${character.characterImages.size() != 1}">
		                    <button onclick="changeImg(this)" class="btn">
		                        <img class="timeTravel" src="img/nav/delorean_time.gif" alt="">
		                    </button>
	                    </c:if>
	                </div>
	                
            </section>
            </c:forEach>
            <!-- Fim -->
            
        </main>

        <footer>
			<jsp:include page="html/footer.html"></jsp:include>
        </footer>

        <jsp:include page="html/importScripts.html"></jsp:include>
        <script src="js/character.js"></script>
        
    </body>
</html>
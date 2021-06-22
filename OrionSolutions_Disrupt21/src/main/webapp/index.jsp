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
		<jsp:include page="html/bannerIndex.html"></jsp:include>

		<div>
			<p class="textStyle text-center">
				Diagrama de classes: <a href="projectInfo.jsp">Link</a> | Machine
				Learning: <a target="_blank"
					href="https://colab.research.google.com/drive/1e9UYh4rPqVkJGh83XiHanJLFqeVCVVPg?usp=sharing">Link</a>
			</p>
		</div>


	</main>

	<footer>
		<jsp:include page="html/footer.html"></jsp:include>
	</footer>

	<jsp:include page="html/importScripts.html"></jsp:include>
</body>
</html>
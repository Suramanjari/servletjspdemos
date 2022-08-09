<%@ taglib prefix="c" uri="https://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] cities = {"Mumbai", "Delhi", "Pune"};
		pageContext.setAttributr("mycities",cities);
		
	%>
	
	<c:forEach var="city" items="${mycities}">
		${city} <br>
	<c:forEach>
	
</body>
</html>
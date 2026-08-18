<%@page import="model.Category_Bean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Category List</h3>
<%-- 
<%

List<Category_Bean> catlist = (List<Category_Bean>) request.getAttribute("catList");

for(Category_Bean obj:catlist){ 
	%>
	<a href="MovieListServlet?catId=<%= obj.getId()%>"><%= obj.getName() %></a> <br> 
	
	<%
    }
	%> --%>
	
	<c:forEach  items="${CatList}" var="category">
	<a href="MovieListServlet?catId=${category.}">${category.name}</a>
	</c:forEach>




</body>
</html>
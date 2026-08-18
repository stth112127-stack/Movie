<%@page import="model.MovieBean"%>
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

<%-- 
<%

List<MovieBean> movlist = (List<MovieBean>) request.getAttribute("movie_list");


%> --%>
<form action="Selected-movie" method="post">

<select name="mname">
<option value="none">None</option>


<%-- 
<%

for(MovieBean obj:movlist){ 
	%>
	   <option value="<%= obj.getId()%>"><%= obj.getTitle() %>,<%= obj.getRelease_year().getYear() %></option>
	
	<%
    }
	%> --%>
	
	<c:forEach items="${movie_list}" var="movie">
	 <option value="${movie.id}">${movie.title}, ${movie.release_year}</option>

	</c:forEach>
	
	
	

</select> <br>

<input type="submit" value="choose">
</form>

</body>
</html>
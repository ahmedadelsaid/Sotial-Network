<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>All Notifications</head>
<body>
<c:forEach items="${it.result}" var="notification">
<p>Time is <c:out value="${notification.timestamp}"></c:out></p>
</c:forEach>
</body>
</html>
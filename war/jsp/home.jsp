<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<p> Welcome b2a ya ${it.name} </p>
<p> This is should be user home page </p>
<p> Current implemented services "http://fci-swe-apps.appspot.com/rest/RegistrationService --- {requires: uname, email, password}" </p>
<p> and "http://fci-swe-apps.appspot.com/rest/LoginService --- {requires: uname,  password}" </p>
<p> you should implement sendFriendRequest service and addFriend service
<form action="/social/search" method="post">
Search for Friend : <input type="text" name="uname" /> <br>
  <input type="submit" value="search">
  </form>
  <form action="/social/logout" method="post"><br>
  <input type="submit" value="LOgout">
  </form>
  <form action="/social/accept" method="post">
acceptname : <input type="text" name="uname" /> <br>
  <input type="submit" value="accept">
  </form>
</body>
</html>
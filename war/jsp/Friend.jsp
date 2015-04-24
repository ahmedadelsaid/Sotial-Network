<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<p> WOW We find Name ${it.name} </p>

 <form action="/social/add" method="post">
 Your Name: <input type="text" name="uname" value=' ${it.name}'/> <br>
 Your friend: <input type="text" name="fname" value=' ${it.name}'/> <br>
  <input type="submit" value="ADD">
 </form>
</body>
</html>
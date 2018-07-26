
<%@ page language="java"  import="java.util.*,com.neuedu.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>

<form action="cart" method="post">
	<input type="hidden" name="operation" value="3"/>
	<table align="center">
	<tr>
		<td>要修改的数量：</td>
		<td><input type="text" name="number"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="确定"/></td>
	</tr>
	</table>
	</form>
  <p>
  <a href="http://localhost:8080/BusinessProject_Web/ProductPageController?pageNo=1">返回购物车继续购物</a>
  </p>
</body>
</html>
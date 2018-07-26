<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>欢迎${acc.username}登陆电商后台管理系统</h1>
	<a href="view/addproduct.jsp">添加商品</a><br/>
	<a href="view/product?operation=2&pageNo=1&pageSize=4">查看商品</a><br/>
	<a href="ProductPageController?pageNo=1">购买商品</a><br/>
	<a href="view/category?operation=2&pageNo=1&pageSize=4">查看分类</a><br/>
	<a href="view/addcategory.jsp">添加分类</a><br/>
</body>
</html>
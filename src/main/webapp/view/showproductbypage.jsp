<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">商品列表</h1>
	<table align="center" border="1" cellpadding="0" cellspacing="0" width="88%">
		<tr>
			<th>商品id</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品图片</th>
			<th>商品规格</th>
			<th>商品库存</th>	
			<th>商品描述</th>	
			<th>商品操作</th>
		
		</tr>
		
		<c:forEach items="${pageMo.data }" var="product" varStatus="vs" >
			<tr bgcolor="${vs.index%2==0?'#CCCCCC':'#6081A3'}">
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${product.image}</td>
				<td>${product.rule }</td>
				<td>${product.stock }</td>	
				<td>${product.desc }</td>
				<td><a href="product?operation=4&id=${product.id }">删除</a>  
				<a href="product?operation=5&id=${product.id }">修改</a></td>
			</tr>
			
		</c:forEach>
		
		
			
	</table>
	<p style="text-align: center">
	<c:forEach begin="1" end="${pageMo.totalPage}" step="1" var="current">
		<c:choose>
			<c:when test="${pageMo.currentPage==current }">
				<a style="color:red" href="product?operation=2&pageNo=${current}&pageSize=4">${current}</a>
			</c:when>
			<c:when test="${pageMo.currentPage!=current }">
				<a style="color:blue" href="product?operation=2&pageNo=${current}&pageSize=4">${current}</a>
			</c:when>
		</c:choose>
		
	</c:forEach>
	</p>
</body>
</html>
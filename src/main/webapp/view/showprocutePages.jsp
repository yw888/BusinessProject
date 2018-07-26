<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">  
</head>
<body>
<h1 align="center">商品列表</h1>
	<table align="center" border="1" width="88%" cellpadding="0" cellspacing="0" >
		<tr>
			<th>商品id</th>
			<th>商品名称</th>
			<th>商品描述</th>
			<th>商品价格</th>
			<th>商品图片</th>
			<th>商品规格</th>
			<th>商品库存</th>
			<th>商品操作</th>
		</tr>
		<c:forEach items="${pageModel.data}" var="product" varStatus="vs">
			<tr  bgcolor="${vs.index%2==0?'#CCCCCC':'#6081A3'}">
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.desc}</td>
				<td>${product.price}</td>
				<td>${product.rule}</td>
				<td>${product.image}</td>
				<td>${product.stock}</td>
				<%-- <td><a href="view/cart?operation=1&id=${product.id}">加入购物车</a></td> --%>
				<td>[<a href="BuyServlet?productId=${product.id}">购买</a>]</td>
			</tr>
		</c:forEach>
	</table>
	<p align="center">
	<a href="ShowCartServlet">查看购物车</a>
	</p>
	<div align="center">
	<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}" step="1" >
	    <a href="ProductPageController?pageNo=${pageNo}">${pageNo}</a>
	</c:forEach>
	</div>
</body>
</html>
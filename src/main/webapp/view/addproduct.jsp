<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="product" method="post">
	<input type="hidden" name="operation" value="1"/>
	<table align="center">
	<h1 style="text-align:center">添加商品</h1>
	<tr>
		<td>商品名称</td>
		<td><input type="text" name="pname"/></td>
	</tr>
	<tr>
		<td>商品描述</td>
		<td><input type="text" name="pdesc"/></td>
	</tr>
	<tr>
		<td>商品价格</td>
		<td><input type="text" name="price"/></td>
	</tr>
	<tr>
		<td>商品规格</td>
		<td><input type="text" name="rule"/></td>
	</tr>
	<tr>
		<td>商品图片</td>
		<td><input type="text" name="pimage"/></td>
	</tr>
	<tr>
		<td>商品库存</td>
		<td><input type="text" name="stock"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="添加商品"/></td>
	</tr>
	</table>
	</form>
	
</body>
</html>
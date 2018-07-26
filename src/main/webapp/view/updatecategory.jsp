<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="category" method="post">
	<input type="hidden" name="operation" value="3"/>
	<input type="hidden" name="id" value="${category.id }"/>
	<table align="center">
	<h1 style="text-align:center">修改类别</h1>
	<tr>
		<td>父类id</td>
		<td><input type="text" name="cparent_id" value="${category.parent_id }"/></td>
	</tr>
	<tr>
		<td>类别名称</td>
		<td><input type="text" name="cname" value="${category.name}"/></td>
	</tr>
	<tr>
		<td>类别状态</td>
		<td><input type="text" name="cstatus" value="${category.status }"/></td>
	</tr>
	<tr>
		<td>排序编号</td>
		<td><input type="text" name="csort_order" value="${category.sort_order }"/></td>
	</tr>
	<%-- <tr>
		<td>创建时间</td>
		<td><input type="text" name="ccreate_time" value="${category.create_time }"/></td>
	</tr>
	<tr>
		<td>更新时间</td>
		<td><input type="text" name="cupdate_time" value="${category.update_time }"/></td>
	</tr> --%>
	<tr>
		<td><input type="submit" value="修改类别"/></td>
	</tr>
	</table>
	</form>
	
</body>
</html>
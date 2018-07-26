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
	<h1 align="center">类别列表</h1>
	<table align="center" border="1" cellpadding="0" cellspacing="0"  width="88%">
		<tr>
			<th>类别id</th>
			<th>父类id</th>
			<th>类别名称</th>
			<th>类别状态</th>
			<th>排序编号</th>
			<th>创建时间</th>	
			<th>更新时间</th>	
			<th>类别操作</th>
		
		</tr>
		
		<c:forEach items="${pageMo.data }" var="category" varStatus="vs">
			<tr  bgcolor="${vs.index%2==0?'#CCCCCC':'#6081A3'}">
				<td>${category.id }</td>
				<td>${category.parent_id }</td>
				<td>${category.name }</td>
				<td>${category.status}</td>
				<td>${category.sort_order }</td>
				<td>${category.create_time }</td>	
				<td>${category.update_time }</td>
				<td><a href="category?operation=4&id=${category.id }">删除</a>  
				<a href="category?operation=5&id=${category.id }">修改</a></td>
			</tr>
			
		</c:forEach>
		
		
			
	</table>
	<p style="text-align: center">
	<c:forEach begin="1" end="${pageMo.totalPage}" step="1" var="current">
		<c:choose>
			<c:when test="${pageMo.currentPage==current }">
				<a style="color:red" href="category?operation=2&pageNo=${current}&pageSize=4">${current}</a>
			</c:when>
			<c:when test="${pageMo.currentPage!=current }">
				<a style="color:blue" href="category?operation=2&pageNo=${current}&pageSize=4">${current}</a>
			</c:when>
		</c:choose>
		
	</c:forEach>
	</p>
</body>
</html>
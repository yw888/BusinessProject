<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
		.fl{float:left;}
		.fr{float:right;}
		.page-title .modular{display:block;}
		.page-title{border-bottom:1px #ddd solid;overflow:hidden;padding:5px 0;margin-bottom:8px;}
		.page-title i{background:url('../images/admin_bg.png') -4px -44px;display:inline-block;width:23px;height:19px;position:relative;top:3px;margin-right:5px;}
		.pt-link-btn{font-size:13px;background:#96aecd;display:block;padding:5px 8px;border-radius:2px;color:#fff;cursor:pointer;}
		.pt-link-btn:hover{background:#a0b7d4;}
		.page-title em{font-style:normal;color:#3d3d3d;font-size:15px;font-weight:bold;}
	</style>
</head>
<body>
	<div class="page-title">
		<span class="modular fl"><i></i><em>商品分类</em></span>
		<span class="modular fr"><a href="addcategory.jsp" class="pt-link-btn">+添加新分类</a></span>
	</div>
	<br>
	<table align="center" border="1" cellpadding="0" cellspacing="0"  width="100%">
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
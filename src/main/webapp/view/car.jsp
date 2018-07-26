
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
<h1 align="center">您的商品如下：</h1>
	<table align="center" border="1" cellspacing="0">
  <tr bgcolor="pink">
  <td>商品编号</td>
  <td>商品名称</td>
  <td>商品价格</td>
  <td>商品数量</td>
  <td>操作</td>
  </tr>
  
  <%    
        List<Map<String,Object>> shoppinglist=(List<Map<String,Object>>)session.getAttribute("shoppinglist");
		    for(Map<String,Object> map :shoppinglist){
   %>

   
   <tr>
   <td><%=((Product)map.get("goods")).getId() %></td>
   <td><%=((Product)map.get("goods")).getName() %></td>
   <td><%=((Product)map.get("goods")).getPrice() %></td>
   <td><%=Integer.parseInt(map.get("count").toString())%></td>
   <td><a href="cart?operation=4&id=<%=((Product)map.get("goods")).getId() %>">删除</a>
   <a href="updatecarnum.jsp">修改</a></td>
   </tr>
   
   <%} %>   
  </table>
  <p>
  <a href="http://localhost:8080/BusinessProject_Web/ProductPageController?pageNo=1">返回购物车继续购物</a>
  </p>
</body>
</html>
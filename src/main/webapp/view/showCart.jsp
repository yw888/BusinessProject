<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align: center;">
  	<br/>
    	<h1>您购买的商品如下</h1>
    	<c:if test="${empty sessionScope.cart.items}">
    		对不起！您还没有购买任何商品
    	</c:if>
    	<c:if test="${!empty sessionScope.cart.items}">
    		<table border="1" width="88%" align="center">
    			<tr>
    				<th>商品id</th>
    				<th>商品名称</th>
    				<th>单价</th>
    				<th>数量</th>
    				<th>小计</th>
    				<th>操作</th>
    			</tr>
    			<c:forEach items="${sessionScope.cart.items}" var="me" varStatus="vs">
    				<tr bgcolor="${vs.index%2==0?'#CCCCCC':'#6081A3'}">
	    				<td>${me.value.product.id}</td>
	    				<td>${me.value.product.name}</td>
	    				<td>${me.value.product.price}</td>
	    				<td>
							<input type="text" name="num" value="${me.value.num}" size="3" onchange="changeNum(this,'${me.key}',${me.value.num})"/>
						</td>
	    				<td>${me.value.price}</td>
	    				<td>
	    					[<a href="javascript:delOne('${me.key}')">删除</a>]
	    					
	    				</td>
	    			</tr>
    			</c:forEach>
    			<tr>
	    			<td colspan="2">
	    				[<a href="javascript:delAll()">清空购物车</a>]
	    			</td>
	    			<td colspan="2" align="right">总计</td>
	    			<td colspan="2">${sessionScope.cart.price}</td>
	    		</tr>
    		</table>
    	</c:if>
    	
    	<a href="http://localhost:8080/BusinessProject_Web/ProductPageController?pageNo=1">继续购物</a>
    	<script type="text/javascript">
    		function changeNum(inputObj,productId,oldNum){
				var newnum = inputObj.value;//新的数量
				var sure = window.confirm("确定要把数量改为"+newnum+"吗?");//返回值 ：点确定就返回true
				if(sure){
					//alert("提交服务器去处理");
					window.location.href="ChangeNumServlet?productId="+productId+"&newnum="+newnum;
				}else{
					//改回原来的值
					inputObj.value=oldNum;
				}
    		}
    		//删除一个购物项
    		function delOne(productId){
				var sure = window.confirm("确定要删除该项吗?");
				if(sure){
					window.location.href="DelOneCartItemServlet?productId="+productId;
				}
    		}
    		function delAll(){
    			var sure = window.confirm("确定要清空购物车吗?");
				if(sure){
					window.location.href="DelAllCartItemServlet";
				}
    		}
    	</script>
    	${message }
  </body>
</html>

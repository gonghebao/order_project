<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script src="detail/style/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="detail/style/css/index.css" />
<script type="text/javascript">
   // 删除菜品项
	function removeSorder(node) {
		var foodid = node.lang;
		window.location.href = "removeSorder.web?&tableId=${tableId}&foodid="+foodid;
	}
	
	 // 修改菜品项数量
	function alterSorder(btn) {
		var number = btn.value;
		var foodid = btn.lang;
		window.location.href = "alterSorder.web?number="+number+"&foodid="+foodid+"&tableId=${tableId}";
	} 
	// 下单
	function genernateOrder() {
		window.location.href = "clientOrderList.web?tableId=${tableId}";
	}
</script>
</head>

<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 餐车div -->
			<div id="count">
				<table align="center" width="100%">
					<tr height="40">
						<td align="center" width="20%">菜名</td>
						<td align="center" width="20%">单价</td>
						<td align="center" width="20%">数量</td>
						<td align="center" width="20%">小计</td>
						<td align="center" width="20%">操作</td>
					</tr>
				    <c:set var="sum" value="0"></c:set>
					 <c:forEach items="${listcar}" var="c">
						<tr height="60">
							<td align="center" width="20%">${c.name }</td>
							<td align="center" width="20%">￥${c.price }</td>
							<td align="center" width="20%"><input type="text"
								value="${c.count}" size="3" lang="${c.foodid }" onblur="alterSorder(this)" /></td>
							<td align="center" width="20%">${c.count*c.price}</td>
							<td align="center" width="20%"><input type="button"
								value="删除" class="btn_next" lang="${c.foodid }"
								onclick="removeSorder(this)" /></td>
						</tr>
						<c:set var="sum" value="${sum+(c.count*c.price)}"></c:set>
					</c:forEach> 
					

					<tr id="before">
						<td colspan="6" align="right">总计: <span
							style="font-size: 36px;">&yen;&nbsp;${sum }</span> <label
							id="counter" style="font-size: 36px"></label>
						</td>
					</tr>
					<tr>
						<td colspan="6" style="margin-left: 100px; text-align: center;"
							align="right"><input type="hidden" name="bId" value="">
							<input type="button" value="下单" class="btn_next"
							onclick="genernateOrder()" /></td>
					</tr>
				</table>
			</div>
		</div>

		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_top">
				<ul>
					<li class="dish_num"></li>
					<li><a href="clientOrderList.web?tableId=${tableId}"> <img
							src="detail/style/images/call2.gif" />
					</a></li>
				</ul>
			</div>

			<div id="dish_2">
				<ul>
					<c:forEach items="${foodtype_list }" var="c">
                        <li><a href="chuancai.web?caixi=${c.typename }&tableId=${tableId}">${c.typename}</a>
                        </li>
                    </c:forEach>
				</ul>
			</div>
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				<form action="caidan_search.web?tableId=${tableId}" method="post">
					<table width="166px">
						<tr>
							<td><input type="text" id="dish_name" name="foodName"
								class="select_value" /> <input type="hidden" value="selectFood"
								name="method"></td>
						</tr>
						<tr>
							<td><input type="submit" id="sub" value="" /></td>
						</tr>
						<tr>
							<td><a href="caidan.web?tableId=${tableId}"> <img src="detail/style/images/look.gif" />
							</a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

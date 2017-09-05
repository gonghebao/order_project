﻿<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- 包含公共的JSP代码片段 -->
<title>无线点餐平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="detail/style/js/jquery.js"></script>
<script type="text/javascript" src="detail/style/js/page_common.js"></script>
<link href="detail/style/css/common_style_blue.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css"
	href="detail/style/css/index_1.css" />
<link href="detail/style/css/index.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="detail/style/css/dis_message.css" />
<script type="text/javascript">
   
	function clientCart(btn) {
		location.href = "clientCart.web?foodid=${id }&tableId=${tableId}&isClick=false";
	}
</script>
</head>
<body style="text-align: center">
	<div id="all">
		<!--左边菜品详细信息 -->
		<div id="menu1">
			<div class="menu2" style="text-align: center;">
				<img src="detail/style/images/order_detials_bg.png" />
			</div>
			<div class="menu3">
				<div class="menu3_left">
					<img src="upload/${caipin.img }"
						style="width: 270px; height: 290px;" />
					<p style="margin-top: 20px;" id="foodid">菜品编号：${id }</p>
				</div>
				<div class="menu3_right">
					<div id="d">
						<p>菜名：&nbsp&nbsp&nbsp ${caipin.foodName }</p>
						<p>单价：&nbsp&nbsp&nbsp ${caipin.price }</p>
						<p>会员价：&nbsp&nbsp&nbsp ${caipin.mprice }</p>
						<p id="jianjie">简介：${caipin.remark }</p>
					</div>
				</div>
				<!--	<div class="menu3_right">
					<p>菜名:白灼虾</p>
					<p>价格:&nbsp;&nbsp;&yen;&nbsp;36.0</p>
					<p>简介:粤菜白灼虾，大件！</p>
				</div> -->
			</div>
			<div class="menu4">

				<a href="#" onclick="clientCart(this)"
					style="background: url(detail/style/images/img/order_left_corner_bg.png);">放入餐车</a>
				<a href="caidan.web?tableId=${tableId}"
					onclick="javascript:history.go(-1);"
					style="background: url(detail/style/images/img/order_right_corner_bg.png);">返回</a>
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
						<li><a
							href="chuancai.web?caixi=${c.typename }&tableId=${tableId}">${c.typename}</a>
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
							<td><a href="caidan.web?tableId=${tableId}"> <img
									src="detail/style/images/look.gif" />
							</a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

﻿<%@page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 包含公共的JSP代码片段 -->

<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="detail/style/js/jquery.js"></script>
<script type="text/javascript" src="detail/style/js/page_common.js"></script>
<link href="detail/style/css/common_style_blue.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
<link href="detail/style/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 显示菜品的div -->
			<div id="top">
				<ul>
					<!-- 循环列出餐品 -->
					<c:forEach items="${list}" var="c">
						<li>
							<dl>
								<dt>
									<a href="caixiangxi.web?tableId=${tableId}&id=${c.id}"> <img alt="" src="upload/${c.img}"
										width="214px" height="145px" />
									</a>
								</dt>
								<dd class="f1">
									<a href="caixiangxi.web?tableId=${tableId}&id=${c.id}">${c.foodname }</a>
								</dd>
								<dd class="f2">
									<a href="caixiangxi.web?tableId=${tableId}&id=${c.id}">${c.price}</a>
								</dd>
							</dl>
						</li>
					</c:forEach>
					<!-- 	<li>
							<dl>
								<dt>
									<a href="caixiangxi.web">
										<img width="214px" height="145px" src="detail/style/images/baizhuoxia.jpg" />
									</a>
								</dt>
								<dd class="f1">
									<a href="caixiangxi.web">白灼虾</a>
								</dd>
								<dd class="f2">
									<a href="caixiangxi.web">&yen;36.0</a>
								</dd>
							</dl>
						</li> -->
				</ul>
			</div>

			<!-- 底部分页导航条div -->
			<div id="foot">



				<span
					style="float: left; line-height: 53PX; margin-left: -50px; font-weight: bold;">
					<span style="font-weight: bold">&lt;&lt;</span>
				</span>

			<!-- 分页 -->
				<div id="pages" style="position:relative;top:15px">
					<c:if test="${page==1 }">
						<a href="">上一页</a>
					</c:if>
					<c:if test="${page!=1 }">
						<a href="caidan_search.web?page=${page-1 }&foodName=${name}&tableId=${tableId}">上一页</a>
					</c:if>
					<c:forEach begin="1" end="5" var="i">
						<!-- 若循环到了当前页，则将页码高亮显示 -->
						<c:if test="${i==page }">
							<a href="caidan_search.web?page=${i}&foodName=${name}&tableId=${tableId}" class="current_page">${i }</a>
						</c:if>
						<!-- 若不是当前页，则去掉高亮的样式 -->
						<c:if test="${i!=page }">
							<a href="caidan_search.web?page=${i}&foodName=${name}&tableId=${tableId}">${i }</a>
						</c:if>
					</c:forEach>
					<c:if test="${page==6 }">
						<a href="">下一页</a>
					</c:if>
					<c:if test="${page!=total }">
						<a href="caidan_search.web?page=${page+1 }&foodName=${name}&tableId=${tableId}">下一页</a>
					</c:if>

				</div>


				<span style="float: right; position:relative;top-7px; margin-right: 10px;">
					<a href="#"
					style="text-decoration: none; color: #000000; font-weight: bold">&gt;&gt;</a>
				</span>



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
					<!-- <li>
							<a href="chuancai.web?caixi=粤菜">粤菜</a>
						</li> -->
					<!-- 
						<li>
							<a href="chuancai.web?caixi=川菜">川菜</a>
						</li>
					
						<li>
							<a href="chuancai.web?caixi=湘菜">湘菜</a>
						</li>
					
						<li>
							<a href="chuancai.web?caixi=东北菜">东北菜</a>
						</li> -->

				</ul>
			</div>
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				<form action="caidan.web?tableId=${tableId}" method="post">
					<table width="166px">
						<tr>
							<td><input type="text" id="dish_name" name="foodName"
								class="select_value" /></td>
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

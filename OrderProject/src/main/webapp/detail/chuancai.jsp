<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 包含公共的JSP代码片段 -->

<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="detail/style/css/common_style_blue.css"
	rel="detail/stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="detail/style/css/index_1.css" />
<link href="detail/style/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 显示菜品的div -->
			<div id="top">
				<ul>
					<!-- 循环列出餐品 -->

					<c:forEach items="${caixi }" var="ca">
						<li>
							<dl>
								<dt>
									<a href="caixiangxi.web?id=${ca.id}&tableId=${tableId}"> <img width="214px" height="145px"
										src="upload/${ca.img }" />
									</a>
								</dt>
								<dd class="f1">
									<a href="caixiangxi.web?id=${ca.id}&tableId=${tableId}">${ca.foodname }</a>
								</dd>
								<dd class="f2">
									<a href="caixiangxi.web?id=${ca.id}&tableId=${tableId}">&yen;${ca.price }</a>
								</dd>
							</dl>
						</li>

					</c:forEach>
					<!-- <li>
							<dl>
								<dt>
									<a href="caixiangxi.web">
										<img width="214px" height="145px" src="detail/style/images/guotourou.jpg" />
									</a>
								</dt>
								<dd class="f1">
									<a href="caixiangxi.web">锅头肉</a>
								</dd>
								<dd class="f2">
									<a href="caixiangxi.web">&yen;23.0</a>
								</dd>
							</dl>
						</li>
					
						<li>
							<dl>
								<dt>
									<a href="caixiangxi.web">
										<img width="214px" height="145px" src="detail/style/images/huotuibaicai.jpg" />
									</a>
								</dt>
								<dd class="f1">
									<a href="caixiangxi.web">火腿白菜</a>
								</dd>
								<dd class="f2">
									<a href="caixiangxi.web">&yen;23.0</a>
								</dd>
							</dl>
						</li>
					
						<li>
							<dl>
								<dt>
									<a href="caixiangxi.web">
										<img width="214px" height="145px" src="detail/style/images/qingjiaojiding.jpg" />
									</a>
								</dt>
								<dd class="f1">
									<a href="caixiangxi.web">青椒鸡丁</a>
								</dd>
								<dd class="f2">
									<a href="caixiangxi.web">&yen;23.0</a>
								</dd>
							</dl>
						</li>
					
						<li>
							<dl>
								<dt>
									<a href="caixiangxi.web">
										<img width="214px" height="145px" src="detail/style/images/xiangguorouwan.jpg" />
									</a>
								</dt>
								<dd class="f1">
									<a href="caixiangxi.web">香锅肉丸</a>
								</dd>
								<dd class="f2">
									<a href="caixiangxi.web">&yen;23.0</a>
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


				<div id="pages" style="position: relative; top: 15px;">
					<c:if test="${page==1 }">
						<a href="">上一页</a>
					</c:if>
					<c:if test="${page!=1 }">
						<a href="chuancai.web?page=${page-1 }&caixi=${caixi2}&tableId=${tableId}">上一页</a>
					</c:if>
					<c:forEach begin="1" end="8" var="i">
						<c:if test="${i==page }">
							<a href="chuancai.web?page=${i }&caixi=${caixi2}&tableId=${tableId}">${i }</a>
						</c:if>
						<c:if test="${i!=page }">
							<a href="chuancai.web?page=${i }&caixi=${caixi2}&tableId=${tableId}">${i }</a>
						</c:if>
					</c:forEach>
					<c:if test="${page==8 }">
						<a href="">下一页</a>
					</c:if>
					<c:if test="${page!=total }">
						<a href="chuancai.web?page=${page+1 }&caixi=${caixi2}&tableId=${tableId}">下一页</a>
					</c:if>

				</div>

				<span
					style="float: right; position: relative; TOP: -7PX; margin-right: 10px;">
					<span style="font-weight: bold">&gt;&gt;</span>
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

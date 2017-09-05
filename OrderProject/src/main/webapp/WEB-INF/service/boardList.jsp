﻿<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style/css/common_style_blue.css" rel="stylesheet"
	type="text/css" />
<title>无线点餐后台管理</title>
</style>
<script type="text/javascript">
function update(id){
	var u = window.confirm("确定退桌吗？");
	if(u) location.href="updateTable.do?id="+id;
}
function del(id){
	var d = window.confirm("确定撤掉/删除餐桌");
	if(d) location.href="deltable.do?id="+id;
}

</script>
<style>
* {
	margin: 0;
	padding: 0;
}

.index_left {
	width: 170px;
	background-color: #4386B7;
	height: 60%;
}
.index_right_container{
	height:600px;
	position:absolute;
	right:0;
	top:0;
	width:88%;
	overflow-y:scroll;
	overflow-x:hidden;
}
.index_right {
	position: absolute;
	width: 100%;
	text-align: center;
	top: 0;
}

.clear {
	clear: both;
}

.margin_10 {
	position: relative;
}

body {
	margin: 0;
}

#Head_1 {
	background: url("style/images/img/top_head1_bg.gif") repeat-x scroll 0 0
		transparent;
	height: 64px;
	margin: 0 auto;
	width: 100%;
}

#Head_1 #Head_1_Logo {
	float: left;
	left: 20px;
	position: absolute;
	top: 12px;
	color: #F1F9FE;
	font-family: Arial Black, Arial;
	font-size: 28px;
}

#Head_1 #Head_1_UserWelcome {
	float: right;
	color: #B3E1FF;
	font-family: "宋体";
	font-size: 12px;
	height: 25px;
	padding-top: 11px;
	margin-right: 20px;
}

#Head_1 #Head_1_FunctionButton {
	float: left;
	position: absolute;
	right: 5px;
	top: 35px;
	margin-right: 15px;
}

#Head_1 #Head_1_FunctionButton img {
	margin-left: 10px;
}

#Head_2 {
	background: url("style/images/img/top_head2_bg.gif") repeat-x scroll 0 0
		transparent;
	border-bottom: 1px solid #FFFFFF;
	border-top: 1px solid #A0C6E1;
	height: 36px;
	margin: 0;
	width: 100%;
}

#Head_2 #Head2_Awoke {
	float: left;
	height: 100%;
	padding-left: 19px;
	padding-top: 2px;
}

#Head_2 #Head2_Awoke #AwokeNum {
	position: absolute;
	left: 20px;
	top: 68px;
	width: 406px;
	/*height: 21px;*/
	margin-top: 0;
	padding: 0;
	padding-top: 2px;
	list-style-type: none;
	margin-bottom: 0;
	margin-left: 0;
}

#Head_2 #Head2_Awoke #AwokeNum li {
	float: left;
	margin: 3px;
	display: inline;
}

#Head_2 #Head2_Awoke #AwokeNum a {
	color: #FFFFFF;
	font-family: "宋体";
	font-size: 12px;
	text-decoration: none;
}

#Head_2 #Head2_Awoke #AwokeNum .Line {
	border-left: 1px solid #005A98;
	border-right: 1px solid #A0C6E1;
	height: 17px;
	width: 0px;
}

#Head_2 #Head2_FunctionList, .Head2_FunctionList {
	color: #FFFFFF;
	float: right;
	font-family: "宋体";
	font-size: 13px;
	height: 100%;
	padding-right: 26px;
	padding-top: 10px;
}

#Menu {
	margin: 0;
	padding: 0;
	width: 155px;
	background: none repeat scroll 0 0 #D8EBF7;
	list-style: none outside none;
	margin-left: 3px;
	border-top: 3px solid #4891C6;
}

#Menu .level1 {
	color: #005790;
	font-weight: bold;
	padding-bottom: 1px;
	cursor: pointer;
}

#Menu .level1 .level1Style {
	background: url("style/images/img/menu_btn_bg.gif") no-repeat scroll 0 0
		transparent;
	height: 23px;
	padding-left: 20px;
	padding-top: 5px;
	width: 135px;
	margin-bottom: -4px
}

#Menu .level1 .level1Style .Icon {
	margin-top: -2px;
}

#Menu .level1 .MenuLevel2 {
	background: none repeat scroll 0 0 #D8EBF7;
	list-style: none outside none;
	margin: 0;
	padding: 0;
}

#Menu .level1 .MenuLevel2 .level2Style {
	color: #005790;
	font-weight: normal;
	border-top: 1px solid #EFF6FB;
	height: 18px;
	padding-left: 43px;
	padding-top: 5px;
	width: 112px;
	background-image: url(style/images/img/menu_arrow_single.gif);
	background-color: #8EC4E9;
	background-repeat: no-repeat;
	background-position: 29px center;
}

#Menu .level1 .level2 a {
	color: #333;
}

#Menu .level1 .level2 a:hover {
	color: #0000ff;
}

img {
	vertical-align: inherit;
	border: 0;
}

a:link, a:hover, a:visited {
	color: #A9DCFF;
	text-decoration: none;
}

#StatusBar {
	background-color: #4386B7;
	border-top: 1px solid #FFFFFF;
	height: 19px;
	width: 100%;
	position: absolute;
	bottom: 0;
}

#StatusBar #StatusBar_Links {
	color: #A9DCFF;
	float: left;
	font-family: "宋体";
	font-size: 12px;
	padding-left: 20px;
	padding-top: 3px;
}

#StatusBar #StatusBar_Right {
	color: #A9DCFF;
	float: right;
	font-family: "宋体";
	font-size: 12px;
	padding-right: 20px;
	padding-top: 4px;
}
</style>
</head>
<!-- 上部 -->
<div id="Head_1">
	<!-- 标题 -->
	<div id="Head_1_Logo">
		<b style="font-family: '黑体'">广州酒家信息管理平台</b>
		<!-- <img border="0" src="style/images/logo.png" /> -->
	</div>
	<!-- 欢迎用户的文字 -->
	<div id="Head_1_UserWelcome">
		<img border="0" width="13" height="14" src="style/images/user.gif" />
		您好，<b>${user}</b>
	</div>
	<!-- 一些链接按钮 -->
	<div id="Head_1_FunctionButton">
		<a target="right" href="javascript:void(0)"> <img width="78"
			height="20" src="style/images/help2.gif" />
		</a> <a target="_parent" href="login.do"> <img width="78"
			height="20" alt="退出系统" src="style/images/logout.gif" />
		</a>
	</div>
</div>
<div class="clear"></div>
<div class="margin_10">
	<div class="index_left">
		<ul id="Menu">
			<li class="level1">
				<div onClick="menuClick(this);" class="level1Style">
					<img src="style/images/func20001.gif" class="Icon" /> 系统菜单
				</div>
				<ul class="MenuLevel2">
					<li class="level2 level2Style"><a target="right"
						href="toBoardList.do">餐桌管理</a></li>
					<li class="level2 level2Style"><a target="right"
						href="toCuisineList.do">菜系管理</a></li>
					<li class="level2 level2Style"><a target="right"
						href="toFoodList.do">菜品管理</a></li>
					<li class="level2 level2Style"><a target="right"
						href="toFrderList.do">餐厅订单</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<div class="index_right_container">
		<div class="index_right">
		<div id="TitleArea">
			<div id="TitleArea_Head"></div>
			<div id="TitleArea_Title">
				<div id="TitleArea_Title_Content">
					<img border="0" width="13" height="13"
						src="style/images/title_arrow.gif" /> 餐桌列表
				</div>
			</div>
			<div id="TitleArea_End"></div>
		</div>

		<div id="QueryArea">
			<form action="/wirelessplatform/board.html" method="get" style="text-align:left">
				<input type="hidden" name="method" value="search"> <input
					type="text" name="keyword" title="请输入餐桌名称"> <input
					type="submit" value="搜索">
			</form>
		</div>

		<!-- 主内容区域（数据列表或表单显示） -->
		<div id="MainArea">
			<table class="MainArea_Content" cellspacing="0" cellpadding="0">
				<!-- 表头-->
				<thead>
					<tr align="center" valign="middle" id="TableTitle">
						<td>编号</td>
						<td>桌名</td>
						<td>状态</td>
						<td>预定时间</td>
						<td>操作</td>
					</tr>
				</thead>
				<!--显示数据列表 -->
				<tbody id="TableData">
					<c:forEach items="${tables}" var="t">
						<tr class="TableDetail1">
							<td align="center">${t.id}</td>
							<td align="center">${t.tableName }</td>
							<td align="center">${t.tableStatus==0?'未预定':'预定'} </td>
							<td align="center">${t.orderDate}</td>
							<td><input type="button" class="FunctionButtonInput"
								onclick="update(${t.id})" value="退桌"> <input
								type="button" class="FunctionButtonInput" onClick="del(${t.id})"
								value="删除"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<!-- 其他功能超链接 -->
			<div id="TableTail" align="center">
					<input type="button"
					onclick="location.href='/OrderProject/toAddTable.do'"
					class="FunctionButtonInput" value="添加">
				</div>
		</div>
	</div>
	</div>
	
</div>
<div id="StatusBar">
	<!-- 链接 -->
	<div id="StatusBar_Links">
		<a href="http://gz.itcast.cn" target="_blank">广州传智博客</a>，最专业的Java培训！
	</div>
	<!-- 右侧功能按钮 -->
	<div id="StatusBar_Right">
		<!-- 版本 -->
		<a href="javascript:void(0)"> <img border="0" width="11"
			height="11" src="style/images/info.gif" /> <img border="0"
			width="40" height="11" src="style/images/version.gif" />
		</a>
	</div>
</div>
</html>




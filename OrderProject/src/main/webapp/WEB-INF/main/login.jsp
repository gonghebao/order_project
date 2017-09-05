<%@page pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>达内－大酒店</title>
<link type="text/css" rel="stylesheet" media="all"
	href="styles/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="styles/global_color.css" />
</head>
<body class="index">
	<div class="login_box">
		<form action="login.do" method="post">
			<table>
				<tr>
					<td class="login_info">账号：</td>
					<td colspan="2"><input name="name" type="text" class="width150"  value="${param.name }"/></td>
					<td class="login_error_info"><span class="required">30长度的字母、数字和下划线</span></td>
				</tr>
				<tr>
					<td class="login_info">密码：</td>
					<td colspan="2"><input name="mm" type="password"
						class="width150" value = "${param.mm }"  /></td>
					<td><span class="required">30长度的字母、数字和下划线</span></td>
				</tr>
				<tr>
					<td class="login_info">验证码：</td>
					<td class="width70"><input  type="text" class="width70"  name = "code"/></td>
					<!-- 在后面加随机参数的目的，是为了欺骗浏览器，让他误以为路径发生了变化 -->
					<td><img src="createimg.do" onclick="this.setAttribute('src','createimg.do?x='+Math.random());" alt="验证码" title="点击更换" /></td>
					<td><span class="required"></span></td>
				</tr>
				<tr>
					<td></td>
					<td class="login_button" colspan="2">
					<!-- 表单提交两种方式
					1.点击按钮的submit按钮，从而触发onsubmit事件
					2.可以通过js调用表单的submit（） -->
						<a href="javascript:document.forms[0].submit();"><img
							src="style/images/login_btn.png" /></a></td>
					<td><span class="required" >${Error }</span></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>

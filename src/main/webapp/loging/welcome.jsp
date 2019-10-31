<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>欢迎页面-L-admin1.0</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
		<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="../css/font.css">
		<link rel="stylesheet" href="../css/xadmin.css">
		<script type="text/javascript" src="../js/jquery.min.js"></script>
	</head>

	<body style="height:600px;">
		<div class="x-body layui-anim layui-anim-up">
			<blockquote class="layui-elem-quote">欢迎管理员：
				<span class="x-red">${boss.mname }</span>！当前时间: &nbsp;&nbsp;
				<font id="sj"></font>
			</blockquote>
		</div>
		<div>
			<table style="width: 100%;height: 500px;">
				<tr>
					<td width="50%" align="center" colspan="2">
						<div id="tks"><img src="../images/ksjc.png" /></div>
					</td>
					<td valign="middle" colspan="3">
						<div id="tjc"><img src="../images/jcjl.png" /> </div>
					</td>
				</tr>
				<tr>
					<td width="50%" align="center" valign="top">
						<font id="ks" size="5" color="#999999">开始检测</font>
					</td>
					<td width="14px"></td>
					<td></td>
					<td width="10%"></td>
					<td valign="top">
						<font id="jc" size="5" color="#999999">检测记录</font>
					</td>
				</tr>
			</table>
		</div>
		<script type="text/javascript">
			function getDate() {
				var today = new Date();
				var date = today.getFullYear() + "-" + twoDigits(today.getMonth() + 1) + "-" + twoDigits(today.getDate()) + " ";
				var week = " 星期" + "日一二三四五六 ".charAt(today.getDay());
				var time = twoDigits(today.getHours()) + ": " + twoDigits(today.getMinutes()) + ": " + twoDigits(today.getSeconds());
				$("#sj").text(date + " " + time + " " + week);
			}

			function twoDigits(val) {
				if(val < 10) return "0" + val;
				return val;
			}

			function xfks() {
				$("#ks").css("color", "deepskyblue");
			}

			function xfjc() {
				$("#jc").css("color", "deepskyblue");
			}

			function lkks() {
				$("#ks").css("color", "#999999");
			}

			function lkjc() {
				$("#jc").css("color", "#999999");
			}

			$(function() {
				getDate();
				setInterval(getDate, 1000);
				$("#ks").hover(function() {

					xfks();
				}, function() {

					lkks();

				});
				$("#jc").hover(function() {

					xfjc();
				}, function() {

					lkjc();

				})
				$("#ks").click(function() {
					xfks();
					location.href="#";
				})
				$("#jc").click(function() {
					xfjc();
					location.href="#";
				})
				$("#tks").click(function() {
					location.href="#";
				})
				$("#tjc").click(function() {
					location.href="#";
				})
			})
		</script>
	</body>

</html>
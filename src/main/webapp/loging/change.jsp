<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<!-- 防止页面缓存 -->
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<title></title>
<!-- 引入EasyUI的样式文件-->
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet" type="text/css" href="css/wu.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">

<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="../css/font.css">
<link rel="stylesheet" href="../css/xadmin.css">
<script src="../js/jquery.min.js"></script>
<script src="../lib/layui/layui.js"></script>
<script type="text/javascript" src="../js/xadmin.js"></script>
<!-- 引入JQuery -->
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<!-- 引入EasyUI -->
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body style="background-color: lavender;">

	<div
		style="background-color: #DEE5E7; margin-top: 10px; height: 15px; width: 95%; margin-left: 2%;"></div>
	<div
		style="background-color: #DEE5E7; height: 38px; width: 95%; margin-left: 2%;">
		<font style="margin-left: 10px; color: #0092DC; font-size: 10px;">修改密码</font>
	</div>
	<div
		style="background-color: white; height: 25px; width: 95%; margin-left: 2%;"></div>
	<div
		style="background-color: white; height: 200px; width: 95%; margin-left: 2%;">
		<div>
			<div style="margin-left: 200px;">
				<label style="color: red;">*</label><label>原始密码：</label> <input
					type="text" name="password" style="margin-left: 10px;" />
			</div>

			<div style="margin-left: 220px; margin-top: 10px;">
				<label style="color: red;">*</label><label>新密码：</label> <input
					type="text" name="pwd" style="margin-left: 10px; margin-top: 6px;" />
			</div>

			<div style="margin-left: 180px; margin-top: 10px;">
				<label style="color: red;">*</label><label>确认新密码：</label> <input
					type="text" name="pwd2" style="margin-left: 10px; margin-top: 6px;" />
			</div>
			<button class="layui-btn layui-btn-normal" id="update"
				style="margin-left: 317px; margin-top: 30px; width: 150px;">保存</button>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#update").click(function(){
		var password = $("input[name='password']").val();
		$.ajax({
			url : "bossActionqueryMm.action",
			async : false,
			type : "POST",
			data : {
				'password':password,
			},
			success : function(succ) {
				var a = eval(succ);
				console.log(a);
				if (a==1) {
					xg();
				}
			}
		});
	})
	//判断密码一样就修改
	function xg() {
		var pwd = $("input[name='pwd']").val();
		var pwd2 = $("input[name='pwd2']").val();
		if (pwd==pwd2) {
			$.ajax({
				url : "bossActionupdateMm.action",
				async : false,
				type : "POST",
				data : {
					'pwd' : pwd
				},
				success : function(succ) {
					var a = eval(succ);
					console.log(a);
					if (a==1) {
						alert("修改成功");
					}
				}
			});
		}
	}
</script>
</html>
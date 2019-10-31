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
<script type="text/javascript" src="../lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="../js/xadmin.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../lib/layui/layui.js"></script>
<script type="text/javascript" src="../js/xadmin.js"></script>
<!-- 引入JQuery -->
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<!-- 引入EasyUI -->
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body style="background-color: lavender; margin-top: 20px;">
	<div
		style="background-color: white; height: 140px; width: 95%; margin-left: 2%;">
		<div style="background-color: white; height: 25px;"></div>

		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label" style="margin-left: 100px;">分店名</label>
				<div class="layui-input-inline">
					<input type="text" name="phone" lay-verify="required|phone"
						placeholder="请输入分店名" autocomplete="off" class="layui-input"
						style="width: 180px; height: 30px;">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label" style="margin-left: 100px;">分店编码</label>
				<div class="layui-input-inline">
					<input type="text" name="email" lay-verify="email"
						placeholder="请输入分店编码" autocomplete="off" class="layui-input"
						style="width: 180px; height: 30px;">
				</div>
			</div>
		</div>

		<div style="position: absolute; top: 100px; left: 100px;">
			<label style="margin-left: 60px;">所在地区</label> <select id="cc"
				class="easyui-combobox" name="dept"
				style="width: 150px; height: 30px;">
				<option value="aa">请选择</option>
			</select>
		</div>
		<div style="position: absolute; top: 100px; left: 420px;">
			<select id="cc" class="easyui-combobox" name="dept"
				style="width: 150px; height: 30px;">
				<option value="aa">请选择</option>
			</select>
		</div>
		<div style="position: absolute; top: 100px; left: 600px;">
			<select id="cc" class="easyui-combobox" name="dept"
				style="width: 150px; height: 30px;">
				<option value="aa">请选择</option>
			</select>
		</div>


		<button class="layui-btn layui-btn-normal layui-btn-radius"
			style="width: 125px; margin-left: 1000px;">查询</button>
		<button class="layui-btn layui-btn-normal layui-btn-radius"
			style="width: 125px;">重置</button>
		<button class="layui-btn layui-btn-normal layui-btn-radius"
			style="width: 125px;">添加分店</button>
	</div>

	<div
		style="background-color: white; height: 50px; width: 95%; margin-left: 2%; margin-top: 20px;">


	</div>

	<div class="page">
		<div>
			<a class="prev" href="">&lt;&lt;</a> <a class="num" href="">1</a> <span
				class="current">2</span> <a class="num" href="">3</a> <a class="num"
				href="">489</a> <a class="next" href="">&gt;&gt;</a>
		</div>
		</div>
</body>
</html>

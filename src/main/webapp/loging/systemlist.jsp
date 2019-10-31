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
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<title></title>
<!-- 引入EasyUI的样式文件-->
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="shortcut icon" href="..//favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="../css/font.css">
<link rel="stylesheet" href="../css/xadmin.css">
<!-- 引入JQuery -->
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<!-- 引入EasyUI -->
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="../easyui/layui.js"></script>


<script src="../js/jquery.min.js"></script>
<script src="../lib/layui/layui.js"></script>
<script type="text/javascript" src="../js/xadmin.js"></script>
</head>
<body style="background-color: lavender; margin-top: 10px;">
	<div align="center">
		<div style="background-color: white; height: 130px; width: 95%;">
			<div style="position: absolute; top: 30px; left: 100px;">
				<label>联系方式</label> <input class="easyui-textbox" id="phone"
					data-options="prompt:'请输入联系方法'" style="width: 200px;height: 30px;">
			</div>
			<div style="position: absolute; top: 30px; left: 450px;">
				<label>姓名</label> <input class="easyui-textbox" id="name"
					data-options="prompt:'请输入姓名'" style="width: 200px;height: 30px;">
			</div>
			<div style="position: absolute; top: 30px; left: 800px;">
				<label>状态</label> <select id="cc" class="easyui-combobox"
					name="dept" style="width: 200px;height: 40px;">
					<option value="aa">请选择</option>
				</select>
			</div>
			<div class="x-body">
				<div class="layui-row" style="margin-top: 50px; margin-left: 20px;">
					<form class="layui-form layui-col-md12  layui-form-pane">
						<div class="layui-form-item" id="x-city">
							<label class="layui-form-label">所在地区</label>
							<div class="layui-input-inline">
								<select name="province" lay-filter="province"
									style="width: 200px; height: 40px; margin-left: 10px;">
									<option value="">请选择省</option>
								</select>
							</div>
							<div class="layui-input-inline">
								<select name="city" lay-filter="city">
									<option value="">请选择市</option>
								</select>
							</div>
							<div class="layui-input-inline">
								<select name="area" lay-filter="area">
									<option value="">请选择县/区</option>
								</select>
							</div>
						</div>
					</form>
				</div>

			</div>


			<button
				id="cx"
				style="position: absolute; left: 820px; top: 82px; width: 120px; height: 35px;"
				class="layui-btn layui-btn-normal">查询</button>
			<button
				style="position: absolute; left: 975px; top: 82px; width: 120px; height: 35px;"
				class="layui-btn layui-btn-normal">重置</button>
			<button
				style="position: absolute; left: 1140px; top: 82px; width: 120px; height: 35px;"
				class="layui-btn layui-btn-normal">新增账号</button>
		</div>
	</div>
	<div align="center">
		<div style="background-color: white; height: 95px; width: 95%;">
			<table class="layui-table">
				<thead>
					<tr>
						<th>
							<div class="layui-unselect header layui-form-checkbox"
								lay-skin="primary">
								<i class="layui-icon">&#xe605;</i>
							</div>
						</th>
						<th>账号</th>
						<th>姓名</th>
						<th>手机</th>
						<th>角色</th>
						<th>状态</th>
						<th>操作</th>
				</thead>
				<tbody>
					<tr>
						<td>
							<div class="layui-unselect layui-form-checkbox"
								lay-skin="primary" data-id='2'>
								<i class="layui-icon">&#xe605;</i>
							</div>
						</td>
						<td></td><!-- 账号 -->
						<td></td><!-- 姓名 -->
						<td></td><!-- 手机 -->
						<td></td><!-- 角色 -->
						<td></td><!-- 状态 -->
						<td class="td-status"><span
							class="layui-btn layui-btn-normal layui-btn-mini">已启用</span></td>
						<td class="td-manage"><a onclick="member_stop(this,'10001')"
							href="javascript:;" title="启用"> <i class="layui-icon">&#xe601;</i>
						</a> <a title="编辑" onclick="x_admin_show('编辑','admin-edit.html')"
							href="javascript:;"> <i class="layui-icon">&#xe642;</i>
						</a> <a title="删除" onclick="member_del(this,'要删除的id')"
							href="javascript:;"> <i class="layui-icon">&#xe640;</i>
						</a></td>
					</tr>
				</tbody>
			</table>
			<div class="page">
				<div>
					<a class="prev" href="">&lt;&lt;</a> <a class="num" href="">1</a> <span
						class="current">2</span> <a class="num" href="">3</a> <a
						class="num" href="">489</a> <a class="next" href="">&gt;&gt;</a>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="../js/xcity.js"></script>
	<script>
		layui.use([ 'form', 'code' ], function() {
			form = layui.form;

			layui.code();

			$('#x-city').xcity('广东', '广州市', '东山区');

		});
	</script>
	<script type="text/javascript">
		$(function() {
			
		})
		
		function zdxlk() {
		$.ajax({
			url : "bossActionqueryBossBranch.action",
			async : false,//异步
			type : "POST",
			/* 	data: {
					参数
				}, */
			success : function(data) {
				var da = eval('(' + data + ')');//转成list集合
				console.log(da.length);
				alert(1);
				//循环总店
				for (var i = 0; i < da.length; i++) {
					/* $("#c1").append('<option value="'+ da.zd[i].bid +'">'+ da.zd[i].bname d+ '</option>'); */
					$("#c1").append('<option value="'+da[i].bid+'">'+da[i].bname+'</option>');
				}
				/* //循环分店
				for (var i = 0; i < da.fd.length; i++) {
					 $("#c1").append('<option value="'+ da.zd[i].bid +'">'+ da.zd[i].bname d+ '</option>'); 
					$("#c2").append('<option value="'+da.fd[i].bid+'">'+da.fd[i].bname+'</option>');
				} */
			}
		});
	}
		function tjcx() {
			var phone= ("#phone").val;
			var name=("#name").val;
		    var zt=	$("#cc option:selected").val();
			$.ajax({
				url : "bossActionqueryBossBranch.action",
				async : false,//异步
				type : "POST",
				data: {
					'name':name,
					'phone':phone,
					'zt':zt
					}, 
				success : function(data) {
					var da = eval('(' + data + ')');//转成list集合
					console.log(da.length);
					alert(1);
					//循环总店
					for (var i = 0; i < da.length; i++) {
						/* $("#c1").append('<option value="'+ da.zd[i].bid +'">'+ da.zd[i].bname d+ '</option>'); */
						$("#c1").append('<option value="'+da[i].bid+'">'+da[i].bname+'</option>');
					}
					/* //循环分店
					for (var i = 0; i < da.fd.length; i++) {
						 $("#c1").append('<option value="'+ da.zd[i].bid +'">'+ da.zd[i].bname d+ '</option>'); 
						$("#c2").append('<option value="'+da.fd[i].bid+'">'+da.fd[i].bname+'</option>');
					} */
				}
			});
		}
		$("#cx").click(function(){
			tjcx();
		})
	</script>
</body>
</html>


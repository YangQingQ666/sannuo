<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎页面-L-admin1.0</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="../css/font.css">
<link rel="stylesheet" href="../css/xadmin.css">
<script src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="../js/xadmin.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
xblock {
	width: 95%;
	margin-left: 18px;
}
</style>
</head>

<body>
	<br />
	<xblock>
	<form>
		<span style="margin-left: 28px; position: relative; top: 20px;">姓名</span>
		<div class="layui-input-inline"
			style="width: 300px; position: relative; top: 20px;">
			<input type="text" name="username" placeholder="请输入姓名"
				autocomplete="off" class="layui-input">
		</div>

		<span style="margin-left: 55px; position: relative; top: 20px;">手机号码</span>
		<div class="layui-input-inline"
			style="width: 300px; position: relative; top: 20px;">
			<input type="text" name="phone" placeholder="请输入手机号码"
				autocomplete="off" class="layui-input">
		</div>
		<br /> <br /> <br /> <br /> <span>所属总店</span>
		<div class="ayui-input-inline layui-form "
			style="width: 300px; margin-left: 60px; margin-top: -31px;">
			<select  lay-filter="search_typez" lay-verify="search_typez"
				id="c1" name="zdn" lay-search>
				<c:if test="${boss.newBranch==null}">
					<option value="a" id="admin">全部</option>
				</c:if>
			</select>
		</div>
		<span style="margin-left: 420px; position: relative; top: -33px;">所属分店</span>
		<div class="ayui-input-inline layui-form "
			style="width: 300px; margin-left: 480px; margin-top: -61px;">
			<select id="c2" name="fdn" lay-filter="search_typef" lay-verify="" lay-search>
				<c:if test="${boss.newBranch.partid==0||boss.newBranch==null}">
					<option value="b">全部</option>
				</c:if>
			</select>
		</div>
		<button  class="layui-btn layui-btn-normal" onclick="cx()" style="width: 100px; margin-left: 840px; margin-top: -38px;" type="button">查询</button>
		<button class="layui-btn layui-btn-normal"
			style="width: 100px; margin-left: 980px; margin-top: -60px;"
			type="reset" onclick="init()">重置</button>
	</form>
	</xblock>
	<!-- <xblock>-->
	<table class="layui-table" style="width: 97%; margin-left: 18px;">
		<thead>
			<tr>
				<th></th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>所属分店</th>
				<th>身份证号码</th>
				<th>电话号码</th>
			</tr>
		</thead>
		<tbody id="tbd">

		</tbody>
	</table>
	<div id="demo6" style="text-align: center;"></div>
	<!--</xblock>-->

	<!--<div class="page">-->

	<!--<a class="prev" href="">&lt;&lt;</a>
          <a class="prev" href="">&lt;</a>
          <a class="num" href="">1</a>
          <span class="current">2</span>
          <a class="num" href="">3</a>
          <a class="num" href="">489</a>
          <a class="next" href="">&gt;</a>
          <a class="next" href="">&gt;&gt;</a>-->

	<!--</div>-->

	<!--</div>-->
	<script src="../lib/layui/layui.js"></script>
	<script src="wzh/dianp.js"></script>

	<script type="text/javascript">
		var count;
		var data;
		$(function() {
			zdxlk();
			fdxlk($("#c1").val());
			fdxlkchange();
			init();
			cx();
			console.log($("#a"));
		})
		
		//分页方法
		function sxfy() {
			layui.use([ 'laypage', 'layer' ], function() {
				var laypage = layui.laypage, layer = layui.layer;

				//只显示上一页、下一页
				laypage.render({
					elem : 'demo6',
					count : 50,
					layout : [ 'prev', 'next' ],
					jump : function(obj, first) {
						if (!first) {
							layer.msg('第 ' + obj.curr + ' 页');
						}
					}
				});

				//将一段数组分页展示

				//调用分页
				laypage.render({
					elem : 'demo6',
					count : data.length,
					limit : 7,
					jump : function(obj) {
						//模拟渲染
						document.getElementById('tbd').innerHTML = function() {
							var arr = [], thisData = data.concat()
									.splice(obj.curr * obj.limit - obj.limit,
											obj.limit);
							layui.each(thisData, function(index, item) {
								arr.push('<tr>' + '<td>'
										+ (parseInt(index) + 1) + '</td>'
										+ '<td>' + item.cname + '</td>'
										+ '<td>' + item.csex + '</td>' + '<td>'
										+ item.cage + '</td>' + '<td>'
										+ item.branch.bname + '</td>' + '<td>'
										+ item.identificationcad + '</td>'
										+ '<td>' + item.phone + '</td>'
										+ '</tr>');
							});

							return arr.join('');
						}();
					}
				});

			});
		}
		//查询并赋值给分页
		function cx() {
			var name = $("input[name='username']").val();
			var phone = $("input[name='phone']").val();
			var zdn = $("#c1").val();
			var fdn = $("#c2").val();
			console.log(zdn);
			console.log(fdn);
			$.ajax({
				url : "customerActionfindByWhere.action",
				async : false,
				type : "POST",
				data : {
					'name' : name,
					'phone' : phone,
					'zdn' : zdn,
					'fdn' : fdn
				},
				success : function(succ) {
					var a = eval(succ);
					console.log(a);
					count = a.length
					data = a;
					sxfy();
				}
			});
		}

		//分页首次刷新赋值
		function fenye() {
			var zdid = $("#c1 option:selected").val();
			var fdid = $("#c2 option:selected").val();
			$.ajax({
				url : "customerActiongetDataAndCountload.action",
				async : false,
				type : "POST",
				data : {
					'zdid' : zdid
				},
				success : function(succ) {
					var a = eval('(' + succ + ')');
					console.log(a);
					count = a.length
					data = a;
				}
			});
		}
		//初始化方法
		function init() {
			fenye();
			sxfy();
		}
	</script>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<meta charset="UTF-8">
<title>欢迎页面-L-admin1.0</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="../css/font.css">
<link rel="stylesheet" href="../css/xadmin.css">
<script src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="../js/xadmin.js"></script>
<style type="text/css">
#table td {
	width: 5%;
}
</style>
</head>

<body>
	<xblock style="margin-left: 18px;margin-top: 18px;width: 96%;">
	<form>
		<table style="margin-left: 30px;">
			<tr style="margin-top: 20px; padding: 0px; display: block;">
				<td>所属总店</td>
				<td>
					<div class="ayui-input-inline layui-form "
						style="width: 200px; margin-left: 20px;">
						<select lay-filter="search_typez" lay-verify="search_typez"
							id="c1" name="zdn" lay-search>
							<c:if test="${boss.newBranch==null}">
								<option value="a" id="admin">全部</option>
							</c:if>
						</select>
					</div>
				</td>
				<td><span style="margin-left: 50px;">所属分店</span></td>
				<td>
					<div class="ayui-input-inline layui-form "
						style="width: 200px; margin-left: 20px;">
						<select id="c2" name="fdn" lay-verify="required" lay-search>
							<c:if test="${boss.newBranch.partid==0||boss.newBranch==null}">
								<option value="b">全部</option>
							</c:if>
						</select>
					</div>
				</td>
				<td><span style="margin-left: 50px;">筛选周期</span></td>
				<td>
					<div class="layui-row">
						<form class="layui-form layui-col-md12 layui-input x-so">
							<input id="start" class="layui-input"
								style="width: 100px; margin-bottom: -38px; margin-left: 20px;"
								placeholder="开始日" name="start" id="start"> <input
								id="end" class="layui-input "
								style="width: 100px; float: left; margin-bottom: 0px; margin-left: 105%"
								placeholder="截止日" name="end" id="end">
						</form>
					</div>
				</td>
			</tr>
			<tr style="margin-top: 20px; padding: 0px; display: block;">
				<td rowspan="6" style="float: right;">
					<div class="layui-btn-container"
						style="position: relative; right: 0px;">
						<button class="layui-btn layui-btn-xs" type="button"
							onclick="anomaly_init()">查询</button>
						<button class="layui-btn layui-btn-xs" type="button">导出报表</button>
					</div>
				</td>
			</tr>
			<!--<tr style="margin-top:0px;padding:0px;display:block;">
						<td rowspan="6">
							<div style="width: 1400px;height: 15px;background-color: white;position: relative;right: 50px;">

							</div>
						</td>
					</tr>-->
		</table>
	</form>
	</xblock>
	<table id="table" height="20" border="1" width="100%"
		bordercolor="#E9E9E9"
		style="margin-left: 0%; position: relative; top: 13px;">
		<tr bgcolor="#F2F2F2" align="center" id="compent">
			<td></td>
			<td>姓名</td>
			<td>手机号</td>
			<td>性别</td>
			<td>年龄</td>
			<td>胆固醇</td>
			<td>收缩压</td>
			<td>舒张压</td>
			<td>血糖</td>
			<td>甘油三脂</td>
			<td>血红蛋白</td>
			<td>血尿酸</td>
			<td>血酮</td>
			<td>检测时间</td>
		</tr>
		<tbody align="center" id="tbd"></tbody>
		<tr align="center">
			<!-- <td>&nbsp;</br>&nbsp;&nbsp;&nbsp;1&nbsp;&nbsp;&nbsp;</br>&nbsp;
			</td>
			<td>姓名</td>
			<td>手机号</td>
			<td>性别</td>
			<td>年龄</td>
			<td>体重</td>
			<td>身高</td>
			<td>饮食状态</td>
			<td>BMI</td>
			<td>血糖</td>
			<td>总胆固醇</td>
			<td>甘油三脂</td>
			<td>12</td>
			<td>3</td>
			<td>4</td>
			<td>血尿酸</td>
			<td>血酮</td>
			<td>2</td>
			<td>血压</td>
			<td>检测次数</td>
			<td>检测时间</td>
		</tr> -->
	</table>
	<br />
	<br />
	<br />

	<div id="demo6" style="text-align: center;"></div>
</body>

<script src="../lib/layui/layui.js"></script>
<script src="wzh/dianp.js"></script>
<script type="text/javascript">
	zdxlk();
	fdxlk($("#c1").val());
	fdxlkchange();
</script>
<script type="text/javascript">
	//查询公共可看的体检数据类型
	//查询信息
	$(function(){
		anomaly_init();
		
	})
	function timestampToTime(timestamp) {
		   var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
		   Y = date.getFullYear() + '-';
		   M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
		   D = date.getDate() + ' ';
		   h = date.getHours() + ':';
		   m = date.getMinutes() + ':';
		   s = date.getSeconds();
		   return Y+M+D;
	}
	function anomaly_init() {
		var zd = $("#c1 option:selected").val();
		var fd = $("#c2 option:selected").val();
		var start = $("#start").val();
		var end = $("#end").val();
		$.ajax({
			url : 'projectOrderActionfindPublicinspectionRecords.action',
			type : 'post',
			async : false,
			data : {
				"zd" : zd,
				"fd" : fd,
				"start" : start,
				"end" : end
			},
			success : function(succ) {
				var da = eval('(' + succ + ')');
				console.log(da);
				count=da.length;
				data=da;
				sxfy();
			}
		});
	}
	var count;
	var data;
	function anomaly_init() {
		var zd = $("#c1 option:selected").val();
		var fd = $("#c2 option:selected").val();
		var start = $("#start").val();
		var end = $("#end").val();
		$.ajax({
			url : 'projectOrderActionfindPublicinspectionRecords.action',
			type : 'post',
			async : false,
			data : {
				"zd" : zd,
				"fd" : fd,
				"start" : start,
				"end" : end
			},
			success : function(succ) {
				var da = eval('(' + succ + ')');
				console.log(da);
				count=da.length;
				data=da;
				sxfy();
			}
		});
	}


	layui.use('laydate', function() {
		var laydate = layui.laydate;

		//执行一个laydate实例
		laydate.render({
			elem : '#start' //指定元素
		});

		//执行一个laydate实例
		laydate.render({
			elem : '#end' //指定元素
		});
	});
	function sxfy() {
		layui.use([ 'laypage', 'layer' ], function() {
			var laypage = layui.laypage, layer = layui.layer;

			//只显示上一页、下一页
			laypage.render({
				elem : 'demo6',
				count : count,
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
				limit : 6,
				jump : function(obj) {
					//模拟渲染
					document.getElementById('tbd').innerHTML = function() {
						var arr = [], thisData = data.concat()
								.splice(obj.curr * obj.limit - obj.limit,
										obj.limit);
						layui.each(thisData, function(index, item) {
							arr.push('<tr><td>'+parseInt(index+1)+'</td>'+
									'<td>'+item[15]+'</td>'+
									'<td>'+item[18]+'</td>'+
									'<td>'+item[16]+'</td>'+
									'<td>'+item[17]+'</td>'+
									'<td>'+item[2]+'</td>'+
									'<td>'+item[3]+'</td>'+
									'<td>'+item[4]+'</td>'+
									'<td>'+item[5]+'</td>'+
									'<td>'+item[6]+'</td>'+
									'<td>'+item[7]+'</td>'+
									'<td>'+item[8]+'</td>'+
									'<td>'+item[9]+'</td>'+
									'<td style="font-size: 1px">'+timestampToTime(item[20])+'</td></tr>'
									)
						});

						return arr.join('');
					}();
				}
			});

		});
	}
</script>
</html>

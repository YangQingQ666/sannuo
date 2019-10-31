<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="../lib/layui/css/layui.css" />
<script src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/xadmin.js"></script>
<script src="../lib/layui/layui.js"></script>

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
	<form style="height: 35px;">
		<div style="margin-top: 18px;">
			<span style="margin-left: 40px;">项目名称</span>
			<div class="ayui-input-inline layui-form "
				style="width: 250px; margin-left: 160px; margin-top: -32px;">
				<select name="contrller" id="zb">
					<option value="0">请选择项目</option>
				</select>
			</div>
		</div>
		<button id="chaxun" class="layui-btn layui-btn-normal layui-btn-radius"
			style="width: 100px; margin-left: 780px; margin-top: -38px;"
			type="button">查询</button>
	</form>
	</xblock>
	<!-- <xblock>-->
	<table class="layui-table" style="width: 97%; margin-left: 18px;">
		<thead>
			<tr>
				<th style="text-align: center;"></th>
				<th style="text-align: center;">项目名称</th>
				<th style="text-align: center;">单位</th>
				<th style="text-align: center;">参考值</th>
				<th style="text-align: center;">检验方法</th>
				<th style="text-align: center;">检测区间</th>
				<th style="text-align: center;">结果解读</th>
				<th style="text-align: center;">操作</th>
			</tr>
		</thead>
		<tbody id="tbody" style="text-align: center; align-content: center;">
			
		</tbody>
	</table>
	<div id="demo6" style="text-align: center;"></div>

	<script src="../lib/layui/layui.js"></script>
	<script type="text/javascript">
	var fyy;
	var fyycount;
		$(function() {
			all();
			$.ajax({
				url : 'projectActionanomalyIndex.action',
				type : 'post',
				async : false,
				success : function(succ) {
					var da = eval('(' + succ + ')');
					console.log(da);
					for (var i = 0; i < da.length; i++) {
						$("#zb").append(
								'<option value="'+da[i][0]+'">' + da[i][1]
										+ '</option>');
					}
				}
			});
			
		})
		//初始页面
		function all(){
			$.ajax({
				url : 'projectActionfindProjectByProject.action',
				type : 'post',
				async : false,
				success : function(data) {
					var all = eval(data);
					fyy=all;
					fyycount=all.length;
					sxfy();
				}
			});
		}
		//查询
		function chaxun(data){
			
			$.ajax({
				url : 'projectActionfindProjectBydname.action',
				type : 'post',
				data:"dname="+data,
				async : false,
				success : function(data) {
					var all = eval(data);
					fyy=all;
					fyycount=all.length;
					sxfy();
				}
			});
		}
		$("#chaxun").click(function(){
			var dname=$("#zb option:selected").text();
			var zs=$("#zb option:selected").val();
			if(zs!=0){
				chaxun(dname);
			}
			
		})
		function ckkk(da){
			var url = "tokenfilter/project_add.jsp?id="+da;
			 var index = layui.layer.open({
			        title : "编辑用户",
			        type : 2,
			        content : url,//弹出层页面
			        area: ['800px', '500px'],
			        shadeClose: true,
			        maxmin: true,
			        fix: false, //不固定
			        end: function () {
			            location.reload();
			          }
			    })
		}
		//分页方法
		function sxfy() {
			layui.use([ 'laypage', 'layer' ], function() {
				var laypage = layui.laypage, layer = layui.layer;

				//只显示上一页、下一页
				laypage.render({
					elem : 'demo6',
					count : fyycount,
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
					count : fyycount,
					limit : 6,
					jump : function(obj) {
						//模拟渲染
						document.getElementById('tbody').innerHTML = function() {
							var arr = [], thisData = fyy.concat()
									.splice(obj.curr * obj.limit - obj.limit,
											obj.limit);
							layui.each(thisData, function(index, item) {
								arr.push('<tr>' + '<td>'
										+ (parseInt(index) + 1) +'</td>'
										+ '<td>' + item.dname + '</td>'
										+ '<td>' + item.unit + '</td>' + '<td>'
										+ item.reference + '</td>' + '<td>'
										+ item.method + '</td>' + '<td>'
										+ item.intervarl + '</td>'
										+ '<td>' + item.unscramble + '</td>' 
										+'<td style="aligin: center;">'
										+"<a title='编辑' "
										+'onclick='
										+'ckkk('+item.did+') href="javascript:;">'
										+'<i style="color: limegreen" class="layui-icon">&#xe642;</i></a></td>'
										+ '</tr>');
							});
							
							return arr.join('');
						}();
					}
				});

			});
		}
	</script>
	<script type="text/javascript">
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

		/*用户-停用*/
		function member_stop(obj, id) {
			layer.confirm('确认要停用吗？', function(index) {

				if ($(obj).attr('title') == '启用') {

					//发异步把用户状态进行更改
					$(obj).attr('title', '停用')
					$(obj).find('i').html('&#xe62f;');

					$(obj).parents("tr").find(".td-status").find('span')
							.addClass('layui-btn-disabled').html('已停用');
					layer.msg('已停用!', {
						icon : 5,
						time : 1000
					});

				} else {
					$(obj).attr('title', '启用')
					$(obj).find('i').html('&#xe601;');

					$(obj).parents("tr").find(".td-status").find('span')
							.removeClass('layui-btn-disabled').html('已启用');
					layer.msg('已启用!', {
						icon : 5,
						time : 1000
					});
				}

			});
		}
		
	</script>
</body>

</html>
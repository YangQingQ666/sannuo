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
<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon" />
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

</head>
<style>
xblock {
	width: 95%;
	margin-left: 18px;
}
</style>
<body>
	<br />
	<xblock>
	<form>
		<table style="margin-left: 30px;">
			<tr style="margin-top: 20px; padding: 0px; display: block;">
				<td>异常指标</td>
				<td>
					<div class="ayui-input-inline layui-form "
						style="width: 200px; margin-left: 20px;">
						<select id="zb" name="contrller">
							<option value="c">全部</option>

						</select>
					</div>
				</td>
				<td><span style="margin-left: 50px;">所属总店</span></td>
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
						<select id="c2" name="fdn" lay-filter="search_typef" lay-verify=""
							lay-search>
							<c:if test="${boss.newBranch.partid==0||boss.newBranch==null}">
								<option value="b">全部</option>
							</c:if>
						</select>
					</div>
				</td>
			</tr>
			<tr style="margin-top: 20px; padding: 0px; display: block;">
				<td><span style="margin-left: 13px;">年龄段</span></td>
				<td>
					<div class="ayui-input-inline layui-form "
						style="width: 200px; margin-left: 20px;">
						<select id="c3" name="contrller">
							<!-- //婴幼儿(0-6)  儿童(7-12)   少年(12-15)  青年(15-30)  中年(30-50)  老年(≥50) -->
							<!-- //["婴幼儿", "儿童", "少年", "青年", "中年", "老年"]; -->
							<option value="d">全部</option>
							<option value="1">婴幼儿(0-6)</option>
							<option value="2">儿童(7-12)</option>
							<option value="3">少年(12-15)</option>
							<option value="4">青年(15-30)</option>
							<option value="5">中年(30-50)</option>
							<option value="6">老年(≥50)</option>
						</select>
					</div>
				</td>
				<!-- <td>
					<div class="ayui-input-inline layui-form "
						style="width: 200px; margin-left: 20px;">
						<select id="sex" name="contrller">
							<option>全部</option>
							<option>男</option>
							<option>女</option>
						</select>
					</div>
				</td> -->
				<td><span style="margin-left: 50px;">筛选日期</span></td>
				<td><div class="layui-row"><form class="layui-form layui-col-md12 layui-input x-so"><input id="start" class="layui-input"
					style="width: 100px; margin-bottom: -38px; margin-left: 20px;"
					placeholder="开始日" name="start" id="start"> <input id="end"
					class="layui-input "
					style="width: 100px; float: left; margin-bottom: 0px; margin-left: 105%"
					placeholder="截止日" name="end" id="end">  </form></div></td>
			</tr>
			<tr style="margin-top: 20px; padding: 0px; display: block;">
				<td rowspan="6" style="float: right;">
					<div class="layui-btn-container">
						<button class="layui-btn" type="button" id="chaxun">查询</button>
						<button class="layui-btn" type="reset">重置</button>
						<button class="layui-btn">导出报表</button>
					</div>

				</td>
			</tr>
		</table>

	</form>
	</xblock>
	<!-- <xblock>-->
	<span
		style="margin-left: 70px; position: relative; top: 20px; font-size: 20px; font-weight: bold;">血糖异常数据</span>
	<div style="float: right; margin-right: 50px;">
		<div
			style="height: 20px; width: 40px; background-color: #003366; margin-right: 100%;">男</div>
		<div
			style="height: 20px; width: 40px; background-color: #006699; margin-right: 100%;">女</div>
		<div
			style="height: 20px; width: 40px; background-color: #4cabce; margin-right: 100%;">合计</div>
	</div>
	<div id="main" style="width: 100%; height: 400px;"></div>
	<div id="app" style="width: 100%; height: 400px;"></div>
	<script type="text/javascript" src="../js/echarts.js"></script>
	<!-- var fd=$("#c2 option:selected").val();
			var zb=$("#zb option:selected").val();
			var age=$("#c3 option:selected").text();
			var start=$("#start").val();
			var end=$("#end").val();
	$("#chaxun").click(function(){
				$.ajax({
					url : 'projectOrderActionfindByWhere.action',
					type : 'post',
					dataType : 'json',
					async : false,
					data:{
						"fd":fd,"zb":zb,"age":age,"start":start,"end":end
					},
					success : function(data) {
						var da=eval(data);
						console.log(da);
						boy=[da.OnTheHighSide.boy,da.normal.boy,da.OnTheHighSide.boy,da.veryHigh.boy];
						girl=[da.OnTheHighSide.girl,da.normal.girl,da.OnTheHighSide.girl,da.veryHigh.girl]
					}
				});
				
			}); -->
	<script src="wzh/dianp.js"></script>
	<script>
		zdxlk();
		fdxlk($("#c1").val());
		fdxlkchange();
		anomaly_index();
		function anomaly_index() {
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
		}
		var myChart = echarts.init(document.getElementById('main'));
		var posList = [
			'left', 'right', 'top', 'bottom',
			'inside',
			'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
			'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
		];
		app.configParameters = {
				rotate: {
					min: -90,
					max: 90
				},
				align: {
					options: {
						left: 'left',
						center: 'center',
						right: 'right'
					}
				},
				verticalAlign: {
					options: {
						top: 'top',
						middle: 'middle',
						bottom: 'bottom'
					}
				},
				position: {
					options: echarts.util.reduce(posList, function(map, pos) {
						map[pos] = pos;
						return map;
					}, {})
				},
				distance: {
					min: 0,
					max: 100
				}
			};

		var fd=null;
		var age=null;
		var zb=null;
		var start=null;
		var end=null;
		var sum=null;
		var glucose = ["低", "正常", "偏高", "高"];
		$(function(){
			$("#chaxun").click(function(){
				
				 fd=$("#c2 option:selected").val();
				 zb=$("#zb option:selected").val();
				 age=$("#c3 option:selected").text();
				 start=$("#start").val();
				 end=$("#end").val();
		$("#chaxun").click(function(){
					$.ajax({
						url : 'projectOrderActionfindByWhere.action',
						type : 'post',
						dataType : 'json',
						async : false,
						data:{
							"fd":fd,"zb":zb,"age":age,"start":start,"end":end
						},
						success : function(data) {
							var da=eval(data);
							console.log(da);
							boy=[da.OnTheHighSide.boy,da.normal.boy,da.OnTheHighSide.boy,da.veryHigh.boy];
							girl=[da.OnTheHighSide.girl,da.normal.girl,da.OnTheHighSide.girl,da.veryHigh.girl];
							sum=[boy[0] + girl[0], boy[1] + girl[1], boy[2] + girl[2], boy[3] + girl[3], boy[4] + girl[4]];//合计人数
							
						}
					});
					// 基于准备好的dom，初始化echarts实例
					

					
					app.config = {
						rotate: 90,
						align: 'left',
						verticalAlign: 'middle',
						position: 'insideBottom',
						distance: 15,
						onClick: function() {
							var labelOption = {
								normal: {
									rotate: app.config.rotate,
									align: app.config.align,
									verticalAlign: app.config.verticalAlign,
									position: app.config.position,
									distance: app.config.distance
								}
							};
							myChart.setOption({
								series: [{
									label: labelOption
								}, {
									label: labelOption
								}, {
									label: labelOption
								}, {
									label: labelOption
								}]
							});
						}
					};

					var labelOption = {
						normal: {
							show: true,
							position: app.config.position,
							distance: app.config.distance,
							align: app.config.align,
							verticalAlign: app.config.verticalAlign,
							rotate: app.config.rotate,
							formatter: '{c}  {name|{a}}',
							fontSize: 16,
							rich: {
								name: {
									textBorderColor: '#fff'
								}
							}
						}
					};

					var option = {
						color: ['#003366', '#006699', '#4cabce', '#e5323e'],
						tooltip: {
							trigger: 'axis',
							axisPointer: {
								type: 'shadow'
							}
						},
						legend: {
							data: ['Forest', 'Steppe', 'Desert', 'Wetland']
						},
						toolbox: {
							show: true,
							orient: 'vertical',
							left: 'right',
							top: 'center',
							feature: {
								mark: {
									show: true
								},
								dataView: {
									show: true,
									readOnly: false
								},
								magicType: {
									show: true,
									type: ['line', 'bar', 'stack', 'tiled']
								},
								restore: {
									show: true
								},
								saveAsImage: {
									show: true
								}
							}
						},
						calculable: true,
						xAxis: [{
							type: 'category',
							axisTick: {
								show: false
							},
							data: glucose
						}],
						yAxis: [{
							type: 'value'
						}],
						series: [{
								name: '男',
								type: 'bar',
								barGap: 0,
								label: labelOption,
								data: boy
							},
							{
								name: '女',
								type: 'bar',
								label: labelOption,
								data: girl
							},
							{
								name: '合计',
								type: 'bar',
								label: labelOption,
								data: sum
							},
						]
					};
					// 使用刚指定的配置项和数据显示图表。
					myChart.setOption(option);
				});
		})
		
		
		$(function() {
			 fd=$("#c2 option:selected").val();
			 zb=$("#zb option:selected").val();
			 age=$("#c3 option:selected").text();
			 start=$("#start").val();
			 end=$("#end").val();
			var boy = [0, 0, 0, 0, 0];//男性人数
			var girl = [0, 0, 0, 0, 0];//女性人数
			var sum = [boy[0] + girl[0], boy[1] + girl[1], boy[2] + girl[2], boy[3] + girl[3], boy[4] + girl[4]];//合计人数
			$.ajax({
				url : 'projectOrderActionfindByWhere.action',
				type : 'post',
				dataType : 'json',
				async : false,
				data:{
					"fd":fd,"zb":zb,"age":age,"start":start,"end":end
				},
				success : function(data) {
					var da=eval(data);
					console.log(da);
					boy=[da.OnTheHighSide.boy,da.normal.boy,da.OnTheHighSide.boy,da.veryHigh.boy];
					girl=[da.OnTheHighSide.gily,da.normal.gily,da.OnTheHighSide.gily,da.veryHigh.gily];
					sum=[boy[0] + girl[0], boy[1] + girl[1], boy[2] + girl[2], boy[3] + girl[3], boy[4] + girl[4]];
				}
			});
			// 基于准备好的dom，初始化echarts实例
			var myChart = echarts.init(document.getElementById('main'));
			var posList = [
				'left', 'right', 'top', 'bottom',
				'inside',
				'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
				'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
			];

			app.configParameters = {
				rotate: {
					min: -90,
					max: 90
				},
				align: {
					options: {
						left: 'left',
						center: 'center',
						right: 'right'
					}
				},
				verticalAlign: {
					options: {
						top: 'top',
						middle: 'middle',
						bottom: 'bottom'
					}
				},
				position: {
					options: echarts.util.reduce(posList, function(map, pos) {
						map[pos] = pos;
						return map;
					}, {})
				},
				distance: {
					min: 0,
					max: 100
				}
			};

			app.config = {
				rotate: 90,
				align: 'left',
				verticalAlign: 'middle',
				position: 'insideBottom',
				distance: 15,
				onClick: function() {
					var labelOption = {
						normal: {
							rotate: app.config.rotate,
							align: app.config.align,
							verticalAlign: app.config.verticalAlign,
							position: app.config.position,
							distance: app.config.distance
						}
					};
					myChart.setOption({
						series: [{
							label: labelOption
						}, {
							label: labelOption
						}, {
							label: labelOption
						}, {
							label: labelOption
						}]
					});
				}
			};

			var labelOption = {
				normal: {
					show: true,
					position: app.config.position,
					distance: app.config.distance,
					align: app.config.align,
					verticalAlign: app.config.verticalAlign,
					rotate: app.config.rotate,
					formatter: '{c}  {name|{a}}',
					fontSize: 16,
					rich: {
						name: {
							textBorderColor: '#fff'
						}
					}
				}
			};

			var option = {
				color: ['#003366', '#006699', '#4cabce', '#e5323e'],
				tooltip: {
					trigger: 'axis',
					axisPointer: {
						type: 'shadow'
					}
				},
				legend: {
					data: ['Forest', 'Steppe', 'Desert', 'Wetland']
				},
				toolbox: {
					show: true,
					orient: 'vertical',
					left: 'right',
					top: 'center',
					feature: {
						mark: {
							show: true
						},
						dataView: {
							show: true,
							readOnly: false
						},
						magicType: {
							show: true,
							type: ['line', 'bar', 'stack', 'tiled']
						},
						restore: {
							show: true
						},
						saveAsImage: {
							show: true
						}
					}
				},
				calculable: true,
				xAxis: [{
					type: 'category',
					axisTick: {
						show: false
					},
					data: glucose
				}],
				yAxis: [{
					type: 'value'
				}],
				series: [{
						name: '男',
						type: 'bar',
						barGap: 0,
						label: labelOption,
						data: boy
					},
					{
						name: '女',
						type: 'bar',
						label: labelOption,
						data: girl
					},
					{
						name: '合计',
						type: 'bar',
						label: labelOption,
						data: sum
					},
				]
			};
			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
		})
		})
	</script>

</body>

</html>
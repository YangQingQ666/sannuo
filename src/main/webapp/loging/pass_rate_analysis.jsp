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
<style>
xblock {
	width: 95%;
	margin-left: 18px;
	margin-top: 2px;
}
</style>
</head>

<body>
	<xblock>

	<table border="0" style="margin-left: 30px;">
		<form>
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
					<div class="ayui-input-inline layui-form "
						style="width: 200px; margin-left: 20px;">
						<select name="contrller">
							<option>全部</option>
							<option>近一年</option>
							<option>近半年</option>
						</select>
					</div>
				</td>
			</tr>
			<tr style="margin-top: 10px; padding: 0px; display: block;">
				<td rowspan="6" style="float: right;">
					<div class="layui-btn-container"
						style="position: relative; right: 500px;">
						<button class="layui-btn layui-btn-xs" type="submit">查询</button>
						<button class="layui-btn layui-btn-xs" type="button">导出报表</button>
					</div>
				</td>
			</tr>
			<tr style="margin-top: 30px; padding: 0px; display: block;">
				<td rowspan="6">
					<div
						style="width: 1400px; height: 20px; background-color: white; position: relative; right: 50px;">

					</div>
				</td>
			</tr>
			<tr style="margin-top: 10px; padding: 0px; display: block;">
				<td rowspan="6">
					<div style="width: 1400px;">
						<p align="center" style="margin-right: 400px; font-size: 22px;">检测项合格率报表</p>
						<!--<span style="font-size: 20px;margin-left: 430px;"></span>-->
					</div>
				</td>
			</tr>
			<tr>
				<td rowspan="6">
					<table width="76%" border="0" cellpadding="30"
						style="border-collapse: separate; border-spacing: 0px 30px;">
						<tr>
							<td>
								<div>
									BIM&nbsp;0.00% <font style="float: right; margin-right: 36px;">0/0人</font>
								</div>
							</td>
							<td>
								<div>
									血压&nbsp;0.00% <font style="float: right; margin-right: 36px;">0/0人</font>
								</div>
							</td>
							<td>
								<div>
									总胆固醇&nbsp;0.00% <font style="float: right; margin-right: 36px;">0/0人</font>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="layui-progress" style="width: 90%;">
									<div class="layui-progress-bar layui-bg-blue" lay-percent="50%"></div>
								</div>
							</td>
							<!--<td>0/0人</td>-->
							<td>
								<div class="layui-progress" style="width: 90%;">
									<div class="layui-progress-bar layui-bg-blue" lay-percent="50%"></div>
								</div>
							</td>
							<td>
								<div class="layui-progress" style="width: 90%;">
									<div class="layui-progress-bar layui-bg-blue" lay-percent="50%"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div>
									血糖&nbsp;0.00% <font style="float: right; margin-right: 36px;">0/0人</font>
								</div>
							</td>
							<td>
								<div>
									糖化血红蛋白&nbsp;0.00% <font
										style="float: right; margin-right: 36px;">0/0人</font>
								</div>
							</td>
							<td>
								<div>
									高密度脂蛋白胆固醇&nbsp;0.00% <font
										style="float: right; margin-right: 36px;">0/0人</font>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="layui-progress" style="width: 90%;">
									<div class="layui-progress-bar layui-bg-blue" lay-percent="50%"></div>
								</div>
							</td>
							<!--<td>0/0人</td>-->
							<td>
								<div class="layui-progress" style="width: 90%;">
									<div class="layui-progress-bar layui-bg-blue" lay-percent="50%"></div>
								</div>
							</td>
							<td>
								<div class="layui-progress" style="width: 90%;">
									<div class="layui-progress-bar layui-bg-blue" lay-percent="50%"></div>
								</div>
							</td>
							</form>
						</tr>
						<tr>
							<td>
								<div>
									血酮&nbsp;0.00% <font style="float: right; margin-right: 36px;">0/0人</font>
								</div>
							</td>
							<td>
								<div>
									低密度脂蛋白胆固醇&nbsp;0.00% <font
										style="float: right; margin-right: 36px;">0/0人</font>
								</div>
							</td>
							<td>
								<div>
									总胆高密比值&nbsp;0.00% <font
										style="float: right; margin-right: 36px;">0/0人</font>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="layui-progress" style="width: 90%;">
									<div class="layui-progress-bar layui-bg-blue" lay-percent="50%"></div>
								</div>
							</td>
							<!--<td>0/0人</td>-->
							<td>
								<div class="layui-progress" style="width: 90%;">
									<div class="layui-progress-bar layui-bg-blue" lay-percent="50%"></div>
								</div>
							</td>
							<td>
								<div class="layui-progress" style="width: 90%;">
									<div class="layui-progress-bar layui-bg-blue" lay-percent="50%"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div>
									甘油三脂&nbsp;0.00% <font style="float: right; margin-right: 36px;">0/0人</font>
								</div>
							</td>
							<td>
								<div>
									血尿酸&nbsp;0.00% <font style="float: right; margin-right: 36px;">0/0人</font>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="layui-progress" style="width: 90%;">
									<div class="layui-progress-bar layui-bg-blue" lay-percent="50%"></div>
								</div>
							</td>
							<td>
								<div class="layui-progress" style="width: 90%;">
									<div class="layui-progress-bar layui-bg-blue" lay-percent="50%"></div>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
	</table>
	</xblock>
	<br />
	<br />
	<br />

	<div>
		<div align="center">
			<h1>合格率图谱</h1>
		</div>
		<div class="mui-input-group" id="chart_l">
			<div class="mui-content-padded">
				<p class="chart-a" style="float: left; margin-top: 0.3rem;">
					全县统计 <span style="font-size: 0.22rem; color: #ACACB4">(近一年)</span>
				</p>
				<p class="chart-a"
					style="float: right; margin-right: 0.2rem; margin-top: 0.3rem;">
					<a
						style="display: inline-block; width: 25px; height: 4px; border-radius: 10px; background-color: #18abf1; margin-right: 5px;"></a><span>合格</span>
					<a
						style="display: inline-block; width: 25px; height: 4px; border-radius: 10px; background-color: #FF8C00; margin-right: 5px"></a><span>合格率</span>
					<a
						style="display: inline-block; width: 25px; height: 4px; border-radius: 10px; background-color: #0078AD; margin-right: 5px"></a><span>不合格</span>
				</p>
				<div id="chart" style="width: 95%; height: 200px;"></div>
			</div>
		</div>
	</div>
</body>
<!--统计图-->
<script src="../js/echarts-all.js"></script>
<script type="text/javascript" src="wzh/dianp.js"></script>
<script type="text/javascript">
	zdxlk();
	fdxlk($("#c1").val());
	fdxlkchange();
</script>
<script>
	months = [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月',
			'十一月', '十二月' ];
	pass = [ 10, 35, 50, 80, 60, 90, 100, 155, 195, 190, 145, 140 ];
	odds = [ 40, 81, 60, 50, 20, 10, 10, 99, 20, 10, 55, 88 ];
	nopass = [ 190, 190, 1, 110, 190, 500, 190, 190, 30, 190, 50, 190 ];
	Max_odds = Math.max.apply(null, odds);
	Max_pass = Math.max.apply(null, pass);
	Max_odds = Math.ceil(Max_odds / 100) * 100;
	Max_pass = Math.max.apply(null, pass);
	Max_nopass = Math.max.apply(null, nopass);
	Max_nopass = Math.max.apply(null, nopass);
	chart(odds, pass, nopass, months, Max_odds, Max_pass, Max_nopass);

	function chart(odds, pass, nopass, months, Max_odds, Max_pass, Max_nopass) {
		var getOption = function(chartType1, chartType2, chartType3) { //分别对应下面的bar(条形),line(折线)
			var chartOption = {
				tooltip : { //鼠标悬浮交互时的信息提示
					trigger : 'axis',
					axisPointer : {
						type : 'cross',
						crossStyle : {
							color : '#999'
						}
					}
				},
				grid : { //直角坐标系内绘图网格
					x : 45,
					x2 : 40,
					y : 25,
					y2 : 25,
					/*z: 30,
					z2: 35*/
					borderWidth : 0
				},
				toolbox : {
					show : false,
				},
				calculable : true, //是否启用拖拽重计算特性
				xAxis : [ { //横坐标
					type : 'category',
					data : months,
					axisLine : {
						show : false
					}, //坐标轴线，默认显示且带样式
					axisTick : {
						show : false
					}, //坐标轴小标记，数值轴和时间轴默认不显示，类目轴默认显示
					splitLine : {
						show : false
					},
				} ],
				yAxis : [ { //纵坐标
					name : "合格率",
					type : 'value',
					nameTextStyle : {
						color : "#ccc"
					},
					min : 0,
					max : Max_odds,
					axisLine : {
						lineStyle : {
							width : 0
						}
					},
					axisLabel : {
						formatter : '{value}'
					}, //坐标轴文本标签选项
				}, {
					name : "人数",
					type : 'value',
					nameTextStyle : {
						color : "#ccc"
					},
					min : 0,
					max : Max_pass > Max_nopass ? Max_pass : Max_nopass,
					axisLine : {
						lineStyle : {
							width : 0
						}
					}, //坐标轴线的样式
					axisLabel : {
						formatter : '{value}'
					},
				} ],
				series : [ {
					name : "合格", //人数采用圆角矩形			
					type : chartType1,
					yAxisIndex : 1,
					barWidth : 8,
					data : pass,
					itemStyle : {
						normal : {
							color : '#18abf1',
							//柱形图圆角，初始化效果
							barBorderRadius : 20,
							label : {
								show : false, //是否展示数据
							},
						}
					}
				}, {
					name : '合格率', //金额采用	折线		
					type : chartType2,
					symbol : 'none', //去掉折线小圆点
					smooth : true,
					data : odds,
					itemStyle : {
						normal : {
							lineStyle : {
								color : '#FF8C00'
							}
						}
					}
				}, {
					name : "不合格", //人数采用圆角矩形			
					type : chartType3,
					yAxisIndex : 1,
					barWidth : 8,
					data : nopass,
					itemStyle : {
						normal : {
							color : '#0078AD',
							//柱形图圆角，初始化效果
							barBorderRadius : 20,
							label : {
								show : false, //是否展示数据
							},
						}
					}
				} ]
			};
			return chartOption;
		};
		var byId = function(id) {
			return document.getElementById(id);
		};
		var barChart = echarts.init(byId('chart')); //将其显示到页面上
		barChart.setOption(getOption('bar', 'line', 'bar'));
	}
</script>
<!--进度条-->
<script>
	layui
			.config({
				base : '../../../layuiadmin/' //静态资源所在路径
			})
			.extend({
				index : 'lib/index' //主入口模块
			})
			.use(
					[ 'index' ],
					function() {
						var $ = layui.$, admin = layui.admin, element = layui.element, router = layui
								.router();

						element.render('progress');

						//触发事件
						var active = {
							setPercent : function() {
								//设置50%进度
								element.progress('component-progress-demo',
										'10%')
							},
							loading : function(othis) {
								var DISABLED = 'layui-btn-disabled';
								if (othis.hasClass(DISABLED))
									return;

								//模拟loading
								var n = 0, timer = setInterval(function() {
									n = n + Math.random() * 10 | 0;
									if (n > 100) {
										n = 100;
										clearInterval(timer);
										othis.removeClass(DISABLED);
									}
									element.progress('component-progress-demo',
											n + '%');
								}, 300 + Math.random() * 1000);

								othis.addClass(DISABLED);
							}
						};

						$('#LAY-component-progress .site-demo-active').on(
								'click',
								function() {
									var othis = $(this), type = $(this).data(
											'type');
									active[type] ? active[type].call(this,
											othis) : '';
								});
					});
</script>

</html>
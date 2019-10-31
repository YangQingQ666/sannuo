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
	<br />
	<xblock>
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
					<div class="layui-row"><form class="layui-form layui-col-md12 layui-input x-so"><input id="start" class="layui-input"
					style="width: 100px; margin-bottom: -38px; margin-left: 20px;"
					placeholder="开始日" name="start" id="start"> <input id="end"
					class="layui-input "
					style="width: 100px; float: left; margin-bottom: 0px; margin-left: 105%"
					placeholder="截止日" name="end" id="end">  </form></div>
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
						<p align="center" style="margin-right: 400px; font-size: 22px;">消费者数据图谱</p>
						<!--<span style="font-size: 20px;margin-left: 430px;"></span>-->
					</div>
				</td>
			</tr>
			<tr>
				<td rowspan="6"></td>
			</tr>
		</table>
	</form>
	</xblock>
	<div class="layui-card-body">
		<div class="layui-tab layui-tab-brief"
			lay-filter="component-tabs-brief">
			<ul class="layui-tab-title">
				<li class="layui-this">检测时段人次分布</li>
				<li>检测频次排行</li>
				<li>结果分析图</li>
			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show" style="margin-top: 10px;">
					<table style="margin-left: 16%;" width="65%">
						<!-- <tr>
							<td align="center">平均年龄(岁)</td>
							<td align="center">异常人次</td>
							<td align="center">异常比例</td>
						</tr>
						<tr>
							<td align="center">36</td>
							<td align="center">439</td>
							<td align="center">81.30%</td>
						</tr> -->
					</table>
					<span
						style="margin-left: 40%; position: relative; top: 50px; font-size: 20px; font-weight: 10px;">按时段检测人次分布</span>
					<div id="main" style="width: 100%; height: 400px;"></div>
					<div id="app" style="width: 100%; height: 400px;"></div>
				</div>
				<div class="layui-tab-item">
					<!--排名前十-->
					<table width="100%" border="1">
						<tr align="center" bgcolor="#F2F2F2">
							<td>排名</td>
							<td>姓名</td>
							<td>性别</td>
							<td>身份证号码</td>
							<td>联系方式</td>
							<td>检测次数</td>
							<td>指标异常率</td>
							<td>所属总店</td>
							<td>所属分店</td>
						</tr>
						<tr align="center">
							<td>1</td>
							<td>白方瑞</td>
							<td>男</td>
							<td>43068115156****888</td>
							<td>110120119</td>
							<td>20</td>
							<td>60%</td>
							<td>艾泽拉斯总店</td>
							<td>奥格瑞玛分店</td>
						</tr>
						<tr align="center" bgcolor="#F2F2F2">
							<td>2</td>
							<td>吴志豪</td>
							<td>男</td>
							<td>43068115156****888</td>
							<td>110120119</td>
							<td>20</td>
							<td>60%</td>
							<td>艾泽拉斯总店</td>
							<td>幽暗城分店</td> 
						</tr>
					</table>

				</div>
				<div class="layui-tab-item">
					<div class="x-body">
						<div id="container"
							style="min-width: 95%; height: 400px; margin: 0 auto;margin-left:-10px"></div>
						<div style="margin: 20px auto; text-align: center;">
							<a href="http://www.100sucai.com/" target="_blank"><img
								src="100sucai.png" alt=""></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>

	<script src='../zx/highcharts.js'></script>
	<script src="../zx/index.js"></script>

	<script type="text/javascript" src="../js/echarts.js"></script>
	<script type="text/javascript" src="wzh/dianp.js"></script>
	<script type="text/javascript">
		zdxlk();
		fdxlk($("#c1").val());
		fdxlkchange();
	</script>
	<script>
	layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });
		$(function() {

			//婴幼儿(0-6)  儿童(7-12)   少年(12-15)  青年(15-30)  中年(30-50)  老年(≥50)
			var glucose = [ "婴幼儿", "儿童", "少年", "青年", "中年", "老年" ];
			var count = [ 1, 2, 2, 2, 3, 10 ]; //异常人次
			$.ajax({
				url : '${path}/query.do',
				type : 'post',
				dataType : 'json',
				async : false,
				success : function(data) {
					count = data.jis;
					//bis = data.bis;
				}
			});
			//var sum = [boy[0] + girl[0], boy[1] + girl[1], boy[2] + girl[2], boy[3] + girl[3], boy[4] + girl[4]]; //合计人数
			// 基于准备好的dom，初始化echarts实例
			var myChart = echarts.init(document.getElementById('main'));
			var posList = [ 'left', 'right', 'top', 'bottom', 'inside',
					'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
					'insideTopLeft', 'insideTopRight', 'insideBottomLeft',
					'insideBottomRight' ];

			app.configParameters = {
				rotate : {
					min : -90,
					max : 90
				},
				align : {
					options : {
						left : 'left',
						center : 'center',
						right : 'right'
					}
				},
				verticalAlign : {
					options : {
						top : 'top',
						middle : 'middle',
						bottom : 'bottom'
					}
				},
				position : {
					options : echarts.util.reduce(posList, function(map, pos) {
						map[pos] = pos;
						return map;
					}, {})
				},
				distance : {
					min : 0,
					max : 100
				}
			};

			app.config = {
				rotate : 90,
				align : 'left',
				verticalAlign : 'middle',
				position : 'insideBottom',
				distance : 15,
				onChange : function() {
					var labelOption = {
						normal : {
							rotate : app.config.rotate,
							align : app.config.align,
							verticalAlign : app.config.verticalAlign,
							position : app.config.position,
							distance : app.config.distance
						}
					};
					myChart.setOption({
						series : [ {
							label : labelOption
						}, {
							label : labelOption
						}, {
							label : labelOption
						}, {
							label : labelOption
						} ]
					});
				}
			};

			var labelOption = {
				normal : {
					show : true,
					position : app.config.position,
					distance : app.config.distance,
					align : app.config.align,
					verticalAlign : app.config.verticalAlign,
					rotate : app.config.rotate,
					formatter : '{c}  {name|{a}}',
					fontSize : 16,
					rich : {
						name : {
							textBorderColor : '#fff'
						}
					}
				}
			};

			var option = {
				color : [ '#003366', '#006699', '#4cabce', '#e5323e' ],
				tooltip : {
					trigger : 'axis',
					axisPointer : {
						type : 'shadow'
					}
				},
				legend : {
					data : [ 'Forest', 'Steppe', 'Desert', 'Wetland' ]
				},
				toolbox : {
					show : true,
					orient : 'vertical',
					left : 'right',
					top : 'center',
					feature : {
						mark : {
							show : true
						},
						dataView : {
							show : true,
							readOnly : false
						},
						magicType : {
							show : true,
							type : [ 'line', 'bar', 'stack', 'tiled' ]
						},
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
				calculable : true,
				xAxis : [ {
					type : 'category',
					axisTick : {
						show : false
					},
					data : glucose
				} ],
				yAxis : [ {
					type : 'value'
				} ],
				series : [ {
					name : '男',
					type : 'bar',
					barGap : 0,
					label : labelOption,
					data : count
				},

				]
			};
			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
		})
	</script>

</body>

</html>
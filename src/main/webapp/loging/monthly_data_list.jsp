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
		<script src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../lib/layui/layui.js" charset="utf-8"></script>
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
		<br/>
		<xblock>
			<div style="height: 50px;">
				<h1 align="center" style="margin-top: 25px;" id="hd"> </h1>
			</div>
			
		</xblock>
		<div class="layui-card-body">
			<div class="layui-tab layui-tab-brief" lay-filter="component-tabs-brief">
				<ul class="layui-tab-title">
					<li class="layui-this">服务人群画像</li>
					<li>检测排名</li>
					<li>指标异常数据统计</li>
					<li>指标异常人群分布</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show" style="margin-top: 10px;">
						<div class="x-body" >
							<div id="container" style="min-width: 95%; height: 400px; margin: 0 auto"></div>
							<div style="margin: 20px auto; text-align: center;">
								<a href="http://www.100sucai.com/" target="_blank"><img src="100sucai.png" alt=""></a>
							</div>
						</div>
					</div>
					<div class="layui-tab-item">
						<table border="0" width="100%">
							<tr>
								<td><h2 id="tb1font"></h2></td>
								<td align="right"><h2 align="right" id="tb1count"></h2></td>
							</tr>
						</table>
						<br />
						<table width="100%" border="1" id="tb1"  >
							<tr align="center" bgcolor="#F2F2F2">
								<td>排名</td>
								<td>总店名称</td>
								<td>分店名称</td>
								<td>检测量</td>
							</tr>
							
						</table>
						<br /><br />
						<table border="0" width="100%">
							<tr>
								<td><h2>异常率最高的店:海王分店1大药房</h2></td>
								<td align="right"><h2 align="right">所有指标异常率200%</h2></td>
							</tr>
						</table>
						<br />
						<!-- <table width="100%" border="1">
							<tr align="center">
								<td>排名</td>
								<td>总店名称</td>
								<td>分店名称</td>
								<td>服务人数</td>
								<td>指标异常人数</td>
								<td>指标异常率</td>
							</tr>
							<tr align="center" >
								<td>1</td>
								<td>海王大药房</td>
								<td>海王分店1大药房</td>
								<td>1</td>
								<td>2</td>
								<td>200%</td>
							</tr>
							<tr align="center" bgcolor="#F2F2F2">
								<td>2</td>
								<td>海王大药房</td>
								<td>海王分店1大药房</td>
								<td>1</td>
								<td>1</td>
								<td>100%</td>
							</tr>
							<tr align="center" >
								<td>3</td>
								<td>海王大药房</td>
								<td>海王分店1大药房</td>
								<td>1</td>
								<td>1</td>
								<td>100%</td>
							</tr>
							<tr align="center" bgcolor="#F2F2F2">
								<td>4</td>
								<td>海王大药房</td>
								<td>海王分店1大药房</td>
								<td>1</td>
								<td>1</td>
								<td>100%</td>
							</tr>
							<tr align="center" >
								<td>5</td>
								<td>海王大药房</td>
								<td>海王分店1大药房</td>
								<td>1</td>
								<td>1</td>
								<td>100%</td>
							</tr>
						</table> -->
					</div>
					<div class="layui-tab-item">
						<h2>检测指标异常数据统计表</h2>
						<table width="100%" border="1">
							<tr align="center" bgcolor="#F2F2F2">
								<td>指标</td>
								<td>检测人次</td>
								<td>异常人数</td>
								<td>指标异常率</td>
								<td>低于标准值人数</td>
								<td>高于标准值人数</td>
							</tr>
							<tr align="center" >
								<td>血糖</td>
								<td>83</td>
								<td>50</td>
								<td>60.2%</td>
								<td>11</td>
								<td>39</td>
							</tr>
							<tr align="center" bgcolor="#F2F2F2">
								<td>甘油三脂</td>
								<td>83</td>
								<td>79</td>
								<td>95.2%</td>
								<td>2</td>
								<td>77</td>
							</tr>
							<tr align="center" >
								<td>总胆固醇</td>
								<td>78</td>
								<td>37</td>
								<td>47.4%</td>
								<td>16</td>
								<td>21</td>
							</tr>
							<tr align="center" bgcolor="#F2F2F2">
								<td>高密度脂蛋白胆固醇</td>
								<td>79</td>
								<td>75</td>
								<td>94.9%</td>
								<td>6</td>
								<td>69</td>
							</tr>
							<tr align="center" >
								<td>低密度脂蛋白胆固醇</td>
								<td>76</td>
								<td>63</td>
								<td>82.9%</td>
								<td>22</td>
								<td>41</td>
							</tr>
							<tr align="center" bgcolor="#F2F2F2">
								<td>总胆/高密度比</td>
								<td>78</td>
								<td>61</td>
								<td>78.2%</td>
								<td>11</td>
								<td>50</td>
							</tr>
							<tr align="center" >
								<td>血尿酸</td>
								<td>81</td>
								<td>62</td>
								<td>76.5%</td>
								<td>0</td>
								<td>62</td>
							</tr>
							<tr align="center" bgcolor="#F2F2F2">
								<td>血酮</td>
								<td>78</td>
								<td>72</td>
								<td>92.3%</td>
								<td>1</td>
								<td>71</td>
							</tr>
							<tr align="center" >
								<td>糖化血红蛋白</td>
								<td>77</td>
								<td>44</td>
								<td>57.1%</td>
								<td>0</td>
								<td>44</td>
							</tr>
							<tr align="center" bgcolor="#F2F2F2">
								<td>BMI</td>
								<td>83</td>
								<td>47</td>
								<td>56.6%</td>
								<td>12</td>
								<td>35</td>
							</tr>
							<tr align="center" >
								<td>血压</td>
								<td>77</td>
								<td>46</td>
								<td>59.7%</td>
								<td>4</td>
								<td>42</td>
							</tr>
						</table>
					</div>
					<div class="layui-tab-item">
						<h2>检测指标异常率人群分布统计表</h2>
						<br />
						<table width="100%" border="1">
							<tr align="center" bgcolor="#F2F2F2">
								<td>指标</td>
								<td>20岁以下</td>
								<td>20-29岁</td>
								<td>30-39岁</td>
								<td>40-49岁</td>
								<td>50-59岁</td>
								<td>60-69岁</td>
								<td>70岁以上</td>
							</tr>
							<tr align="center" >
								<td>血糖</td>
								<td>83%</td>
								<td>50%</td>
								<td>60.2%</td>
								<td>11%</td>
								<td>39%</td>
								<td>39%</td>
								<td>39%</td>
							</tr>
							<tr align="center" bgcolor="#F2F2F2">
								<td>甘油三脂</td>
								<td>83%</td>
								<td>79%</td>
								<td>95.2%</td>
								<td>2%</td>
								<td>77%</td>
								<td>39%</td>
								<td>39%</td>
							</tr>
							<tr align="center" >
								<td>总胆固醇</td>
								<td>78%</td>
								<td>37%</td>
								<td>47.4%</td>
								<td>16%</td>
								<td>21%</td>
								<td>39%</td>
								<td>39%</td>
							</tr>
							<tr align="center" bgcolor="#F2F2F2">
								<td>高密度脂蛋白胆固醇</td>
								<td>79%</td>
								<td>75%</td>
								<td>94.9%</td>
								<td>6%</td>
								<td>69%</td>
								<td>39%</td>
								<td>39%</td>
							</tr>
							<tr align="center" >
								<td>低密度脂蛋白胆固醇</td>
								<td>76%</td>
								<td>63%</td>
								<td>82.9%</td>
								<td>22%</td>
								<td>41%</td>
								<td>39%</td>
								<td>39%</td>
							</tr>
							<tr align="center" bgcolor="#F2F2F2">
								<td>总胆/高密度比</td>
								<td>78%</td>
								<td>61%</td>
								<td>78.2%</td>
								<td>11%</td>
								<td>50%</td>
								<td>39%</td>
								<td>39%</td>
							</tr>
							<tr align="center" >
								<td>血尿酸</td>
								<td>81%</td>
								<td>62%</td>
								<td>76.5%</td>
								<td>0%</td>
								<td>62%</td>
								<td>39%</td>
								<td>39%</td>
							</tr>
							<tr align="center" bgcolor="#F2F2F2">
								<td>血酮</td>
								<td>78%</td>
								<td>72%</td>
								<td>92.3%</td>
								<td>1%</td>
								<td>71%</td>
								<td>39%</td>
								<td>39%</td>
							</tr>
							<tr align="center" >
								<td>糖化血红蛋白</td>
								<td>77%</td>
								<td>44%</td>
								<td>57.1%</td>
								<td>0%</td>
								<td>44%</td>
								<td>39%</td>
								<td>39%</td>
							</tr>
							<tr align="center" bgcolor="#F2F2F2">
								<td>BMI%</td>
								<td>83%</td>
								<td>47%</td>
								<td>56.6%</td>
								<td>12%</td>
								<td>35%</td>
								<td>39%</td>
								<td>39%</td>
							</tr>
							<tr align="center" >
								<td>血压%</td>
								<td>77%</td>
								<td>46%</td>
								<td>59.7%</td>
								<td>4%</td>
								<td>42%</td>
								<td>39%</td>
								<td>39%</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		</div>
		
		<script src='../zx/highcharts.js'></script>
		<!-- <script src="../zx/index1.js"></script> -->

		<script type="text/javascript" src="../js/echarts.js"></script>
		<script type="text/javascript">
		var data1=new Array();
		var data2=new Array();
		var day=new Array();
		for(var i=0;i<mGetDate(mGetYear(),mGetYear());i++){
			day[i]=i+1;
		}
		function mGetYear() {
		    var myDate = new Date();
		    var tYear = myDate.getFullYear();
		 
		    return tYear;
		}
		function mGetMonth() {
		    var myDate = new Date();
		    var tMonth = myDate.getMonth();
		 
		    var m = tMonth + 1;
		    if (m.toString().length == 1) {
		        m = "0" + m;
		    }
		    return m;
		}
		function mGetDate(year, month){
		    var d = new Date(year, month, 0);
		    return d.getDate();
		}
		function fz(){
			$.ajax({
				url : "jlActionenquiriesOnQualifiedPersons.action",
				async : false,
				type : "POST",
				/*data : {
				},*/
				success : function(succ) {
					var a=JSON.parse(succ);
					console.log(a);
					for (var i = 0; i < a.nopass.length; i++) {
						data1[i]=a.nopass[i];
					}
					for (var i = 0; i < a.pass.length; i++) {
						data2[i]=a.pass[i];
					}
					
				}
			});
		}
		function Maximum_Detection(){
			$.ajax({
				url : "jlActionmaximumDetection.action",
				async : false,
				type : "POST",
				/*data : {
				},*/
				success : function(succ) {
					var a=eval(succ);
					console.log(a);
					var tra;
					var fdd;
					$("#tb1font").text("检测量最大的店:"+a[0][1]);
					$("#tb1count").text("检测量共计为:"+a[0][3]);
					for (var i = 0; i < a.length; i++) {
						if((i+1)%2==0){
							tra='<tr align="center" bgcolor="#F2F2F2">';
						}else{
							tra='<tr align="center">';
						}
						if(a[i][2]==null){
							fdd=a[i][1];
						}else{
							fdd=a[i][2];
						}
						$("#tb1").append(tra+
									'<td>'+(i+1)+'</td>'+
									'<td>'+fdd+'</td>'+
									'<td>'+(a[i][1])+'</td>'+
									'<td>'+(a[i][3]+1)+'</td>'+
								+'</tr>');
					}
				}
			});
		}
		$(function () {
			fz();
			Maximum_Detection();
			for(var i=0;i<mGetDate(mGetYear(),2);i++){
				day[i]=i+1;
			}
			function mGetYear() {
			    var myDate = new Date();
			    var tYear = myDate.getFullYear();
			 
			    return tYear;
			}
			function mGetMonth() {
			    var myDate = new Date();
			    var tMonth = myDate.getMonth();
			 
			    var m = tMonth + 1;
			    if (m.toString().length == 1) {
			        m = "0" + m;
			    }
			    return m;
			}
			function mGetDate(year, month){
			    var d = new Date(year, month, 0);
			    return d.getDate();
			}
			
		  $('#container').highcharts({
		    title: {
		      text: '',
		      x: -20 //center
		    },
		    colors: ['blue', 'red'],
		    plotOptions: {
		      line: {
		        lineWidth: 3
		      },
		      tooltip: {
		        hideDelay: 200
		      }
		    },
		    subtitle: {
		      text: '',
		      x: -20
		    },
		    xAxis: {
		    	//当月天数
		      categories: day/*['1', '2', '3', '4', '5', '6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22',
		      '23','24','25','26','27','28','29','30','31']*/
		    },
		    yAxis: {
		      title: {
		        text: '人数'
		      },
		      plotLines: [{
		        value: 0,
		        width: 1
		      }]
		    },
		    tooltip: {
		      valueSuffix: '人',
		      crosshairs: true,
		      shared: true
		    },
		    legend: {
		      layout: 'vertical',
		      align: 'right',
		      verticalAlign: 'middle',
		      borderWidth: 0
		    },
		    series: [{
		      name: '异常',
		      color: 'rgba(241, 63, 64)',
		      lineWidth: 2,
		      data:data1/* [100, 90, 80, 70, 60, 50,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,4,5,6,7,8,9,0,1]*/
		    },{
		    	 name: '正常',
		         color: 'rgba(0,0,204)',
		         lineWidth: 2,
		         data: data2/*[100, 90, 80, 75, 60, 2,1,77,3,4,7,6,7,8,9,0,1,2,3,1,5,6,7,4,5,22,7,8,55,0,1]*/
		    }]
		  });
		});
		
		function doHandleDate() {
		    var myDate = new Date();
		    var tYear = myDate.getFullYear();
		    var tMonth = myDate.getMonth();
		 
		    var m = tMonth + 1;
		    if (m.toString().length == 1) {
		        m = "0" + m;
		    }
		    return tYear +'-'+ m;
		}
			$(function() {
				
				$("#hd").html(doHandleDate()+"月份数据报表");
				//婴幼儿(0-6)  儿童(7-12)   少年(12-15)  青年(15-30)  中年(30-50)  老年(≥50)
				var glucose = ["婴幼儿", "儿童", "少年", "青年", "中年", "老年"];
				var count = [1, 2, 2, 2, 3, 10]; //异常人次
				$.ajax({
					url: '${path}/query.do',
					type: 'post',
					dataType: 'json',
					async: false,
					success: function(data) {
						count = data.jis;
						//bis = data.bis;
					}
				});
				//var sum = [boy[0] + girl[0], boy[1] + girl[1], boy[2] + girl[2], boy[3] + girl[3], boy[4] + girl[4]]; //合计人数
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
					onChange: function() {
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
							data: count
						},

					]
				};
				// 使用刚指定的配置项和数据显示图表。
				myChart.setOption(option);
			})
		</script>

	</body>

</html>
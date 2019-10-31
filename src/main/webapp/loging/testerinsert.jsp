<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta charset="UTF-8">
		<title>个人信息</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
		<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon" />
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
	</head>

	<body>
		<table >
			<tr>
				<td>
					<div style="margin-top: 40px;">
						<font size="5px" style="margin-left: 100px; margin-top: 30px;">项目代号:</font>
						<input type="text"  style="height: 27px;width: 180px" />
					</div>
				</td>
				<td>
					<div style="margin-top: 40px;">
						<font size="5px" style="margin-left: 100px; ">项目名称:</font>
						<input type="text" style="height: 27px;width: 180px" />
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div style="margin-top: 40px;">
						<font size="5px" style="margin-left: 145px; ">结果:</font>
						<input type="text" style="height: 27px;width: 180px" />
					</div>
				</td>
				<td>
					<div class="layui-inline"  style="margin-top: 40px;">
						<font size="5px" style="margin-left: 145px; ">单位:</font>
						<div class="layui-input-inline" style="width: 200px;">
							<select name="modules" lay-verify="required" lay-search="" style="height: 40px;"> 
								<option value="">请选择单位</option>
								<option value="1">mmol/L</option>
								<option value="2">%</option>
								<option value="3">umol/L</option>
							</select>
					</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div style="margin-top: 40px;">
						<font size="5px" style="margin-left: 120px;">参考值:</font>
						<input type="text" style="height: 27px;width: 180px" />
					</div>
				</td>
				<td>
					<div style="margin-top: 40px;">
						<font size="5px" style="margin-left: 100px;">校验方法:</font>
						<input type="text" style="height: 27px;width: 180px" />
					</div>
				</td>
			</tr>
					

		</table>
		 <div class="layui-form-item" style="margin-top: 20px;">
                <label class="layui-form-label" style="font-size: 25px;width: 175px;">其它信息:</label>
                <div class="layui-input-block" >
                  <textarea name="other"  class="layui-textarea" style="width: 250px;margin-left: 22px;"></textarea>
                </div>
              </div>
				
		<div style="margin-left:460px ;margin-top: 70px;">
			<button class="layui-btn layui-btn-radius">默认按钮</button>
		</div>
		
		
	</body>

</html>

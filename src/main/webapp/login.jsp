<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="format-detection" content="telephone=no">
            <meta name="renderer" content="webkit">
            <meta http-equiv="Cache-Control" content="no-siteapp" />
<title>三诺分钟诊所管理系统</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/font.css">
<script src="js/jquery.min.js"></script>
</head>
<body style="background-image:;">
	<div
		style="width: 700px; margin-left: auto; margin-right: auto; margin-top: 50px;">
		<span style="float: left;"><img src="images/logo.png"
			width="350" style="margin-top: 4px" /></span>
		<h1 style="float: left; color: #fff; font-size: 40px;">分钟诊所管理系统</h1>
	</div>
	<div id="wrapper" class="login-page">
		<div id="login_form" class="form">
			<form   class="register-form">
				<h2 id="sf1">检测者登录</h2>
				<input name="phone" type="text" autocomplete="off" placeholder="手机号" id="phone" />
					<input autocomplete="off" style="margin-right: 250px;float:left;width: 170px;" placeholder="验证码" id="rpcode" /><button id="getCode" type="button" style="float:right;width:140px;margin-right: 1px;margin-top: -64px;">发送验证码</button>
					<input id="code" type="hidden" />
					<input id="abc1" type="hidden" />
					<font  id="yz" style="float:right;color:red;font-weight: 400;margin-bottom: 12px;"></font>
					<font  id="m" style="float:right;color:red;font-weight: 400;margin-bottom: 12px;"></font>
				<button id="create" type="button">登 录</button>
				<p class="message">
					换个身份吧? <a id="jgl" href="#">管理者登录</a>
				</p>
			</form>
			<form class="login-form">
				<h2 style="text-align: center;" id="sf2">管理者登录</h2>
				<input type="text" placeholder="用户名" id="account" /> <input
					type="password" placeholder="密码" id="password" />
					<font id="ts" style="float:right;color:red;font-weight: 400;margin-bottom: 12px;"></font>
				<button id="login" type="button">登 录</button>
				<p class="message">
					换个身份吧? <a id="gdl" href="#">检测者登录</a>
				</p>
			</form>
		</div>
	</div>
	
	<script type="text/javascript">
		$(function() {
			var InterValObj; //timer变量，控制时间 
            var count = 60; //间隔函数，1秒执行 
            var curCount; //当前剩余秒数 
            var code = ""; //验证码 
            var codeLength = 6; //验证码长度 
            function sendMessages() {
                  curCount = count;
                  var phone =$("#phone").val();
                  var da=$("#abc1").val();
               	 	if(da==0){
                		$("#yz").text("❗手机号不存在");
                		return;
              		  }
               	 	$("#code").val(da);
                  if(validatePhone(phone)) {
                        return;
                  }
                  if(phone != "") {
                        //设置button效果，开始计时 
                        $("#getCode").attr("disabled", "true");
                        $("#getCode").text("请在" + curCount + "秒内输入");
                        InterValObj = window.setInterval(SetRemainTimes, 1000); //启动计时器，1秒执行一次 
                        
                  } else {
                        $("#yz").text("❗手机号不能为空");
                  }
            }
            //timer处理函数 
            function SetRemainTimes() {
                  if(curCount == 0) {
                        window.clearInterval(InterValObj); //停止计时器 
                        $("#getCode").removeAttr("disabled"); //启用按钮 
                        $("#getCode").text("重新发送验证码");
                        code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效     
                  } else {
                        curCount--;
                        $("#getCode").text("请在" + curCount + "秒内输入");
                  }
            }
            //开始按钮点击事件
            $("#create").click(function() {
            	var phone =$("#phone").val();
               if(!(validatePhone(phone)&&validateCode()))
              	{
					window.location.href ='loging/index.jsp';
              	}  
            })
            //验证手机号
            function validatePhone(phone) {
                  if(phone == '') {
                        $("#yz").text("❗请先填写手机号");
                        return true;
                  }
                  var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
                  if(!myreg.test(phone)) {
                        $("#yz").text("❗请输入有效的手机号");
                        return true;
                  }
                  $("#yz").html("");
                  return false;
            }
           	//验证码非空和错误验证
            function validateCode() {
                  var phone = $("#phone").val();
                  var code = $("#code").val();
                  var rpcode = $("#rpcode").val();
                  console.log(code);
                  if(validatePhone(phone)) {
                        return true;
                  }
                  if(code == '') {
                        $("#m").text("❗请先获取验证码");
                        return true;
                  }
                  if(rpcode == ''|| code != rpcode) {
                        $("#m").text("❗请正确输入验证码");
                        return true;
                  }
                  $("#m").text("");
                  return false;
            }
			$("#rpcode").keyup(function(){
				 validateCode();
			})
			//向后台发送处理数据 
			$("#getCode").click(function(){
				 var phone =$("#phone").val();
	                $.ajax({
	                	url: "customerActionfindByCustomer.action",
						async: false,
						type: "POST",
						data: "phone=" + phone,
						success: function(data) {
								$("#abc1").val(data);
						}
	                });
				sendMessages();
				$("#m").text("");
				$("#rpcode").val();
			})
			$("#login").click(function() {
				var url=null;
				var name = $("#account").val();
				var pass = $("#password").val();
				if(name==""){
					$("#ts").html("❗用户名不能为空"); 
					return;
				}
				if(pass==""){
					$("#ts").html("❗密码不能为空"); 
					return;
				}
				$.ajax({
					url: "bossActionfindByBoss.action",
					async: true,
					type: "POST",
					data: {
						'account':name,
						'password':pass
					},
					success: function(data) {
						var a=data;
						if(a==1){
							url='loging/index.jsp';
							setTimeout(function(){
							    window.location.href = url;
							},1);
						}else{
							$("#ts").html("❗账号或密码错误"); 
						}
					}
				});
				
			})
			$("#account").blur(function(){
				if(this.value==""){
					$("#ts").html("❗用户名不能为空"); 
					return;
				}else{
					$("#ts").html(""); 
				}
			})
			$("#password").blur(function(){
				if(this.value==""){
					$("#ts").html("❗密码不能为空"); 
					return;
				}else{
					$("#ts").html(""); 
				}
			})
			$("#r_user_name").blur(function(){
				if(this.value==""){
					$("#ts1").html("❗手机号不能为空"); 
					return;
				}else{
					$("#ts1").html(""); 
				}
			})
			
			$("#r_password").blur(function(){
				if(this.value==""){
					$("#ts1").html("❗验证码不能为空"); 
					return;
				}else{
					$("#ts1").html(""); 
				}
			})
			$('.message a').click(function() {
				$('form').animate({
					height : 'toggle',
					opacity : 'toggle'
				}, 'slow');
				$("#yz").text("");
           	 $("#ts").text("");
           	 $("#m").text("");
           	 $("input").val("");
			}); 
		})
		$("#phone").click(function() {
                        $("#yz").text("");
                 })
                 
	</script>
</body>
</html>
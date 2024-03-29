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
  </head>
  
  <body>
    <div class="x-body">
        <form class="layui-form">
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>菜单名称
              </label>
              <div class="layui-input-inline">
                  <input  type="text" id="username" style="width: 220px" name="username" required lay-verify="required"
                  autocomplete="off" value="admin" class="layui-input">
              </div>&nbsp;&nbsp;
              <div style="margin-left: 30px;" class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>菜单路径
              </label>
              <div class="layui-input-inline">
                  <input type="text"  style="width: 220px" id="username" name="username" required lay-verify="required"
                  autocomplete="off" value="admin" class="layui-input">
              </div>
              <div style="margin-left: 30px;" class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>菜单类型	
              </label>
              <div  class="ayui-input-inline layui-form " style="width: 220px;margin-left: 110px;margin-top: 10px;" >
            		<select name="contrller">
              	<option>支付方式</option>
              	<option>支付宝</option>
             	 <option>微信</option>
              	<option>货到付款</option>
            </select>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>上级菜单
              </label>
              <div  class="ayui-input-inline layui-form " style="width: 220px;margin-left: 110px;margin-top: 10px;" >
            		<select name="contrller">
              	<option>支付方式</option>
              	<option>支付宝</option>
             	 <option>微信</option>
              	<option>货到付款</option>
            </select>
          </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>图标
              </label>
              <div  class="ayui-input-inline layui-form " style="width: 220px;margin-left: 110px;margin-top: 10px;" >
            		<select name="contrller">
              	<option>支付方式</option>
              	<option>支付宝</option>
             	 <option>微信</option>
              	<option>货到付款</option>
            </select>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button style="margin-left: 500px;margin-top: 17px;width: 100px;"  class="layui-btn" lay-filter="add" lay-submit="">
                  保存
              </button>
          </div>
      </form>
    </div>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
          });

          //监听提交
          form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
          });
          
          
        });
    </script>
  </body>

</html>
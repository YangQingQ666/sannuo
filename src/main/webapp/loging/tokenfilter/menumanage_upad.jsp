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
    <link rel="stylesheet" href="../../css/font.css">
    <link rel="stylesheet" href="../../css/xadmin.css">
    <script src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../../js/xadmin.js"></script>
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
                  <input  type="text"  style="width: 220px" required lay-verify="required"
                  autocomplete="off" id="jname" class="layui-input"><input id="id" name="id" type="hidden" />
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
                  <input type="text" id="url"  style="width: 220px" 
                  autocomplete="off" class="layui-input">
              </div>
              <div style="margin-left: 30px;" class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>一级菜单无菜单路径
              </div>
          </div>
          
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>上级菜单
              </label>
              <div class="ayui-input-inline layui-form " style="width: 220px;margin-left: 110px;margin-top: 10px;" >
            		<select id="partid">
              	<option  value="0">*一级菜单*</option>
              	
            </select>
          </div>
          </div>
          <div class="layui-form-item">
              <label style="margin-left: 0px;" class="layui-form-label">
                  <span class="x-red">*</span>图标
              </label>
              <div class="layui-input-inline">
                  <input id="tb" disabled="disabled" type="text" style="width: 100px" required lay-verify="required"
                  autocomplete="off"  class="layui-input">
              </div>&nbsp;&nbsp;<input type="hidden" name="icon" id="icon" />
               <button style="margin-left:-50px;" class="layui-btn" onclick="x_admin_show('图标选择','../icon.jsp',700,400)" lay-filter="add" id="xtb" type="button">选择</button>
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
    <script type="text/javascript">
    var id=${param.id};
    $("#id").val(id); 
    $(function(){
    	var jid=$("#id").val();
    	$.ajax({
			url : 'jurisdictionActionfinByJurisdictionTwo.action',
			type : 'post',
			async : false,
			success : function(data) {
				var da=eval('(' + data + ')');
				console.log(da);
				for (var i = 0; i < da.length; i++) {
					$("#partid").append(
							'<option value="'+da[i].jid+'">' + da[i].jname
									+ '</option>');
				}
			}
		});
    	upd(jid);
    	
    })
    function upd(da){
    	if(id!=null&&id!=''){
    		$.ajax({
    			url : 'jurisdictionActionfindById.action',
    			type : 'post',
    			async : false,
    			data:"id="+id,
    			success : function(data) {
    				var da =eval('('+data+')');
    				console.log(da);
    				$("#jname").val(da.jname);
            		$("#url").val(da.url);
            		$("#partid").val(da.partid);
            		$("#tb").val(da.icon);
            		$("#icon").val(da.icon);
    			}
    		});
    	}
    }
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length ==0){
                return '不能为空哦';
              }
            }
            
          });

          //监听提交
          form.on('submit(add)', function(data){
        	  var jid=$("#id").val();
        	  var jname=$("#jname").val();
      		var url=$("#url").val();
      		var partid=$("#partid option:selected").val();
      		var icon=$("#icon").val();
        	  if(jid==null){
        		  $.ajax({
            			url : 'jurisdictionActionsaveMenumanage.action',
            			type : 'post',
            			data:{
            				"jname":jname,
            				"url":url,
            				"partid":partid,
            				"icon":icon
            			},
            			async : false,
            			success : function(data) {
            				var jg=eval(data);
            				state=jg;
            				if(state!=0){
            					x_admin_close();
            				}
            				return false;
            			}
            		});
        	  }
        	  $.ajax({
        			url : 'jurisdictionActionupJurisdictionById.action',
        			type : 'post',
        			data:{
        				"jid":jid,
        				"jname":jname,
        				"url":url,
        				"partid":partid,
        				"icon":icon
        			},
        			async : false,
        			success : function(data) {
        				var jg=eval(data);
        				state=jg;
        				if(state!=0){
        					x_admin_close();
        				}
        				return false;
        			}
        		});
        	  
        	  
          });
          
          
        });
    </script>
  </body>

</html>
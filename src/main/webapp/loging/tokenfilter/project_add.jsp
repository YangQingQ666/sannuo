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
  <style>
  	
  </style>
  <body>
    <div class="x-body">
        <form class="layui-form">
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>项目名称<input type="hidden" id="did"/>
              </label>
              <div class="layui-input-inline">
                  <input disabled="disabled" type="text" id="pname"  required lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>项目名称固定不可更改
              </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>单位
              </label>
              <div class="layui-input-inline">
                  <input disabled="disabled" type="text" id="unit" required lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>单位固定不可更改
              </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>参考值	
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="c1" disabled="disabled"  οnkeyup="value=value.replace(/[^\d.]/g,'')"  style="width: 65px;display: inline;" required lay-verify="required" autocomplete="off"  class="layui-input">&nbsp;&nbsp;&nbsp;&nbsp;--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" id="c2" disabled="disabled"  οnkeyup="value=value.replace(/[^\d.]/g,'')"  style="width: 65px;display: inline;" required lay-verify="required" autocomplete="off"  class="layui-input">
                  
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>参考值不可改动
              </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>检测方法
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="method"  required lay-verify="required" autocomplete="off"  class="layui-input">
                  
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>检测区间
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="j1" placeholder="最小值"  onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" style="width: 65px;display: inline;"  autocomplete="off"  class="layui-input">&nbsp;&nbsp;&nbsp;&nbsp;--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" id="j2" placeholder="最大值" onkeyup="this.value=this.value.replace(/[^\d]+[^.][^\d]{0,3},'')"  style="width: 65px;display: inline;"  autocomplete="off"  class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>结果解读
              </label>
              <div class="layui-input-inline">
              	<textarea id="jd" required lay-verify="required" cols="24" rows="4"></textarea>
                  
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button style="margin-left:450px;width:100px;"  class="layui-btn" lay-filter="add" lay-submit="">
                保存
              </button>
          </div>
      </form>
    </div>
    <script>
    $(function(){
    	var id = ${param.id};
    	$("#did").val(id);
        	$.ajax({
    			url : 'projectActionfindProjectById.action',
    			type : 'post',
    			data:"did="+id,
    			async : false,
    			success : function(data) {
    				var project =eval('('+data+')');
    				if(project.reference.indexOf(">")>=0){
    					$("#c1").val(project.reference.substring(1,project.reference.length));
    					$("#c2").val("---");
    				}
    				if(project.reference.indexOf("<")>=0){
    					$("#c2").val(project.reference.substring(1,project.reference.length));
    					$("#c1").val("---");
    				}
    				if(project.reference.indexOf("-")>=0){
    					$("#c1").val(project.reference.substr(0,project.reference.indexOf("-")));
    					$("#c2").val(project.reference.substring((project.reference.indexOf("-")+1),project.reference.length));
    				}
    				if(project.intervarl.indexOf("-")>=0){
    					$("#j1").val(project.intervarl.substr(0,project.intervarl.indexOf("-")));
    					$("#j2").val(project.intervarl.substring((project.intervarl.indexOf("-")+1),project.intervarl.length));
    				}
    				if(project.intervarl.indexOf("<")>=0){
    					$("#j2").val(project.intervarl.substring(1,project.intervarl.length));
    					$("#j1").val();
    				}
    				if(project.intervarl.indexOf(">")>=0){
    					$("#j1").val(project.intervarl.substring(1,project.intervarl.length));
    					$("#j2").val();
    				}
    				$("#pname").val(project.dname);
    				$("#unit").val(project.unit);
    				$("#method").val(project.method);
    				$("#jd").val(project.unscramble);
    			}
    		});
    })
    
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length ==0){
                return '不能为空';
              }
            }
            
          });

          //监听提交
          form.on('submit(add)', function(data){
            var state=0;
            var method=$("#method").val();
            var intervarl="";
            var min=$("#j1").val();
            var max=$("#j2").val();
            if(min==null||min==''){
            	intervarl="<"+max;
            }
            if(max==null||max==''){
            	intervarl=">"+min;
            }
            if(max!=null&&max!=''&&min!=null&&min!=''){
            	intervarl=min+"-"+max;
            }
            var unscramble=$("#jd").val();
            var did=$("#did").val()
            $.ajax({
    			url : 'projectActionupByid.action',
    			type : 'post',
    			data:{
    				"method":method,
    				"intervarl":intervarl,
    				"unscramble":unscramble,
    				"did":did
    			},
    			async : false,
    			success : function(data) {
    				var jg=eval(data);
    				state=jg;
    				if(state!=0){
    					// 获得frame索引
    	                var index = parent.layer.getFrameIndex(window.name);
    	                //关闭当前frame
    	                /* parent.layer.reload(); */
    	                parent.layer.close(index);
    				}
    				return false;
    			}
    		});
            
          });
          
          
        });
    </script>
  </body>

</html>
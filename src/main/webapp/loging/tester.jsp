<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>检测数据</title>
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
  
  <body class="layui-anim layui-anim-up">
  
  	<div class="x-body">
    
    
      <table class="layui-table">
				
        <thead>
          <tr>
            <th>收缩压</th>
            <th>舒张压</th>
            <th>胆固醇</th>
            <th>血糖</th>
            <th>血尿酸</th>
            <th>血红蛋白</th>
            <th>甘油三脂</th>
            <th>血酮</th>
            <th>参考值</th>
            <th>检测方法</th>
            <th>结果解读</th>
            <th>检测时间</th>
            <th>检查店面</th>
        </thead>
        <tbody id="tbody">
          	
        </tbody>
				
				</table>
      <div class="page">
        <div>
          <a class="prev" href="">&lt;&lt;</a>
          <a class="num" href="">1</a>
          <span class="current">2</span>
          <a class="num" href="">3</a>
          
          <a class="next" href="">&gt;&gt;</a>
        </div>
      </div>

    </div>
    <script>
    $(function(){
    	cx();
    })
    
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

    
    function cx(){
		 $.ajax({
			url : "testerActionquery.action",
			async : false,
			type : "POST",
			data : {},
			success : function(json) {
				var a=eval('('+json+')');
				console.log(a);
				for (var i = 0; i < a.length; i++) {
					$("#tbody").append("<tr><td> "+a[i].ssy+"</td><td>"+a[i].szy+"</td><td>"+a[i].dgc+"</td><td>"+a[i].xtang+"</td><td>"+a[i].xns+"</td><td>"+a[i].xhdb+"</td><td>"+a[i].gysz+"</td><td>"+a[i].xton+"</td><td>"+"8.12~18"+"</td><td>"+a[i].method+"</td><td>"+a[i].commont+"</td><td>"+a[i].time+"</td><td>"+a[i].bname+"</td></tr>");
				}
				
			}
		}); 
	}
    </script>
  </body>

</html>
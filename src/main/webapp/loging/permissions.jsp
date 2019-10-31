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
  </style>
  <body>
    <div class="x-body">
      <xblock style="height: 50px;">
        <button class="layui-btn" style="margin-top:6px;background-color: dodgerblue;width: 150px; margin-left: 30px;" onclick="x_admin_show('添加用户','loging/menumanage_upad.jsp',770,400)"><i class="layui-icon"></i>添加</button>
       
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th></th>
            <th>角色名</th>
            <th>权限</th>
            <th>备注</th>
            <th>状态</th>
            <th>操作</th>
        </thead>
        <tbody id="tbody">
          
        </tbody>
      </table>
      <div id="demo6" style="text-align: center;"></div>

    </div>
    <script type="text/javascript">
    var fyy;
	var fyycount;
	$(function(){
		all();
		$("#count").text("共有数据："+fyycount+" 条");
	})
  	//初始页面
  	function all(){
		$.ajax({
			url : 'roleJurisdictionActionfindByRoleJurisdiction.action',
			type : 'post',
			async : false,
			success : function(data) {
				var all = eval(data);
				fyy=all;
				fyycount=all.length;
				sxfy();
			}
		});
	}
	function ckkk(da){
		var url = "tokenfilter/roleJurisdiction_upda.jsp?id="+da;
		 var index = layui.layer.open({
		        title : "编辑角色权限",
		        type : 2,
		        content : url,//弹出层页面
		        area: ['800px', '500px'],
		        shadeClose: true,
		        maxmin: true,
		        fix: false, //不固定
		        end: function () {
		            location.reload();
		          }
		    })
	}
	//分页方法
	function sxfy() {
		layui.use([ 'laypage', 'layer' ], function() {
			var laypage = layui.laypage, layer = layui.layer;

			//只显示上一页、下一页
			laypage.render({
				elem : 'demo6',
				count : fyycount,
				layout : [ 'prev', 'next' ],
				jump : function(obj, first) {
					if (!first) {
						layer.msg('第 ' + obj.curr + ' 页');
					}
				}
			});

			
			//调用分页
			laypage.render({
				elem : 'demo6',
				count : fyycount,
				limit : 5,
				jump : function(obj) {
					//模拟渲染
					document.getElementById('tbody').innerHTML = function() {
						var arr = [], thisData = fyy.concat()
								.splice(obj.curr * obj.limit - obj.limit,
										obj.limit);
						layui.each(thisData, function(index, item) {
							var state="正常";
							if(item.state!=0){
								state="已禁用";
							}
							arr.push('<tr>' + '<td>'
									+ (parseInt(index) + 1) + '</td>'
									+ '<td>' + item.jname + '</td>'
									+ '<td>' +item.name
								     + '</td>' + '<td>'
									+ item.comment + '</td>'
									+'<td class="td-status">'+state+'</td>'
						             +'<td class="td-manage">'
						              +'<a onclick='
						              +"member_stop(this,'10001')"
						              +'href="javascript:;"  title="启用"><i style="color:limegreen" class="layui-icon">&#xe601;</i>'
						              +'</a>'
						              +"<a title='编辑' "
						              +'onclick='
						              +'ckkk('+item.rid+') href="javascript:;">'
						                +'<i style="color:limegreen" class="layui-icon">&#xe642;</i></a></td></tr>');
							
						});
						
						return arr.join('');
					}();
				}
			});

		});
	}
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

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }



      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
    </script>
  </body>

</html>
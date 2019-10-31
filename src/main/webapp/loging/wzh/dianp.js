/*
 * 这是获取分店和总店的方法
 * 总店
 * <select  lay-filter="search_typez" lay-verify="search_typez"
				id="c1" name="zdn" lay-search>
				<c:if test="${boss.newBranch==null}">
					<option value="a" id="admin">全部</option>
				</c:if>
			</select>
 * 分店
 * <select id="c2" name="fdn">
				<c:if test="${boss.newBranch.partid==0||boss.newBranch==null}">
					<option value="b">全部</option>
				</c:if>
			</select>
 * */
function fdxlkchange(){
		layui.use([ 'form' ], function() {
			var form = layui.form;
			form.on('select(search_typez)', function(data) {
				//var partid=data.value;
				$.ajax({
	                type : "POST",
	                async:false,
	                url : "branchActiongetAllSmallBranch.action",
	                data : {"partid":$("#c1 option:selected").val()},
	                success : function(da)
	                {
	                	console.log($("#c1 option:selected").val());
	                	var ev=eval('('+da+')');
	                	
	                    console.log(ev);
	                    $("#c2").empty();
	                    $("#c2").append('<option value="b" id="admin">全部</option>');
	                   // $("#first").prepend("<option value='0'>请选择</option>");//添加第一个option值
	                     for (var i = 0; i < ev.length; i++) {
	                        //如果在select中传递其他参数，可以在option 的value属性中添加参数
	                        $("#c2").append('<option value="'+ev[i][0]+'">'+ev[i][1]+'</option>');
	 
	                    }
	                    //这句话必加，不加不显示新增的option
	                    form.render();
	                },error:function(){
	                    alert("获取数据失败","error");
	                }
	            });
			});
		});
		}

function fdxlk(partid){
	//分店
	$.ajax({
		url : "branchActiongetAllSmallBranch.action",
		async : false,
		type : "POST",
		 	data: {
		 		"partid":partid
			}, success : function(data) {
				da = eval('(' + data + ')');
				console.log(da);
			//循环分店
			for (var i = 0; i < da.length; i++) {
				$("#c2").append('<option value="'+da[i][0]+'">'+da[i][1]+'</option>');
			}
		}
	});
}
function zdxlk() {
			//总店
			$.ajax({
				url : "branchActiongetAllBigBranch.action",
				async : false,
				type : "POST",
				/* 	data: {
						
					}, */success : function(data) {
					var da = eval('(' + data + ')');
					console.log(da);
					//循环总店
					for (var i = 0; i < da.length; i++) {
						/* $("#c1").append('<option value="'+ da.zd[i].bid +'">'+ da.zd[i].bname d+ '</option>'); */
						$("#c1").append('<option  value="'+da[i][0]+'">'+da[i][1]+'</option>');
					}
				}
			});
		
		}

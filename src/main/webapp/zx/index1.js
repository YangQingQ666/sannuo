$(function () {
	var data1=new Array();
	var data2=new Array();
	$.ajax({
		url : "jlActionenquiriesOnQualifiedPersons.action",
		async : false,
		type : "POST",
		/*data : {
		},*/
		success : function(succ) {
			data1=eval(succ).pass;
			data2=eval(succ).nopass;
			alert(data2)
			console.log(data2);
		}
	});
	var day=new Array();
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
      data: data1/* [100, 90, 80, 70, 60, 50,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,4,5,6,7,8,9,0,1]*/
    },{
    	 name: '正常',
         color: 'rgba(0,0,204)',
         lineWidth: 2,
         data: data2/*[100, 90, 80, 75, 60, 2,1,77,3,4,7,6,7,8,9,0,1,2,3,1,5,6,7,4,5,22,7,8,55,0,1]*/
    }]
  });
});
$(function () {
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
    	//婴幼儿(0-6)  儿童(7-12)   少年(12-15)  青年(15-30)  中年(30-50)  老年(≥50)
      categories: ['婴幼儿', '儿童', '少年', '青年', '中年', '老年']
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
      color: 'rgba(255,0,0,0.25)',
      lineWidth: 2,
      data: [100, 90, 80, 70, 60, 50]
    }, {
      name: '正常',
      color: 'rgba(0,120,200,0.75)',
      marker: {
        radius: 6
      },
      data: [100, 110, 85, 60, 60, 30]
    }]
  });
});
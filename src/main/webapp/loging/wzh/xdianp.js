layui.fsSelect = {
    //省份
    area1 : {
      formatType : "server", //server 动态数据字典
      loadUrl : "branchActiongetAllBigBranch.action", //异步加载数据的url地址
      method : "post",//指定请求类型，默认post
      //inputs : "partid":partid, //异步请求携带的参数
      labelField : "0", //示数据的属性
      valueField : "1" //value对应的属性
    }
  }
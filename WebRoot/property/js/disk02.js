$(function(){
	// 基于准备好的dom，初始化echarts实例
    var myChart02 = echarts.init(document.getElementById('main02'));

    option02 = {
	    title : {
	        text: '磁盘使用情况',
	        subtext: 'GB',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	        orient: 'vertical',
	        left: 'left',
//	        data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
	    	data: []
	    },
	    series : [
	        {
	            name: '磁盘',
	            type: 'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:[
//	                {value:335, name:'直接访问'},
	            ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
    getDisk02();
    
    function getDisk02(){
    	$.ajax({
			type:"post",
			async:true,	//异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
			url:"getDisk.action",
			dataType:"json",
			success:function(data){
				//myChart.hideLoading();    //隐藏加载动画
				for(var i=0;i<data.length;i++){
					delete option02.series[0].data[i];
					delete option02.legend.data[i];
				}
				for(var i=0;i<data.length;i++){
					var d ={
						"value":data[i].diskTotal,
						"name":data[i].diskName
					}
					option02.series[0].data.push(d);
					option02.legend.data.push(data[i].diskName);
				}
				myChart02.setOption(option02, true);
			},
			error:function(jqXHR){
//				alert("请求失败");
//				myChart.hideLoading();
			}
		});
    }
});
$(function(){
// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
	
    option = {
    	title:{
    		text:'内存'
    	},
	    tooltip : {
	        formatter: "{a} <br/>{b} : {c}%"
	    },
	    toolbox: {
	        feature: {
	            restore: {},
	            saveAsImage: {}
	        }
	    },
	    series: [
	        {
	            name: '内存',
	            type: 'gauge',
	            detail: {formatter:'{value}%'},
	            data: [{value: 0, name: '内存'}]
	        }
	    ]
	};
	getMemory();

	//myChart.showLoading();		//数据加载完之前显示loading画面
	setInterval(function(){		//定时请求数据 2s一次
		getMemory();
	}, 2000);
	
	function getMemory(){
		$.ajax({
			type:"post",
			async:true,	//异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
			url:"getMemory.action",
			dataType:"json",
			success:function(data){
				//myChart.hideLoading();    //隐藏加载动画
				option.series[0].data[0].value=data[0].memPercent;
				option.series[0].data[0].name=data[0].memTotal+" GB";
				myChart.setOption(option, true);
			},
			error:function(jqXHR){
//				alert("请求失败");
//				myChart.hideLoading();
			}
		});
	}
			
});
var RTAUtil={
	initFlag:true,
	requestService:function(url,reqData,callbackFn){
		$.ajax({ 
	         type:'post', 
	         url:url, 
	         data:reqData, 
//	         async:false,
	         success:function(data){
	            if(data.msg=='success'){
	            	callbackFn(data);  
	            }else{
	            	if(RTAUtil.initFlag){
	            		alert(data.msg);  //弹出失败msg
	            		RTAUtil.initFlag=false;
	            	}
	                
	            }
	         },
	         error:function(data){
	        	if(RTAUtil.initFlag){
		            alert("访问服务器出错");  
		            RTAUtil.initFlag=false;
	        	}
	         }
	    });
	},
	format2HHMMSS:function (obj){       
        return obj.getHours()+":"+obj.getMinutes()+":"+obj.getSeconds();
    },
    echartSetOption:function(myChart,option){
    	myChart.setOption(option);
    }
};


(function(){
    var defaultInd = 0;
    var list = $('#js_ban_content').children();
    var count = 0;
    var change = function(newInd, callback){
        if(count) return;
        count = 2;
        $(list[defaultInd]).fadeOut(400, function(){
            count--;
            if(count <= 0){
                if(start.timer) window.clearTimeout(start.timer);
                callback && callback();
            }
        });
        $(list[newInd]).fadeIn(400, function(){
            defaultInd = newInd;
            count--;
            if(count <= 0){
                if(start.timer) window.clearTimeout(start.timer);
                callback && callback();
            }
        });
    }
    
    var next = function(callback){
        var newInd = defaultInd + 1;
        if(newInd >= list.length){
            newInd = 0;
        }
        change(newInd, callback);
    }
    
    var start = function(){
        if(start.timer) window.clearTimeout(start.timer);
        start.timer = window.setTimeout(function(){
            next(function(){
                start();
            });
        }, 3000);
    }
    
    //start();
    
    $('#js_ban_button_box').on('click', 'a', function(){
        var btn = $(this);
        if(btn.hasClass('right')){
            //next
            next(function(){
                start();
            });
        }
        else{
            //prev
            var newInd = defaultInd - 1;
            if(newInd < 0){
                newInd = list.length - 1;
            }
            change(newInd, function(){
                start();
            });
        }
        return false;
    });
    
})();


/**
 * 用户登录
 */
function userLogin(){
    $('#errorNotice').html('');
    //登陆
    var ajax_data = $('#loginform').serialize();
    var username = $("form[name='loginform'] input[name='username']").val();
    var password = $("form[name='loginform'] input[name='password']").val();
    var verify = $("form[name='loginform'] input[name='verify']").val();
    if(username==''){
        $('#errorNotice').html('请输入用户名');
        return ;
    }
    if(password==''){
        $('#errorNotice').html('请输入密码');
        return ;
    }

    //登陆
    $.ajax({
        type: "POST",
        url: 'login_check.do',
        data: ajax_data,
        dataType: "json",
        success: function(data){
            //alert(data.message);
            //var row = eval("("+data+")");
            var row = data;

            if(row.url == null || row.url == 'undefined') {
                if(row.errorMsg == null || row.errorMsg == 'undefined') {
                    $('#errorNotice').html('未知登陆错误');
                    //$('#username').val('');
                    //$('#password').val('');
                } else {
                    $('#errorNotice').html(row.errorMsg);
                    //$('#password').val('');
                }
            } else {
                window.location = row.url;
            }
           
        }
    });
}
//更换验证码
function changeImg(){
	$('#imgObj').src = 	$('#imgObj').src;

	
}



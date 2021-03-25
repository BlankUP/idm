<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<head>
    <title>中银富登智能决策管理平台-登录</title>
 
    
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/login.css" />
    <script src="<%=request.getContextPath()%>/public/jquery/jquery.min.js"></script>
</head>

<body>
<div id='ccc' class="wrap" style="" >


<div class="zhongyinlogo"><h1 class="word-p">智能决策管理平台</h1></div>



<!--  <div class="pos">
 <div  class="pos-c"> -->
        <!-- 登录框  -->
     <div class="login-box"  ><br>
    
    <div class="login-box-p">
            <div class="login-slogan">用户登录</div><br><br>
            <form class="form-horizontal" role="form" id="loginform" name="loginform" id='loginform' method="post" onkeydown="if(event.keyCode==13)userLogin();" >
            <div class="login-form cell">
                <div id='errorNotice'></div>
               <div class="control-group">
              <!--   <label class="control-label" for="inputEmail"><i class="fa fa-user"></i> 用户名：</label> -->
                <div class="controls">
                  <input class="form-control-username" id ="username" name="username" type="text" id="inputEmail" required=""  placeholder="请输入用户名">
                </div>
              </div>
              <div class="control-group">
             <!--    <label class="control-label" ><i class="fa fa-lock"></i> 密&emsp;码：</label> -->
                <div class="controls">
                  <input type="password" class="form-control" id ="password" name="password" required=""  placeholder="请输入密码">
                </div>
              </div>
              
              <%-- <div class="control-group">
             <!--    <label class="control-label" ><i class="fa fa-lock"></i> 密&emsp;码：</label> -->
                <div class="controls">
                  <input type="text" class="form-control" id ="imageCode" name="imageCode" required=""  placeholder="验证码" maxlength="4">
                  <img id="imgObj" title="" src="<%=request.getContextPath()%>/drawImage" onclick="changeImg()" />
                  <a href="" οnclick="changeImg()"><font size="1" face="arial" color="red">看不清，换一张</font></a>
                </div>
              </div> --%>
                  <div class="control-group-b">
                        <button type="button" class="btn btn-success btn-block" onclick="userLogin()" name="submitbutton" >登 录</button>
                  </div> 
                  
                  
              </div>
            </form>
            </div>
            </div>
            <div class="bottom-detail"><font color="#FFFFFF">版权信息 中银富登版权所有</font></div>
       <!--  </div>
        </div> -->
</div>
<script type="text/javascript">
var ss;
var ff
window.onload=function()
{
var w=document.documentElement.clientWidth ;//可见区域宽度
var h=document.documentElement.clientHeight;//可见区域高度
ss=document.getElementById('ccc');
//alert(w);

ss.style.height=h+"px";
}
/* window.onload=function()
{
	var w=document.documentElement.clientWidth ;//可见区域宽度
	var h=document.documentElement.clientHeight;//可见区域高度
   ff=document.getElementById('ddd');
   alert(h);
   ff.style.height=h+"px";
} */
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/login.js"></script>
</div>
</body>
</html>
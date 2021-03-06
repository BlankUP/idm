<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<style>
	.dropdown-submenu {
		position: relative;
	}
	.dropdown-submenu > .dropdown-menu {
		top: 0;
		left: 100%;
		margin-top: -6px;
		margin-left: -1px;
		-webkit-border-radius: 0 6px 6px 6px;
		-moz-border-radius: 0 6px 6px;
		border-radius: 0 6px 6px 6px;
	}
	.dropdown-submenu:hover > .dropdown-menu {
		display: block;
	}
	.dropdown-submenu > a:after {
		display: block;
		content: " ";
		float: right;
		width: 0;
		height: 0;
		border-color: transparent;
		border-style: solid;
		border-width: 5px 0 5px 5px;
		border-left-color: #ccc;
		margin-top: 5px;
		margin-right: -10px;
	}
	.dropdown-submenu:hover > a:after {
		border-left-color: #fff;
	}
	.dropdown-submenu.pull-left {
		float: none;
	}
	.dropdown-submenu.pull-left > .dropdown-menu {
		left: -100%;
		margin-left: 10px;
		-webkit-border-radius: 6px 0 6px 6px;
		-moz-border-radius: 6px 0 6px 6px;
		border-radius: 6px 0 6px 6px;
	}
</style>
	
      <div class="navbar navbar-fixed-top" style="width: 100%">
      <div class="navbar-emp" style="padding-right: 5px;">
        <div class="container-fluid">
          <a class="brand-tittle" href="javascript:void(0)" style="padding-left: 5px;">中银富登智能决策管理平台</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
               	 <font color="#fff">${user.userId}！ 欢迎你！ </font>
              <a href="#" onclick="openUpdatePassword()" class="navbar-link"> 修改密码 </a>|<a href="<%=request.getContextPath()%>/logout" class="navbar-link"> 注销 </a>
            </p>
              <ul id="navbar" class="nav">
              	<li><a href="<%=request.getContextPath()%>/home"><i class="fa fa-home active"></i> 首页</a></li>
              </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
</div>

<div id="updatePassword" class="modal hide fade" style="width:400px;" >
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span  style="color: #f5f5f5;">修改密码</span></h3>
	  </div>	
	  <div class="modal-body">
		<form id="updatePasswordFrom" class="form-horizontal">
						<table cellpadding="2px" >
							<tr> 
								<td style="width: 80px;">新的密码</td>
								<td style="width: 300px;">
									<input id="c_password" type="text"   name="password">
								</td>
							</tr>
							<tr>
								<td style="width: 80px;">重新输入</td>
								<td style="width: 300px;">
									<input id="d_password" type="text"  name="d_password">
								</td>
							</tr>
						</table>
					</form>
	  </div>
	  <div class="modal-footer">
	    <a href="javascript:void(0)" class="btn btn-info" onclick="updatePassword()"><i class="fa fa-save"></i> 确 定</a>
	    <a href="javascript:void(0)" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
	  </div>
	</div>
	
<script type="text/javascript">

var root='<%=request.getContextPath()%>';
	 
function openUpdatePassword() {
	$('#updatePassword').modal('show');
}

/*
var validator = null;
$(document).ready(function() {
	validator = $("#updatePasswordFrom").validate({
		rules : {
			password : {
				required : true,
				rangelength : [ 0, 20 ]
			},
			d_password : {
				required : true
			}
		},
		focusCleanup : true
	});
});
*/

/**
 * 修改信息
 * 
 * @param el
 * @param method
 */
function updatePassword() {
//	if($("#updatePasswordFrom").valid()){
		var data = $('#updatePasswordFrom').serialize();
		var pass = $('#c_password').val();
		var again = $('#d_password').val();
		if (pass == null ||pass == "") {
			alert("密码输入不可为空！");
			return false;
		}
		
		if (again == null ||again == "") {
			alert("密码确认不可为空！");
			return false;
		}
		
		if (again != pass) {
			alert("两次密码输入不一致！");
			return false;
		}
		$.ajax({
			type : 'post',
			url : root + '/user_update_password.do',
			data : data,
			success : function(msg) {
				if (msg.success) {
					alert("保存成功！"); // 弹出成功msg
					// 刷新表格数据
					parent.$('#updatePassword').modal('hide');
				} else {
					alert("保存失败:" + msg); // 弹出失败msg
				}
			},
			error : function(msg) {
				alert("访问服务器出错");
			}
		});
//	}
}


</script>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>JUNLYCMS后台登录</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<!-- load css -->
	<link rel="stylesheet" type="text/css" href="${basePath}/js/common/layer/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="${basePath}/css/login.css" media="all">
</head>
<body>
<div class="layui-canvs"></div>
<div class="layui-layout layui-layout-login">
	<h1>
		 <strong>JUNLYCMS管理系统后台</strong>
		 <em>Management System</em>
	     <div class="error"><span id="errortext">用户名密码错误</span></div>
	</h1>
	
	<div class="layui-user-icon larry-login">
		 <input type="text" placeholder="账号" class="login_txtbx" id="username"/>
	</div>
	<div class="layui-pwd-icon larry-login">
		 <input type="password" placeholder="密码" class="login_txtbx"  id="password" />
	</div>
    <div class="layui-val-icon larry-login">
    	<div class="layui-code-box">
    		<input type="text" id="code" name="code" placeholder="验证码" maxlength="4" class="login_txtbx">
            <img src="images/verifyimg.png" alt="" class="verifyImg" id="verifyImg" onclick="javascript:this.src='xxx'+Math.random();">
    	</div>
    </div>
    <div class="layui-submit larry-login">
    	<input type="button" value="立即登陆" class="submit_btn"/>
    </div>
    <div class="layui-login-text">
    	<p>© 2016-2017 Larry 版权所有</p>
        <p>浙xxxxxx <a href="http://www.baidu.com" title="">baidu.com</a></p>
    </div>
</div>
<script type="text/javascript" src="${basePath}/js/common/layer/lay/dest/layui.all.js"></script>
<script type="text/javascript" src="${basePath}/js/login/login.js"></script>
<script type="text/javascript" src="${basePath}/js/login/MD5.js"></script>
<script type="text/javascript" src="${basePath}/js/jsplug/jparticle.jquery.js"></script>
<script type="text/javascript">
$(function(){
	$(".layui-canvs").jParticle({
		background: "#141414",
		color: "#E6E6E6"
	});
	//登录链接测试，使用时可删除
	$(".submit_btn").click(function(){
         var username = $('#username').val();
	    var password = $('#password').val();
	     if(username == '') {
	      $('#errortext').text("用户不能为空");
           $('.error').fadeIn('fast', function(){
               
                $('.error').css('top', '27px').show();
            });
            $('.error').fadeOut('fast', function(){
                $('#username').focus();
            });
            
            return false;
	    }
        if(password == '') {
           $('#errortext').text("密码不能为空");
            $('.error').fadeOut('fast', function(){
                $('.error').css('top', '96px').show();
            });
            $(this).find('.error').fadeIn('fast', function(){
                $('#password').focus();
            });
            return false;
        }
        
      var pswd = MD5(username +"#" + password),
      data = {pswd:pswd,email:username};  
       var load = layer.load();
        $.post("${basePath}/user/submitLogin",data ,function(result){
        	layer.close(load);
    		if(result && result.status != 200){
    			layer.msg(result.message,function(){});
    			$('#password').val('');
    			return;
    		}else{
    			layer.msg('登录成功！');
    			setTimeout(function(){
    				//登录返回
	    			window.location.href= result.back_url || "${basePath}/user/index";
    			},1000)
    		}
    	},"json");
       
	});
});
</script>
</body>
</html>
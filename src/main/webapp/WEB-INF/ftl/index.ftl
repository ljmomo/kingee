<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>JUNYYCMS后台管理</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<!-- load css -->
	<link rel="stylesheet" type="text/css" href="${basePath}/js/common/layer/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="${basePath}/css/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="${basePath}/css/adminstyle.css" media="all">
</head>
<body>
<div class="layui-layout layui-layout-admin" id="layui_layout">
	<!-- 顶部区域 -->
    <@_top.top 1/>

	<!-- 左侧侧边导航开始 -->
	  <@_left.left 1/>
	<!-- 左侧侧边导航结束 -->
	<!-- 右侧主体内容 -->
	<div class="layui-body" id="larry-body" style="bottom: 0;border-left: solid 2px #1AA094;">
		<div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab" lay-filter="demo" lay-allowclose="true">
			<ul class="layui-tab-title">
				<li class="layui-this" id="admin-home"><i class="iconfont icon-diannao1"></i><em>后台首页</em></li>
			</ul>
			<div class="layui-tab-content" style="min-height: 150px; ">
				<div class="layui-tab-item layui-show">
					<iframe class="larry-iframe" data-id='0' src="main.html"></iframe>
				</div>
			</div>
		</div>

        
	</div>
	<!-- 底部区域 -->
	<div class="layui-footer layui-larry-foot" id="larry-footer">
		<div class="layui-mian">
		    <div class="larry-footer-left">
		    	LarryCMS QQ群：
		    	<a href="https://jq.qq.com/?_wv=1027&k=42fC4vT"><img border="0" src="${basePath}/images/group.png" title="LarryCMS官方交流群"></a>
		    	 查看:<a href="http://www.qinshouwei.com" title="">作者信息</a>
		    </div>
		    <p class="p-admin">
		    	<span>2016 &copy;</span>
		    	Write by Larry,<a href="http://www.larrycms.com">LarryCMS</a>. 版权所有
		    	前端框架layui，下载地址：www.layui.com
		    </p>
		</div>
	</div>
</div>
<!-- 加载js文件-->
	<script type="text/javascript" src="${basePath}/js/common/layer/layui.js"></script> 
	<script type="text/javascript" src="${basePath}/js/larry.js"></script>
	<script type="text/javascript" src="${basePath}/js/index.js"></script>
<!-- 锁屏 -->
<div class="lock-screen" style="display: none;">
	<div id="locker" class="lock-wrapper">
		<div id="time"></div>
		<div class="lock-box center">
			<img src="${basePath}/images/userimg.jpg" alt="">
			<h1>admin</h1>
			<duv class="form-group col-lg-12">
				<input type="password" placeholder='锁屏状态，请输入密码解锁' id="lock_password" class="form-control lock-input" autofocus name="lock_password">
				<button id="unlock" class="btn btn-lock">解锁</button>
			</duv>
		</div>
	</div>
</div>
<!-- 菜单控件 -->
<!-- <div class="larry-tab-menu">
	<span class="layui-btn larry-test">刷新</span>
</div> -->
<!-- iframe框架刷新操作 -->
<!-- <div id="refresh_iframe" class="layui-btn refresh_iframe">刷新</div> -->
</body>
</html>
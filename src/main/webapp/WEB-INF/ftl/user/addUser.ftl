<head>
	<meta charset="UTF-8">
	<title>个人信息</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<link rel="stylesheet" type="text/css" href="${basePath}/js/common/layer/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="${basePath}/css/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="${basePath}/js/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="${basePath}/css/personal.css" media="all">
</head>
<body>
          
<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit">
			<span>个人信息</span>
		</header><!-- /header -->
		<div class="larry-personal-body clearfix">
			<form class="layui-form col-lg-5" action="${basePath}/user/saveUser" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">用户名</label>
					<div class="layui-input-block">  
						<input type="text" name="username" lay-verify="required" autocomplete="off"  class="layui-input " placeholder="请输入用户名"  >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">手机号码</label>
					<div class="layui-input-block">
						<input type="password" name="password"  autocomplete="off"  class="layui-input" placeholder="输入手机号码">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-block">
						<input type="radio" name="sex" value="男" title="男" checked=""><div class="layui-unselect layui-form-radio layui-form-radioed"><i class="layui-anim layui-icon"></i><span>男</span></div>
						<input type="radio" name="sex" value="女" title="女"><div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><span>女</span></div>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">修改头像</label>
					<div class="layui-input-block">
						<input type="file" name="file" class="layui-upload-file">
					</div>
				</div>

				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
<script type="text/javascript" src="${basePath}/js/common/layer/layui.js"></script> 

<script type="text/javascript">
         
        var index = parent.layer.getFrameIndex(window.name);
        <#if result??>
	        var success = '${result.status}';
	        if ( success == '200' ) {
	            parent.$("#handle_status").val('1');
	              parent.layer.close(index);
	        } else {
	            parent.$("#handle_status").val('2');
	            parent.layer.close(index);
	        }
	        <#else>
        </#if>
    </script>
    
    
<script type="text/javascript">
	layui.use(['form','upload'],function(){
         var form = layui.form();
         layui.upload({ 
             url: '' ,//上传接口 
             success: function(res){
              //上传成功后的回调 
              console.log(res) 
            } 
         });
         
         //监听提交
		 // form.on('submit(demo1)', function(data){
		 //  layer.alert(JSON.stringify(data.field), {
		  //    title: '最终的提交信息'
		  // })
		  // layer.closeAll();
		  // return false;
		 //});

	});
</script>
</body>
</html>
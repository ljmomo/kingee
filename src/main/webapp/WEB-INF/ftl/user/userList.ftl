<!DOCTYPE html>
<html lang="en">
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
	    <div class="layui-tab" id ="LAY_demo" >
            <blockquote class="layui-elem-quote mylog-info-tit">
               <button data-method="offset" data-type="auto" class="layui-btn" >添加</button>
               <button data-method="offset" data-type="auto" class="layui-btn" >修改</button>
            </blockquote>
            <div class="larry-separate"></div>
		    <div class="layui-tab-content larry-personal-body clearfix mylog-info-box">
		         <!-- 操作日志 -->
                <div class="layui-tab-item layui-field-box layui-show">
                     <table class="layui-table table-hover" lay-even="" lay-skin="nob">
                          <thead>
                              <tr>
                                  <th><input type="checkbox" id="selected-all"></th>
                                  <th>ID</th>
                                  <th>昵称</th>
                                  <th>邮箱</th>
                                  <th>密码</th>
                                  <th>创建时间</th>
                                  <th>最后登录时间</th>
                                  <th>状态</th>
                              </tr>
                          </thead>
                          <tbody>
                             
						    <#list userList as user>
                                <tr>
                                <td><input type="checkbox"></td>
                                <td>${user.id}</td>
                                <td>${user.nickname}</td>
                                <td>${user.email}</td>
                                <td>${user.pswd}</td>
                                <td>${user.createTime?string('yyyy-MM-dd HH:mm')}</td>
                                <td>${user.lastLoginTime?string('yyyy-MM-dd HH:mm')}</td>
                                   <td>
                                      <#if user.status==1>
                                                                                                                                   
                                        <li class="layui-btn layui-this"><i class="layui-icon">&#xe60a;</i>有效</li>       
                                       <#else>
                                             <li class="layui-btn layui-this"><i class="layui-icon">&#xe60a;</i>被禁用</li>                                                        
                                      </#if>
                                   </td>
                              </tr>
							</#list>
                          </tbody>
                     </table>
                     <div class="larry-table-page clearfix">
                          <a href="javascript:;" class="layui-btn layui-btn-small"><i class="iconfont icon-shanchu1"></i>删除</a>
				          <div id="page" class="page"></div>
			         </div>
			    </div>
			     <!-- 登录日志 -->
			    <div class="layui-tab-item layui-field-box">
			          <table class="layui-table table-hover" lay-even="" lay-skin="nob">
                           <thead>
                              <tr>
                                  <th><input type="checkbox" id="selected-all"></th>
                                  <th>ID</th>
                                  <th>管理员账号</th>
                                  <th>状态</th>
                                  <th>最后登录时间</th>
                                  <th>上次登录IP</th>
                                  <th>登录IP</th>
                                  <th>IP所在位置</th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <td><input type="checkbox"></td>
                                <td>110</td>
                                <td>admin</td>
                                <td>后台登录成功</td>
                                <td>2016-12-19 14:26:03</td>
                                <td>127.0.0.1</td>
                                <td>127.0.0.1</td>
                                <td>Unknown</td>
                              </tr>
                            </tbody>
			          </table>
			          <div class="larry-table-page clearfix">
                          <a href="javascript:;" class="layui-btn layui-btn-small"><i class="iconfont icon-shanchu1"></i>删除</a>
				          <div id="page2" class="page"></div>
			         </div>
			    </div>
		    </div>
		</div>
	</div>
	<input id="handle_status" value="" hidden="hidden">
</section>
<script type="text/javascript" src="${basePath}/js/common/layer/layui.js"></script> 
<script type="text/javascript" src="${basePath}/js/common/bootstrap/js/bootstrap.js"></script> 
<script type="text/javascript">
	layui.use(['jquery','layer','element','laypage'],function(){
	      window.jQuery = window.$ = layui.jquery;
	      window.layer = layui.layer;
          var element = layui.element(),
          laypage = layui.laypage;
          var pageNum = ${page.pageNum};
          laypage({
					cont: 'page',
					pages: ${page.totalPage} //总页数
						,
					groups: 5 //连续显示分页数
						,
                    curr: pageNum,	
                    hash: true,
					jump: function(obj, first) {
						//得到了当前页，用于向服务端请求对应数据
						var curr = obj.curr;
						if(!first) {
							//layer.msg('第 '+ obj.curr +' 页');
							location.href='${basePath}/user/userList?pageNum='+obj.curr;
						}
					},
					
				});
				
			  
			  	//-----
			  	//触发事件
  var active = {
    setTop: function(){
      var that = this; 
      //多窗口模式，层叠置顶
      layer.open({
        type: 2 //此处以iframe举例
        ,title: '当你选择该窗体时，即会在最顶端'
        ,area: ['390px', '260px']
        ,shade: 0
        ,maxmin: true
        ,offset: [ //为了演示，随机坐标
          Math.random()*($(window).height()-300)
          ,Math.random()*($(window).width()-390)
        ] 
        ,content: '${basePath}/user/index'
        ,btn: ['继续弹出', '全部关闭'] //只是为了演示
        ,yes: function(){
          $(that).click(); 
        }
        ,btn2: function(){
          layer.closeAll();
        }
        
        ,zIndex: layer.zIndex //重点1
        ,success: function(layero){
          layer.setTop(layero); //重点2
        }
      });
    }
    ,confirmTrans: function(){
      //配置一个透明的询问框
      layer.msg('大部分参数都是可以公用的<br>合理搭配，展示不一样的风格', {
        time: 20000, //20s后自动关闭
        btn: ['明白了', '知道了', '哦']
      });
    }
    ,notice: function(){
      //示范一个公告层
      layer.open({
        type: 1
        ,title: false //不显示标题栏
        ,closeBtn: false
        ,area: '300px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
        ,btn: ['火速围观', '残忍拒绝']
        ,moveType: 1 //拖拽模式，0或者1
        ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">你知道吗？亲！<br>layer ≠ layui<br><br>layer只是作为Layui的一个弹层模块，由于其用户基数较大，所以常常会有人以为layui是layerui<br><br>layer虽然已被 Layui 收编为内置的弹层模块，但仍然会作为一个独立组件全力维护、升级。<br><br>我们此后的征途是星辰大海 ^_^</div>'
        ,success: function(layero){
          var btn = layero.find('.layui-layer-btn');
          btn.css('text-align', 'center');
          btn.find('.layui-layer-btn0').attr({
            href: 'http://www.layui.com/'
            ,target: '_blank'
          });
        }
      });
    }
    ,offset: function(othis){
      var type = othis.data('type')
      ,text = othis.text();
      
      layer.open({
        type: 2
        ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
        ,id: 'LAY_demo'+type //防止重复弹出
        ,area: ['680px', '480px']
        ,content: '${basePath}/user/addUser'
        //,btn: '关闭全部'
        ,btnAlign: 'c' //按钮居中
        ,shade: 0 //不显示遮罩
        ,yes: function(){
          layer.closeAll();
        },
         end:function(){
            var handle_status = $("#handle_status").val();
            if ( handle_status == '1' ) {
                layer.msg('添加成功！',{
                    icon: 1,
                    time: 2000 //2秒关闭（如果不配置，默认是3秒）
                },function(){
                    history.go(0);
                });
            } else if ( handle_status == '2' ) {
                layer.msg('添加失败！',{
                    icon: 2,
                    time: 2000 //2秒关闭（如果不配置，默认是3秒）
                },function(){
                    history.go(0);
                });
            }
        }
      });
    }
  };
    //---	
	$('#LAY_demo .layui-btn').on('click', function(){
	    var othis = $(this), method = othis.data('method');
	    active[method] ? active[method].call(this, othis) : '';
	  });

    });
</script>
</body>
</html>
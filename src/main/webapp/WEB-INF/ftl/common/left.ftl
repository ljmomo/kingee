<#macro left index>
<div class="layui-side layui-side-bg layui-larry-side" id="larry-side">
        <div class="layui-side-scroll" id="larry-nav-side" lay-filter="side">
		<div class="user-photo">
			<a class="img" title="我的头像" >
				<img src="${basePath}/images/user.jpg" class="userimg1"></a>
			<p>你好！admin, 欢迎登录</p>
		</div>
		<!-- 左侧菜单 -->
		<ul class="layui-nav layui-nav-tree">
			<li class="layui-nav-item layui-this">
				<a href="javascript:;" data-url="main.html">
				    <i class="iconfont icon-home1" data-icon='icon-home1'></i>
					<span>后台首页</span>
				</a>
			</li>
			<!-- 个人信息 -->
			<li class="layui-nav-item">
				<a href="javascript:;">
					<i class="iconfont icon-jiaoseguanli" ></i>
					<span>我的面板</span>
					<em class="layui-nav-more"></em>
				</a>
				<dl class="layui-nav-child">
                    <dd>
                        <a href="javascript:;" data-url="${basePath}/user/userInfo">
                            <i class="iconfont icon-geren1" data-icon='icon-geren1'></i>
                            <span>个人信息</span>
                        </a>
                    </dd>
                    <dd>
                        <a href="javascript:;" data-url="changepwd.html">
                            <i class="iconfont icon-iconfuzhi01" data-icon='icon-iconfuzhi01'></i>
                            <span>修改密码</span>
                        </a>
                    </dd>
                    <dd>
                        <a href="javascript:;" data-url="${basePath}/user/userList" id="userInfoTable">
                            <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
                            <span>日志信息</span>
                        </a>
                    </dd>
                </dl>
			</li>
			<!-- 用户管理 -->
			<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont icon-jiaoseguanli2" ></i>
					   <span>用户管理</span>
					   <em class="layui-nav-more"></em>
					</a>
					    <dl class="layui-nav-child">
					    	<dd>
					    		<a href="javascript:;" data-url="userlist.html">
					    		   <i class="iconfont icon-yonghu1" data-icon='icon-yonghu1'></i>
					    		   <span>用户列表</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-jiaoseguanli4" data-icon='icon-jiaoseguanli4'></i>
					    		   <span>角色列表</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-quanxian2" data-icon='icon-quanxian2'></i>
					    		   <span>菜单管理</span>
					    		</a>
					    	</dd>
					    </dl>
			    </li>
			<!-- 内容管理 -->
			<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont icon-wenzhang1" ></i>
					   <span>内容管理</span>
					   <em class="layui-nav-more"></em>
					</a>
					   <dl class="layui-nav-child">
					   	   <dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-lanmuguanli" data-icon='icon-lanmuguanli'></i>
					    		   <span>网站栏目管理</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-wenzhang2" data-icon='icon-wenzhang2'></i>
					    		   <span>所有档案列表</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-icon1" data-icon='icon-icon1'></i>
					    		   <span>待审核的档案</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-word" data-icon='icon-word'></i>
					    		   <span>我发布的文档</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-pinglun1" data-icon='icon-pinglun1'></i>
					    		   <span>评论管理</span>
					    		</a>
					    	</dd>
					    	
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-tags1" data-icon='icon-tags1'></i>
					    		   <span>TAGS管理</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-huishouzhan1" data-icon='icon-huishouzhan1'></i>
					    		   <span>内容回收站</span>
					    		</a>
					    	</dd>
					   </dl>
			   </li>
			
                 <!-- 会员管理 -->
				<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont icon-m-members" ></i>
					   <span>会员管理</span>
					   <em class="layui-nav-more"></em>
					</a>
					<dl class="layui-nav-child">
                           <dd>
                           	   <a href="javascript:;">
					              <i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
					              <span>注册会员列表</span>
					           </a>
                           </dd>
                           <dd>
                           	   <a href="javascript:;">
					              <i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
					              <span>会员留言管理</span>
					           </a>
                           </dd>
                    </dl>
				</li>
				
				<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont icon-shengchengbaogao" ></i>
					   <span>网站维护</span>
					   <em class="layui-nav-more"></em>
					</a>
					   <dl class="layui-nav-child">
                           <dd>
                           	   <a href="javascript:;">
					              <i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
					              <span>网站主题</span>
					           </a>
                           </dd>
                           <dd>
					    		<a href="">
					    		   <i class="iconfont icon-database" data-icon='icon-database'></i>
					    		   <span>数据库管理</span>
					    		</a>
					    	</dd>
					   	    <dd>
					    		<a href="">
					    		   <i class="iconfont icon-shengchengbaogao" data-icon='icon-shengchengbaogao'></i>
					    		   <span>生成页面</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="">
					    		   <i class="iconfont icon-qingchuhuancun" data-icon='icon-qingchuhuancun'></i>
					    		   <span>更新缓存</span>
					    		</a>
					    	</dd>
					    	
					   </dl>
				</li>
				
			<!-- 系统设置 -->
			<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont icon-xitong" ></i>
					   <span>系统设置</span>
					   <em class="layui-nav-more"></em>
					</a>
					    <dl class="layui-nav-child">
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-zhandianpeizhi" data-icon='icon-zhandianpeizhi'></i>
					    		   <span>基本参数设置</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-zhandianguanli1" data-icon='icon-zhandianguanli1'></i>
					    		   <span>多站点管理</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-anquanshezhi" data-icon='icon-anquanshezhi'></i>
					    		   <span>安全设置</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-sms" data-icon='icon-sms'></i>
					    		   <span>短信接口设置</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-iconfuzhi01" data-icon='icon-iconfuzhi01'></i>
					    		   <span>系统日志管理</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    			<i class='iconfont icon-SQLServershujuku' data-icon='icon-SQLServershujuku'></i>
					    			<span>SQL命令行工具</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    			<i class='iconfont icon-xinxicaiji' data-icon='icon-xinxicaiji'></i>
					    			<span>防采集管理</span>
					    		</a>
					    	</dd>
					    </dl>
				</li>
				
				
				
				
				
				
			 <li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont icon-xitong" ></i>
					   <span>商品管理</span>
					   <em class="layui-nav-more"></em>
					</a>
					    <dl class="layui-nav-child">
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-zhandianpeizhi" data-icon='icon-zhandianpeizhi'></i>
					    		   <span>基本参数设置</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-zhandianguanli1" data-icon='icon-zhandianguanli1'></i>
					    		   <span>多站点管理</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-anquanshezhi" data-icon='icon-anquanshezhi'></i>
					    		   <span>安全设置</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-sms" data-icon='icon-sms'></i>
					    		   <span>短信接口设置</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-iconfuzhi01" data-icon='icon-iconfuzhi01'></i>
					    		   <span>系统日志管理</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    			<i class='iconfont icon-SQLServershujuku' data-icon='icon-SQLServershujuku'></i>
					    			<span>SQL命令行工具</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    			<i class='iconfont icon-xinxicaiji' data-icon='icon-xinxicaiji'></i>
					    			<span>防采集管理</span>
					    		</a>
					    	</dd>
					    </dl>
				</li>
				
				<!-- 友链设置 -->
				<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont icon-youqinglianjie"  data-icon='icon-youqinglianjie'></i>
					   <span>友情链接</span>
					</a>
				</li>
		</ul>
	    </div>
	</div>
</#macro>

<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
			<!-- jsp页面布局,导入header -->
			<jsp:include page="header.jsp"/>                    
                
                <link rel="stylesheet" type="text/css" href="css/select2/select2.css"/>
        <link rel="stylesheet" type="text/css" href="css/user_manage.css"/>
        <link rel="stylesheet" type="text/css" href="css/datepicker.css"/>

                <!-- START BREADCRUMB -->
                <ul class="breadcrumb">
                    <li><a href="#">首页</a></li>
                    <li class="active">个人信息</li>
                </ul>
                <!-- END BREADCRUMB -->                                                
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">
                    
                    <div class="row">
                        <div class="col-md-3">
                            
                            <div class="panel panel-default">
                                <div class="panel-body profile" style="background: url('img/backgrounds/wall_1.jpg') 100% 100% / 100% 100%">
                                    <div class="profile-image">
                                        <img src="assets/images/users/no-image.png" alt="Nadia Ali"/>
                                    </div>
                                    <div class="profile-data">
                                        <div class="profile-data-name">吴崇辉</div>
                                        <div class="profile-data-title" style="color: #FFF;">Fechon</div>
                                    </div>                                
                                </div>                                
                                <div class="panel-body">                                    
                                    <div class="row">
                                        <div class="col-md-6">
                                            <button class="btn btn-info btn-rounded btn-block"><span class="fa fa-check"></span> 关注</button>
                                        </div>
                                        <div class="col-md-6">
                                            <button class="btn btn-primary btn-rounded btn-block"><span class="fa fa-comments"></span> 私聊</button>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body list-group border-bottom">
                                    <a class="list-group-item"><span class="fa fa-tasks"></span> 任务 <span class="badge badge-default"> +2</span></a>
                                    <a class="list-group-item"><span class="fa fa-frown-o"></span>缺勤天数(未打卡) <span class="badge badge-danger"><%out.print(request.getAttribute("queqin"));%></span></a>
                                    <a class="list-group-item"><span class="fa fa-frown-o"></span>请假天数 <span class="badge badge-danger"><%out.print(request.getAttribute("qingjia"));%></span></a>
                                    <a class="list-group-item"><span class="fa fa-frown-o"></span>早退天数 <span class="badge badge-danger"><%out.print(request.getAttribute("zoatui"));%></span></a>
                                    <a class="list-group-item"><span class="fa fa-frown-o"></span>迟到天数 <span class="badge badge-danger"><%out.print(request.getAttribute("chidao"));%></span></a>
                                    <a class="list-group-item"><span class="fa fa-lightbulb-o"></span> 外勤天数 <span class="badge badge-info"><%out.print(request.getAttribute("waiqin"));%></span></a>
                                    <a class="list-group-item"><span class="fa fa-cog"></span> 职务 <span class="badge badge-info"><%out.print(request.getAttribute("duty"));%></span></a>
                                    <a class="list-group-item"><span class="fa fa-money"></span>本月薪金 <span class="badge badge-info"> <% out.print(request.getAttribute("salary")); %></span></a>
                                </div>
                                <div class="panel-body">
                                    <h4 class="text-title">部门同事</h4>
                                    <div class="row">
                                        <div class="col-md-4 col-xs-4">
                                            <a href="#" class="friend">
                                                <img src="assets/images/users/no-image.png"/>
                                                <span>方赞潘</span>
                                            </a>                                            
                                        </div>
                                        <div class="col-md-4 col-xs-4">                                            
                                            <a href="#" class="friend">
                                                <img src="assets/images/users/no-image.png"/>
                                                <span>林德欣</span>
                                            </a>                                            
                                        </div>
                                        <div class="col-md-4 col-xs-4">                                            
                                            <a href="#" class="friend">
                                                <img src="assets/images/users/no-image.png"/>
                                                <span>陈俊杰</span>
                                            </a>                                            
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4 col-xs-4">                                            
                                            <a href="#" class="friend">
                                                <img src="assets/images/users/no-image.png"/>
                                                <span>湛耀</span>
                                            </a>                                            
                                        </div>
                                        <div class="col-md-4 col-xs-4">                                            
                                            <a href="#" class="friend">
                                                <img src="assets/images/users/no-image.png"/>
                                                <span>陈俊杰2</span>
                                            </a>                                            
                                        </div>
                                        <div class="col-md-4 col-xs-4">                                            
                                            <a href="#" class="friend">
                                                <img src="assets/images/users/no-image.png"/>
                                                <span>陈俊杰3</span>
                                            </a>                                            
                                        </div>
                                    </div>
                                
                                    <h4 class="text-title">广告</h4>
                                    <div class="gallery" id="links">                                                
                                        <a href="assets/images/gallery/music-1.jpg" title="Music Image 1" class="gallery-item" data-gallery>
                                            <div class="image">
                                                <img src="assets/images/gallery/music-1.jpg" alt="Music Image 1"/>
                                            </div>                                            
                                        </a>
                                        <a href="assets/images/gallery/music-2.jpg" title="Music Image 2" class="gallery-item" data-gallery>
                                            <div class="image">
                                                <img src="assets/images/gallery/music-2.jpg" alt="Music Image 2"/>
                                            </div>                                            
                                        </a>
                                        <a href="assets/images/gallery/music-3.jpg" title="Music Image 3" class="gallery-item" data-gallery>
                                            <div class="image">
                                                <img src="assets/images/gallery/music-3.jpg" alt="Music Image 3"/>
                                            </div>                                            
                                        </a>
                                        <a href="assets/images/gallery/nature-1.jpg" title="Nature Image 1" class="gallery-item" data-gallery>
                                            <div class="image">
                                                <img src="assets/images/gallery/nature-1.jpg" alt="Nature Image 1"/>
                                            </div>                                            
                                        </a>
                                        <a href="assets/images/gallery/nature-2.jpg" title="Nature Image 2" class="gallery-item" data-gallery>
                                            <div class="image">
                                                <img src="assets/images/gallery/nature-2.jpg" alt="Nature Image 2"/>
                                            </div>                                            
                                        </a>
                                        <a href="assets/images/gallery/nature-3.jpg" title="Nature Image 3" class="gallery-item" data-gallery>
                                            <div class="image">
                                                <img src="assets/images/gallery/nature-3.jpg" alt="Nature Image 3"/>
                                            </div>                                            
                                        </a>
                                        <a href="assets/images/gallery/nature-4.jpg" title="Nature Image 4" class="gallery-item" data-gallery>
                                            <div class="image">
                                                <img src="assets/images/gallery/nature-4.jpg" alt="Nature Image 4"/>
                                            </div>                                            
                                        </a>
                                        <a href="assets/images/gallery/nature-5.jpg" title="Nature Image 5" class="gallery-item" data-gallery>
                                            <div class="image">
                                                <img src="assets/images/gallery/nature-5.jpg" alt="Nature Image 5"/>
                                            </div>                                            
                                        </a>                                        
                                    </div>
                                </div>
                            </div>                            
                            
                        </div>
                        
                        <div class="col-md-9">

                            <!-- 薪金计算开始 -->
                            <div class="row">
                                <!-- START PANEL WITH CONTROL CLASSES -->
                                <div class="panel panel-warning panel-hidden-controls">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">薪金计算</h3>
                                        <ul class="panel-controls">
                                            <li><a href="#" class="panel-fullscreen"><span class="fa fa-expand"></span></a></li>
                                            <li><a href="#" class="panel-collapse"><span class="fa fa-angle-down"></span></a></li>
                                            <li><a href="#" class="panel-refresh"><span class="fa fa-refresh"></span></a></li>
                                            <li><a href="#" class="panel-remove"><span class="fa fa-times"></span></a></li>
                                        </ul>                                
                                    </div>
                                    <div class="panel-body">
                                        <p>薪金 = 底薪 + 外派奖金 + 技术等级薪金 - 缺勤次数 * 100</p>
                                        <hr>
                                        <p>外派奖金 = 外派工作薪金 + （工作距离公里量 * 10） + （客户满意度 * 10）</p>
                                        <p>  客户满意度等级分为五星，四星，三星，二星，一星 --- 各自代表为500，400，300，200，100</p>
                                        <p>技术等级分为 A，B，C，D，E --- 各自技术薪金为2500，2000，1500，1000，500</p>
                                        <hr>
                                        <p>  本月份中您的缺勤次数为 0 </p>
                                        <p>  外派奖金 = 5000 + 300 * 10 + 4000</p>
                                        <p>  客户满意度为 四星 </p>
                                        <p>  技术等级为五级</p>
                                        <p><b>您本月份的薪金为 = 4000 + 12000 + 2500 - 0 = 18500</b></p>
                                    </div>                       
                                </div>
                                <!-- END PANEL WITH CONTROL CLASSES -->
                            </div>
                            <!-- 薪金计算结束 -->
														
														<div class="row">
                                <!-- START LINE CHART -->
                                <div class="panel panel-warning panel-hidden-controls">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">工作量与工资统计图</h3>                                
                                    </div>
                                    <div class="panel-body">
                                        <div id="morris-line-example" style="height: 300px;"></div>
                                    </div>
                                </div>
                                <!-- END LINE CHART -->
                            </div>
														
                            <!-- 个人信息开始 -->
                            <div class="row">
                                <!-- START PANEL WITH CONTROL CLASSES -->
                                <div class="panel panel-warning panel-hidden-controls">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">个人信息</h3>
                                        <ul class="panel-controls">
                                            <li><a href="#" class="panel-fullscreen"><span class="fa fa-expand"></span></a></li>
                                            <li><a href="#" class="panel-collapse"><span class="fa fa-angle-down"></span></a></li>
                                            <li><a href="#" class="panel-refresh"><span class="fa fa-refresh"></span></a></li>
                                            <li><a href="#" class="panel-remove"><span class="fa fa-times"></span></a></li>
                                        </ul>                                
                                    </div>
                                    <form action="#" method="POST" class="form-horizontal" role="form" id="profile_form">
                                        <div class="panel-body">
                                            <input type="hidden" name="id" class="form-control" value="">
                                            <div class="form-group">
                                                <label class="control-label col-md-3">姓名</label>
                                                <div class="col-md-7">          
                                                    <div class="input-group">
                                                        <input class="form-control" name="name" placeholder="请输入姓名" type="text">
                                                        <span class="input-group-addon"><span class="fa fa-user"></span></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">分机</label>
                                                <div class="col-md-7">          
                                                    <div class="input-group">
                                                        <input class="form-control" name="extension" placeholder="请输入分机" type="text">
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-phone-alt"></span></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">性别</label>
                                                <div class="col-md-5">
                                                    <label class="radio-inline">
                                                        <input name="sex[]" type="radio" value="男" checked="">
                                                        <span>男</span>
                                                    </label>
                                                    <label class="radio-inline">
                                                        <input name="sex[]" type="radio" value="女">
                                                        <span>女</span>
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">籍贯</label>
                                                <div class="col-md-9">
                                                    <select id="loc_province" name="province" style="width:120px;"></select>
                                                    <select id="loc_city" name="city" style="width:120px; margin-left: 10px"></select>
                                                    <select id="loc_town" name="town" style="width:120px;margin-left: 10px"></select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">学历</label>
                                                <div class="col-md-9">
                                                    <label class="radio-inline">
                                                        <input name="education_background[]" type="radio" value="博士">
                                                        <span>博士</span>
                                                    </label>
                                                    <label class="radio-inline">
                                                        <input name="education_background[]" type="radio" value="硕士">
                                                        <span>硕士</span>
                                                    </label>
                                                    <label class="radio-inline">
                                                        <input name="education_background[]" type="radio" value="本科" checked="">
                                                        <span>本科</span>
                                                    </label>
                                                    <label class="radio-inline">
                                                        <input name="education_background[]" type="radio" value="专科">
                                                        <span>专科</span>
                                                    </label>
                                                    <label class="radio-inline">
                                                        <input name="education_background[]" type="radio" value="高中">
                                                        <span>高中</span>
                                                    </label>
                                                    <label class="radio-inline">
                                                        <input name="education_background[]" type="radio" value="初中">
                                                        <span>初中</span>
                                                    </label>
                                                    <label class="radio-inline">
                                                        <input name="education_background[]" type="radio" value="小学">
                                                        <span>小学</span>
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="form-group">            
                                                <label class="control-label col-md-3">出生日期</label>
                                                <div class="col-md-7">       
                                                    <div class="input-group">
                                                        <input type="text" class="form-control datepicker" value="1994-01-21" name="birthday" placeholder="请输入出生日期">
                                                        <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-3 col-xs-12 control-label">专业</label>
                                                <div class="col-md-7 col-xs-12">             
                                                    <div class="input-group">
                                                        <input type="text" class="form-control" name="major" placeholder="请输入专业" />
                                                        <span class="input-group-addon"><span class="fa fa-book"></span></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>      
                                        <div class="panel-footer">                                
                                            <button class="btn btn-primary pull-right" type="submit">保存</button>
                                        </div>   
                                    </form>                         
                                </div>
                                <!-- END PANEL WITH CONTROL CLASSES -->
                            </div>
                            <!-- 个人信息结束 -->

                            <!-- 修改密码开始 -->
                            <div class="row">
                                <!-- START PANEL WITH CONTROL CLASSES -->
                                <div class="panel panel-warning panel-hidden-controls">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">修改密码</h3>
                                        <ul class="panel-controls">
                                            <li><a href="#" class="panel-fullscreen"><span class="fa fa-expand"></span></a></li>
                                            <li><a href="#" class="panel-collapse"><span class="fa fa-angle-down"></span></a></li>
                                            <li><a href="#" class="panel-refresh"><span class="fa fa-refresh"></span></a></li>
                                            <li><a href="#" class="panel-remove"><span class="fa fa-times"></span></a></li>
                                        </ul>                                
                                    </div>
                                    <form action="#" method="POST" class="form-horizontal" role="form" id="password_form">
                                        <div class="panel-body">
                                            <input type="hidden" name="id" class="form-control" value="">
                                            <div class="form-group">
                                                <label class="control-label col-md-3">原密码</label>
                                                <div class="col-md-7">          
                                                    <div class="input-group">
                                                        <input class="form-control" name="password" placeholder="请输入原密码" type="password">
                                                        <span class="input-group-addon"><span class="fa fa-lock"></span></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">新密码</label>
                                                <div class="col-md-7">          
                                                    <div class="input-group">
                                                        <input class="form-control" name="new_password" placeholder="请输入新密码" type="password">
                                                        <span class="input-group-addon"><span class="fa fa-lock"></span></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">确认密码</label>
                                                <div class="col-md-7">          
                                                    <div class="input-group">
                                                        <input class="form-control" name="confirm_password" placeholder="请输入确认密码" type="password">
                                                        <span class="input-group-addon"><span class="fa fa-lock"></span></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>      
                                        <div class="panel-footer">                                
                                            <button class="btn btn-primary pull-right">保存</button>
                                        </div>       
                                    </form>                     
                                </div>
                                <!-- END PANEL WITH CONTROL CLASSES -->
                            </div>
                            <!-- 修改密码结束 -->
                            
                        </div>
                        
                    </div>

                </div>
                <!-- END PAGE CONTENT WRAPPER -->                                                 
            </div>            
            <!-- END PAGE CONTENT -->
        </div>
        <!-- END PAGE CONTAINER -->

        <!-- MESSAGE BOX-->
        <div class="message-box animated fadeIn" data-sound="alert" id="mb-signout">
            <div class="mb-container">
                <div class="mb-middle">
                    <div class="mb-title"><span class="fa fa-sign-out"></span> Log <strong>Out</strong> ?</div>
                    <div class="mb-content">
                        <p>Are you sure you want to log out?</p>                    
                        <p>Press No if youwant to continue work. Press Yes to logout current user.</p>
                    </div>
                    <div class="mb-footer">
                        <div class="pull-right">
                            <a href="pages-login.html" class="btn btn-success btn-lg">Yes</a>
                            <button class="btn btn-default btn-lg mb-control-close">No</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END MESSAGE BOX-->

        <!-- BLUEIMP GALLERY -->
        <div id="blueimp-gallery" class="blueimp-gallery blueimp-gallery-controls">
            <div class="slides"></div>
            <h3 class="title"></h3>
            <a class="prev">‹</a>
            <a class="next">›</a>
            <a class="close">×</a>
            <a class="play-pause"></a>
            <ol class="indicator"></ol>
        </div>      
        <!-- END BLUEIMP GALLERY -->        
        
        <!-- START PRELOADS -->
        <audio id="audio-alert" src="audio/alert.mp3" preload="auto"></audio>
        <audio id="audio-fail" src="audio/fail.mp3" preload="auto"></audio>
        <!-- END PRELOADS -->          
        
    <!-- START SCRIPTS -->
        <!-- START PLUGINS -->
        <script type="text/javascript" src="js/plugins/jquery/jquery.min.js"></script>
        <script type="text/javascript" src="js/plugins/jquery/jquery-ui.min.js"></script>
        <script type="text/javascript" src="js/plugins/bootstrap/bootstrap.min.js"></script>        
        <!-- END PLUGINS -->

        <!-- START THIS PAGE PLUGINS-->    

        <script type="text/javascript" src="js/plugins/select2/area.js"></script>
        <script type="text/javascript" src="js/plugins/select2/location.js"></script>
        <script type="text/javascript" src="js/plugins/select2/select2.js"></script>
        <script type="text/javascript" src="js/plugins/select2/select2_locale_zh-CN.js"></script>

        <script type="text/javascript" src="js/plugins/bootstrap/bootstrap-datepicker.js"></script>

        <script type="text/javascript" src="js/plugins/jquery-validation/jquery.validate.js"></script> 

        <script type='text/javascript' src='js/plugins/icheck/icheck.min.js'></script>
        <script type="text/javascript" src="js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js"></script>
        
        <script type="text/javascript" src="js/plugins/morris/raphael-min.js"></script>
        <script type="text/javascript" src="js/plugins/morris/morris.min.js"></script>
        
        <script type="text/javascript" src="js/plugins/blueimp/jquery.blueimp-gallery.min.js"></script>

    <script src="js/plugins/tableexport_my/Blob.js"></script>
    <script src="js/plugins/tableexport_my/FileSaver.js"></script>
    <script src="js/plugins/tableexport_my/tableExport.js"></script>        
        <!-- END THIS PAGE PLUGINS-->        

        <!-- START TEMPLATE -->
        <script type="text/javascript" src="js/settings.js"></script>
        
        <script type="text/javascript" src="js/plugins.js"></script>        
        <script type="text/javascript" src="js/actions.js"></script>        
        <!-- END TEMPLATE -->

        <script>            
            document.getElementById('links').onclick = function (event) {
                event = event || window.event;
                var target = event.target || event.srcElement,
                    link = target.src ? target.parentNode : target,
                    options = {index: link, event: event,onclosed: function(){
                        setTimeout(function(){
                            $("body").css("overflow","");
                        },200);                        
                    }},
                    links = this.getElementsByTagName('a');
                blueimp.Gallery(links, options);
            };

            $(function(){
            	
            			Morris.Line({
                    element: 'morris-line-example',
                    data: [
                      { y: '2015-01', salary: 3400, work: 490 },
                      { y: '2015-02', salary: 3212,  work: 365 },
                      { y: '2015-03', salary: 2745,  work: 540 },
                      { y: '2015-04', salary: 2334,  work: 365 },
                      { y: '2015-05', salary: 3445,  work: 440 },
                      { y: '2015-06', salary: 4231,  work: 565 },
                      { y: '2015-07', salary: 3353, work: 290 }
                    ],
                    xkey: 'y',
                    ykeys: ['salary', 'work'],
                    labels: ['工资', '工作量'],
                    resize: true,
                    lineColors: ['#33414E', '#95B75D']
                  });

                  $("#educationBackgroundID").select2({
                      placeholder:"请您选择学历"
                  });
            	
                // 中文的验证 
                jQuery.validator.addMethod("chinese", function(value, element) { 
                var chinese = /^[\u4e00-\u9fa5]+$/; 
                return this.optional(element) || (chinese.test(value)); 
                }, "只能输入中文"); 
                // 密码的验证 
                jQuery.validator.addMethod("password", function(value, element) { 
                var password = /(?!^[0-9]+$)(?!^[a-z]+$)(?!^[^A-z0-9]+$)^.{6,16}$/; 
                return this.optional(element) || (password.test(value)); 
                }, "密码必须为6-16个字母加数字或符号的组合密码"); 
                $("#profile_form").validate({
                    rules: {
                        name: {
                            required : true,
                            chinese : true
                        },
                        extension : {
                            required : true,
                            minlength : 3,
                            maxlength : 3,
                            digits : true
                        },
                        birthday : {
                            required : true,
                            date : true
                        },
                        major : {
                            required : true
                        }
                    },
                    messages: {
                        name: {
                            required : '请您填写姓名',
                            chinese : '姓名必须为中文'
                        },
                        extension : {
                            required : '请您填写分号',
                            minlength : '分号必须为3位数字',
                            maxlength : '分号必须为3位数字',
                            digits : '分号必须为数字'
                        },
                        birthday : {
                            required : '请您选择出生日期',
                            date : '出生日期不正确'
                        },
                        major : {
                            required : '请您填写专业'
                        }
                    },
                    errorPlacement: function(error, element) {  
                      error.appendTo ( element.parent().parent() );  
                      error.addClass ("checkbox-inline");
                    },
                    submitHandler:function(form){
                        if ($("#loc_province").select2('data').text == "省份") {
                            $("#loc_province").parent().append('<label id="loc_province-error" class="error checkbox-inline" for="loc_province">请您选择省份</label>');
                        }else if ($("#loc_city").select2('data').text == "地级市"){
                            $("#loc_city").parent().append('<label id="loc_city-error" class="error checkbox-inline" for="loc_city">请您选择地级市</label>');
                        }else if ($("#loc_town").select2('data').text == "市、县、区"){
                            $("#loc_town").parent().append('<label id="loc_town-error" class="error checkbox-inline" for="loc_town">请您选择市、县、区</label>');
                        }else {
                            $(form).submit();
                        };
                    }
                });

                $("#password_form").validate({
                    rules: {
                        password : {
                            required : true,
                            password : true
                        },
                        new_password : {
                            required : true,
                            password : true
                        },
                        confirm_password : {
                            required : true,
                            equalTo: 'input[name="new_password"]',
                            password : true
                        }
                    },
                    messages: {
                        password : {
                            required : '请您填写密码'
                        },
                        new_password : {
                            required : '请您填写新密码'
                        },
                        confirm_password : {
                            required : '请您填写确认密码',
                            equalTo: '确认密码与新密码要保持一致'
                        }
                    },
                    errorPlacement: function(error, element) {  
                      error.appendTo ( element.parent().parent() );  
                      error.addClass ("checkbox-inline");
                    },
                    submitHandler:function(form){
                        $(form).submit();
                    }
                });


            //省市区
                showLocation();



            })
        </script>        
        
    <!-- END SCRIPTS -->         
    </body>
</html>

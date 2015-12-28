<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String smallTitle = "";
	String name = "";	//用户保存当前用户名
	if( request.getAttribute("smallTitle") != null ){
		smallTitle = request.getAttribute("smallTitle").toString();
	}
	String activeSidebar = "";
	if( request.getAttribute("activeSidebar") != null ){
		activeSidebar = request.getAttribute("activeSidebar").toString();
	}
	String activeClass = "class='active'";
	if (request.getAttribute("name") != null) {
		 name = request.getAttribute("name").toString();	//获取用户姓名
	}
%> 
<!DOCTYPE html>
<html lang="en">
    <head>       
    	<base href="<%=basePath%>"> 
        <!-- META SECTION -->
        <title>诺特考勤管理系统<%=smallTitle%></title>            
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        
        <link rel="icon" href="favicon.ico" type="image/x-icon" />
        <!-- END META SECTION -->
        
        <!-- CSS INCLUDE -->        
        <link rel="stylesheet" type="text/css" id="theme" href="css/theme-default.css"/>
        <!-- EOF CSS INCLUDE -->                                      
        <link rel="stylesheet" type="text/css" href="css/select2/select2_2.css"/>
        <link rel="stylesheet" type="text/css" href="css/user_manage.css"/>
    </head>
    <body>
        <!-- START PAGE CONTAINER -->
        <div class="page-container">
            
            <!-- START PAGE SIDEBAR -->
            <div class="page-sidebar">
                <!-- START X-NAVIGATION -->
                <ul class="x-navigation">
                    <li class="xn-logo">
                        <a href="index.html">TK Admin</a>
                        <a href="#" class="x-navigation-control"></a>
                    </li>
                    <li class="xn-profile">
                        <a href="#" class="profile-mini">
                            <img src="assets/images/users/no-image.png" alt="头像"/>
                        </a>
                        <div class="profile">
                            <div class="profile-image">
                                <img src="assets/images/users/no-image.png" alt="头像"/>
                            </div>
                            <div class="profile-data">
                                <div class="profile-data-name"><% out.print(name); %></div>
                                <div class="profile-data-title">Super Manager</div>
                            </div>
                            <div class="profile-controls">
                                <a href="pages-profile.html" class="profile-control-left"><span class="fa fa-info"></span></a>
                                <a href="pages-messages.html" class="profile-control-right"><span class="fa fa-envelope"></span></a>
                            </div>
                        </div>                                                                        
                    </li>
                    <li <%if(activeSidebar.equals("c")){ out.print(activeClass); } %> >
                        <a href="adminIndex.do">
                            <span class="fa fa-desktop"></span> 
                            <span class="xn-text">控制台</span>
                        </a>                        
                    </li>
                    <security:authorize ifAnyGranted="ROLE_SUPER, ROLE_ADMIN">                    
	                    <li class="xn-openable  <%if(activeSidebar.equals("dm") || activeSidebar.equals("bm") || activeSidebar.equals("pm")){ out.print("active"); } %>">
	                        <a href="#"><span class="fa fa-files-o"></span> <span class="xn-text">管理</span></a>
	                        <ul>
	                            <li <%if(activeSidebar.equals("um")){ out.print(activeClass); } %>><a href="userManage.do"><span class="fa fa-users"></span>员工管理</a></li>
	                            <security:authorize ifAllGranted="ROLE_SUPER"> 
	                            	<li <%if(activeSidebar.equals("dm")){ out.print(activeClass); } %>><a href="departmentManage.do"><span class="fa fa-adn"></span>部门管理</a></li>
	                            	<li <%if(activeSidebar.equals("bm")){ out.print(activeClass); } %>><a href="businessManage.do"><span class="fa fa-credit-card"></span>业务管理</a></li>
	                            	<li <%if(activeSidebar.equals("pm")){ out.print(activeClass); } %>><a href="postManage.do"><span class="fa fa-sitemap"></span>岗位管理</a></li>
	                            </security:authorize>
	                            <li><a href="#"><span class="fa fa-cogs"></span>公告管理</a></li>
	                        </ul>
	                    </li>
                    </security:authorize>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-file-text-o"></span> <span class="xn-text">信息</span></a>
                        <ul>
                            <li><a href="personal.do"><span class="fa fa-info-circle"></span>个人信息</a></li>
                        </ul>
                    </li>
                    <security:authorize ifAllGranted="ROLE_ADMIN"> 
	                    <li class="xn-openable">
	                        <a href="#"><span class="fa fa-cogs"></span> <span class="xn-text">操作</span></a>
	                        <ul>
	                            <li <%if(activeSidebar.equals("em")){ out.print(activeClass); } %>><a href="expatriate.do"><span class="fa fa-heart"></span>外勤任务</a></li>
	                            <li><a href="ui-buttons.html"><span class="fa fa-square-o"></span>请假审批</a></li>   
	                        </ul>
	                    </li>
                    </security:authorize>
                    <security:authorize ifAllGranted="ROLE_EMPLOYEE"> 
	                    <li class="xn-openable">
	                        <a href="#"><span class="fa fa-cogs"></span> <span class="xn-text">操作</span></a>
	                        <ul>
	                            <li><a href="ui-widgets.html"><span class="fa fa-heart"></span>外勤任务</a></li>
	                            <li><a href="ui-buttons.html"><span class="fa fa-square-o"></span>请假申请</a></li>   
	                        </ul>
	                    </li>
                    </security:authorize>
                </ul>
                <!-- END X-NAVIGATION -->
            </div>
            
            <!-- END PAGE SIDEBAR -->
            
            <!-- PAGE CONTENT -->
            <div class="page-content">
                
                <!-- START X-NAVIGATION VERTICAL -->
                <ul class="x-navigation x-navigation-horizontal x-navigation-panel">
                    <!-- TOGGLE NAVIGATION -->
                    <li class="xn-icon-button">
                        <a href="#" class="x-navigation-minimize"><span class="fa fa-dedent"></span></a>
                    </li>
                    <!-- END TOGGLE NAVIGATION -->
                    <!-- SEARCH -->
                    <li class="xn-search">
                        <form role="form">
                            <input type="text" name="search" placeholder="Search..."/>
                        </form>
                    </li>   
                    <!-- END SEARCH -->
                    <!-- SIGN OUT -->
                    <li class="xn-icon-button pull-right">
                        <a href="#" class="mb-control" data-box="#mb-signout"><span class="fa fa-sign-out"></span></a>                        
                    </li> 
                    <!-- END SIGN OUT -->
                    <!-- MESSAGES -->
                    <li class="xn-icon-button pull-right">
                        <a href="#"><span class="fa fa-comments"></span></a>
                        <div class="informer informer-danger">4</div>
                        <div class="panel panel-primary animated zoomIn xn-drop-left xn-panel-dragging">
                            <div class="panel-heading">
                                <h3 class="panel-title"><span class="fa fa-comments"></span> 消息提醒</h3>                                
                                <div class="pull-right">
                                    <span class="label label-danger">4 条新消息</span>
                                </div>
                            </div>
                            <div class="panel-body list-group list-group-contacts scroll" style="height: 200px;">
                                <a href="#" class="list-group-item">
                                    <div class="list-group-status status-online"></div>
                                    <img src="assets/images/users/no-image.png" class="pull-left" alt="头像"/>
                                    <span class="contacts-title">陈俊杰</span>
                                    <p>奥巴马前来邀请赴国际会议。</p>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="list-group-status status-away"></div>
                                    <img src="assets/images/users/no-image.png"" class="pull-left" alt="头像"/>
                                    <span class="contacts-title">吴崇辉</span>
                                    <p>阿尔法量产跑车三号工作线出现故障。</p>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="list-group-status status-away"></div>
                                    <img src="assets/images/users/no-image.png" class="pull-left" alt="头像"/>
                                    <span class="contacts-title">湛耀</span>
                                    <p>本拉登前来商讨恐怖事件。</p>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="list-group-status status-offline"></div>
                                    <img src="assets/images/users/no-image.png" class="pull-left" alt="头像"/>
                                    <span class="contacts-title">方赞潘</span>
                                    <p>中国好声音邀请您加盟导师。</p>
                                </a>
                            </div>     
                            <div class="panel-footer text-center">
                                <a href="#">显示所有消息</a>
                            </div>                            
                        </div>                        
                    </li>
                    <!-- END MESSAGES -->
                    <!-- TASKS -->
                    <li class="xn-icon-button pull-right">
                        <a href="#"><span class="fa fa-tasks"></span></a>
                        <div class="informer informer-warning">3</div>
                        <div class="panel panel-primary animated zoomIn xn-drop-left xn-panel-dragging">
                            <div class="panel-heading">
                                <h3 class="panel-title"><span class="fa fa-tasks"></span> 任务提醒</h3>                                
                                <div class="pull-right">
                                    <span class="label label-warning">3 条任务进行中</span>
                                </div>
                            </div>
                            <div class="panel-body list-group scroll" style="height: 200px;">                                
                                <a class="list-group-item" href="#">
                                    <strong>回家吃饭阿。</strong>
                                    <div class="progress progress-small progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;">50%</div>
                                    </div>
                                    <small class="text-muted">方赞潘, 25 Sep 2014 / 50%</small>
                                </a>
                                <a class="list-group-item" href="#">
                                    <strong>治愈非典2.0</strong>
                                    <div class="progress progress-small progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">80%</div>
                                    </div>
                                    <small class="text-muted">湛耀, 24 Sep 2014 / 80%</small>
                                </a>
                                <a class="list-group-item" href="#">
                                    <strong>权利的游戏拍摄工作。</strong>
                                    <div class="progress progress-small progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="95" aria-valuemin="0" aria-valuemax="100" style="width: 95%;">95%</div>
                                    </div>
                                    <small class="text-muted">林德欣, 23 Sep 2014 / 95%</small>
                                </a>
                                <a class="list-group-item" href="#">
                                    <strong>石油贩卖。</strong>
                                    <div class="progress progress-small">
                                        <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">100%</div>
                                    </div>
                                    <small class="text-muted">陈俊杰, 21 Sep 2014 /</small><small class="text-success"> Done</small>
                                </a>                                
                            </div>     
                            <div class="panel-footer text-center">
                                <a href="#">显示所有任务。</a>
                            </div>                            
                        </div>                        
                    </li>
                    <!-- END TASKS -->
                </ul>
                <!-- END X-NAVIGATION VERTICAL -->    
                
                <!-- MESSAGE BOX-->
		        <div class="message-box animated fadeIn" data-sound="alert" id="mb-signout">
		            <div class="mb-container">
		                <div class="mb-middle">
		                    <div class="mb-title"><span class="fa fa-sign-out"></span> <strong>退 出</strong> ?</div>
		                    <div class="mb-content">
		                        <p>您 真 的 要 退 出 吗?</p>                    
		                        <p>点 击 取 消 将 返 回 ， 继 续 操 作 。 </p>
		                        <p>点 击 确 认 将 退 出 当 前 用 户 。 </p>
		                    </div>
		                    <div class="mb-footer">
		                        <div class="pull-right">
		                            <a href="<c:url value="/j_spring_security_logout"></c:url>" class="btn btn-success btn-lg">确认</a>
		                            <button class="btn btn-default btn-lg mb-control-close">取消</button>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </div>
		        <!-- END MESSAGE BOX--> 
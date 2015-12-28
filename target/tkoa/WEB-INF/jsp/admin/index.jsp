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
			
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
			           
                <!-- START BREADCRUMB -->
                <ul class="breadcrumb">
                    <li><a href="#">首页</a></li>                    
                    <li class="active">控制台</li>
                </ul>
                <!-- END BREADCRUMB -->        
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">
                    
                    <!-- START WIDGETS -->                    
                    <div class="row">
                        <div class="col-md-3">
                            
                            <!-- START WIDGET SLIDER -->
                            <div class="widget widget-default widget-carousel">
                                <div class="owl-carousel" id="owl-example">
                                    <div>                                    
                                        <div class="widget-title">新公告</div>             
                                        <div class="widget-subtitle">Anounces</div>
                                        <div class="widget-int">3,548</div>
                                    </div>
                                    <div>                                    
                                        <div class="widget-title">任务总数</div>
                                        <div class="widget-subtitle">Tasks</div>
                                        <div class="widget-int">1,695</div>
                                    </div>
                                    <!-- <div>                                    
                                        <div class="widget-title">New</div>
                                        <div class="widget-subtitle">Visitors</div>
                                        <div class="widget-int">1,977</div>
                                    </div> -->
                                </div>                            
                                <div class="widget-controls">                                
                                    <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip" data-placement="top" title="隐藏"><span class="fa fa-times"></span></a>
                                </div>                             
                            </div>         
                            <!-- END WIDGET SLIDER -->
                            
                        </div>
                        <div class="col-md-3">
                            
                            <!-- START WIDGET MESSAGES -->
                            <div class="widget widget-default widget-item-icon" onclick="location.href='#';">
                                <div class="widget-item-left">
                                    <span class="fa fa-envelope"></span>
                                </div>                             
                                <div class="widget-data">
                                    <div class="widget-int num-count">48</div>
                                    <div class="widget-title">新消息</div>
                                    <div class="widget-subtitle">New messages</div>
                                </div>      
                                <div class="widget-controls">                                
                                    <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip" data-placement="top" title="隐藏"><span class="fa fa-times"></span></a>
                                </div>
                            </div>                            
                            <!-- END WIDGET MESSAGES -->
                            
                        </div>
                        <div class="col-md-3">
                            
                            <!-- START WIDGET REGISTRED -->
                            <div class="widget widget-default widget-item-icon">
                                <div class="widget-item-left">
                                    <span class="fa fa-user"></span>
                                </div>
                                <div class="widget-data">
                                    <div class="widget-int num-count">375</div>
                                    <div class="widget-title">员工总数</div>
                                    <div class="widget-subtitle">Worker</div>
                                </div>
                                <div class="widget-controls">                                
                                    <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip" data-placement="top" title="隐藏"><span class="fa fa-times"></span></a>
                                </div>                            
                            </div>                            
                            <!-- END WIDGET REGISTRED -->
                            
                        </div>
                        <div class="col-md-3">
                            
                            <!-- START WIDGET CLOCK -->
                            <div class="widget widget-default widget-padding-sm">
                                <div class="widget-big-int plugin-clock">00:00</div>                            
                                <div class="widget-subtitle plugin-date">Loading...</div>
                                <div class="widget-controls">                                
                                    <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip" data-placement="left" title="隐藏"><span class="fa fa-times"></span></a>
                                </div>                            
                                <div class="widget-buttons widget-c3">
                                    <div class="col">
                                        <a href="#"><span class="fa fa-clock-o"></span></a>
                                    </div>
                                    <div class="col">
                                        <a href="#"><span class="fa fa-bell"></span></a>
                                    </div>
                                    <div class="col">
                                        <a href="#"><span class="fa fa-calendar"></span></a>
                                    </div>
                                </div>                            
                            </div>                        
                            <!-- END WIDGET CLOCK -->
                            
                        </div>
                    </div>
                    <!-- END WIDGETS -->      
                    
                    <div class="row">
                    		<security:authorize ifAnyGranted="ROLE_ADMIN, ROLE_EMPLOYEE">
                        <div class="col-md-6">
                            <!-- START PANEL WITH CONTROL CLASSES -->
                            <div class="panel panel-warning panel-toggled">
                                <div class="panel-heading text-center">
                                	<security:authorize ifAnyGranted="ROLE_ADMIN, ROLE_EMPLOYEE">
                                		<!-- 未签到 -->
                                		<s:if test="#request.clockingInFlag==0">
                                			<a href="adminIndex.do" class="btn btn-success" id="clockingInBtn">上班打卡</a>
                                    	<a href="#" class="btn btn-warning" disabled>下班签退</a>
                                		</s:if>
                                		<!-- 已签到，未签退 -->
                                		<s:elseif test="(#request.clockingInFlag==1 || #request.clockingInFlag==2) && #request.clockingOutFlag==0">
                                			<a href="#" class="btn btn-success" disabled>已签到</a>
                                    	<a href="adminIndex.do" class="btn btn-warning" id="clockingOutBtn">下班签退</a>
                                		</s:elseif>
                                		<!-- 已签到，已签退 -->
                                		<s:elseif test="(#request.clockingInFlag==1 || #request.clockingInFlag==2) && (#request.clockingOutFlag==1 || #request.clockingOutFlag==3)">
                                			<a href="#" class="btn btn-success" disabled>已签到</a>
                                    	<a href="#" class="btn btn-warning" disabled>已签退</a>
                                		</s:elseif>
                                		<!-- 已签到，后请假或外勤 -->
                                    <s:elseif test="(#request.clockingInFlag==1 || #request.clockingInFlag==2) && (#request.clockingOutFlag==4 || #request.clockingOutFlag==6)">
                                			<a href="#" class="btn btn-success" disabled>已签到</a>
                                    	<a href="#" class="btn btn-warning" disabled>免签退</a>
                                		</s:elseif>
                                		<!-- 已请假，外勤 -->
                                    <s:elseif test="#request.clockingInFlag==4 || #request.clockingInFlag==6  ">
                                			<a href="#" class="btn btn-success" disabled>免签到</a>
                                    	<a href="#" class="btn btn-warning" disabled>免签退</a>
                                		</s:elseif>
                                    <security:authorize ifAllGranted="ROLE_EMPLOYEE">
                                    	<a href="#" class="btn btn-danger panel-collapse">请假</a>
                                    </security:authorize>
                                  </security:authorize>
                                </div>
                                <form action="" method="POST" class="form-horizontal" role="form">
                                    <div class="panel-body" style="height:266px;">
                                    		<div class="form-group">
                                            <label class="col-md-3 col-xs-12 control-label">请假时间</label>
                                            <div class="col-md-9 col-xs-12">                                            
                                                <input class="form-control" id="startLeave" type="date"/>
                                            </div>
                                            <label class="col-md-3 col-xs-12 control-label">至</label>
                                            <div class="col-md-9 col-xs-12">                                            
                                                <input class="form-control" id="endLeave" type="date"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 col-xs-12 control-label">请假事由</label>
                                            <div class="col-md-9 col-xs-12">                                            
                                                <textarea class="form-control" id="reason" rows="5"></textarea>
                                            </div>
                                        </div>
                                    </div>      
                                    <div class="panel-footer">                                
                                        <button class="btn btn-primary pull-right" id="leaveBtn">提交</button>
                                    </div>    
                                </form>   
                                                
                            </div>
                            <!-- END PANEL WITH CONTROL CLASSES -->
                        </div>
                        </security:authorize>
                        <security:authorize ifAllGranted="ROLE_ANONYMOUS">
                        <div class="col-md-6">
                            <!-- TABS WIDGET -->
                            <div class="panel panel-default tabs">
                                <ul class="nav nav-tabs nav-justified">
                                    <li class="active"><a href="#tab1" data-toggle="tab">公告</a></li>
                                    <li><a href="#tab2" data-toggle="tab">留言板</a></li>
                                </ul>
                                <div class="panel-body tab-content">
                                    <div class="tab-pane active scroll" id="tab1" style="height:300px;">
                                        <p>本系统将于2015-07-12发布V1.0.0版本</p>
                                        <p>©2015 TKOA</p>
                                        <p>本系统将于2015-07-12发布V1.0.0版本</p>
                                        <p>©2015 TKOA</p>
                                        <p>本系统将于2015-07-12发布V1.0.0版本</p>
                                        <p>©2015 TKOA</p>
                                        <p>本系统将于2015-07-12发布V1.0.0版本</p>
                                        <p>©2015 TKOA</p>
                                        <p>本系统将于2015-07-12发布V1.0.0版本</p>
                                        <p>©2015 TKOA</p>
                                        <p>本系统将于2015-07-12发布V1.0.0版本</p>
                                        <p>©2015 TKOA</p>
                                        <p>本系统将于2015-07-12发布V1.0.0版本</p>
                                        <p>©2015 TKOA</p>
                                        <p>本系统将于2015-07-12发布V1.0.0版本</p>
                                        <p>©2015 TKOA</p>
                                        <p>本系统将于2015-07-12发布V1.0.0版本</p>
                                        <p>©2015 TKOA</p>
                                        <p>本系统将于2015-07-12发布V1.0.0版本</p>
                                        <p>©2015 TKOA</p>
                                        <p>本系统将于2015-07-12发布V1.0.0版本</p>
                                        <p>©2015 TKOA</p>
                                    </div>
                                    <div class="tab-pane clearfix" id="tab2">
                                        <div class="scroll" style="height:300px;">
                                            <div class="messages messages-img" id="message_div">
                                                <div class="item in">
                                                    <div class="image">
                                                        <img src="assets/images/users/user2.jpg" alt="John Doe">
                                                    </div>
                                                    <div class="text">
                                                        <div class="heading">
                                                            <a href="#">超级管理员</a>
                                                            <span class="date">上午08:33:17</span>
                                                        </div>
                                                        项目进度20%。
                                                    </div>
                                                </div>
                                                <div class="item">
                                                    <div class="image">
                                                        <img src="assets/images/users/user.jpg" alt="Dmitry Ivaniuk">
                                                    </div>                                
                                                    <div class="text">
                                                        <div class="heading">
                                                            <a href="#">黄经理</a>
                                                            <span class="date">上午08:27:57</span>
                                                        </div>                                    
                                                        干巴爹。
                                                    </div>
                                                </div>
                                                <div class="item in">
                                                    <div class="image">
                                                        <img src="assets/images/users/user2.jpg" alt="John Doe">
                                                    </div>
                                                    <div class="text">
                                                        <div class="heading">
                                                            <a href="#">超级管理员</a>
                                                            <span class="date">上午08:25:10</span>
                                                        </div>
                                                        目前进度为10%，革命尚未成功。
                                                    </div>
                                                </div>                            
                                            </div>  
                                        </div>
                                        <div class="input-group">                                    
                                            <input type="text" class="form-control" placeholder="请您输入内容" id="message_input" />
                                            <span class="input-group-btn">
                                                <button class="btn btn-default" type="button" id="message_submit">发送</button>
                                            </span>                                    
                                        </div>  
                                    </div>                       
                                </div>
                            </div>                        
                            <!-- END TABS WIDGET -->
                        </div>
                    		</security:authorize>
                    </div>
                    
                    
                    <div class="row">
                    	<div class="col-md-12">
                    		<div class="panel">
                    			<div class="panel-heading panel-default panel-hidden-controls">
                    				<h3 class="panel-title">考勤信息列表</h3>
                            <ul class="panel-controls">
                                <li><a href="#" class="panel-fullscreen"><span class="fa fa-expand"></span></a></li>
                                <li><a href="#" class="panel-collapse"><span class="fa fa-angle-up"></span></a></li>
                                <li><a href="#" class="panel-refresh"><span class="fa fa-refresh"></span></a></li>
                                <li><a href="#" class="panel-remove"><span class="fa fa-times"></span></a></li>
                            </ul>
                    			</div>
                    			<div class="panel-body">
                    				<!-- 考勤信息列表开始 -->
                            <table class="table table-hover" id="clockingIn_table">
                            	<security:authorize ifAnyGranted="ROLE_SUPER, ROLE_ADMIN">
                            		<thead>
                             		<tr>
                             			<th>姓名</th>
                             			<th>年</th>
                             			<th>月</th>
                             			<th>日</th>
                             			<th>签到时间</th>
                             			<th>签到情况</th>
                             			<th>签退时间</th>
                             			<th>签退情况</th>
                             		</tr>
                             	</thead>
                             	<tbody>
                             		<security:authorize ifAllGranted="ROLE_SUPER">
                             			<s:iterator id="allclockingIn" value="#request.allclockingIns">
                              			<tr>
                              				<td><s:property value="#allclockingIn.employee.name"/></td>
	                               			<td><s:property value="#allclockingIn.year"/></td>
	                               			<td><s:property value="#allclockingIn.month"/></td>
	                               			<td><s:property value="#allclockingIn.day"/></td>
	                               			<td><s:property value="#allclockingIn.time"/></td>
	                               			<td><s:property value="#allclockingIn.attendType.name"/></td>
	                               			<td><s:property value="#allclockingIn.clockingOut.time"/></td>
	                               			<td><s:property value="#allclockingIn.clockingOut.attendType.name"/></td>
                               		</tr>
                              		</s:iterator>
                             		</security:authorize>
                             		<security:authorize ifAllGranted="ROLE_ADMIN">
                             			<s:iterator id="departmentClockingIn" value="#request.departmentClockingIns">
                              			<tr>
                              				<td><s:property value="#departmentClockingIn.employee.name"/></td>
	                               			<td><s:property value="#departmentClockingIn.year"/></td>
	                               			<td><s:property value="#departmentClockingIn.month"/></td>
	                               			<td><s:property value="#departmentClockingIn.day"/></td>
	                               			<td><s:property value="#departmentClockingIn.time"/></td>
	                               			<td><s:property value="#departmentClockingIn.attendType.name"/></td>
	                               			<td><s:property value="#departmentClockingIn.clockingOut.time"/></td>
	                               			<td><s:property value="#departmentClockingIn.clockingOut.attendType.name"/></td>
                               		</tr>
                              		</s:iterator>
                             		</security:authorize>
                             	</tbody>
                            	</security:authorize>
                            	<security:authorize ifAllGranted="ROLE_EMPLOYEE">
                            		<thead>
                             		<tr>
                             			<th>年</th><th>月</th><th>日</th><th>签到时间</th><th>签到情况</th><th>签退时间</th><th>签退情况</th>
                             		</tr>
                             	</thead>
                             	<tbody>
                             		<s:iterator id="clockingIn" value="#request.clockingIns">
                             			<tr>
	                             			<td><s:property value="#clockingIn.year"/></td>
	                             			<td><s:property value="#clockingIn.month"/></td>
	                             			<td><s:property value="#clockingIn.day"/></td>
	                             			<td><s:property value="#clockingIn.time"/></td>
	                             			<td><s:property value="#clockingIn.attendType.name"/></td>
	                             			<td><s:property value="#clockingIn.clockingOut.time"/></td>
	                             			<td><s:property value="#clockingIn.clockingOut.attendType.name"/></td>
                             			</tr>
                             		</s:iterator>
                             	</tbody>
                            	</security:authorize>
                            </table>    
                            <!-- 考勤信息列表结束 --> 
                    			</div>
                    		</div>
                    	</div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <!-- START SALES BLOCK -->
                            <div class="panel panel-default panel-hidden-controls">
                                <div class="panel-heading">
                                    <div class="panel-title-box tasks_title_div">
                                        <h3><span class="fa fa-tasks"></span>任务查看</h3>
                                        <!-- <a href="#">跳转至任务中心</a> -->
                                    </div>
				                            <ul class="panel-controls">
				                                <li><a href="#" class="panel-fullscreen"><span class="fa fa-expand"></span></a></li>
				                                <li><a href="#" class="panel-collapse"><span class="fa fa-angle-up"></span></a></li>
				                                <li><a href="#" class="panel-refresh"><span class="fa fa-refresh"></span></a></li>
				                                <li><a href="#" class="panel-remove"><span class="fa fa-times"></span></a></li>
				                            </ul>
                                </div>
                                <div class="panel-body">                                    
                                    <div class="row stacked">
                                        <div class="col-md-4 scroll" style="height: 350px;border-right: 1px solid #e0e0e0">
                                            <div class="task_div">
                                                <div class="task_title">
                                                    <span class="fa fa-calendar"></span>8月16日
                                                </div>
                                                <div class="task_content">
                                                    前往伦敦视察斯塔克大厦运营情况。
                                                </div>
                                            </div>
                                            <div class="task_div">
                                                <div class="task_title">
                                                    <span class="fa fa-calendar"></span>8月16日
                                                </div>
                                                <div class="task_content">
                                                    前往伦敦视察斯塔克大厦运营情况。
                                                </div>
                                            </div>
                                            <div class="task_div">
                                                <div class="task_title">
                                                    <span class="fa fa-calendar"></span>8月16日
                                                </div>
                                                <div class="task_content">
                                                    前往伦敦视察斯塔克大厦运营情况。
                                                </div>
                                            </div>
                                            <div class="task_div">
                                                <div class="task_title">
                                                    <span class="fa fa-calendar"></span>8月16日
                                                </div>
                                                <div class="task_content">
                                                    前往伦敦视察斯塔克大厦运营情况。
                                                </div>
                                            </div>
                                            <div class="task_div">
                                                <div class="task_title">
                                                    <span class="fa fa-calendar"></span>8月16日
                                                </div>
                                                <div class="task_content">
                                                    前往伦敦视察斯塔克大厦运营情况。
                                                </div>
                                            </div>
                                            <div class="task_div">
                                                <div class="task_title">
                                                    <span class="fa fa-calendar"></span>8月16日
                                                </div>
                                                <div class="task_content">
                                                    前往伦敦视察斯塔克大厦运营情况。
                                                </div>
                                            </div>
                                            <div class="task_div">
                                                <div class="task_title">
                                                    <span class="fa fa-calendar"></span>8月16日
                                                </div>
                                                <div class="task_content">
                                                    前往伦敦视察斯塔克大厦运营情况。
                                                </div>
                                            </div>  
                                            <div class="task_div">
                                                <div class="task_title">
                                                    <span class="fa fa-calendar"></span>8月14日
                                                </div>
                                                <div class="task_content">
                                                    会见奥巴马商讨第九区商业模式。
                                                </div>
                                            </div>
                                            <div class="task_div">
                                                <div class="task_title">
                                                    <span class="fa fa-calendar"></span>8月10日
                                                </div>
                                                <div class="task_content">
                                                    与阿联酋王子会见并确定布迪加威龙产业链。
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div id="dashboard-map-seles" style="width: 100%; height: 350px"></div>
                                        </div>
                                    </div>                                    
                                </div>
                            </div>
                        </div>
                        <!-- END SALES BLOCK -->
                            
                    </div>
						
                    
                </div>
                <!-- END PAGE CONTENT WRAPPER -->                                
            </div>            
            <!-- END PAGE CONTENT -->
        </div>
        <!-- END PAGE CONTAINER -->

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
        <script type='text/javascript' src='js/plugins/icheck/icheck.min.js'></script>        
        <script type="text/javascript" src="js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js"></script>
        <script type="text/javascript" src="js/plugins/scrolltotop/scrolltopcontrol.js"></script>
        
        <script type="text/javascript" src="js/plugins/morris/raphael-min.js"></script>
        <script type="text/javascript" src="js/plugins/morris/morris.min.js"></script>       
        <script type="text/javascript" src="js/plugins/rickshaw/d3.v3.js"></script>
        <script type="text/javascript" src="js/plugins/rickshaw/rickshaw.min.js"></script>
        <script type='text/javascript' src='js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js'></script>
        <script type='text/javascript' src='js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js'></script>                
        <script type='text/javascript' src='js/plugins/bootstrap/bootstrap-datepicker.js'></script>                
        <script type="text/javascript" src="js/plugins/owl/owl.carousel.min.js"></script>                 
        
        <script type="text/javascript" src="js/plugins/moment.min.js"></script>
        <script type="text/javascript" src="js/plugins/daterangepicker/daterangepicker.js"></script>
        <!-- END THIS PAGE PLUGINS-->        

        <script type="text/javascript" src="js/plugins/datatables/jquery.dataTables.min.js"></script>
        
        <!-- START TEMPLATE -->
        <script type="text/javascript" src="js/settings.js"></script>
        
        <script type="text/javascript" src="js/plugins.js"></script>        
        <script type="text/javascript" src="js/actions.js"></script>
        
        <script type="text/javascript" src="js/demo_dashboard.js"></script>
        <!-- END TEMPLATE -->
        
    <!-- END SCRIPTS -->         
    </body>
</html>
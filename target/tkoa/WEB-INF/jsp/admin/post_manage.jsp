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
                
                <!-- START BREADCRUMB -->
                <ul class="breadcrumb">
                    <li><a href="index.do">首页</a></li>
                    <li><a href="javascript:void(0);">管理</a></li>
                    <li class="active">岗位管理</li>
                </ul>
                <!-- END BREADCRUMB -->
                
                <!-- PAGE TITLE -->
                <!-- <div class="page-title">                    
                    <h2><span class="fa fa-arrow-circle-o-left"></span> Basic Tables</h2>
                </div> -->
                <!-- END PAGE TITLE -->                
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">
                
                    
                    <!-- 岗位管理开始 -->
                    <div class="row">
                        <div class="col-md-12">
                            
                            <!-- START DATATABLE EXPORT -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">岗位管理</h3>
                                    <div class="btn-group pull-right">
                                        <button class="btn btn-danger dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bars"></i> 导出数据</button>
                                        <a class="btn btn-info ml20" data-toggle="modal" href='#modal_pb_add'>增加岗位 <i class="fa fa-gears"></i></a>
                                        <ul class="dropdown-menu" id="export_ul1">
                                            <li><a data-type="json" href="javascript:;"><img src='img/icons/json.png' width="24"/> JSON</a></li>
                                            <li><a data-type="csv" href="javascript:;"><img src='img/icons/csv.png' width="24"/> CSV</a></li>
                                            <li><a data-type="txt" href="javascript:;"><img src='img/icons/txt.png' width="24"/> TXT</a></li>
                                            <li class="divider"></li>
                                            <li><a data-type="xls" href="javascript:;"><img src='img/icons/xls.png' width="24"/> XLS</a></li>
                                            <li><a data-type="doc" href="javascript:;"><img src='img/icons/word.png' width="24"/> Word</a></li>
                                        </ul>
                                    </div>
                                </div>

                                <!-- 模态框 - 增加岗位开始 -->

                                <div class="modal fade" id="modal_pb_add">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title">增加岗位</h4>
                                            </div>
                                            <form action="#" method="POST" class="form-horizontal" role="form" id="modal_post_add_form">
                                                <div class="modal-body">
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3">业务名称</label>
                                                        <div class="col-md-9">
                                                            <div class="input-group" style="width: 80%;">
                                                                <select id="charge_business" name="businessID" >
                                                                  <s:iterator value="#request.listBusiness" id="lb">
                                                                  <option value="<s:property value="#lb.id"/>"><s:property value="#lb.name"/></option>
                                                                  </s:iterator>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3">岗位名称</label>
                                                        <div class="col-md-7">          
                                                            <div class="input-group">
                                                                <input class="form-control" name="postName" placeholder="请输入岗位名称" type="text">
                                                                <span class="input-group-addon"><span class="fa fa-bookmark-o"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                    <button type="button" id="add_submit" class="btn btn-primary">保存</button>
                                                </div>
                                            </form>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal-dialog -->
                                </div><!-- /.modal -->

                                <!-- 模态框 - 增加业务及其岗位结束 -->

                                <div class="panel-body">

                                    <!-- 表格 - 岗位信息开始 -->

                                    <table id="post_table" class="table">
                                        <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>岗位名称</th>
                                                <th>隶属业务</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<!-- 对listDepartment集合进行迭代输出 -->
                                        	<s:iterator value="#request.listPost" id="lp">
                                        	<tr>
                                        		<td class="id"><s:property value="#lp.id"/></td>
                                                <td class="post_name"><s:property value="#lp.postName"/></td>
                                                <td class="under_business"><s:property value="#lp.business.name"/></td>
                                                <td class="operate">
                                                    <a class="icon_edit" data-toggle="modal" href='#modal_post' >编辑</a>
                                                    <a href="javascript:void(0);" class="icon_delete">删除</a>
                                                </td>
                                        	</tr>
                                        	</s:iterator>
                                        </tbody>
                                    </table>

                                    <!-- 表格 - 岗位信息结束 -->

                                    <!-- 模态框 - 编辑岗位信息开始 -->

                                    <div class="modal fade" id="modal_post">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title">修改岗位信息</h4>
                                                </div>
                                                <form action="#" method="POST" class="form-horizontal" role="form" id="modal_edit_post_form">
                                                    <div class="modal-body">
                                                        <div class="form-group">
                                                            <label class="control-label col-md-3">岗位名称</label>
                                                    		<input type="hidden" name="postID" id="modal_pd_post_id" class="form-control" value="">
                                                            <div class="col-md-7">          
                                                                <div class="input-group">
                                                                    <input class="form-control" name="modal_post_name" placeholder="请输入岗位名称" type="text" id="modal_post_name">
                                                                    <span class="input-group-addon"><span class="fa fa-bookmark-o"></span></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group" id="modal_post_business">
                                                            <label class="control-label col-md-3">隶属业务</label>
	                                                        <div class="col-md-9">
	                                                            <div class="input-group" style="width: 80%;">
	                                                                <select id="edit_charge_business" name="modal_pb_post_name" >
	                                                                  <s:iterator value="#request.listBusiness" id="lb">
	                                                                  <option value="<s:property value="#lb.id"/>"><s:property value="#lb.name"/></option>
	                                                                  </s:iterator>
	                                                                </select>
	                                                            </div>
	                                                        </div>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                        <button type="button" id="edit_submit" class="btn btn-primary">保存</button>
                                                    </div>
                                                </form>
                                            </div><!-- /.modal-content -->
                                        </div><!-- /.modal-dialog -->
                                    </div><!-- /.modal -->

                                    <!-- 模态框 - 编辑岗位信息结束 -->

                                </div>
                            </div>
                            <!-- END DATATABLE EXPORT -->                            
                            
                        </div>
                    </div>
                    <!-- 岗位管理结束 -->

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
        
        <script type="text/javascript" src="js/plugins/select2/select2_2.js"></script>

        <script type="text/javascript" src="js/plugins/jquery-validation/jquery.validate.js"></script>

        <!-- START THIS PAGE PLUGINS-->        
        <script type='text/javascript' src='js/plugins/icheck/icheck.min.js'></script>
        <script type="text/javascript" src="js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js"></script>
        
        <script type="text/javascript" src="js/plugins/datatables/jquery.dataTables.min.js"></script>

	    <script src="js/plugins/tableexport_my/Blob.js"></script>
	    <script src="js/plugins/tableexport_my/FileSaver.js"></script>
	    <script src="js/plugins/tableexport_my/tableExport.js"></script>
        <!-- END THIS PAGE PLUGINS-->  
        
        <!-- START TEMPLATE -->
        <script type="text/javascript" src="js/settings.js"></script>
        
        <script type="text/javascript" src="js/plugins.js"></script>        
        <script type="text/javascript" src="js/actions.js"></script>        
        <!-- END TEMPLATE -->
    <!-- END SCRIPTS -->     
        <script>

            $(function(){

            //业务选择框初始化
                $("#charge_business").select2({
                  placeholder: "请选择该部门负责的业务",
                  width : 'inherit'
                });
            
            //业务选择框初始化
                $("#edit_charge_business").select2({
                    placeholder: "请选择该部门负责的业务",
                    width : 'inherit'
                  });
            
            //岗位表格初始化
                var oTable1 = $("#post_table").dataTable({
                    aoColumnDefs: [{
                        bSortable: false,
                        aTargets: [-1]
                    }]
                  });
                $('#post_table').on('click', 'a.icon_delete', function (e) {
                    //获取表格id
                    var id = $(this).parents("tr").find('.id').text();
                	$.ajax({
                	    url: '<%=basePath %>deletePost.do?postID='+id,
                	    type: 'GET',
                	})
                	.done(function(data) {
                		if( data == "SUCCESS" ){
                			alert("删除成功");
                			location.href=location.href;
                		}else if( data == "FALSE" ){
                			alert("删除失败");
                		}
                	})
                	.fail(function(data) {
                		alert("ajax error:"+data.status);
                	});
                });


            //模态框 - 增加业务及其岗位验证
                $("#modal_pb_add_form").validate({
                    rules: {
                        modal_pb_post_name: {
                            required : true
                        }
                    },
                    messages: {
                        modal_pb_post_name: {
                            required : '请您填写业务名称'
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

            //模态框 - 编辑岗位验证
                $("#modal_post_form").validate({
                    rules: {
                        modal_post_name: {
                            required : true
                        }
                    },
                    messages: {
                        modal_post_name: {
                            required : '请您填写岗位名称'
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

            //导出数据1
                var $exportLink1 = document.getElementById('export_ul1');
                $exportLink1.addEventListener('click', function(e){
                    e.preventDefault();
                    if(e.target.nodeName === "A"){
                        tableExport('post_table', 'posts', e.target.getAttribute('data-type'));
                    }
                    
                }, false);

            //表格 - 编辑 - 按钮
                $(".icon_edit").click(function() {
                    //获取表格id
                    var id = $(this).parents("tr").find('.id').text();
                    //获取表格岗位名称
                    var post_name = $(this).parents("tr").find('.post_name').text();
                    //获取表格所属业务
                    var under_business = $(this).parents("tr").find('.under_business').text();

                    //模态框 - 赋值
                    $("#modal_pd_post_id").val(id);
                    $("#modal_post_name").val(post_name);
                    $("#modal_post_business input[name='business[]']").each(function() {
                        if ($(this).val() == under_business) {
                            $(this).click();
                        };
                    });
                });
                
                //修改--提交
                $("#edit_submit").click(function(){
                	$.ajax({
                	    url: '<%=basePath %>updatePost.do',
                	    type: 'POST',
                	    data: $('#modal_edit_post_form').serialize(),
                	})
                	.done(function(data) {
                		if( data == "SUCCESS" ){
                			alert("修改成功");
                			location.href=location.href;
                		}else if( data == "BUSINESS_HAVED" ){
                			alert("修改失败,关联的业务中含有同名字岗位!");
                		}else if( data == "BUSINESS_NOT_FOUND" ){
                			alert("修改失败,关联的业务不存在!");
                		}else if( data == "FALSE" ){
                			alert("修改失败,请重新刷新页面后再次提交!");
                			location.href=location.href;
                		}
                	})
                	.fail(function(data) {
                		alert("ajax error:"+data.status);
                	});
                });
                
              //添加--提交
                $("#add_submit").click(function(){
                	$.ajax({
                	    url: '<%=basePath %>addPost.do',
                	    type: 'POST',
                	    data: $('#modal_post_add_form').serialize(),
                	})
                	.done(function(data) {
                		if( data == "SUCCESS" ){
                			alert("添加成功");
                			location.href=location.href;
                		}else if( data == "BUSINESS_HAVED" ){
                			alert("添加失败,关联的业务中含有同名字岗位!");
                		}else if( data == "BUSINESS_NOT_FOUND" ){
                			alert("添加失败,关联的业务不存在!");
                		}else if( data == "FALSE" ){
                			alert("添加失败,请重新刷新页面后再次提交!");
                			location.href=location.href;
                		}
                	})
                	.fail(function(data) {
                		alert("ajax error:"+data.status);
                	});
                });
            });
            
            </script>
    </body>
</html>
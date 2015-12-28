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
                    <li><a href="">首页</a></li>
                    <li><a href="javascript:void(0);">管理</a></li>
                    <li class="active">业务管理</li>
                </ul>
                <!-- END BREADCRUMB -->
                
                <!-- PAGE TITLE -->
                <!-- <div class="page-title">                    
                    <h2><span class="fa fa-arrow-circle-o-left"></span> Basic Tables</h2>
                </div> -->
                <!-- END PAGE TITLE -->                
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">

                    <!-- 业务管理开始 -->
                    <div class="row">
                        <div class="col-md-12">
                            
                            <!-- START DATATABLE EXPORT -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">业务管理</h3>
                                    <div class="btn-group pull-right">
                                        <button class="btn btn-danger dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bars"></i> 导出数据</button>
                                        <a class="btn btn-info ml20" data-toggle="modal" href='#modal_pb_add'>增加业务 <i class="fa fa-gears"></i></a>
                                        <ul class="dropdown-menu" id="export_ul2">
                                            <li><a data-type="json" href="javascript:;"><img src='img/icons/json.png' width="24"/> JSON</a></li>
                                            <li><a data-type="csv" href="javascript:;"><img src='img/icons/csv.png' width="24"/> CSV</a></li>
                                            <li><a data-type="txt" href="javascript:;"><img src='img/icons/txt.png' width="24"/> TXT</a></li>
                                            <li class="divider"></li>
                                            <li><a data-type="xls" href="javascript:;"><img src='img/icons/xls.png' width="24"/> XLS</a></li>
                                            <li><a data-type="doc" href="javascript:;"><img src='img/icons/word.png' width="24"/> Word</a></li>
                                        </ul>
                                    </div>
                                    <!-- 模态框 - 增加业务开始 -->

                                    <div class="modal fade" id="modal_pb_add">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title">增加业务</h4>
                                                </div>
                                                <form action="#" method="POST" class="form-horizontal" role="form" id="modal_b_add_form">
                                                    <div class="modal-body">
                                                        <div class="form-group">
                                                            <label class="control-label col-md-3">业务名称</label>
                                                            <div class="col-md-7">          
                                                                <div class="input-group">
                                                                    <input class="form-control" name="businessName" placeholder="请输入业务名称" type="text">
                                                                    <span class="input-group-addon"><span class="fa fa-user"></span></span>
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
                                </div>
                                
                                <div class="panel-body">
                                    <table id="business_table" class="table">
                                        <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>业务名称</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<!-- 对listBusiness集合进行迭代输出 -->
                                        	<s:iterator value="#request.listBusiness" id="lb">
                                        	<tr>
                                        		<td class="id"><s:property value="#lb.id"/></td>
                                                <td class="business_name"><s:property value="#lb.name"/></td>
                                                <td class="operate">
                                                    <a class="icon_edit" data-toggle="modal" href='#modal_business' >编辑</a>
                                                    <a href="javascript:void(0);" class="icon_delete">删除</a>
                                                </td>
                                        	</tr>
                                        	</s:iterator>
                                        </tbody>
                                    </table>
                                    <div class="modal fade" id="modal_business">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title">业务信息</h4>
                                                </div>
                                                <form action="#" method="POST" class="form-horizontal" role="form" id="modal_business_form">
                                                    <div class="modal-body">
                                                        <input type="hidden" name="modal_business_id" id="modal_business_id" class="form-control" value="">
                                                        <div class="form-group">
                                                            <label class="control-label col-md-3">业务名称</label>
                                                            <div class="col-md-7">          
                                                                <div class="input-group">
                                                                    <input class="form-control" name="businessName" placeholder="请输入业务名称" type="text" id="modal_business_name">
                                                                    <span class="input-group-addon"><span class="fa fa-bookmark-o"></span></span>
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
                                </div>
                            </div>
                            <!-- END DATATABLE EXPORT -->                            
                            
                        </div>
                    </div>
                    <!-- 业务管理结束 -->


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

            //业务表格初始化
                var oTable2 = $("#business_table").dataTable({
                    aoColumnDefs: [{
                        bSortable: false,
                        aTargets: [-1]
                    }]
                  });
                $('#business_table').on('click', 'a.icon_delete', function (e) {
                    //获取表格id
                    var modal_business_id = $(this).parents("tr").find('.id').text();
                    var bool =  confirm("确定要删除id为<b style='color:red;'> "+modal_business_id+" </b>的业务吗?\n\n\n删除之前请确保该业务没有与其他部门以及岗位关联!!!");
                    if( bool == true ){
                    	$.ajax({
                    	    url: '<%=basePath %>deleteBusiness.do?businessID='+modal_business_id,
                    	    type: 'GET',
                    	})
                    	.done(function(data) {
                    		if( data == "HAVE_DEPARTMENTS" ){
                    			alert("删除失败,该业务存在于部门关联,请将部门业务转移或者删除部门！");
                    		}else if( data == "HAVE_POSTS" ){
                    			alert("删除失败,该业务存在岗位,请先删除岗位！");
                    		}else if( data == "NOT_FOUND" ){
                    			alert("删除失败,找不到该业务");
                    		}else if( data == "SUCCESS" ){
                    			alert("删除成功");
                    			location.href = location.href;
                    		}
                    	})
                    	.fail(function(data) {
                    		alert("ajax error:"+data.status);
                    	});
                    }
                });

            //模态框 - 增加业务验证
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

            //模态框 - 编辑业务验证
                $("#modal_business_form").validate({
                    rules: {
                        modal_business_name: {
                            required : true
                        }
                    },
                    messages: {
                        modal_business_name: {
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

            //导出数据2
                var $exportLink2 = document.getElementById('export_ul2');
                $exportLink2.addEventListener('click', function(e){
                    e.preventDefault();
                    if(e.target.nodeName === "A"){
                        tableExport('business_table', '数据2', e.target.getAttribute('data-type'));
                    }
                    
                }, false);

            //表格 - 编辑 - 按钮
                $(".icon_edit").click(function() {
                    //获取表格id
                    var id = $(this).parents("tr").find('.id').text();
                    //获取表格业务名称
                    var business_name  = $(this).parents("tr").find('.business_name').text();

                    //模态框 - 赋值
                    $("#modal_business_id").val(id);
                    $("#modal_business_name").val(business_name);
                });

            });
            
            //修改--提交
            $("#edit_submit").click(function(){
            	$.ajax({
            	    url: '<%=basePath %>updateBusiness.do',
            	    type: 'POST',
            	    data: $('#modal_business_form').serialize(),
            	})
            	.done(function(data) {
            		if( data == "SUCCESS" ){
            			alert("修改成功");
            			location.href=location.href;
            		}else if( data == "HAVED_OTHER_BUSINESS" ){
            			alert("修改失败,存在同名的业务!!请修改名字后再提交");
            		}else if( data == "FALSE" ){
            			alert("修改失败,请重新刷新页面后再次提交");
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
            	    url: '<%=basePath %>addBusiness.do',
            	    type: 'POST',
            	    data: $('#modal_b_add_form').serialize(),
            	})
            	.done(function(data) {
            		if( data == "SUCCESS" ){
            			alert("添加成功");
            			location.href=location.href;
            		}else if( "HAVED_OTHER_BUSINESS" == data ){
            			alert("添加失败,存在相同名字的业务");
            		}else if( data == "FALSE" ){
            			alert("添加失败");
            			location.href=location.href;
            		}
            	})
            	.fail(function(data) {
            		alert("ajax error:"+data.status);
            	});
            });
            </script>
    </body>
</html>
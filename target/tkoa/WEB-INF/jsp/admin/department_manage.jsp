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
                    <li class="active">部门管理</li>
                </ul>
                <!-- END BREADCRUMB -->
                
                <!-- PAGE TITLE -->
                <!-- <div class="page-title">                    
                    <h2><span class="fa fa-arrow-circle-o-left"></span> Basic Tables</h2>
                </div> -->
                <!-- END PAGE TITLE -->                
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">
                
                   
                    <!-- 部门管理开始 -->
                    <div class="row">
                        <div class="col-md-12">
                            
                            <!-- START DATATABLE EXPORT -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">部门管理</h3>
                                    <div class="btn-group pull-right">
                                        <button class="btn btn-danger dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bars"></i> 导出数据</button>
                                        <a class="btn btn-info ml20" data-toggle="modal" href='#modal_department' id="modal_department_trigger">增加部门 <i class="fa fa-dropbox"></i></a>
                                        <ul class="dropdown-menu" id="export_ul3">
                                            <li><a data-type="json" href="javascript:;"><img src='img/icons/json.png' width="24"/> JSON</a></li>
                                            <li><a data-type="csv" href="javascript:;"><img src='img/icons/csv.png' width="24"/> CSV</a></li>
                                            <li><a data-type="txt" href="javascript:;"><img src='img/icons/txt.png' width="24"/> TXT</a></li>
                                            <li class="divider"></li>
                                            <li><a data-type="xls" href="javascript:;"><img src='img/icons/xls.png' width="24"/> XLS</a></li>
                                            <li><a data-type="doc" href="javascript:;"><img src='img/icons/word.png' width="24"/> Word</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <!-- 模态框 -- 添加  -- 开始 -->
                                <div class="modal fade" id="modal_department">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title">增加部门</h4>
                                            </div>
                                            <form action="addDepartment.do" method="POST" class="form-horizontal" role="form" id="modal_department_form">
                                                <div class="modal-body">
                                                    <input type="hidden" name="departmentID" id="modal_department_id" class="form-control" value="">
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3">部门名称</label>
                                                        <div class="col-md-7">          
                                                            <div class="input-group">
                                                                <input class="form-control" name="departmentName" placeholder="请输入部门名称" type="text" id="modal_department_name">
                                                                <span class="input-group-addon"><span class="fa fa-bookmark-o"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3">负责业务</label>
                                                        <div class="col-md-7">
                                                            <div class="input-group" style="width: 100%;">
                                                                <select id="charge_business" name="businessID" >
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
                                                    <button type="submit" class="btn btn-primary">保存</button>
                                                </div>
                                            </form>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal-dialog -->
                                </div><!-- /.modal -->
                                <!-- 模态框 -- 添加  -- 结束 -->
                                
                                <!-- 模态框 -- 修改  -- 开始 -->
                                <div class="modal fade" id="modal_edit_department">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title">修改部门信息</h4>
                                            </div>
                                            <form action="#" method="POST" class="form-horizontal" role="form" id="modal_edit_department_form">
                                                <div class="modal-body">
                                                    <input type="hidden" name="departmentID" id="edit_modal_department_id" class="form-control" value="">
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3">部门名称</label>
                                                        <div class="col-md-7">          
                                                            <div class="input-group">
                                                                <input class="form-control" name="departmentName" placeholder="请输入部门名称" type="text" id="edit_modal_department_name">
                                                                <span class="input-group-addon"><span class="fa fa-bookmark-o"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3">负责业务</label>
                                                        <div class="col-md-7">
                                                            <div class="input-group" style="width: 100%;">
                                                                <select id="edit_charge_business" name="businessID" >
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
                                                    <button type="submit" class="btn btn-primary">保存</button>
                                                </div>
                                            </form>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal-dialog -->
                                </div><!-- /.modal -->
                                <!-- 模态框 -- 修改  -- 结束 -->
                                
                                <div class="panel-body">
                                    <table id="department_table" class="table">
                                        <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>部门名称</th>
                                               	<th>负责业务</th>
                                                <th>部门人数</th>
                                                <th>高职称人数</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<!-- 对listDepartment集合进行迭代输出 -->
                                        	<s:iterator value="#request.listDepartment" id="ld">
                                        	<tr>
                                        		<td class="id"><s:property value="#ld.id"/></td>
                                                <td class="department_name"><s:property value="#ld.name"/></td>
                                                <td class="charge_business"><span class="label label-warning"><s:property value="#ld.business.name"/></span></td>
                                                <td class="headcount"><s:property value="#ld.headcount"/></td>
                                                <td class="highgrade_deadcount"><s:property value="#ld.highgradeHeadcount"/></td>
                                                <td class="operate">
                                                    <a class="icon_edit" data-toggle="modal" href='#modal_edit_department' >编辑</a>
                                                    <a href="javascript:void(0);" class="icon_delete">删除</a>
                                                    <div class="hide_info hidden">
                                                    	<div class="charge_business_id"><s:property value="#ld.business.id"/></div>
                                                    </div>
                                                </td>
                                        	</tr>
                                        	</s:iterator>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- END DATATABLE EXPORT -->                            
                            
                        </div>
                    </div>
                    <!-- 部门管理结束 -->



                </div>         
                <!-- END PAGE CONTENT WRAPPER -->
            </div>            
            <!-- END PAGE CONTENT -->
        </div>
        <!-- END PAGE CONTAINER -->    

        <!-- MESSAGE BOX-->
        <div class="message-box animated fadeIn" data-sound="alert" id="mb-remove-row">
            <div class="mb-container">
                <div class="mb-middle">
                    <div class="mb-title"><span class="fa fa-times"></span> Remove <strong>Data</strong> ?</div>
                    <div class="mb-content">
                        <p>Are you sure you want to remove this row?</p>                    
                        <p>Press Yes if you sure.</p>
                    </div>
                    <div class="mb-footer">
                        <div class="pull-right">
                            <button class="btn btn-success btn-lg mb-control-yes">Yes</button>
                            <button class="btn btn-default btn-lg mb-control-close">No</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END MESSAGE BOX-->        
        
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

            //部门表格初始化
                var oTable3 = $("#department_table").dataTable({
                    aoColumnDefs: [{
                        bSortable: false,
                        aTargets: [-1]
                    }]
                  });
                $('#department_table').on('click', 'a.icon_delete', function (e) {
                    //获取表格id
                    var id = $(this).parents("tr").find('.id').text();
                    var bool =  confirm("确定要删除id为<b style='color:red;'> "+id+" </b>的部门吗?\n\n\n删除之前请确保该部门已经没有员工和外勤任务!!!");
                    if( bool == true ){
                    	$.ajax({
                    	    url: '<%=basePath %>deleteDepartment.do?departmentID='+id,
                    	    type: 'GET',
                    	})
                    	.done(function(data) {
                    		if( data == "HAVE_EMPLOYEES" ){
                    			alert("删除失败,该部门存在员工,请将员工解雇或者转移至其他部门！");
                    		}else if( data == "HAVE_EXPATRIATELABORS" ){
                    			alert("删除失败,该部门仍存在外勤任务,请讲任务删除或者转移至其他部门！");
                    		}else if( data == "NOT_FOUND" ){
                    			alert("删除失败,找不到该部门");
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

            //部门选择框初始化
                $("#charge_business").select2({
                  placeholder: "请选择该部门负责的业务",
                  width : 'inherit'
                });
            
              //部门选择框初始化
                $("#edit_charge_business").select2({
                  placeholder: "请选择该部门负责的业务",
                  width : 'inherit'
                });

              //模态框 - 部门验证
                $("#modal_department_form").validate({
                    rules: {
                        modal_department_name: {
                            required : true
                        },
                        modal_department_business: {
                            required : true
                        }
                    },
                    messages: {
                        modal_department_name: {
                            required : '请您填写部门名称'
                        },
                        modal_department_business: {
                            required : '请您至少选择一个负责业务'
                        }
                    },
                    errorPlacement: function(error, element) {  
                      error.appendTo ( element.parent().parent() );  
                      error.addClass ("checkbox-inline");
                    },
                    submitHandler:function(form){
                    	$.ajax({
                    	    url: '<%=basePath %>addDepartment.do',
                    	    type: 'POST',
                    	    data: $(form).serialize(),
                    	})
                    	.done(function(data) {
                    		if( data == "SUCCESS" ){
                    			alert("添加成功");
                    			location.href=location.href;
                    		}else if( "HAVED_OTHER_DEPARTMENT" == data ){
                    			alert("添加失败,存在相同名字的部门！");
                    		}else if( data == "BUSINESS_NOT_FOUND" ){
                    			alert("添加失败,关联的业务不存在!");
                    		}else if( data == "OVERFLOW" ){
                    			alert("添加失败,部门数量超过999！请删减后再添加！");
                    		}else if( data == "FALSE" ){
                    			alert("添加失败");
                    			location.href=location.href;
                    		}
                    	})
                    	.fail(function(data) {
                    		alert("ajax error:"+data.status);
                    	});
                    }
                });
              
              //模态框 - 部门验证 - 编辑
                $("#modal_edit_department_form").validate({
                    rules: {
                        modal_department_name: {
                            required : true
                        },
                        modal_department_business: {
                            required : true
                        }
                    },
                    messages: {
                        modal_department_name: {
                            required : '请您填写部门名称'
                        },
                        modal_department_business: {
                            required : '请您至少选择一个负责业务'
                        }
                    },
                    errorPlacement: function(error, element) {  
                      error.appendTo ( element.parent().parent() );  
                      error.addClass ("checkbox-inline");
                    },
                    submitHandler:function(form){
                    	$.ajax({
                    	    url: '<%=basePath %>updateDepartment.do',
                    	    type: 'POST',
                    	    data: $(form).serialize(),
                    	})
                    	.done(function(data) {
                    		if( data == "SUCCESS" ){
                    			alert("修改成功");
                    			location.href=location.href;
                    		}else if( data == "HAVED_OTHER_DEPARMENT" ){
                    			alert("修改失败,该部门名字已存在!");
                    		}else if( data == "BUSINESS_NOT_FOUND" ){
                    			alert("修改失败,负责的业务不存在!");
                    		}else if( data == "FALSE" ){
                    			alert("修改失败,请刷新后重新修改！");
                    			location.href=location.href;
                    		}
                    	})
                    	.fail(function(data) {
                    		alert("ajax error:"+data.status);
                    	});
                    }
                });

            //导出数据3
                var $exportLink3 = document.getElementById('export_ul3');
                $exportLink3.addEventListener('click', function(e){
                    e.preventDefault();
                    if(e.target.nodeName === "A"){
                        tableExport('department_table', 'departments', e.target.getAttribute('data-type'));
                    }
                    
                }, false);

            //表格 - 编辑 - 按钮
                $(".icon_edit").click(function() {
                    //获取表格id
                    var id = $(this).parents("tr").find('.id').text();
                    //获取表格部门名字
                    var department_name = $(this).parents("tr").find('.department_name').text();
					//获取表格负责业务
					var charge_business = $(this).parents("tr").find('.charge_business > span').text();
	                //获取表格学历id值
	                var charge_business_id = $(this).siblings('.hide_info').find('.charge_business_id').text();
                    
                    //var charge_business_array = new Array();

                    //$(this).parents("tr").find(".charge_business > span").each(function(index){
                    //    charge_business_array[index] = $(this).text();
                    //})

                    //模态框 - 赋值
                    $("#edit_modal_department_id").val(id);
                    $("#edit_modal_department_name").val(department_name);
                    $("#edit_charge_business").select2("val", charge_business_id);
                    
                });

                
                

            });
            </script>
    </body>
</html>
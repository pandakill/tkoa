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
                    <li class="active">员工管理</li>
                </ul>
                <!-- END BREADCRUMB -->
                
                <!-- PAGE TITLE -->
                <!-- <div class="page-title">                    
                    <h2><span class="fa fa-arrow-circle-o-left"></span> Basic Tables</h2>
                </div> -->
                <!-- END PAGE TITLE -->                
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">
                
                    
                    
                    <div class="row">
                        <div class="col-md-12">
                            
                            <!-- START DATATABLE EXPORT -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">用户管理</h3>
                                    <div class="btn-group pull-right">
                                        <button class="btn btn-danger dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bars"></i> 导出数据</button>
                                        <a class="btn btn-info ml20" data-toggle="modal" href='#modal-id' id="modal_click">增加用户 <i class="fa fa-users"></i></a>
                                        <ul class="dropdown-menu" id="export_ul">
                                            <li><a data-type="json" href="javascript:;"><img src='img/icons/json.png' width="24"/> JSON</a></li>
                                            <li><a data-type="csv" href="javascript:;"><img src='img/icons/csv.png' width="24"/> CSV</a></li>
                                            <li><a data-type="txt" href="javascript:;"><img src='img/icons/txt.png' width="24"/> TXT</a></li>
                                            <li class="divider"></li>
                                            <li><a data-type="xls" href="javascript:;"><img src='img/icons/xls.png' width="24"/> XLS</a></li>
                                            <li><a data-type="doc" href="javascript:;"><img src='img/icons/word.png' width="24"/> Word</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <!-- 模态框 - 增加用户开始 -->
                                <div class="modal fade" id="modal-id">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title">用户信息</h4>
                                            </div>
                                            <form action="#" method="POST" class="form-horizontal" role="form" id="modal_form">
                                                <div class="modal-body">
                                                    <input type="hidden" name="employeeID" class="form-control" value="" id="modal_id">
                                                    <div class="form-group">
                                                        <label class="control-label col-xs-3">姓名</label>
                                                        <div class="col-xs-7">          
                                                            <div class="input-group">
                                                                <input class="form-control" name="name" placeholder="请输入姓名" type="text" id="modal_name">
                                                                <span class="input-group-addon"><span class="fa fa-user"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-xs-3">手机号码</label>
                                                        <div class="col-xs-7">             
                                                            <div class="input-group">
                                                                <input type="text" class="form-control" name="tel" placeholder="请输入手机号码" id="modal_tel" />
                                                                <span class="input-group-addon"><span class="fa fa-phone"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-xs-3">分机</label>
                                                        <div class="col-xs-7">          
                                                            <div class="input-group">
                                                                <input class="form-control" name="extension" placeholder="请输入分机" type="text" id="modal_extension">
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-phone-alt"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-xs-3">籍贯</label>
                                                        <div class="col-xs-7">          
                                                            <div class="input-group">
                                                                <input class="form-control" name="nativePlace" placeholder="请输入籍贯" type="text" id="modal_native_place">
                                                                <span class="input-group-addon"><span class="fa fa-user"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group" id="modal_sex">
                                                        <label class="control-label col-xs-3">性别</label>
                                                        <div class="col-xs-5">
                                                            <label class="radio-inline">
                                                                <input name="sex" type="radio" value="男" checked="">
                                                                <span>男</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="sex" type="radio" value="女">
                                                                <span>女</span>
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group" id="modal_education">
                                                        <label class="control-label col-xs-3">学历</label>
                                                        <div class="col-xs-5">
                                                       		<select id="modal_educationBackground" name="educationBackgroundID" >
                                                              <s:iterator value="#request.listEducationBackground" id="le">
                                                              <option value="<s:property value="#le.id"/>"><s:property value="#le.name"/></option>
                                                              </s:iterator>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-xs-3">专业</label>
                                                        <div class="col-xs-5">             
                                                            <div class="input-group">
                                                                <input type="text" class="form-control" name="major" placeholder="请输入专业" id="modal_major" />
                                                                <span class="input-group-addon"><span class="fa fa-book"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">            
                                                        <label class="control-label col-xs-3">出生日期</label>
                                                        <div class="col-xs-7">       
                                                            <div class="input-group">
                                                                <input type="text" class="form-control datepicker" value="2015-07-10" name="birthday" placeholder="请输入出生日期" id="modal_birthday">
                                                                <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group" id="modal_duty">
                                                        <label class="control-label col-xs-3">职务</label>
                                                        <div class="col-xs-5">
                                                            <label class="radio-inline">
                                                                <input name="athorities" type="radio" value="ROLE_EMPLOYEE" checked="">
                                                                <span>员工</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="athorities" type="radio" value="ROLE_ADMIN">
                                                                <span>部门经理</span>
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-xs-3">部门</label>
                                                        <div class="col-xs-5">
                                                       		<select id="modal_department" name="departmentID" >
                                                              <s:iterator value="#request.listDepartment" id="ld">
                                                              <option value='<s:property value="#ld.id"/>'><s:property value="#ld.name"/></option>
                                                              </s:iterator>  
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-xs-3">业务</label>
                                                        <div class="col-xs-5">
                                                        	<input name="businessID" type="hidden" id="modal_business_id" value=""/>
                                                        	<label class="label label-info" id="modal_business"><% out.print(request.getAttribute("firstBusiness")); %></label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-xs-3">岗位</label>
                                                        <div class="col-xs-5">
                                                       		<select id="modal_post" name="postID" >
                                                              <s:iterator value="#request.listPosts" id="ld">
                                                              <option value='<s:property value="#ld.id"/>'><s:property value="#ld.postName"/></option>
                                                              </s:iterator>  
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">            
                                                        <label class="control-label col-md-3">入职日期</label>
                                                        <div class="col-xs-7">       
                                                            <div class="input-group">
                                                                <input type="text" class="form-control datepicker" value="2014-11-01" name="hiredate" placeholder="请输入入职日期" id="modal_hiredate">
                                                                <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- 
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3">工龄</label>
                                                        <div class="col-xs-7">    
                                                            <div class="input-group">
                                                                <input class="form-control" name="seniority" placeholder="请输入年资" type="text" id="modal_seniority">
                                                                <span class="input-group-addon"><span class="fa fa-heart"></span></span>
                                                            </div>
                                                        </div>
                                                    </div> -->
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3">工资</label>
                                                        <div class="col-xs-7">           
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><span class="fa fa-rmb"></span></span>
                                                                <input class="form-control" name="salary" placeholder="请输入工资" type="text" id="modal_salary">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                    <button type="submit" class="btn btn-primary" id="modal_add_btn">保存</button>
                                                    <button type="submit" class="btn btn-primary" id="modal_edit_btn">保存</button>
                                                </div>
                                            </form>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal-dialog -->
                                </div><!-- /.modal -->
                                
                                <!-- 模态框 - 增加用户结束 -->
                                
                                <div class="panel-body">
                                    <table id="customers2" class="table">
                                        <thead>
                                            <tr>
                                                <th>姓名</th>
                                                <th>手机</th>
                                                <th>岗位</th>
                                                <th>职务</th>
                                                <th>学历</th>
                                                <th>部门</th>
                                                <th>入职日期</th>
                                                <th>工资</th>
                                                <th>状态</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<s:iterator id="employee" value="#request.employees" status="st">
                                        		<tr>
                                                <td class="name"><s:property value="#employee.name"/></td>
                                                <td class="tel"><s:property value="#employee.users.username"/></td>
                                                <td class="post"><s:property value="#employee.post.postName"/></td>
                                                <td class="authorities"><s:property value="#employee.duty"/></td>
                                                <td class="education_background"><s:property value="#employee.educationBackground.name"/></td>
                                                <td class="department"><s:property value="#employee.department.name"/></td>
                                                <td class="birthday"><s:property value="#employee.hiredate"/></td>
                                                <td class="salary"><s:property value="#employee.salary /100.0 "/></td>
                                                <td class="status">
                                                	<s:if test="#employee.users.enabled ==0">
                                                		<span class="label label-danger">未注册/未激活</span>
                                                	</s:if>
                                                	<s:if test="#employee.users.enabled ==1">
                                                		<span class="label label-warning">已注册/已激活</span>
                                                	</s:if>
                                                </td>
                                                <td class="operate">
                                                    <a class="icon_edit" data-toggle="modal" href='#modal-id' >编辑</a>
                                                    <!-- <a href="javascript:void(0);" class="icon_delete">删除</a> -->
                                                    <div class="hide_info hidden">
                                                        <div class="id"><s:property value="#employee.id"/></div>
                                                        <div class="sex"><s:property value="#employee.sex"/></div>
                                                        <div class="hiredate"><s:property value="#employee.hiredate"/></div>
                                                        <div class="extension"><s:property value="#employee.extension"/></div>
                                                        <div class="nativePlace"><s:property value="#employee.nativePlace"/></div>
                                                        <div class="major"><s:property value="#employee.major"/></div>
                                                        <div class="authorities_value"><s:property value="#employee.users.authorities.authority"/></div>
                                                        <div class="seniority"><s:property value="#employee.seniority"/></div>
                                                        <div class="business"><s:property value="#employee.department.business.name"/></div>
                                                        <div class="department_id"><s:property value="#employee.department.id"/></div>
                                                		<div class="education_background_id"><s:property value="#employee.educationBackground.id"/></div>
                                                        
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

        <script type="text/javascript" src="js/plugins/bootstrap/bootstrap-datepicker.js"></script>

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
        
    		var control_btn = 0;

            $(function(){
            	
                var oTable = $("#customers2").dataTable({
                    aoColumnDefs: [{
                        bSortable: false,
                        aTargets: [-1]
                    }]
                  });
                
              //业务选择框初始化
                $("#modal_department").select2({
                    placeholder: "请选择该部门负责的业务",
                    width : '100%'
                  });
              
              //部门选择时触发的事件
              $("#modal_department").change(function(){
            	  
            	  var department_value = $(this).val();
          		  //ajax获取业务以及岗位
                  $.ajax({
                      url: '<%=basePath %>getBusiness.do?departmentID='+department_value,
                      type: 'GET',
                  })
                  .done(function(data) {
                	  var d = eval('(' + data + ')');
                	  if( "SUCCESS" == d.result){
                		  //替换业务值
                    	  $("#modal_business").text(d.businessName);
                    	  $("#modal_business_id").val(d.businessID);
                    	  //alert("listposts="+d.listPosts);
                    	  //var l = eval(d.listPosts);
                    	  //替换岗位值
                    	  var post_value = "";
                    	  for( var i=0;i<d.listPosts.length;i++ ){
                    		  post_value += "<option value='"+d.listPosts[i].id+"'>"+d.listPosts[i].postName+"</option>";
                    	  }
                    	  //post_value = "<option value='"+d.postID+"'>"+d.postName+"</option>";
                    	  $("#modal_post").select("destroy");
                    	  $("#modal_post").html(post_value);
                    	  $("#modal_post").select2({
                              placeholder: "请选择岗位",
                              width : '100%'
                          });
                	  }
                  })
                  .fail(function(data) {
                      alert("getBusiness ajax error:"+data.status);
                  });
              });
              
              //学历选择框初始化
                $("#modal_educationBackground").select2({
                    placeholder: "请选择学历",
                    width : '100%'
                  });
              
              //岗位选择框初始化
                $("#modal_post").select2({
                    placeholder: "请选择岗位",
                    width : '100%'
                  });

                $('#customers2').on('click', 'a.icon_delete', function (e) {

                    //获取表格id
                    var id = $(this).siblings('.hide_info').find('.id').text();

                    alert("要删除的id值为："+id);

                    e.preventDefault();

                    var nRow = $(this).parents('tr')[0];
                    oTable.fnDeleteRow( nRow );
                });

             	// 中文的验证 
                jQuery.validator.addMethod("chinese", function(value, element) { 
                var chinese = /^[\u4e00-\u9fa5]+$/; 
                return this.optional(element) || (chinese.test(value)); 
                }, "只能输入中文"); 
                // 手机号码验证 
                jQuery.validator.addMethod("mobile", function(value, element) { 
                var length = value.length; 
                var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/ 
                return this.optional(element) || (length == 11 && mobile.test(value)); 
                }, "手机号码格式错误"); 
                $("#modal_form").validate({
                    rules: {
                        name: {
                            required : true,
                            chinese : true
                        },
                        tel: {
                            required : true,
                            mobile : true
                        },
                        nativePlace : {
                            required : true
                        },
                        extension : {
                            required : true,
                            minlength : 3,
                            maxlength : 3,
                            digits : true
                        },
                        educationBackground : {
                            required : true
                        },
                        major : {
                        	required : true
                        },
                        birthday : {
                            required : true,
                            date : true
                        },
                        departmentID : {
                            required : true
                        },
                        postID : {
                            required : true
                        },
                        hiredate : {
                            required : true,
                            date : true
                        },
                        seniority : {
                            required : true,
                            digits : true,
                            range : [0,100]
                        },
                        salary : {
                            required : true,
                            number : true
                        }
                    },
                    messages: {
                        name: {
                            required : '请您填写姓名',
                            chinese : '姓名必须为中文'
                        },
                        tel: {
                            required : '请您填写手机号码'
                        },
                        nativePlace : {
                            required : '请您填写籍贯'
                        },
                        extension : {
                            required : '请您填写分号',
                            minlength : '分号必须为3位数字',
                            maxlength : '分号必须为3位数字',
                            digits : '分号必须为数字'
                        },
                        educationBackground : {
                            required : '请您选择学历'
                        },
                        major : {
                        	required : '请您填写专业'
                        },
                        birthday : {
                            required : '请您选择出生日期',
                            date : '出生日期不正确'
                        },
                        departmentID : {
                            required : '请您选择学历'
                        },
                        postID : {
                            required : '请您选择岗位'
                        },
                        hiredate : {
                            required : '请您选择入职日期',
                            date : '入职日期不正确'
                        },
                        seniority : {
                            required : '请您输入年资',
                            digits : '年资必须为数字',
                            range : '年资范围为1-100'
                        },
                        salary : {
                            required : '请您输入工资',
                            number : '工资必须为数字'
                        }
                    },
                    errorPlacement: function(error, element) {  
                      error.appendTo ( element.parent().parent() );  
                      error.addClass ("checkbox-inline");
                    },
                    submitHandler:function(form){
                    	if(control_btn == 1){
                    		//alert("添加表单提交");
                            $.ajax({
                                url: '<%=basePath %>addEmployee.do',
                                type: 'POST',
                                data: $('#modal_form').serialize(),
                            })
                            .done(function(data) {
                            	alert(data);
                                if( data == "SUCCESS" ){
                                    alert("添加成功");
                                    location.href=location.href;
                                }else if( "HAVED_USERS" == data ){
                                    alert("添加失败,存在相同手机号码的员工");
                                }else{
                                    alert("添加失败");
                                    location.href=location.href;
                                }
                            })
                            .fail(function(data) {
                                alert("ajax error:"+data.status);
                            });
                    	}else if(control_btn == 2){
                    		//alert("编辑表单提交");
                            $.ajax({
                                url: '<%=basePath %>updateEmployee.do',
                                type: 'POST',
                                data: $('#modal_form').serialize(),
                            })
                            .done(function(data) {
                            	alert(data);
                                if( data == "SUCCESS" ){
                                    alert("修改成功");
                                    location.href=location.href;
                                }else if( "HAVED_USERS" == data ){
                                    alert("修改失败,存在相同手机号码的员工");
                                }else{
                                    alert("修改失败");
                                    //location.href=location.href;
                                }
                            })
                            .fail(function(data) {
                                alert("ajax error:"+data.status);
                            });
                    	}
                        //$(form).submit();
                    }
                });

            })

        //导出数据
            var $exportLink = document.getElementById('export_ul');
            $exportLink.addEventListener('click', function(e){
                e.preventDefault();
                if(e.target.nodeName === "A"){
                    tableExport('customers2', '数据', e.target.getAttribute('data-type'));
                }
                
            }, false);


            //编辑按钮
            $(".icon_edit").click(function() {
            	
                control_btn = 2;    //改为编辑状态
                $("#modal_edit_btn").removeClass('hidden');
                $("#modal_add_btn").addClass('hidden');
            	
                //去除错误提示
                $("#modal-id label.error").remove();
                $("#modal-id .error").removeClass("error");

            /*
                **  获取表格数据
             */
            
                //获取表格名字
                var name = $(this).parents("tr").find('.name').text();
                //获取表格手机
                var tel = $(this).parents("tr").find('.tel').text();
                //获取表格岗位值
                var post = $(this).parents("tr").find('.post').text();
                //获取表格职务值
                var authorities = $(this).parents("tr").find('.athorities').text();
                //获取表格教育背景
                var education_background = $(this).parents("tr").find('.education_background').text();
                //获取表格部门值
                var department = $(this).parents("tr").find('.department').text();
                //获取表格出生日期
                var birthday = $(this).parents("tr").find('.birthday').text();
                //获取表格工资
                var salary = $(this).parents("tr").find('.salary').text();

            /*
                **  获取表格隐藏数据
             */
                
                //获取表格id
                var id = $(this).siblings('.hide_info').find('.id').text();
                //获取表格性别
                var sex = $(this).siblings('.hide_info').find('.sex').text();
                //获取表格岗位值
                var hiredate = $(this).siblings('.hide_info').find('.hiredate').text();
                //获取表格分机
                var extension = $(this).siblings('.hide_info').find('.extension').text();
                //获取表格籍贯
                var nativePlace = $(this).siblings('.hide_info').find('.nativePlace').text();
                //获取表格专业
                var major = $(this).siblings('.hide_info').find('.major').text();
                //获取表格年资
                var seniority = $(this).siblings('.hide_info').find('.seniority').text();
                //获取表格业务值
                var business = $(this).siblings('.hide_info').find('.business').text();
                //获取表格部门id值
                var department_id = $(this).siblings('.hide_info').find('.department_id').text();
                //获取表格学历id值
                var education_background_id = $(this).siblings('.hide_info').find('.education_background_id').text();
                //获取表格职务英文值
                var authorities_value = $(this).siblings('.hide_info').find('.authorities_value').text();
                
                //模态框 - id赋值
                $("#modal_id").val(id);
                //模态框 - 名字赋值
                $("#modal_name").val(name);
                //模态框 - 手机赋值
                $("#modal_tel").val(tel);
                if( tel != null ){
                    alert(tel);
                    //$("#modal_tel").setAttibute("disabled",true);
                }
                //模态框 - 分机赋值
                $("#modal_extension").val(extension);
                //模态框 - 籍贯赋值
                $("#modal_native_place").val(extension);
                //遍历模态框性别单选框并赋值
                $("input[name='sex']").each(function() {
                    if ( $(this).val() == sex) {
                        $(this).click();
                    };
                });
              	//模态框 - 学历赋值
                $("#modal_educationBackground").select2("val", education_background_id);
                //模态框 - 专业赋值
                $("#modal_major").val(major);
                //模态框 - 出生日期赋值
                $("#modal_birthday").val(birthday);
                //遍历模态框职务单选框并赋值
                $("#modal_duty input[type='radio']").each(function() {
                    if ( $(this).val() == authorities_value) {
                        $(this).click();
                    };
                });
                //模态框 - 业务赋值
                $("#modal_business").val(business);
              	//模态框 - 岗位赋值
                $("#modal_post").select2("val", post);
                //模态框 - 入职日期赋值
                $("#modal_hiredate").val(hiredate);
                //模态框 - 年资赋值
                $("#modal_seniority").val(seniority);
                //模态框 - 工资赋值
                $("#modal_salary").val(salary);
                
              	//模态框 - 部门赋值	(trigger下面不执行)
                $("#modal_department").select2("val", department_id).trigger("change");

            });
            
          //表格 - 添加 - 按钮
            $("#modal_click").click(function(){

                control_btn = 1;    //改为添加状态
                $("#modal_edit_btn").addClass('hidden');
                $("#modal_add_btn").removeClass('hidden');

              	//模态框 - id赋值
                $("#modal_id").val(null);
                //模态框 - 名字赋值
                $("#modal_name").val(null);
                //模态框 - 手机赋值
                $("#modal_tel").val(null);
                //模态框 - 分机赋值
                $("#modal_extension").val(null);
                //模态框 - 籍贯赋值
                $("#modal_native_place").val(null);
                //模态框 - 专业赋值
                $("#modal_major").val(null);
                //模态框 - 出生日期赋值
                $("#modal_birthday").val(null);
                //模态框 - 入职日期赋值
                $("#modal_hiredate").val(null);
                //模态框 - 年资赋值
                $("#modal_seniority").val(null);
                //模态框 - 工资赋值
                $("#modal_salary").val(null);
            });

            </script>
    </body>
</html>

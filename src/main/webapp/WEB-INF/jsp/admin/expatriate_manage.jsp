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
<style>
.datepicker.datepicker-dropdown.dropdown-menu{z-index: 1050;}
</style>
                <!-- START BREADCRUMB -->
                <ul class="breadcrumb">
                    <li><a href="#">首页</a></li>
                    <li><a href="#">操作</a></li>
                    <li class="active">外派任务</li>
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
                                    <h3 class="panel-title">外派任务管理</h3>
                                    <div class="btn-group pull-right">
                                        <button class="btn btn-danger dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bars"></i> 导出数据</button>
                                        <a class="btn btn-info ml20" data-toggle="modal" href='#modal_expatriate' id="modal_expatriate_trigger">增加外派任务 <i class="fa fa-gears"></i></a>
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

                                <!-- 模态框 - 增加业务及其岗位开始 -->

                                <div class="modal fade" id="modal_expatriate">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title">增加外派任务</h4>
                                            </div>
                                            <form action="#" method="POST" class="form-horizontal" role="form" id="modal_expatriate_form">
                                                <div class="modal-body">
                                                    <input type="hidden" name="id" id="modal_expatriate_id" class="form-control" value="">
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3">客户名称</label>
                                                        <div class="col-md-7">          
                                                            <div class="input-group">
                                                                <input class="form-control" name="name" placeholder="请输入业务名称" type="text" id="modal_expatriate_name">
                                                                <span class="input-group-addon"><span class="fa fa-user"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3">地址名称</label>
                                                        <div class="col-md-7">          
                                                            <div class="input-group">
                                                                <input class="form-control" name="address" placeholder="请输入地址名称" type="text" id="modal_expatriate_address">
                                                                <span class="input-group-addon"><span class="fa fa-location-arrow"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3"></label>
                                                        <div class="col-md-7"> 
                                                            <div id="baidu_map" style="height:200px;"></div>
                                                            <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
                                                            <input type="hidden" name="longitude" class="form-control" value="" id="modal_expatriate_longitude">
                                                            <input type="hidden" name="latitude" class="form-control" value="" id="modal_expatriate_latitude">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">            
                                                        <label class="control-label col-md-3">开始日期</label>
                                                        <div class="col-xs-7" style="z-index:1111;">       
                                                            <div class="input-group">
                                                                <input type="text" class="form-control datepicker" value="2015-07-01" name="begindate" placeholder="请输入入职日期" id="modal_expatriate_begindate">
                                                                <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3">项目期限</label>
                                                        <div class="col-md-7">          
                                                            <div class="input-group">
                                                                <input class="form-control" name="time" placeholder="请输入项目期限" type="text" id="modal_expatriate_time">
                                                                <span class="input-group-addon"><span class="fa fa-tags"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3">负责员工</label>
                                                        <div class="col-md-7">
                                                            <div class="input-group" style="width: 100%;">
                                                                <select id="modal_expatriate_employee" multiple="multiple" name="employee" style="width: 100%" placeholder="请您选择负责员工">
                                                                  <s:iterator id="employee" value="#request.employees" status="st">
                                                                  	<option value='<s:property value="#employee.id"/>'><s:property value="#employee.name"/></option>
                                                                  </s:iterator>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3">项目描述</label>
                                                        <div class="col-md-9">
                                                            <div class="input-group">
                                                                <textarea name="details" id="modal_expatriate_details" rows="4" cols="50%"></textarea>
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

                                <!-- 模态框 - 增加业务及其岗位结束 -->

                                <div class="panel-body">

                                    <!-- 表格 - 岗位信息开始 -->

                                    <table id="expatriate_table" class="table">
                                        <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>客户名称</th>
                                                <th>负责部门</th>
                                                <th>负责员工</th>
                                                <th>项目期限</th>
                                                <th>所在地址</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<s:iterator id="expatriateLabor" value="#request.expatriateLabors">
                                            <tr>
                                                <td class="id"><s:property value="#expatriateLabor.id"/></td>
                                                <td class="name"><s:property value="#expatriateLabor.customerName"/></td>
                                                <td class="charge_department"><s:property value="#expatriateLabor.department.name"/></td>
                                                <td class="charge_employee"><s:property value="#expatriateLabor.employee.name"/></td>
                                                <td class="time"><s:property value="#expatriateLabor.deadline"/></td>
                                                <td class="address"><s:property value="#expatriateLabor.customerAddress"/></td>
                                                <td class="operate">
                                                    <a class="icon_edit" data-toggle="modal" href='#modal_expatriate' >编辑</a>
                                                    <a href="javascript:void(0);" class="icon_delete">删除</a>
                                                    <div class="hide_info hidden">
                                                        <div class="details"><s:property value="#expatriateLabor.projectDetails"/></div>
                                                        <div class="longitude"><s:property value="#expatriateLabor.longitudeE"/></div>
                                                        <div class="latitude"><s:property value="#expatriateLabor.latitudeE"/></div>
                                                        <div class="begindate">2015-6-7</div>
                                                    </div>
                                                </td>
                                            </tr>		
                                           </s:iterator>
                                        </tbody>
                                    </table>

                                    <!-- 表格 - 岗位信息结束 -->

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

        <script type="text/javascript" src="js/plugins/bootstrap/bootstrap-datepicker.js"></script>
        
        <script type="text/javascript" src="js/plugins/jquery-validation/jquery.validate.js"></script>

        <!-- START THIS PAGE PLUGINS-->        
        <script type='text/javascript' src='js/plugins/icheck/icheck.min.js'></script>
        <script type="text/javascript" src="js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js"></script>
        
        <script type="text/javascript" src="js/plugins/datatables/jquery.dataTables.min.js"></script>

    <script src="js/plugins/tableexport_my/Blob.js"></script>
    <script src="js/plugins/tableexport_my/FileSaver.js"></script>
    <script src="js/plugins/tableexport_my/tableExport.js"></script>

<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.5&ak=8fe304aa75cf43abc8d33eb20564a9c7"></script>
        <!-- END THIS PAGE PLUGINS-->  
        
        <!-- START TEMPLATE -->
        <script type="text/javascript" src="js/settings.js"></script>
        
        <script type="text/javascript" src="js/plugins.js"></script>        
        <script type="text/javascript" src="js/actions.js"></script>        
        <!-- END TEMPLATE -->
    <!-- END SCRIPTS -->     
        <script>

            $(function(){

            /*
             *    百度地图API功能 -- 开始
             */

                var map = new BMap.Map("baidu_map");                    // 创建地图实例  
                var point = new BMap.Point(116.404, 39.915);            // 创建点坐标  
                map.centerAndZoom(point, 15);                           // 初始化地图，设置中心点坐标和地图级别 
                var marker = new BMap.Marker(point);                    // 创建标注    
                map.addOverlay(marker);                                 // 将标注添加到地图中
                var opts = {type: BMAP_NAVIGATION_CONTROL_SMALL}        // 设置放大缩小平移控件
                map.addControl(new BMap.NavigationControl(opts));       // 将控件添加到地图
                map.enableScrollWheelZoom();                            // 设置地图可用滑鼠缩放
                //单击获取点击的经纬度
                map.addEventListener("click",function(e){               // 绑定地图点击事件
                    point = new BMap.Point(e.point.lng, e.point.lat);   // 获取点击的经纬度并赋值
                    marker.setPosition(point);                          // 标注设置位置
                    $("#modal_expatriate_longitude").val(e.point.lng);  // 隐藏经度表单域
                    $("#modal_expatriate_latitude").val(e.point.lat);   // 隐藏纬度表单域
                    $("#baidu_map").siblings('.error').remove();        // 去除错误提示
                });


                function G(id) {
                    return document.getElementById(id);
                }

                var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
                    {"input" : "modal_expatriate_address"       //设置用于提示的输入框
                    ,"location" : map
                });

                ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
                var str = "";
                    var _value = e.fromitem.value;
                    var value = "";
                    if (e.fromitem.index > -1) {
                        value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
                    }    
                    str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
                    
                    value = "";
                    if (e.toitem.index > -1) {
                        _value = e.toitem.value;
                        value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
                    }    
                    str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
                    G("searchResultPanel").innerHTML = str;
                });

                var myValue;
                ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
                var _value = e.item.value;
                    myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
                    G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
                    
                    setPlace();
                });

                function setPlace(){
                    function myFun(){
                        var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
                        map.centerAndZoom(pp, 15);            // 设置中心点坐标和地图级别 
                        marker.setPosition(pp);
                        $("#modal_expatriate_longitude").val(pp.lng);
                        $("#modal_expatriate_latitude").val(pp.lat);
                        $("#baidu_map").siblings('.error').remove();
                    }
                    var local = new BMap.LocalSearch(map, { //智能搜索
                      onSearchComplete: myFun
                    });
                    local.search(myValue);
                }

            /*
             *    百度地图API功能 -- 结束
             */

            //岗位表格初始化
                var oTable1 = $("#expatriate_table").dataTable({
                    aoColumnDefs: [{
                        bSortable: false,
                        aTargets: [-1]
                    }]
                  });
                $('#expatriate_table').on('click', 'a.icon_delete', function (e) {
                    //获取表格id
                    var id = $(this).parents("tr").find('.id').text();
                    alert("要删除的id值为："+id);
                    e.preventDefault();
                    var nRow = $(this).parents('tr')[0];
                    oTable1.fnDeleteRow( nRow );
                });

                $("#modal_expatriate_employee").select2();

            //模态框 - 增加外派验证
                $("#modal_expatriate_form").validate({
                    ignore: "",
                    rules: {
                        name: {
                            required : true
                        },
                        employee: {
                            required : true
                        },
                        details: {
                            required : true
                        },
                        department : {
                            required : true
                        },
                        modaddress: {
                            required : true
                        },
                        time: {
                            required : true,
                            digits : true,
                            range : [1,99]
                        },
                        latitude: {
                            required : true
                        },
                        address: {
                            required : true
                        },
                        begindate:{
                        	required : true,
                            date : true
                        }
                    },
                    messages: {
                        name: {
                            required : '请您填写客户名称'
                        },
                        employee: {
                            required : '请您选择负责员工'
                        },
                        details: {
                            required : '请您填写项目描述'
                        },
                        department : {
                            required : '请您选择负责部门'
                        },
                        address: {
                            required : '请您填写客户地址'
                        },
                        time: {
                            required : '请您填写项目期限',
                            digits : '项目期限必须为数字',
                            range : '项目期限只能为1-99天'
                        },
                        latitude: {
                            required : '请在地图上点击客户地址'
                        },
                        address: {
                            required : '请您填写客户地址'
                        },
                        begindate:{
                        	required : '请您选择开始日期',
                            date : '日期格式不正确'
                        }
                    },
                    errorPlacement: function(error, element) {  
                        if ( element.attr("name") == "latitude") {
                            error.appendTo ( element.parent() );  
                        }else {
                            error.appendTo ( element.parent().parent() );  
                        };
                      error.addClass ("checkbox-inline");
                    },
                    submitHandler:function(form){
                        if (control_btn == 1) {
                        	$.post("addExpatriate.do", {
                        		name : $("#modal_expatriate_name").val(),
                        		employeeID : parseInt($("#modal_expatriate_employee").val()),
                        		details : $("#modal_expatriate_details").val(),
                        		address : $("#modal_expatriate_address").val(),
                        		longitude : $("#modal_expatriate_longitude").val(),
                        		latitude : $("#modal_expatriate_latitude").val(),
                        		begindate : $("#modal_expatriate_begindate").val(),
                        		deadline : $("#modal_expatriate_time").val()
                        	}, function(data, textStatus) {
        										if (data == true) {
	        										window.location.reload(true);
	        									} else {
	        										alert("存在错误,添加失败");
	        									}
                        	}, "json");
                        }else if(control_btn == 2){
                            alert("这是编辑");
                        };
                        // $(form).submit();
                    }
                });

                $("#modal_expatriate_department input[type='radio']").click(function() {
                    alert("选择的值为："+$(this).val()+"准备重置负责员工");
                    $("#modal_expatriate_employee").select2("destroy");
                    $("#modal_expatriate_employee").html("<option value='吴崇辉'>吴崇辉</option><option value='方赞潘'>方赞潘</option><option value='负责员工3'>负责员工3</option>");
                    $("#modal_expatriate_employee").select2();
                });

            //导出数据1
                var $exportLink1 = document.getElementById('export_ul1');
                $exportLink1.addEventListener('click', function(e){
                    e.preventDefault();
                    if(e.target.nodeName === "A"){
                        tableExport('post_table', '数据1', e.target.getAttribute('data-type'));
                    }
                    
                }, false);

                var control_btn = 0;        //控制传送位置

            //表格 - 编辑 - 按钮
                $(".icon_edit").click(function() {

                    control_btn = 2;    //改为编辑状态
                    $("#modal_edit_btn").removeClass('hidden');
                    $("#modal_add_btn").addClass('hidden');

                    //获取表格id
                    var id = $(this).parents("tr").find('.id').text();
                    //获取表格客户名称
                    var name = $(this).parents("tr").find('.name').text();
                    //获取表格负责部门
                    var charge_department = $(this).parents("tr").find('.charge_department').text();
                    //获取表格项目期限
                    var time = $(this).parents("tr").find('.time').text();
                    //获取表格客户地址
                    var address = $(this).parents("tr").find('.address').text();

                    //获取表格隐藏数据 - 项目描述
                    var details = $(this).siblings('.hide_info').find('.details').text();
                    //获取表格隐藏数据 - 经度
                    var longitude = $(this).siblings('.hide_info').find('.longitude').text();
                    //获取表格隐藏数据 - 纬度
                    var latitude = $(this).siblings('.hide_info').find('.latitude').text();
                    //获取表格隐藏数据 - 开始日期
                    var latitude = $(this).siblings('.hide_info').find('.begindate').text();

                    var charge_employee_array = new Array();

                    //模态框 - 赋值
                    $("#modal_expatriate_id").val(id);      //id赋值
                    $("#modal_expatriate_name").val(name);  //客户名称赋值
                    //负责部门赋值
                    $("#modal_expatriate_department input[type='radio']").each(function() {
                        if ($(this).val() == charge_department) {
                            $(this).click();
                        };
                    });
                    //获取表格负责员工 - 存进数组
                    $(this).parents("tr").find('.charge_employee > span').each(function(index){
                        charge_employee_array[index] = $(this).text();
                    });
                    //负责员工赋值
                    $("#modal_expatriate_employee").select2("val", charge_employee_array);
                    //项目描述赋值
                    $("#modal_expatriate_details").val(details);
                    //客户地址赋值
                    $("#modal_expatriate_address").val(address);

                    //客户地图赋值
                    var point = new BMap.Point(longitude, latitude);            // 创建点坐标  
                    map.centerAndZoom(point, 15);            // 设置中心点坐标和地图级别 
                    marker.setPosition(point);
					//经度赋值
                    $("#modal_expatriate_longitude").val(pp.lng);
					//纬度赋值
                    $("#modal_expatriate_latitude").val(pp.lat);
                    //开始日期赋值
                    $("#modal_expatriate_begindate").val(begindate);
                    //项目期限赋值
                    $("#modal_expatriate_time").val(time);

                    //去除错误提示
                    $("#modal_expatriate .error").remove();

                });
            
            //表格 - 添加 - 按钮
                $("#modal_expatriate_trigger").click(function(){

                    control_btn = 1;    //改为编辑状态
                    $("#modal_edit_btn").addClass('hidden');
                    $("#modal_add_btn").removeClass('hidden');

                    $("#modal_expatriate_id").val(null);      //id赋值
                    $("#modal_expatriate_name").val(null);  //客户名称赋值
                    //负责员工赋值
                    $("#modal_expatriate_employee").select2("val", null);
                    //项目描述赋值
                    $("#modal_expatriate_details").val(null);
                    //客户地址赋值
                    $("#modal_expatriate_address").val(null);
                    //开始日期赋值
                    $("#modal_expatriate_begindate").val(null);
                    //项目期限赋值
                    $("#modal_expatriate_time").val(null);
                })

            });

            </script>
    </body>
</html>
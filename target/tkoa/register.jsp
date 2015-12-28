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
<!DOCTYPE html>
<html lang="en">
    <head>       
    	<base href="<%=basePath%>"> 
        <!-- META SECTION -->
        <title>诺特考勤管理系统--用户激活</title>         
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        
        <link rel="icon" href="favicon.ico" type="image/x-icon" />
        <!-- END META SECTION -->
        
        <!-- CSS INCLUDE -->        
        <link rel="stylesheet" type="text/css" id="theme" href="css/theme-default.css"/>
        <!-- EOF CSS INCLUDE -->
        <link rel="stylesheet" type="text/css" href="css/select2/select2_2.css"/>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>                                 
    </head>
    <body>
        
        <div class="login-container lightmode">
        
            <div class="login-box animated fadeInDown">
                <div class="login-logo"></div>
                <div class="login-body">
                    <div class="login-title">用户激活</div>
                    <form action="" class="form-horizontal" method="post" id="register_form">
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="input-group" style="width:100%">
                                    <select name="employeeID" style="width:100%" id="realname">
                                        <option value="00">员工已经全部激活</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <input type="text" class="form-control" placeholder="请输入您的手机号" name="phone" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <input type="password" class="form-control" placeholder="请输入您的密码" name="password" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <input type="password" class="form-control" placeholder="请再次输入您的密码" name="password2" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6">
                                <a href="login.jsp" class="btn btn-info btn-block"><i class="fa fa-reply"></i>返回登录</a>
                            </div>
                            <div class="col-md-6">
                                <button id="activate" disabled="disbaled" class="btn btn-primary btn-block"><i class="glyphicon glyphicon-ok-sign"></i>激活</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="login-footer">
                    <div class="pull-left">
                        &copy; 2015 TKOA
                    </div>
                </div>
            </div>
            
        </div>
        
        <script type="text/javascript" src="js/plugins/jquery/jquery.min.js"></script>
        <script type="text/javascript" src="js/plugins/select2/select2_2.js"></script>
        <script type='text/javascript' src='js/plugins/jquery-validation/jquery.validate.js'></script> 
        <script type="text/javascript">
            $(function(){
               	$.ajax({
               	    url: '<%=basePath %>getNames.do',
               	    type: 'POST',
               	})
               	.done(function(data) {
                	  var d = eval(data);
                	  if( d[0] != null ){
                    	  var name_value="";
    	              	  for( var i=0;i<d.length;i++ ){
    	              		  name_value += "<option value='"+d[i].employeeID+"'>"+d[i].name+"</option>";
    	              	  }
    	              	  $("#realname").select("destroy");
    	              	  $("#realname").html(name_value);
    	              	  $("#realname").select2({
    	                        placeholder: "请选择姓名",
    	                        width : '100%'
    	                  });
                		  $("#activate").removeAttr("disabled");  
                	  }else {
                		  $("#activate").attr("disabled",true); 
                	  }
               	})
               	.fail(function(data) {
               		alert("ajax error:"+data.status);
               	});
            	
                //$("select[name='realname']").select2({
                //    placeholder:"请您选择姓名"
                //});
                // 密码的验证 
                jQuery.validator.addMethod("password", function(value, element) { 
                var password = /(?!^[0-9]+$)(?!^[a-z]+$)(?!^[^A-z0-9]+$)^.{6,16}$/; 
                return this.optional(element) || (password.test(value)); 
                }, "密码必须为6-16个字母加数字或符号的组合密码"); 
                // 手机号码验证 
                jQuery.validator.addMethod("mobile", function(value, element) { 
                var length = value.length; 
                var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/ 
                return this.optional(element) || (length == 11 && mobile.test(value)); 
                }, "手机号码格式错误"); 
                $("#register_form").validate({
                    rules: {                                            
                        phone: {
                            required: true,
                            mobile: true
                        },
                        realname: {
                            required: true
                        },
                        password: {
                            required: true,
                            password: true
                        },
                        password2: {
                            required: true,
                            equalTo: 'input[name="password"]',
                            password: true
                        }
                    },
                    messages: {
                        phone: {
                            required: '请您填写手机号'
                        },
                        realname: {
                            required: '请您选择姓名'
                        },
                        password: {
                            required: '请您填写密码'
                        },
                        password2: {
                            required: '请您填写密码',
                            equalTo: '两次输入密码不一致'
                        }
                    }                                     
                });   
                
              //添加--提交
                $("#activate").click(function(){
                	$.ajax({
                	    url: '<%=basePath %>register.do',
                	    type: 'POST',
                	    data: $('#register_form').serialize(),
                	})
                	.done(function(data) {
                		alert(data);
                		if( data == "SUCCESS" ){
                			alert("激活成功,点击返回登录界面");
                			//location.href="index.jsp";
                		}else if( "TEL_NOT_THE_SAME_NAME" == data ){
                			alert("激活失败,真实姓名与手机号码不匹配");
                		}else if( data == "NOT_FOUND_EMPLOYEE" ){
                			alert("激活失败,没有找到该员工");
                		}else if( data == "ALREADY_REGISTER" ){
                			alert("该员工已激活,请直接登录");
                			//location.href="index.jsp";
                		}else{
                			alert("激活失败,请检查或者刷新后重新激活");
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
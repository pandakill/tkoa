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
        <title>诺特</title>            
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        
        <link rel="icon" href="favicon.ico" type="image/x-icon" />
        <!-- END META SECTION -->
        
        <!-- CSS INCLUDE -->        
        <link rel="stylesheet" type="text/css" id="theme" href="css/theme-default.css"/>
        <!-- EOF CSS INCLUDE -->
        <link rel="stylesheet" type="text/css" href="css/login.css?v=1"/>                                 
    </head>
    <body>
        
        <div class="login-container lightmode">
        
            <div class="login-box animated fadeInDown">
                <div class="login-logo"></div>
                <div class="login-body">
                    <div class="login-title">重置密码</div>
                    <form action="index.html" class="form-horizontal" method="post" id="login_form">
                        <div class="form-group">
                            <div class="col-md-12">
                                <input type="password" class="form-control" placeholder="请输入您的手机号码" name="phone" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="请输入您的验证码" name="code" />
                            </div>
                            <div class="col-md-4">
                                <button class="btn btn-info btn-block" type="button" id="get_code">获取验证码</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <input type="password" class="form-control" placeholder="请输入您的密码" name="password" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6">
                                <a href="login.html" class="btn btn-info btn-block"><i class="fa fa-reply"></i>返回登录</a>
                            </div>
                            <div class="col-md-6">
                                <button class="btn btn-primary btn-block" type="submit"><i class="glyphicon glyphicon-ok-sign"></i>重置密码</button>
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
        <script type='text/javascript' src='js/plugins/jquery-validation/jquery.validate.js'></script> 
        <script type="text/javascript">
            $("#login_form").validate({
                rules: {                                            
                    phone: {
                        required: true,
                        digits: true,
                        minlength: 11,
                        maxlength: 11
                    },
                    password: {
                        required: true
                    },
                    code: {
                        required: true,
                        digits: true,
                    }
                },
                messages: {
                    phone: {
                        required: '请您填写手机号',
                        digits: '手机号码必须为数字',
                        minlength: '手机号必须为11位数字',
                        maxlength: '手机号必须为11位数字'
                    },
                    password: {
                        required: '请您填写密码'
                    },
                    code: {
                        required: '请您填写验证码',
                        digits: '验证码必须为数字',
                    }
                }                                     
            });   
        </script>
    </body>
</html>
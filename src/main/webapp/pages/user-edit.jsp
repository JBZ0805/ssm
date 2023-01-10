<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="js-library.jsp" %>
<%@include file="css-library.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" charset="UTF-8">
    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="header.jsp"/>
    <!-- 页面头部 /-->
    <!-- 导航侧栏 -->
    <jsp:include page="aside.jsp"/>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                用户管理<small>用户表单</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/pages/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/user/findAllUser">用户管理</a></li>
                <li class="active">用户表单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->
        <form action="${pageContext.request.contextPath}/user/edit" method="post">
            <!--id隐藏域-->
            <input type="hidden" name="id" value="${result.get("user").id}">
            <!-- 正文区域 -->
            <section class="content"> <!--产品信息-->
                <div class="panel panel-default">
                    <div class="panel-heading">修改用户信息</div>
                    <div class="row data-type">
                        <div class="col-md-2 title">用户名</div>
                        <div class="col-md-4 data">
                            <label>
                                <input type="text" class="form-control" name="username" placeholder="用户名"
                                       value="${result.get("user").username}">
                            </label>
                        </div>
                        <div class="col-md-2 title">用户密码</div>
                        <div class="col-md-4 data">
                            <label>
                                <input type="text" class="form-control" name="password" placeholder="用户密码"
                                       value="${result.get("user").password}">
                            </label>
                        </div>
                        <div class="col-md-2 title">用户邮箱</div>
                        <div class="col-md-4 data">
                            <label>
                                <input type="text" class="form-control" name="email" placeholder="用户邮箱"
                                       value="${result.get("user").email}">
                            </label>
                        </div>
                        <div class="col-md-2 title">手机号</div>
                        <div class="col-md-4 data">
                            <label>
                                <input type="text" class="form-control" name="phoneNum" placeholder="手机号"
                                       value="${result.get("user").phoneNum}">
                            </label>
                        </div>
                        <div class="col-md-2 title">用户角色</div>
                        <div class="col-md-10 data">
                            <c:forEach items="${result.get('roles')}" var="role">
                                <c:if test="${fn:contains(result.get('user').roles,role.id)}">
                                    <label>
                                        <input class="" type="checkbox" name="roleIds" checked="checked" value="${role.id}">
                                    </label>${role.roleDesc}
                                </c:if>
                                <c:if test="${!fn:contains(result.get('user').roles,role.id)}">
                                    <label>
                                        <input class="" type="checkbox" name="roleIds" value="${role.id}">
                                    </label>${role.roleDesc}
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <!--订单信息/--> <!--工具栏-->
                <div class="box-tools text-center">
                    <button type="submit" class="btn bg-maroon">保存</button>
                    <button type="button" class="btn bg-default"
                            onclick="history.back(-1);">返回
                    </button>
                </div>
                <!--工具栏/-->
            </section>
            <!-- 正文区域 /-->
        </form>
    </div>
    <!-- 内容区域 /-->
    <!-- 底部导航 -->
    <jsp:include page="footer.jsp"/>
    <!-- 底部导航 /-->

</div>
</body>

</html>
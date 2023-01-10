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
            <h1>角色管理 <small>角色表单</small></h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/pages/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/role/queryAllRole">角色管理</a></li>
                <li class="active">角色表单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->
        <form action="${pageContext.request.contextPath}/role/edit" method="post">
            <!--id隐藏域-->
            <input type="hidden" name="id" value="${data.get('role').id}">
            <!-- 正文区域 -->
            <section class="content"> <!--产品信息-->
                <div class="panel panel-default">
                    <div class="panel-heading">修改角色信息</div>
                    <div class="row data-type">
                        <div class="col-md-2 title">角色名称</div>
                        <div class="col-md-4 data">
                            <label>
                                <input type="text" class="form-control" name="roleName" placeholder="角色名称"
                                       value="${data.get('role').roleName}">
                            </label>
                        </div>
                        <div class="col-md-2 title">角色描述</div>
                        <div class="col-md-4 data">
                            <label>
                                <input type="text" class="form-control" name="roleDesc" placeholder="角色描述"
                                       value="${data.get('role').roleDesc}">
                            </label>
                        </div>
                        <div class="col-md-2 title">角色权限</div>
                        <div class="col-md-10 data">
                            <c:forEach items="${data.get('permissions')}" var="permission">
                                    <c:if test="${fn:contains(data.get('role').permissions,permission.id)}">
                                        <label>
                                            <input class="" type="checkbox" name="permissionIds" checked="checked" value="${permission.id}">
                                        </label>${permission.permissionName}
                                    </c:if>
                                    <c:if test="${!fn:contains(data.get('role').permissions,permission.id)}">
                                        <label>
                                            <input class="" type="checkbox" name="permissionIds"  value="${permission.id}">
                                        </label>${permission.permissionName}
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
                <!--工具栏/--> </section>
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
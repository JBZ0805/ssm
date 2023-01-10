<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1>旅客管理<small>旅客表单</small></h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/pages/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="${pageContext.request.contextPath}/traveller/queryAllTraveller">旅客管理</a></li>
                <li class="active">旅客表单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->
        <form action="${pageContext.request.contextPath}/traveller/save" method="post">
            <!-- 正文区域 -->
            <section class="content"> <!--产品信息-->
                <div class="panel panel-default">
                    <div class="panel-heading">修改旅客信息</div>
                    <input type="hidden" name="id" value="${traveller.id}">
                    <div class="row data-type">
                        <div class="col-md-2 title">旅客姓名</div>
                        <div class="col-md-4 data">
                            <label>
                                <input type="text" class="form-control" name="name" placeholder="旅客姓名"
                                       value="${traveller.name}">
                            </label>
                        </div>
                        <div class="col-md-2 title">性别</div>
                        <div class="col-md-4 data">
                            <label>
                                <c:if test="${traveller.sex eq '男'}">
                                    <input type="radio" class="radio-inline" name="sex" checked="checked" value="男">男
                                    <input type="radio" class="radio-inline" name="sex" value="女">女
                                </c:if>
                                <c:if test="${traveller.sex eq '女'}">
                                    <input type="radio" class="radio-inline" name="sex" value="男">男
                                    <input type="radio" class="radio-inline" name="sex" checked="checked" value="女">女
                                </c:if>
                            </label>
                        </div>
                        <div class="col-md-2 title">手机号</div>
                        <div class="col-md-4 data">
                            <label>
                                <input type="text" class="form-control" name="phoneNum" placeholder="手机号"
                                       value="${traveller.phoneNum}">
                            </label>
                        </div>
                        <div class="col-md-2 title">证件类型</div>
                        <div class="col-md-4 data">
                            <label>
                                <c:if test="${traveller.credentialsType==0}">
                                    <input type="radio" class="radio-inline" name="credentialsType" checked="checked"
                                           value="0">身份证
                                    <input type="radio" class="radio-inline" name="credentialsType" value="1">护照
                                    <input type="radio" class="radio-inline" name="credentialsType" value="2">军官证
                                </c:if>
                                <c:if test="${traveller.credentialsType==1}">
                                    <input type="radio" class="radio-inline" name="credentialsType" value="0">身份证
                                    <input type="radio" class="radio-inline" name="credentialsType" checked="checked"
                                           value="1">护照
                                    <input type="radio" class="radio-inline" name="credentialsType" value="2">军官证
                                </c:if>
                                <c:if test="${traveller.credentialsType==2}">
                                    <input type="radio" class="radio-inline" name="credentialsType"
                                           value="0">身份证
                                    <input type="radio" class="radio-inline" name="credentialsType" value="1">护照
                                    <input type="radio" class="radio-inline" name="credentialsType" checked="checked"
                                           value="2">军官证
                                </c:if>
                            </label>
                        </div>
                        <div class="col-md-2 title">证件号码</div>
                        <div class="col-md-4 data">
                            <label>
                                <input type="text" class="form-control" name="credentialsNum" placeholder="证件号码"
                                       value="${traveller.credentialsNum}">
                            </label>
                        </div>
                        <div class="col-md-2 title">旅客类型</div>
                        <div class="col-md-4 data">
                            <label>
                                <c:if test="${traveller.travellerType==0}">
                                    <input type="radio" class="radio-inline" name="travellerType" checked="checked" value="0">成人
                                    <input type="radio" class="radio-inline" name="travellerType" value="1">儿童
                                </c:if>
                                <c:if test="${traveller.travellerType==1}">
                                    <input type="radio" class="radio-inline" name="travellerType"  value="0">成人
                                    <input type="radio" class="radio-inline" name="travellerType" checked="checked" value="1">儿童
                                </c:if>
                            </label>
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
<script type="text/javascript">
    $(document).ready(function () {
        // 选择框
        $(".select2").select2();
        // MSHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        const liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }
</script>


</body>

</html>
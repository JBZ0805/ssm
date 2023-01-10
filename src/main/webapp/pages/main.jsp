<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="js-library.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" charset="UTF-8">
    <title>AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <%@include file="css-library.jsp" %>
</head>
<body class="hold-transition skin-blue sidebar-mini">
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
            <h1>控制面板<small>首页</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="index.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
            </ol>
        </section>
        <!-- 统计数值 -->
        <section class="content">
            <div class="row">
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-yellow">
                        <div class="inner">
                            <c:if test="${exceptionNum==null}">
                                <h3>0</h3>
                            </c:if>
                            <c:if test="${exceptionNum!=null}">
                                <h3>${exceptionNum}</h3>
                            </c:if>
                            <p>异常总数</p>
                        </div>
                        <div class="icon" style="padding: 10px">
                            <i class="ion ion-alert-circled"></i>
                        </div>
                        <a href="${pageContext.request.contextPath}/sysLog/findAll" class="small-box-footer">详细 <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-red">
                        <div class="inner">
                            <c:if test="${permissionNum==null}">
                                <h3>0</h3>
                            </c:if>
                            <c:if test="${permissionNum!=null}">
                                <h3>${permissionNum}</h3>
                            </c:if>
                            <p>权限拦截</p>
                        </div>
                        <div class="icon" style="padding: 10px">
                            <i class="ion  ion-ios-locked"></i>
                        </div>
                        <a href="${pageContext.request.contextPath}/sysLog/findAll" class="small-box-footer">详细 <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-aqua">
                        <div class="inner">
                            <c:if test="${orderNum==null}">
                                <h3>0</h3>
                            </c:if>
                            <c:if test="${orderNum!=null}">
                                <h3>${orderNum}</h3>
                            </c:if>
                            <p>新增订单</p>
                        </div>
                        <div class="icon" style="padding: 10px">
                            <i class="ion ion-bag"></i>
                        </div>
                        <a href="${pageContext.request.contextPath}/orders/queryAllOrders" class="small-box-footer">详细 <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-green">
                        <div class="inner">
                            <c:if test="${visitNum==null}">
                                <h3>0</h3>
                            </c:if>
                            <c:if test="${visitNum!=null}">
                                <h3>${visitNum}</h3>
                            </c:if>
                            <p>总访问量</p>
                        </div>
                        <div class="icon" style="padding: 10px">
                            <i class="ion  ion-person-stalker"></i>
                        </div>
                        <a href="${pageContext.request.contextPath}/sysLog/findAll" class="small-box-footer">详细 <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                <!-- ./col -->
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <!-- interactive chart -->
                    <div class="box box-primary">
                        <div class="box-body">
                            <div id="interactive" style="height: 300px;">
                                <img src="../img/center.jpg" alt="" width="100%" height="350">
                            </div>
                        </div>
                        <!-- /.box-body-->
                    </div>
                    <!-- /.box -->

                </div>
                <!-- /.col -->
            </div>
        </section>
    </div>

    <!-- /.row -->
    <!-- 内容区域 /-->
    <!-- 底部导航 -->
    <jsp:include page="footer.jsp"/>
    <!-- 底部导航 /-->
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        // 选择框
        $(".select2").select2();
        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(document).ready(function () {
        // 激活导航位置
        setSidebarActive("admin-index");
    });


</script>


</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                产品管理 <small>产品表单</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/pages/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/product/queryProductList">产品管理</a></li>
                <li class="active">产品表单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->
        <form action="${pageContext.request.contextPath}/product/edit" method="post">
            <!--id隐藏域-->
            <input type="hidden" name="id" value="${product.id}">
            <!-- 正文区域 -->
            <section class="content"> <!--产品信息-->
                <div class="panel panel-default">
                    <div class="panel-heading">修改产品信息</div>
                    <div class="row data-type">
                        <div class="col-md-2 title">产品编号</div>
                        <div class="col-md-4 data">
                            <label>
                                <input type="text" class="form-control" name="productNum" placeholder="产品编号"
                                       value="${product.productNum}">
                            </label>
                        </div>
                        <div class="col-md-2 title">产品名称</div>
                        <div class="col-md-4 data">
                            <label>
                                <input type="text" class="form-control" name="productName" placeholder="产品名称"
                                       value="${product.productName}">
                            </label>
                        </div>
                        <div class="col-md-2 title">出发城市</div>
                        <div class="col-md-4 data">
                            <label>
                                <input type="text" class="form-control" name="cityName" placeholder="出发城市" value="${product.cityName}">
                            </label>
                        </div>
                        <div class="col-md-2 title">出发时间</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <label for="datepicker-a3"></label>
                                <input type="text" class="form-control pull-right" id="datepicker-a3"
                                       name="departureTime" value='<fmt:formatDate value='${product.departureTime}' pattern='yyyy-MM-dd'/>'>
                            </div>
                        </div>
                        <div class="col-md-2 title">产品价格</div>
                        <div class="col-md-4 data">
                            <label>
                                <input type="text" class="form-control" name="productPrice" placeholder="产品价格"
                                       value="${product.productPrice}">
                            </label>
                        </div>
                        <div class="col-md-2 title">产品状态</div>
                        <div class="col-md-4 data">
                            <label>
                                <select class="form-control select2" style="width: 100%"
                                        name="productStatus">
                                    <option value="0" <c:if test="${product.productStatus eq 0}">selected="selected"</c:if>>下架</option>
                                    <option value="1" <c:if test="${product.productStatus eq 1}">selected="selected"</c:if>>上架</option>
                                </select>
                            </label>
                        </div>
                        <div class="col-md-2 title rowHeight2x">产品描述</div>
                        <div class="col-md-10 data rowHeight2x">
                            <textarea class="form-control" rows="3" placeholder="产品描述" name="productDesc">${product.productDesc}</textarea>
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
    $(document).ready(function() {
        // 选择框
        $(".select2").select2();
        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale : 'zh-CN'
        });
    });
    $(document).ready(function () {
        $('#datepicker-a3').datetimepicker({
            format: "yyyy-mm-dd",
            autoclose: true,
            todayBtn: true,
            language: "zh-CN"
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
        setSidebarActive("order-manage");
        $("#datepicker-a3").datetimepicker({
            format: "yyyy-mm-dd",
        });
    });
</script>


</body>

</html>
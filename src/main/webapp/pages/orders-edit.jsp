<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="js-library.jsp" %>
<%@include file="css-library.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <style type="text/css">
    </style>
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
            <h1>订单管理 <small>订单表单</small></h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/pages/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="${pageContext.request.contextPath}/orders/queryAllOrders">订单管理</a></li>
                <li class="active">订单表单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->
        <!-- 正文区域 -->
        <section class="content">
            <!--产品信息-->
            <form action="${pageContext.request.contextPath}/orders/edit" method="post">
                <input type="hidden" name="id" value="${data.get('orders').id}">
                <div class="panel panel-default">
                    <div class="panel-heading">修改订单信息</div>
                    <div class="row data-type">
                        <div class="col-md-2 title">订单编号</div>
                        <div class="col-md-4 data">
                            <label>
                                <input type="text" class="form-control" name="orderNum" placeholder="订单编号" value="${data.get('orders').orderNum}">
                            </label>
                        </div>
                        <div class="col-md-2 title">订单时间</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <label for="datepicker-a3"></label>
                                <input type="text" class="form-control pull-right" id="datepicker-a3"
                                       name="orderTime" value='<fmt:formatDate value="${data.get('orders').orderTime}" pattern='yyyy-MM-dd HH:mm:ss'/>'>
                            </div>
                        </div>
                        <div class="col-md-2 title">订单人数</div>
                        <div class="col-md-4 data">
                            <label>
                                <input type="text" class="form-control" name="peopleCount" placeholder="订单人数"
                                       value="${data.get('orders').peopleCount}">
                            </label>
                        </div>
                        <div class="col-md-2 title">产品选择</div>
                        <div class="col-md-4 data">
                                <select class="form-control select2" style="width: 100%;" name="productId">
                                    <c:forEach items="${data.get('products')}" var="product">
                                        <c:if test="${data.get('orders').product.id==product.id}">
                                            <option value="${product.id}" selected="selected">${product.productName}</option>
                                        </c:if>
                                        <c:if test="${data.get('orders').product.id!=product.id}">
                                            <option value="${product.id}">${product.productName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                        </div>
                        <div class="col-md-2 title">订单负责人选择</div>
                        <div class="col-md-4 data">
                                <select class="form-control select2" style="width: 100%;" name="memberId">
                                    <c:forEach items="${data.get('members')}" var="member">
                                        <c:if test="${data.get('orders').member.id==member.id}">
                                            <option value="${member.id}" selected="selected">${member.name}</option>
                                        </c:if>
                                        <c:if test="${data.get('orders').member.id!=member.id}">
                                            <option value="${member.id}">${member.name}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                        </div>
                        <div class="col-md-2 title">选择旅客</div>
                        <div class="col-md-4 data" id="addTraveller">
                                <select class="form-control select2" style="width: 100%;" name="travellerIds" multiple="multiple" data-placeholder="可多选">
                                    <c:forEach items="${data.get('travellers')}" var="traveller">
                                        <c:if test="${fn:contains(data.get('orders').travellerList,traveller.id)}">
                                            <option value="${traveller.id}" selected="selected">${traveller.name}</option>
                                        </c:if>
                                        <c:if test="${!fn:contains(data.get('orders').travellerList,traveller.id)}">
                                            <option value="${traveller.id}">${traveller.name}</option>
                                        </c:if>

                                    </c:forEach>
                                </select>
                        </div>
                        <div class="col-md-2 title">支付方式</div>
                        <div class="col-md-4 data">
                            <label>
                                <c:if test="${data.get('orders').payType==0}">
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="0" checked="checked">未支付
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="1">微信
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="2">支付宝
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="3">现金
                                </c:if>
                                <c:if test="${data.get('orders').payType==1}">
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="0">未支付
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="1" checked="checked">微信
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="2">支付宝
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="3">现金
                                </c:if>
                                <c:if test="${data.get('orders').payType==2}">
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="0">未支付
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="1">微信
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="2" checked="checked">支付宝
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="3">现金
                                </c:if>
                                <c:if test="${data.get('orders').payType==3}">
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="0">未支付
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="1">微信
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="2">支付宝
                                    <input type="radio" class="radio-inline"
                                           name="payType" value="3" checked="checked">现金
                                </c:if>
                            </label>
                        </div>
                        <div class="col-md-2 title">订单状态</div>
                        <div class="col-md-4 data">
                            <label>
                                <c:if test="${data.get('orders').orderStatus==0}">
                                    <input type="radio" class="radio-inline"
                                           name="orderStatus" value="0" checked="checked">已取消
                                    <input type="radio" class="radio-inline"
                                           name="orderStatus" value="1">已完成
                                    <input type="radio" class="radio-inline"
                                           name="orderStatus" value="2">未支付
                                </c:if>
                                <c:if test="${data.get('orders').orderStatus==1}">
                                    <input type="radio" class="radio-inline"
                                           name="orderStatus" value="0">已取消
                                    <input type="radio" class="radio-inline"
                                           name="orderStatus" value="1" checked="checked">已完成
                                    <input type="radio" class="radio-inline"
                                           name="orderStatus" value="2">未支付
                                </c:if>
                                <c:if test="${data.get('orders').orderStatus==2}">
                                    <input type="radio" class="radio-inline"
                                           name="orderStatus" value="0">已取消
                                    <input type="radio" class="radio-inline"
                                           name="orderStatus" value="1">已完成
                                    <input type="radio" class="radio-inline"
                                           name="orderStatus" value="2" checked="checked">未支付
                                </c:if>
                            </label>
                        </div>
                        <div class="col-md-2 title rowHeight2x">订单描述</div>
                        <div class="col-md-10 data rowHeight2x">
                            <textarea class="form-control" rows="3" placeholder="订单描述"
                                      name="orderDesc">${data.get('orders').orderDesc}</textarea>
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
            </form>
            <!--工具栏/--> </section>
        <!-- 正文区域 /-->
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
        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });
    $(document).ready(function () {
        $('#datepicker-a3').datetimepicker({
            format: "yyyy-mm-dd hh:mm:ss",
            autoclose: true,
            todayBtn: true,
            language: "zh-CN",
            timeZone:"Asia/Shanghai"
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
            format: "yyyy-mm-dd hh:mm:ss",
        });
    });
</script>


</body>

</html>
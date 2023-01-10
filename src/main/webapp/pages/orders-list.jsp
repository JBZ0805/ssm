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
    <script type="text/javascript">
        function delOrder(id) {
            if (confirm("您确认要删除吗")) {
                location.href = "${pageContext.request.contextPath}/orders/delOrderById?id=" + id;
            }
        }
    </script>
    <style type="text/css">
        .has-feedback {
            width: 330px;
        }

        #input-label {
            width: 250px;
        }

        #search_input {
            width: 250px;
        }

        td {
            font-size: 15px;
            padding: 5px;
            text-align: center;
        }

        th {
            text-align: center;
        }
        #pages {
            width: 72px;
            height: 34px;
            padding: 0;
        }
    </style>
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
            <h1>
                订单管理 <small>全部订单</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/pages/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/orders/findAllOrders">订单管理</a></li>

                <li class="active">全部日志</li>
            </ol>
        </section>
        <!-- 内容头部 /-->
        <!-- 正文区域 -->
        <section class="content"> <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">订单列表</h3>
                </div>
                <div class="box-body">
                    <!-- 数据表格 -->
                    <div class="table-box">
                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="添加"
                                            onclick="location.href='${pageContext.request.contextPath}/orders/queryData'">
                                        <i class="fa fa-plus-square-o"></i> 添加订单
                                    </button>
                                    <button type="button" class="btn btn-default" title="批量删除" id="batchDelete">
                                        <i class="fa fa-trash-o"></i> 批量删除
                                    </button>
                                    <button type="button" class="btn btn-default" title="刷新"
                                            onclick="window.location.reload();">
                                        <i class="fa fa-refresh"></i> 刷新
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <label id="input-label">
                                    <input type="text" class="form-control input-sm" placeholder="按订单编号搜索"
                                           id="search_input" value="">
                                </label>
                                <button type="button" class="btn btn-default" title="搜索" id="search">
                                    <i class="fa fa-search"></i> 搜索
                                </button>
                            </div>
                        </div>

                        <!--工具栏/-->
                        <!--数据列表-->
                        <table id="dataList"
                               class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="" style="padding-right: 0">
                                    <label for="selall"></label><input id="selall" type="checkbox" class="icheckbox_square-blue">
                                </th>
                                <th class="sorting">订单编号</th>
                                <th class="sorting">订单时间</th>
                                <th class="sorting">订单人数</th>
                                <th class="sorting">订单描述</th>
                                <th class="sorting">支付方式</th>
                                <th class="sorting">订单状态</th>
                                <th class="sorting">产品名称</th>
                                <th class="sorting">订单负责人</th>
                                <th class="sorting">订单操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageInfo.list}" var="order" varStatus="status">
                                <tr>
                                    <td><label>
                                        <input name="ids" type="checkbox" value="${order.id}">
                                    </label></td>
                                    <td>${order.orderNum}</td>
                                    <td><fmt:formatDate value="${order.orderTime}"
                                                        pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                    <td>${order.peopleCount }人</td>
                                    <td>${order.orderDesc }</td>
                                    <c:if test="${order.payType==0}">
                                        <td>未支付</td>
                                    </c:if>
                                    <c:if test="${order.payType==1}">
                                        <td>微信</td>
                                    </c:if>
                                    <c:if test="${order.payType==2}">
                                        <td>支付宝</td>
                                    </c:if>
                                    <c:if test="${order.payType==3}">
                                        <td>现金</td>
                                    </c:if>
                                    <c:if test="${order.orderStatus==0}">
                                        <td>已取消</td>
                                    </c:if>
                                    <c:if test="${order.orderStatus==1}">
                                        <td>已完成</td>
                                    </c:if>
                                    <c:if test="${order.orderStatus==2}">
                                        <td>未支付</td>
                                    </c:if>
                                    <td>${order.product.productName}</td>
                                    <td>${order.member.name}</td>
                                    <td class="text-center">
                                        <button type="button" class="btn bg-blue btn-xs" onclick="location.href='${pageContext.request.contextPath}/orders/queryOrdersById?id=${order.id}'">编辑
                                        </button>
                                        <button type="button" class="btn bg-olive btn-xs" onclick="delOrder(${order.id})">删除
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                        <!--数据列表/-->

                    </div>
                    <!-- 数据表格 /-->

                </div>
                <!-- /.box-body -->

                <!-- .box-footer-->
                <!--分页begin-->
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            总共${pageInfo.pages}页，共${pageInfo.size}条数据。 每页
                            <select class="form-control" id="changePageSize" onchange="changePageSize()">
                                <option value="6" <c:if test="${pageInfo.pageSize eq 6}"> selected </c:if>>6
                                </option>
                                <option value="8" <c:if test="${pageInfo.pageSize eq 8}"> selected </c:if>>8
                                </option>
                                <option value="10" <c:if test="${pageInfo.pageSize eq 10}"> selected </c:if>>10
                                </option>
                            </select> 条
                        </div>
                    </div>

                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <li>
                                <a href="${pageContext.request.contextPath}/orders/queryAllOrders?pageNum=1&pageSize=${pageInfo.pageSize}"
                                   aria-label="Previous">首页</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/orders/queryAllOrders?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}">上一页</a>
                            </li>
                            <li>
                                <div class="col-md-4 data" id="pages">
                                    <label for="pageSelect"></label><select class="form-control select2"
                                                                            style="width: 100%;" id="pageSelect">
                                    <c:forEach begin="1" end="${pageInfo.pages}" var="pageNow">
                                        <c:if test="${pageNow==pageInfo.pageNum}">
                                            <option value="${pageNow}" selected="selected">第${pageNow}页</option>
                                        </c:if>
                                        <c:if test="${pageNow!=pageInfo.pageNum}">
                                            <option value="${pageNow}">第${pageNow}页</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                                </div>
                            </li>
                            <c:if test="${pageInfo.pageNum == pageInfo.pages}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/orders/queryAllOrders?pageNum=${pageInfo.pageNum}&pageSize=${pageInfo.pageSize}">下一页</a>
                                </li>
                            </c:if>
                            <c:if test="${pageInfo.pageNum != pageInfo.pages}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/orders/queryAllOrders?pageNum=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}">下一页</a>
                                </li>
                            </c:if>
                            <li>
                                <a href="${pageContext.request.contextPath}/orders/queryAllOrders?pageNum=${pageInfo.pages}&pageSize=${pageInfo.pageSize}"
                                   aria-label="Next">尾页</a>
                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /.box-footer-->
                <!--分页end-->
                <!-- /.box-footer-->
            </div>

        </section>
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
        // 列表按钮
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
        // 全选操作
        $("#selall").click(function () {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
    //批量删除
    $("#batchDelete").on("click", function () {
        if (confirm("你确定要批量删除吗?")) {
            //把要选择的id放到一个数组中
            let ids = [];
            //获取每个选中的id
            $("input[name='ids']:checked").each(function () {
                ids.push($(this).val())
            })
            // console.log(ids)
            //把获取的ids数组提交到后台
            location.href = "${pageContext.request.contextPath}/orders/batchDeleteOrders?ids=" + ids;
        }
    });

    //改变分页的每页显示记录数
    function changePageSize() {
        var v = $("#search_input").val();
        var pageSize = $("#changePageSize").val()
        location.href = "${pageContext.request.contextPath}/orders/queryAllOrders?pageNum=1&pageSize=" + pageSize + "&orderNum=" + v;
    }

    //搜索
    $("#search").on("click", function () {
        var v = $("#search_input").val();
        location.href = "${pageContext.request.contextPath}/orders/queryAllOrders?orderNum=" + v;
    });
    //给页码下拉框绑定区域改变事件
    $("#pageSelect").change(function () {
        let pageNum = $(this).val()
        location.href = "${pageContext.request.contextPath}/orders/queryAllOrders?pageNum=" + pageNum + "&pageSize=${pageInfo.pageSize}"
    })
</script>
</body>

</html>
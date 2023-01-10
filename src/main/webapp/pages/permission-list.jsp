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
                权限管理 <small>全部权限</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/pages/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/permission/queryAllPermission">权限管理</a></li>

                <li class="active">全部权限</li>
            </ol>
        </section>
        <!-- 内容头部 /-->
        <!-- 正文区域 -->
        <section class="content"> <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">权限列表</h3>
                </div>
                <div class="box-body">
                    <!-- 数据表格 -->
                    <div class="table-box">
                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建"
                                            onclick="location.href='${pageContext.request.contextPath}/pages/permission-add.jsp'">
                                        <i class="fa fa-plus-square-o"></i> 新建
                                    </button>
                                    <button type="button" class="btn btn-default" title="下架" id="batchDelete">
                                        <i class="fa fa-trash-o"></i> 删除
                                    </button>
                                    <button type="button" class="btn btn-default" title="刷新">
                                        <i class="fa fa-refresh"></i> 刷新
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <label id="input-label">
                                    <input type="text" class="form-control input-sm" placeholder="按权限名搜索"
                                           id="search_input" value="">
                                </label>
                                <button type="button" class="btn btn-default" title="搜索" id="search">
                                    <i class="fa fa-search"></i> 搜索
                                </button>
                            </div>
                        </div>
                        <!--工具栏/-->

                        <!--数据列表-->
                        <form id="form" action="${pageContext.request.contextPath}/permission/#" method="post">
                            <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                <tr>
                                    <th class="" style="padding-right: 0"><label for="selall"></label><input
                                            id="selall" type="checkbox" class="icheckbox_square-blue">
                                    </th>
                                    <th class="sorting_asc">序号</th>
                                    <th class="sorting_desc">权限名称</th>
                                    <th class="sorting">请求路径</th>
                                    <th class="sorting">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pageInfo.list}" var="permission" varStatus="status">
                                    <tr>
                                        <td><label><input name="ids" type="checkbox" value="${permission.id}"></label></td>
                                        <td>${status.count}</td>
                                        <td>${permission.permissionName}</td>
                                        <td>${permission.url}</td>
                                        <td class="text-center">
                                            <button type="button" class="btn bg-olive btn-xs"
                                                    onclick="location.href='${pageContext.request.contextPath}/permission/queryPermissionById?id='+${permission.id}">
                                                编辑
                                            </button>
                                            <button type="button" class="btn bg-olive btn-xs"
                                                    onclick="delRole(${permission.id})">删除
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </form>
                        <!--数据列表/-->
                    </div>
                    <!-- 数据表格 /-->

                </div>
                <!-- /.box-body -->
                <!--分页begin-->
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            总共${pageInfo.pages}页，共${pageInfo.total}条数据。 每页
                            <select class="form-control" id="changePageSize" onchange="changePageSize()">
                                <option value="6"
                                        <c:if test="${pageInfo.pageSize eq 6}">selected</c:if> >6
                                </option>
                                <option value="8" <c:if test="${pageInfo.pageSize eq 8}">selected</c:if>>8</option>
                                <option value="10" <c:if test="${pageInfo.pageSize eq 10}">selected</c:if>>10</option>
                            </select> 条
                        </div>
                    </div>

                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <li>
                                <a href="${pageContext.request.contextPath}/permission/queryAllPermission?pageNum=1&pageSize=${pageInfo.pageSize}"
                                   aria-label="Previous">首页</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/permission/queryAllPermission?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}">上一页</a>
                            </li>
                            <c:forEach begin="1" end="${pageInfo.pages}" var="pageNow">
                                <li>
                                    <a href="${pageContext.request.contextPath}/permission/queryAllPermission?pageNum=${pageNow}&pageSize=${pageInfo.pageSize}">${pageNow}</a>
                                </li>
                            </c:forEach>
                            <c:if test="${pageInfo.pageNum == pageInfo.pages}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/permission/queryAllPermission?pageNum=${pageInfo.pageNum}&pageSize=${pageInfo.pageSize}">下一页</a>
                                </li>
                            </c:if>
                            <c:if test="${pageInfo.pageNum != pageInfo.pages}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/permission/queryAllPermission?pageNum=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}">下一页</a>
                                </li>
                            </c:if>
                            <li>
                                <a href="${pageContext.request.contextPath}/permission/queryAllPermission?pageNum=${pageInfo.pages}&pageSize=${pageInfo.pageSize}"
                                   aria-label="Next">尾页</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- /.box-footer-->
                <!--分页end-->

            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- @@close -->
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
        setSidebarActive("admin-datalist");
        // 列表按钮
        $("#dataList td input[type='checkbox']").iCheck(
            {
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
            var ids = [];
            //获取每个选中的id
            $("input[name='ids']:checked").each(function () {
                ids.push($(this).val())
            })
            // console.log(ids)
            //把获取的ids数组提交到后台
            location.href = "${pageContext.request.contextPath}/permission/batchDeletePermission?ids=" + ids;
        }
    });

    //改变分页的每页显示记录数
    function changePageSize() {
        let v = $("#search_input").val();
        let pageSize = $("#changePageSize").val()
        location.href = "${pageContext.request.contextPath}/permission/queryAllPermission?pageNum=1&pageSize=" + pageSize + "&permissionName=" + v;
    }

    //搜索
    $("#search").on("click", function () {
        var v = $("#search_input").val();
        location.href = "${pageContext.request.contextPath}/permission/queryAllPermission?permissionName=" + v;
    });

    function delRole(id) {
        if (confirm("您确认要删除吗")) {
            location.href = "${pageContext.request.contextPath}/permission/del?id=" + id;
        }
    }
</script>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="js-library.jsp" %>
<%@include file="css-library.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" charset="utf-8">
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

        .col-sm-4 {
            width: auto;
        }

        .form-horizontal .control-label {
            padding-top: 7px;
            margin-bottom: 0;
            text-align: left;
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
                旅客管理 <small>全部旅客</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/pages/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="${pageContext.request.contextPath}/traveller/queryAllTraveller">旅客管理</a></li>
                <li class="active">全部旅客</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content"> <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">旅客列表</h3>
                </div>
                <div class="box-body">
                    <!-- 数据表格 -->
                    <div class="table-box">
                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="添加" data-toggle="modal"
                                            data-target="#myModal">
                                        <i class="fa fa-plus-square-o"></i> 添加
                                    </button>
                                    <!--添加旅客弹框-->
                                    <div id="myModal" class="modal modal-primary" role="dialog">
                                        <div class="modal-dialog modal-lg">
                                            <form class="modal-content"
                                                  action="${pageContext.request.contextPath}/traveller/addTraveller"
                                                  method="post">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal"
                                                            aria-label="Close">
                                                        <span aria-hidden="true">&times;</span></button>
                                                    <h4 class="modal-title">新增旅客</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="box-body">
                                                        <div class="form-horizontal">
                                                            <div class="form-group">
                                                                <label for="inputText2" class="col-sm-4 control-label">旅客姓名:</label>
                                                                <div class="col-sm-6">
                                                                    <div class="input-group">
                                                                        <input id="inputText2" type="text"
                                                                               class="form-control"
                                                                               placeholder="输入旅客姓名" name="name">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-4 control-label">旅客性别:</label>
                                                                <div class="col-sm-8">
                                                                    <div class="input-group">
                                                                        <label>
                                                                            <input type="radio" class="radio-inline"
                                                                                   name="sex" value="男">男
                                                                            <input type="radio" class="radio-inline"
                                                                                   name="sex" value="女">女
                                                                        </label>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="inputText3" class="col-sm-4 control-label">联系电话:</label>
                                                                <div class="col-sm-6">
                                                                    <div class="input-group">
                                                                        <input id="inputText3" type="text"
                                                                               class="form-control"
                                                                               placeholder="输入手机号" name="phoneNum">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-4 control-label">证件类型:</label>
                                                                <div class="col-sm-9">
                                                                    <div class="input-group">
                                                                        <label>
                                                                            <input type="radio" class="radio-inline"
                                                                                   name="credentialsType" value="0">身份证
                                                                            <input type="radio" class="radio-inline"
                                                                                   name="credentialsType" value="1">护照
                                                                            <input type="radio" class="radio-inline"
                                                                                   name="credentialsType" value="2">军官证
                                                                        </label>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="inputText4" class="col-sm-4 control-label">证件号码:</label>
                                                                <div class="col-sm-6">
                                                                    <div class="input-group">
                                                                        <input id="inputText4" type="text"
                                                                               class="form-control"
                                                                               placeholder="输入证件号"
                                                                               name="credentialsNum">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-4 control-label">旅客类型:</label>
                                                                <div class="col-sm-9">
                                                                    <div class="input-group">
                                                                        <label>
                                                                            <input type="radio" class="radio-inline"
                                                                                   name="travellerType" value="0">成人
                                                                            <input type="radio" class="radio-inline"
                                                                                   name="travellerType" value="1">儿童
                                                                        </label>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-outline" data-dismiss="modal">
                                                        关闭
                                                    </button>
                                                    <button type="submit" class="btn btn-outline" id="saveData">保存
                                                    </button>
                                                </div>
                                            </form>
                                            <!-- /.modal-content -->
                                        </div>
                                        <!-- /.modal-dialog -->
                                    </div>
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
                                    <input type="text" class="form-control input-sm" placeholder="按姓名搜索"
                                           id="search_input" value="">
                                </label>
                                <button type="button" class="btn btn-default" title="搜索" id="search">
                                    <i class="fa fa-search"></i> 搜索
                                </button>
                            </div>
                        </div>
                        <!--工具栏/-->
                        <!--数据列表-->
                        <form id="form" action="${pageContext.request.contextPath}/traveller/#" method="post">
                            <table id="dataList"
                                   class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                <tr>
                                    <th class="" style="padding-right: 0">
                                        <label for="selall"></label>
                                        <input id="selall" type="checkbox" class="icheckbox_square-blue">
                                    </th>
                                    <th class="sorting">序号</th>
                                    <th class="sorting_desc">姓名</th>
                                    <th class="sorting">性别</th>
                                    <th class="sorting">手机号</th>
                                    <th class="sorting">证件类型</th>
                                    <th class="sorting">证件号码</th>
                                    <th class="sorting">旅客类型</th>
                                    <th class="sorting">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pageInfo.list}" var="traveller" varStatus="status">
                                    <tr>
                                        <td><label><input name="ids" type="checkbox" value="${traveller.id}"></label>
                                        </td>
                                        <td>${status.count}</td>
                                        <td>${traveller.name}</td>
                                        <td>${traveller.sex}</td>
                                        <td>${traveller.phoneNum}</td>
                                        <c:if test="${traveller.credentialsType == 0}">
                                            <td>身份证</td>
                                        </c:if>
                                        <c:if test="${traveller.credentialsType == 1}">
                                            <td>护照</td>
                                        </c:if>
                                        <c:if test="${traveller.credentialsType == 2}">
                                            <td>军官证</td>
                                        </c:if>
                                        <td>${traveller.credentialsNum}</td>
                                        <c:if test="${traveller.travellerType == 0}">
                                            <td>成人</td>
                                        </c:if>
                                        <c:if test="${traveller.travellerType == 1}">
                                            <td>儿童</td>
                                        </c:if>
                                        <td class="text-center">
                                            <button type="button" class="btn bg-olive btn-xs" name="btn"
                                                    onclick="location.href='${pageContext.request.contextPath}/traveller/queryTravellerById?id=${traveller.id}'">
                                                编辑
                                            </button>
                                            <button type="button" class="btn bg-olive btn-xs"
                                                    onclick="delProduct(${traveller.id})">删除
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
                <!-- .box-footer-->
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
                                <a href="${pageContext.request.contextPath}/traveller/queryAllTraveller?pageNum=1&pageSize=${pageInfo.pageSize}"
                                   aria-label="Previous">首页</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/traveller/queryAllTraveller?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}">上一页</a>
                            </li>
                            <c:forEach begin="1" end="${pageInfo.pages}" var="pageNow">
                                <li>
                                    <a href="${pageContext.request.contextPath}/traveller/queryAllTraveller?pageNum=${pageNow}&pageSize=${pageInfo.pageSize}">${pageNow}</a>
                                </li>
                            </c:forEach>
                            <c:if test="${pageInfo.pageNum == pageInfo.pages}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/traveller/queryAllTraveller?pageNum=${pageInfo.pageNum}&pageSize=${pageInfo.pageSize}">下一页</a>
                                </li>
                            </c:if>
                            <c:if test="${pageInfo.pageNum != pageInfo.pages}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/traveller/queryAllTraveller?pageNum=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}">下一页</a>
                                </li>
                            </c:if>
                            <li>
                                <a href="${pageContext.request.contextPath}/traveller/queryAllTraveller?pageNum=${pageInfo.pages}&pageSize=${pageInfo.pageSize}"
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
            location.href = "${pageContext.request.contextPath}/traveller/batchDeleteTravellerByIds?ids=" + ids;
        }
    });

    //改变分页的每页显示记录数
    function changePageSize() {
        let v = $("#search_input").val();
        let pageSize = $("#changePageSize").val()
        location.href = "${pageContext.request.contextPath}/traveller/queryAllTraveller?pageNum=1&pageSize=" + pageSize + "&name=" + v;
    }

    //搜索
    $("#search").on("click", function () {
        var v = $("#search_input").val();
        location.href = "${pageContext.request.contextPath}/traveller/queryAllTraveller?name=" + v;
    });

    function delProduct(id) {
        if (confirm("您确认要删除吗")) {
            location.href = "${pageContext.request.contextPath}/traveller/delTravellerById?id=" + id;
        }
    }
</script>
</body>

</html>
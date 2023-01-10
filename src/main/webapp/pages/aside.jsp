<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <c:if test="${user.img!=null&&user.img!=''}">
                <div class="pull-left image">
                    <img src="${pageContext.request.contextPath}/img/${user.img}" class="img-circle" alt="User Image" width="128" height="128">
                </div>
            </c:if>
            <c:if test="${user.img==null || user.img==''}">
                <div class="pull-left image">
                    <img src="${pageContext.request.contextPath}/img/user1-128x128.jpg" class="img-circle" alt="User Image" width="128" height="128">
                </div>
            </c:if>

            <div class="pull-left info">
                <c:if test="${user==null}">
                    <p>您当前还没有登录</p>
                    <a href="#"><i class="fa fa-circle text-muted"></i>离线</a>
                </c:if>
                <c:if test="${user!=null}">
                    <p>${user.username}</p>
                    <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
                </c:if>

            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li id="admin-index"><a href="${pageContext.request.contextPath}/pages/main.jsp"><i
                    class="fa fa-home"></i> <span>首页</span></a></li>
            <li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
                <span>系统管理</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i></span>
            </a>
                <ul class="treeview-menu">
                    <li><a
                            href="${pageContext.request.contextPath}/user/findAllUser"> <i
                            class="fa fa-group"></i> 用户管理
                    </a></li>
                    <li><a
                            href="${pageContext.request.contextPath}/role/queryAllRole"> <i
                            class="fa fa-user-secret"></i> 角色管理
                    </a></li>
                    <li><a
                            href="${pageContext.request.contextPath}/sysLog/findAll"> <i
                            class="fa fa-file-text"></i> 访问日志
                    </a></li>
                </ul>
            </li>
            <li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
                <span>基础数据</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>
            </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/product/queryProductList">
                        <i class="fa fa-truck"></i> 产品管理
                    </a></li>
                    <li><a href="${pageContext.request.contextPath}/orders/queryAllOrders"><i class="fa fa-cart-plus"></i> 订单管理
                    </a></li>
                    <li><a href="${pageContext.request.contextPath}/traveller/queryAllTraveller"><i class="fa fa-child"></i> 旅客管理
                    </a></li>
                    <li><a href="${pageContext.request.contextPath}/member/queryAllMember"><i class="fa fa-address-book"></i> 成员管理
                    </a></li>
                </ul>
            </li>
            <li class="treeview"><a href="#"> <i class="fa fa-lock"></i>
                <span>系统权限</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>
            </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/permission/queryAllPermission"> <i
                            class="fa fa-expeditedssl"></i> 权限管理
                    </a></li>
                </ul>
            </li>
            <li class="treeview"><a href="#"> <i class="fa fa-user-circle-o"></i>
                <span>个人中心</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>
            </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/personal/queryPersonalUserById?id=${user.id}"}>
                        <i class="fa fa-drivers-license-o"></i> 修改信息
                    </a></li>
                    <li><a href="${pageContext.request.contextPath}/pages/uploadImg.jsp"><i class="fa fa-user-circle"></i> 上传头像
                    </a></li>
                    <li><a href="${pageContext.request.contextPath}/personal/exit"><i class="fa fa-sign-out"></i> 注销
                    </a></li>
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 页面头部 -->
<header class="main-header">
    <!-- Logo -->
    <a href="main.jsp" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>数据</b></span> <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>数据</b>后台管理</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas"
           role="button"> <span class="sr-only">Toggle navigation</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <c:if test="${user.img!=null&&user.img!=''}">
                        <img src="${pageContext.request.contextPath}/img/${user.img}"
                             class="user-image" alt="User Image" width="128" height="128"> <span class="hidden-xs">
							<security:authentication property="principal.username"/>
					</span>
                    </c:if>
                    <c:if test="${user.img==null || user.img==''}">
                        <img src="${pageContext.request.contextPath}/img/user1-128x128.jpg"
                             class="user-image" alt="User Image" width="128" height="128"> <span class="hidden-xs">
							<security:authentication property="principal.username"/>
					</span>
                    </c:if>

                </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <c:if test="${user.img==null || user.img==''}">
                                <img src="${pageContext.request.contextPath}/img/user1-128x128.jpg" class="img-circle"
                                     alt="User Image" width="128" height="128">
                            </c:if>
                            <c:if test="${user.img!=null&&user.img!=''}">
                                <img src="${pageContext.request.contextPath}/img/${user.img}" class="img-circle"
                                     alt="User Image" width="128" height="128">
                            </c:if>
                        </li>

                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="${pageContext.request.contextPath}/personal/queryPersonalUserById?id=${user.id}" class="btn btn-default btn-flat">修改密码</a>
                            </div>
                            <div class="pull-right">
                                <a href="${pageContext.request.contextPath}/personal/exit"
                                   class="btn btn-default btn-flat">注销</a>
                            </div>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>
    </nav>
</header>
<!-- 页面头部 /-->
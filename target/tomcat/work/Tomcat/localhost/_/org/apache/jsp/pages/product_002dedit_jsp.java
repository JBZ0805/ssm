/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2023-01-09 00:50:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class product_002dedit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/pages/js-library.jsp", Long.valueOf(1673053538122L));
    _jspx_dependants.put("/pages/css-library.jsp", Long.valueOf(1673053828711L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/jQuery/jquery-2.2.3.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/jQueryUI/jquery-ui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">$.widget.bridge('uibutton', $.ui.button);</script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/raphael/raphael-min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/morris/morris.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/sparkline/jquery.sparkline.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/jvectormap/jquery-jvectormap-world-mill-en.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/knob/jquery.knob.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/daterangepicker/moment.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/daterangepicker/daterangepicker.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/daterangepicker/daterangepicker.zh-CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/datepicker/bootstrap-datepicker.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/slimScroll/jquery.slimscroll.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/fastclick/fastclick.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/iCheck/icheck.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/adminLTE/js/app.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/treeTable/jquery.treetable.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/select2/select2.full.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/colorpicker/bootstrap-colorpicker.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/bootstrap-markdown/js/bootstrap-markdown.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/bootstrap-markdown/js/markdown.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/bootstrap-markdown/js/to-markdown.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/ckeditor/ckeditor.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/input-mask/jquery.inputmask.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/input-mask/jquery.inputmask.date.extensions.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/input-mask/jquery.inputmask.extensions.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/datatables/jquery.dataTables.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/datatables/dataTables.bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/chartjs/Chart.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/flot/jquery.flot.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/flot/jquery.flot.resize.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/flot/jquery.flot.pie.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/flot/jquery.flot.categories.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/ionslider/ion.rangeSlider.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/bootstrap-slider/bootstrap-slider.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/font-awesome/css/font-awesome.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/ionicons/css/ionicons.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/iCheck/square/blue.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/morris/morris.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/jvectormap/jquery-jvectormap-1.2.2.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/datepicker/datepicker3.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/daterangepicker/daterangepicker.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/datatables/dataTables.bootstrap.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/treeTable/jquery.treetable.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/treeTable/jquery.treetable.theme.default.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/select2/select2.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/colorpicker/bootstrap-colorpicker.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/adminLTE/css/AdminLTE.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/adminLTE/css/skins/_all-skins.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/ionslider/ion.rangeSlider.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/ionslider/ion.rangeSlider.skinNice.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/bootstrap-slider/slider.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css\">\r\n");
      out.write("\r\n");
      out.write("    <title></title>\r\n");
      out.write("</head>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <!-- 页面meta -->\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" charset=\"UTF-8\">\r\n");
      out.write("    <title>数据 - AdminLTE2定制版</title>\r\n");
      out.write("    <meta name=\"description\" content=\"AdminLTE2定制版\">\r\n");
      out.write("    <meta name=\"keywords\" content=\"AdminLTE2定制版\">\r\n");
      out.write("    <!-- Tell the browser to be responsive to screen width -->\r\n");
      out.write("    <meta content=\"width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no\" name=\"viewport\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"hold-transition skin-purple sidebar-mini\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("    <!-- 页面头部 -->\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("    <!-- 页面头部 /-->\r\n");
      out.write("    <!-- 导航侧栏 -->\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "aside.jsp", out, false);
      out.write("\r\n");
      out.write("    <!-- 导航侧栏 /-->\r\n");
      out.write("\r\n");
      out.write("    <!-- 内容区域 -->\r\n");
      out.write("    <div class=\"content-wrapper\">\r\n");
      out.write("\r\n");
      out.write("        <!-- 内容头部 -->\r\n");
      out.write("        <section class=\"content-header\">\r\n");
      out.write("            <h1>\r\n");
      out.write("                产品管理 <small>产品表单</small>\r\n");
      out.write("            </h1>\r\n");
      out.write("            <ol class=\"breadcrumb\">\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/pages/index.jsp\"><i\r\n");
      out.write("                        class=\"fa fa-dashboard\"></i> 首页</a></li>\r\n");
      out.write("                <li><a\r\n");
      out.write("                        href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product/queryProductList\">产品管理</a></li>\r\n");
      out.write("                <li class=\"active\">产品表单</li>\r\n");
      out.write("            </ol>\r\n");
      out.write("        </section>\r\n");
      out.write("        <!-- 内容头部 /-->\r\n");
      out.write("        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product/edit\" method=\"post\">\r\n");
      out.write("            <!--id隐藏域-->\r\n");
      out.write("            <input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("            <!-- 正文区域 -->\r\n");
      out.write("            <section class=\"content\"> <!--产品信息-->\r\n");
      out.write("                <div class=\"panel panel-default\">\r\n");
      out.write("                    <div class=\"panel-heading\">修改产品信息</div>\r\n");
      out.write("                    <div class=\"row data-type\">\r\n");
      out.write("                        <div class=\"col-md-2 title\">产品编号</div>\r\n");
      out.write("                        <div class=\"col-md-4 data\">\r\n");
      out.write("                            <label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"productNum\" placeholder=\"产品编号\"\r\n");
      out.write("                                       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.productNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                            </label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-2 title\">产品名称</div>\r\n");
      out.write("                        <div class=\"col-md-4 data\">\r\n");
      out.write("                            <label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"productName\" placeholder=\"产品名称\"\r\n");
      out.write("                                       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.productName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                            </label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-2 title\">出发城市</div>\r\n");
      out.write("                        <div class=\"col-md-4 data\">\r\n");
      out.write("                            <label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"cityName\" placeholder=\"出发城市\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.cityName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                            </label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-2 title\">出发时间</div>\r\n");
      out.write("                        <div class=\"col-md-4 data\">\r\n");
      out.write("                            <div class=\"input-group date\">\r\n");
      out.write("                                <div class=\"input-group-addon\">\r\n");
      out.write("                                    <i class=\"fa fa-calendar\"></i>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <label for=\"datepicker-a3\"></label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control pull-right\" id=\"datepicker-a3\"\r\n");
      out.write("                                       name=\"departureTime\" value='");
      if (_jspx_meth_fmt_005fformatDate_005f0(_jspx_page_context))
        return;
      out.write("'>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-2 title\">产品价格</div>\r\n");
      out.write("                        <div class=\"col-md-4 data\">\r\n");
      out.write("                            <label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"productPrice\" placeholder=\"产品价格\"\r\n");
      out.write("                                       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.productPrice}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                            </label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-2 title\">产品状态</div>\r\n");
      out.write("                        <div class=\"col-md-4 data\">\r\n");
      out.write("                            <label>\r\n");
      out.write("                                <select class=\"form-control select2\" style=\"width: 100%\"\r\n");
      out.write("                                        name=\"productStatus\">\r\n");
      out.write("                                    <option value=\"0\" ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write(">下架</option>\r\n");
      out.write("                                    <option value=\"1\" ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write(">上架</option>\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-2 title rowHeight2x\">产品描述</div>\r\n");
      out.write("                        <div class=\"col-md-10 data rowHeight2x\">\r\n");
      out.write("                            <textarea class=\"form-control\" rows=\"3\" placeholder=\"产品描述\" name=\"productDesc\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.productDesc}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!--订单信息/--> <!--工具栏-->\r\n");
      out.write("                <div class=\"box-tools text-center\">\r\n");
      out.write("                    <button type=\"submit\" class=\"btn bg-maroon\">保存</button>\r\n");
      out.write("                    <button type=\"button\" class=\"btn bg-default\"\r\n");
      out.write("                            onclick=\"history.back(-1);\">返回\r\n");
      out.write("                    </button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!--工具栏/--> </section>\r\n");
      out.write("            <!-- 正文区域 /-->\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- 内容区域 /-->\r\n");
      out.write("    <!-- 底部导航 -->\r\n");
      out.write("   ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("    <!-- 底部导航 /-->\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    $(document).ready(function() {\r\n");
      out.write("        // 选择框\r\n");
      out.write("        $(\".select2\").select2();\r\n");
      out.write("        // WYSIHTML5编辑器\r\n");
      out.write("        $(\".textarea\").wysihtml5({\r\n");
      out.write("            locale : 'zh-CN'\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("    $(document).ready(function () {\r\n");
      out.write("        $('#datepicker-a3').datetimepicker({\r\n");
      out.write("            format: \"yyyy-mm-dd\",\r\n");
      out.write("            autoclose: true,\r\n");
      out.write("            todayBtn: true,\r\n");
      out.write("            language: \"zh-CN\"\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("    // 设置激活菜单\r\n");
      out.write("    function setSidebarActive(tagUri) {\r\n");
      out.write("        var liObj = $(\"#\" + tagUri);\r\n");
      out.write("        if (liObj.length > 0) {\r\n");
      out.write("            liObj.parent().parent().addClass(\"active\");\r\n");
      out.write("            liObj.addClass(\"active\");\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    $(document).ready(function () {\r\n");
      out.write("        // 激活导航位置\r\n");
      out.write("        setSidebarActive(\"order-manage\");\r\n");
      out.write("        $(\"#datepicker-a3\").datetimepicker({\r\n");
      out.write("            format: \"yyyy-mm-dd\",\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_fmt_005fformatDate_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_005fformatDate_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatDate_005f0.setParent(null);
    // /pages/product-edit.jsp(84,67) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.departureTime}", java.util.Date.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /pages/product-edit.jsp(84,67) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setPattern("yyyy-MM-dd");
    int _jspx_eval_fmt_005fformatDate_005f0 = _jspx_th_fmt_005fformatDate_005f0.doStartTag();
    if (_jspx_th_fmt_005fformatDate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /pages/product-edit.jsp(99,54) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.productStatus eq 0}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("selected=\"selected\"");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /pages/product-edit.jsp(100,54) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.productStatus eq 1}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("selected=\"selected\"");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}
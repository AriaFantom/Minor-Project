/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.30
 * Generated at: 2024-12-13 19:36:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.dashboard.doctor.schedule;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class create_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../../css/doctor-panel.css\">\r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<aside class=\"side-bar\">\r\n");
      out.write("    <div class=\"user-info\">\r\n");
      out.write("        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\"\r\n");
      out.write("             stroke=\"currentColor\"\r\n");
      out.write("             stroke-width=\"1\" stroke-linecap=\"round\" stroke-linejoin=\"round\" class=\"user-avatar\">\r\n");
      out.write("            <circle cx=\"12\" cy=\"8\" r=\"5\"/>\r\n");
      out.write("            <path d=\"M20 21a8 8 0 0 0-16 0\"/>\r\n");
      out.write("        </svg>\r\n");
      out.write("        <p>Doctor</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <ul class=\"siderbar-navlinks\">\r\n");
      out.write("        <li>\r\n");
      out.write("            <a href=\"../panel.jsp\">\r\n");
      out.write("                <div class=\"icon\">📊</div>\r\n");
      out.write("                Dashboard\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("            <a href=\"../schedule.jsp\">\r\n");
      out.write("                <div class=\"icon\">📆</div>\r\n");
      out.write("                Schedule\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("            <a href=\"../appointments.jsp\">\r\n");
      out.write("                <div class=\"icon\">📅</div>\r\n");
      out.write("                Appointments\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("            <a href=\"../patients.jsp\">\r\n");
      out.write("                <div class=\"icon\">🏥</div>\r\n");
      out.write("                Patients\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</aside>\r\n");
      out.write("<main>\r\n");
      out.write("    <div class=\"top-heading\">\r\n");
      out.write("        <h4 class=\"panel-heading\">Session Adding</h4>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"session-form-container\">\r\n");
      out.write("    <form action=\"");
      out.print(request.getContextPath());
      out.write("/AddSessionServlet\" method=\"post\" class=\"session-form\">\r\n");
      out.write("        <input type=\"hidden\" name=\"doctor_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.email}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"name\">Session Name:</label>\r\n");
      out.write("            <input type=\"text\" id=\"name\" name=\"name\" required \r\n");
      out.write("                   maxlength=\"100\" \r\n");
      out.write("                   placeholder=\"Enter session name\">\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"description\">Description:</label>\r\n");
      out.write("            <textarea id=\"description\" name=\"description\" \r\n");
      out.write("                      maxlength=\"500\" \r\n");
      out.write("                      placeholder=\"Enter session description\"></textarea>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"start_time\">Start Time:</label>\r\n");
      out.write("            <input type=\"time\" id=\"start_time\" name=\"start_time\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"end_time\">End Time:</label>\r\n");
      out.write("            <input type=\"time\" id=\"end_time\" name=\"end_time\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("               <div class=\"form-group\">\r\n");
      out.write("            <label for=\"week\">Day of Week:</label>\r\n");
      out.write("            <select id=\"week\" name=\"week\" required>\r\n");
      out.write("                <option value=\"\">Select a Day</option>\r\n");
      out.write("                <option value=\"1\">Monday</option>\r\n");
      out.write("                <option value=\"2\">Tuesday</option>\r\n");
      out.write("                <option value=\"3\">Wednesday</option>\r\n");
      out.write("                <option value=\"4\">Thursday</option>\r\n");
      out.write("                <option value=\"5\">Friday</option>\r\n");
      out.write("                <option value=\"6\">Saturday</option>\r\n");
      out.write("                <option value=\"7\">Sunday</option>\r\n");
      out.write("            </select>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"form-actions\">\r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary\">Add Session</button>\r\n");
      out.write("            <button type=\"reset\" class=\"btn btn-secondary\">Reset</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("</main>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.30
 * Generated at: 2024-12-14 05:43:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.dashboard.doctor;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class schedule_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(6);
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(3);
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../css/doctor-panel.css\">\r\n");
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
      out.write("         ");

                String username = "";
                String doctorEmail = (String) session.getAttribute("email");
                Connection conn = null;
                PreparedStatement pstm = null;
                ResultSet rs = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String url="jdbc:mysql://localhost:3306/minorproject";
                    String uid="root";
                    String upass="1234";
                    conn=DriverManager.getConnection(url,uid,upass);
                    
                    pstm = conn.prepareStatement("SELECT username from doctors where email = ?");
                    pstm.setString(1, doctorEmail);
                    rs = pstm.executeQuery();
                    if (rs.next()) {
                        username = rs.getString("username");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            
      out.write("\r\n");
      out.write("                    		\r\n");
      out.write("        <p>");
      out.print( username != null && !username.trim().isEmpty() ? username : "Not Logged In" );
      out.write("</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <ul class=\"siderbar-navlinks\">\r\n");
      out.write("        <li>\r\n");
      out.write("            <a href=\"panel.jsp\">\r\n");
      out.write("                <div class=\"icon\">📊</div>\r\n");
      out.write("                Dashboard\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("            <a href=\"schedule.jsp\">\r\n");
      out.write("                <div class=\"icon\">📆</div>\r\n");
      out.write("                Schedule\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("            <a href=\"appointments.jsp\">\r\n");
      out.write("                <div class=\"icon\">📅</div>\r\n");
      out.write("                Appointments\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("            <a href=\"patients.jsp\">\r\n");
      out.write("                <div class=\"icon\">🏥</div>\r\n");
      out.write("                Patients\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</aside>\r\n");
      out.write("<main>\r\n");
      out.write("    <div class=\"top-heading\">\r\n");
      out.write("        <h4 class=\"panel-heading\">Session Manager</h4>\r\n");
      out.write("        <a href=\"schedule/create.jsp\"><button class=\"add-button\">+ Add Session</button></a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <table class=\"appointment-table\">\r\n");
      out.write("            <caption>📱 All Sessions</caption>\r\n");
      out.write("            <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>Session Name</th>\r\n");
      out.write("                <th>Description</th>\r\n");
      out.write("                <th>Start Time</th>\r\n");
      out.write("                <th>End Time</th>\r\n");
      out.write("                <th>Week</th>\r\n");
      out.write("                <th>Action</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("             ");

           
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String url="jdbc:mysql://localhost:3306/minorproject";
                    String uid="root";
                    String upass="1234";
                    conn=DriverManager.getConnection(url,uid,upass);
                    
                    pstm = conn.prepareStatement("SELECT s.id, s.name, s.description, s.start_time, s.end_time, s.week " +
                            "FROM schedule s " +
                            "JOIN doctors d ON s.doctor_id = d.id " +
                            "WHERE d.email = ?");
             
                    pstm.setString(1, doctorEmail);
                    rs = pstm.executeQuery();
                    
                    while (rs.next()) {
                    	int sessionId = rs.getInt("id");
                        String sessionName = rs.getString("name");
                        String description = rs.getString("description");
                        String startTime = rs.getString("start_time");
                        String endTime = rs.getString("end_time");
                        String formattedStartTime = startTime.substring(0, 5);
                        String formattedEndTime = endTime.substring(0, 5);
                        int week = rs.getInt("week");
                        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
                        String dayName = (week >= 1 && week <= 7) ? days[week - 1] : "Unknown Day";
                    
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                    <td>");
      out.print( sessionName );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( (description != null) ? description : "" );
      out.write("</td>\r\n");
      out.write("                     <td>");
      out.print( formattedStartTime );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( formattedEndTime );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( dayName );
      out.write("</td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <!-- <button class=\"edit-button\">Edit</button>  -->\r\n");
      out.write("                        <form action=\"");
      out.print(request.getContextPath());
      out.write("/RemoveSessionServlet\" method=\"post\">\r\n");
      out.write("                          <input type=\"hidden\" name=\"session_id\" value=\"");
      out.print( sessionId );
      out.write("\"/>\r\n");
      out.write("                          <button type=\"submit\" class=\"delete-button\">Delete</button>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                  
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td colspan=\"7\" style=\"color:red;\">Error retrieving sessions</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
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

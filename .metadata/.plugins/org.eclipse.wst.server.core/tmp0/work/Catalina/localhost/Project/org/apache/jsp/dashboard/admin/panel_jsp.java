/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.30
 * Generated at: 2025-01-17 14:28:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.dashboard.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class panel_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../css/admin-panel.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	String user_id = "";
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
    
    pstm = conn.prepareStatement("SELECT id, username from admins where email = ?");
    pstm.setString(1, doctorEmail);
    rs = pstm.executeQuery();
    if (rs.next()) {
    	user_id = rs.getString("id");
        username = rs.getString("username");
        
    }
} catch (Exception e) {
    e.printStackTrace();
} 

if(username != null && !username.trim().isEmpty()) {

      out.write("\r\n");
      out.write("<aside class=\"side-bar\">\r\n");
      out.write("    <div class=\"user-info\">\r\n");
      out.write("        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\"\r\n");
      out.write("             stroke=\"currentColor\"\r\n");
      out.write("             stroke-width=\"1\" stroke-linecap=\"round\" stroke-linejoin=\"round\" class=\"user-avatar\">\r\n");
      out.write("            <circle cx=\"12\" cy=\"8\" r=\"5\"/>\r\n");
      out.write("            <path d=\"M20 21a8 8 0 0 0-16 0\"/>\r\n");
      out.write("        </svg>\r\n");
      out.write("        <p>");
      out.print( username != null && !username.trim().isEmpty() ? username : "Not Logged In" );
      out.write("</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <ul class=\"siderbar-navlinks\">\r\n");
      out.write("               <li>\r\n");
      out.write("      <a href=\"panel.jsp\">\r\n");
      out.write("        <div class=\"icon\">📊</div>\r\n");
      out.write("        Dashboard\r\n");
      out.write("      </a>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li>\r\n");
      out.write("      <a href=\"doctor.jsp\">\r\n");
      out.write("        <div class=\"icon\">👨‍⚕️</div>\r\n");
      out.write("        Doctors\r\n");
      out.write("      </a>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li>\r\n");
      out.write("      <a href=\"schedule.jsp\">\r\n");
      out.write("                <div class=\"icon\">📆</div>\r\n");
      out.write("                Schedule\r\n");
      out.write("            </a>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li>\r\n");
      out.write("      <a href=\"appointments.jsp\">\r\n");
      out.write("        <div class=\"icon\">📅</div>\r\n");
      out.write("        Appointments\r\n");
      out.write("      </a>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li>\r\n");
      out.write("      <a href=\"patient.jsp\">\r\n");
      out.write("        <div class=\"icon\">🏥</div>\r\n");
      out.write("        Patients\r\n");
      out.write("      </a>\r\n");
      out.write("    </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</aside>\r\n");
      out.write("<main>\r\n");
      out.write("    <h4 class=\"panel-heading\">Status</h4>\r\n");
      out.write("    <div class=\"stats-container\">\r\n");
      out.write("                ");
 
    
    int Doctors = 0;
    int Patient = 0;
    int Bookings = 0;
    int Appointments = 0;
    
    try {
   	 Class.forName("com.mysql.cj.jdbc.Driver");
   		String url="jdbc:mysql://localhost:3306/minorproject";
   		String uid="root";
   		String upass="1234";
   		conn=DriverManager.getConnection(url,uid,upass);
     
       pstm = conn.prepareStatement("select count(*) from patients");
       rs = pstm.executeQuery();
       while (rs.next()) {
    	   Patient = rs.getInt(1);
       }
       pstm = conn.prepareStatement("select count(*) from doctors");
       rs = pstm.executeQuery();
       while (rs.next()) {
    	   Doctors = rs.getInt(1);
       }
       pstm = conn.prepareStatement("select count(*) from schedule");
       rs = pstm.executeQuery();
       while (rs.next()) {
    	   Bookings = rs.getInt(1);
       }
       pstm = conn.prepareStatement("select count(*) from appointments");
       rs = pstm.executeQuery();
       while (rs.next()) {
    	   Appointments = rs.getInt(1);
       }
       
      
    
      out.write("\r\n");
      out.write("          <div class=\"stats-card doctors\">\r\n");
      out.write("            <div class=\"stats-icon\">👩‍⚕️</div>\r\n");
      out.write("            <div class=\"stats-number\">");
      out.print( Doctors );
      out.write("</div>\r\n");
      out.write("            <div class=\"stats-label\">Doctors</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"stats-card patients\">\r\n");
      out.write("            <div class=\"stats-icon\">🏥</div>\r\n");
      out.write("            <div class=\"stats-number\">");
      out.print( Patient );
      out.write("</div>\r\n");
      out.write("            <div class=\"stats-label\">Patients</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"stats-card bookings\">\r\n");
      out.write("            <div class=\"stats-icon\">📅</div>\r\n");
      out.write("            <div class=\"stats-number\">");
      out.print( Appointments );
      out.write("</div>\r\n");
      out.write("            <div class=\"stats-label\">Total Bookings</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"stats-card sessions\">\r\n");
      out.write("            <div class=\"stats-icon\">🩺</div>\r\n");
      out.write("            <div class=\"stats-number\">");
      out.print( Bookings );
      out.write("</div>\r\n");
      out.write("            <div class=\"stats-label\">Total Sessions</div>\r\n");
      out.write("        </div>\r\n");
      out.write("                ");


} catch (Exception e) {
	System.out.println(e);
}


      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <table class=\"appointment-table\">\r\n");
      out.write("            <caption>📋 Upcoming Appointments</caption>\r\n");
      out.write("            <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>Appointment No</th>\r\n");
      out.write("                <th>Patient Name ️</th>\r\n");
      out.write("                <th>Doctor</th>\r\n");
      out.write("                <th>Session</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("            ");

             try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           String url="jdbc:mysql://localhost:3306/minorproject";
           String uid="root";
           String upass="1234";
           conn=DriverManager.getConnection(url,uid,upass);
           pstm = conn.prepareStatement("SELECT "+ 
        	        "a.id AS `appointmentid`, " +
        	        "p.username AS `patient_name`, " +
        	        "d.username AS `doctor_name`, d.specialist AS `doctor_specialist`, " +
        	        "a.date AS `app_date` " +
        	        "FROM appointments a " +
        	    	"INNER JOIN " +
        		    "doctors d ON a.doctor_id = d.id " +
        		"INNER JOIN " +
        		    "patients p ON a.patient_id = p.id " +
        		"INNER JOIN " +
        		    "schedule s ON a.schedule = s.id " +
        		"WHERE " +
        	        "a.status = 'booked' " +
        	    "ORDER BY " +
        	        "a.id ASC LIMIT 5;");
           rs = pstm.executeQuery();
           
           while (rs.next()) {
        	   int appointment_id = rs.getInt("appointmentid");
            String doctor_name = rs.getString("doctor_name");
            String patient_name = rs.getString("patient_name");
            Timestamp app_date = rs.getTimestamp("app_date");
            java.time.LocalDate appointmentLocalDate = app_date.toLocalDateTime().toLocalDate();
            java.time.LocalDate today = java.time.LocalDate.now();
            long daysLeft = java.time.temporal.ChronoUnit.DAYS.between(today, appointmentLocalDate);
            
            String daysLeftStr;
            if (daysLeft > 0) {
                daysLeftStr = daysLeft + " day(s) left";
            } else if (daysLeft == 0) {
                daysLeftStr = "Today";
            } else {
                daysLeftStr = "Past Appointment";
            }
       
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>");
      out.print( appointment_id );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( patient_name );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( doctor_name );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( daysLeftStr );
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("       ");
  } 
             } catch (Exception e) {
          e.printStackTrace(); 
      out.write("\r\n");
      out.write("          <tr>\r\n");
      out.write("             <td colspan=\"7\" style=\"color:red;\">Error retrieving sessions</td>\r\n");
      out.write("         </tr>\r\n");
      out.write("     ");
 } 
      out.write(" \r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("\r\n");
      out.write("        <table class=\"appointment-table\">\r\n");
      out.write("            <caption>📋 Recent Schedules</caption>\r\n");
      out.write("            <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>Session Id</th>\r\n");
      out.write("                <th>Session Name</th>\r\n");
      out.write("                <th>Week</th>\r\n");
      out.write("                <th>Time</th>\r\n");
      out.write("                <th>Doctor</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("               ");

             try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           String url="jdbc:mysql://localhost:3306/minorproject";
           String uid="root";
           String upass="1234";
           conn=DriverManager.getConnection(url,uid,upass);
           pstm = conn.prepareStatement("SELECT s.id, s.name, s.start_time, s.end_time, s.week, d.username " +
                   "FROM schedule s " +
                   "JOIN doctors d ON s.doctor_id = d.id;");
           rs = pstm.executeQuery();
           
           while (rs.next()) {
        	   int s_id = rs.getInt("id");
               String s_name = rs.getString("name");
               String start_time = rs.getString("start_time");
               String end_time = rs.getString("end_time");
               int week = rs.getInt("week");
               String doctor_name = rs.getString("username");
               
               String formattedStartTime = start_time.substring(0, 5);
               String formattedEndTime = end_time.substring(0, 5);
               String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
               String dayName = (week >= 1 && week <= 7) ? days[week - 1] : "Unknown Day";
    
       
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>");
      out.print( s_id );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( s_name );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( dayName );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( formattedStartTime );
      out.write(' ');
      out.write('-');
      out.write(' ');
      out.print( formattedEndTime );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( doctor_name );
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("             ");
  } 
             } catch (Exception e) {
          e.printStackTrace(); 
      out.write("\r\n");
      out.write("          <tr>\r\n");
      out.write("             <td colspan=\"7\" style=\"color:red;\">Error retrieving sessions</td>\r\n");
      out.write("         </tr>\r\n");
      out.write("     ");
 } 
      out.write(" \r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
      out.write("</main>\r\n");
 } else { 
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <div class=\"errordiv\">\r\n");
      out.write(" 	<h1>Login</h1>\r\n");
      out.write(" 		<a href=\"");
      out.print( request.getContextPath() );
      out.write("/login.jsp\">Go to Login Page</a>\r\n");
      out.write(" </div>\r\n");
      out.write("\r\n");
 } 
      out.write("\r\n");
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

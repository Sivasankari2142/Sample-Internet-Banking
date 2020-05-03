import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class signup extends HttpServlet {
 Connection con;
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
 response.setContentType("text/html;charset=UTF-8");
 try (PrintWriter out = response.getWriter()) {
String name=request.getParameter("t1");
String gender=request.getParameter("t2");
String account =request.getParameter("t3");
String email =request.getParameter("email");
String mobile =request.getParameter("mob");
String Address =request.getParameter("address");
                        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signup</title>");            
            out.println("</head>");
            out.println("<body>");
            try{
Class.forName("com.mysql.jdbc.Driver") ;
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","");
Statement stmt=con.createStatement();  
String query="insert into bank values(' "+name+" ',' "+gender+" ',' "+account+" ',' "+email+" ',' "+mobile+" ',' "+Address+" ')";
int iupdate=stmt.executeUpdate(query);
if(iupdate>0)
{
out.println("<font size='14' color='blue'> Account created successfully</font>");
out.println("<br>");
out.println("<a href='index.html'> Click here to create again </a>");
}
else {
out.println("Account created unsuccessfully");

}}
catch(Exception e)
{
e.printStackTrace();
out.println("Account created unsuccessfully"); }
out.println("</body>");
out.println("</html>");
}
            out.println("<h1>Servlet insert at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
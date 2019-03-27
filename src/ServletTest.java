import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.*;

public class ServletTest extends javax.servlet.http.HttpServlet {
    private String hello;
    public void init() throws ServletException {
        hello = "neat";

    }
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException{

    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");   //sets response type, in this case html
        PrintWriter out = response.getWriter();
        out.println("<p>" + hello + "</p>");
    }
}

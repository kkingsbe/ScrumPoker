import GamePackage.GameDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "home", urlPatterns = "/home")
public class home extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameDriver.createDb();
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("homePage.jsp");
        dispatcher.forward(request, response);
    }
}

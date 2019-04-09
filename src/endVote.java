import GamePackage.GameDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "endVote", urlPatterns = "/endVote")
public class endVote extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameDriver.placeVote(request.getParameter("gamename"), request.getParameter("username"), request.getParameter("vote"));
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("roundOver.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

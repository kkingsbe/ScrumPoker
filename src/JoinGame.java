import GamePackage.GameDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "JoinGame", urlPatterns = "/joinGame")
public class JoinGame extends HttpServlet {
    @SuppressWarnings("Duplicates")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username;
        String gamename;
        String description;
        username = request.getParameter("username");
        gamename = request.getParameter("gamename");
        description = request.getParameter("description");
        GameDriver.addPlayer(gamename, username);
        ArrayList<String> players =  new ArrayList<String>();
        players = GameDriver.getPlayers(request.getParameter("gamename"));
        request.setAttribute("players", players);
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("gameHome.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

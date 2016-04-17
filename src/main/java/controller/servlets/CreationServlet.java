package controller.servlets;

import controller.operations.CreateOperator;
import controller.operations.DbOperation;
import model.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Fedor on 17.04.2016.
 */
@WebServlet("/creation")
public class CreationServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        DbConnection connection = DbConnection.getInstance();
        connection.connectToDb();

        DbOperation operation = new CreateOperator();

        req.setAttribute("type", "CREATE");
        req.setAttribute("answer", operation.requestToDb(name, description));
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}

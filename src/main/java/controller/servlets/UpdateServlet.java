package controller.servlets;

import controller.operations.DbOperation;
import controller.operations.UpdateOperator;
import model.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Fedor on 17.04.2016.
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        DbConnection connection = DbConnection.getInstance();
        connection.connectToDb();

        DbOperation operation = new UpdateOperator();
        operation.requestToDb(name, description);

        PrintWriter out = resp.getWriter();
        out.println("<br>Operation completed</br>");
    }
}

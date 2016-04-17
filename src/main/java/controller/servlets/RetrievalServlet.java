package controller.servlets;

import controller.operations.DbOperation;
import controller.operations.RetrieveOperator;
import model.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Fedor on 17.04.2016.
 */
@WebServlet("/retrieval")
public class RetrievalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        DbConnection connection = DbConnection.getInstance();
        connection.connectToDb();

        DbOperation operation = new RetrieveOperator();

        PrintWriter out = resp.getWriter();
        out.println(
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
                        "http://www.w3.org/TR/html4/loose.dtd\">\n" +
                        "<html> \n" +
                        "<head> \n" +
                        "<meta http-equiv=\"Content-Type\" content=\"text/html; " +
                        "charset=ISO-8859-1\"> \n" +
                        "<title> Ответ на запрос " + name + " </title> \n" +
                        "</head> \n" +
                        "<body> <div align='center'> \n" +
                        "<style= \"font-size=\"12px\" color='black'\"" + "\">" +
                        "Запрос: " + name + " <br> " +
                        "Определение: " + operation.requestToDb(name, null) +
                        "</font></body> \n" +
                        "</html>"
        );
    }
}

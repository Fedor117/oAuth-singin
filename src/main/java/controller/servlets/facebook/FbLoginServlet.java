package controller.servlets.facebook;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Fedor on 18.04.2016.
 */

@WebServlet("/facebook-login")
public class FbLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String code;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        code = req.getParameter("code");

        if (code == null || code.equals("")) {
            throw new RuntimeException("ERROR");
        }

        FbConnection connection = new FbConnection();
        String accessToken = connection.getAccessToken(code);

        FbGraph fbGraph = new FbGraph(accessToken);
        String graph = fbGraph.getFbGraph();
        Map<String, String> fbProfileData = fbGraph.getGraphData(graph);

        ServletOutputStream out = resp.getOutputStream();
        out.println("<h1>Facebook Login using Java</h1>");
        out.println("<h2>Application Main Menu</h2>");
        out.println("<div>Welcome "+fbProfileData.get("first_name"));
        out.println("<div>Your Email: "+fbProfileData.get("email"));
        out.println("<div>You are "+fbProfileData.get("gender"));
    }
}

package controller.servlets.facebook;

import javax.servlet.ServletException;
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
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        code = req.getParameter("code");

        if (code == null || code.equals("")) {
            req.getRequestDispatcher("/").forward(req, resp);
            throw new RuntimeException("ERROR");
        }

        FbConnection connection = new FbConnection();
        String accessToken = connection.getAccessToken(code);

        FbGraph fbGraph = new FbGraph(accessToken);
        String graph = fbGraph.getFbGraph();
        Map<String, String> fbProfileData = fbGraph.getGraphData(graph);

        String message = "Hello, ".concat(fbProfileData.get("first_name")).concat(". You are ")
                .concat(fbProfileData.get("gender")).concat(". Your Email: ").concat(fbProfileData.get("email"));

        req.setAttribute("photo", fbGraph.getPicture(fbProfileData.get("id")));
        req.setAttribute("message", message);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}

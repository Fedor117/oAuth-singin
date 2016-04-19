package controller.servlets.facebook;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Fedor on 18.04.2016.
 */

@WebServlet("/facebook-login")
public class FbLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String code = req.getParameter("code");
        if (code == null || code.equals("")) {
            System.err.println("Something went bad with code from Facebook");
        }

        String token = null;
        try {
            String g = "https://graph.facebook.com/oauth/access_token?client_id=1147701885262257&redirect_uri=" +
                    URLEncoder.encode("http://localhost:8080/result.jsp", "UTF-8") +
                    "&client_secret=c7573959636deb991e6746b5dfa220f7&code=" + code;

            URL u = new URL(g);
            URLConnection c = u.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String inputLine;
            StringBuilder b = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                b.append(inputLine).append("\n");
            in.close();
            token = b.toString();
            if (token.startsWith("{"))
                throw new Exception("error on requesting token: " + token + " with code: " + code);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String graph = null;
        try {
            String g = "https://graph.facebook.com/me?" + token;
            URL u = new URL(g);
            URLConnection c = u.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String inputLine;
            StringBuilder b = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                b.append(inputLine).append("\n");
            in.close();
            graph = b.toString();
        } catch (Exception e) {
            // an error occurred, handle this
        }

        String facebookId  = null;
        String firstName   = null;
        String middleNames = null;
        String lastName    = null;
        String email       = null;

        try {
            assert graph != null;
            JSONObject json = new JSONObject(graph);
            facebookId = json.getString("id");
            firstName = json.getString("first_name");
            if (json.has("middle_name"))
                middleNames = json.getString("middle_name");
            else
                middleNames = null;
            if (middleNames != null && middleNames.equals(""))
                middleNames = null;
            lastName = json.getString("last_name");
            email = json.getString("email");
        } catch (JSONException e) {
            // an error occurred, handle this
        }

        req.setAttribute("facebookId", facebookId);
        req.setAttribute("firstName", firstName);
        req.setAttribute("middleNames", middleNames);
        req.setAttribute("lastName", lastName);
        req.setAttribute("email", email);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}

package controller.servlets.vk;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Dzmitry Saladukha on 18.04.2016.
 */
@WebServlet("/vk-login")
public class VkLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String code;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        code = req.getParameter("code");

        if (code == null || code.equals("")) {
            req.getRequestDispatcher("/").forward(req, resp);
            throw new RuntimeException("ERROR");
        }

        VkConnection vkConnection = new VkConnection();
        String accessToken = vkConnection.getAccessToken(code);
        String userId = vkConnection.getUserId();

        JSONObject userData = getUserData(accessToken, userId);
        String message = "Hello, ".concat(userData.getString("first_name")).concat(". You are ")
                .concat(userData.get("sex").toString());

        req.setAttribute("photo", userData.getString("photo_100"));
        req.setAttribute("message", message);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }

    private JSONObject getUserData(String accessToken, String userId) {
        URL url;
        try {
            url = new URL("https://api.vk.com/method/users.get?user_id=" + userId +
                    "&fields=photo_100,sex&name_case=nom&v=5.50&access_token=" + accessToken);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid code received " + e);
        }
        URLConnection urlConnection;
        StringBuffer b;
        try {
            urlConnection = url.openConnection();
            BufferedReader in;
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String inputLine;
            b = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                b.append(inputLine).append("\n");
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect with VK " + e);
        }
        System.out.println(b.toString());
        JSONObject jsonObject = (JSONObject) new JSONObject(b.toString()).getJSONArray("response").get(0);
        if (2 == (int) jsonObject.get("sex")) {
            jsonObject.put("sex", "male");
        } else if (1 == (int) jsonObject.get("sex")) {
            jsonObject.put("sex", "female");
        } else {
            jsonObject.put("sex", "trap");
        }
        return jsonObject;
    }
}

package controller.servlets.vk;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Dzmitry Saladukha on 18.04.2016.
 */
public class VkConnection {
    private static final String VK_APP_ID = "5422793";
    private static final String REDIRECT_URI = "http://localhost:8080/vk-login";
    private final String VK_APP_SECRET = "xmqatJXEerR3VPbztT2N";
    private String accessToken = "";
    private String userId = "";

    public static String getAuthUrl() {
        String vkLoginUrl = "";
        try {
            vkLoginUrl = "https://oauth.vk.com/authorize?" + "client_id=" + VK_APP_ID +
                    "&display=popup&redirect_uri=" +
                    URLEncoder.encode(REDIRECT_URI, "UTF-8") +
                    "&scope=email&response_type=code&v=5.50";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return vkLoginUrl;
    }

    private String getTokenURL(String code) {
        String url = "";
        try {
            url = "https://oauth.vk.com/access_token?client_id=" + VK_APP_ID + "&client_secret=" + VK_APP_SECRET +
                    "&redirect_uri=" + URLEncoder.encode(REDIRECT_URI, "UTF-8") + "&code=" + code;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url;
    }

    String getAccessToken(String code) {
        if ("".equals(accessToken)) {
            URL url;
            try {
                url = new URL(getTokenURL(code));
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Invalid code received " + e);
            }
            URLConnection urlConnection;
            StringBuffer b;
            try {
                urlConnection = url.openConnection();
                BufferedReader in;
                in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
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

            JSONObject jsonObject = new JSONObject(b.toString());
            accessToken = jsonObject.getString("access_token");
            if (accessToken.isEmpty()) {
                throw new RuntimeException("ERROR: Access Token Invalid: " + accessToken);
            }
            userId = jsonObject.get("user_id").toString();
            System.out.println(b.toString());
        }
        return accessToken;
    }

    String getUserId() {
        return userId;
    }
}

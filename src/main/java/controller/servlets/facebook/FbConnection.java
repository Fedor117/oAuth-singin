package controller.servlets.facebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Fedor on 18.04.2016.
 */
public class FbConnection {
    private static final String FB_APP_ID = "1147701885262257";
    private static final String REDIRECT_URI = "http://localhost:8080/facebook-login";
    private final String FB_APP_SECRET = "c7573959636deb991e6746b5dfa220f7";
    private String accessToken = "";

    public static String getFbAuthUrl() {
        String fbLoginUrl = "";
        try {
            fbLoginUrl = "http://www.facebook.com/dialog/oauth?" + "client_id=" + FB_APP_ID + "&redirect_uri=" +
                    URLEncoder.encode(REDIRECT_URI, "UTF-8") + "&scope=email";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return fbLoginUrl;
    }

    private String getFbGraphUrl(String code) {
        String fbGraphUrl = "";
        try {
            fbGraphUrl =
                    "https://graph.facebook.com/oauth/access_token?" + "client_id=" + FB_APP_ID + "&redirect_uri=" +
                            URLEncoder.encode(REDIRECT_URI, "UTF-8") + "&client_secret=" + FB_APP_SECRET + "&code=" +
                            code;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return fbGraphUrl;
    }

    String getAccessToken(String code) {
        if ("".equals(accessToken)) {
            URL fbGraphURL;
            try {
                fbGraphURL = new URL(getFbGraphUrl(code));
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Invalid code received " + e);
            }
            URLConnection fbConnection;
            StringBuffer b;
            try {
                fbConnection = fbGraphURL.openConnection();
                BufferedReader in;
                in = new BufferedReader(new InputStreamReader(fbConnection.getInputStream()));
                String inputLine;
                b = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    b.append(inputLine).append("\n");
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Unable to connect with Facebook " + e);
            }

            accessToken = b.toString();
            if (accessToken.startsWith("{")) {
                throw new RuntimeException("ERROR: Access Token Invalid: " + accessToken);
            }
        }
        return accessToken;
    }
}

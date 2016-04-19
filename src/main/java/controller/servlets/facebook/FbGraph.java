package controller.servlets.facebook;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fedor on 18.04.2016.
 */
class FbGraph {

    private String accessToken;

    FbGraph(String accessToken) {
        this.accessToken = accessToken;
    }

    String getFbGraph() {
        String graph = null;
        try {

            String g = "https://graph.facebook.com/me?fields=email,first_name,gender&" + accessToken;
            System.out.println(g);
            URL u = new URL(g);
            URLConnection c = u.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String inputLine;
            StringBuilder b = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                b.append(inputLine).append("\n");
            }
            in.close();
            graph = b.toString();
            System.out.println(graph);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR in getting FB graph data. " + e);
        }
        return graph;
    }

    Map<String, String> getGraphData(String fbGraph) {
        Map<String, String> fbProfile = new HashMap<>();
        try {
            JSONObject json = new JSONObject(fbGraph);
            fbProfile.put("id", json.getString("id"));
            fbProfile.put("first_name", json.getString("first_name"));
            if (json.has("email")) {
                fbProfile.put("email", json.getString("email"));
            }
            if (json.has("gender")) {
                fbProfile.put("gender", json.getString("gender"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR in parsing FB graph data. " + e);
        }
        return fbProfile;
    }
}

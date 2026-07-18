import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Practice 06 — findSpeedster LIVE with Gson (HackerRank-style, needs internet)
 *
 * Same API task as P04, but uses HttpURLConnection + Gson instead of offline regex.
 * HackerRank provides Gson; locally add libs/gson-2.10.1.jar to module classpath.
 * jsonmock.hackerrank.com may return empty data now — use P04 offline mock to verify logic.
 * Expected on mock data: marathon="Boston Marathon", sex="F" → "Diana Bolt" (22.1)
 */
public class P06_FindSpeedsterLiveGson {

    public static void main(String[] args) {
        String marathon = "Boston Marathon";
        String sex = "F";

        String winner = findSpeedster(marathon, sex);
        System.out.println("Speedster: " + winner);
    }

    /**
     * HackerRank template shape: static method on Result class.
     * Kept here as P06_FindSpeedsterLiveGson.findSpeedster for local runs.
     */
    public static String findSpeedster(String marathon, String sex) {
        String fastestRunner = "";
        double maxSpeed = -1.0;
        int page = 1;
        int totalPages = 1;

        try {
            String encodedSex = URLEncoder.encode(sex, StandardCharsets.UTF_8);

            while (page <= totalPages) {
                URL url = new URL("https://jsonmock.hackerrank.com/api/marathon?sex="
                        + encodedSex + "&page=" + page);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");

                StringBuilder response = new StringBuilder();
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                }
                con.disconnect();

                JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();

                if (page == 1) {
                    totalPages = jsonResponse.get("total_pages").getAsInt();
                }

                JsonArray data = jsonResponse.getAsJsonArray("data");

                for (JsonElement element : data) {
                    JsonObject runner = element.getAsJsonObject();

                    if (runner.has("marathon_name") && runner.has("top_speed")) {
                        String currentMarathon = runner.get("marathon_name").getAsString();

                        if (currentMarathon.equalsIgnoreCase(marathon)) {
                            double currentSpeed = runner.get("top_speed").getAsDouble();

                            if (currentSpeed > maxSpeed) {
                                maxSpeed = currentSpeed;
                                fastestRunner = runner.get("name").getAsString();
                            }
                        }
                    }
                }
                page++;
            }
        } catch (Exception e) {
            System.err.println("Live API call failed (check internet + Gson on classpath): "
                    + e.getMessage());
            e.printStackTrace();
        }

        return fastestRunner;
    }
}

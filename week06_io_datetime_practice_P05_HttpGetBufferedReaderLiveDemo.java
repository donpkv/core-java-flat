import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Practice 05 — Live HTTP GET + BufferedReader (needs internet)
 *
 * Calls jsonmock.hackerrank.com — same stack as interview/API tasks.
 * If offline, use P04_FindSpeedsterOffline instead.
 */
public class P05_HttpGetBufferedReaderLiveDemo {

    public static void main(String[] args) {
        try {
            String marathon = "Boston Marathon";
            String sex = "F";

            String encodedMarathon = URLEncoder.encode(marathon, StandardCharsets.UTF_8).replace("+", "%20");
            String encodedSex = URLEncoder.encode(sex, StandardCharsets.UTF_8);

            String urlString = "https://jsonmock.hackerrank.com/api/marathon?marathon_name="
                    + encodedMarathon + "&sex=" + encodedSex + "&page=1";

            String json = httpGet(urlString);
            System.out.println("Response length: " + json.length());

            Pattern namePattern = Pattern.compile("\"name\":\\s*\"(.*?)\"");
            Matcher m = namePattern.matcher(json);
            int count = 0;
            while (m.find()) {
                count++;
                System.out.println("Runner " + count + ": " + m.group(1));
            }

        } catch (Exception e) {
            System.err.println("Network call failed (check internet): " + e.getMessage());
        }
    }

    static String httpGet(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
        }

        return response.toString();
    }
}

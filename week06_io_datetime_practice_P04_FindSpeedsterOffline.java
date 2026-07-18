import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Practice 04 — findSpeedster pattern OFFLINE (no network)
 *
 * Reads mock page JSON files from week06_api_practice/data/
 * Same logic as HackerRank-style API task: paginate, regex-parse, pick max top_speed.
 *
 * Expected for marathon="Boston Marathon", sex="F" → "Diana Bolt" (22.1)
 */
public class P04_FindSpeedsterOffline {

    public static void main(String[] args) {
        String marathon = "Boston Marathon";
        String sex = "F";

        String winner = findSpeedster(marathon, sex);
        System.out.println("Speedster: " + winner);
    }

    public static String findSpeedster(String marathon, String sex) {
        String speedsterName = "";
        double maxTopSpeed = -1.0;

        int currentPage = 1;
        int totalPages = 1;

        while (currentPage <= totalPages) {
            Path path = Path.of("week06_api_practice/data/marathon_page" + currentPage + ".json");
            String jsonResponse = readFileAsString(path.toString());

            if (currentPage == 1) {
                Pattern tpPattern = Pattern.compile("\"total_pages\":\\s*(\\d+)");
                Matcher tpMatcher = tpPattern.matcher(jsonResponse);
                if (tpMatcher.find()) {
                    totalPages = Integer.parseInt(tpMatcher.group(1));
                }
            }

            Pattern objPattern = Pattern.compile("\\{([^{}]+)\\}");
            Matcher objMatcher = objPattern.matcher(jsonResponse);

            while (objMatcher.find()) {
                String jsonObject = objMatcher.group(1);

                if (!jsonObject.contains("top_speed")) {
                    continue;
                }

                double currentSpeed = extractDouble(jsonObject, "top_speed");
                String currentName = extractString(jsonObject, "name");
                String currentMarathon = extractString(jsonObject, "marathon_name");
                String currentSex = extractString(jsonObject, "sex");

                if (currentMarathon.equals(marathon) && currentSex.equals(sex)) {
                    if (currentSpeed > maxTopSpeed) {
                        maxTopSpeed = currentSpeed;
                        speedsterName = currentName;
                    }
                }
            }

            currentPage++;
        }

        return speedsterName;
    }

    static String readFileAsString(String filePath) {
        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response.toString();
    }

    static String extractString(String jsonObject, String field) {
        Pattern p = Pattern.compile("\"" + field + "\":\\s*\"(.*?)\"");
        Matcher m = p.matcher(jsonObject);
        return m.find() ? m.group(1) : "";
    }

    static double extractDouble(String jsonObject, String field) {
        Pattern p = Pattern.compile("\"" + field + "\":\\s*([0-9.]+)");
        Matcher m = p.matcher(jsonObject);
        return m.find() ? Double.parseDouble(m.group(1)) : -1.0;
    }
}

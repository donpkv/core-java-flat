import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Practice 01 — Regex on a JSON-like string (no HTTP yet)
 *
 * Scenario: API returned one line of JSON. Extract fields with Pattern/Matcher.
 *
 * Run from working directory = core_java_programs
 */
public class P01_RegexExtractFieldsFromJson {

    public static void main(String[] args) {
        String json = """
                {"page":1,"total_pages":2,"data":[
                {"name":"Alice Runner","marathon_name":"Boston Marathon","sex":"F","top_speed":18.2},
                {"name":"Bob Fast","marathon_name":"Boston Marathon","sex":"M","top_speed":21.5}
                ]}""";

        // total_pages — capture group (\\d+) is group 1
        Pattern totalPagesPattern = Pattern.compile("\"total_pages\":\\s*(\\d+)");
        Matcher totalPagesMatcher = totalPagesPattern.matcher(json);
        if (totalPagesMatcher.find()) {
            int totalPages = Integer.parseInt(totalPagesMatcher.group(1));
            System.out.println("total_pages = " + totalPages);
        }

        // Each flat object inside data array: { ... } with no nested braces
        Pattern objectPattern = Pattern.compile("\\{([^{}]+)\\}");
        Matcher objectMatcher = objectPattern.matcher(json);

        while (objectMatcher.find()) {
            String objectBody = objectMatcher.group(1);

            // skip the outer wrapper if it matched "page":1,... — filter by top_speed field
            if (!objectBody.contains("top_speed")) {
                continue;
            }

            String name = extractStringField(objectBody, "name");
            double speed = extractDoubleField(objectBody, "top_speed");
            System.out.println("Runner: " + name + ", top_speed = " + speed);
        }
    }

    static String extractStringField(String jsonObject, String fieldName) {
        Pattern p = Pattern.compile("\"" + fieldName + "\":\\s*\"(.*?)\"");
        Matcher m = p.matcher(jsonObject);
        return m.find() ? m.group(1) : "";
    }

    static double extractDoubleField(String jsonObject, String fieldName) {
        Pattern p = Pattern.compile("\"" + fieldName + "\":\\s*([0-9.]+)");
        Matcher m = p.matcher(jsonObject);
        return m.find() ? Double.parseDouble(m.group(1)) : -1.0;
    }
}

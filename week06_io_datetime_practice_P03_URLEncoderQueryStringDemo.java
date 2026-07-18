import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Practice 03 — Build safe query strings for HTTP GET
 *
 * Spaces and special chars in marathon name must be encoded.
 * URLEncoder.encode uses + for space; many APIs expect %20 in query string.
 */
public class P03_URLEncoderQueryStringDemo {

    public static void main(String[] args) {
        String marathon = "Boston Marathon";
        String sex = "F";
        int page = 2;

        String encodedMarathon = URLEncoder.encode(marathon, StandardCharsets.UTF_8).replace("+", "%20");
        String encodedSex = URLEncoder.encode(sex, StandardCharsets.UTF_8);

        String url = "https://jsonmock.hackerrank.com/api/marathon?marathon_name="
                + encodedMarathon + "&sex=" + encodedSex + "&page=" + page;

        System.out.println("Original marathon : " + marathon);
        System.out.println("Encoded marathon  : " + encodedMarathon);
        System.out.println("Full URL          : " + url);
    }
}

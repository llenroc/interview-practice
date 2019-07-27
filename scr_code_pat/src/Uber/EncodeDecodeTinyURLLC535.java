package Uber;

import java.util.HashMap;
import java.util.Map;

public class EncodeDecodeTinyURLLC535 {
    Map<String, String> code2url = new HashMap<String, String>();
    Map<String, String> url2code = new HashMap<String, String>();
    static String BASE_HOST = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (url2code.containsKey(longUrl)) return BASE_HOST + url2code.get(longUrl);
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = null;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int r = (int) (Math.random() * charSet.length());
                sb.append(charSet.charAt(r));
            }
            key = sb.toString();
        } while (code2url.containsKey(key)); // remake a another one if the random key exists
        code2url.put(key, longUrl);
        url2code.put(longUrl, key);
        return BASE_HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return code2url.get(shortUrl.replace(BASE_HOST, ""));
    }
}

package valverde.com.mx;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class ConverterV1 {

    public static void main (String[] args) throws IOException, MalformedURLException {

        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/979f7ceaf6aaa5085018cbdf/latest/USD";

// Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

// Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();
        System.out.println(jsonobj);

// Accessing object
        String req_result = jsonobj.get("result").getAsString();
    }
}

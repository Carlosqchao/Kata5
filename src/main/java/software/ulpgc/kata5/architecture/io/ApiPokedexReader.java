package software.ulpgc.kata5.architecture.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiPokedexReader implements PokedexReader{
    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

    @Override
    public String read(int id) throws IOException {
        String apiUrl = BASE_URL + id;
        URL url = new URL(apiUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode >= 200 && responseCode < 300){
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            )){
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine())!= null){
                    response.append(line);
                }
                return response.toString();
            }
        } else {
            return "Error";
        }


    }
}

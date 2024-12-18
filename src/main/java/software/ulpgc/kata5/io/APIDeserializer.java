package software.ulpgc.kata5.io;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.kata5.model.Pokedex;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APIDeserializer {
    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

    public Pokedex getPokemonbyId(int pokemonId) throws IOException {
        String apiUrl = BASE_URL + pokemonId;
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try(Reader reader = new InputStreamReader(connection.getInputStream())){
            Gson gson = new Gson();
            JsonElement jsonElement = gson.fromJson(reader,JsonElement.class);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            String name = jsonObject.get("name").getAsString();
            JsonObject sprites  = jsonObject.getAsJsonObject("sprites");
            String frontSprite = sprites.get("front_default").getAsString();
            String backSprite = sprites.get("back_default").getAsString();

            return new Pokedex(pokemonId,name,frontSprite,backSprite);
        } finally {
            connection.disconnect();
        }
    }
}

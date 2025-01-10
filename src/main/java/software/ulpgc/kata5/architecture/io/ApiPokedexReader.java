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
        String apiUrl = BASE_URL + id; // Construye la URL con el ID proporcionado
        URL url = new URL(apiUrl);

        // Establece la conexión
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Obtener el código de respuesta HTTP
        int responseCode = connection.getResponseCode();

        // Leer el cuerpo de la respuesta si el código es exitoso
        if (responseCode >= 200 && responseCode < 300) { // Códigos HTTP exitosos
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString(); // Devuelve el cuerpo de la respuesta
            }
        } else {
            // En caso de error, puedes devolver un mensaje o lanzar una excepción
            return "Error: " + responseCode + " - " + connection.getResponseMessage();
        }
    }
}

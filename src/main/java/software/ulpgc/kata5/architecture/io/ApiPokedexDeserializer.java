package software.ulpgc.kata5.architecture.io;

import com.google.gson.Gson;
import software.ulpgc.kata5.architecture.io.pojos.RandomPokemonGetResponse;

public class ApiPokedexDeserializer implements PokedexDeserializer{


    @Override
    public Object deserialize(String json) {
        return new Gson().fromJson(json,RandomPokemonGetResponse.class);
    }
}

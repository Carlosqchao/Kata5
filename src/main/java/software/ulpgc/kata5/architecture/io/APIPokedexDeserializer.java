package software.ulpgc.kata5.architecture.io;

import com.google.gson.Gson;
import software.ulpgc.kata5.architecture.io.pojos.RandomPokemonGetResponse;


import java.io.IOException;


public class APIPokedexDeserializer implements PokedexDeserializer{



    @Override
    public Object deserialize(String json) throws IOException {
        RandomPokemonGetResponse pokemon = new Gson().fromJson(json,RandomPokemonGetResponse.class);
        return pokemon;
    }
}

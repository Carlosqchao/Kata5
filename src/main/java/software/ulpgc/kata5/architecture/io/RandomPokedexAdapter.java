package software.ulpgc.kata5.architecture.io;

import software.ulpgc.kata5.architecture.io.pojos.RandomPokemonGetResponse;
import software.ulpgc.kata5.architecture.model.Pokedex;


public class RandomPokedexAdapter implements PokedexAdapter{


    @Override
    public Pokedex adapt(Object object) {
        return adapt(((RandomPokemonGetResponse) object));
    }

    private Pokedex adapt(RandomPokemonGetResponse pokemon){
        return new Pokedex(pokemon.name(), pokemon.sprites().front_default(),pokemon.sprites().back_default());
    }


}

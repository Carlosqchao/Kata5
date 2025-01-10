package software.ulpgc.kata5.architecture.view;

import software.ulpgc.kata5.architecture.model.Pokedex;

import java.io.IOException;

public interface PokemonDisplay {
    void show(Pokedex pokemon) throws IOException;
}

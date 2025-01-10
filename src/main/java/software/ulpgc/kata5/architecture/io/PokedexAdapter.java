package software.ulpgc.kata5.architecture.io;

import software.ulpgc.kata5.architecture.model.Pokedex;

public interface PokedexAdapter {
    Pokedex adapt(Object object);
}

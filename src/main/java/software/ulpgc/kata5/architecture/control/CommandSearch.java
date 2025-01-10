package software.ulpgc.kata5.architecture.control;

import software.ulpgc.kata5.architecture.view.PokemonDisplay;
import software.ulpgc.kata5.architecture.io.PokedexAdapter;
import software.ulpgc.kata5.architecture.io.PokedexDeserializer;
import software.ulpgc.kata5.architecture.io.PokedexReader;

import java.io.IOException;

public class CommandSearch implements Command{

    private final PokemonDisplay display;
    private final PokedexAdapter adapter;
    private final PokedexReader reader;

    private final PokedexDeserializer deserializer;

    public CommandSearch(PokemonDisplay display, PokedexAdapter adapter, PokedexReader reader, PokedexDeserializer deserializer) {
        this.display = display;
        this.adapter = adapter;
        this.reader = reader;
        this.deserializer = deserializer;
    }

    @Override
    public void execute(int id) throws IOException {
        display.show(adapter.adapt(deserializer.deserialize(reader.read(id))));
    }


}

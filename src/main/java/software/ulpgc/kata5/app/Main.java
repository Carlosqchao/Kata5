package software.ulpgc.kata5.app;

import software.ulpgc.kata5.architecture.control.CommandSearch;
import software.ulpgc.kata5.architecture.io.ApiPokedexDeserializer;
import software.ulpgc.kata5.architecture.io.ApiPokedexReader;
import software.ulpgc.kata5.architecture.io.RandomPokedexAdapter;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        CommandSearch search = new CommandSearch(frame.PokemonDisplay(),
                new RandomPokedexAdapter(),new ApiPokedexReader(),new ApiPokedexDeserializer());
        frame.put("search",search);
        frame.setVisible(true);
    }
}

package software.ulpgc.kata5.app;

import software.ulpgc.kata5.architecture.control.CommandSearch;
import software.ulpgc.kata5.architecture.io.APIPokedexDeserializer;
import software.ulpgc.kata5.architecture.io.ApiPokedexReader;
import software.ulpgc.kata5.architecture.io.RandomPokedexAdapter;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        CommandSearch search = new CommandSearch(frame.PokemonDisplay(),
                new RandomPokedexAdapter(),new ApiPokedexReader(),new APIPokedexDeserializer());
        frame.put("search",search);
        frame.setVisible(true);
    }
}

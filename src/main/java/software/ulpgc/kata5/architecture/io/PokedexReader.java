package software.ulpgc.kata5.architecture.io;

import java.io.IOException;

public interface PokedexReader {
    String read(int id) throws IOException;
}

package software.ulpgc.kata5.architecture.io;

import java.io.IOException;

public interface PokedexDeserializer {
    Object deserialize(String json) throws IOException;
}

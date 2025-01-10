package software.ulpgc.kata5.architecture.control;

import java.io.IOException;

public interface Command {
    void execute(int id) throws IOException;
}

package software.ulpgc.kata5.architecture.io.pojos;



import java.util.List;

public record RandomPokemonGetResponse(String name, Sprite sprites) {

    public record Sprite(String front_default, String back_default) {}
}
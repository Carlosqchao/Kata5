package software.ulpgc.kata5.app;
import software.ulpgc.kata5.architecture.control.Command;
import software.ulpgc.kata5.architecture.view.PokemonDisplay;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainFrame extends JFrame {
    private Map<String, Command> commands;
    private PokemonDisplay pokemonDisplay;

    public MainFrame(){
        this.setTitle("Kata 5");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());
        this.add(panel(), BorderLayout.NORTH);
        this.add(button(), BorderLayout.SOUTH);
        this.add(createSwingPokemonDisplay(), BorderLayout.CENTER);
        this.commands = new HashMap<>();

    }

    private Component createSwingPokemonDisplay() {
        SwingPokemonDisplay display = new SwingPokemonDisplay();
        this.pokemonDisplay = display;
        return display;
    }

    private Component button() {
        JButton button = new JButton("Generate a Pokemon");
        button.addActionListener(e -> {
            Random randomId = new Random();
            try {
                commands.get("search").execute(randomId.nextInt(890) + 1);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        return button;
    }

    private Component panel() {
        JPanel panel = new JPanel();
        this.add(Box.createHorizontalStrut(this.getWidth()));
        JLabel label = new JLabel("Get a Random Pokemon");
        panel.add(label);
        return panel;
    }

    public void  put(String name,Command command){
        commands.put(name, command);
    }

    public PokemonDisplay PokemonDisplay() {
        return pokemonDisplay;
    }
}

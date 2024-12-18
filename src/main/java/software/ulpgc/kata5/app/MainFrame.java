package software.ulpgc.kata5.app;

import software.ulpgc.kata5.io.APIDeserializer;
import software.ulpgc.kata5.model.Pokedex;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class MainFrame extends JFrame {
    private JLabel imageLabel;
    private JLabel imageLabel2;
    private  JLabel infoLabel;

    public MainFrame(){
        this.setTitle("Kata 5");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());
        this.add(panel(), BorderLayout.NORTH);
        this.add(button(), BorderLayout.SOUTH);
        this.add(imagePanel(), BorderLayout.CENTER);
        this.setVisible(true);
    }

    private Component button() {
        JButton button = new JButton("Generate a Pokemon");
        button.addActionListener(e -> {
            try {
                APIDeserializer pokeApiService = new APIDeserializer();
                Random randomId = new Random();
                Pokedex pokemon = pokeApiService.getPokemonbyId(randomId.nextInt(890)+1);

                ImageIcon frontSprite = loadFrontSprite(pokemon);
                ImageIcon backSprite = loadBackSprite(pokemon);
                imageLabel.setIcon(frontSprite);
                imageLabel2.setIcon(backSprite);
                imageLabel.setText("");
                infoLabel.setText(pokemon.name());

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        return button;
    }

    private static ImageIcon loadFrontSprite(Pokedex pokemon) throws IOException {
        URL url = new URL(pokemon.sprite());
        BufferedImage image= ImageIO.read(url);
        return new ImageIcon(image);
    }

    private static ImageIcon loadBackSprite(Pokedex pokemon) throws IOException {
        URL url = new URL(pokemon.backSprite());
        BufferedImage image= ImageIO.read(url);
        return new ImageIcon(image);
    }

    private Component imagePanel() {
        JPanel panel = new JPanel();
        panel.setLayout( new BorderLayout());
        JPanel spritePanel = new JPanel(new GridLayout(1,2));

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        imageLabel2 = new JLabel();
        imageLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        spritePanel.add(imageLabel);
        spritePanel.add(imageLabel2);

        infoLabel = new JLabel("",SwingConstants.CENTER);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(spritePanel,BorderLayout.CENTER);
        panel.add(infoLabel,BorderLayout.SOUTH);
        return  panel;
    }

    private Component panel() {
        JPanel panel = new JPanel();
        this.add(Box.createHorizontalStrut(this.getWidth()));
        JLabel label = new JLabel("Get a Random Pokemon");
        panel.add(label);
        return panel;
    }


}

package software.ulpgc.kata5.app;

import software.ulpgc.kata5.architecture.model.Pokedex;
import software.ulpgc.kata5.architecture.view.PokemonDisplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SwingPokemonDisplay extends JPanel implements PokemonDisplay {
    private JLabel imageLabel;
    private JLabel imageLabel2;
    private  JLabel infoLabel;

    public SwingPokemonDisplay() {
        this.setLayout(new BorderLayout());
        this.add(imagePanel(), BorderLayout.CENTER);
    }

    public void show(Pokedex pokemon) throws IOException {
        ImageIcon frontSprite = loadFrontSprite(pokemon);
        ImageIcon backSprite = loadBackSprite(pokemon);
        imageLabel.setIcon(frontSprite);
        imageLabel2.setIcon(backSprite);
        imageLabel.setText("");
        infoLabel.setText(pokemon.name());
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


}

package view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class DrawingPanel extends JPanel {

    private HashMap<String, Image> imageCache;

    public DrawingPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        imageCache = new HashMap<>();
    }

    public void showImage(String imageUrl) {
        // Verificar si la imagen ya está en caché
        if (imageCache.containsKey(imageUrl)) {
            displayImage(imageUrl, imageCache.get(imageUrl));
        } else {
            // Si no está en caché, descargar y guardar en caché
            loadImage(imageUrl);
        }
    }

    private void loadImage(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            Image image = ImageIO.read(url);
            if (image != null) {
                imageCache.put(imageUrl, image);
                displayImage(imageUrl, image);
            } else {
                System.err.println("Failed to load image: " + imageUrl);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayImage(String imageUrl, Image image) {
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon);
        add(imageLabel);
        revalidate();
        repaint();
    }

    public void clearPanel() {
        removeAll();
        revalidate();
        repaint();
    }
}

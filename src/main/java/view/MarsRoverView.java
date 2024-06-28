package view;

import models.Photo;
import service.MarsRoverService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MarsRoverView {

    private MarsRoverService service;
    private JTextArea linkTextArea;
    private JTextField cameraField;
    private JTextField solField;
    private JTextField earthDateField;

    public MarsRoverView() {
        service = new MarsRoverService();
    }

    public void initialize() {
        // Crear la ventana Swing
        JFrame frame = new JFrame("Mars Rover Image Links");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Panel para mostrar los enlaces de las imágenes
        linkTextArea = new JTextArea(30, 70);
        linkTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(linkTextArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel para la entrada de búsqueda
        JPanel inputPanel = new JPanel();
        cameraField = new JTextField(10);
        solField = new JTextField(5);
        earthDateField = new JTextField(10);
        JButton searchButton = new JButton("Generate");
        inputPanel.add(new JLabel("Camera:"));
        inputPanel.add(cameraField);
        inputPanel.add(new JLabel("Sol:"));
        inputPanel.add(solField);
        inputPanel.add(new JLabel("Earth Date:"));
        inputPanel.add(earthDateField);
        inputPanel.add(searchButton);
        frame.add(inputPanel, BorderLayout.NORTH);

        // Acción del botón de búsqueda
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cameraName = cameraField.getText();
                String sol = solField.getText();
                String earthDate = earthDateField.getText();

                List<Photo> photos = service.fetchFilteredPhotos(cameraName, sol, earthDate);

                // Limpiar el área de texto y mostrar los enlaces
                linkTextArea.setText("");
                for (Photo photo : photos) {
                    linkTextArea.append(photo.getImgSrc() + "\n");
                }
            }
        });

        frame.setVisible(true);
    }
}

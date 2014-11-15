package com.mineSweeper;

import javax.swing.*;
import java.awt.*;

/**
 * Created by qiaorui on 11/15/14.
 */
public class AdministratorShell extends JFrame {
    private static volatile AdministratorShell instance;
    private JPanel mainPanel;
    private JTextField textField;
    private JTextArea textArea;
    private final int ancho = 400;
    private final int altura = 550;


    private AdministratorShell(){
        inicializar();
    }

    public static AdministratorShell getInstance() {
        if (instance == null) {
            synchronized (AdministratorShell.class) {
                if (instance == null) {
                    instance = new AdministratorShell();
                }
            }
        }
        return instance;
    }

    private void inicializar(){
        setSize(ancho, altura);    //tamany de la ventana
        setTitle("Administrator Shell");

        textArea = new JTextArea("Welcome to the Administrator Shell\n" +
                "-----------------------------------------------------------------\n" +
                "This is beta version, you can't enter command for now :)\n" +
                "********************************************************\n");
        textArea.setLineWrap(true);
        textArea.setAutoscrolls(true);
        textField = new JTextField();


        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(textField, BorderLayout.SOUTH);
        getContentPane().add(mainPanel);

    }

    public void showText(String text){
        textArea.setText(textArea.getText()+text);
        setVisible(true);
    }


}

package com.mineSweeper.presentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by qiaorui on 11/14/14.
 */
public class LoginFrame extends JFrame {


    private JButton okButton;
    private JButton cancelButton;
    private JTextField usernameArea;
    private JTextField passwordArea;
    private JPanel mainPanel;
    private ActionListener actionListener;

    private final int ancho = 250;
    private final int altura = 250;


    public LoginFrame(ActionListener actionListener){
        this.actionListener = actionListener;
    }

    public void inicializar(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();     //dimension es la dimension de la pantalla
        setSize(ancho, altura);    //tamany de la ventana
        setLocation(( dimension.width - ancho) / 2, (dimension.height - altura) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        inicializarElement();
        Box box = Box.createVerticalBox();

        box.add(Box.createVerticalStrut(30));

        JPanel tmp = new JPanel();
        tmp.add(usernameArea);
        box.add(tmp);

        box.add(Box.createVerticalStrut(5));

        JPanel tmp2 = new JPanel();
        tmp2.add(passwordArea);
        box.add(tmp2);


        box.add(Box.createVerticalStrut(45));

        JPanel tmp3 =new JPanel();
        tmp3.add(okButton);
        Box box2 = Box.createHorizontalBox();
        box2.add(tmp3);

        box2.add(Box.createHorizontalStrut(10));

        JPanel tmp4 = new JPanel();
        tmp4.add(cancelButton);
        box2.add(tmp4);

        box.add(box2);
        mainPanel = new JPanel();
        mainPanel.add(box);
        getContentPane().add(mainPanel);
    }

    private void inicializarElement(){
        okButton = new JButton("OK");
        okButton.setActionCommand("okLogin");
        okButton.addActionListener(actionListener);
        cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("cancel");
        cancelButton.addActionListener(actionListener);
        usernameArea = new JTextField(12);
        usernameArea.setText("username");
        passwordArea = new JTextField(12);
        passwordArea.setText("password");
    }


}

package com.mineSweeper.presentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by qiaorui on 1/14/15.
 */
public class RegistrarFrame extends JFrame implements ActionListener{

    private InterfaceRegistrar registrar;

    private JButton okButton;
    private JButton cancelButton;
    private JTextField usernameArea;
    private JTextField passwordArea;
    private JTextField cognomArea;
    private JTextField nomArea;
    private JTextField emailArea;
    private JPanel mainPanel;

    private final int ancho = 350;
    private final int altura = 350;

    public RegistrarFrame(InterfaceRegistrar interfaceRegistrar) {
        registrar = interfaceRegistrar;
    }


    public void inicializar(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();     //dimension es la dimension de la pantalla
        setSize(ancho, altura);    //tamany de la ventana
        setLocation(( dimension.width - ancho) / 2, (dimension.height - altura) / 2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Registrar");
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

        box.add(Box.createVerticalStrut(5));

        JPanel tmp5 = new JPanel();
        tmp5.add(nomArea);
        box.add(tmp5);

        box.add(Box.createVerticalStrut(5));

        JPanel tmp6 = new JPanel();
        tmp6.add(cognomArea);
        box.add(tmp6);

        box.add(Box.createVerticalStrut(5));

        JPanel tmp7 = new JPanel();
        tmp7.add(emailArea);
        box.add(tmp7);

        box.add(Box.createVerticalStrut(30));

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
        okButton.addActionListener(this);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        usernameArea = new JTextField(12);
        usernameArea.setText("username");
        passwordArea = new JTextField(12);
        passwordArea.setText("password");
        cognomArea = new JTextField(12);
        cognomArea.setText("cognom");
        nomArea = new JTextField(12);
        nomArea.setText("nom");
        emailArea = new JTextField(20);
        emailArea.setText("tuEmail@email.com");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == okButton) {
            registrar.prOkRegistrar(usernameArea.getText(),passwordArea.getText(),nomArea.getText(),cognomArea.getText(),emailArea.getText());
        }
        if (event.getSource() == cancelButton) {
            registrar.prCancel();
        }
    }



}

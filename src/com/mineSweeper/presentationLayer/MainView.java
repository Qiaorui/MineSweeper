package com.mineSweeper.presentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mineSweeper.AdministratorShell;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.*;

/**
 * Created by qiaorui on 11/14/14.
 */
public class MainView extends JFrame implements ActionListener{

    private Box menu;
    private JPanel mainPanel;
    private JButton jugarPartidaButton;
    private JButton loginButton;
    private JButton consultarNivellButton;
    private JButton sortirButton;
    private CJugarPartida cJugarPartida;
    private CLogin cLogin;

    private final int ancho = 350;
    private final int altura = 600;


    private JButton nextSkin;
    private JButton previousSkin;
    private int skinId = 24;

    public MainView () {
        cJugarPartida = new CJugarPartida();
        cLogin = new CLogin();
    }


    public void inicializar() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();     //dimension es la dimension de la pantalla
        setSize(ancho, altura);    //tamany de la ventana
        setLocation(( dimension.width - ancho) / 2, (dimension.height - altura) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mine Sweeper");
        setResizable(false);

        inicializarButton();
        menu = Box.createVerticalBox();

        Image image = kit.createImage(getClass().getResource("/image/unnamed.png"));
        //Image image=kit.getImage("res/image/unnamed.png");
        setIconImage(image);

        JPanel tmp1 = new JPanel();
        tmp1.add(new JLabel("Mine Sweeper"));
        menu.add(tmp1);

        JPanel tmp5 = new JPanel();
        tmp5.add(new JLabel(new ImageIcon(getClass().getResource("/image/unnamed.png"))));
        //tmp5.add(new JLabel(new ImageIcon("res/image/unnamed.png")));
        menu.add(tmp5);

        JPanel tmp = new JPanel();
        tmp.add(loginButton);
        menu.add(tmp);

        menu.add(Box.createVerticalStrut(5));

        JPanel tmp2 = new JPanel();
        tmp2.add(consultarNivellButton);
        menu.add(tmp2);


        menu.add(Box.createVerticalStrut(5));

        JPanel tmp3 = new JPanel();
        tmp3.add(jugarPartidaButton);
        menu.add(tmp3);


        menu.add(Box.createVerticalStrut(5));

        JPanel tmp4 = new JPanel();
        tmp4.add(sortirButton);
        menu.add(tmp4);

        Box box = Box.createHorizontalBox();
        box.add(previousSkin);
        box.add(Box.createHorizontalStrut(20));
        box.add(nextSkin);

        menu.add(Box.createVerticalStrut(5));
        menu.add(box);

        mainPanel = new JPanel();
        mainPanel.add(menu);
        setContentPane(mainPanel);
        setVisible(true);
    }

    private void inicializarButton() {
        jugarPartidaButton = new JButton("Jugar partida");
        jugarPartidaButton.addActionListener(this);
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        consultarNivellButton = new JButton("Consultar nivell");
        consultarNivellButton.addActionListener(this);
        sortirButton = new JButton("Sortir");
        sortirButton.addActionListener(this);
        nextSkin = new JButton(" next ");
        nextSkin.addActionListener(this);
        previousSkin = new JButton(" previous ");
        previousSkin.addActionListener(this);
    }

    public void changeSkin(){
        switch (skinId){
            case 0: SubstanceLookAndFeel.setSkin(new AutumnSkin());break;
            case 1: SubstanceLookAndFeel.setSkin(new BusinessSkin());break;
            case 2: SubstanceLookAndFeel.setSkin(new BusinessBlackSteelSkin());break;
            case 3: SubstanceLookAndFeel.setSkin(new BusinessBlueSteelSkin());break;
            case 4: SubstanceLookAndFeel.setSkin(new ChallengerDeepSkin());break;
            case 5: SubstanceLookAndFeel.setSkin(new CremeSkin());break;
            case 6: SubstanceLookAndFeel.setSkin(new CremeCoffeeSkin());break;
            case 7: SubstanceLookAndFeel.setSkin(new DustSkin());break;
            case 8: SubstanceLookAndFeel.setSkin(new DustCoffeeSkin());break;
            case 9: SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());break;
            case 10: SubstanceLookAndFeel.setSkin(new GeminiSkin());break;
            case 11: SubstanceLookAndFeel.setSkin(new GraphiteSkin());break;
            case 12: SubstanceLookAndFeel.setSkin(new GraphiteAquaSkin());break;
            case 13: SubstanceLookAndFeel.setSkin(new GraphiteGlassSkin());break;
            case 14: SubstanceLookAndFeel.setSkin(new MagellanSkin());break;
            case 15: SubstanceLookAndFeel.setSkin(new MarinerSkin());break;
            case 16: SubstanceLookAndFeel.setSkin(new MistAquaSkin());break;
            case 17: SubstanceLookAndFeel.setSkin(new MistSilverSkin());break;
            case 18: SubstanceLookAndFeel.setSkin(new ModerateSkin());break;
            case 19: SubstanceLookAndFeel.setSkin(new NebulaSkin());break;
            case 20: SubstanceLookAndFeel.setSkin(new NebulaBrickWallSkin());break;
            case 21: SubstanceLookAndFeel.setSkin(new OfficeBlack2007Skin());break;
            case 22: SubstanceLookAndFeel.setSkin(new OfficeBlue2007Skin());break;
            case 23: SubstanceLookAndFeel.setSkin(new OfficeSilver2007Skin());break;
            case 24: SubstanceLookAndFeel.setSkin(new RavenSkin());break;
            case 25: SubstanceLookAndFeel.setSkin(new SaharaSkin());break;
        }

        AdministratorShell.getInstance().showText("Skin ID: "+skinId+"\n");
    }

    @Override
    public void actionPerformed (ActionEvent event) {
        if (event.getSource() == sortirButton) {
            System.exit(0);
        }
        else if (event.getSource() == loginButton) {
            login();
        }
        else if (event.getSource() == consultarNivellButton) {

        }
        else if (event.getSource() == jugarPartidaButton) {
            jugarPartida();
        }
        else if (event.getSource() == previousSkin) {
            skinId = (skinId-1)%26;
            changeSkin();
        }
        else if (event.getSource() == nextSkin) {
            skinId = (skinId+1)%26;
            changeSkin();
        }
    }

    public void jugarPartida() {
        cJugarPartida.inicializar();
        //setVisible(false);
    }

    public void login(){
        cLogin.inicializar();
    }

}

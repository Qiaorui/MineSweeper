package com.mineSweeper;

import com.mineSweeper.presentationLayer.*;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.*;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JFrame.setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SubstanceLookAndFeel.setSkin(new RavenSkin());
                try {
                    MainView mainView = new MainView();
                    CUJugarPartidaStub cuJugarPartidaStub = new CUJugarPartidaStub();
                    mainView.setCJugarPartida(new CJugarPartida(cuJugarPartidaStub));
                    mainView.setCLogin(new CLogin());
                    mainView.setCConsultarNivell(new CConsultarNivell());
                    mainView.inicializar();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}

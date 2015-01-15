package com.mineSweeper;

import com.mineSweeper.domainLayer.domainControllers.CUConsultarNivells;
import com.mineSweeper.domainLayer.domainControllers.CUJugarPartida;
import com.mineSweeper.domainLayer.domainControllers.CURegistrar;
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
                    mainView.setCJugarPartida(new CJugarPartida( new CUJugarPartida();));
                    /** Cas d'us Login es per login de admin, no esta acabat.*/
                    mainView.setCLogin(new CLogin());
                    mainView.setCConsultarNivell(new CConsultarNivell(new CUConsultarNivells();));
                    mainView.setCRegistrar(new CRegistrar(new CURegistrar()));
                    mainView.inicializar();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}

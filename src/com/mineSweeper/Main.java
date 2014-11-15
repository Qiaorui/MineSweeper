package com.mineSweeper;

import com.mineSweeper.presentationLayer.MainView;
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
                    mainView.inicializar();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}

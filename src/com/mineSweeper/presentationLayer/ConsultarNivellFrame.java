package com.mineSweeper.presentationLayer;

import com.mineSweeper.AdministratorShell;
import com.mineSweeper.domainLayer.domainModel.Administrator;
import com.mineSweeper.domainLayer.struct.Dades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by qiaorui on 11/15/14.
 */
public class ConsultarNivellFrame extends JFrame implements ActionListener{

    private InterfaceConsultarNivell consultarNivell;
    private JPanel mainPanel;
    private JButton okButton;
    private JButton cancelButton;
    private final int ancho = 300;
    private final int altura = 300;
    private JList nivells;
    private Dades[] dades;

    /**
     * ConsultarNivellFrame Creadora del Frame per a Consultar Nivell
     * @param consultarNivell Interficies de Consulta Nivell
     */
    public ConsultarNivellFrame(InterfaceConsultarNivell consultarNivell){
        this.consultarNivell = consultarNivell;
    }

    /**
     * inicializar inicialitza el frame amb les dades de tots els nivells
     * @param dades vector amb la informacio corresponent a cada nivell
     */
    public void inicializar(Dades[] dades){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();     //dimension es la dimension de la pantalla
        setSize(ancho, altura);    //tamany de la ventana
        setLocation(( dimension.width - ancho) / 2, (dimension.height - altura) / 2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Consultar Nivell");
        setResizable(false);
        inicializarElement();

        this.dades = dades;
        String[] information = new String[dades.length];
        for (int i=0; i < dades.length; ++i) {
            information[i] = dades[i].nom+": "+dades[i].nombreMines+" mines"+dades[i].nombreCasellaxColumna+
                    " x "+dades[i].nombreCasellaxFila;
        }


        Box box = Box.createVerticalBox();

        box.add(Box.createVerticalStrut(30));

        nivells = new JList<String>(information);
        nivells.setName("Nivells");
        nivells.setSelectedIndex(0);
        JPanel tmp = new JPanel();
        tmp.add(nivells);
        box.add(tmp);

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

    /**
     * inicializarElement afegeix botons i els seus events al Frame
     */
    private void inicializarElement(){
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(okButton)) {
            int i = nivells.getSelectedIndex();
            consultarNivell.prOkCrearPartida(dades[i].nom,dades[i].nombreCasellaxFila,dades[i].nombreCasellaxColumna);
        }
        if (event.getSource().equals(cancelButton)) {
            consultarNivell.prCancel();
        }
    }

}

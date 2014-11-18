package com.mineSweeper.presentationLayer;


import com.mineSweeper.AdministratorShell;
import com.mineSweeper.domainLayer.struct.Dades;

/**
 * Created by qiaorui on 11/14/14.
 */
public class JugarPartidaView {

    private LoginFrame loginFrame;
    private ConsultarNivellFrame consultarNivellFrame;
    private JugarPartidaFrame jugarPartidaFrame;
    private CJugarPartida cJugarPartida;

    public JugarPartidaView(CJugarPartida cJugarPartida) {
        this.cJugarPartida = cJugarPartida;
    }

    public void inicializar() {
        loginFrame = new LoginFrame(cJugarPartida);


        loginFrame.inicializar();
        loginFrame.setVisible(true);
    }


    public void mostraDialog(String missatge) {

    }

    public void mostraNivells(Dades[] dades) {
        loginFrame.dispose();
        consultarNivellFrame = new ConsultarNivellFrame(cJugarPartida);
        consultarNivellFrame.inicializar(dades);
        consultarNivellFrame.setVisible(true);
    }

    public void mostraNoExisteixNivell() {

    }

    public void mostraMissatge(String missatge) {

    }

    public void mostraDesmarcarCasella(int fila, int columna) {

    }

    public void mostraMarcarCasella(int fila, int columna) {

    }

    public void mostraGuanyda(int punt) {

    }

    public void mostraPerdida() {

    }

    public void mostraDescobrirCasella(int fila, int columna){

    }

    public void mostraPartida(int nFila, int nColumna){
        consultarNivellFrame.dispose();
        jugarPartidaFrame = new JugarPartidaFrame(cJugarPartida);
        jugarPartidaFrame.inicializar(nFila,nColumna);
        jugarPartidaFrame.setVisible(true);
    }

    public void tancar(){
        if (loginFrame != null)loginFrame.dispose();
        if (consultarNivellFrame != null)consultarNivellFrame.dispose();
        if (jugarPartidaFrame != null)jugarPartidaFrame.dispose();
    }


}

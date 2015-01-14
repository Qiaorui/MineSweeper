package com.mineSweeper.dataLayer;


import java.util.List;

import org.hibernate.Session;

import com.mineSweeper.domainLayer.dataInterface.CtrlCasella;
import com.mineSweeper.domainLayer.domainModel.Casella;
import com.mineSweeper.domainLayer.domainModel.Jugador;
import com.mineSweeper.domainLayer.domainModel.Partida;


public class CtrlCasellaBD implements CtrlCasella{

    public Casella getCasella(Partida p, int numeroFila, int numeroColumna) {
    	ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		Casella c = (Casella) session.createQuery("from Casella where "+" "
				+ "partidaid = "+p.getIdPartida()+" and numeroFila = "+numeroFila+" and numeroColumna = "+numeroColumna+"").uniqueResult();
		
		session.getTransaction().commit();

		return c;
    }
    public void createCasella(Casella a) {
    	ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		session.save(a);
		session.getTransaction().commit();
    	
    }
    public void updateCasellas(Casella a) {
    	ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		session.update(a);
		session.getTransaction().commit();
    }
    
    public List getCasellas(Partida p) {
    	ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		session.beginTransaction();
    	List casellas = session.createQuery("from Casella where partidaid = "+p.getIdPartida()+"").list();
		return casellas;
    }
}

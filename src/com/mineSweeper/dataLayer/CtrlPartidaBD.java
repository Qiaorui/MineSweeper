package com.mineSweeper.dataLayer;

import org.hibernate.Session;

import com.mineSweeper.domainLayer.dataInterface.CtrlPartida;
import com.mineSweeper.domainLayer.domainModel.Nivell;
import com.mineSweeper.domainLayer.domainModel.Partida;

public class CtrlPartidaBD implements CtrlPartida {

    public Partida getPartida(int partidaid) {
    	ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		session.beginTransaction();
		
		Partida p = (Partida) session.createQuery("from Partida where partidaid = '"+p.getIdPartida()+"'").uniqueResult();
		
		session.getTransaction().commit();
		
		
		return p;
    }
    public void createPartida(Partida partida) {
    	ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		session.save(partida);
		session.getTransaction().commit();
    }
    
    public void updatePatida(Partida partida) {
    	ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		session.update(partida);
		session.getTransaction().commit();
    }
}

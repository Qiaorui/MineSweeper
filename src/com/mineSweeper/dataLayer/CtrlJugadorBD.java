package com.mineSweeper.dataLayer;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;

import com.mineSweeper.AdministratorShell;
import com.mineSweeper.domainLayer.dataInterface.CtrlJugador;
import com.mineSweeper.domainLayer.domainModel.Jugador;
import com.mineSweeper.domainLayer.domainModel.Nivell;

public class CtrlJugadorBD implements CtrlJugador{
	
	public Jugador getJugador(String username) {
		ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		session.beginTransaction();
		
		Jugador j = (Jugador) session.createQuery("from Jugador where username = '"+username+"'").uniqueResult();
	
		session.getTransaction().commit();
		return j;
	}
	
	public void createJugador(Jugador j) {
		ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		session.beginTransaction();
		
		session.save(j);
		session.getTransaction().commit();
	}
	
	public void updateJugador(Jugador j) {
		ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		session.beginTransaction();
		
		session.update(j);
		session.getTransaction().commit();
	}
}

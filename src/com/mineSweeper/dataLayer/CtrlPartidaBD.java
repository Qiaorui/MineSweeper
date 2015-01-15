package com.mineSweeper.dataLayer;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.mineSweeper.domainLayer.dataInterface.CtrlPartida;
import com.mineSweeper.domainLayer.domainModel.Casella;
import com.mineSweeper.domainLayer.domainModel.Nivell;
import com.mineSweeper.domainLayer.domainModel.Partida;
import com.mineSweeper.domainLayer.struct.Dades;

public class CtrlPartidaBD implements CtrlPartida {

    public Partida getPartida(int partidaid) {
    	ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		session.beginTransaction();
		
		Partida p = (Partida) session.createQuery("from Partida where partidaid = "+partidaid+"").uniqueResult();
		List casellas = session.createQuery("from Casella where partidaid = "+partidaid+"").list();

		session.getTransaction().commit();
		
		
		Casella[] aux = new Casella[casellas.size()];
        int i = 0;
        for (Iterator iterator1 = casellas.iterator(); iterator1.hasNext();)
        	{
        	Casella c = (Casella) iterator1.next();
        	aux[i] = c;
        	i++;
        }
		
		
		
		return p;
    }
    public void createPartida(Partida partida) {
    	ConnexionPgl.getInstance();
    	
    	
    	
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		session.beginTransaction();
		
		session.save(partida);
		session.getTransaction().commit();
    }
    
    public void updatePartida(Partida partida) {
    	ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		session.beginTransaction();
		
		session.update(partida);
		session.getTransaction().commit();
    }
}

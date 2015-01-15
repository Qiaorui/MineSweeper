package com.mineSweeper.dataLayer;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.mineSweeper.domainLayer.dataInterface.CtrlJugador;
import com.mineSweeper.domainLayer.dataInterface.CtrlNivell;
import com.mineSweeper.domainLayer.dataInterface.DataControllerFactory;
import com.mineSweeper.domainLayer.domainModel.Administrator;
import com.mineSweeper.domainLayer.domainModel.Casella;
import com.mineSweeper.domainLayer.domainModel.Jugador;
import com.mineSweeper.domainLayer.domainModel.Nivell;
import com.mineSweeper.domainLayer.domainModel.Partida;
import com.mineSweeper.domainLayer.domainModel.UsuariRegistrat;

public class ConnexionPgl {
	
	private static ConnexionPgl instance;
	
	private static AnnotationConfiguration config;
	private static SessionFactory factory;
	
	public static SessionFactory getFactory() {
		return factory;
	}

	private ConnexionPgl() {
		config = new AnnotationConfiguration();
		
		config.addAnnotatedClass(Nivell.class);
		config.addAnnotatedClass(UsuariRegistrat.class);
		config.addAnnotatedClass(Jugador.class);
		config.addAnnotatedClass(Administrator.class);
		config.addAnnotatedClass(Casella.class);
		config.addAnnotatedClass(Partida.class);
		
		config.configure("hibernate.cfg.xml");
		factory = config.buildSessionFactory();
		
		//new SchemaExport(config).create(true, true);
    }

    public static ConnexionPgl getInstance() {
        if (instance == null) {
            synchronized (ConnexionPgl.class) {
                if (instance == null) {
                    instance = new ConnexionPgl();
                }
            }
        }
        return instance;
    }
    
    

}

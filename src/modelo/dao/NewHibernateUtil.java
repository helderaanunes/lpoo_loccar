package modelo.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author paula
 */
public class NewHibernateUtil {

    
    private static final SessionFactory sessionFactory;
    
    static {
        try {
            System.out.println("Tentando configurar a Session Factory...");
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            System.out.println("Session Factory criada com sucesso!");
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Falha ao criar a Session Factory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}

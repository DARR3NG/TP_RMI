/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.Machine;
import entities.Sale;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author tarma
 */
public class SaleService extends UnicastRemoteObject implements IDao<Sale>{
    
    
    public SaleService() throws RemoteException {
        super();
    }

    @Override 
    public boolean create(Sale o) throws RemoteException {
         Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean update(Sale o) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Sale o) throws RemoteException {
    
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public List<Sale> findAll() throws RemoteException {
   
    
        Session session = null;
        Transaction tx = null;
        List<Sale> sales = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            sales  = session.getNamedQuery("findAllNativeSale").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return sales;
    }

    @Override
    public Sale findById(int id) throws RemoteException {
    
         Session session = null;
        Transaction tx = null;
        Sale sale = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            sale  = (Sale) session.get(Sale.class, id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return sale;
    }

    @Override
    public List<Machine> findMachineBySale(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

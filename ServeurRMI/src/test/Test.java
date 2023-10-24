/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.IDao;
import entities.Machine;
import entities.Sale;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SaleService;
import util.HibernateUtil;

/**
 *
 * @author tarma
 */
public class Test {
    
    public static void main(String[] args) {
        try {
            IDao<Machine> dao = new MachineService();
           /* IDao<Machine> dao = new MachineService();
            dao.create(new Machine("ER44", "HP", 1000));
            dao.create(new Machine("ER46", "MENOVO", 5000));
            dao.create(new Machine("ER48", "HP", 5000));
            
            for(Machine  m : dao.findAll())
                System.out.println(m);*/
            
            /*IDao<Sale> dao = new SaleService();
            dao.create(new Sale("code1"));
            dao.create(new Sale("code2"));
            dao.create(new Sale("code3"));
            
            for(Sale s:dao.findAll())
                System.out.println(s);*/
             for(Machine s:dao.findMachineBySale(1))
                System.out.println(s);
        } catch (RemoteException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

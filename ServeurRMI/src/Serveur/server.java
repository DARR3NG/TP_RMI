/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;

import dao.IDao;
import entities.Machine;
import entities.Sale;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SaleService;

/**
 *
 * @author tarma
 */
public class server {
    
    public static void main(String[] args) {
        try {
            IDao<Machine> daoM = new MachineService();
            IDao<Sale> daoS = new SaleService();
            LocateRegistry.createRegistry(1099);
            Naming.bind("rmi://localhost:1099/daoM", daoM);
            Naming.bind("rmi://localhost:1099/daoS", daoS);
            System.out.println("En attente des clients");
        } catch (RemoteException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientrmi2;

import dao.IDao;
import entities.Machine;
import entities.Sale;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lachgar
 */
public class ClientRMI2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            IDao<Machine> dao = (IDao<Machine>) Naming.lookup("rmi://localhost:1099/daoM");
            
            IDao<Sale> daoS = (IDao<Sale>) Naming.lookup("rmi://localhost:1099/daoS");
            System.out.println(daoS.create(new Sale("code")));
            

            /*for (Machine m : dao.findAll()) {
                System.out.println(m);
            }*/

        } catch (NotBoundException ex) {
            Logger.getLogger(ClientRMI2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientRMI2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientRMI2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

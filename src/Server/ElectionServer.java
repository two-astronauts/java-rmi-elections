/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Implement.ElectionImplement;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author User
 */
public class ElectionServer {
    public static void main(String []args) throws RemoteException{
        Registry reg = LocateRegistry.createRegistry(1099);
        ElectionImplement electionImplement = new ElectionImplement();
        // Nombre objeto
        reg.rebind("election", electionImplement);
        System.out.println("servidor iniciado");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Bean.Departament;
import Bean.Total;
import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author User
 */
public interface ElectionInterface extends Remote {
    public List<Departament> fillDepartaments(File file) throws RemoteException;

    public List<Departament> calcPercents(List<Departament> departaments) throws RemoteException;

    public Total calcTotal(List<Departament> departaments) throws RemoteException;
}

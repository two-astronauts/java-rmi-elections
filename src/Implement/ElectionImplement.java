/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Bean.Departament;
import Bean.Total;
import Interface.ElectionInterface;
import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class ElectionImplement extends UnicastRemoteObject implements ElectionInterface {

    public ElectionImplement() throws RemoteException {
    }

    @Override
    public List<Departament> fillDepartaments(File file) throws RemoteException {
        List<Departament> departaments = new ArrayList<>();
        try {
            try (Scanner myReader = new Scanner(file)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine(); // Toma la linea
                    if (!data.isEmpty()) {
                        fillDepartament(departaments, data); // Convierte la linea a un departamento
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return departaments;
    }

    public void fillDepartament(List<Departament> departaments, String departament) {
        String[] depTemp = departament.split(",");
        departaments.add(new Departament(
                depTemp[0],
                Integer.parseInt(depTemp[1]),
                Integer.parseInt(depTemp[2]),
                Integer.parseInt(depTemp[3]),
                Integer.parseInt(depTemp[4]),
                Integer.parseInt(depTemp[5])
        ));
    }

    @Override
    public List<Departament> calcPercents(List<Departament> departaments) throws RemoteException {
        departaments.forEach((departament) -> {
            departament.setAbstentionPercent(calcAbstention(departament));
            departament.setWhitePercent(calcPercent(departament.getRegistered(), departament.getWhite()));
            departament.setGroup1Percent(calcPercent(departament.getRegistered(), departament.getGroup1()));
            departament.setGroup2Percent(calcPercent(departament.getRegistered(), departament.getGroup2()));
            departament.setGroup3Percent(calcPercent(departament.getRegistered(), departament.getGroup3()));
        });
        return departaments;
    }

    public float calcAbstention(Departament departament) {
        int votes = departament.getWhite() + departament.getGroup1() + departament.getGroup2() + departament.getGroup3();
        int totalVotes = departament.getRegistered() - votes;
        return calcPercent(departament.getRegistered(), totalVotes);
    }

    public float calcPercent(int registered, int votes) {
        return (float) ((votes * 100.0) / registered);
    }

    @Override
    public Total calcTotal(List<Departament> departaments) throws RemoteException {
        Total total = new Total(0, 0);
        int registered = 0;
        int votes = 0;
        for (Departament departament : departaments) {
            registered += departament.getRegistered();
            votes += departament.getWhite() + departament.getGroup1() + departament.getGroup2() + departament.getGroup3();
        }
        total.setRegistered(registered);
        total.setVotes(votes);
        return total;
    }

}

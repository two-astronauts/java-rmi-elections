/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Bean.Departament;
import Bean.Total;
import Interface.ElectionInterface;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ElectionClient {
    private static List<Departament> departaments = new ArrayList<>();
    private static Total total = new Total(0, 0);

    public static void main(String[] args) throws IOException {
        try {
            File file = new File("votes.txt"); // Cargar archivo plano delimitado por comas
            ElectionInterface electionInterface = (ElectionInterface)Naming.lookup("election"); // Invocar registro del servidor
            departaments = electionInterface.fillDepartaments(file); // Obtener votos del archivo plano
            if (departaments.isEmpty()) {
                System.out.println("Archivo vacio");
            } else {
                menu(electionInterface); // Mostrar menu si existen votos
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ElectionClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void menu(ElectionInterface electionInterface) throws IOException {
        int choice = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("1.Mostrar tabla");
            System.out.println("2.Calcular porcentajes");
            System.out.println("3.Calcular totales");
            System.out.println("0.Salir");
            System.out.println("OPCION:");
            choice = Integer.parseInt(br.readLine());
            if (choice != 0) {
                switch (choice) {
                    case 1:
                        showDepartaments();
                        break;
                    case 2:
                        departaments = electionInterface.calcPercents(departaments);
                        showDepartaments();
                        break;
                    case 3:
                        total = electionInterface.calcTotal(departaments);
                        showDepartaments();
                        break;
                    default:
                        System.out.println("Error!");
                        break;
                }
            }
        } while (choice != 0);
    }

    public static void showDepartaments() {
        System.out.println();
        System.out.println(
                String.format(
                        "%15s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s",
                        "Departamento", "|", "Inscritos", "|", "Voto Blanco", "|", "Partido1", "|", "Partido2", "|", "Partido3", "|",
                        "% abstención", "|", "% Blanco", "|", "% Partido1", "|", "% Partido2", "|", "% Partido3"));
        System.out.println(
                String.format("%s", String.join("", Collections.nCopies(240, "-"))));
        departaments.forEach((departament) -> {
            System.out.println(
                    String.format(
                            "%15s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10.2f %10s %10.2f %10s %10.2f %10s %10.2f %10s %10.2f",
                            departament.getName(), "|", departament.getRegistered(), "|", departament.getWhite(), "|", departament.getGroup1(), "|", departament.getGroup2(), "|", departament.getGroup3(),
                            "|", departament.getAbstentionPercent(), "|", departament.getWhitePercent(), "|", departament.getGroup1Percent(), "|", departament.getGroup2Percent(), "|", departament.getGroup3Percent()));
        });
        System.out.println(
                String.format("%s", String.join("", Collections.nCopies(240, "-"))));
        System.out.println(
                String.format(
                        "%15s %10s %10s %10s %10s %10s %10s", "Totales inscritos", "|", total.getRegistered(), "|", "Totales votos", "|", total.getVotes()));
        System.out.println();
    }

}

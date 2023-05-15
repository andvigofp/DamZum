package es.joseluisgs.dam.DamZum.main.java.es.dam;

/**
 * @Author: Andrés Fernández Pereira
 */
import java.util.Scanner;

import static es.joseluisgs.dam.DamZum.main.java.es.dam.BusinessLogic.transferir;

public class App {
    public static void main( String[] args ) {
        float saldo = 500.00f;
        System.out.println("Dime el la cantidad a transferir");
        float cantidad = leerFloat();
        System.out.println("Dime el telefono");
        Scanner sc = new Scanner(System.in);
        String telf = sc.nextLine();

        try {
            saldo = transferir(saldo, cantidad, telf);
            System.out.println(saldo);

        }catch (CantidadIncorrectaException |  CantidadIntervaloIncorrectoException | TamanhoCaracteresTelefonoException | PrimerCaracterTelefonoException | CaracterIncorrectoTelefonoException e){
            System.out.println(e.getMessage());
        }
    }




    public static float leerFloat() {
        boolean ok = true;
        float cantidad = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                cantidad = sc.nextFloat();
                ok = true;
            } catch (Exception ex) {
                System.err.println("No es una cantidad válida");
                ok = false;
                sc.next();
            }
        } while(!ok);
        return cantidad;
    }
}



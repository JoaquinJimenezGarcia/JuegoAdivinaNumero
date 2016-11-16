package com.company;

import javax.swing.*;
import java.util.Scanner;

import static com.apple.eio.FileManager.getResource;
import static java.lang.System.in;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(in);
        Icon sharapova = new ImageIcon("/com.company/sharapova.jpg");

        int intentos = 0, num, numIntroducido, puntuacion = 100, nivel = 1, dificultad = 0, vidas = 3;
        String jugar, jugarMinus = "valor";

        num = (int)(1+Math.random()*99 + dificultad);

        do {
            do {
                //System.out.println("Estás en el nivel " + nivel);
                //System.out.println("Introduce un número para jugar:");
                numIntroducido = Integer.parseInt(JOptionPane.showInputDialog("Estás en el nivel "+nivel+"\n" +"Inserte número:" +num));
                //numIntroducido = input.nextInt();
                intentos++;
                puntuacion = puntuacion - (Math.abs(numIntroducido - num));
                vidas--;
                if (numIntroducido < num && num != numIntroducido && vidas > 0) {
                    //System.out.println("El número oculto es mayor al tuyo");
                    JOptionPane.showMessageDialog(null,"El numero oculto es mayor al tuyo");
                } else if (numIntroducido > num && num != numIntroducido && vidas > 0) {
                    //System.out.println("El número oculto es menor al tuyo");
                    JOptionPane.showMessageDialog(null,"El numero oculto es menor al tuyo");
                }
            } while (num != numIntroducido && vidas > 0);

            if (num==numIntroducido) {
                vidas++;
                /*System.out.println("Enhorabuena!");
                System.out.println("Lo has logrado en " + intentos + " intentos");
                System.out.println("==================");
                System.out.printf("= ");
                System.out.printf("Puntuación: " + puntuacion);
                System.out.printf("  = \n");
                System.out.println("==================");*/
                JOptionPane.showMessageDialog(null,"Enhorabuena! Lo has logrado en "+intentos+" intentos" + "\n"+"Puntuación: "+puntuacion);
            }

            while(!jugarMinus.equals("si") && !jugarMinus.equals("no") && vidas > 0){
                /*System.out.println("Desea volver a jugar? (si/no)");
                jugar = input.next();
                jugarMinus = jugar.toLowerCase();*/
                jugar = JOptionPane.showInputDialog("Desea volver a jugar?");
                jugarMinus = jugar.toLowerCase();
            }

            /*do{
                System.out.println("Desea volver a jugar? (si/no)");
                jugar = input.next();
                jugarMinus = jugar.toLowerCase();
            }while(!jugarMinus.equals("si") && !jugarMinus.equals("no"));*/

            if (jugarMinus.equals("si")){
                nivel++;
                dificultad = dificultad + 20;
                intentos = 0;
                num = (int) (1 + Math.random() * (99 + dificultad));
            }

        }while(jugarMinus.equals("si"));

        if (jugarMinus.equals("no")){
            //System.out.println("Espero que te hayas divertido. Hasta pronto!");
            JOptionPane.showMessageDialog(null,"Espero que te hayas divertido. Hasta pronto!","Adiós!", JOptionPane.WARNING_MESSAGE,sharapova);

        }

        if (vidas == 0){
            //System.out.println("Ohhhh... Se te han acabado los intentos :(");
            JOptionPane.showMessageDialog(null,"Ohhhh.. Se te han acabado los intentos...");
        }

    }
}

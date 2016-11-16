package com.company;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int intentos = 0, num, numIntroducido, puntuacion = 0, nivel = 1, dificultad = 0, vidas = 10;
        String jugar, jugarMinus = "valor";

        num = (int)(1+Math.random()*99 + dificultad);

        do {
            do {
                System.out.println("Estás en el nivel " + nivel);
                System.out.println("Introduce un número para jugar:");
                numIntroducido = input.nextInt();
                intentos++;
                puntuacion = puntuacion + (100 - (Math.abs(numIntroducido - num)));
                vidas--;
                if (numIntroducido < num && num != numIntroducido && vidas > 0) {
                    System.out.println("El número oculto es mayor al tuyo");
                } else if (numIntroducido > num && num != numIntroducido && vidas > 0) {
                    System.out.println("El número oculto es menor al tuyo");
                }
            } while (num != numIntroducido && vidas > 0);

            if (num==numIntroducido) {
                vidas++;
                System.out.println("Enhorabuena!");
                System.out.println("Lo has logrado en " + intentos + " intentos");
                System.out.println("==================");
                System.out.printf("= ");
                System.out.printf("Puntuación: " + puntuacion);
                System.out.printf("  = \n");
                System.out.println("==================");
            }

            while(!jugarMinus.equals("si") && !jugarMinus.equals("no") && vidas > 0){
                System.out.println("Desea volver a jugar? (si/no)");
                jugar = input.next();
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
            System.out.println("Espero que te hayas divertido. Hasta pronto!");
        }

        if (vidas == 0){
            System.out.println("Ohhhh... Se te han acabado los intentos :(");
        }

    }
}

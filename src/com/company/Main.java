package com.company;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int intentos = 0, num, numIntroducido, puntuacion = 0, nivel = 1, dificultad = 0;
        String jugar, jugarMinus = "si";

        num = (int)(1+Math.random()*99 + dificultad);

        do {
            do {
                System.out.println("Estás en el nivel " + nivel);
                System.out.println("Introduce un número para jugar:");
                numIntroducido = input.nextInt();
                intentos++;
                if (numIntroducido < num && num != numIntroducido) {
                    System.out.println("El número oculto es mayor al tuyo");
                } else if (numIntroducido > num && num != numIntroducido) {
                    System.out.println("El número oculto es menor al tuyo");
                }
            } while (num != numIntroducido);

            if (num==numIntroducido){
                System.out.println("Enhorabuena!");
                System.out.println("Lo has logrado en " + intentos + " intentos");
            }

            switch(intentos){
                case 1:
                    puntuacion = puntuacion + 10;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    puntuacion = puntuacion + 5;
                    break;
                case 6:
                case 7:
                    puntuacion = puntuacion + 2;
                    break;
                case 8:
                case 9:
                case 10:
                    puntuacion = puntuacion + 1;
                    break;
                default:
                    puntuacion = puntuacion - 2;
                    break;
            }

            System.out.println("==================");
            System.out.printf("= ");
            System.out.printf("Puntuación: " + puntuacion);
            System.out.printf("  = \n");
            System.out.println("==================");

            do{
                System.out.println("Desea volver a jugar? (si/no)");
                jugar = input.next();
                jugarMinus = jugar.toLowerCase();
            }while(!jugarMinus.equals("si") && !jugarMinus.equals("no"));

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

    }
}

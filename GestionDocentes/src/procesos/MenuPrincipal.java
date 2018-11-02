/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.util.Scanner;

/**
 *
 * @author FERNANDO
 */
public class MenuPrincipal {
  
    Gestor gestor = new Gestor();
    public MenuPrincipal(){
        Menu();
    }

    public void Menu() {
        int op = 0;
        Scanner teclado = new Scanner(System.in);
        while (op != 4) {
            System.out.printf("%10s\n", "1.- Ingresar materia: ");
            System.out.printf("%10s\n", "2.- Ingresar docente: ");
            System.out.printf("%10s\n", "3.- Ingresar estudiante: ");
            System.out.printf("%10s\n", "4.- Ver Materias ");
            System.out.printf("%10s\n", "4.- Salir ");
            System.out.print("Opción: ");
            op = teclado.nextInt();
            switch (op) {
                case 1:
                    gestor.asignarMateria();
                    break;
                case 2:
                    gestor.asignarDocentes();
                    break;
                case 3:
                    gestor.asignarEtudiante();
                    break;
                default:
                    if (op != 4) {
                        System.out.println("ERROR: Opción incorrecta");
                    }
                    break;
            }
        }

    }

}

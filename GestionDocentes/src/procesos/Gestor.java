/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import datos.Calificacion;
import datos.Docente;
import datos.Estudiante;
import datos.Lista;
import datos.Materia;
import java.util.Scanner;

/**
 *
 * @author FERNANDO
 */
public class Gestor {

    Lista materias = new Lista();
    Lista docentes = new Lista();
    Lista estudiantes = new Lista();
    Scanner teclado = new Scanner(System.in);

    public void asignarMateria() {
        Materia m = new Materia();
        System.out.print("Agregar identificador: ");
        m.setId(teclado.next());
        System.out.print("Agregar nombre de la Materia: ");
        m.setNombre(teclado.next());
        System.out.print("Agregar descripción: ");
        m.setDescripción(teclado.next());
        materias.insertar(m);
    }

    public void asignarDocentes() {
        Docente d = new Docente();
        System.out.print("Agregar cédula: ");
        d.setCedula(teclado.next());
        System.out.print("Agregar nombre: ");
        d.setNombre(teclado.next());
        System.out.print("Agregar apellido: ");
        d.setApellido(teclado.next());
        System.out.print("Agregar dirección: ");
        d.setDireccion(teclado.next());
        System.out.print("Agregar teléfono: ");
        d.setTelefono(teclado.next());
        System.out.print("Agregar materia impartida: ");
        d.setMateriaImpartida(materias.buscarMateria(teclado.next()));
        docentes.insertar(d);
    }

    private Calificacion insertarCalificacion() {
        Calificacion c = new Calificacion();
        System.out.print("Agregar nota: ");
        c.setCalificacion(teclado.nextFloat());
        System.out.print("Agregar docente: ");
        c.setDocente(docentes.buscarDocente(teclado.next()));
        return c;
    }

    public void asignarEtudiante() {
        int op = 0;
        Estudiante e = new Estudiante();
        System.out.print("Agregar cédula: ");
        e.setCedula(teclado.next());
        System.out.print("Agregar nombre: ");
        e.setNombre(teclado.next());
        System.out.print("Agregar apellido: ");
        e.setApellido(teclado.next());
        System.out.print("Agregar calificaciones: ");
        e.setCalificaciones(new Lista());
        while (op != 2) {
            System.out.print("1.- Agregar nueva calificación: ");
            System.out.print("2.- Salir: ");
            System.out.print("Opción: ");
            op= teclado.nextInt();
            switch (op) {
                case 1:
                    e.getCalificaciones().insertar(insertarCalificacion());
                    break;
                default:
                    if (op != 2) {
                        System.out.println("ERROR: Opción incorrecta");
                    }
                    break;
            }
        }
    }
}

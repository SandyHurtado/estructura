/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import datos.Lista;
import datos.Materia;
import java.util.Scanner;

/**
 *
 * @author FERNANDO
 */
public class Gestor {
    Lista materias= new Lista();
    Lista docentes= new Lista();
    Lista estudiantes = new Lista();
    Scanner teclado = new Scanner(System.in);
    
    public void asignarMateria(){
        Materia m = new Materia();
        m.setId(teclado.next());
        m.setNombre(teclado.next());
        m.setDescripción(teclado.next());
        m.setDocentes(new Lista());
        materias.insertar(m);
    }
   
    public void asignarDocentes(){
        
    }
}

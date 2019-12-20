/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sem6;

import entidades.Estudiante;
import entidades.Persona;
import entidades.Profesor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laboratorio
 */
public class Sem6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        List<Persona> personas = new ArrayList<Persona>();
        
        Persona fulanito = new Estudiante();
        fulanito.setNombre("Carlitos");
        //fulanito.setNota(100); para que esto sea posible se debe hacer un casting
        ((Estudiante)fulanito).setNota(100); //esto es un casteo de la clase Estudiante, indicandole a java que fulanito es de tipo estudiante Esto es polimorfismo
        Persona sutanito = new Profesor("Roberto");
        ((Profesor)sutanito).setHorario("Diurno");
        Estudiante menganito = new Estudiante ("Jhon");
        
        //La lista personas al ser de tipo personas permite agregar objetos extendidos de persona
        //Implementacion del polimorfimo
        personas.add(fulanito);
        personas.add(sutanito);
        personas.add(menganito);
        
        try{
            printPersonas (personas);  //los catch van en orden de jerarquia
        } catch (NoRException ex){
            System.out.println("Nada de R: " + ex.getMessage());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void printPersonas(List<Persona> personas) throws Exception {
        for (Persona persona : personas){   //for each
            
            if(persona.getNombre().contains("R"))
            {
                throw new NoRException();
            }
            else
            {
                System.out.println(persona.getNombre());
            }
        }
    } 

    private static class NoRException extends Exception {

        public NoRException() {
            super ("No se permiten R's");
        }
    }
}

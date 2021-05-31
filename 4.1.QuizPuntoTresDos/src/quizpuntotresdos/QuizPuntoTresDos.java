/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizpuntotresdos;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Usuario
 */
public class QuizPuntoTresDos {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Queue<String> personal = new LinkedList<>();
        personal.add("Michelangelo");
        personal.add("Alessandro"); personal.remove();
        personal.offer("Leonardo"); personal.peek();
        personal.add("Verrocchio"); personal.poll();
        personal.element(); personal.offer("Raffaello");
        personal.peek(); personal.offer("Tiziano"); personal.remove();
        Object[]arr2 = personal.toArray();
        personal.add("Donatello"); personal.element();
        personal.remove(); personal.add("Pietro");
        
        System.out.println("Resultados: " + personal);
        System.out.println("ResultadosArray: " + arr2[1]);
        System.out.println("ResultadosArray: " + arr2[2]);
    } 
    
}

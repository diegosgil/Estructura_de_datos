/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizpuntotresuno;

import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class QuizPuntoTresUno {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Stack<String> st = new Stack<>();
        st.push("alpha");
        st.push("beta"); st.peek();
        st.push("gamma");   
        st.push("delta"); st.pop();
        st.push("epsilon"); st.size();
        st.pop(); st.push("eta");
        st.push("theta"); st.peek(); st.pop();
        st.peek(); st.pop(); st.push("iota");
        Object[] arr = st.toArray();
        st.peek(); st.add("lambda"); st.peek();
        st.pop(); st.pop(); st.pop();
        st.add("omicron"); st.peek();
        
        System.out.println("Resultados: " + st);
        System.out.println("ResultadosArray: " + arr[2]);
        System.out.println("ResultadosArray: " + arr[3]);      
    }      
}

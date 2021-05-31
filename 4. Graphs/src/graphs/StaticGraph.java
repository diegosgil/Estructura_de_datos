/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Usuario
 */
public class StaticGraph {

    private boolean AdjacencyMatrix[][];    //Matriz de adyacencia
    private int totalNodes;

    public StaticGraph(int n) {     //Constructor
        AdjacencyMatrix = new boolean[n][n];
        totalNodes = n;
    }
    
    //AGREGAR ARCOS
    public void addEdge(int source, int destination) {  //adEdge:Agregar arcos / source:origen 
        AdjacencyMatrix[source][destination] = true;    //Bidireccional
        AdjacencyMatrix[destination][source] = true;    //Bidireccional
    }

    //BORRAR ARCOS
    public void deleteEdge(int source, int destination) throws Exception {
        if (source > totalNodes || destination > totalNodes) {  //Si 'source' o 'destination' sobrepasa el total de nodos, no existe ese arco
            throw new Exception("No es posible borrar el arco, no existe");     //ò System.out.println("No existe ese arco");
        } else {
            AdjacencyMatrix[source][destination] = false;
        }
    }
    
    //MUESTRA TODA LA INFORMACION
    public String showAdjacencyMatrix() {   
        String aM = "";

        for (int i = 0; i < totalNodes; i++) {
            for (int j = 0; j < totalNodes; j++) {
            //Forma 1:
                aM += (AdjacencyMatrix[i][j]) ? 1 : 0;
            //Forma 2:
            /*
            if(AdjacencyMatrix[i][j] = true){   //si lo que hay dentro de esta matriz es verdadero,
                aM += 1;
            }else{
                aM += 0;
            */
            }
            aM += "\n"; //Realiza salto de linea
        }        
        return aM;
    }
    
    //QUIZ: PUNTO 1
    //Determinar si cada nodo tiene el mismo número de entradas y salidas.
    public boolean verificarEntradaSalida()     //CheckInOut
    {
        for (int i = 0; i < totalNodes; i++) {
            Queue<Integer> entradaSalida = new LinkedList<>();
            
            for(int j = 0; j < totalNodes; j++){
                if(AdjacencyMatrix[i][j]){
                    entradaSalida.add(1);
                }
            }
            for(int j = 0; j < totalNodes; j++){
                if(AdjacencyMatrix[j][i] && !entradaSalida.isEmpty()){
                    entradaSalida.remove();
                }
            }
            if(!entradaSalida.isEmpty()){
                return false;
            }
        }
        return true;
    }
}

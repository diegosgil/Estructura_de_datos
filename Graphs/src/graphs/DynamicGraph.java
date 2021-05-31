/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class DynamicGraph {
    
    private ArrayList<LinkedList<Integer>> adjacencyList;   //ATRIBUTO : Atributo de ArrayList<tendra un tipo de dato LinkedList< que a su vez el tipo de dato sera entero>> se llamara 'adjacencyList'
    private int totalNodes;                                 //ATRIBUTO
    LinkedList<Integer> aaa = new LinkedList<>();           //ATRIBUTO

    public DynamicGraph() {
        adjacencyList = new ArrayList<>();      //Insstanciamos el ArrayList
        totalNodes = 0;
    }

    //AGREGAR NODO
    public void addNode() {
        adjacencyList.add(totalNodes++, new LinkedList<>()); 
    }

    //AGREGAR ARCO
    public void addEdge(int source, int destination) throws Exception {
        if (source >= totalNodes || destination >= totalNodes) {
            //Preguntar si es desea agregar el nodo: invocar al metodo addNode
            throw new Exception("No existe el nodo");
        }
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }
   
    //ELIMINAR NODO Y ARCO
    public void deleteNode(int node){
        adjacencyList.get(node).clear();
        //Recorrer la lista de adyacencia y eliminar los elementos de destino
        int i = 0;
        for (LinkedList<Integer> n : adjacencyList) {
            for (Integer d : n) {
                if(d==node){
                    //System.out.println("Origen: " + i + "destino: " + d);
                    int nodeToDelete = adjacencyList.get(i).indexOf(d);     //En que posicion esta el numero
                    adjacencyList.get(i).remove(d);               
                }
            }
            i++;
        }
    }

    //METODO CON QUIEN SE ENLAZA (IDA Y VUELTA)
    public String showAdjacencyList(){
        String data = "";
        int i = 0;
        for (LinkedList<Integer> node : adjacencyList){
            data += i++ + ": " + node + "\n";
        } 
        return data;
    }

    //MOSTRAR LA LISTA DE ARCO
    public String edgeList(){
        String data = "";
        int i = 0;
        for (LinkedList<Integer> node : adjacencyList) {            
            if(node.size()!=0){                
                for (Integer destination : node) {
                    data += i + " " + destination + "\n";
                }
            }
            i++;
        }        
        return data;
    }
    
    /**
     * Recorrido en anchura
     * @param u nodo actual(donde estoy ubicado
     */
    public void BFS(int u){
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[totalNodes];
        visited[u]=true;
        
        queue.add(u);
        
        while (!queue.isEmpty()) {
            u=queue.poll();//u = Q.front, Q.pop
            System.out.print(u+" ");
            for(Integer v: adjacencyList.get(u)){
            //if v is unvisited
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
    
    public void DFS(int u){
        boolean[] visited=new boolean[totalNodes];
        DFS(u,visited);
    }
    
    private void DFS(int u, boolean[] visited){
        visited[u] = true;
        System.out.print(u + " ");
        for(Integer v: adjacencyList.get(u)){
            if(!visited[v]){
                DFS(v,visited);
            }
        }
    }
    
    
    //QUIZ: PUNTO 2
    //Llegar de un nodo a otro pasando por maximo dos arcos(independiente de la ruta tomada)
    public boolean verificarEnlaceDeDosSaltos() {
        
        boolean[][] validate = new boolean[adjacencyList.size()][adjacencyList.size()];
        boolean VoBo = true;
        
        for (int filas = 0; filas < adjacencyList.size(); filas++) {        //Le pasamos cada nodo para compararlo
            for (int columnas = 0; columnas < adjacencyList.size(); columnas++) {
                validate[filas][columnas] = pruebaLlegada(filas, columnas);
            }
        }        
        for (int filas = 0; filas < validate.length; filas++) {
            for (int columnas = 0; columnas < validate.length; columnas++) {
                if (!validate[filas][columnas]) {
                    VoBo = false;
                }
            }
        }
        return VoBo;
    }   
    private boolean pruebaLlegada(int source, int destination) {
        
        boolean validacion = false;    
        
        if (source == destination) {
            validacion = true;
        } else {        //Cuando el elemento esta dentro del destina
            for (int elemento : adjacencyList.get(source)) {
                if (elemento == destination) {
                    validacion = true;
                } else {        //Cuando el elemento no esta dentro del destina
                    for (int elemento2 : adjacencyList.get(elemento)) {
                        if (elemento2 == destination) {
                            validacion = true;
                        }
                    }
                }
            }
        }
        return validacion;
    }
}




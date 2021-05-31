/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author Usuario
 */
public class Graphs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("====================== GRAFO ESTATICO ======================");
        
        //PRUEBAS DE GRAFO ESTATICO
        StaticGraph sg = new StaticGraph(4);        //Creamos un objeto de la clase StaticGraph
        //Realizamos uniones de los grafos
        sg.addEdge(0, 1);
        sg.addEdge(1, 2);
        sg.addEdge(2, 3);
        sg.addEdge(3, 2);
        //sg.addEdge(4, 6);
        //sg.addEdge(5, 4);
        //sg.addEdge(3, 5);
        System.out.println("");

        System.out.println("lista de adyacencia (Antes de hacer el borrado)");
        System.out.println(sg.showAdjacencyMatrix());
        //sg.deleteEdge(5, 9); //Sacara un error porque estoy sobrepasando el tamaño de la tabla              
        int n=0, m=99;        
        try{
            sg.deleteEdge(3, 0);
            sg.deleteEdge(m, n);    //genera la excepción diseñada en el método          
        }catch(Exception errorcito){
            System.out.println(errorcito.getMessage());
        }               
        System.out.println("lista de adyacencia (Despues de hacer el borrado)");
        System.out.println(sg.showAdjacencyMatrix());        

        //----------------------------------------------------------------------
        System.out.println("=================================================");
        System.out.println("1er Punto Quiz");
        System.out.println("Valir Entradas - Salidas: " + sg.verificarEntradaSalida());
        System.out.println("=================================================");
        System.out.println("");
        
        
        ///////////////////////////////////////////////////////////////////////
        /*        
        System.out.println("====================== GRAFO DINAMICO ======================");
        //PRUEBAS DE GRAFO DINAMICO
        DynamicGraph dg = new DynamicGraph();
        dg.addNode();
        dg.addNode();
        dg.addNode();
        dg.addNode();
        dg.addNode();
        dg.addNode();
        try {
            dg.addEdge(3, 0);
            dg.addEdge(0, 4);
            dg.addEdge(5, 0);
            dg.addEdge(2, 1);
            dg.addEdge(1, 4);
            dg.addEdge(2, 3);
            dg.addEdge(5, 2);
            dg.addEdge(0, 3);
            dg.addEdge(4, 0);
            dg.addEdge(0, 5);
            dg.addEdge(1, 2);
            dg.addEdge(4, 1);
            dg.addEdge(3, 2);
            dg.addEdge(2, 5);
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());     //.getMEssage: Muestreme cual fue el error
        }   
        
        System.out.println("=================================================");
        System.out.println("2do Punto Quiz");
        System.out.println("Respuesta: " + dg.verificarEnlaceDeDosSaltos());         
        
        System.out.println("Recorrido en anchura: BFS");
        dg.BFS(0);
        System.out.println("");
        System.out.println("Recorrido en profundidad: DFS");
        dg.DFS(0);
        
        //----------------------------------------------------------------------
        System.out.println("lista de adyacencia (Antes de hacer el borrado)");
        System.out.println(dg.showAdjacencyList());
        
        //BORRAR NODO
        dg.deleteNode(3);
        
        System.out.println("lista de adyacencia (Despues de hacer el borrado)");
        System.out.println(dg.showAdjacencyList());
        
        System.out.println("Lista de arcos");
        System.out.println(dg.edgeList());
        */
        
        //----------------------------------------------------------------------
        System.out.println("====================== COLA PRIORIZADA DE NODOS ======================");
        
        //A donde puedo llegar desde cada arco
        MinGraphPath mgp = new MinGraphPath();
        mgp.addNode("A");
        mgp.addNode("B");
        mgp.addNode("C");
        mgp.addNode("D");
        mgp.addEdge("A", "B", 2);
        mgp.addEdge("B", "A", 2);
        mgp.addEdge("A", "C", 5);
        mgp.addEdge("C", "A", 5);
        mgp.addEdge("B", "C", 2);
        mgp.addEdge("C", "B", 2);
        mgp.addEdge("B", "D", 5);
        mgp.addEdge("D", "B", 5);
        mgp.addEdge("C", "D", 1);
        mgp.addEdge("D", "C", 1);
        System.out.println("Lista de adyacencia de grafo con arcos que tienen peso");
        System.out.println(mgp.showAdjacencyList());
        
        //Implementar un hashmap - mapa de recorrudi
        HashMap<String,EdgeNode> map = new HashMap<>();
        map.putIfAbsent("A",new EdgeNode("", 0));
        map.putIfAbsent("B",new EdgeNode("A", 2));
        map.putIfAbsent("X",new EdgeNode("A", 5));
        
        for (String k : map.keySet()) {
            
            System.out.print(k + " ");            
            System.out.print(map.get(k).getWeight()+ " ");
            System.out.print(map.get(k).getDestinationNode()+ "\n");

        }
                
        //Cola priorizada de nodos(con su respectivo peso)
        PriorityQueue<EdgeNode> PQ = new PriorityQueue<>();
        
        PQ.add(new EdgeNode("C", 5));
        PQ.add(new EdgeNode("B", 2));
        PQ.add(new EdgeNode("D", 7));
        
        System.out.println(PQ);
    }   
}
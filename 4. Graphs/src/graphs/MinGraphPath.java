/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * @author Usuario
 */
public class MinGraphPath {
    
    private HashMap<String,LinkedList<EdgeNode>> adjacencyList;

    public MinGraphPath() {
        adjacencyList = new HashMap<>();
    }
    
    public void addNode(String nodeName){
        adjacencyList.putIfAbsent(nodeName, new LinkedList<>());
    }
    
    public void addEdge(String source, String destination, int weitgh){
        adjacencyList.get(source).add(new EdgeNode(destination, weitgh));
    }
    
    public String showAdjacencyList(){
        String data="";
        for (String o : adjacencyList.keySet()) {
            System.out.println(o + ": "+getNeighbors(o));            
        }
        return data;
    }
    
    private String getNeighbors(String key){
        String data="";
        LinkedList<EdgeNode> neighbors;
        neighbors = adjacencyList.get(key);
        for (EdgeNode n : neighbors) {
            data += n.getDestinationNode()+ n.getWeight()+" ";    
        }
        return data;
    }
    

    public HashMap<String, EdgeNode> Dijkstra(String currentNode) {
        /*
        Crear un mapa de recorrido, 
        considerando vértice de destino, 
        peso total y vértice de origen 
        donde el peso desde el origen es cero, 
        los demás son infinitos.
         */
        HashMap<String, EdgeNode> map = new HashMap<>();
        EdgeNode info;
        for (String node : adjacencyList.keySet()) {
            if (node.equals(currentNode)) {
                info = new EdgeNode(null, 0);
            } else {
                info = new EdgeNode(null, Integer.MAX_VALUE);
            }
            map.putIfAbsent(node, info);
        }
        
        /*
        Crear una cola priorizada donde se almacenan 
        vértices a donde llegar y su respectivo peso.
        */
        PriorityQueue<EdgeNode> pq = new PriorityQueue<>();
        /*
        Definir un punto de referencia 
        (vértice actual y peso actual: cero) 
        y agregarlo a la cola priorizada. 
        */
        
        int currentWeight = 0,totalWeight;
        pq.add(new EdgeNode(currentNode, currentWeight));
        
        
        /*
        Generar un arreglo de vértices visitados.
        */
        LinkedList<String> visited = new LinkedList<>();

        while(!pq.isEmpty()){

            /*Sacar un vértice de la cola priorizada
            (el que tega menor peso y parasará a ser el nodo actual), 
            su peso será el peso actual. Agregar si ya no lo está, 
            el vértice sacado al arreglo de visitados
            */
            EdgeNode temp = pq.poll();
            currentNode = temp.getDestinationNode();
            currentWeight = temp.getWeight();


            /*
            *Para el vértive actual, obtener todos sus vecinos
            y calcular el peso del recorrido
            (peso actual + peso arco) para agregarlos a la cola
            priorizada si no han sido visitados.
            */

            for (EdgeNode neighbor : allNeighbors(currentNode)) {
                if(!visited.contains(neighbor.getDestinationNode())){
                    totalWeight = currentWeight + neighbor.getWeight();
                    pq.add(new EdgeNode(neighbor.getDestinationNode(), totalWeight));
                }
            }

            /*
            Actualizar el mapa de recorrido, 
            esto es comparar cada vertice de destino 
            con los existentes en la cola priorizada, 
            agregar el peso y el origen correspondiente
            (vértice sacado previamente) 
            si es menor al valor actual del mapa.
            */    

            for (EdgeNode node : pq) {
                if(node.getWeight()<map.get(node.getDestinationNode()).getWeight()){
                    map.put(node.getDestinationNode(), new EdgeNode(currentNode, node.getWeight()));
                }
            }        

            if(!visited.contains(currentNode)){
                visited.add(currentNode);
            }   
        }
        return map;
    }    

    private Iterable<EdgeNode> allNeighbors(String currentNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} 
        
    
            
            
   

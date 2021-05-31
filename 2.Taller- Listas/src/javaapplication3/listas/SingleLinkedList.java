  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.listas;

/**
 *
 * @author samaniw
 */
public class SingleLinkedList<T extends Number & Comparable> implements ILists<T> {

    private Node<T> head;
    public int auxNodo;
    public int tamaño;
    
    public SingleLinkedList() {
        head = null;
        this.auxNodo = 0;
        this.tamaño = 0;
    }

    @Override
    public void add(T d) {
        //1. Crear un nuevo nodo
        Node<T> newNode = new Node<>(d);
        //2. Modificar el siguiente del nuevo nodo(cabeza)
        newNode.setNextNode(head);
        //3. Cambiar la cabeza de la lista(nuevo nodo)
        head = newNode;
    }

    @Override
    public void addLast(T d) {
        if (isEmpty()){
            add(d);
        }else{
            //1. Crear un nuevo nodo
            Node<T> current = head;
            //2.Verificamos que el nodo actual sea diferente de vacio
            while (current.getNextNode() !=  null){
                current = current.getNextNode();        //Actualizamos el nodo actual obteniendo el nodo siguiente
            }
            Node<T> newNode = new Node <>(d);
            current.setNextNode(newNode);       //En nodo actual sera la cabeza del nuevo nodo
        }
    }

    
    
    @Override
    public void addAfter(T a, T b) {
        if (isEmpty()) {
            System.out.println("Lista vacía");    
        } else {
            
        }
    }

    
    
    @Override
    public void deleteFirts() {
        if (isEmpty()) {
            System.out.println("Lista vacía");
        } else {
            //cambiar cabeza
            //la nueva cabeza será el siguiente de la cabeza actual
            head = head.getNextNode();
        }
    }

    @Override
    public void deleteLast() {
        Node<T> i = this.head;
        while(i != null)  {
            if(i.getNextNode().getNextNode() == null)
            {
                this.auxNodo -= i.getNextNode().getData().intValue();
                i.setNextNode(null);
                this.tamaño--;
                break;
            }
            i = i.getNextNode();
        }
    }

    @Override
    public boolean delete(T d){ //ELIMINAR UN DATO DESEADO
        boolean checkDeleted = false;
        //1. Validar si el dato a borrar esta en la cabeza
        if (head.getData() == d) {
            deleteFirts();
            checkDeleted = true;            
        } else {
            //2. Recorrer toda la estructura
            Node<T> currentNode = head;
            while (currentNode.getNextNode() != null) {
                //3. Verificar si el dato se encuentra en el siguiente nodo
                if (currentNode.getNextNode().getData() == d) {
                    //4.Cambiar el siguiene del actual para que se ubique dos pasos adelante
                    currentNode.setNextNode(currentNode.getNextNode().getNextNode());   //Realiza el cambio
                    checkDeleted = true;                   
                } //5. Avanzar un nodo
                else if (currentNode.getNextNode() != null) {
                    currentNode = currentNode.getNextNode();
                }
                //System.out.println("");
            }
        }
        return checkDeleted;
    }
 
    @Override
    public String showData() {
        if (isEmpty()) {
            return "Lista vacia";
        } else {
            String info = "";
            for (Node<T> i = head; i != null; i = i.getNextNode()){    //similar a esto: (int i = 0; i < 10; i++)
                info = info + i.getData() + " - ";
            }
            
            //Forma 2:
            //Forma tradicional de recorrer lista con 'while'
            /*Node<T>currentNode = head;
            while(currentNode != null){
                info = info + currentNode.getData();
                currentNode = currentNode.getNextNode();    //siguiente nodo actual
            }*/
            return info;
        }
    }

    @Override
    public boolean isEmpty() {
        //option 1: 
        return head == null;
        /*option 2: La condicion es la misma (7 renglones hacia abajo) 
        if (head==null){
            return true;
        }
        else
        {
            return false;
        }*/
    }

    @Override
    public boolean search(T d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void addOrdered(T d) {
        //Crear un nodo para el nuevo dato.
        Node<T> newNode = new Node<>(d);
        /*Si la lista esta vacía, o el valor del primer elemento de la lista 
            es mayor que el nuevo, insertar el nuevo nodo en la primera posición 
            de la lista y modificar la cabecera respectivamente.*/
        if (isEmpty() || newNode.getData().compareTo(head.getData()) == -1) {
            add(d);
        } /*
        Si no se cumple el caso anterior, buscar el lugar adecuado 
        para la inserción: recorrer la lista conservando el nodo actual. 
        Inicializar nodo actual con el valor de primera posición, 
        y avanzar mientras el siguiente nodo no sea nulo y el dato que 
        contiene la siguiente posición sea menor o igual que el dato a insertar.
         */ else {
            Node<T> currentNode = head;
            while (currentNode.getNextNode() != null
                    && currentNode.getNextNode().getData().compareTo(d) < 0) {
                //avanzar
                currentNode = currentNode.getNextNode();
            }
            /*
            Con esto se seña al nodo adecuado, a continuación insertar el 
            nuevo nodo a continuación de él
             */
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
        }
    }
}

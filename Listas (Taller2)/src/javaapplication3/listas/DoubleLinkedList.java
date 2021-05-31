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
public class DoubleLinkedList<T extends Number & Comparable> implements ILists<T> {

    private DoubleNode<T> head; //cabeza
    private DoubleNode<T> tail; //cola

    public DoubleLinkedList() {
        head = tail = null;
    }


    @Override
    public void add(T d) {
        //verificar si la lista esta vacia
        if (isEmpty()) {
            head = tail = new DoubleNode<>(d);
        } else {
            //1.Crear un nuevo nodo con un siguiente apuntando a la cabeza
            DoubleNode<T> newNode = new DoubleNode<>(null, d, head);
            //2. Cambiar el anterior de la cabeza, para que sea el nuevo nodo
            head.setPreviousNode(newNode);
            //3. Actualizar la cabeza de la lista, para que sea el nuevo nodo
            head = newNode;
        }

    }

    @Override
    public void addLast(T d) {
        if (isEmpty()) {
            head = tail = new DoubleNode<>(d);
        } else {
            //1. Crear nuevo nodo: el anterior es la cola y el siguente es nulo
            DoubleNode<T> newNode = new DoubleNode<>(tail, d, null);
            //2. Cambiar el siguiente de la cola para que sea el nuevo nodo
            tail.setNextNode(newNode);
            //3. Actualizar la cola para que sea el nuevo nodo
            tail = newNode;
        }
    }

    @Override
    public void addAfter(T a, T b) {
        if(isEmpty()){
            System.out.println("Lista vacia");
        }else{
            //localizar y retornar del nodo
            DoubleNode<T> temp = new DoubleNode<>(null);
            for (DoubleNode<T> i = head; i != null; i = i.getNextNode()) {                
                if(i.getData().compareTo(a)==0){
                    temp = i;
                    break;                    
                }
            }
            //*************************************************************
            //Verificar si el dato no existe y evitar un nullPointerException
            //*************************************************************
            if(temp==null){
                System.out.println("No se encuentra el dato");
            }else{
                //*************************************************************
                //Verificar si el dato que se busca se encuentra al final.(nullPointerException)
                //*************************************************************
                //1. Crear un nuevo nodo con enlaces al anterior donde localizo
                //el dato, y al siguiente con el siguiente del nodo localizado
                DoubleNode<T> newNode = new DoubleNode<T>(temp,b,temp.getNextNode());
                //2. En el nodo localizado previamente, cambiar el siguiente
                //al nuevo nodo
                temp.setNextNode(newNode);
                //3. Cambiar el anterior del siguiente del nuevo nuevo, 
                //para que apunte al nuevo nodo
                newNode.getNextNode().setPreviousNode(newNode);               
            }       
        }
    }

    @Override
    public void addOrdered(T d) {
        if (isEmpty() || head.getData().compareTo(d) > 0) {
            add(d);
            return;//finalizar el método 
        }

        if (tail.getData().compareTo(d) < 0) {
            addLast(d);
            return;
        }

        DoubleNode<T> current = head;
        while (current.getData().compareTo(d) < 0) {
            current = current.getNextNode();
        }
        DoubleNode<T> anterior = current.getPreviousNode();
        DoubleNode<T> newNode = new DoubleNode<>(anterior, d, current);
        anterior.setNextNode(newNode);
        current.setPreviousNode(newNode);
    }
 
    @Override
    public void deleteFirts() {

        if (isEmpty()) {
            System.out.println("Lista sin datos");
        } else //Verificar que si la lista tiene un solo dato
        {
            if (head == tail) {
                head = tail = null;
            } else {
                //1. Actualizar la cabeza: siguiente de la cabeza actual
                head = head.getNextNode();
                //2. Cambiar el anterior de la cabeza para que sea null
                head.setPreviousNode(null);
            }
        }
    }

    @Override
    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("Lista sin datos");
        } 
        else //Verificar que si la lista tiene un solo dato
        {
            if (head == tail) {
                head = tail = null;
            } else {
                //1. Actualizar la cabeza: siguiente de la cabeza actual
                tail = tail.getPreviousNode();
                //2. Cambiar el anterior de la cabeza para que sea null
                tail.setNextNode(null);
            }
        }
    }

    @Override
    public boolean delete(T d) {
        boolean checkDeleted = false;
        //1. Validar si el dato a borrar esta en la cabeza
        if (head.getData() == d) {
            deleteFirts();
            checkDeleted = true;            
        } else {
            //2. Recorrer toda la estructura
            DoubleNode<T> currentNode = head;
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
            for (DoubleNode<T> i = head; i != null; i = i.getNextNode()) {    //==(int i = 0; i < 10; i++)
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

    public String showDataDesc() {
        if (isEmpty()) {
            return "Lista vacia";
        } else {
            String info = "";
            for (DoubleNode<T> i = tail; i != null; i = i.getPreviousNode()) {  //==(int i = 0; i < 10; i++) 
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
    public boolean isEmpty(){
        //option 1: 
        return head == null;
        /*option 2: La condicion es la misma (7 renglones hacia abajo) 
        if (head==null){
            return true;
        }else
        {
            return false;
        }*/
    }

    @Override
    public boolean search(T d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}

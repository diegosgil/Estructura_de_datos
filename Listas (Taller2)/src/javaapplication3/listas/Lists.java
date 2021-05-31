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
public class Lists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ExampleNode n1 = new ExampleNode();
        ExampleNode n2 = new ExampleNode();
        ExampleNode n3 = new ExampleNode();
        ExampleNode n4 = new ExampleNode();
        ExampleNode n5 = new ExampleNode();
        ExampleNode n6 = new ExampleNode();
        ExampleNode n7 = new ExampleNode();
        ExampleNode n8 = new ExampleNode();
        n1.setData(99);     //Darle varoles o contenido al n1
        n2.setData(88);     //Darle varoles o contenido al n2
        n3.setData(77);     //...
        n4.setData(66);
        n5.setData(55);
        n6.setData(44);
        
        //UNIR NODOS
        n1.setNextNode(n2);     //n1 se une con n2
        n2.setNextNode(n3);     //n2 se une con n3...   
        n3.setNextNode(n4);     //...
        n4.setNextNode(n5);
        n5.setNextNode(n6);
        //System.out.println("Dato del primer nodo");     //AVANZAR DOS NODOS Y OBTENER EL DATO
        //System.out.println(n1.getNextNode().getData());   //Avanzar un nodo y tomar el valor de el.
        //System.out.println(n1.getData());   //muestreme el dato que esta en n1
        System.out.println("");        
        
        //Instaciación de clase con dato genérico
        Box<Integer> bbb = new Box<>();     //<Toca decir que tipo de clase es>
        bbb.Experiment();
        bbb.Experiment(99);
        bbb.Experiment(88, 44);
        Box<Double> ccc = new Box<>();
        Box<String> ddd = new Box<>(); 
        
        /*        
        System.out.println("============================PRUEBAS DE LISTAS SIMPLES============================");        
        //Ejemplo de inserción de datos en lista simple
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();        
        //DATOS EN ORDEN
        System.out.println("Datos en orden");
        sll.addOrdered(99);
        sll.addOrdered(88);      //Imprimir en orden los datos
        sll.addOrdered(101);
        sll.addOrdered(109);
        sll.addOrdered(109);
        sll.addOrdered(11);
        sll.addOrdered(122); 
        System.out.println(sll.showData());
        System.out.println();
        
        //BORRAR DATO DESEADO
        System.out.println("Borrar dato deseado");
        System.out.println(sll.showData());   //MUESTRE LOS DATOS ORIGINALES     
        System.out.println(sll.delete(99));    //MUESTRE LOS DATOS DESPUES DEL PROCESO
        System.out.println(sll.showData());
        System.out.println();
        
        //BORRAR CABEZA ACTUAL
        System.out.println("Borrar cabeza actual");
        System.out.println(sll.showData());
        sll.deleteFirts();      
        System.out.println(sll.showData());
        System.out.println();
        
        //AGREGAR UN NODO
        System.out.println("Agregar una nuevo dato a la lista");
        System.out.println(sll.showData());        
        sll.add(55);      //Cada vez que ingrese un dato, queda de primero, lo demas corre a la derecha
        sll.add(22);
        sll.add(33);
        sll.add(715);
        sll.add(888);        
        System.out.println(sll.showData());
        System.out.println();
        
        System.out.println("PUNTOS DEL TALLER");
        //AGREGAR DATO AL FINAL
        System.out.println("Agregar una nuevo dato al final de la lista");
        System.out.println(sll.showData());        
        sll.addLast(10);
        sll.addLast(33);       
        System.out.println(sll.showData());
        System.out.println();
        
        System.out.println("Eliminar el dato del final de la lista");
        System.out.println(sll.showData());   
        sll.deleteLast();                                  
        System.out.println(sll.showData());
        System.out.println();
        
        System.out.println("Insertar un nuevo nodo despues de un dato especifico");
        System.out.println(sll.showData());   
        //sll.addAfter();                 
        //sll.addAfter();                 
        System.out.println(sll.showData());
        System.out.println();
        */
        /*Toda validacion retorna False o Verdadero
        int a=55, b=66;
        System.out.println(a!=b);*/
        
        /*Comparar datos
        String aa = "1";
        String bb = "2";
        System.out.println("Resultados de compareTo");
        System.out.println(aa.compareTo(bb));*/
        
        
        
        System.out.println("============================PRUEBAS DE LISTAS DOBLES============================");
        //PRUEBAS DE LISTAS DOBLES
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        System.out.println("Resultados de la lista dobble");
        dll.addLast(33);
        dll.addLast(44);
        dll.addLast(88);
        dll.addLast(62);
        dll.addLast(99);
        System.out.println(dll.showData());
        System.out.println();
        
        //AGRREGAR DATO AL PRINCIPIO
        System.out.println("Agregar una nuevo dato al principio de la lista");
        System.out.println(dll.showData());        
        dll.add(55);      //Cada vez que ingrese un dato, queda de primero, lo demas corre a la derecha
        dll.add(66);
        System.out.println(dll.showData());
        System.out.println();

        //ELIMINAR EL PRIMER DATO
        System.out.println("Eliminar el primer dato de la lista");        
        System.out.println(dll.showData());
        dll.deleteFirts();
        System.out.println(dll.showData());
        System.out.println();
        
        //ELIMINAR EL ULTIMO DATO
        System.out.println("Eliminar el ultimo dato de la lista");  
        System.out.println(dll.showData());
        dll.deleteLast();
        System.out.println(dll.showData());
        System.out.println();
        
        System.out.println("PUNTOS DEL TALLER");        
        //AGREGAR NUEVOS DATOS ORDENADOS A LA LISTA
        System.out.println("Agregar nuevos datos ordenados a la lista");  
        dll.addOrdered(32);
        dll.addOrdered(5);
        dll.addOrdered(66);
        dll.addOrdered(44);
        System.out.println(dll.showData());
        System.out.println();
        
        //ELIMINAR UN DATO EN ESPECIFICO DE LA LISTA
        System.out.println("Eliminar un dato en especifico de la lista");  
        System.out.println(dll.showData());
        dll.delete(88);
        System.out.println(dll.showData());
        System.out.println();
        
        //Falta evitar un NullPointerException al buscar el último dato...
        //dll.addAfter(99,11);
        //System.out.println(dll.showDataDesc()); 
        
        
        
        
        /*
        System.out.println("============================LISTA CIRCULAR SIMPLE============================");
        //PRUEBA PARA LISTA CIRCULAR SIMPLE
        CircularSingleLinkedList<Integer> csl = new CircularSingleLinkedList<>();
        System.out.println("Resultados de la lista circular simple");      
        csl.add(11);
        csl.add(77);
        csl.add(88);
        csl.add(101);
        csl.add(33);
        csl.add(44);
        csl.add(55);
        System.out.println(csl.showData()); 
        System.out.println();
        
        //ELIMINAR EL PRIMER DATO
        System.out.println("Eliminar el primer dato de la lista");        
        System.out.println(csl.showData());
        csl.deleteFirts();
        System.out.println(csl.showData());
        System.out.println();
        
        CircularSingleLinkedList<Integer> csl2 = new CircularSingleLinkedList<>();
        System.out.println("Resultados de la segunda lista circular simple");      
        csl2.add(99);
        csl2.add(88);
        csl2.add(77);
        System.out.println(csl.showData());
        System.out.println();
        
        //UNIR LISTAS
        System.out.println("Resultadp de las listas unidas");      
        csl.joinList(csl2);
        System.out.println("Listas unidas: " + csl.showData());
        System.out.println();
        
        //BUSCAR UN DATO EN ESPECIFICO
        System.out.println("Búsqueda de dato: " + csl.search(55));
        System.out.println();
        */
                
        
        
        /*
        System.out.println("============================LISTA CIRCULAR DOBLE============================");
        CircularDoubleLinkedList<Integer> cdll = new CircularDoubleLinkedList<>();
        System.out.println("Resultados de la lista circular doble");              
        cdll.add(22);
        cdll.add(33);
        cdll.add(88);
        cdll.add(10);
        cdll.add(90);
        cdll.add(5);
        System.out.println(cdll.showData());
        System.out.println();

        System.out.println("PUNTOS DEL TALLER");                
        System.out.println("Datos de la lista circular doble descendente");
        System.out.println(cdll.showDataDesc());
        System.out.println();
        */
        
        /*
        System.out.println("======================================================================");
        //PRUEBAS DE PILAS CON ARREGLO
        ArrayStack as = new ArrayStack(6);
        as.push(44);
        as.push(33);
        as.push(55);
        as.push(22);
        System.out.println(as);
        
        System.out.println("======================================================================");
        //PRUEBA DE PILA CON NODOS
        LinkedStack<Integer> ls = new LinkedStack<>();
        ls.push(11);
        ls.push(99);
        ls.push(22);
        ls.push(88);
        ls.push(33);
        System.out.println(ls);
        ls.pop();       //Elimina el dato (la cabeza exactamente)
        System.out.println(ls);

        //PRUEBAS PARA VERIFICAR EL BALANCE DE UNA EXPRESION
        String expresion = "(5 +(5 * 5))/55";
        System.out.println("Verificar parentesis: " + checkParentheses(expresion));

        //PRUEBAS DE CONVERSION A BINARIO
        System.out.println("Convetir a binario: " + toBinary(1)); 
        
        System.out.println("======================================================================");
        //PRUEBAS DE COLA
        LinkedQueue<Integer> lq = new LinkedQueue<>();
        lq.offer(22);
        lq.offer(33);
        lq.offer(44);
        lq.offer(66);
        lq.offer(11);
        lq.offer(99);
        System.out.println("Datos de la cola: "+lq);
        //Stack<Integer> testStack = new Stack<>();
        //testStack.push(22);
        //testStack.push(33);
        //testStack.push(44);
        //testStack.push(55);
        //testStack.push(66);
        //System.out.println(testStack);
        //System.out.println(testStack.search(22));
        String aa = "2";
        String bb = "1";
        System.out.println("Resultados de compareTo");
        System.out.println(aa.compareTo(bb));
        */
    }
    
       
        
    //Ejemplo de genérico
    //https://docs.oracle.com/javase/tutorial/java/generics/types.html

    public static class Box<E> {

        private E[] object;

        public void Experiment() {
            System.out.println("Experiment 1");
        }

        public void Experiment(int x) {
            System.out.println("Experiment " + x);
        }

        public void Experiment(int x, int y) {
            System.out.println("Experiment " + x + y);
        }

        public void set(E[] object) {
            this.object = object;
        }

        public Object get() {
            return object;
        }
    }

    //VERIFICAR SI UNA EXPRESION ESTA BALANCEADA
    public static boolean checkParentheses(String exp) {

        LinkedStack<String> checkBalance = new LinkedStack<>();
        char[] arrayExp = exp.toCharArray();
        for (int i = 0; i < arrayExp.length; i++) {
            if (arrayExp[i] == '(') {
                checkBalance.push("(");
            } else if (arrayExp[i] == ')') {
                if (checkBalance.empty()) {
                    return false;
                } else {
                    checkBalance.pop();
                }
            }
        }
        return checkBalance.empty();
    }

    //CONVERTIR DE DECIMAL A BINARIO
    public static String toBinary(int n) {
        LinkedStack<Integer> residue = new LinkedStack<>();
        String binary ="";
        while (n>0) {            
            residue.push(n % 2);
            n = n/2;                //n /= 2;
        }
        while (!residue.empty()) {            
            binary+=residue.pop();
        }
        return binary;
    }
}

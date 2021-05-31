/*3. Mostrar N números de la secuencia Tribonacci[1].*/
package tallerRecursividad.taller1;
/*
 * @author diegosgil
 */
public class ejercicio3 { 
    public String tribonacciPrincipal(int num, int i) { 
        //Caso base
        if(i < num){
            System.out.print(tribonacci(i) + " ");
            i++;
            return tribonacciPrincipal(num, i);
        }else{
            return "";
        }
    }
      
    private int tribonacci(int i){
        if(i == 0) {  
            return 0;
        }else{
            if(i == 1) {
                return 0;
            }else{
                if(i == 2){
                    return 1;
                }else {    
                    return tribonacci(i - 1) + tribonacci(i - 2) + tribonacci(i - 3);
                } 
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ejercicio3 r = new ejercicio3();
        r.tribonacci(11);
        System.out.println("Secuencia Tribonacci");
        System.out.println(r.tribonacciPrincipal(4,0));
    }
}

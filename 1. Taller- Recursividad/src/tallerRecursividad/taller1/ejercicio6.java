/*6. En la matemática védica existe el concepto de navshesh[2], el cual 
consiste en reducir cualquier número, sin importar su longitud, a un solo 
dígito por medio de la suma de sus dígitos. Dado un número entero, retornar 
su respectivo navshesh.
Ejemplos:
412 = 4 + 1 +2 = 7
645 = 6 + 4 +5  = 15 = 1 + 5 = 6
3861 = 3 + 8 + 6 +1 = 18 = 1 + 8 = 9
692224 = 6 + 9 + 2 + 2 + 2 + 4 = 25 = 2 + 5 = 7
*/
package tallerRecursividad.taller1;
/*
 * @author diegosgil
 */
public class ejercicio6 {
    //Caso base
    public int navshesh(int n){
        if(n<10){
            return n;
        }else{
            return navshesh((n/10)+(n%10));
        }         
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ejercicio6 r = new ejercicio6();
        System.out.println("El navshesh de 412 es: " + r.navshesh(412));
    }
}

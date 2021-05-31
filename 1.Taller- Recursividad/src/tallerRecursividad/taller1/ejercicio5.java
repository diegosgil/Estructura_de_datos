/*5. Determinar si una palabra es palíndroma.*/
package tallerRecursividad.taller1;
/*
 * @author diegosgil
 */
public class ejercicio5 {
    
    public boolean verificarPalindromo(String s){
        //Caso base
        if(s.length() == 0){
            return true;
        }else{
            if (s.length() == 1){
                return true;
            }else{
                if(s.charAt(0) == s.charAt(s.length()-1)){      //Comparo la primera y ultima letra
                    s = s.substring(1, s.length() - 1);     //borra las dos letras comparadas(primera y ultima) //substring: recorta la palabra
                        return verificarPalindromo(s);     
                }else{
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ejercicio5 r = new ejercicio5();
        System.out.print("Verificar palíndromo: ");
        System.out.print(r.verificarPalindromo("narran"));
    }
}

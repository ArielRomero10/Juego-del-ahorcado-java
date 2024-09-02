import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(System.in);

        String palabraAdivinar = "messi";
        int intentosMax = 5 , intentoActual = 0;
        boolean palabraAdivinada = false;
        

        char []  letrasAdivinadas  =  new char[palabraAdivinar.length()]; // CON ESTO SABEMOS CUANTAS LETRAS TIENE LA PALABRA A ADIVINAR
                                   
        //BUCLE PARA RELLENAR EL ARRAY CON GUIONES
        for (int i = 0; i < letrasAdivinadas.length; i++) {

            letrasAdivinadas[i]='_'; // CON ESTO MOSTRAMOS LOS GUIONES QUE NOS DAN LA PISTA DE CUANTAS LETRAS TIENE LA PALABRA A ADIVINAR
        }

        // BUCLE  QUE SE VA A EJECUTAR MIENTRAS LA PALABRA ADIVINADA SEA INCORRECTA Y TENGAS INTENTOS DISPONIBLES 
        while (!palabraAdivinada && intentoActual < intentosMax) {
            
            System.out.println("Palabra a adivinar:  " + String.valueOf(letrasAdivinadas) +"("+ palabraAdivinar.length() + " Letras)"); // ESTO SE USA CUANDO TENEMOS UN ARRAY DE CHAR Y FINALMENTE SE FORMA UNA PALABRA

            System.out.println("Introduzca una letra: ");
            char letraUsuario = Character.toLowerCase(in.next().charAt(0)); // ME DEVUELVE SOLO LA PRIMERA LETRA Y LA PONE EN MINUSCULA 
            
            Boolean letraCorrecta = false; // PARA SABER SI LA LETRA INGRESADA ES CORRECTA O NO 

            for (int i = 0; i < palabraAdivinar.length(); i++) { //RECORRE EL TAMAÑO DE LA PALABRA A ADIVINAR EN ESTE CASO 5
                
                if (palabraAdivinar.charAt(i) ==  letraUsuario) { // RECORRE LETRA X LETRA DE LA PALABRA A ADVINAR COMPARANDO CON LA LETRA QUE INGRESO EL USUARIO 
                    letrasAdivinadas[i]=letraUsuario;              //M == L
                    letraCorrecta=true;
                }
            }

            if (!letraCorrecta) { // SI LA LETRA NO FUE CORRECTA    
                    intentoActual++;
                    System.out.println("Letra incorrecta, te quedan: " + (intentosMax-intentoActual) + " Intentos" );
            }


            if (String.valueOf(letrasAdivinadas).equals(palabraAdivinar)) {  //SI PUDE ENCONTRAR LA PALABRA , ENTRAMOS AL CONDICIONAL.
                palabraAdivinada = true;
                System.out.println("¡FELICIDADES! adivinaste la palabra secreta: " + palabraAdivinar);
            }

        }

        if (!palabraAdivinada) { // CONDICIONAL POR SI SE TE ACABARON LOS INTENTOS
            System.out.println("¡GAME OVER! la proxima tendras mas suerte :)");
        }

        in.close();

    }
}

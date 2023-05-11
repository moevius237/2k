import java.io.*;
import java.util.ArrayList;

public class Problema {

    public static void main(String[] args) {
        ArrayList<Character> letras = new ArrayList();
        ArrayList<Character> letrasMayus = new ArrayList();
        ArrayList<Character> abecedario = new ArrayList();


        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
          br = new BufferedReader(new FileReader("/home/usuario/Escritorio/jafrsad/mensaje.txt"));
          bw = new BufferedWriter(new FileWriter("/home/usuario/Escritorio/jafrsad/mensaje_cifrado.txt"));

            String linea = null;
            int posicionAsci=0, posicionMensaje=0, posicionAbece;
            /* Lectura y validación  de clave */

            while ((linea = br.readLine()) != null) {
                StringBuilder sb = new StringBuilder(linea.length());

                /* Aquí vendría la lógica del programa *letrasMayus*/
                for (int i = 97; i <= 122; i++){
                    letras.add((char) i);
                }
                for (int i = 65; i <= 90; i++){
                    letrasMayus.add((char) i);
                }
                for (int i = 0; i <= 25; i++){
                    abecedario.add(letrasMayus.get(i));
                }
                char[] caracter = linea.toCharArray();
                for (int i=0;i<caracter.length;i++){
                    if(Character.isLetter(caracter[i])){
                        if (caracter[i] > 91){
                           posicionAsci = caracter[i];
                           posicionMensaje ++;
                           for (int a =0; a < abecedario.size();a++){
                               int cont=0;
                               if(caracter[i] == abecedario.get(a)){
                                   posicionAbece = cont;
                                   System.out.println(posicionAbece);
                               }
                               cont ++;
                           }
                        }else{
                            posicionAsci = caracter[i];
                            posicionMensaje ++;

                        }
                    }
                }
                bw.write(sb.toString()); /* Escribe la cadena de caracteres en el fichero*/
                bw.newLine(); /* escribe nueva línea en el fichero */

            }
            System.out.println("El mensaje ha sido cifrado correctamente");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

}




package pkg05.sopa.de.letras;

import java.util.ArrayList;
import java.util.Random;

public class Datos {
    
    public static String getLetraRandom(){
     String letra = "";
     Integer random;
     Random aleatorio = new Random();
     
     random = aleatorio.nextInt(26);
     
     switch(random){
         case 0:
             letra = "A";
             break;
         case 1:
             letra = "B";
             break;
         case 2:
             letra = "C";
             break;
         case 3:
             letra = "D";
             break;
         case 4:
             letra = "E";
             break;
         case 5:
             letra = "F";
             break;
         case 6:
             letra = "G";
             break;
         case 7:
             letra = "H";
             break;
         case 8:
             letra = "I";
             break;
         case 9:
             letra = "J";
             break;
         case 10:
             letra = "K";
             break;
         case 11:
             letra = "L";
             break;
         case 12:
             letra = "M";
             break;
         case 13:
             letra = "N";
             break;
         case 14:
             letra = "Ñ";
             break;
         case 15:
             letra = "O";
             break;
         case 16:
             letra = "P";
             break;
         case 17:
             letra = "R";
             break;
         case 18:
             letra = "S";
             break;
         case 19:
             letra = "T";
             break;
         case 20:
             letra = "U";
             break;
         case 21:
             letra = "V";
             break;
         case 22:
             letra = "W";
             break;
         case 23:
             letra = "X";
             break;
         case 24:
             letra = "Y";
             break;
         case 25:
             letra = "Z";
             break;
     }
        
     return letra;
    }
    
    public static ArrayList<String> getPalabraRandom(){
        int r;
        Random aleatorio = new Random();
        r = aleatorio.nextInt(palabras.length);
        ArrayList <String> lista = new ArrayList<>();
        lista.add(palabras[r]);
        
        while(lista.size() < 10){
            r = aleatorio.nextInt(palabras.length);
            boolean existe = false;
                for (String palabra: lista) {
                    if(!palabras[r].equals(palabra)){
                        existe = true;
                    }
                }
            if(existe){
               lista.add(palabras[r]);
            }
        }
        
        return lista;
    }
    
    private static String[] palabras = {"SILLA", "BALLENA", "OCEANO", "CORTINA", 
    "TELEVISION", "PANTALLA", "PERRO", "PENDRIVE", "CIELO", "VASO", "ESCUCHAR", 
    "ESCRIBIR", "TECLADO", "BOTELLA", "BATERIA", "FRACTURA", "TONTO", "ETICO",
    "LIBRO", "CEPILLO", "FOSFORO", "INTERNET", "FAMA", "BOTON", "ZAPATO", "MARCA",
    "BILLETE", "ESTUFA", "CAJA", "MOCHILA", "PUERTA", "HOSPITAL", "POLICIA", "CASA",
    "ISLA", "RELIGION", "PIZZA", "REMERA", "GORRA", "PANTALON", "NOMBRE", "CHILE", 
    "ARGENTINA", "BRASIL", "FRANCIA", "ESPAÑA", "BALCON", "COMEDIA", "ARBOL", "METODO",
    "PETROLEO", "COLOR", "LENGUA", "VENTANA", "VERDURA", "CARNE", "MITO", "CASCO", 
    "AVION", "BARCO", "MENTIRA", "RAZON", "SEMAFORO", "YUXTAPOSICION", "MADERA", 
    "LAMPARA", "BICHO", "CABLE", "LLUVIA", "ESTADIO", "CANAL", "ACCION", "GUITARRA", 
    "AGUA", "CAMION"};
    
}

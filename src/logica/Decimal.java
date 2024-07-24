package logica;

import java.util.Arrays;

/**
 *
 * @author Bleider Hernandez
 */
public class Decimal {
    
    private int numero;
    private SeleccionDeSistema sistema;
    private int conversion[];

    public Decimal() {
    }

    public Decimal(int numero, SeleccionDeSistema sistema) {
        setNum(numero);
        this.sistema = sistema;
        this.conversion = new int[nIteraciones(numero, sistema.getBase())];
    }

    public void setNum(int numero) {
        if (numero > 0) {
            this.numero = numero;
        } else{
//            System.out.println("Numero invalido");
        }
    }

     

    // Metodos de conversión
    
    
    public String decimalABinarioUOctal() {
        String resultado = "";
        if (sistema == SeleccionDeSistema.BINARIO || sistema == SeleccionDeSistema.OCTAL) {
            // sacamos la division entera y el residuo para obtener el resultado
            for (int i = conversion.length - 1; i >= 0; i--) {
                conversion[i] = numero % sistema.getBase();
                numero /= sistema.getBase();
            }
            // Mostrar resultado            
            for (int j = 0; j < conversion.length; j++) {
//                System.out.print(conversion[j]);
                resultado += String.valueOf(conversion[j]);
            }
//            System.out.println();
        }
        return resultado;
    }
    
    public String decimalAHexadecimal(){
        String hexaResul = "";
        if (sistema == SeleccionDeSistema.HEXADECIMAL) {
            
            String hexadecimal[] = new String[conversion.length];
            int resto, posicion;
                       
            for(int i = hexadecimal.length - 1; i >= 0; i--) {
                resto = numero % sistema.getBase();                
                if (resto > 9) {
                    
                    for (char abc = 'A'; abc <='F'; abc++) {
                        posicion = abc - 'A'; // la posicion de la letra, ejemplo: B = 1
                        if (posicion == resto - 10) { // resto - 10 para poder asginar letra correspondiente
                            hexadecimal[i] = String.valueOf(abc); // pasamos char a String
//                            break;
                        }
                    }
                }else{
                    hexadecimal[i] = String.valueOf(resto); // pasamos int a String
                }
                numero /= sistema.getBase();       // vamos achicando el valor de num         
            }
            //Mostramos el numero hexadecimal resultante
            for (String hexa : hexadecimal) {
                hexaResul += hexa;
            }

        }
        return hexaResul;
    }

    
    private int nIteraciones(int num, int base) {
        int division = num;
        int iteraciones = 0;

        if (base != 0) {
            while (division > 0) {
                division = division / base;
                iteraciones++;
            }
        }

        return iteraciones;
    }

    @Override
    public String toString() {
        return "Decimal{" + "numero=" + numero + ", sistema=" + sistema + ", conversion=" + Arrays.toString(conversion) + '}';
    }
    
    

}

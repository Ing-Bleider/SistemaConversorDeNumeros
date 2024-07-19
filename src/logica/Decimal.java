package logica;

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

    public Decimal(int num, SeleccionDeSistema sistema) {
        setNum(num);
        this.sistema = sistema;
        this.conversion = new int[nIteraciones(num, sistema.getBase())];
    }

    public void setNum(int num) {
        if (num > 0) {
            this.numero = num;
        } else{
//            System.out.println("Numero invalido");
        }
    }

     

    // Metodos de conversión
    
    
    public String decimalABinarioUOctal() {
        String resultado = "";
        if (sistema == sistema.BINARIO || sistema == sistema.OCTAL) {
            // sacamos la division entera y el residuo para obtener el resultado
            for (int i = conversion.length - 1; i >= 0; i--) {
                conversion[i] = numero % sistema.getBase();
                numero = numero / sistema.getBase();
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
    
//    public void decimalAHexadecimal(){
//        if (sistema == 16) {
//            
//            String hexadecimal[] = new String[conversion.length];
//            int resto, posicion;
//            
////            System.out.print("El numero Decimal "+numero+"\nEn su equivalente Hexadecimal es: ");
//            
//            for(int i = hexadecimal.length - 1; i >= 0; i--) {
//                resto = numero % sistema;                
//                if (resto > 9) {
//                    
//                    for (char abc = 'A'; abc <='F'; abc++) {
//                        posicion = abc - 'A'; // la posicion de la letra, ejemplo: B = 1
//                        if (posicion == resto - 10) { // resto - 10 para poder asginar letra correspondiente
//                            hexadecimal[i] = String.valueOf(abc); // pasamos char a String
//                        }
//                    }
//                }else{
//                    hexadecimal[i] = String.valueOf(resto); // pasamos int a String
//                }
//                numero = numero / sistema;       // vamos achicando el valor de num         
//            }
//            //Mostramos el numero hexadecimal resultante
//            for (String hexa : hexadecimal) {
//                System.out.print(hexa);
//            }
//            System.out.println("\n");
//        }
//    }

    
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
    
    

}

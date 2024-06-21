package conversiondenumeros;

/**
 *
 * @author Bleider Hernandez
 */
public class Decimal {
    
    private int numero;
    private int base;
    private int conversion[];

    public Decimal() {
    }

    public Decimal(int num, int base) {
        setNum(num);
        setBase(base);
        this.conversion = new int[nIteraciones(num, base)];
    }

    public void setNum(int num) {
        if (num > 0) {
            this.numero = num;
        } else{
            System.out.println("Numero invalido");
        }
    }

    public void setBase(int base) {
        if (base == 2 || base == 8 || base == 16) {
            this.base = base;
        } else{ 
            System.out.println("Base incorrecta");
            this.base = 0;
        }
    }    

    // Metodos de conversión
    
    
    public void decimalABinarioUOctal() {
        if (base == 2 || base == 8) {
            // sacamos la division entera y el residuo para obtener el resultado
            if (base == 2) {
                System.out.print("El numero Decimal "+numero+"\nEn su equivalente Binario es: ");
            }
            if (base == 8) {
                System.out.print("El numero Decimal "+numero+"\nEn su equivalente Octal es: ");
            }
          
            for (int i = conversion.length - 1; i >= 0; i--) {
                conversion[i] = numero % base;
                numero = numero / base;
            }
            // Mostrar resultado            
            for (int j = 0; j < conversion.length; j++) {
                System.out.print(conversion[j]);
            }
            System.out.println();
        }
    }
    
    public void decimalAHexadecimal(){
        if (base == 16) {
            
            String hexadecimal[] = new String[conversion.length];
            int resto, posicion;
            
            System.out.print("El numero Decimal "+numero+"\nEn su equivalente Hexadecimal es: ");
            
            for(int i = hexadecimal.length - 1; i >= 0; i--) {
                resto = numero % base;                
                if (resto > 9) {
                    
                    for (char abc = 'A'; abc <='F'; abc++) {
                        posicion = abc - 'A'; // la posicion de la letra, ejemplo: B = 1
                        if (posicion == resto - 10) { // resto - 10 para poder asginar letra correspondiente
                            hexadecimal[i] = String.valueOf(abc); // pasamos char a String
                        }
                    }
                }else{
                    hexadecimal[i] = String.valueOf(resto); // pasamos int a String
                }
                numero = numero / base;       // vamos achicando el valor de num         
            }
            //Mostramos el numero hexadecimal resultante
            for (String hexa : hexadecimal) {
                System.out.print(hexa);
            }
            System.out.println("\n");
        }
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

}

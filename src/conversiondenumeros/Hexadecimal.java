
package conversiondenumeros;

/**
 *
 * @author Bleider Hernandez
 */
public class Hexadecimal {

    
    Decimal dl;
    private String numero;
    private int base;
    private char numHexa[];
    
    
    public Hexadecimal(){}
    
    public Hexadecimal(String numero, int base){
        setNumero(numero);
        setBase(base);
        this.numHexa = new char[this.numero.length()];
    }

    public void setNumero(String numero) {
        if (validarNumero(numero).length() > 0) {
            this.numero = numero;
        }else{
            System.out.println("El valor no es Hexadecimal");
            this.numero = "";
        }
    }
    
    public void setBase(int base) {
        if (base == 2 || base == 8 || base == 10){
            this.base = base;
        }else{
            System.out.println("Base incorrecta");
            this.base = 0;
        }
    }
    
    
    // conversiones
    private String validarNumero(String n) {
        String valor = n;
        for (int i = 0; i < valor.length(); i++) {
            // toLowerCase ve por igual mayusculas y minusculas. CharAt especifica la posición del digito.
            char caracter = Character.toLowerCase(valor.charAt(i));
            
            if ( ! ((caracter >= '0' && caracter <= '9') || (caracter >= 'a' && caracter <= 'f')) ) { // Distinto de toda la expresión
                valor = "";
                break;
            }             
        }
        return valor;
    }
    
    private void asignarValores(){
        if (numHexa.length > 0) {
            for (int i = 0; i < numHexa.length; i++) {
                numHexa[i] = numero.charAt(numero.length() - i - 1);
            }
        }
    }
    
    private void conversionABinarioUOctal() {
        if (base == 2 || base == 8) {
            int guardarValor[] = new int[nIteraciones()];
            int num = conversionADecimal();
            // sacamos la division entera y el residuo para obtener el resultado
                    
            for (int i = guardarValor.length - 1; i >= 0; i--) {
                guardarValor[i] = num % base;
                num = num / base;
            }
            // Mostrar resultado            
            for (int j = 0; j < guardarValor.length; j++) {
                System.out.print(guardarValor[j]);
            }
            System.out.println();
        }
    }
    
    private int conversionADecimal() {
        char letras[] = {'a', 'b', 'c', 'd', 'e', 'f'};
        int valorDigito, potencia, multi, resultado = 0;

        asignarValores();
        for (int i = 0; i < numHexa.length; i++) {
            for (int j = 0; j < letras.length; j++) {
                if (Character.toLowerCase(numHexa[i]) == letras[j]) { // esta instruccion compara independiente de mayusculas y minusculas
                    valorDigito = 10 + j; // valor correspondiente a cada letra
                    potencia = (int) Math.pow(16, i);
                    multi = valorDigito * potencia;
                    resultado += multi;
                }
            }

            for (int k = 0; k < 10; k++) {
                valorDigito = Character.getNumericValue(numHexa[i]); // convierte char a int
                if (valorDigito == k) {
                    potencia = (int) Math.pow(16, i);
                    multi = valorDigito * potencia;
                    resultado += multi;
                }
            }
        }       
        return resultado;
    }    
   
    public void hexadecimalABinario() {
        if (numHexa.length > 0 && base == 2) {
            System.out.print("El numero Hexadecimal " + numero + "\nEn su equivalente Binario, es: ");
            conversionABinarioUOctal();
        }
    }
    
    public void hexadecimalADecimal(){
        if (numHexa.length > 0 && base == 10) {
            System.out.println("El numero Hexadecimal "+numero+"\nEn su equivalente Decimal, es: "+conversionADecimal());
        }       
    }
    
    public void hexadecimalAOctal() {
        if (numHexa.length > 0 && base == 8) {
            System.out.print("El numero Hexadecimal " + numero + "\nEn su equivalente Octal, es: ");
            conversionABinarioUOctal();
        }
    }
    
 
    private int nIteraciones() {
        int division = conversionADecimal();
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

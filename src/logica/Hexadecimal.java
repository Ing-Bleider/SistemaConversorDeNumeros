
package logica;

import java.util.Arrays;

/**
 *
 * @author Bleider Hernandez
 */
public class Hexadecimal {

    
    private Decimal dl;
    private String numero;
    private SeleccionDeSistema sistema;
    private char numHexa[];
    
    
    public Hexadecimal(){}
    
    public Hexadecimal(String numero, SeleccionDeSistema sistema){
        setNumero(numero);
        this.sistema = sistema;
        this.numHexa = new char[this.numero.length()];
    }

    public void setNumero(String numero) {
        if (validarNumero(numero).length() > 0) {
            this.numero = numero;
        }else{
//            System.out.println("El valor no es Hexadecimal");
            this.numero = "";
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
                numHexa[i] = numero.charAt(numero.length() - 1 - i);
            }
        }
    }
    
    private String conversionABinarioUOctal() {
        String resul = "";
        if (sistema == SeleccionDeSistema.BINARIO || sistema == SeleccionDeSistema.OCTAL) {
            int guardarValor[] = new int[nIteraciones()];
            int num = conversionADecimal();
            // sacamos la division entera y el residuo para obtener el resultado
                    
            for (int i = guardarValor.length - 1; i >= 0; i--) {
                guardarValor[i] = num % sistema.getBase();
                num = num / sistema.getBase();
            }
            // Mostrar resultado            
            for (int j = 0; j < guardarValor.length; j++) {
//                System.out.print(guardarValor[j]);
                resul += String.valueOf(guardarValor[j]);
            }
//            System.out.println("");
        }
        return resul;
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
   
    public String hexadecimalABinario() {
        String resultado = "";
        if (numHexa.length > 0 && sistema == SeleccionDeSistema.BINARIO) {
            resultado = conversionABinarioUOctal();
        }
        return resultado;
    }
    
    public String hexadecimalADecimal(){
        String result= "";
        if (numHexa.length > 0 && sistema == SeleccionDeSistema.DECIMAL) {
            result = String.valueOf(conversionADecimal());
        } 
        return result;
    }
    
    public String hexadecimalAOctal() {
        String resultado = "";
        if (numHexa.length > 0 && sistema == SeleccionDeSistema.OCTAL) {
            resultado = conversionABinarioUOctal();
        }
        return resultado;
    }
    
 
    private int nIteraciones() {
        int division = conversionADecimal();
        int iteraciones = 0;

        if (sistema.getBase() != 0) {
            while (division > 0) {
                division = division / sistema.getBase();
                iteraciones++;
            }
        }

        return iteraciones;
    }

    @Override
    public String toString() {
        return "Hexadecimal{" + "numero=" + numero + ", sistema=" + sistema + ", numHexa=" + Arrays.toString(numHexa) + '}';
    }
    
    
    
}

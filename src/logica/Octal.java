package logica;

import java.util.Arrays;

/**
 *
 * @author Bleider Hernandez
 */
public class Octal {

    Decimal dl;
    
    private int num;
    private SeleccionDeSistema sistema;
    private int conversion[];

    public Octal() {
    }

    public Octal(int num, SeleccionDeSistema sistema) {
        setNum(num);
        this.sistema = sistema;
        this.conversion = new int[nDigitos(num)];
    }

    public void setNum(int num) {        
        if (nDigitos(num) > 0) {            
            this.num = num;
        } else{
//            System.out.println("Numero invalido");
        }
    }


    // Conversiones 
    
    
    private int conversionADecimal() {
        int resto, divEntera = num, potencia, multi, suma = 0;
        if (num> 0) {
            for (int i = 0; i < conversion.length; i++) {
                resto = divEntera % 10;
                divEntera = divEntera / 10;
                conversion[i] = resto;
            }

            for (int i = 0; i < conversion.length; i++) {
                potencia = (int) Math.pow(SeleccionDeSistema.OCTAL.getBase(), i);
                multi = conversion[i] * potencia;
                suma += multi;
            }

            num = suma;
        }
        return num;
    }
    
    
    public String octalABinario(){        
        String numBinario = "";
//        if (sistema == SeleccionDeSistema.BINARIO) {
//            System.out.println("El numero Octal "+num);
            conversionADecimal();
            dl = new Decimal(num, sistema);
//            System.out.print("En su equivalente Binario es: ");
            numBinario = dl.decimalABinarioUOctal();
//        }
        return numBinario;
    }
    
    public int octalADecimal() {
        int decimal = 0;
        if (sistema == SeleccionDeSistema.DECIMAL) {
//            System.out.println("El numero Octal "+num);
//            System.out.print("En su equivalente Decimal es: "+conversionADecimal()+"\n");
            decimal = conversionADecimal();
        }
        return decimal;
    }
    
    public String octalAHexadecimal() {    
        String numHexadecimal = "";
        if (sistema == SeleccionDeSistema.HEXADECIMAL) {
//            System.out.println("El numero Octal "+num);
            conversionADecimal();
            dl = new Decimal(num, sistema);
//            System.out.print("En su equivalente Hexadecimal es: ");
            numHexadecimal = dl.decimalAHexadecimal();
        }
        return numHexadecimal;
    }
    
    public int nDigitos(int nume){
        int copiaNumero= nume, contCifras = 0, resto;        
        while (copiaNumero > 0) {
            resto = copiaNumero % 10;
            copiaNumero = copiaNumero / 10;
            if (resto < 0 || resto > 7) {
                contCifras = 0;
                break;
            }
            contCifras ++;
        }       
        return contCifras;
    }

    @Override
    public String toString() {
        return "Octal{" + "num=" + num + ", sistema=" + sistema + ", conversion=" + Arrays.toString(conversion) + '}';
    }

}

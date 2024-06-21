package conversiondenumeros;

/**
 *
 * @author Bleider Hernandez
 */
public class Octal {

    Decimal dl;
    
    private int num;
    private int base;
    private int conversion[];

    public Octal() {
    }

    public Octal(int num, int base) {
        setNum(num);
        setBase(base);
        this.conversion = new int[nDigitos(num)];
    }

    public void setNum(int num) {        
        if (nDigitos(num) > 0) {            
            this.num = num;
        } else{
            System.out.println("Numero invalido");
        }
    }

    public void setBase(int base) {
        if (base == 2 || base == 10 || base == 16) {
            this.base = base;
        } else{         
            System.out.println("Base incorrecta");
            this.base = 0;
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
                potencia = (int) Math.pow(8, i);
                multi = conversion[i] * potencia;
                suma += multi;
            }

            //System.out.println(suma);
            num = suma;
        }
        return num;
    }
    
    
    public void octalABinario(){        
        if (base == 2) {
            System.out.println("El numero Octal "+num);
            conversionADecimal();
            dl = new Decimal(num, base);
            System.out.print("En su equivalente Binario es: ");
            dl.decimalABinarioUOctal();
        }
    }
    
    public void octalADecimal() {
        if (base == 10) {
            System.out.println("El numero Octal "+num);
            System.out.print("En su equivalente Decimal es: "+conversionADecimal()+"\n");
        }
    }
    
    public void octalAHexadecimal() {        
        if (base == 16) {
            System.out.println("El numero Octal "+num);
            conversionADecimal();
            dl = new Decimal(num, base);
            System.out.print("En su equivalente Hexadecimal es: ");
            dl.decimalAHexadecimal();
        }
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
}

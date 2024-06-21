
package conversiondenumeros;


/**
 *
 * @author Bleider Hernandez
 */
public class Binario {

    Decimal dl;
    
    private int num;
    private int base;
    private int conversion[];

    public Binario() {
    }

    public Binario(int num, int base) {
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
        if (base == 8 || base == 10 || base == 16) {
            this.base = base;
        } else{         
            System.out.println("Base incorrecta");
            this.base = 0;
        }
    }

    // Conversiones 
    
    
    public void binarioADecimal() {
        int resto, divEntera = num, potencia, multi, suma = 0;
        if (num> 0) {
            for (int i = 0; i < conversion.length; i++) {
                resto = divEntera % 10;
                divEntera = divEntera / 10;
                conversion[i] = resto;
            }

            for (int i = 0; i < conversion.length; i++) {
                potencia = (int) Math.pow(2, i);
                multi = conversion[i] * potencia;
                suma += multi;
            }
            if (base == 10) {
                System.out.println("El numero Binario " + num + "\nEn su equivalente Decimal es: " + suma);
            }
            num = suma;
        }
    }

    
    public void binarioAOctal(){
        
        if (base == 8) {  
            System.out.println("El numero Binario "+num);
            binarioADecimal();
            dl = new Decimal(num, base); 
            System.out.print("En su equivalente Octal es: ");
            dl.decimalABinarioUOctal();
        }
    }
    
    public void binarioAHexadecimal() {
        
        if (base == 16) {
            System.out.println("El numero Binario "+num);
            binarioADecimal();
            dl = new Decimal(num, base);
            System.out.print("En su equivalente Hexadecimal es: ");
            dl.decimalAHexadecimal();
        }
    }
    
    // falta confirmar que el numero agregado si sea binario
    public int nDigitos(int nume){
        int copiaNumero= nume, contCifras = 0, resto;        
        while (copiaNumero > 0) {
            resto = copiaNumero % 10;
            copiaNumero = copiaNumero / 10;
            if (resto != 0 && resto != 1) {
                contCifras = 0;
                break;
            }
            contCifras ++;
        }       
        return contCifras;
    }
}

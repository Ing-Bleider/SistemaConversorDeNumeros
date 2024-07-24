
package logica;



/**
 *
 * @author Bleider Hernandez
 */
public class Binario {

    private Decimal dl;    
    private String num;
    private SeleccionDeSistema sistema;

    public Binario() {
    }

    public Binario(String num, SeleccionDeSistema sistema) {
        setNum(num);
        this.sistema = sistema;
    }

    public void setNum(String num) {        
        if (num !=  null) {            
            this.num = num;
        } else{
//            System.out.println("Numero invalido");
        }
    }

    // Conversiones 
    
    public String binarioADecimal() {
        int digito, potencia, multip, suma = 0;
        
        if (num != null) {
            for (int i = 0; i < num.length(); i++) {
                digito = Character.getNumericValue(num.charAt(i));
//              Si conversion.lenght = 12 || 12-1-0, 12-1-1, 12-1-2, 12-1,3, 12-1-4 ...              
                potencia = (int)Math.pow(2, (num.length() -1 -i));
                multip = digito * potencia;
                suma += multip;
            }
            num = String.valueOf(suma);
        }
        
        return num;
    }
    
    public String binarioAOctal(){
        String binOctal = "";
        if (sistema == SeleccionDeSistema.OCTAL) {  
            binarioADecimal();
            dl = new Decimal(Integer.parseInt(num), sistema); 
           binOctal = dl.decimalABinarioUOctal();
        }
        return binOctal;
    }
    
    public String binarioAHexadecimal() {
        String binHexa = "";
        if (sistema == SeleccionDeSistema.HEXADECIMAL) {
            binarioADecimal();
            dl = new Decimal(Integer.parseInt(num), sistema);
            binHexa = dl.decimalAHexadecimal();
        }
        return  binHexa;
    }

    @Override
    public String toString() {
        return "Binario{" + "num=" + num + ", sistema=" + sistema + '}';
    }

  
}

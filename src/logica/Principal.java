
package logica;

import java.util.Scanner;
import javax.naming.Binding;

/**
 * @author Bleider Hernandez
 */
public class Principal {

    public static void main(String[] args) {
       
        Decimal dec = new Decimal(204, SeleccionDeSistema.BINARIO);
        
        System.out.println(dec.decimalABinarioUOctal());
    }
    
}


package conversiondenumeros;

import java.util.Scanner;
import javax.naming.Binding;

/**
 * @author Bleider Hernandez
 */
public class Principal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Binario bin;
        Octal oct;
        Decimal dec;
        Hexadecimal hex;
        
        byte opcion;
        int base;
        int numero;
        
        System.out.println("\t>>>>>>>>>>: Sistema conversor de números :<<<<<<<<<<<\n");
        do {    
            System.out.println("\t**********: Seleccione una opción :************");
            System.out.println("""
                               1. De Binario a otra potencia
                               2. De Octal a otra potencia
                               3. De Decimal a otra potencia
                               4. De Hexadecimal a otra potencia                               
                               """);
            System.out.print("--> ");
            opcion = input.nextByte();
            
            if (opcion > 4 || opcion < 1){
                System.out.println("\t-------: El numero ingresado NO es correcto :---------\n");
            }
        } while (opcion > 4 || opcion < 1);
       
        
        if (opcion == 1) {
            System.out.print("Digite el numero Binario a convertir: ");
            numero = input.nextInt();
            System.out.print("Digite la base a convertir: ");
            base = input.nextInt();
            bin = new Binario(numero, base);
            
            System.out.println("");
            
            switch (base) {
                case 8 -> bin.binarioAOctal();
                case 10 -> bin.binarioADecimal();
                case 16 -> bin.binarioAHexadecimal();
            }
        }
        
        if (opcion == 2) {
            System.out.print("Digite el numero Octal a convertir: ");
            numero = input.nextInt();
            System.out.print("Digite la base a convertir: ");
            base = input.nextInt();
            oct = new Octal(numero, base);
            
            System.out.println("");
            
            switch (base) {
                case 2 -> oct.octalABinario();
                case 10 -> oct.octalADecimal();
                case 16 -> oct.octalAHexadecimal();
            }
        }
        
        if (opcion == 3) {
            System.out.print("Digite el numero Decimal a convertir: ");
            numero = input.nextInt();
            System.out.print("Digite la base a convertir: ");
            base = input.nextInt();
            dec = new Decimal(numero, base);
            
            System.out.println("");
            
            switch (base) {
                case 2 -> dec.decimalABinarioUOctal();
                case 8 -> dec.decimalABinarioUOctal();
                case 16 -> dec.decimalAHexadecimal();
            }
        }
        
        if (opcion == 4) {
            String numeroCadena;
            System.out.print("Digite el numero Hexadecimal a convertir: ");
            numeroCadena = input.next();
            input.nextLine();
            System.out.print("Digite la base a convertir: ");
            base = input.nextInt();
            hex = new Hexadecimal(numeroCadena, base);
            
            System.out.println("");
            
            switch (base) {
                case 2 -> hex.hexadecimalABinario();
                case 8 -> hex.hexadecimalAOctal();
                case 10 -> hex.hexadecimalADecimal();
            }
        }
    }
}

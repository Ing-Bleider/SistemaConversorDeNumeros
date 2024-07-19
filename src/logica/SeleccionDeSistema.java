
package logica;

/**
 * @author Bleider Hernandez
 */
public enum SeleccionDeSistema {
    BINARIO(2), 
    OCTAL(8), 
    DECIMAL(10), 
    HEXADECIMAL(16);
    
    private final int base;

    private SeleccionDeSistema(int base) {
        this.base = base;
    }

    public int getBase() {
        return base;
    }    
    
    @Override
    public String toString() {
        return "SeleccionDeSistema{" + "base=" + base + '}';
    }

    
}

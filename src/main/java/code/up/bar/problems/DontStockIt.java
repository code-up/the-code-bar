package code.up.bar.problems;

/**
 *
 * @author Peter C
 */
public class DontStockIt extends Exception {

    public DontStockIt(String message) {
        super(message);
    }

    public DontStockIt(String message, Throwable cause) {
        super(message, cause);
    }
    
}

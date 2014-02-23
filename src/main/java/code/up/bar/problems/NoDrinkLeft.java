package code.up.bar.problems;

/**
 *
 * @author Peter C
 */
public class NoDrinkLeft extends Exception {

    public NoDrinkLeft(String message) {
        super(message);
    }

    public NoDrinkLeft(String message, Throwable cause) {
        super(message, cause);
    }
    
}

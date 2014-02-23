package code.up.bar.problems;

/**
 *
 * @author Peter C
 */
public class WrongMeasure extends Exception {

    public WrongMeasure(String message) {
        super(message);
    }

    public WrongMeasure(String message, Throwable cause) {
        super(message, cause);
    }
}

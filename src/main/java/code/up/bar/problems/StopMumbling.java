package code.up.bar.problems;

/**
 *
 * @author Peter C
 */
public class StopMumbling extends Exception {

    public StopMumbling(String message) {
        super(message);
    }

    public StopMumbling(String message, Throwable cause) {
        super(message, cause);
    }
}

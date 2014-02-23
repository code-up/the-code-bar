package code.up.bar.orders;

import code.up.bar.problems.StopMumbling;
import code.up.bar.problems.WrongMeasure;

/**
 *
 * @author Peter C
 */
public interface OrderParser {
    Order parse(Order order, String data) throws StopMumbling, WrongMeasure;
}

package code.up.bar.tender;

import code.up.bar.orders.Order;
import code.up.bar.problems.DontStockIt;
import code.up.bar.problems.NoDrinkLeft;
import code.up.bar.problems.WrongMeasure;

/**
 *
 * @author Peter C
 */
public interface Bartender {
    
    void greeting();
    void tip();
    void serve(Order order) throws DontStockIt, NoDrinkLeft, WrongMeasure;
    void noneLeft();
    void runOut();
    void handDrink();
    void seeYa();
}

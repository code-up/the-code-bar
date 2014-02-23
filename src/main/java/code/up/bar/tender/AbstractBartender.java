package code.up.bar.tender;

import code.up.bar.drinks.Drink;
import code.up.bar.orders.Order;
import code.up.bar.orders.OrderItem;
import code.up.bar.problems.DontStockIt;
import code.up.bar.problems.NoDrinkLeft;
import code.up.bar.problems.WrongMeasure;
import code.up.bar.stock.StockCupboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rubber.duck.froot.names.People;

/**
 *
 * @author Peter C
 */
public abstract class AbstractBartender implements Bartender {
    
    private static final Logger log = LoggerFactory.getLogger(AbstractBartender.class);

    protected final StockCupboard stock;

    protected final String name = new People().random();

    public AbstractBartender(StockCupboard stock) {
        this.stock = stock;
    }

    @Override
    public void serve(Order order) throws DontStockIt, NoDrinkLeft, WrongMeasure {
        for (OrderItem item : order.getOrders()) {
            log.info("The bartender fetches the drink from the store cupboard.");
            Drink drink = fetchDrink(item);
            if (!drink.isFinished()) {
                log.info("The bartender puts the rest of the {} back.", drink.getName());
                stock.putDrinkBack(drink);
            } else {
                log.info("The {} is finished, so the bartender throws it away.", drink.getContainer().getDisplayName());
                runOut();
            }
        }
    }

    private Drink fetchDrink(OrderItem item) throws DontStockIt, NoDrinkLeft, WrongMeasure {
        Drink drink = stock.getDrink(item.getDrinkName());
        try {
            for (int i = item.getNumber(); i > 0; i--) {
                drink.drink(item.getMeasure());
            }
        } catch (NoDrinkLeft ex) {
            log.info("The {} is finished, so the bartender throws it away - he reaches for another one.", drink.getContainer().getDisplayName());
            runOut();
            return fetchDrink(item);
        }
        return drink;
    }

}

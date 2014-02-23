package code.up.bar.tender;

import code.up.bar.stock.StockCupboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Peter C
 */
public class SurlyBartender extends AbstractBartender {

    private static final Logger log = LoggerFactory.getLogger(Bartender.class);

    public SurlyBartender(StockCupboard stock) {
        super(stock);
    }

    @Override
    public void greeting() {
        log.info(name + ": *Nods* You being served?");
    }

    @Override
    public void noneLeft() {
        log.error(name + ": *grunt* None left. Anything else?");
    }

    @Override
    public void tip() {
        log.info(name + ": We tip in this country.");
    }

    @Override
    public void runOut() {
        log.info(name + ": Gonna grab another *grunt*.");
    }

    @Override
    public void handDrink() {
        log.info(name + ": *hands you the drink, and stares at you in silence*");
    }

    @Override
    public void seeYa() {
        log.info(name + ": *stares at you as you leave the bar*");
    }
}

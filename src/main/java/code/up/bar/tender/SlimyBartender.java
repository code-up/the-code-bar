package code.up.bar.tender;

import code.up.bar.stock.StockCupboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Peter C
 */
public class SlimyBartender extends AbstractBartender {
    
    private static final Logger log = LoggerFactory.getLogger(SlimyBartender.class);

    public SlimyBartender(StockCupboard stock) {
        super(stock);
    }

    @Override
    public void greeting() {
        log.info(name + ": Hey there... *looks you up and down* gorgeous. Can I get you something?");
    }

    @Override
    public void tip() {
        log.info(name + ": You gonna give me some sugar? And by that, I mean a tip...");
    }

    @Override
    public void handDrink() {
        log.info(name + ": Here you go... Come back anytime, foxy.");
    }

    @Override
    public void runOut() {
        log.info(name + ": Looks like that one's empty, let me just grab another one sweetness.");
    }
    
    @Override
    public void noneLeft() {
        log.info(name + ": Sorry love, ain't got that anymore.");
    }

    @Override
    public void seeYa() {
        log.info(name + ": Come back anytime gorgeous - I would love to see you again.");
    }
}

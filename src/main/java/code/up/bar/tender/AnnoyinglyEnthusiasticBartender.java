package code.up.bar.tender;

import code.up.bar.stock.StockCupboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Peter C
 */
public class AnnoyinglyEnthusiasticBartender extends AbstractBartender {
    
    private static final Logger log = LoggerFactory.getLogger(AnnoyinglyEnthusiasticBartender.class);

    public AnnoyinglyEnthusiasticBartender(StockCupboard stock) {
        super(stock);
    }
    
    @Override
    public void greeting() {
        log.info(name + ": Hello, and welcome to the Bar!! My name is "+name+" and I will be your server today. What can I get you?!");
    }

    @Override
    public void tip() {
        log.info(name + ": While I don't want to pressure you, we here at the Bar sure do appreciate a tip for our hard work! If you're not satisfied you can always ask for it back!!");
    }

    @Override
    public void handDrink() {
        log.info(name + ": Here's your drinks, have an absolutely fantastic day ahead, and just holler if you need anything else!");
    }

    @Override
    public void runOut() {
        log.info(name + ": That one's gone, let me just grab another one for you. Won't be a minute!");
    }
    
    @Override
    public void noneLeft() {
        log.info(name + ": I am so so sorry, but we're out of that... Is there anything else I can get you?? I will move mountains this time!!");
    }

    @Override
    public void seeYa() {
        log.info(name + ": Come back soon!!");
    }

}

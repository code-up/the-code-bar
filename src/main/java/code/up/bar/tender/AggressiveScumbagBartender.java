package code.up.bar.tender;

import code.up.bar.stock.StockCupboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Peter C
 */
public class AggressiveScumbagBartender extends AbstractBartender {
    
    private static final Logger log = LoggerFactory.getLogger(AggressiveScumbagBartender.class);

    public AggressiveScumbagBartender(StockCupboard stock) {
        super(stock);
    }
    
    @Override
    public void greeting() {
        log.info(name + ": You talkin' to me? ARE YOU TALKIN' TO ME!!");
    }

    @Override
    public void tip() {
        log.info(name + ": GIMME A TIP, BITCH!");
    }

    @Override
    public void noneLeft() {
        log.info(name + ": We don't have any - SUCKS TO BE YOU!!!");
    }

    @Override
    public void runOut() {
        log.info(name + ": GIVE ME A SECOND AND I'LL GET YOU ANOTHER, OR I'LL PUMP YOUR GUTS FULLA LEAD!!");
    }

    @Override
    public void handDrink() {
        log.info(name + ": Keep tha change, ya filthy animal!!");
    }

    @Override
    public void seeYa() {
        log.info(name + ": I'm gonna give you, to the count of 10, to get your ugly, yella, no good kiester of my property. 1, 2.... 10!!!");
    }

}

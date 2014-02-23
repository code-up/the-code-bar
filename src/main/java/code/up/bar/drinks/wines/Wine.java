package code.up.bar.drinks.wines;

import code.up.bar.drinks.AbstractDrink;
import code.up.bar.drinks.Containers;
import code.up.bar.measures.Measure;
import code.up.bar.problems.NoDrinkLeft;
import code.up.bar.problems.WrongMeasure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Peter C
 */
public class Wine extends AbstractDrink {
    
    private static final Logger log = LoggerFactory.getLogger(Wine.class);
    
    public Wine(String name, double alcoholicUnits) {
        super(name, Containers.LARGE_BOTTLE, alcoholicUnits);
    }

    @Override
    public void drink(Measure measure) throws WrongMeasure, NoDrinkLeft {
        switch (measure) {
            case WINE_GLASS: 
                break;
            case SHOT:
                log.info("The bartender looks at you oddly, but gets you your drink.");
                break;
            case PINT:
                throw new WrongMeasure("The bartender chuckles, \"We don't do pints of wine here...\"");
            case HALF_PINT:
                log.info("Strange choice of glass, but ok.");
                break;
            case BOTTLE:
                throw new WrongMeasure("\"We don't have small bottles of wine here... Try an airplane.\"");       
        }
        removeAmount(measure.measureAmount());
    }
}

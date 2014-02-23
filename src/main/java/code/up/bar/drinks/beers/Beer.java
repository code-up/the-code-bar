package code.up.bar.drinks.beers;

import code.up.bar.drinks.AbstractDrink;
import code.up.bar.drinks.Containers;
import code.up.bar.measures.Measure;
import code.up.bar.problems.NoDrinkLeft;
import code.up.bar.problems.WrongMeasure;


/**
 *
 * @author Peter C
 */
public abstract class Beer extends AbstractDrink {

    public Beer(String name, Containers container, double alcoholicUnits) {
        super(name, container, alcoholicUnits);
    }
    
    @Override
    public void drink(Measure measure) throws WrongMeasure, NoDrinkLeft {
        if (Measure.SHOT.equals(measure)){
            throw new WrongMeasure("Who drinks beer out of a shot glass?");
        } else if (Measure.WINE_GLASS.equals(measure)){
            throw new WrongMeasure("A wine glass? We don't do that for beer...");
        }
        
        removeAmount(measure.measureAmount());
    }
}

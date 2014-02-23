package code.up.bar.drinks.spirits;

import code.up.bar.drinks.AbstractDrink;
import code.up.bar.drinks.Containers;
import code.up.bar.measures.Measure;
import code.up.bar.problems.NoDrinkLeft;
import code.up.bar.problems.WrongMeasure;

/**
 *
 * @author Peter C
 */
public class Spirit extends AbstractDrink {

    public Spirit(String name, Containers container, double alcoholicUnits) {
        super(name, container, alcoholicUnits);
    }

    @Override
    public void drink(Measure measure) throws WrongMeasure, NoDrinkLeft {
        if (!Measure.SHOT.equals(measure)){
            throw new WrongMeasure("We only do shots of any spirit here... *mumbles* You raving alcoholic *mumbles*");
        }
        
        removeAmount(measure.measureAmount());
    }
}

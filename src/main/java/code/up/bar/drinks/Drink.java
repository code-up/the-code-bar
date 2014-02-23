package code.up.bar.drinks;

import code.up.bar.measures.Measure;
import code.up.bar.problems.NoDrinkLeft;
import code.up.bar.problems.WrongMeasure;

/**
 *
 * @author Peter C
 */
public interface Drink {
    
    void drink(Measure measure) throws WrongMeasure, NoDrinkLeft;
    String getName();
    Containers getContainer();
    boolean isFinished();
}

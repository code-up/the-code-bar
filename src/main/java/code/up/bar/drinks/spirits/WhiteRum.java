package code.up.bar.drinks.spirits;

import code.up.bar.drinks.Containers;
import code.up.bar.measures.Measure;
import code.up.bar.problems.NoDrinkLeft;
import code.up.bar.problems.WrongMeasure;

/**
 *
 * @author Peter C
 */
public class WhiteRum extends Spirit {

    public WhiteRum() {
        super("White Rum", Containers.LARGE_BOTTLE, 44);
    }

    @Override
    public void drink(Measure measure) throws WrongMeasure, NoDrinkLeft {
        throw new IllegalArgumentException("Anyone who asks for white rum can leave my bar immediately. Never darken our doorway again.");
    }
}

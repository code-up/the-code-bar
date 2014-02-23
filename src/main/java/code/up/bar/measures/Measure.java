package code.up.bar.measures;

import code.up.bar.problems.WrongMeasure;

/**
 *
 * @author Peter C
 */
public enum Measure {

    SHOT(25), WINE_GLASS(250), BOTTLE(330), HALF_PINT(284), PINT(568);

    private final int ml;

    private Measure(int ml) {
        this.ml = ml;
    }

    public int measureAmount() {
        return this.ml;
    }

    public static Measure parse(String measure) throws WrongMeasure {
        if ("Shot".equalsIgnoreCase(measure)) {
            return SHOT;
        } else if ("Glass".equalsIgnoreCase(measure)) {
            return WINE_GLASS;
        } else if ("Half-Pint".equalsIgnoreCase(measure)) {
            return HALF_PINT;
        } else if ("Bottle".equalsIgnoreCase(measure)) {
            return BOTTLE;
        } else if ("Pint".equalsIgnoreCase(measure)) {
            return PINT;
        }
        throw new WrongMeasure("I've never heard of a \"" + measure + "\" - come on your wasting my time now...");
    }
}

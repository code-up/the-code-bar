package code.up.bar.drinks;

/**
 *
 * @author Peter C
 */
public enum Containers {

    KEG(58674), LARGE_BOTTLE(700), CAN(440), SMALL_BOTTLE(330);

    private final int millilitres;

    private Containers(int millilitres) {
        this.millilitres = millilitres;
    }

    public int getContainerAmount() {
        return millilitres;
    }

    public String getDisplayName() {
        switch (this) {
            case KEG:
                return "keg";
            case LARGE_BOTTLE:
                return "large bottle";
            case SMALL_BOTTLE:
                return "small bottle";
            case CAN:
                return "can";
        }
        // Never going to reach here.
        return "container";
    }
}

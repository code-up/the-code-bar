package code.up.bar.drinks;

import code.up.bar.problems.NoDrinkLeft;

/**
 *
 * @author Peter C
 */
public abstract class AbstractDrink implements Drink {
    
    private final String name;
    private final Containers container;
    private final double alcoholicUnits;
    private boolean finished = false;
    private int amountRemaining;

    public AbstractDrink(String name, Containers container, double alcoholicUnits) {
        this.name = name;
        this.container = container;
        this.alcoholicUnits = alcoholicUnits;
        this.amountRemaining = container.getContainerAmount();
    }

    public String getName() {
        return name;
    }

    public Containers getContainer() {
        return container;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    
    public void removeAmount(int ml) throws NoDrinkLeft {
        if (this.amountRemaining < ml){
            this.finished = true;
            throw new NoDrinkLeft("This one's finished.");
        }
        this.amountRemaining -= ml;
    }

    public double getAlcoholicUnits() {
        return alcoholicUnits;
    }

    public int getAmountRemaining() {
        return amountRemaining;
    }
}

package code.up.bar.orders;

import code.up.bar.measures.Measure;

/**
 *
 * @author Peter C
 */
public class OrderItem {
    
    private final String drinkName;
    private final Measure measure;
    private final int number;

    public OrderItem(String drinkName, Measure measure, int number) {
        this.drinkName = drinkName;
        this.measure = measure;
        this.number = number;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public Measure getMeasure() {
        return measure;
    }

    public int getNumber() {
        return number;
    }
}

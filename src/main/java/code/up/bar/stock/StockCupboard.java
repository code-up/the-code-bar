package code.up.bar.stock;

import code.up.bar.drinks.Drink;
import code.up.bar.drinks.beers.BrooklynLager;
import code.up.bar.drinks.beers.Guinness;
import code.up.bar.drinks.spirits.DarkRum;
import code.up.bar.drinks.spirits.Tequila;
import code.up.bar.drinks.spirits.Vodka;
import code.up.bar.drinks.spirits.WhiteRum;
import code.up.bar.drinks.wines.CoteDeRhone;
import code.up.bar.drinks.wines.HouseRed;
import code.up.bar.problems.DontStockIt;
import code.up.bar.problems.NoDrinkLeft;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Peter C
 */
public class StockCupboard {
    
    private static final Logger log = LoggerFactory.getLogger(StockCupboard.class);
    
    private final Multimap<String, Drink> stocks = LinkedListMultimap.create();
    
    public void stockIt(){
        log.info("There is a bartender behind the bar, stocking the cupboard.");
        Drink brooklynLager = new BrooklynLager();
        putDrinkBack(brooklynLager);
        
        Drink tequila = new Tequila();
        putDrinkBack(tequila);
        
        putDrinkBack(new Guinness());
        putDrinkBack(new HouseRed());
        putDrinkBack(new CoteDeRhone());
        putDrinkBack(new DarkRum());
        putDrinkBack(new WhiteRum());
        putDrinkBack(new Vodka());
    }
    
    public void putDrinkBack(Drink drink){
        stocks.put(drink.getName().toLowerCase(), drink);
    }
    
    public Drink getDrink(String name) throws NoDrinkLeft, DontStockIt {
        if (!stocks.containsKey(name.trim())){
            throw new DontStockIt("Sorry mate, we don't serve \"" + name + "\" here.");
        }
        
        Collection<Drink> stock = stocks.get(name);
        if (!stock.isEmpty() && stock.iterator().hasNext()){
            Drink drink = stock.iterator().next();
            stock.remove(drink);
            return drink;
        } else {
            throw new NoDrinkLeft("Sorry mate, we're out of that.");
        }
    }
}

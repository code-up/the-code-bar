package code.up.bar;

import code.up.bar.orders.DefaultOrderParser;
import code.up.bar.orders.Order;
import code.up.bar.orders.OrderParser;
import code.up.bar.problems.DontStockIt;
import code.up.bar.problems.NoDrinkLeft;
import code.up.bar.stock.StockCupboard;
import code.up.bar.tender.AggressiveScumbagBartender;
import code.up.bar.tender.AnnoyinglyEnthusiasticBartender;
import code.up.bar.tender.Bartender;
import code.up.bar.tender.SlimyBartender;
import code.up.bar.tender.SurlyBartender;
import java.util.Random;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
    
    private static final Logger log = LoggerFactory.getLogger(App.class);
    
    private static final OrderParser orderParser = new DefaultOrderParser();
    private static final Scanner readInput = new Scanner(System.in);
    
    public static void main( String[] args ) throws Exception {
        log.info("You walk into the Bar.");
        
        StockCupboard stockCupboard = new StockCupboard();
        stockCupboard.stockIt();
        
        Bartender barkeep = getBartender(stockCupboard);
        barkeep.greeting();
        
        log.info("[Type ? for help]");
        
        while (true){
            order(barkeep);
        }
    }
    
    public static void order(Bartender barkeep) throws Exception {
        String input = readInput.nextLine();
        
        if ("?".equalsIgnoreCase(input)){
            help();
            return;
        } else if ("exit".equalsIgnoreCase(input)){
            barkeep.seeYa();
            readInput.close();
            System.exit(0);
        }
        
        Order order = orderParser.parse(new Order(10), input);
        
        try {
            barkeep.serve(order);
        } catch (NoDrinkLeft ex) {
            barkeep.runOut();
            order(barkeep);
        } catch (DontStockIt ex){
            barkeep.noneLeft();
            order(barkeep);
        }
        
        barkeep.handDrink();
    }
    
    public static void help(){
        log.info("Help! I'm in a Bar!");
        log.info("-------------------");
        log.info("");
        log.info("When asked for your order, type your order in the following format:");
        log.info("[Quantity] x [Measure] of [Drink Name]");
        log.info("Where quantity is a number (whole numbers only please), and measure is either Pint, Half-Pint, Glass, Bottle, or Shot.");
        log.info("As for Drink Name... try something, see if they have it. They probably don't.");
    }
    
    public static Bartender getBartender(StockCupboard stockCupboard){
        Random random = new Random();
        Bartender[] bartenders = {new SurlyBartender(stockCupboard), new SlimyBartender(stockCupboard), new AnnoyinglyEnthusiasticBartender(stockCupboard), new AggressiveScumbagBartender(stockCupboard) };
        int num = random.nextInt(bartenders.length);
        return bartenders[num];
    }
}

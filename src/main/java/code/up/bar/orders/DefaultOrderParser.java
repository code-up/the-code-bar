package code.up.bar.orders;

import code.up.bar.measures.Measure;
import code.up.bar.problems.StopMumbling;
import code.up.bar.problems.WrongMeasure;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Peter C
 */
public class DefaultOrderParser implements OrderParser {
    
    private final Pattern orderItemPattern = Pattern.compile("(\\d+)\\sx\\s([\\w-]+)\\sof\\s(.*$)");
    
    @Override
    public Order parse(Order order, String data) throws StopMumbling, WrongMeasure {
        String[] rawItems = data.split(",");
        for (String item : rawItems){
            OrderItem orderItem = parseItem(item);
            order.addOrderItem(orderItem);
        }
        return order;
    }
    
    private OrderItem parseItem(String rawItem) throws StopMumbling, WrongMeasure {
        Matcher matcher = orderItemPattern.matcher(rawItem.toLowerCase());
        if (matcher.find()){
            String quantity = matcher.group(1);
            String container = matcher.group(2);
            String drinkName = matcher.group(3);
            return new OrderItem(drinkName, Measure.parse(container), Integer.parseInt(quantity));
        }
        
        throw new StopMumbling("Say that again? It's loud in here, speak up!");
    }
}

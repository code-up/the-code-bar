package code.up.bar.orders;

import code.up.bar.measures.Measure;
import code.up.bar.problems.StopMumbling;
import code.up.bar.problems.WrongMeasure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;

/**
 *
 * @author Peter C
 */
public class DefaultOrderParserTest {
    
    private DefaultOrderParser instance;
    
    public DefaultOrderParserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new DefaultOrderParser();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test() throws StopMumbling, WrongMeasure {
        Order order = instance.parse(new Order(10), "4 x Pint of Brooklyn Lager");
        OrderItem item = order.getOrders().get(0);
        assertEquals("brooklyn lager", item.getDrinkName());
        assertEquals(4, item.getNumber());
        assertEquals(Measure.PINT, item.getMeasure());   
    }

}
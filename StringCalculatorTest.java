import org.junit.*;
public class StringCalculatorTest {
    @Test
    public void testAdd() {
        StringCalculator calculator = new StringCalculator();

        // Test cases Task 1
        Assert.assertEquals(15, calculator.add("1,2,3,4,5"));
        Assert.assertEquals(60, calculator.add("10,20,30"));
        Assert.assertEquals(0, calculator.add(""));
        Assert.assertEquals(1, calculator.add("1"));
        Assert.assertEquals(6, calculator.add("1,5"));
    }
}

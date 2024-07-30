import org.junit.*;
public class StringCalculatorTest {
    @Test
    public void testAdd() {
        StringCalculator calculator = new StringCalculator();
        
        //Test Cases for string of comma-separated numbers,and any numbers
        Assert.assertEquals(15, calculator.add("1,2,3,4,5"));
        Assert.assertEquals(60, calculator.add("10,20,30"));
        Assert.assertEquals(0, calculator.add(""));
        Assert.assertEquals(1, calculator.add("1"));
        Assert.assertEquals(6, calculator.add("1,5"));

        //Test cases for Handle new line Betweeen Numbers
        Assert.assertEquals(6, calculator.add("1\n2,3")); 
        Assert.assertEquals(10, calculator.add("1\n2\n3\n4")); 
        Assert.assertEquals(6, calculator.add("1,\n2,3")); 

        //Test cases for Handle delimiters
        Assert.assertEquals(3, calculator.add("//;\n1;2"));
        Assert.assertEquals(6, calculator.add("//|\n1|2|3"));
        Assert.assertEquals(9, calculator.add("//.\n2.3.4"));
        Assert.assertEquals(10, calculator.add("//-\n1-2-3-4"));


    }
    //Test for Negative Values
    @Test(expected = IllegalArgumentException.class)
    public void testAddWithNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        calculator.add("1,-2,3,-4,5");
    }


    @Test
    public void testAddWithNegativeNumbersMessage() {
        StringCalculator calculator = new StringCalculator();
        try {
            calculator.add("1,-2,3,-4,5");
            Assert.fail("Exception expected");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("negative numbers not allowed: [-2, -4]", e.getMessage());
        }
    }
}


public class StringCalculator{
    public static int add(String numbers) {
      
        if (numbers.isEmpty()) {
            return 0;
        }

        //convert string into string array using split
        String[] numberStrings = numbers.split(",");

     
        int sum = 0;
        //in for loop convert string into integer using and add into sum using wrapper class 
        for (String numberString : numberStrings) {
            sum += Integer.parseInt(numberString.trim());
        }

        return sum;
    }

}
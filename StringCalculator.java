import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator{
    public  int add(String numbers) {
      
        if (numbers.isEmpty()) {
            return 0;
        }

        //convert string into string array using split
        String delimiter = ",|\n"; // Default delimiters
        String numberString = numbers;

        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            if (delimiterEndIndex != -1) {
                delimiter = Pattern.quote(numbers.substring(2, delimiterEndIndex));
                numberString = numbers.substring(delimiterEndIndex + 1);
            }
        }

        // Split the string into an array of strings using the specified delimiters
        String[] numberStrings = numberString.split(delimiter);

        //initially number is zero
        int sum = 0;

         List<Integer> negativeNumbers = new ArrayList<>();
        //in for loop convert string into integer using and add into sum using wrapper class 
        for (String numberStr : numberStrings) {
            //it is used to check number is not empty.
            if (!numberStr.trim().isEmpty()) {
                int number = Integer.parseInt(numberStr.trim());
                if (number < 0) {
                    negativeNumbers.add(number);
                }

                sum += number;
            }
        }
        
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed: " + negativeNumbers);
        }

        return sum;
    }

    public static void main(String[] args) {
        
        StringCalculator calculator = new StringCalculator();
        try {
            System.out.println(calculator.add("1,2,3,4,5")); 
            System.out.println(calculator.add("10,20,30")); 
            System.out.println(calculator.add("")); 
            System.out.println(calculator.add("1")); 
            System.out.println(calculator.add("1,2"));
            System.out.println(calculator.add("1\n2,3"));
            System.out.println(calculator.add("1\n2\n3\n4")); 
            System.out.println(calculator.add("1,\n2,3")); 
            System.out.println(calculator.add("//;\n1;2"));
            System.out.println(calculator.add("//|\n1|2|3")); 
            System.out.println(calculator.add("//.\n2.3.4")); 
            System.out.println(calculator.add("//-\n1-2-3-4")); 

            //Exception Occurs
            System.out.println(calculator.add("1,-2,3,-4,5"));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage()); 
        }
    }

}
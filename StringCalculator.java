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
        //in for loop convert string into integer using and add into sum using wrapper class 
        for (String numberStr : numberStrings) {
            //it is used to check number is not empty.
            if (!numberStr.trim().isEmpty()) {
                sum += Integer.parseInt(numberStr.trim());
            }
        }

        return sum;
    }

}

public class StringCalculator{
    public  int add(String numbers) {
      
        if (numbers.isEmpty()) {
            return 0;
        }

        //convert string into string array using split
        String[] numberStrings = numbers.split(",|\n");

        //initially number is zero
        int sum = 0;
        //in for loop convert string into integer using and add into sum using wrapper class 
        for (String numberString : numberStrings) {
            //it is used to check number is not empty.
            if (!numberString.trim().isEmpty()) {
                sum += Integer.parseInt(numberString.trim());
            }
        }

        return sum;
    }

}
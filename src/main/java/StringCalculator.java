import java.util.ArrayList;

public class StringCalculator {

    ArrayList<String> negativeNumberList = new ArrayList<>();
    int sumOfNumbers = 0;

    int add(String numbers) {

        if (numbers.isBlank())
            return 0;
        else {
            if (numbers.length() > 1)
                if (numbers.substring(0, 2).equals("//"))
                    numbers = numbers.substring(4);
            String[] numbersArray = numbers.split("[;\n,]");

            for (var numberarray : numbersArray) {
                if ((Integer.parseInt(numberarray) > 0 && Integer.parseInt(numberarray) <= 1000))
                    sumOfNumbers += Integer.parseInt(numberarray);
                else if ((Integer.parseInt(numberarray) < 0))

                negativeNumberList.add(numberarray);
            }
            if (!negativeNumberList.isEmpty())
                throw new RuntimeException("negative numbers not allowed!:" + negativeNumberList);
            return sumOfNumbers;


        }

    }
}



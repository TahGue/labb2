

public class StringCalculator {


    int add(String numbers){

        if (numbers.isBlank())
                return 0;
       else{
                String [] numbersArray = null;
                int sumofnumber = 0;
            numbersArray = numbers.split(",");
            for (var numberarray:numbersArray) {
               sumofnumber += Integer.parseInt(numberarray);
            }
                return sumofnumber;


        }


    }
}

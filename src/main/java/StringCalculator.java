

public class StringCalculator {


    int add(String numbers){

        if (numbers.isBlank())
                return 0;
       else{
           if(numbers.length()>1)
           if (numbers.substring(0,2).equals("//"))
            numbers = numbers.substring(4);

           String [] numbersArray = numbers.split ("[\n,;]");
                int sumofnumber = 0;

            for (var numberarray:numbersArray) {
               sumofnumber += Integer.parseInt(numberarray);
            }
                return sumofnumber;


        }


    }
}



public class StringCalculator {


    int add(String numbers){

        if (numbers.isBlank())
                return 0;
       else{
                String [] array = null;
                int research = 0;
                array = numbers.split(",");
            for (var numberarray:array) {
               research += Integer.parseInt(numberarray);
            }
                return research;


        }


    }
}

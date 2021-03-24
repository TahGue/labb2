import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculatorTest {

    @Test
    @DisplayName("Return 0 empty string")
    void methodAddTest() {

        StringCalculator calculator = new StringCalculator();
        String numbers = "";
        int actual = 0;
        int expected = 0;

        actual = calculator.add(numbers);
        assertEquals(expected, actual);
    }
      @Test
        @DisplayName("Return one number from string")
        void testAddOnenumbers(){

            StringCalculator calculator = new StringCalculator();
            String numbers = "1";
            int actual = 0;
            int expected = 1;

            actual = calculator.add(numbers);
            assertEquals(expected, actual);
}
    @Test
    @DisplayName("Return tow number from string")
    void testAddTownumbers(){

        StringCalculator calculator = new StringCalculator();
        String numbers = "1,2";
        int actual = 0;
        int expected = 3;

        actual = calculator.add(numbers);
        assertEquals(expected, actual);

    }
    @Test
    @DisplayName("Return unknown number from string")
    void testAddUnknownnumbers(){

        StringCalculator calculator = new StringCalculator();
        String numbers = "1,2,3,4";
        int actual = 0;
        int expected = 10;

        actual = calculator.add(numbers);
        assertEquals(expected, actual);

    }
    @Test
    @DisplayName("Return  number from string with , and \n")
    void testAddnnumberswithdelimeters(){

        StringCalculator calculator = new StringCalculator();
        String numbers = "//;\n1;2";
        int actual = 0;
        int expected = 3;

        actual = calculator.add(numbers);
        assertEquals(expected, actual);

    }
    @Test
    @DisplayName("Negative numbers exeptions")
    void testNegtiaveExeption(){
        StringCalculator calculator = new StringCalculator();
    String numbers = "-8,-12,12";


    String actual = "-8,-12";

        String expted = "negatives not allowed:[-8,-12]";

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> calculator.add(numbers)).withMessage("negative numbers not allowed!:[-8, -12]");
    }
    @Test
    @DisplayName("ignore numbers bigger then 1000")
    void testNumbersAbove1000(){
        StringCalculator calculator = new StringCalculator();
        String numbers = "2,1001";
        int actual = 0;
        int expected = 2;
        actual = calculator.add(numbers);
        assertEquals(expected, actual);

    }



}
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        @DisplayName("Return tow number from string")
        void testAddOnenumbers(){

            StringCalculator calculator = new StringCalculator();
            String numbers = "1";
            int actual = 0;
            int expected = 1;

            actual = calculator.add(numbers);
            assertEquals(expected, actual);
}

}
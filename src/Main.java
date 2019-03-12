import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Create method performing an operation of addition of two numbers passed as String and returning result also as String
 * Method must work correctly with provided test data
 */
public class Main {
    public static void main(String[] args) {
    }

    static String addStringNumbers(String arg1, String arg2) {
        int difference = arg1.length() - arg2.length();
        if (difference > 0) { // arg1 is longer
            for (int i = arg2.length(); i < arg1.length(); i++) {
                arg2 = "0" + arg2;
            }
        } else if (difference < 0) { // arg2 is longer
            for (int i = arg1.length(); i < arg2.length(); i++) {
                arg1 = "0" + arg1;
            }
        }
        String str_sum = "";
        int overload = 0;
        for (int i = arg1.length() - 1; i >= 0; i--) {
            int intermediate = Integer.parseInt(arg1.substring(i, i + 1)) + Integer.parseInt(arg2.substring(i, i + 1)) + overload;
            if (intermediate >= 10)
                overload = intermediate / 10;
            else
                overload = 0;
            intermediate %= 10;
            str_sum = intermediate + str_sum;
        }
        return str_sum;
    }

    @Test
    void shouldReturnCorrectAdditionResult1() {
        // given
        // when
        String result1 = addStringNumbers("3", "14"); // = 17

        // then
        assertEquals("17", result1);
    }

    @Test
    void shouldReturnCorrectAdditionResult2() {
        // given
        // when
        String result2 = addStringNumbers("54", "333"); // = 387

        // then
        assertEquals("387", result2);
    }

    @Test
    void shouldReturnCorrectAdditionResult3() {
        // given
        // when
        String result3 = addStringNumbers("9", "254"); // = 263

        // then
        assertEquals("263", result3);
    }

    @Test
    void shouldReturnCorrectAdditionResult4() {
        // given
        // when
        String result4 = addStringNumbers("31234123153453123331244", "442134455124"); // = 31234123153895257786368

        // then
        assertEquals("31234123153895257786368", result4);
    }
}

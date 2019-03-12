import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Create method performing an operation of addition of two numbers passed as String and returning result also as String
 * Method must work correctly with provided test data
 */
class Main {

    static String addStringNumbers(String arg1, String arg2) {
        int difference = arg1.length() - arg2.length();
        if (difference > 0) // arg1 is longer
            arg2 = padStringWithZeroes(arg1, arg2);
        else if (difference < 0) // arg2 is longer
            arg1 = padStringWithZeroes(arg2, arg1);
        StringBuilder str_sum = new StringBuilder();
        int overload = 0;
        for (int i = arg1.length() - 1; i >= 0; i--) {
            int intermediate = Integer.parseInt(arg1.substring(i, i + 1)) + Integer.parseInt(arg2.substring(i, i + 1)) + overload;
            if (intermediate >= 10)
                overload = intermediate / 10;
            else
                overload = 0;
            intermediate %= 10;
            str_sum.insert(0, intermediate);
        }
        return str_sum.toString();
    }

    private static String padStringWithZeroes(String arg1, String arg2) {
        StringBuilder arg2Builder = new StringBuilder(arg2);
        for (int i = arg2Builder.length(); i < arg1.length(); i++) {
            arg2Builder.insert(0, "0");
        }
        arg2 = arg2Builder.toString();
        return arg2;
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

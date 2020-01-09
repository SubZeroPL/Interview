import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Create method performing an operation of addition of two numbers passed as String and returning result also as String
 * Method must work correctly with provided test data
 */
class Main {

    static String addStringNumbers(String arg1, String arg2) {
        BigInteger a1 = new BigInteger(arg1);
        BigInteger a2 = new BigInteger(arg2);
        BigInteger sum = a1.add(a2);
        return sum.toString();
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

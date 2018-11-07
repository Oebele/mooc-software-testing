package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarShiftCipherTest {
    @ParameterizedTest(name = "{0}: ({1}, {2}) = {3}")
    @CsvSource({
            "'Example 1', 'abc', 3, 'def'",
            "'Example 2', 'xyz', 3, 'abc'",
            "'Empty string', '', 3, ''",
            "'a shift 0 should give a', 'a', 0, 'a'",
            "'a shift 1 should give b', 'a', 1, 'b'",
            "'a shift -1 should give z', 'a', -1, 'z'",
            "'a shift 26 should give a', 'a', 26, 'a'",
            "'a shift 27 should give b', 'a', 27, 'b'",
            "'! shift 1 should give invalid ', '!', 0, 'invalid'",
            "'0 shift 1 should give invalid ', '0', 0, 'invalid'",
            "'attackatdawn shift 7 should give haahjrhakhdu ', 'attackatdawn', 7, 'haahjrhakhdu'",
    })
    public void testAlgorithm(String test_name, String message, int shift, String expectedResult) {
        String result = new CaesarShiftCipher().CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expectedResult, result);
    }
}

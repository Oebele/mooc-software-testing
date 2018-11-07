package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {
    @ParameterizedTest(name = "{0}: ({1}) = {2}")
    @CsvSource({
            "'string empty should be false', '', true",
            "'string a should be false', 'a', true",
            "'string g should be false', 'g', false",
            "'string gg should be true ', 'gg', true",
            "'string ga should be false', 'ga', false",
            "'string ag should be false', 'ag', false",
            "'string aa should be false ', 'aa', true",
            "'string gag should be false ', 'gag', false",
            "'string ggg should be true ', 'ggg', true",
            "'string aag should be false ', 'aag', false",
            "'string aga should be false ', 'aga', false",
            "'string gaa should be false ', 'gaa', false",
            "'string ggag should be false ', 'ggag', false",
            "'string ggggaag should be false ', 'ggggaag', false",
            "'string ggaggaaagga should be true ', 'ggaggaaagga', true",


            "'string example 1 ', 'xxggxx', true",
            "'string example 2 ', 'xxgxx', false",
            "'string example 3 ', 'xxggyygxx', false",
    })
    public void testAlgorithm(String test_name, String str, boolean expectedResult) {
        boolean result = new GHappy().gHappy(str);
        Assertions.assertEquals(expectedResult, result);
    }
}

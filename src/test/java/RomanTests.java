import dec2roman.NumberConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RomanTests {
    @Test
    public void tests1() {
        NumberConverter converter = new NumberConverter();
        Assertions.assertEquals("I", converter.decToRoman(1));
        Assertions.assertEquals("IV", converter.decToRoman(4));
        Assertions.assertEquals("XLIV", converter.decToRoman(44));
        Assertions.assertEquals("CDIX", converter.decToRoman(409));
        Assertions.assertEquals("CMXCIX", converter.decToRoman(999));
        Assertions.assertEquals(999, converter.romanToDec("CMXCIX"));
    }

    @Test
    public void testConvertionAndBack() {
        NumberConverter converter = new NumberConverter();
        Random generator = new Random();
        for (int i = 0; i < 10; i++) {
            int value = generator.nextInt(3999);
            Assertions.assertEquals(value, converter.romanToDec(converter.decToRoman(value)));
        }
    }
}

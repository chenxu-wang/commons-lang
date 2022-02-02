package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SWE261_P1_Test {
    /**
     * Part I:
     * In general, the test can be partitioned into two parts: the input is null or not null
     * When the input is not null, it has two dimensions: the type of input and length of input
     *      For type, it can be partitioned into space, number, letter (uppercase & lowercase), symbols and mix
     *      For length, it can be partitioned into three ranges; 0, 0-maxLength, maxLength
     *
     * IsAlpha() feature can be found as the following path: src/main/java/org/apache/commons/lang3/StringUtils.java
     *
     * testNullOrNot() is used to check the following two occasions
     * testIsAlpha() is used to test diverse input types
     * testLength() is used to test the different length of input
     *
     */
    @Test
    public void testNullOrNot(){
        // null
        assertFalse(StringUtils.isAlpha(null));
        // Not null
        assertTrue(StringUtils.isAlpha("abcABC"));
    }

    @Test
    public void testIsAlpha(){
        // only space
        assertFalse(StringUtils.isAlpha(""));
        assertFalse(StringUtils.isAlpha(" "));
        assertFalse(StringUtils.isAlpha("   "));

        // only numbers
        assertFalse(StringUtils.isAlpha("1"));
        assertFalse(StringUtils.isAlpha("325"));

        // only uppercase letters
        assertTrue(StringUtils.isAlpha("A"));
        assertTrue(StringUtils.isAlpha("CB"));

        // only lowercase letters
        assertTrue(StringUtils.isAlpha("a"));
        assertTrue(StringUtils.isAlpha("good"));

        // only symbols
        assertFalse(StringUtils.isAlpha("$"));
        assertFalse(StringUtils.isAlpha("!-,"));

        //mix together && start with letter
        assertFalse(StringUtils.isAlpha("a -1bbr"));
        assertFalse(StringUtils.isAlpha("H6@0b br"));

        // mix together && start with space
        assertFalse(StringUtils.isAlpha(" 1bbr"));
        assertFalse(StringUtils.isAlpha(" (Lbr!"));

        // mix together && start with symbols
        assertFalse(StringUtils.isAlpha("!1bbr "));
        assertFalse(StringUtils.isAlpha("+J4b.."));

        // mix together && start with number
        assertFalse(StringUtils.isAlpha("1bbr$"));
        assertFalse(StringUtils.isAlpha("0:brI$"));

        // Mix uppercase letters and lowercase letters
        assertTrue(StringUtils.isAlpha("GoodmorninG"));
        assertTrue(StringUtils.isAlpha("ExcitedGames"));
    }

    @Test
    public void testLength(){
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] c = s.toCharArray();
        Random random = new Random(); // to get a random letter from s

        // length = 0
        assertFalse(StringUtils.isAlpha(""));

        // length between 1 and 65535
        String str = "";
        for (int i = 0; i < 6666; i++){
            str +=  c[random.nextInt(c.length)];
        }
        assertTrue(StringUtils.isAlpha(str));


        // length is 65535
        String str2 = "";
        for (int i = 0; i < 65535; i++){
            str2 +=  c[random.nextInt(c.length)];
        }
        assertTrue(StringUtils.isAlpha(str2));
    }
}

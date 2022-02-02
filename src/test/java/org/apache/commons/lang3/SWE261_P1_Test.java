package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SWE261_P1_Test {
    @Test
    public void testNullOrNot(){
        // nUll
        assertFalse(StringUtils.isAlpha(null));
        // Not null
        assertTrue(StringUtils.isAlpha("abc"));
    }

    @Test
    public void testIsAlpha(){
        // only space
        assertFalse(StringUtils.isAlpha(" "));
        // only numbers
        assertFalse(StringUtils.isAlpha("1"));
        // only upper case letters
        assertTrue(StringUtils.isAlpha("A"));
        // only lower case letters
        assertTrue(StringUtils.isAlpha("a"));
        // only symbols
        assertFalse(StringUtils.isAlpha("$"));
        //mix together start with letter
        assertFalse(StringUtils.isAlpha("a -1bbr"));
        // mix together start with space
        assertFalse(StringUtils.isAlpha(" 1bbr"));
        // mix together start with symbols
        assertFalse(StringUtils.isAlpha("!1bbr "));
        // mix together start with number
        assertFalse(StringUtils.isAlpha("1bbr$"));
        // letters
        assertTrue(StringUtils.isAlpha("GoodmorninG"));
    }

    @Test
    public void testLength(){
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] c = s.toCharArray();
        Random random = new Random();
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

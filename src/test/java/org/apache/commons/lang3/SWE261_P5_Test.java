package org.apache.commons.lang3;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SWE261_P5_Test {
    StringUtils strutils;
    @Before
    public void setup() {
        //  Mocks are being created.
        strutils = (StringUtils) Mockito.mockStatic(StringUtils.class);

        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testIsAlpha() {

        try (MockedStatic<StringUtils> utilities = Mockito.mockStatic(StringUtils.class)) {
            utilities.when(() -> strutils.isAlpha(""))
                    .thenReturn(false);
            utilities.verify(()->StringUtils.isAlpha(""), times(0));
        }
     assertThat(StringUtils.isAlpha("")).isFalse();


    }
    @Test
    public void testArrayUtil() {
       int[] data = new int[]{1,2,3};
        try (MockedStatic<ArrayUtils> utilities = Mockito.mockStatic(ArrayUtils.class)) {
            utilities.when(() -> ArrayUtils.add(data,4))
                    .thenReturn(new int[]{1,2,3,4});
            utilities.verify(()->ArrayUtils.add(data,4), times(0));
        }
        assertThat(ArrayUtils.add(data,4)).containsExactly(1,2,3,4);
    }


    /**
     *      * Appends the suffix to the end of the string if the string does not
     *      * already end with any of the suffixes.
     *       str: The string.
     *       suffix: The suffix to append to the end of the string.
     *       suffixes: Additional suffixes that are valid terminators.
     */
    @Test
    public void testAppendIfMissing(){
// Do not take suffixes into consideration
        assertNull(StringUtils.appendIfMissingE2(null, null, false));
        assertEquals("abc", StringUtils.appendIfMissingE2("abc", null, false));
        assertEquals("xyz", StringUtils.appendIfMissingE2("", "xyz", false));
        assertEquals("abcxyz", StringUtils.appendIfMissingE2("abc", "xyz",false));
        assertEquals("abcxyz", StringUtils.appendIfMissingE2("abcxyz", "xyz",false));
        assertEquals("aXYZxyz", StringUtils.appendIfMissingE2("aXYZ", "xyz",false));
// Take suffixes into consideration
        assertNull(StringUtils.appendIfMissing(null, null, (CharSequence[]) null));
        assertEquals("abc", StringUtils.appendIfMissing("abc", null, (CharSequence[]) null));
        assertEquals("xyz", StringUtils.appendIfMissing("", "xyz", (CharSequence[]) null));
        assertEquals("abcxyz", StringUtils.appendIfMissing("abc", "xyz", null));
        assertEquals("abc", StringUtils.appendIfMissing("abc", "xyz", ""));
        assertEquals("abcxyz", StringUtils.appendIfMissing("abc", "xyz", "mno"));
        assertEquals("abcxyz", StringUtils.appendIfMissing("abcxyz", "xyz", "mno"));
        assertEquals("abcmno", StringUtils.appendIfMissing("abcmno", "xyz", "mno"));
        assertEquals("abcXYZxyz", StringUtils.appendIfMissing("abcXYZ", "xyz", "mno"));
        assertEquals("abcMNOxyz", StringUtils.appendIfMissing("abcMNO", "xyz", "mno"));
    }
}

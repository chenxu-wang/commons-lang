package org.apache.commons.lang3;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.assertj.core.api.Assertions.assertThat;
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
}

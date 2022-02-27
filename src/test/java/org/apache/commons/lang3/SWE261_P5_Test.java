package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SWE261_P5_Test {
    @Test
    public void testIsAlpha() {
        try (MockedStatic<StringUtils> utilities = Mockito.mockStatic(StringUtils.class)) {
            utilities.when(() -> StringUtils.isAlpha(""))
                    .thenReturn(false);
            assertThat(StringUtils.isAlpha("")).containsExactly(10, 11, 12);

        }

    }
}

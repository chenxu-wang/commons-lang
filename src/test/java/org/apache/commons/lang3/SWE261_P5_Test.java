package org.apache.commons.lang3;

import org.apache.commons.lang3.concurrent.*;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SWE261_P5_Test {
    /**
     * Test initializeUnchecked successfully
     * @throws ConcurrentException
     */
    @Test
    public void testConcurrent() throws ConcurrentException {
        final ConcurrentInitializer<Object> init = mock(ConcurrentInitializer.class);
        final Object result = new Object();
        when(init.get()).thenReturn(result);
        assertThat(ConcurrentUtils.initializeUnchecked(init)).isEqualTo(result);
        verify(init).get();
    }

    /**
     * Test initializeUnchecked handle with exception.
     * @throws ConcurrentException
     */
    @Test
    public void testConcurrentEx() throws ConcurrentException {
        final ConcurrentInitializer<Object> init = mock(ConcurrentInitializer.class);
        final Exception cause = new Exception();
        when(init.get()).thenThrow(new ConcurrentException(cause));
        final ConcurrentRuntimeException crex =
                assertThrows(ConcurrentRuntimeException.class, () -> ConcurrentUtils.initializeUnchecked(init));
        assertThat(cause).isEqualTo(crex.getCause());
        verify(init).get();
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

package org.apache.commons.lang3;

import org.apache.commons.lang3.concurrent.*;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SWE261_P5_Test {
    @Test
    public void testConcurrent() throws ConcurrentException {
        final ConcurrentInitializer<Object> init = mock(ConcurrentInitializer.class);
        final Object result = new Object();
        when(init.get()).thenReturn(result);
        assertThat(ConcurrentUtils.initialize(init)).isEqualTo(result);
        verify(init).get();
    }
    @Test
    public void testConcurrentEx() throws ConcurrentException {
        final
        ConcurrentInitializer<Object> init = mock(ConcurrentInitializer.class);
        final Exception cause = new Exception();
        when(init.get()).thenThrow(new ConcurrentException(cause));
        final ConcurrentRuntimeException crex =
                assertThrows(ConcurrentRuntimeException.class, () -> ConcurrentUtils.initializeUnchecked(init));
        assertThat(cause).isEqualTo(crex.getCause());
        verify(init).get();
    }

}

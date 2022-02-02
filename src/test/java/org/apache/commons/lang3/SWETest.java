package org.apache.commons.lang3;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SWETest {
    @Test
    public void testAddPosition(){
        final int[] array = {1, 2, 3};
        //add directly
        assertArrayEquals(new int[] {1,2,3,0}, ArrayUtils.add(array,0));
        //add at first
        assertArrayEquals(new int[] {0,1,2,3}, ArrayUtils.add(array,0,0));
        //add at last
        assertArrayEquals(new int[] {1,2,3,0}, ArrayUtils.add(array,3,0));
        //add in mid
        assertArrayEquals(new int[] {1,0,2,3}, ArrayUtils.add(array,1,0));
        //add out of bounds
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.add( array, -1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.add( array, 4, 0));
    }


}

package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SWE261_P2_Test {

    // ArrayUtils.toString() method can convert an array to a String.
    @Test
    public void testArrayToString() {
        String[] a = {"aaa", "bbb"};
        assertEquals("{aaa,bbb}", ArrayUtils.toString(a));
    }

    // ArrayUtils.toArray() method can convert some Strings to an array.
    @Test
    public void testToArray() {
        String[] a = {"aaa", "bbb"};
        String[] b = ArrayUtils.toArray("aaa", "bbb");
        assertEquals(ArrayUtils.toString(a), ArrayUtils.toString(b));
    }

    // ArrayUtils.add() method can add an object to the array at the last position.
    @Test
    public void testArrayUtilAdd() {
        String[] a = ArrayUtils.toArray("aaa", "bbb");
        String[] c = ArrayUtils.add(a, "ccc");
        assertEquals("{aaa,bbb,ccc}", ArrayUtils.toString(c));
    }

    // ArrayUtils.remove() method can remove an object from an array.
    @Test
    public void testArrayUtilRemove() {
        String[] a = ArrayUtils.toArray("aaa", "bbb");
        String[] c = ArrayUtils.add(a, "ccc");
        String[] d = ArrayUtils.remove(c, c.length - 1);
        assertEquals("{aaa,bbb}", ArrayUtils.toString(d));
    }

    // ArrayUtils.reverse() method can reverse an array.
    @Test
    public void testArrayUtilReverse() {
        String[] a = ArrayUtils.toArray("aaa", "bbb", "ccc");
        ArrayUtils.reverse(a);
        assertEquals("{ccc,bbb,aaa}", ArrayUtils.toString(a));
        ArrayUtils.reverse(a);
        assertEquals("{aaa,bbb,ccc}", ArrayUtils.toString(a));
    }

    // ArrayUtils.swap() method can swap two object’s positions in an array.
    @Test
    public void testArrayUtilSwap() {
        String[] a = ArrayUtils.toArray("aaa", "bbb", "ccc");
        ArrayUtils.swap(a, 0, 2);
        assertEquals("{ccc,bbb,aaa}", ArrayUtils.toString(a));
        ArrayUtils.swap(a, 2, 0);
        assertEquals("{aaa,bbb,ccc}", ArrayUtils.toString(a));
    }


}

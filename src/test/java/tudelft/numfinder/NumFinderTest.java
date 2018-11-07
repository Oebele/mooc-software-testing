package tudelft.numfinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.SingleTestExecutor;

import static org.junit.jupiter.api.Assertions.*;

class NumFinderTest {
    private NumFinder nf;

    @BeforeEach
    void setUp() {
        nf = new NumFinder();
    }


    @Test
    void find_null() {
        assertThrows(NullPointerException.class, () -> nf.find(null));
    }

    @Test
    void find_empty_array() {
        nf.find(new int[]{});
        assertEquals(nf.getLargest(), Integer.MIN_VALUE);
        assertEquals(nf.getSmallest(), Integer.MAX_VALUE);
    }

    @Test
    void find_array_size_1() {
        nf.find(new int[]{2});
        assertEquals(nf.getLargest(), 2);
        assertEquals(nf.getSmallest(), 2);
    }

    @Test
    void find_array_size_2_equal() {
        nf.find(new int[]{2, 2});
        assertEquals(nf.getLargest(), 2);
        assertEquals(nf.getSmallest(), 2);
    }

    @Test
    void find_array_size_2_descending() {
        nf.find(new int[]{2, 1});
        assertEquals(nf.getLargest(), 2);
        assertEquals(nf.getSmallest(), 1);
    }

    @Test
    void find_array_size_2_ascending() {
        nf.find(new int[]{1, 2});
        assertEquals(nf.getLargest(), 2);
        assertEquals(nf.getSmallest(), 1);
    }
    @Test
    void find_array_size_4_equal() {
        nf.find(new int[]{2, 2, 2, 2});
        assertEquals(nf.getLargest(), 2);
        assertEquals(nf.getSmallest(), 2);
    }

    @Test
    void find_array_size_4_descending() {
        nf.find(new int[]{4, 3, 2, 1});
        assertEquals(nf.getLargest(), 4);
        assertEquals(nf.getSmallest(), 1);
    }

    @Test
    void find_array_size_4_ascending() {
        nf.find(new int[]{1, 2, 3, 4});
        assertEquals(nf.getLargest(), 4);
        assertEquals(nf.getSmallest(), 1);
    }

    @Test
    void find_array_size_3_one_border_value_MIN() {
        nf.find(new int[]{1, -2,  Integer.MIN_VALUE});
        assertEquals(nf.getLargest(), 1);
        assertEquals(nf.getSmallest(), Integer.MIN_VALUE);
    }

    @Test
    void find_array_size_3_one_border_value_MAX() {
        nf.find(new int[]{1, -2,  Integer.MAX_VALUE});
        assertEquals(nf.getLargest(), Integer.MAX_VALUE);
        assertEquals(nf.getSmallest(),-2);
    }

    @Test
    void find_array_size_3_one_border_value() {
        nf.find(new int[]{Integer.MAX_VALUE, -2,  Integer.MIN_VALUE});
        assertEquals(nf.getLargest(), Integer.MAX_VALUE);
        assertEquals(nf.getSmallest(), Integer.MIN_VALUE);
    }

    @Test
    void find_example_array() {
        nf.find(new int[] {4, 25, 7, 9});
        assertEquals(nf.getLargest(), 25);
        assertEquals(nf.getSmallest(), 4);
    }
}
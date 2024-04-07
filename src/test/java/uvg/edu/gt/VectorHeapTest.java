package uvg.edu.gt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class VectorHeapTest {

    private VectorHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new VectorHeap<>();
    }

    @Test
    public void testAdd() {
        assertTrue(heap.isEmpty());
        assertTrue(heap.add(5));
        assertFalse(heap.isEmpty());
        assertEquals(1, heap.size());
    }

    @Test
    public void testRemove() {
        assertTrue(heap.add(5));
        assertTrue(heap.add(10));
        assertTrue(heap.add(3));
        assertTrue(heap.add(7));

        assertEquals(Integer.valueOf(3), heap.remove());
        assertEquals(Integer.valueOf(5), heap.remove());
        assertEquals(Integer.valueOf(7), heap.remove());
        assertEquals(Integer.valueOf(10), heap.remove());
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(heap.isEmpty());
        heap.add(5);
        assertFalse(heap.isEmpty());
        heap.remove();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, heap.size());
        heap.add(5);
        assertEquals(1, heap.size());
        heap.add(10);
        assertEquals(2, heap.size());
        heap.remove();
        assertEquals(1, heap.size());
    }

    @Test
    public void testClear() {
        heap.add(5);
        heap.add(10);
        heap.add(3);
        heap.add(7);

        assertFalse(heap.isEmpty());
        assertEquals(4, heap.size());
        heap.clear();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        assertNull(heap.getFirst());
    }

    @Test
    public void testGetFirst() {
        assertNull(heap.getFirst());
        heap.add(5);
        assertEquals(Integer.valueOf(5), heap.getFirst());
        heap.add(3);
        assertEquals(Integer.valueOf(3), heap.getFirst());
        heap.remove();
        assertEquals(Integer.valueOf(5), heap.getFirst());
    }
}

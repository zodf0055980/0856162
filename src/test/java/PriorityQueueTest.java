import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.PriorityQueue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class PriorityQueueTest {

    private int[] a1;
    private int[] a2;

    public PriorityQueueTest(int[] i1, int[] i2) {
        this.a1 = i1;
        this.a2 = i2;
    }

    @Parameters
    public static Iterable<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
                {new int[] {6, 1, 2}, new int[] {1, 2, 6}},
                {new int[] {5, 5, 5, 6, 6}, new int[] {5, 5, 5, 6, 6}},
                {new int[] {0xdeadbeef, 0xbeefdead, 1},
                        new int[] {0xbeefdead, 0xdeadbeef, 1}},
                {new int[] {0, 1, 1}, new int[] {0, 1, 1}},
                {new int[] {0, -1, 1}, new int[] {-1, 0, 1}},
                {new int[] {0, 0, 0}, new int[] {1, 1, 1}},
        });
    }

    @Test(expected = NullPointerException.class)
    public void ex1() {
        PriorityQueue<Integer> prq = new PriorityQueue<Integer>();
        prq.offer(null);
    }
    @Test(expected = NullPointerException.class)
    public void ex2() {
        PriorityQueue<Integer> prq = new PriorityQueue<Integer>();
        prq.add(null);
    }
    @Test(expected = ArrayStoreException.class)
    public void ex3() {
        PriorityQueue<Integer> prq = new PriorityQueue<Integer>();
        prq.add(1);
        prq.offer(1);
        String[] arr = new String[5];
        String[] arr1 = prq.toArray(arr);
    }
    @Test
    public void testPrint() {
        PriorityQueue<Integer> prq = new PriorityQueue<Integer>();
        for (int i = 0; i < a1.length; i++) {
            prq.add(a1[i]);
        }
        for (int i = 0; i < a1.length; i++) {
            Integer head = prq.poll();
            System.out.println(head);
            assertEquals(head, a2[i]);
        }
        System.out.println("=========n");
    }
}
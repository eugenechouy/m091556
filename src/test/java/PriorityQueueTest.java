import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueTest {

    public static Stream<Arguments> getParameters() {
        return Stream.of(
                arguments(new int[]{1, 4, 3, 2}, new int[]{4, 3, 2, 1}),
                arguments(new int[]{3, 2, 1, 0}, new int[]{3, 2, 1, 0}),
                arguments(new int[]{0, -4, 9, -2}, new int[]{-4, -2, 0, 9}),
                arguments(new int[]{-2, -3, -4, -5}, new int[]{-5, -4, -3, -2}),
                arguments(new int[]{-1, -4, -3, -4}, new int[]{-4, -4, -3, -1})
        );
    }

    @ParameterizedTest
    @MethodSource("getParameters")
    public void parameterizedTest(int[] input, int [] expected) {
        PriorityQueue pq = new PriorityQueue();
        for( int i : input )
            pq.offer(i);
        for( int e : expected )
            assertEquals(e, pq.poll());
    }

    @Test
    public void offerExpcetionClassCast(){
        assertThrows(ClassCastException.class, () -> {
            PriorityQueue pq = new PriorityQueue();
            pq.offer("first");
            pq.offer(1);
        });
    }

    @Test
    public void offerExceptionNullPointer() {
        assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().offer(null);
        });
    }

    @Test
    public void constructorExceptionIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
           new PriorityQueue(-1);
        });
    }

}

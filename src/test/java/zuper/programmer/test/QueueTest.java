package zuper.programmer.test;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class QueueTest {
    private Queue<String> queue;

    @Nested
    @DisplayName("When New")
    public class WhenNew {
        @BeforeEach
        void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("when offer, size must be 1")
        void offerNewData() {
            queue.offer("Mohammad");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("when offer, size must be 2")
        void offerMoreData() {
            queue.offer("Mohammad");
            queue.offer("Sirajul");
            Assertions.assertEquals(2, queue.size());
        }
    }
}

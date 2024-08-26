package zuper.programmer.test;

import org.junit.jupiter.api.Test;

public class LifecycleTest {
    private String temp;
    @Test
    void testA() {
        temp = "Umam";
    }

    @Test
    void testB() {
        System.out.println(temp);
    }
}

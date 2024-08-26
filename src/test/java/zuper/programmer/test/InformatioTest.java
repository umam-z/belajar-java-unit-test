package zuper.programmer.test;

import org.junit.jupiter.api.*;

@DisplayName("information test")
public class InformatioTest {
    @Test
    @Tags({
            @Tag("one"),
            @Tag("two")
    })
    @DisplayName("this is test one")
    void test1(TestInfo info) {
        System.out.println(info.getDisplayName());
        System.out.println(info.getTags());
        System.out.println(info.getTestClass().orElse(null));
        System.out.println(info.getTestMethod().orElse(null));
    }
}

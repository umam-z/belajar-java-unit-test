package zuper.programmer.test;

import org.junit.jupiter.api.*;
import zuper.programmer.test.generator.SimpleDisplayNameGenerator;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayName("test untuk calculator class")
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
//@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before Each");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After Each");
    }

    @Test
//    @DisplayName("test skanario suksess untuk method add(Integer, Integer)")
    public void testAddSuccess() {
        var result = calculator.add(10, 10);
        assertEquals(20, result);
//        if (result != 20) {
//            throw new RuntimeException("Test gagal");
//        }
    }

    @Test
    public void testDevideSuccess() {
        var result = calculator.devide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDevideFiled() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.devide(10, 0);
        });
    }

    @Test
    @Disabled
    public void testComingSoon() {

    }
}

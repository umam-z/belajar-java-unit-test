package zuper.programmer.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import zuper.programmer.test.resolver.RandomParameterResolver;

import java.util.Random;

//@Extensions({
//        @ExtendWith(RandomParameterResolver.class)
//})
public class RandomCalculatorTest extends AbstractCalculatorTest{
//    private Calculator calculator = new Calculator();

    @Test
    void testRandom(TestInfo info, Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test random calculator")
    @RepeatedTest(
            value = 5,
            name = "{displayName} ke  {currentRepetition} dari {totalRepetitions}"
    )
    void testRandomRepeat(TestInfo info, Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test random calculator")
    @RepeatedTest(
            value = 5,
            name = "{displayName}"
    )
    void testRandomRepeatInfo(TestInfo info, Random random, RepetitionInfo repetitionInfo) {

        System.out.println(info.getDisplayName() + " ke " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions());
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }
}

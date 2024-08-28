package zuper.programmer.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import zuper.programmer.test.resolver.RandomParameterResolver;

import java.util.List;
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

    @DisplayName("Test Calculator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void testWithParameter(int value) {
        var expected = value + value;
        var actual = calculator.add(value, value);

        Assertions.assertEquals(expected, actual);
    }

    public static List<Integer> parameterSource() {
        return List.of(1,2,3,4,5,6,7,8,9);
    }

    @DisplayName("Test Calculator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @MethodSource({"parameterSource"})
    void testWithMethodSource(Integer value) {
        var expected = value + value;
        var actual = calculator.add(value, value);

        Assertions.assertEquals(expected, actual);
    }


}

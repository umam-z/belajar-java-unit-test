package zuper.programmer.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;


@Tag("integration-test")
public class ConditionTest {

    @Test
    public void testSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyOnWindows() {

    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisableRunOnlyOnWindows() {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_8})
    public void testEnableOnJava8() {

    }

    @Test
    @DisabledOnJre({JRE.JAVA_8})
    public void testDisableOnJava8() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_16, max = JRE.JAVA_20)
    public void testEnableOnJava16To20() {

    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_16, max = JRE.JAVA_20)
    public void testDisableOnJava16To20() {

    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testEnableOnJavaVendorOracle() {

    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testDisableOnJavaVendorOracle() {

    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testEnabledOnProfileDev() {

    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testDisabledOnProfileDev() {

    }

}

package tqs;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

public class bookStoreTest {

    @Suite
    @IncludeEngines("cucumber")
    @SelectPackages("tqs")
    @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "tqs")
    public class CucumberTest {

    }

}

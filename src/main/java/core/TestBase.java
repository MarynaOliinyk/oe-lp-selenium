package core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.BeforeClass;

public class TestBase {

    @BeforeClass
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
    }

}


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.BaseTest;
import pageObjectStatic.RubberDucks;

public class SPOTest extends BaseTest {
    @Test
    public void checkRedLabelTest() {
        Assert.assertTrue(RubberDucks.checkRedDuckLabel(driver));
    }

    @Test
    public void checkYellowLabelTest() {
        Assert.assertTrue(RubberDucks.checkYellowDuckLabel(driver));
    }

    @Test
    public void checkGreenLabelTest() {
        Assert.assertTrue(RubberDucks.checkGreenDuckLabel(driver));
    }
}

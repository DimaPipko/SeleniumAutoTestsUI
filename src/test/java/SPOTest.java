
import org.testng.Assert;
import org.testng.annotations.Test;
import PO.pageObject.BaseTest;
import PO.pageObject.pageObjectStatic.RubberDucks;

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

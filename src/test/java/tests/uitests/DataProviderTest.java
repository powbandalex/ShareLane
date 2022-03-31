package tests.uitests;

import lombok.extern.log4j.Log4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Log4j
public class DataProviderTest {

    @DataProvider(name = "testData")
    public Object[][] inputForTask() {
        return new Object[][]{
                {3, "Alex"},
                {5, "Khadasevich"},
                {15, "Alex Khadasevich"},
                {6, "Alex"},
                {10, "Khadasevich"},
                {30, "Alex Khadasevich"},
                {1, "Error"},
                {-1, "Error"},
        };
    }

    @Test(dataProvider = "testData")
    public void test123(double number, String expectedString) {
        log.info(number + " " + expectedString);
    }

}

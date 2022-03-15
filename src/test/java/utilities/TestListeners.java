package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestListeners implements ITestListener{

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test ".concat(iTestResult.getName()).concat(" started"));

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseTest) currentClass).getDriver();
        AllureService allureService = new AllureService();
        allureService.takeScreenshot(webDriver);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}

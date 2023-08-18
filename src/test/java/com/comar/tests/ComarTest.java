package com.comar.tests;

// import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
// import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
// import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.comar.pages.ActualitesPage;
import com.comar.pages.HomePage;

public class ComarTest {
    private WebDriver driver;
    private HomePage homePage;
    private ActualitesPage actualitesPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C://Users/Lenovo/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.comar.tn/");
        homePage = new HomePage(driver);

    }

    @Test
    public void testActualitesPage() {
        actualitesPage = homePage.clickActualitesLink();
        Assert.assertTrue(actualitesPage.isPageOpened(), "Actualités page not opened.");

    }

    @Test
    public void testSearch() {
        actualitesPage = homePage.clickActualitesLink();
        actualitesPage.enterSearchText("COMAR Assurances partenaire");
        actualitesPage.submitSearch();
        Assert.assertTrue(actualitesPage.isSearchResultVisible(), "Search result not visible.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

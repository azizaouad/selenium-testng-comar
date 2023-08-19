package com.comar.tests;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.comar.pages.ActualitesPage;
import com.comar.pages.HomePage;

public class ComarTest {
    private WebDriver driver;
    private HomePage homePage;
    private ActualitesPage actualitesPage;

    @Before
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
        Assert.assertTrue( "Actualités page not opened.",actualitesPage.isPageOpened());

    }

    @Test
    public void testSearch() {
        actualitesPage = homePage.clickActualitesLink();
        actualitesPage.enterSearchText("COMAR Assurances partenaire");
        actualitesPage.submitSearch();
        Assert.assertTrue( "Search result not visible.",actualitesPage.isSearchResultVisible());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

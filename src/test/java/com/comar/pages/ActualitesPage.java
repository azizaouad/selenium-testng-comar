package com.comar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActualitesPage {
    private WebDriver driver;
    private By pageTitle = By.xpath("/html/body/div[4]/div/section/div/div[1]/h1");
    private By searchInput = By.id("edit-searchmeta");
    private By searchButton = By.id("edit-submit-actualites");
    private By searchResult = By.linkText("COMAR Assurances partenaire du Semi-Marathon Ulysse Djerba");

    public ActualitesPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageOpened() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public void enterSearchText(String searchText) {
        driver.findElement(searchInput).sendKeys(searchText);
    }

    public void submitSearch() {
        driver.findElement(searchButton).click();
    }

    public boolean isSearchResultVisible() {
        return driver.findElement(searchResult).isDisplayed();
    }
}

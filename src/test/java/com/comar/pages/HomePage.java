package com.comar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By actualitesLink = By.linkText("Actualités");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


	public ActualitesPage clickActualitesLink() {
        driver.findElement(actualitesLink).click();
        return new ActualitesPage(driver);
    }


}


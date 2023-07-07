package br.com.lojasrenner.pages.e_commerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPlacedPage {

    private WebDriver driver;

    public OrderPlacedPage(WebDriver driver) {
        this.driver = driver;
    }

 public String captureDisplayedMessage() {
        return driver.findElement(By.xpath("//h2[@class='title text-center'][contains(.,'Order Placed!')]")).getText();
    }
}

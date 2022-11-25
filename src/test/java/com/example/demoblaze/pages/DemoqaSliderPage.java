package com.example.demoblaze.pages;

import com.example.demoblaze.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://demoqa.com/slider
public class DemoqaSliderPage {
    @FindBy(xpath = "//input[contains(@class, 'range')]")
    public WebElement rangeSlider;

    @FindBy(id = "sliderValue")
    public WebElement sliderValue;
    


    public DemoqaSliderPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    
    
    
}
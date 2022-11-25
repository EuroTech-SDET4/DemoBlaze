package com.example.demoblaze.stepDefs;

import com.example.demoblaze.pages.DemoqaSliderPage;
import com.example.demoblaze.utilities.ConfigurationReader;
import com.example.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class SliderStepDefs {

    DemoqaSliderPage slider = new DemoqaSliderPage();

    @Given("The user is on the slider page")
    public void the_user_is_on_the_slider_page() {
        Driver.get().get(ConfigurationReader.get("urlSlider"));
    }
    @When("The user able to move the slider")
    public void the_user_able_to_move_the_slider() {

        for (int i = 0; i <55 ; i++) {
            slider.rangeSlider.sendKeys(Keys.ARROW_RIGHT);
        }
        for (int i = 0; i <60 ; i++) {
            slider.rangeSlider.sendKeys(Keys.ARROW_LEFT);
        }

    }
    @Then("The user able see slider has moved to {string}")
    public void theUserAbleSeeSliderHasMovedTo(String expectedSliderValue) {
        Assert.assertEquals(expectedSliderValue,slider.sliderValue.getAttribute("Value"));
    }
}

package com.example.demoblaze.stepDefs;

import com.example.demoblaze.pages.DemoBlazePage;
import com.example.demoblaze.utilities.BrowserUtils;
import com.example.demoblaze.utilities.ConfigurationReader;
import com.example.demoblaze.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.*;

public class DemoBlazeStepDefs {

    DemoBlazePage blaze = new DemoBlazePage();


    @Given("The user is on the home page")
    public void the_user_is_on_the_home_page() {

        Driver.get().get(ConfigurationReader.get("urlDemoBlaze"));
    }
    @When("The user add {string} from {string}")
    public void the_user_add_from(String product, String category) {

        blaze.addProduct(category,product);

    }

    @And("The user navigates the cart")
    public void theUserNavigatesTheCart() {
        blaze.cart.click();
    }

    @And("The user removes {string} product")
    public void theUserRemovesProduct(String productName) {

        blaze.removeProduct(productName);

    }

    @Then("The user verify that cart list size is {int}")
    public void theUserVerifyThatCartListSizeIs(int expectedSize) {
        BrowserUtils.waitFor(2);
        assertEquals(expectedSize,blaze.cartList.size());
    }

    @And("The user clicks place order")
    public void theUserClicksPlaceOrder() {
        blaze.placeOrder.click();
    }

    @And("The user fill the form and clicks purchase button")
    public void theUserFillTheFormAndClicksPurchaseButton() {
        blaze.fillTheForm();
    }


    @Then("The user verify that order is successful and able to see {string} message")
    public void theUserVerifyThatOrderIsSuccessfulAndAbleToSeeMessage(String expectedText) {
        assertEquals(expectedText,blaze.confirmationMessage.getText());

    }
}

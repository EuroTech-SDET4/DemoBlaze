package com.example.demoblaze.pages;

import com.example.demoblaze.utilities.BrowserUtils;
import com.example.demoblaze.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://www.demoblaze.com/
public class DemoBlazePage {
    @FindBy(xpath = "//a[text() = 'Phones']")
    public WebElement phones;

    @FindBy(xpath = "//a[text()='Laptops']")
    public WebElement laptops;

    @FindBy(xpath = "//*[text() = 'Sony vaio i5']")
    public WebElement sonyVaioILink;

    @FindBy(xpath = "//*[text() = 'Add to cart']")
    public WebElement addCart;



    @FindBy(xpath = "//a[text()='Home ']")
    public WebElement homeBtn;

    @FindBy(id = "cartur")
    public WebElement cart;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> cartList;

    @FindBy(xpath = "//*[text() = 'Place Order']")
    public WebElement placeOrder;

    @FindBy(xpath = "//*[@id='name']")
    public WebElement nameFormControl;

    @FindBy(xpath = "//*[@id='country']")
    public WebElement countryFormControl;

    @FindBy(xpath = "//*[@id='city']")
    public WebElement cityFormControl;

    @FindBy(xpath = "//*[@id='card']")
    public WebElement cardFormControl;

    @FindBy(xpath = "//*[@id='month']")
    public WebElement monthFormControl;

    @FindBy(xpath = "//*[@id='year']")
    public WebElement yearFormControl;

    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    public WebElement purchasePrimaryButton;


    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    public WebElement confirmationMessage;
    
    
    public DemoBlazePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void addProduct(String category,String product){
        Driver.get().findElement(By.xpath("//a[text() = '"+category+"']")).click();
        Driver.get().findElement(By.xpath("//*[text() = '"+product+"']")).click();
        addCart.click();

        BrowserUtils.waitFor(2);
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();

        homeBtn.click();
        BrowserUtils.waitFor(1);
        

    }
    public void removeProduct(String productName){
        Driver.get().findElement(By.xpath("//*[text()='"+productName+"']/../td[4]/a")).click();


    }
    public void fillTheForm(){
        BrowserUtils.waitFor(1);
        Faker faker = new Faker();
        nameFormControl.sendKeys(faker.name().fullName());
        countryFormControl.sendKeys(faker.country().name());
        cityFormControl.sendKeys(faker.country().capital());
        cardFormControl.sendKeys(faker.business().creditCardNumber());
        monthFormControl.sendKeys("November");
        yearFormControl.sendKeys("2022");
        purchasePrimaryButton.click();
    }
    

}
package com.yourcompany.Pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class GuineaPigPage {

    @FindBy(linkText = "i am a link")
    private WebElement theActiveLink;

    @FindBy(id = "your_comments")
    private WebElement yourCommentsSpan;

    @FindBy(id = "comments")
    private WebElement commentsTextAreaInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public WebDriver driver;
    public static String url = "https://www.flipkart.com/";

    public static GuineaPigPage visitPage(WebDriver driver) {
        GuineaPigPage page = new GuineaPigPage(driver);
        page.visitPage();
        //page.AlertDemo();
        // page.WebTable();
        //page.Innertext();
        //page.SwitchtoFrames();
        //page.SwitchTOPopup();
        //page. RadioButton();
        //page.UploadFile();
        //page.form();


        return page;
    }

    public GuineaPigPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public void followLink() {

        this.theActiveLink.click();
    }

    public void submitComment(String text) {
        this.commentsTextAreaInput.sendKeys(text);
        this.submitButton.click();

        // Race condition for time to populate yourCommentsSpan
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        wait.until(ExpectedConditions.textToBePresentInElement(yourCommentsSpan, text));
    }

    public String getSubmittedCommentText() {
        return this.yourCommentsSpan.getText();
    }

    public boolean isOnPage() {
        String title = "I am a page title - Flipkart";
        return this.driver.getTitle() == title;
    }

    public void AlertDemo() {

        WebDriver driver = this.driver;


        // Alert Message handling

        driver.get("http://demo.guru99.com/test/delete_customer.php");


        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).submit();

        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        // Capturing alert message.
        String alertMessage = driver.switchTo().alert().getText();

        // Displaying alert message
        System.out.println(alertMessage);
        // Thread.sleep(5000);

        // Accepting alert
        alert.accept();

    }

    public void PopupAlert() {
        //Launching the site.
        driver.get("http://demo.guru99.com/popup.php");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

        String MainWindow = driver.getWindowHandle();

        // To handle all new opened window.
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                driver.findElement(By.name("emailid"))
                        .sendKeys("gaurav.3n@gmail.com");

                driver.findElement(By.name("btnLogin")).click();

                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
    }

    public void WebTable() {
        String baseUrl = "http://demo.guru99.com/test/write-xpath-table.html";
        WebDriver driver = this.driver;

        driver.get(baseUrl);
        String innerText = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
        System.out.println(innerText);
        driver.quit();

    }


    public void Innertext() {
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        WebDriver driver = this.driver;

        driver.get(baseUrl);
        String innerText = driver.findElement(By
                .xpath("//table/tbody/tr/td[2]"
                        + "//table/tbody/tr[4]/td/"
                        + "table/tbody/tr/td[2]/"
                        + "table/tbody/tr[2]/td[1]/"
                        + "table[2]/tbody/tr[3]/td[2]/font"))
                .getText();
        System.out.println(innerText);
        driver.quit();

    }

    public void SwitchtoFrames() {

        WebDriver driver = this.driver;
        driver.get("http://demo.guru99.com/selenium/deprecated.html");
        driver.switchTo().frame("classFrame");
        driver.findElement(By.linkText("Deprecated")).click();
        driver.close();
    }

    public void SwitchTOPopup() {
        WebDriver driver = this.driver;
        String alertMessage = "hcl popup is shown";

        driver.get("http://jsbin.com/usidix/1");
        driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
        alertMessage = driver.switchTo().alert().getText();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().alert().accept();
        System.out.println(alertMessage);
        driver.quit();
    }

    public void RadioButton() {

        WebDriver driver = this.driver;
        driver.get("http://demo.guru99.com/test/ajax.html");

        List<WebElement> elements = driver.findElements(By.name("name"));
        System.out.println("Number of elements:" + elements.size());

        for (int i = 0; i < elements.size(); i++) {
            System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));

        }
    }

    public void UploadFile() {
        String baseUrl = "http://demo.guru99.com/test/upload/";
        WebDriver driver = this.driver;

        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("C:\\newhtml.html");

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();

    }
    public void form(){
        WebDriver driver = this.driver;

        String baseUrl = "http://demo.guru99.com/test/login.html";
        driver.get(baseUrl);

        // Get the WebElement corresponding to the Email Address(TextField)
        WebElement email = driver.findElement(By.id("email"));

        // Get the WebElement corresponding to the Password Field
        WebElement password = driver.findElement(By.name("passwd"));

        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        System.out.println("Text Field Set");

        // Deleting values in the text box
        email.clear();
        password.clear();
        System.out.println("Text Field Cleared");

        // Find the submit button
        WebElement login = driver.findElement(By.id("SubmitLogin"));

        // Using click method to submit form
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        login.click();
        System.out.println("Login Done with Click");

        //using submit method to submit the form. Submit used on password field
        driver.get(baseUrl);
        driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");
        driver.findElement(By.id("SubmitLogin")).submit();
        System.out.println("Login Done with Submit");

        //driver.close();

    }



}

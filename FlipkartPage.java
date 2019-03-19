package com.yourcompany.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static javafx.scene.input.KeyCode.W;

public class FlipkartPage {


    @FindBy(id = "//*[@id=\"container\"]/div/div[2]/div/ul/li[6]/span")
    private WebElement furniture;

    @FindBy(id = "your_comments")
    private WebElement yourCommentsSpan;

    @FindBy(id = "comments")
    private WebElement commentsTextAreaInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public WebDriver driver;
    //Actions act = new Actions(driver);
    public static String url = "https://www.flipkart.com/";

    public static FlipkartPage visitPage(WebDriver driver) throws Exception {
        FlipkartPage page = new FlipkartPage(driver);
         page.visitPage();
        page.popup_close();
        page.MouseClick1();
        page.MouseClick2();
        page.show_more();
        page.chairs();
        page.rating();

        return page;
    }

    public FlipkartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public boolean isOnPage() {
        String title = "I am a page title - Flipkart";
        return this.driver.getTitle() == title;
    }

    public void MouseClick1() {
        String baseUrl = "https://www.flipkart.com/";

        WebDriver driver = this.driver;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(baseUrl);

        WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/ul/li[6]/span"));

        Actions action = new Actions(driver);

        action.moveToElement(element).build().perform();


        //driver.findElement(By.linkText("Home_&_Furniture")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void popup_close() {
        String baseUrl = "https://www.flipkart.com/";

        WebDriver driver = this.driver;

        driver.get(baseUrl);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
    }


    public void MouseClick2() {
        String baseUrl = "https://www.flipkart.com/furniture-year-end-bonanza-store?otracker=nmenu_sub_Home%20%26%20Furniture_0_Furniture";

        WebDriver driver = this.driver;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(baseUrl);

        WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/ul/li[6]/ul/li/ul/li[2]/ul/li[1]/a"));

    }

    public void show_more() {
        String baseUrl = "https://www.flipkart.com/furniture-year-end-bonanza-store?otracker=nmenu_sub_Home%20%26%20Furniture_0_Furniture";

        WebDriver driver = this.driver;

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(baseUrl);
        WebElement show_more = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[3]/div/div/div[1]/div/div/section/div[2]/div[2]/div/span"));
        show_more.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        public void chairs(){
            String baseUrl = "https://www.flipkart.com/furniture/chairs/pr?sid=wwe,y7b&p[]=facets.serviceability%5B%5D%3Dtrue&otracker=categorytree";

            WebDriver driver = this.driver;

            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get(baseUrl);
            WebElement chairs = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div/div/section/div[3]/div[1]/a"));
            chairs.click();


    }

    public void rating(){
        String baseUrl = "https://www.flipkart.com/furniture/chairs/pr?sid=wwe%2Cy7b&p%5B%5D=facets.serviceability%5B%5D%3Dtrue&otracker=categorytree&p%5B%5D=facets.rating%255B%255D%3D4%25E2%2598%2585%2B%2526%2Babove";

        WebDriver driver = this.driver;

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(baseUrl);
        WebElement chairs = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div/section[5]/div[2]/div/div[2]/div/div/label/div[1]"));
        chairs.click();

        //System.out.println("the No.of.Chairs under 4 star rating are:"+ driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div[2]/div[1]/div/div/span")));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}




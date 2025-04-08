import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class VerifyDirectoryMenuItem {
    public static void main(String[] args) {
        // Step 1: Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Update with the correct path to your ChromeDriver

        // Step 2: Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Step 3: Open the OrangeHRM login page
            driver.get("http://alchemy.hguy.co/orangehrm");

            // Step 4: Log in with the credentials
            WebElement usernameField = driver.findElement(By.id("txtUsername"));
            WebElement passwordField = driver.findElement(By.id("txtPassword"));
            usernameField.sendKeys("orange");
            passwordField.sendKeys("orangepassword123");
            WebElement loginButton = driver.findElement(By.id("btnLogin"));
            loginButton.click();

            // Step 5: Wait for the page to load completely (optional, use an explicit wait for better stability)
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Wait up to 5 seconds for the page to load

            // Step 6: Locate the "Directory" menu item
            WebElement directoryMenu = driver.findElement(By.id("menu_directory_viewDirectory"));

            // Step 7: Verify that the "Directory" menu item is visible and clickable
            WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds
            wait.until(ExpectedConditions.visibilityOf(directoryMenu)); // Wait

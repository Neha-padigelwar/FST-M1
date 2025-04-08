import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginTest {
    public static void main(String[] args) {
        // Step 1: Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Update with the path to your ChromeDriver

        // Step 2: Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Step 3: Open the OrangeHRM login page
            driver.get("http://alchemy.hguy.co/orangehrm");

            // Step 4: Find the username and password fields
            WebElement usernameField = driver.findElement(By.id("txtUsername"));
            WebElement passwordField = driver.findElement(By.id("txtPassword"));

            // Step 5: Enter login credentials into the respective fields
            usernameField.sendKeys("orange");  // Enter username
            passwordField.sendKeys("orangepassword123");  // Enter password

            // Step 6: Click the login button
            WebElement loginButton = driver.findElement(By.id("btnLogin"));
            loginButton.click();

            // Step 7: Verify that the homepage has opened
            // Check if the "Welcome" text or any unique element of the homepage is visible
            WebElement welcomeText = driver.findElement(By.id("welcome"));
            if (welcomeText.isDisplayed()) {
                System.out.println("Login successful and homepage is displayed.");
            } else {
                System.out.println("Login failed or homepage is not displayed.");
            }
        } finally {
            // Step 8: Close the browser after the test
            driver.quit();
        }
    }
}

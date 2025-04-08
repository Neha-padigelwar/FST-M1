import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RetrieveEmergencyContacts {
    public static void main(String[] args) {
        // Step 1: Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Update with the actual path to your ChromeDriver

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

            // Step 5: Wait for the page to load completely
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Wait up to 5 seconds for the page to load

            // Step 6: Navigate to "My Info" page
            WebElement myInfoMenu = driver.findElement(By.id("menu_pim_viewMyDetails"));
            myInfoMenu.click();

            // Step 7: Wait for the page to load and locate the "Emergency Contacts" option in the left-hand menu
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement emergencyContactsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_emergencyContacts")));
            emergencyContactsMenu.click();

            // Step 8: Wait for the emergency contacts table to load
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("emergencyContact_list")));

            // Step 9: Retrieve all the rows in the emergency contacts table
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='emergencyContact_list']//tbody/tr"));

            // Step 10: Loop through the rows and print the emergency contact details
            for (WebElement row : rows) {
                List<WebElement> columns = row.findElements(By.tagName("td"));
                if (columns.size() > 0) {
                    String name = columns.get(0).getText();
                    String relationship = columns.get(1).getText();
                    String homePhone = columns.get(2).getText();
                    String mobilePhone = columns.get(3).getText();

                    System.out.println("Name: " + name);
                    System.out.println("Relationship: " + relationship);
                    System.out.println("Home Phone: " + homePhone);
                    System.out.println("Mobile Phone: " + mobilePhone);
                    System.out.println("-------------------------------");
                }
            }

        } finally {
            // Step 11: Close the browser after the test is completed
            driver.quit();
        }
    }
}

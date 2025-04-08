import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Update with your ChromeDriver path

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Navigate to the website
            driver.get("http://alchemy.hguy.co/orangehrm");

            // Step 2: Get the title of the webpage
            String pageTitle = driver.getTitle();

            // Step 3: Verify if the title matches "OrangeHRM"
            if (pageTitle.equals("OrangeHRM")) {
                System.out.println("Test Passed: Title is correct.");
            } else {
                System.out.println("Test Failed: Title is incorrect. Actual title is: " + pageTitle);
            }
        } finally {
            // Step 4: Close the browser after the test
            driver.quit();
        }
    }
}

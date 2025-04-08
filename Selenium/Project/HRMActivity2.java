import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetHeaderImageURL {
    public static void main(String[] args) {
        // Step 1: Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Update with the correct path to your ChromeDriver

        // Step 2: Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Step 3: Navigate to the website
            driver.get("http://alchemy.hguy.co/orangehrm");

            // Step 4: Find the header image using XPath (based on the class name)
            WebElement headerImage = driver.findElement(By.xpath("//img[@class='oxd-brand-banner']")); // Update the XPath if necessary

            // Step 5: Get the URL of the header image (from the 'src' attribute)
            String imageUrl = headerImage.getAttribute("src");

            // Step 6: Print the URL of the header image to the console
            System.out.println("URL of the header image: " + imageUrl);
        } finally {
            // Step 7: Close the browser after the test
            driver.quit();
        }
    }
}

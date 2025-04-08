import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class ApplyForLeave {
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

            // Step 5: Wait for the Dashboard page to load completely
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Wait up to 5 seconds for the page to load

            // Step 6: Navigate to the Dashboard and click "Apply Leave"
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement applyLeaveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_leave_applyLeave")));
            applyLeaveButton.click();

            // Step 7: Select Leave Type and Duration of the Leave
            WebElement leaveTypeDropdown = driver.findElement(By.id("applyleave_txtLeaveType"));
            leaveTypeDropdown.click();
            WebElement leaveTypeOption = driver.findElement(By.xpath("//option[contains(text(),'Vacation')]")); // Select "Vacation" type leave
            leaveTypeOption.click();

            WebElement fromDateField = driver.findElement(By.id("applyleave_txtFromDate"));
            WebElement toDateField = driver.findElement(By.id("applyleave_txtToDate"));
            fromDateField.clear();
            fromDateField.sendKeys("2025-04-10"); // Select the from date
            toDateField.clear();
            toDateField.sendKeys("2025-04-15"); // Select the to date

            // Step 8: Click Apply
            WebElement applyButton = driver.findElement(By.id("applyBtn"));
            applyButton.click();

            // Step 9: Navigate to "My Leave" page to check the status of the leave application
            WebElement myLeaveMenu = driver.findElement(By.id("menu_leave_viewMyLeaveList"));
            myLeaveMenu.click();

            // Step 10: Optionally, you can verify if the leave has been successfully applied by checking if the leave appears in the list
            WebElement leaveList = driver.findElement(By.id("resultTable"));
            if (leaveList.isDisplayed()) {
                System.out.println("Leave application submitted successfully.");
            } else {
                System.out.println("Failed to submit leave application.");
            }

        } finally {
            // Step 11: Close the browser after the test is completed
            driver.quit();
        }
    }
}

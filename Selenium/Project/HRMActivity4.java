import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddNewEmployee {
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

            // Step 5: Wait for the page to load (optional, use an explicit wait for better stability)
            Thread.sleep(2000); // Wait 2 seconds for the page to load fully, consider using WebDriverWait for better performance

            // Step 6: Navigate to the "PIM" section
            WebElement pimMenu = driver.findElement(By.id("menu_pim_viewPimModule"));
            pimMenu.click();

            // Step 7: Click the "Add" button to add a new employee
            WebElement addButton = driver.findElement(By.id("btnAdd"));
            addButton.click();

            // Step 8: Fill in the required fields for the new employee
            WebElement firstNameField = driver.findElement(By.id("firstName"));
            WebElement lastNameField = driver.findElement(By.id("lastName"));
            WebElement employeeIdField = driver.findElement(By.id("employeeId"));
            firstNameField.sendKeys("John");
            lastNameField.sendKeys("Doe");

            // Optionally, you can get the employee ID or set it manually
            String employeeId = employeeIdField.getAttribute("value");
            System.out.println("Employee ID generated: " + employeeId); // Output the generated ID to console

            // Step 9: Click the "Save" button
            WebElement saveButton = driver.findElement(By.id("btnSave"));
            saveButton.click();

            // Step 10: Navigate back to the "Employee List" tab to verify the creation of the employee
            WebElement employeeListTab = driver.findElement(By.id("menu_pim_viewEmployeeList"));
            employeeListTab.click();

            // Step 11: Verify the employee is added by searching for the new employee (by their name)
            WebElement searchField = driver.findElement(By.id("empsearch_employee_name_empName"));
            searchField.sendKeys("John Doe");

            WebElement searchButton = driver.findElement(By.id("searchBtn"));
            searchButton.click();

            // Step 12: Verify the employee is listed in the search results
            WebElement employeeRow = driver.findElement(By.xpath("//table[@id='resultTable']//td[contains(text(), 'John Doe')]"));
            if (employeeRow.isDisplayed()) {
                System.out.println("Employee " + employeeId + " has been successfully added.");
            } else {
                System.out.println("Failed to add the employee.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Step 13: Close the browser after the test
            driver.quit();
        }
    }
}

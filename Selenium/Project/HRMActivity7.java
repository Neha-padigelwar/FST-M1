import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class AddEmployeeQualifications {
    public static void main(String[] args) {
        // Step 1: Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Update with your actual path to ChromeDriver

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
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Wait up to 5 seconds

            // Step 6: Navigate to "My Info"
            WebElement myInfoMenu = driver.findElement(By.id("menu_pim_viewMyDetails"));
            myInfoMenu.click();

            // Step 7: Wait for the page to load and locate the "Qualifications" option in the left menu
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement qualificationsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_qualification")));
            qualificationsMenu.click();

            // Step 8: Add Work Experience
            // Click on "Add Work Experience" button
            WebElement addWorkExperienceButton = driver.findElement(By.id("btnAddWorkExperience"));
            addWorkExperienceButton.click();

            // Step 9: Fill in the Work Experience details
            WebElement companyNameField = driver.findElement(By.id("experience_employer"));
            WebElement jobTitleField = driver.findElement(By.id("experience_jobtitle"));
            WebElement fromDateField = driver.findElement(By.id("experience_from_date"));
            WebElement toDateField = driver.findElement(By.id("experience_to_date"));
            WebElement jobDescriptionField = driver.findElement(By.id("experience_description"));

            // Fill in the Work Experience details
            companyNameField.sendKeys("ABC Corporation");
            jobTitleField.sendKeys("Software Engineer");
            fromDateField.sendKeys("2015-01-01");
            toDateField.sendKeys("2020-01-01");
            jobDescriptionField.sendKeys("Responsible for developing software applications and working on various projects.");

            // Step 10: Click Save to save the Work Experience
            WebElement saveButton = driver.findElement(By.id("btnSaveWorkExperience"));
            saveButton.click();

            // Step 11: Optionally, verify if the work experience has been added (for example, check if the work experience appears in the list)
            WebElement workExperienceList = driver.find

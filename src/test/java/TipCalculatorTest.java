import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TipCalculatorTest {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://qatipcalc.ccbp.tech/");

        WebElement billAmountEl=driver.findElement(By.cssSelector("input[id^='billAmount']"));
        billAmountEl.sendKeys("1000");

        WebElement percentageEl=driver.findElement(By.cssSelector("input[id^='percentageTip']"));
        percentageEl.sendKeys("12");

        WebElement btnEl=driver.findElement(By.cssSelector("button[id*='calculateButton']"));
        btnEl.click();

        WebElement tipEl=driver.findElement(By.cssSelector("p[id^='tipAmount']"));

        WebElement totalAmountEl=driver.findElement(By.cssSelector("p[id^='totalAmount']"));

        if(tipEl.getText().equals("120.00")&&totalAmountEl.getText().equals("1120.00")){
            System.out.println("Tip Calculated Correctly");
        }
        else{
            System.out.println("Tip Calculated Incorrectly");
        }

        percentageEl.clear();

        btnEl.click();

        WebElement errorMsg= driver.findElement(By.cssSelector("p[id^='errorMessage']"));

        if(errorMsg.getText().equals("Please Enter a Valid Input.")){
            System.out.println("Error message displayed for no input.");
        }
        else{
            System.out.println("Error message missing for no input");
        }

        percentageEl.sendKeys("10f");
        btnEl.click();

        WebElement errorMsgEl= driver.findElement(By.cssSelector("p[id$='Message']"));
        
        if(errorMsgEl.getText().equals("Please Enter a Valid Input.")){
            System.out.println("Error message displayed for invalid input.");
        }
        else{
            System.out.println("Error message missing for invalid input");
        }

        driver.quit();
    }
}

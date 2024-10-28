import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TicketTest {
    
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver(); 
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void buyTicket() {
        driver.get("https://blazedemo.com");
        driver.manage().window().maximize();

        // combo origem
        driver.findElement(By.name("fromPort")); // clica no combo
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'São Paolo']")).click();
        }

        // combo Destino
        {
            WebElement dropdown = driver.findElement(By.name("toPort"))
            dropdown.click(); // clica no combo
            dropdown.findElement(By.xpath("//option[. = 'Cairo']")).click();
        }

        driver.findElement(By.cssSelector("input.btn.btn-primary"));

        assertEquals("Flights from São Paolo to Cairo:", 
            driver.findElement(By.cssSelector("//h3")).getText());
    }
}
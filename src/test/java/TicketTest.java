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
        driver.get("https://blazedemo.com");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void buyTicket() {
        // combo origem
        driver.findElement(By.name("fromPort")); // clica no combo
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'São Paolo']")).click();
        }

        // combo Destino
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.click(); // clica no combo
            dropdown.findElement(By.xpath("//option[. = 'Cairo']")).click();
        }

        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        assertEquals("Flights from São Paolo to Cairo:", 
            driver.findElement(By.cssSelector("h3")).getText());

        // clica no botão do voo desejado
        driver.findElement(By.cssSelector("tr:nth-child(1) .btn")).click();

        assertEquals("Your flight from TLV to SFO has been reserved.", 
            driver.findElement(By.cssSelector("h2")).getText());
    }
}
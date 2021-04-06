package ua.deti.pedros50.SelJupTest;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Test;

@ExtendWith(SeleniumJupiter.class)
public class AppTest 
{
    ChromeDriver driver;

    @Test
    void testWithOneChrome() {
        driver.get("https://www.ua.pt");
        assertThat(driver.getTitle().contains())
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.remote.DesiredCapabilities;

@Execution(ExecutionMode.CONCURRENT)
public class Fixture {

    @BeforeAll
    public static void setUp(){
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browserSize = "1920x1080";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability( "enableVideo",true);
        Configuration.browserCapabilities = capabilities;
        Selenide.open("http://automationpractice.com/index.php");
    }


    @AfterEach
    public void clear(){
        Selenide.clearBrowserCookies();
    }
}

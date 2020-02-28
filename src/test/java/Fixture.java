
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Fixture {

    @BeforeAll
    public static void setUp(){
        Configuration.remote = "http://localhost:4040/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability( "enableVideo",true);
        Configuration.browserCapabilities = capabilities;
        Selenide.open("http://automationpractice.com/index.php");
    }
}

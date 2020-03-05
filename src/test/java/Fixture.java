
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Fixture {

    @Execution(ExecutionMode.CONCURRENT)
    @BeforeAll
    public static void setUp(){
//        Configuration.baseUrl= "http://automationpractice.com/index.php";
//        Configuration.headless = true;
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browserSize = "1920x1080";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability( "enableVideo",true);
        Configuration.browserCapabilities = capabilities;
        Selenide.open("http://automationpractice.com/index.php");
    }


    @AfterAll
    public static void clear(){
        Selenide.clearBrowserCookies();
    }
}

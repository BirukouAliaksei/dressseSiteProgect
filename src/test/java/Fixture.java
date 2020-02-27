
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class Fixture {

    @BeforeAll
    public static void setUp(){
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Selenide.open("http://automationpractice.com/index.php");
    }
}

package filaC.webUi.session;

import filaC.webUi.factoryBrowser.FactoryBrowser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Session {
    private static Session session;
    private WebDriver browser;
    private Session(){
        browser = FactoryBrowser.make("chrome").create();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }
    public static Session getInstance(){
        if (session == null)
            session = new Session();
        return session;
    }

    public WebDriver getBrowser() {
        return browser;
    }
    public Alert getAlert(){return browser.switchTo().alert();}

    public void closeSession(){
        browser.quit();
        session = null;
    }
}

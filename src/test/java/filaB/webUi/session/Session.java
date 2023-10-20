package filaB.webUi.session;

import filaB.webUi.factoryBrowser.FactoryBrowser;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Session {
    private static Session session;
    private final WebDriver browser;
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

    public void closeSession(){
        browser.quit();
        session = null;
    }
}

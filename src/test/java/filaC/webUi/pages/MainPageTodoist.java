package filaC.webUi.pages;

import filaC.webUi.controls.Button;
import org.openqa.selenium.By;

public class MainPageTodoist {
    public Button loginButton = new Button(By.xpath("//li/a[@href='/auth/login']"));
}

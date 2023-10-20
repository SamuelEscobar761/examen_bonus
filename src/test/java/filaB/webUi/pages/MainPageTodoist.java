package filaB.webUi.pages;

import filaB.webUi.controls.Button;
import org.openqa.selenium.By;

public class MainPageTodoist {
    public Button signUpButton = new Button(By.xpath("//li/a[@href=\"/auth/signup\"]"));

}

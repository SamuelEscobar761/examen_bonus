package filaB.webUi.pages;

import filaB.webUi.controls.Button;
import org.openqa.selenium.By;
public class MenuSectionTodoist {
    public Button hamburguerButton = new Button(By.xpath("//button[@data-gtm-id=\"burger-menu-toggle\"]"));
    public Button projectsButton = new Button(By.xpath("//div[text()=\"Projects\"]"));
    public Button addProjectButton = new Button(By.xpath("//button[@aria-label=\"Add project\"]"));
}

package filaC.webUi.pages;

import filaC.webUi.controls.Button;
import filaC.webUi.controls.TextBox;
import org.openqa.selenium.By;

public class MenuSection {
    public Button settingsButton = new Button(By.xpath("//a[@href='javascript:OpenSettingsDialog();']"));
}

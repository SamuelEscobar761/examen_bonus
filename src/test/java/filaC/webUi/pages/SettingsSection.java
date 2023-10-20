package filaC.webUi.pages;

import filaC.webUi.controls.Button;
import org.openqa.selenium.By;

public class SettingsSection {
    public Button accountButton = new Button(By.xpath("//a[text()=\"Account\"]"));
    public Button deleteButton = new Button(By.id("DeleteAccountBtn"));
}

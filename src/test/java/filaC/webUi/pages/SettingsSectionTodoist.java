package filaC.webUi.pages;

import filaC.webUi.controls.Button;
import filaC.webUi.controls.TextBox;
import org.openqa.selenium.By;

public class SettingsSectionTodoist {
    public Button submitButton = new Button(By.xpath("//button[@type='submit']"));
    public Button closeSettingsSectionButton = new Button(By.xpath("//button[@class='dOAUdcnSj9gBY1w5ax6aQxa5xcA8ASxf']"));
    public TextBox nameTextBox = new TextBox(By.xpath("//span[text()=\"Name\"]/../../..//div//input"));

    public TextBox getName(String name){
        System.out.println("//input[value=\"" + name + "\"]");
        return new TextBox(By.xpath("//input[@value=\"" + name + "\"]"));
    }
}

package filaB.webUi.pages;

import filaB.webUi.controls.Button;
import filaB.webUi.controls.TextBox;
import org.openqa.selenium.By;

public class AddProjectPageTodoist {
    public TextBox nameTextbox = new TextBox(By.xpath("//label[text()=\"Name\"]/..//input"));
    public Button addButton = new Button(By.xpath("//span[text()=\"Add\"]/.."));
}

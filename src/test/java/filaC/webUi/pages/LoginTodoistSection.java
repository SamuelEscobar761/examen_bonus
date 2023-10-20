package filaC.webUi.pages;

import filaC.webUi.controls.Button;
import filaC.webUi.controls.TextBox;
import org.openqa.selenium.By;

public class LoginTodoistSection {
    public TextBox emailTextBox = new TextBox(By.xpath("//input[@type='email']"));
    public TextBox pwdTextBox = new TextBox(By.xpath("//input[@type='password']"));
    public Button startEmailLoginButton = new Button(By.xpath("//button[@data-gtm-id='start-email-login']"));
}

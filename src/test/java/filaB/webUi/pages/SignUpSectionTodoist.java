package filaB.webUi.pages;

import filaB.webUi.controls.Button;
import filaB.webUi.controls.TextBox;
import org.openqa.selenium.By;

public class SignUpSectionTodoist {
    public TextBox emailTextbox = new TextBox(By.xpath("//input[@placeholder=\"Enter your email...\"]"));
    public TextBox passwordTextbox = new TextBox(By.xpath("//input[@type=\"password\"]"));
    public Button registerButton = new Button(By.xpath("//button[@data-gtm-id=\"start-email-signup\"]"));
    public TextBox nameTextBox = new TextBox(By.xpath("//span[text()=\"Your name\"]/../../..//input"));
    public Button continueButton = new Button(By.xpath("//span[text()=\"Continue\"]/.."));
    public Button educationCheckbox = new Button(By.xpath("//button[@data-gtm-id=\"education\"]"));
    public Button openTodoistButton = new Button(By.xpath("//span[text()=\"Launch Todoist\"]/.."));
}

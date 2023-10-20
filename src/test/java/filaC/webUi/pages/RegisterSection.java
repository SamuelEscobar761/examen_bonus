package filaC.webUi.pages;

import filaC.webUi.controls.Button;
import filaC.webUi.controls.TextBox;
import org.openqa.selenium.By;

public class RegisterSection {
    public TextBox fullNameTextBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"));
    public TextBox emailTextBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail"));
    public TextBox passwordTextBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword"));
    public Button termsButton = new Button(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms"));
    public Button signupButton = new Button(By.id("ctl00_MainContent_SignupControl1_ButtonSignup"));

}

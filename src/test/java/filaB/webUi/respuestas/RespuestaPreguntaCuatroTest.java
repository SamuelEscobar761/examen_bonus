package filaB.webUi.respuestas;

import filaB.webUi.pages.LoginSection;
import filaB.webUi.pages.MainPage;
import filaB.webUi.pages.MenuSection;
import filaB.webUi.session.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RespuestaPreguntaCuatroTest {
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @Test
    public void loginTesting() throws InterruptedException {
        String password = "1234";
        String newPassword = "12345";
        String email = "samuelbejarano777@gmail.com";
        login(email, password);
        menuSection.settingsButton.click();
        Thread.sleep(2000);
        menuSection.oldPasswordTextBox.clearSetText(password);
        menuSection.newPasswordTextBox.clearSetText(newPassword);
        Thread.sleep(2000);
        menuSection.okButton.click();

        //Logout
        menuSection.logoutButton.click();

        //Login de verificacion
        login(email, newPassword);

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no me pude iniciar sesion");
    }

    private void login(String email, String password){
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText(email);
        loginSection.pwdTextBox.setText(password);
        loginSection.loginButton.click();
    }
}

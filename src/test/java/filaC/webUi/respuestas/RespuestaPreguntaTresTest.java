package filaC.webUi.respuestas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import filaC.webUi.pages.*;
import filaC.webUi.session.Session;

public class RespuestaPreguntaTresTest {
    MainPageTodoist mainPage = new MainPageTodoist();
    LoginTodoistSection loginSection = new LoginTodoistSection();
    NavbarSectionTodoist navbarSectionTodoist = new NavbarSectionTodoist();
    SettingsSectionTodoist settingsSectionTodoist = new SettingsSectionTodoist();
    String email = "samueb8@gmail.com";
    String password = "SamuelCambio/1234";

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("https://todoist.com/es");
    }

    @Test
    public void respuestaPreguntaTres() throws InterruptedException {
        String newName = "Samuel Escobar Pregunta3FilaCPruebaFinal";
        //Login
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText(email);
        loginSection.pwdTextBox.setText(password);
        loginSection.startEmailLoginButton.click();
        Thread.sleep(7000);

        //Cambiar el nombre de usuario
        navbarSectionTodoist.profileButton.click();
        navbarSectionTodoist.settingsButton.click();
        settingsSectionTodoist.nameTextBox.clearSetText(newName);
        settingsSectionTodoist.submitButton.click();
        Thread.sleep(2000);
        settingsSectionTodoist.closeSettingsSectionButton.click();

        //Verificacion
        navbarSectionTodoist.profileButton.click();
        navbarSectionTodoist.settingsButton.click();
        Assertions.assertTrue(settingsSectionTodoist.getName(newName).isControlDisplayed(),
                "No se pudo cambiar el nombre");
    }
}

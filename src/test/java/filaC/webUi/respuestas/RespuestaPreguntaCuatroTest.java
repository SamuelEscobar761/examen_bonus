package filaC.webUi.respuestas;

import filaC.webUi.pages.*;
import filaC.webUi.session.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RespuestaPreguntaCuatroTest {
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    RegisterSection registerSection =  new RegisterSection();
    SettingsSection settingsSection = new SettingsSection();


    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @Test
    public void preguntaCuatro() throws InterruptedException {
        //Registrar
        String fullName = "Samuel Escobar Bejarano";
        String email = "samueb8@gmail.com";
        String password = "1234";
        mainPage.registerButton.click();
        registerSection.fullNameTextBox.clearSetText(fullName);
        registerSection.emailTextBox.setText(email);
        registerSection.passwordTextBox.setText(password);
        registerSection.termsButton.click();
        registerSection.signupButton.click();

        //Eliminar
        menuSection.settingsButton.click();
        settingsSection.accountButton.click();
        settingsSection.deleteButton.click();
        Session.getInstance().getAlert().accept();
        Thread.sleep(2000);
        Assertions.assertTrue(mainPage.registerButton.isControlDisplayed(),
                "ERROR no se pudo borrar la cuenta creada");

    }
}

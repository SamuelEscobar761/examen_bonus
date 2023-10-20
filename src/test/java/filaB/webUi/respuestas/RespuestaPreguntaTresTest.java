package filaB.webUi.respuestas;

import filaB.webUi.pages.*;
import filaB.webUi.session.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RespuestaPreguntaTresTest {
    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("https://todoist.com");
    }
    MainPageTodoist mainPage = new MainPageTodoist();
    SignUpSectionTodoist signUpSection = new SignUpSectionTodoist();
    MenuSectionTodoist menuSection = new MenuSectionTodoist();
    AddProjectPageTodoist addProjectPage = new AddProjectPageTodoist();
    ProjectsSectionTodoist projectsSection = new ProjectsSectionTodoist();
    String newEmail;
    String newPassword;
    @Test
    public void preguntaTres() throws InterruptedException {
        newEmail = "samuelescobarbejarano@gmail.com";
        newPassword = "Samuel/1234";
        String projectName = "Proyecto1Pregunta3";
        //Crear un usuario
        mainPage.signUpButton.click();
        signUpSection.emailTextbox.clearSetText(newEmail);
        signUpSection.passwordTextbox.clearSetText(newPassword);
        signUpSection.registerButton.click();
        signUpSection.nameTextBox.clearSetText("Samuel Escobar");
        Thread.sleep(2000);
        signUpSection.continueButton.click();
        signUpSection.educationCheckbox.click();
        Thread.sleep(2000);
        signUpSection.openTodoistButton.click();
        Thread.sleep(2000);

//        //Crear un proyecto
        if(menuSection.hamburguerButton.isControlDisplayed()){
            menuSection.hamburguerButton.click();
        }
        menuSection.projectsButton.click();
        menuSection.addProjectButton.click();
        addProjectPage.nameTextbox.clearSetText(projectName);
        addProjectPage.addButton.click();

        //Verificacion
        Assertions.assertTrue(projectsSection.getProjectButton(projectName).isControlDisplayed(),
                "ERROR no se pudo crear el proyecto");

    }
}

package filaB.webUi.pages;

import filaB.webUi.controls.Button;
import filaB.webUi.controls.TextBox;
import org.openqa.selenium.By;

public class MenuSection {
    public Button logoutButton = new Button(By.xpath("//a[text()='Logout']"));
    public Button addNewProject = new Button(By.xpath("//td[text()='Add New Project']"));
    public TextBox newProjNameInput = new TextBox(By.id("NewProjNameInput"));
    public Button newProjNameButton = new Button(By.id("NewProjNameButton"));
    public TextBox newItemContentInput = new TextBox(By.id("NewItemContentInput"));
    public Button newItemAddButton = new Button(By.id("NewItemAddButton"));
    public TextBox editItemName = new TextBox(By.xpath("//div[@id='ItemEditDiv' and last()]//textarea[@id='ItemEditTextbox' and @itemid]"));
    public Button settingsButton = new Button(By.xpath("//a[text()=\"Settings\"]"));
    public TextBox fullNameInput = new TextBox(By.id("FullNameInput"));
    public Button okButton = new Button(By.xpath("//span[text()='Ok']"));
    public TextBox oldPasswordTextBox = new TextBox(By.id("TextPwOld"));
    public TextBox newPasswordTextBox= new TextBox(By.id("TextPwNew"));
    public Button getProject(String nameProject){
        return new Button(By.xpath("//li[last()]//td[text()='"+nameProject+"']"));
    }

    public Button getItem(String nameItem){
        return new Button(By.xpath("//td[last()]//div[text()='"+nameItem+"']"));
    }
}

package filaB.webUi.pages;

import filaB.webUi.controls.Button;
import org.openqa.selenium.By;

public class ProjectsSectionTodoist {
    public Button getProjectButton(String name){
        return new Button(By.xpath("//div[text()=\"" + name + "\"]"));
    }

}

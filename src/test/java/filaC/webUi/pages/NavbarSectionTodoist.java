package filaC.webUi.pages;

import filaC.webUi.controls.Button;
import org.openqa.selenium.By;


public class NavbarSectionTodoist {
    public Button profileButton = new Button(By.xpath("//img[@src=\"https://d1nbslm0j6pual.cloudfront.net?text=S&size=50\"]/.."));
    public Button settingsButton = new Button(By.id("user_menu_settings_menuitem"));
}

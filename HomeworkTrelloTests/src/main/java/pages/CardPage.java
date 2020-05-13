package pages;
import elements.Button;
import elements.Field;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class CardPage extends Page {
    public CardPage(WebDriver driver) {
        super(driver);
    }
    public Button labelButton = new Button(By.cssSelector("#chrome-container > div.window-overlay > div > div > div > div.window-sidebar > div:nth-child(2) > div > a.button-link.js-edit-labels"));
    public Button blueLabelButton = new Button(By.cssSelector("#chrome-container > div.pop-over.is-shown > div > div:nth-child(2) > div > div > div > div:nth-child(3) > ul > li:nth-child(6) > span"));
    public Button closeLabelsButton = new Button(By.cssSelector("#chrome-container > div.pop-over.is-shown > div > div.pop-over-header.js-pop-over-header > a"));
    public Button closeButton = new Button(By.cssSelector("#chrome-container > div.window-overlay > div > div > a"));
    public Button moveButton = new Button(By.cssSelector("#chrome-container > div.window-overlay > div > div > div > div.window-sidebar > div:nth-child(4) > div > a.button-link.js-move-card"));
    public Button positionButton = new Button(By.cssSelector("#chrome-container > div.pop-over.is-shown > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div:nth-child(2) > select"));
    public Button positionButton2 = new Button(By.cssSelector("#chrome-container > div.pop-over.is-shown > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div:nth-child(2) > select > option:nth-child(2)"));
    public Button moveToButton = new Button(By.cssSelector("#chrome-container > div.pop-over.is-shown > div > div:nth-child(2) > div > div > div > div > input"));
}

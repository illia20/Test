package pages;

import elements.Header;
import elements.Container;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import elements.Label;

public class BoardPage extends Page {
    public BoardPage(WebDriver driver) {
        super(driver);
    }
    public Container firstList = new Container(By.cssSelector("#board > div:nth-child(1) > div > div.list-header.js-list-header.u-clearfix.is-menu-shown > div.list-header-target.js-editing-target"));
    public Container secondList = new Container(By.cssSelector("#board > div:nth-child(2) > div > div.list-header.js-list-header.u-clearfix.is-menu-shown > div.list-header-target.js-editing-target"));
    public Header firstListHeader = new Header(By.cssSelector("#board > div:nth-child(1) > div > div.list-header.js-list-header.u-clearfix.is-menu-shown > h2"));
    public Header secondListHeader = new Header(By.cssSelector("#board > div:nth-child(2) > div > div.list-header.js-list-header.u-clearfix.is-menu-shown > h2"));
    public Button firstCard = new Button(By.cssSelector("#board > div:nth-child(1) > div > div.list-cards.u-fancy-scrollbar.u-clearfix.js-list-cards.js-sortable.ui-sortable > a:nth-child(1) > div.list-card-details.js-card-details"));
    public Button secondCard = new Button(By.cssSelector("#board > div:nth-child(1) > div > div.list-cards.u-fancy-scrollbar.u-clearfix.js-list-cards.js-sortable.ui-sortable > a:nth-child(2) > div.list-card-details.js-card-details > span"));
    public Button newCard = new Button(By.cssSelector("#board > div:nth-child(1) > div > div.card-composer-container.js-card-composer-container > a"));
    public Button newCardSecondList = new Button(By.xpath("//*[@id=\"board\"]/div[2]/div/div[3]/div"));
    public Button secondCardSecondList = new Button(By.xpath("//*[@id=\"board\"]/div[2]/div/div[2]/a[2]"));
    public Label cardLabel = new Label(By.xpath("//*[@id=\"board\"]/div[1]/div/div[2]/a/div[3]/div[1]/span"));
}

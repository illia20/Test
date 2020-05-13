import API.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import conf.TestManager;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TrelloTest extends TestManager{

    @Test(priority = 1)
    public void checkCreateLabel() throws IOException {
        String name = "Checking";
        String color = "blue";
        Label newLabel = retrofitBuilder.getTrelloApi().createLabel(label, boardId, name, color).execute().body();
        Assert.assertEquals(newLabel.getName(), name);
    }
    @Test(priority = 2)
    public void checkMoveList() throws IOException {
        int status = retrofitBuilder.getTrelloApi().moveList(list, listIdTwo, boardIdTwo).execute().code();
        Assert.assertEquals(status, 200);
    }
    // Testing moving card inside list and to other list: 2 different tests
    @Test(priority = 3)
    public void checkMoveCardInList() throws IOException {
        int response = retrofitBuilder.getTrelloApi().moveCardInList(card, cardId, 3).execute().code();
        Assert.assertEquals(response, 200);
    }
    @Test(priority = 4)
    public void checkMoveCardToList() throws IOException {
        int response = retrofitBuilder.getTrelloApi().moveCardToList(card, cardId, listIdTM).execute().code();
        Assert.assertEquals(response, 200);
    }
    @Test(priority = 5)
    public void checkCreateLabelUI(){

            BoardsPage boardsPage = new BoardsPage(driver);
            boardsPage.boardButton.click();
            BoardPage boardPage = new BoardPage(driver);
            try {
                boardPage.firstCard.click();
            }
            catch (Exception e){
                boardPage.firstCard.click();
            }
            CardPage cardPage = new CardPage(driver);
            cardPage.labelButton.click();
            cardPage.blueLabelButton.click();
            cardPage.closeLabelsButton.click();
            cardPage.closeButton.click();
            Assert.assertTrue(boardPage.cardLabel.compose().isEnabled());
    }
    @Test(priority = 6)
    public void checkMoveListUI() throws InterruptedException {
        BoardPage boardPage = new BoardPage(driver);
        Actions action = new Actions(driver);
        String title = boardPage.firstListHeader.compose().getText();
        WebElement from = boardPage.firstList.compose();
        WebElement to = boardPage.secondList.compose();
        String listText = from.getText();
        action.dragAndDrop(from, to).build().perform();
        String newTitle = boardPage.secondListHeader.compose().getText();
        Assert.assertEquals(newTitle, title);
    }
    @Test(priority = 7)
    public void checkMoveCardInListUI(){
        BoardPage boardPage = new BoardPage(driver);
        String cardText = boardPage.firstCard.compose().getText();
        boardPage.firstCard.click();
        CardPage cardPage = new CardPage(driver);
        cardPage.moveButton.click();
        cardPage.positionButton.click();
        cardPage.positionButton2.click();
        cardPage.moveToButton.click();
        cardPage.closeButton.click();
        WebElement secondCard = boardPage.secondCard.compose();
        Assert.assertEquals(secondCard.getText(), cardText);
    }
    @Test(priority = 8)
    public void checkMoveCardToListUI(){
        BoardPage boardPage = new BoardPage(driver);
        Actions action = new Actions(driver);
        WebElement from = boardPage.firstCard.compose();
        String cardText = from.getText();
        WebElement to = boardPage.newCardSecondList.compose();
        action.dragAndDrop(from, to).build().perform();
        Assert.assertEquals(boardPage.secondCardSecondList.compose().getText(), cardText);
    }
}

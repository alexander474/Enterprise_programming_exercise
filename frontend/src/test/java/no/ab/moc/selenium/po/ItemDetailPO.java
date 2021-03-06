package no.ab.moc.selenium.po;

import no.ab.moc.selenium.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ItemDetailPO extends LayoutPO{

    public ItemDetailPO(WebDriver driver, String host, int port) {
        super(driver, host, port);
    }

    public ItemDetailPO(PageObject other) {
        super(other);
    }

    @Override
    public boolean isOnPage() {
        return getDriver().getTitle().contains("Details");
    }

    public void createRating(String comment, String score){
        setText("addComment", comment);
        setText("addScore", score);
        clickAndWait("createBtnId");
    }

    public void updateRating(String comment, String score){
        setText("addComment", comment);
        setText("addScore", score);
        clickAndWait("updateBtnId");
    }


    public boolean textExistsOnPage(String text){
        // Source https://stackoverflow.com/questions/11454798/how-can-i-check-if-some-text-exist-or-not-in-the-page-using-selenium
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        return list.size() > 0;
    }
}

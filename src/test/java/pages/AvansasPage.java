package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AvansasPage {
    public AvansasPage() {
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//input[@type='search'][2]")
    public WebElement aramaKutusu;

    @FindBy(xpath="//img[@data-src='https://cdn2.avansas.com/icerik/kategori/5.jpg']")
    public WebElement kursunKalem;

    @FindBy(id="select2-sort-container")
    public WebElement sıralamaButonu;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement sıralamaText;

    @FindBy(xpath = "//div[@class='list-container area active']")
    public WebElement urunListesi;
}

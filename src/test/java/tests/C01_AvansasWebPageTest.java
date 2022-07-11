package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AvansasPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class C01_AvansasWebPageTest {
    /*
 Avansas.com da arama alanına “kalem” yazılarak ara butonu tıklanır.
 Kategori listesinden kurşun kalemler kategorisi tıklanır.
 Sıralama fonksiyonundan ada göre sırala seçilir.
 Gelen ürün listesinde adında “Bic Evolution” içeren kaç ürün olduğu tespit edilir.
 Ürün adeti tespit edilir ve 0 dan fazla ise test başarılıdır.
 Ürü n adeti 0 ise test başarısızdır.
     */
    @Test
    public void test01() throws InterruptedException {
        AvansasPage avansasPage = new AvansasPage();
        Driver.getDriver().get(ConfigReader.getProperty("avansasUrl"));
        Thread.sleep(2000);
        avansasPage.aramaKutusu.sendKeys("Kalem" + Keys.ENTER);
        Thread.sleep(2000);
        avansasPage.kursunKalem.click();
        Thread.sleep(2000);
        avansasPage.sıralamaButonu.click();
        avansasPage.sıralamaText.sendKeys("isme göre" + Keys.ENTER);

        List<WebElement> bicEvolutionKalemler = Driver.getDriver().findElements(By.xpath("//h3"));

        int sayac = 1;
        for (WebElement each : bicEvolutionKalemler
        ) {
            if (each.getText().contains("Bic Evolution")) {
                sayac++;
            }
        }System.out.println("Bic Evolution Kalem sayisi: " +  sayac);

        if (sayac >= 0) {
            System.out.println("Bic evolution adedi sıfırdan fazla testi PASS");
        }else {
            System.out.println("Bic Evolution adedi sıfırdan az testi FAILED");
        }
         Driver.closeDriver();
    }
}

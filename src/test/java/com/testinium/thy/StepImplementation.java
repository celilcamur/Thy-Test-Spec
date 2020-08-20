package com.testinium.thy;

import helper.RandomString;
import helper.StoreHelper;
import com.thoughtworks.gauge.Step;
import model.SelectorInfo;
import selector.Selector;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class StepImplementation extends HookImpl {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<MobileElement> findElements(By by) throws Exception {
        List<MobileElement> webElementList = null;
        try {
            webElementList = appiumFluentWait.until(new ExpectedCondition<List<MobileElement>>() {
                @Nullable
                @Override
                public List<MobileElement> apply(@Nullable WebDriver driver) {
                    List<MobileElement> elements = driver.findElements(by);
                    return elements.size() > 0 ? elements : null;
                }
            });
            if (webElementList == null) {
                throw new NullPointerException(String.format("by = %s Web element list not found", by.toString()));
            }
        } catch (Exception e) {
            throw e;
        }
        return webElementList;
    }

    public MobileElement findElement(By by) throws Exception {
        MobileElement mobileElement;
        try {
            mobileElement = findElements(by).get(0);
        } catch (Exception e) {
            throw e;
        }
        return mobileElement;
    }

    @Step({"<seconds> saniye bekle"})
    public void waitBySecond(int second) {
        try {
            Thread.sleep(second * 1000);
            logger.info(second + "saniye bekliyor.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Step("<key> Cerezleri kabul et.")
    public void acceptCookie(String key) {
        appiumDriver.findElement(By.id(key)).click();
    }

    @Step("<key> Bilet al a tikla.")
    public void getTicket(String key) {
        appiumDriver.findElement(By.id(key)).click();
    }

    @Step("<key> Tek Yon Ucusa tikla.")
    public void oneWay(String key) {
        appiumDriver.findElement(By.id(key)).click();
    }

    @Step("<key> Ucagin nereden kalkacagini sec.")
    public void selectDeparture(String key) {
        appiumDriver.findElement(By.id(key)).click();
    }

    @Step("<key> Kalkis havalimanini ara.")
    public void departureCode(String key) {
        appiumDriver.findElement(By.id(key)).sendKeys("SAW");
    }

    @Step("<key> Havalimanini sec.")
    public void selectDepartureAirport(String key) {
        appiumDriver.findElement(By.id(key)).click();
    }

    @Step("<key> Nereye gidecegini sec.")
    public void toAirport(String key) {
        appiumDriver.findElement(By.id(key)).click();
    }

    @Step("<key> Gidecegin havalimanini ara.")
    public void toAirportCode(String key) throws Exception {
        appiumDriver.findElement(By.id(key)).sendKeys("ESB");
    }

    @Step("<key> Varis Havalimani sec.")
    public void toAirportSelect(String key) throws Exception {
        appiumDriver.findElement(By.id(key)).click();
    }
    @Step("<key> tarih alanina tikla.")
    public void SelectDateView(String key) {
        appiumDriver.findElement(By.id(key)).click();
    }

    @Step({"2 gun sonrayi sec."})
    public void selectDate() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd");
        int twoDaysLater = Integer.valueOf(df.format(now)) + 2;

        try {
            appiumDriver.findElement(By.xpath("//*[@text='" + twoDaysLater + "']")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("<key> Tamam butonuna tikla.")
    public void btnOK(String key) {
        appiumDriver.findElement(By.id(key)).click();
    }

    @Step("<key> Yetiskin degerini bir arttir.")
    public void increaseAdult(String key) {
        appiumDriver.findElement(By.xpath(key)).click();
    }

    @Step("<key> Ucus Ara butonuna tikla.")
    public void searchFlight(String key) {
        appiumDriver.findElement(By.id(key)).click();
    }

    @Step("<key> Ucus Zamanini sec.")
    public void selectFlight(String key) {
        appiumDriver.findElement(By.xpath(key)).click();
    }

    @Step("<key> Ekonomik ucus sec.")
    public void ecoFlight(String key) {
        appiumDriver.findElement(By.xpath(key)).click();
    }

    @Step("<key> Devam butonuna tikla.")
    public void btnContinue(String key) {
        appiumDriver.findElement(By.id(key)).click();
    }

    @Step("<key> Yolcu ekle.")
    public void addPassenger(String key) {
        appiumDriver.findElement(By.id(key)).click();
    }

    @Step("<key> Ad bilgisi <text> dir.")
    public void inputName(String key, String text) {
        appiumDriver.findElement(By.id(key)).sendKeys(text);
    }

    @Step("<key> Soyad bilgisi <text> dir..")
    public void inputSurname(String key, String text) { appiumDriver.findElement(By.id(key)).sendKeys(text); }

    @Step("<key> Cinsiyet gir.")
    public void selectGender(String key) {
        appiumDriver.findElement(By.xpath(key)).click();
    }

    @Step("<key> Dogum tarihi bilgisi <text> dir.")
    public void birthDate(String key, String text) {
        appiumDriver.findElement(By.id(key)).sendKeys(text);
    }

    @Step("<key> Email bilgisi <text> dir.")
    public void emailAdress(String key, String text) {
        appiumDriver.findElement(By.id(key)).sendKeys(text);
    }

    @Step("<key> T.C. sec.")
    public void TC(String key) {
        appiumDriver.findElement(By.xpath(key)).click();
    }

    @Step("<key> T.C. bilgisi <text> dir.")
    public void TCNo(String key, String text) {
        appiumDriver.findElement(By.id(key)).sendKeys(text);
    }

    @Step("<key> Kaydet butonuna tikla.")
    public void btnSave(String key) {
        appiumDriver.findElement(By.id(key)).click();
    }

    @Step("<key> 2. Yolcuyu Sec.")
    public void adult2(String key) {
        appiumDriver.findElement(By.xpath(key)).click();
    }

    @Step("<key> 2. Yolcuyu ekle.")
    public void addPassenger2(String key) {
        appiumDriver.findElement(By.xpath(key)).click();
    }

    @Step("<key> Yolcu sayfasinda Devam butonuna tikla.")
    public void btnPassengerContinue(String key) {
        appiumDriver.findElement(By.id(key)).click();
    }

    @Step("<key> Hes sayfasinda Iptal butonuna tikla.")
    public void btnCancel(String key)
    {
        appiumDriver.findElement(By.id(key)).click();
    }
    @Step("<key> Iptal ekraninda Devam butonuna tikla.")
    public void btnCancelContinue(String id)
    {
        appiumDriver.findElement(By.id(id)).click();
    }


}








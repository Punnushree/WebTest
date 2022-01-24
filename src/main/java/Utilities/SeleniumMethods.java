package Utilities;

import Base.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumMethods extends Baseclass {

    //generic methods to operate on the objects
    public static void SendData(WebElement txt, String data){
            txt.sendKeys(data);
    }

    public static void ClickButton(WebElement btn){
        btn.click();
    }

    public static void ClickLink(WebElement lnk){
        lnk.click();
    }
    public static String getElementText(WebElement webElmtxt){
        String elmtxt = webElmtxt.getText();
        return elmtxt;
    }

    public void SelectByName(WebElement drpdwn, String data){
        Select s = new Select(drpdwn);
        s.selectByVisibleText(data);
    }
}

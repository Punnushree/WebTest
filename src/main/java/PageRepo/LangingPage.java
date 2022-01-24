package PageRepo;

import Base.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LangingPage extends Baseclass {

    public LangingPage(){
        PageFactory.initElements(driver,this);
    }

    //Variables for objects in landing page
    @FindBy(xpath = "//img[@class='img-responsive']")
    private WebElement imgLanding;

    public WebElement getImgLanding() {
        return imgLanding;
    }

    public void setImgLanding(WebElement imgLanding) {
        this.imgLanding = imgLanding;
    }
}

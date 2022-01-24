package PageRepo;

import Base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OwnersList extends Baseclass {

    public OwnersList(){

        PageFactory.initElements(driver,this);
    }

    //Variables for objects in owners list page
    @FindBy(xpath = "//a[@title='find owners']")
    private WebElement lnkFindOwner;

    @FindBy(xpath = "//*[@id='search-owner-form']/div[2]/div/button")
    private WebElement btnFindOwner;

    public WebElement getLnkFindOwner() {

        return lnkFindOwner;
    }

    public void setLnkFindOwner(WebElement lnkFindOwner) {
        this.lnkFindOwner = lnkFindOwner;
    }

    public WebElement getBtnFindOwner() {
        return btnFindOwner;
    }

    public void setBtnFindOwner(WebElement btnFindOwner) {
        this.btnFindOwner = btnFindOwner;
    }

}

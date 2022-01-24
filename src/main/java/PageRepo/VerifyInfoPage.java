package PageRepo;

import Base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VerifyInfoPage extends Baseclass {

    public VerifyInfoPage(){
        PageFactory.initElements(driver,this);
    }

    //Variables for objects in information page
    @FindBy(xpath = "//a[@title='find owners")
    private WebElement lnkHomeFindOwner;

    @FindBy(xpath = "//*[@id='search-owner-form']/div[2]/div/button")
    private WebElement btnFindOwner;

    @FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td")
    private WebElement tblAddedOwnerDtls;

    @FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td/dl/dd\"")
    private WebElement tblAddedPetDtls;


    public WebElement getLnkHomeFindOwner() {
        return lnkHomeFindOwner;
    }

    public void setLnkHomeFindOwner(WebElement lnkHomeFindOwner) {
        this.lnkHomeFindOwner = lnkHomeFindOwner;
    }

    public WebElement getBtnFindOwner() {
        return btnFindOwner;
    }

    public void setBtnFindOwner(WebElement btnFindOwner) {
        this.btnFindOwner = btnFindOwner;
    }

    public WebElement getTblAddedOwnerDtls() {
        return tblAddedOwnerDtls;
    }

    public void setTblAddedOwnerDtls(WebElement tblAddedOwnerDtls) {
        this.tblAddedOwnerDtls = tblAddedOwnerDtls;
    }

    public WebElement getTblAddedPetDtls() {
        return tblAddedPetDtls;
    }

    public void setTblAddedPetDtls(WebElement tblAddedPetDtls) {
        this.tblAddedPetDtls = tblAddedPetDtls;
    }
    }

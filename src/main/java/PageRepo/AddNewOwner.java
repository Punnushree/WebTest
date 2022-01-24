package PageRepo;

import Base.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Inheriting the methods of base class
public class AddNewOwner extends Baseclass {

    public AddNewOwner(){
        PageFactory.initElements(driver,this);
    }

    //Variables for objects in Add new owner page
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private  WebElement btnToAddOwner;

    @FindBy(xpath = "//span[normalize-space()='Find owners']")
    private WebElement lnkFindOwner;

    @FindBy(id = "firstName")
    private WebElement txtFname;

    @FindBy(name = "lastName")
    private WebElement txtLname;

    @FindBy(id = "address")
    private WebElement txAddress;

    @FindBy(id = "city")
    private WebElement txtcity;

    @FindBy(id = "telephone")
    private WebElement txtPhone;

    @FindBy(css = "button[type='submit']")
    private WebElement btnAddOwner;


    public WebElement getLnkFindOwner() {
        return lnkFindOwner;
    }

    public void setLnkFindOwner(WebElement lnkFindOwner) {
        this.lnkFindOwner = lnkFindOwner;
    }

    public WebElement getBtnToAddOwner() {
        return btnToAddOwner;
    }

    public void setBtnToAddOwner(WebElement btnToAddOwner) {
        this.btnToAddOwner = btnToAddOwner;
    }

    public WebElement getTxtFname() {
        return txtFname;
    }

    public void setTxtFname(WebElement txtFname) {
        this.txtFname = txtFname;
    }

    public WebElement getTxtLname() {
        return txtLname;
    }

    public void setTxtLname(WebElement txtLname) {
        this.txtLname = txtLname;
    }

    public WebElement getTxAddress() {
        return txAddress;
    }

    public void setTxAddress(WebElement txAddress) {
        this.txAddress = txAddress;
    }

    public WebElement getTxtcity() {
        return txtcity;
    }

    public void setTxtcity(WebElement txtcity) {
        this.txtcity = txtcity;
    }

    public WebElement getTxtPhone() {
        return txtPhone;
    }

    public void setTxtPhone(WebElement txtPhone) {
        this.txtPhone = txtPhone;
    }

    public WebElement getBtnAddOwner() {
        return btnAddOwner;
    }

    public void setBtnAddOwner(WebElement btnAddOwner) {
        this.btnAddOwner = btnAddOwner;
    }

}

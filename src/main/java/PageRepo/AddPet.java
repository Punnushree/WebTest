package PageRepo;

import Base.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPet extends Baseclass {

    public AddPet(){
        PageFactory.initElements(driver,this);
    }

    //Variables for objects in Add pet page
    @FindBy(xpath = "//a[contains(text(),'Add')]")
    private WebElement btnAddPet;

    @FindBy(id = "name")
    private WebElement txtPetName;

    @FindBy(id = "birthDate")
    private WebElement clndrDOB;

    @FindBy(id = "type")
    private WebElement drpdwnType;

    public WebElement getBtnPetSubmit() {
        return btnPetSubmit;
    }

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnPetSubmit;


    public WebElement getBtnAddPet() {
        return btnAddPet;
    }

    public void setBtnAddPet(WebElement btnAddPet) {
        this.btnAddPet = btnAddPet;
    }

    public WebElement getTxtPetName() {
        return txtPetName;
    }

    public void setTxtPetName(WebElement txtPetName) {
        this.txtPetName = txtPetName;
    }

    public WebElement getClndrDOB() {
        return clndrDOB;
    }

    public void setClndrDOB(WebElement clndrDOB) {
        this.clndrDOB = clndrDOB;
    }

    public WebElement getDrpdwnType() {
        return drpdwnType;
    }

    public void setDrpdwnType(WebElement drpdwnType) {
        this.drpdwnType = drpdwnType;
    }

    public void setBtnPetSubmit(WebElement btnPetSubmit) {
        this.btnPetSubmit = btnPetSubmit;
    }

}

package PageRepo;

import Base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VetsList extends Baseclass {

    public VetsList(){
        PageFactory.initElements(driver,this);
    }

    //Variables for objects in Vets details page
    @FindBy(xpath = "//a[@title='veterinarians']")
    private WebElement lnkVet;

    public WebElement getLnkVet() {
        return lnkVet;
    }

    public void setLnkVet(WebElement lnkVet) {
        this.lnkVet = lnkVet;
    }

    //driver.findElement(By.xpath("//*[@id='main-navbar']/ul/li[3]/a/span[2]")).click();
}

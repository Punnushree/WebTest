package Testcases;

import Base.Baseclass;
import ExtentReporting.Report;
import PageRepo.*;
import Utilities.SeleniumMethods;
import Utilities.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PetClinicFlow extends Baseclass {

    //Global class initiation
    public SeleniumMethods sm = new SeleniumMethods();
    public TestData td =  new TestData();
    public Report testReport = new Report();

    // Testcase to Validate the image on landing page
    @Test(priority = 1)
    public void validateIMG() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        LangingPage lp = new LangingPage();

        Boolean img = lp.getImgLanding().isDisplayed();
        System.out.println(img);
        Assert.assertTrue(img);
    }

    //Testcase to add a new owner
    @Test(priority = 2)
    public void addOwner() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        AddNewOwner ao = new AddNewOwner();

        sm.ClickButton(ao.getLnkFindOwner());
        sm.ClickButton(ao.getBtnToAddOwner());

        //Enter owner data and submit
        sm.SendData(ao.getTxtFname(),td.ownerFName);
        sm.SendData(ao.getTxtLname(), td.ownerLName);
        sm.SendData(ao.getTxAddress(),td.ownerAddress);
        sm.SendData(ao.getTxtcity(),td.ownerCity);
        sm.SendData(ao.getTxtPhone(),td.ownerPhone);
        sm.ClickButton(ao.getBtnAddOwner());
    }

    //Testcase to add pat to the owner
    @Test(priority = 3)
    public void addPet() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        AddPet ap = new AddPet();

        //Enter pet details and submit
        sm.ClickButton(ap.getBtnAddPet());
        sm.SendData(ap.getTxtPetName(),td.petName);
        sm.SendData(ap.getClndrDOB(),td.petDOB);
        sm.SelectByName(ap.getDrpdwnType(),td.petType);
        sm.ClickButton(ap.getBtnPetSubmit());
    }

    //Validate the data displayed matches with input data
    @Test(priority = 4)
    public void VerifyInfoPage() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        VerifyInfoPage vip = new VerifyInfoPage();

        //Retrieve the table data by looping and validate with input data
        List<WebElement> addedOAttri = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td"));
        // List<WebElement>addedOAttri = driver.vip.getTblAddedOwnerDtls();

        //Validate owner info
        int j = 0;
        String OwnerFullName = td.ownerFName + td.ownerLName;
        if ((addedOAttri.get(j).getText()).equals(OwnerFullName) &&
                addedOAttri.get(j + 1).getText().equals(td.ownerAddress) &&
                addedOAttri.get(j + 2).getText().equals(td.ownerCity) &&
                addedOAttri.get(j + 3).getText().equals(td.ownerPhone)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        //converting the date format to match the formats in inputdata page and validation page
        String dtDOB = td.petDOB; //dtDOB="12/24/2011"
        DateFormat inputDate = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat dateFormatNeeded = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        String reqDOB = null;
        try {
            date = inputDate.parse(dtDOB);
            System.out.println(dateFormatNeeded.format(date));
            reqDOB = dateFormatNeeded.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Validate Pet info
        int i = 0;
        List<WebElement> addedPAttri = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td/dl/dd"));
        if (addedPAttri.get(i).getText().equals(td.petName) &&
                addedPAttri.get(i + 1).getText().equals(reqDOB) &&
                addedPAttri.get(i + 2).getText().equals(td.petType)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    //Testcase to view owners list
    @Test(priority = 5)
    public void VerifyOwnersList() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        OwnersList ol = new OwnersList();

        sm.ClickLink(ol.getLnkFindOwner());
        sm.ClickButton(ol.getBtnFindOwner());

        // while
        List<WebElement> ownerAttri = driver.findElements(By.xpath("//table[@id='owners']/tbody/tr/td"));
        for (int i = 0; i < ownerAttri.size(); i++) {
            if (i % 5 == 0) {
                String AttriVal = ownerAttri.get(i).getText();
                System.out.println("list of owners "+AttriVal);
            }
        }
    }

    //Testcase to view Vets list
    @Test(priority = 6)
    public void VerifyVetsList(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        VetsList vl = new VetsList();

        sm.ClickLink(vl.getLnkVet());
        List<WebElement>vetsAttri = driver.findElements(By.xpath("//table[@id='vets']/tbody/tr/td"));
        for(int i=0;i< vetsAttri.size();i++){
            if(i%2==0){
                String vetVal = vetsAttri.get(i).getText();
                System.out.println("list of vets are " + vetVal);
            }
        }
    }
}

